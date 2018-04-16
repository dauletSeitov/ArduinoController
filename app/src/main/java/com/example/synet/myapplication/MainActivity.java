package com.example.synet.myapplication;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();

        final Bluetooth sd= new Bluetooth(this, handler);

        List<BluetoothDevice> names = null;
        try {
            names = sd.getAvaibleDevices();
        }
        catch (Exception e){
            Utils.toast(this, e);
        }

        ListView lvMain = (ListView) findViewById(R.id.list_view);

        if (names != null){
            ArrayAdapter adapter = new listAdapter(this, names);
            lvMain.setAdapter(adapter);
            lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //BluetoothDevice selected = (BluetoothDevice)adapterView.getSelectedItem();
                    try{
                        sd.init(i);
                    }
                    catch (Exception e){
                        Utils.toast(MainActivity.this, "i can't connect " + e);
                    }

                }
            });


            Button button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'o');
                }
            });

            Button clickButton0 = (Button) findViewById(R.id.button0);
            clickButton0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'0');
                }
            });

            Button clickButton1 = (Button) findViewById(R.id.button1);
            clickButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'1');
                }
            });

            Button clickButton2 = (Button) findViewById(R.id.button2);
            clickButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'2');
                }
            });

            Button clickButton3 = (Button) findViewById(R.id.button3);
            clickButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'3');
                }
            });

            Button button4 = (Button) findViewById(R.id.button4);
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'4');
                }
            });

            //-------------------------------

            Button button5 = (Button) findViewById(R.id.button5);
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'5');
                }
            });

            Button button6 = (Button) findViewById(R.id.button6);
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'6');
                }
            });

            Button button7 = (Button) findViewById(R.id.button7);
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'7');
                }
            });

            Button button8 = (Button) findViewById(R.id.button8);
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'8');
                }
            });

            Button button9 = (Button) findViewById(R.id.button9);
            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'9');
                }
            });

            Button button10 = (Button) findViewById(R.id.button10);
            button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'a');
                }
            });

            Button button11 = (Button) findViewById(R.id.button11);
            button11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'b');
                }
            });

            Button button12 = (Button) findViewById(R.id.button12);
            button12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'c');
                }
            });

            Button button13 = (Button) findViewById(R.id.button13);
            button13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'d');
                }
            });

            Button button14 = (Button) findViewById(R.id.button14);
            button14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'e');
                }
            });

            Button button15 = (Button) findViewById(R.id.button15);
            button15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'f');
                }
            });

            Button button16 = (Button) findViewById(R.id.button16);
            button16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'g');
                }
            });

            Button button17 = (Button) findViewById(R.id.button17);
            button17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'k');
                }
            });

            Button button18 = (Button) findViewById(R.id.button18);
            button18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'l');
                }
            });

            Button button19 = (Button) findViewById(R.id.button19);
            button19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sd.writeByte((byte)'m');
                }
            });

            RadioGroup rg = (RadioGroup)findViewById(R.id.GroupradioButton);
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch(i){
                        case R.id.radioButton:
                            sd.writeByte((byte)'n');
                            break;
                        case R.id.radioButton2:
                            sd.writeByte((byte)'p');
                            break;
                        case R.id.radioButton3:
                            sd.writeByte((byte)'r');
                            break;
                    }
                }
            });


        }




    }
}
