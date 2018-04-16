package com.example.synet.myapplication;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by synet on 27.11.2017.
 */

public class Utils {

    public static void toast(Context context, Object message){

        Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show();
    }

}
