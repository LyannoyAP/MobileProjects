package com.example.mobileprojects;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobileprojects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private boolean bOntinue_on = false;
    private int currenttasknumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(
                getLayoutInflater()
        );
        Intent intent = new Intent(this, TestActivity.class);
        setContentView(binding.getRoot());
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() > 0) {
                            if (!bOntinue_on) {
                                binding.bOntinue.setBackground(
                                        getResources().
                                                getDrawable
                                                        (R.drawable.normal_button));
                            bOntinue_on = true;
                            }
                        }
                        binding.bOntinue.setText(R.string.s_b_continue);
                        binding.bStart.setText(R.string.s_b_start);
                        binding.iStart.setImageResource(R.drawable.image_start);
                        currenttasknumber = result.getResultCode();
                    }
                });
        intent.putExtra("d_t_taskcount", binding.eQuestioncount.getText());
        binding.bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Starting test");
                binding.bStart.setText(R.string.s_b_startload);
                binding.iStart.setImageResource(R.drawable.image_wait);
                mStartForResult.launch(intent);
            }
        });
        binding.bOntinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bOntinue_on)
                    return;
                Log.i(TAG, "Completing test");
                binding.bOntinue.setText(R.string.s_b_startload);
                binding.iStart.setImageResource(R.drawable.image_wait);
                mStartForResult.launch(intent);
            }
        });
    }

    public void b_exitClick(View view) {
        Log.i(TAG, "Quiting the program");
        System.exit(0);
    }
}