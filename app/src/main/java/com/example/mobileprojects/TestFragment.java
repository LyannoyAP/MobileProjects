package com.example.mobileprojects;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TestFragment extends Fragment {

    private Button b_return;
    private TextView t_textscount;
    public TestFragment() {
        super(R.layout.test_layout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t_textscount = view.findViewById(R.id.t_taskscount);
        Bundle arguments = getArguments();
        t_textscount.setText(arguments.getString("qcount"));
        b_return = view.findViewById(R.id.b_return);
        b_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", t_textscount.getText().toString());
                getParentFragmentManager().setFragmentResult(
                        "requestKey", result);
                if (savedInstanceState == null) {
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_main, MainFragment.class, null)
                            .commit();
                }
            }
        });
    }
}