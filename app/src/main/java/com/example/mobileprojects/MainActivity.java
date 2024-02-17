package com.example.mobileprojects;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onCreate");
        Log.e(TAG, "Error message: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onStart");
        Log.e(TAG, "Error message: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onResume");
        Log.e(TAG, "Error message: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onPause");
        Log.e(TAG, "Error message: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onStop");
        Log.e(TAG, "Error message: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onRestart");
        Log.e(TAG, "Error message: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Context context = getApplicationContext();
        Toast.makeText(context, "Called method: onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Debug message: onDestroy");
        Log.e(TAG, "Error message: onDestroy");
    }

    public void b_exitClick(View view) {
        System.exit(0);
    }
}