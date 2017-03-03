package com.example.desarrollo7.myapplication.data;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by desarrollo7 on 1/03/17.
 */

public class Presenter {
    public void onSaveClick(View view){
        Log.d("LALA", "lala");
        Button button = (Button) view;
        button.setText("You pressme :D");
    }
}
