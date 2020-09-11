package com.example.sharedpreferencesexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText text;
//    private Button save;
    SharedPreferences sharedPreferences;
//    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        Log.d("log","createData");
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.inputText);
//        text.setText(random);
//        save = findViewById(R.id.button);
    }


    @Override
    protected void onResume()
    {
        super.onResume();
//        SharedPreferences sh= getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("text", "");
        text.setText(s1);
        Log.d("log","resume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
//        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();
        myEdit.putString("text",
                text.getText().toString());
        myEdit.commit();
        Log.d("log","stop");

    }

    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            Log.d("nilai", savedInstanceState.getString("nilai"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("nilai","kena");
        outState.putString("nilai","Hai");
    }

}