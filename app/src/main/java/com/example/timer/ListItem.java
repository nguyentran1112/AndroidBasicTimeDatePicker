package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ListItem extends AppCompatActivity {
    private TextView textWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        this.textWork = (TextView) this.findViewById(R.id.textView);
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("Key_1");
        Log.d("test",value1);
        textWork.setText(value1);
    }
}