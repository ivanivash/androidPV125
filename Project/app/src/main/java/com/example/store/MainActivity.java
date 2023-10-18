package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValue = findViewById(R.id.txtValue);
    }

    public void onClickMeHandler(View view){
        String text = txtValue.getText().toString();
        Log.d("my_text", "----Ви нажали кнопку----"+ text);
    }

    public void onClickBtn (View view){
        Button button = (Button) view;
        String buttonText = button.getText().toString();
    }
    
}