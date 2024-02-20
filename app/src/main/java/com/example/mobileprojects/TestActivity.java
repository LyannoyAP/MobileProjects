package com.example.mobileprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileprojects.databinding.ActivityMainBinding;

public class TestActivity extends AppCompatActivity {

    private Button b_return;
    private TextView t_textscount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_layout);
        Bundle arguments = getIntent().getExtras();
        t_textscount = findViewById(R.id.t_taskscount);
        t_textscount.setText(arguments.get("d_t_taskcount").toString());
        b_return = findViewById(R.id.b_return);
        b_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });

    }
}