package com.example.synet.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RunnableFuture;



public class Bluetooth  {

    private OutputStream outputStream;
    private InputStream inStream;
    private Context context;
    private List<BluetoothDevice> deviceList;// = new ArrayList<>();

    private Handler handler;



    public Bluetooth( Context context, Handler handler ) {

        this.context = context;
        this.handler = handler;
    }

    public List<BluetoothDevice> getAvaibleDevices() throws Exception {
        BluetoothAdapter blueAdapter = BluetoothAdapter.getDefaultAdapter();
        if (blueAdapter != null) {
            if (blueAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = blueAdapter.getBondedDevices();
                deviceList = new ArrayList<BluetoothDevice>(bondedDevices);
                return deviceList;
               // Utils.toast(context,"No appropriate paired devices.");
            }
            else {
                Utils.toast(context, "Bluetooth is disabled.");
            }
        }
        else {
            Utils.toast(context, "this device has no bluetooth.");
        }
        return null;
    }

    public void init(int chosenDevice) throws Exception {
        BluetoothDevice device;
        try {
            device =  deviceList.get(chosenDevice);
        }catch (Exception e){
            Utils.toast(context, "There no such device.");
            return;
        }

        ParcelUuid[] uuids = device.getUuids();
        BluetoothSocket socket = device.createRfcommSocketToServiceRecord(uuids[0].getUuid());
        socket.connect();
        outputStream = socket.getOutputStream();
        inStream = socket.getInputStream();

        Utils.toast(context, "i connected.");
    }

    public void writeString(String s)   {
        try {
            outputStream.write(s.getBytes());
        }
        catch (Exception e){
            Utils.toast(context, "write data error.");
        }

    }

    public void writeByte(byte b)   {
        try {
            //Utils.toast(context, ""+b);
            outputStream.write(b);
    }
        catch (Exception e){
            Utils.toast(context, "write data error.");
        }
    }

}
