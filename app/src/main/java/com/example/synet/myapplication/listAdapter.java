package com.example.synet.myapplication;


import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class listAdapter  extends ArrayAdapter<BluetoothDevice> {

    private final List<BluetoothDevice> list;


    public listAdapter(Context context, List<BluetoothDevice> list) {
        super(context, R.layout.bluetothissi, list);
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BluetoothDevice device = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.bluetothissi, null);
        }

        ((TextView) convertView.findViewById(R.id.label777)).setText(device.getName());

        return convertView;
    }

}
