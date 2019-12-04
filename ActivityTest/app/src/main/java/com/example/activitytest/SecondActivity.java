package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {     //显示intent
                                           Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                                           startActivity(intent);
                                       }
                                   }

        );

        //接收上个活动发来的数据
        Intent intent = getIntent();
        String data = intent.getStringExtra("My_Data");
        Log.d("SecondActivity",data);
    }
}
