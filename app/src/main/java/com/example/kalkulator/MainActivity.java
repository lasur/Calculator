package com.example.kalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moveToSimpleCalc(View view) {
        Intent intent = new Intent(this, SimpleMode.class);
        startActivity(intent);
    }

    public void moveToAdvanceCalc(View view) {
        Intent intent = new Intent(this, AdvanceMode.class);
        startActivity(intent);
    }

    public void moveToAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void moveToExit(View view) {
        finishAndRemoveTask();
    }
}

