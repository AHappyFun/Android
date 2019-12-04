package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent();
                                           intent.putExtra("Return_Data", "从Third返回的Data");
                                           setResult(RESULT_OK, intent);
                                           finish();
                                       }
                                   }

        );
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("Return_Data", "点返回时候 从Third返回的Data");
        setResult(RESULT_OK, intent);
        finish();
    }
}
