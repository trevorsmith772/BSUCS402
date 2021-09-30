package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SecondaryActivity.class);
        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                //Do what you want with click here
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Close this alert for a message");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                String message = "message";
                                intent.putExtra(EXTRA_MESSAGE, message);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();
            }
        });
    }
}