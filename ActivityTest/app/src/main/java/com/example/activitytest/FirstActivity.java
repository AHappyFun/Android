package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Toast.makeText(FirstActivity.this, "lalla", Toast.LENGTH_LONG).show();
                                       }
                                   }

        );

        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {      //隐式intent

                                           //打开SecondActivity
                                           Intent intent = new Intent("com.example.activitytest.HaHa");
                                           intent.addCategory("com.example.activitytest.My_Category");
                                           startActivity(intent);
                                       }
                                   }

        );

        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {      //隐式intent

                                           Intent intent = new Intent(Intent.ACTION_VIEW);
                                           intent.setData(Uri.parse("http://www.google.com"));
                                           startActivity(intent);
                                       }
                                   }

        );

        Button button4 = (Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {      //隐式intent

                                           //传递数据给 下个活动
                                           Intent intent = new Intent("com.example.activitytest.HaHa");
                                           intent.putExtra("My_Data", "哈哈哈 啦啦啦");
                                           startActivity(intent);
                                       }
                                   }

        );


        Button button5 = (Button)findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

                                           Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
                                           startActivityForResult(intent, 1); //
                                       }
                                   }

        );

    }

    //返回本活动的时候，带有数据的时候，执行这个回调
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("Return_Data");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }
}
