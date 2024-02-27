package com.example.mobileprojects;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainFragment extends Fragment {

    private Button b_start, b_continue, b_exit;
    private EditText e_questioncount;
    private ImageView i_start;
    private String questioncount;
    private boolean b_continueOn = false;
    public MainFragment() {
        super(R.layout.start_layout);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = getContext();
        Toast.makeText(context, "Fragment: onCreate", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreate called, States: fragment: CREATED; View: NONE");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = getContext();
        Toast.makeText(context, "Fragment: onCreateView", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreateView called, States: fragment: CREATED; View: INITIALIZED");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        Toast.makeText(context, "Fragment: onViewCreated", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onViewCreated called, States: fragment: CREATED; View: INITIALIZED");
        b_start = view.findViewById(R.id.b_start);
        i_start = view.findViewById(R.id.i_start);
        b_continue = view.findViewById(R.id.b_continue);
        b_exit = view.findViewById(R.id.b_exit);
        e_questioncount = view.findViewById(R.id.e_questioncount);
        getParentFragmentManager().setFragmentResultListener("requestKey",
                this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey,
                                                 @NonNull Bundle bundle) {
                        String result = bundle.getString("bundleKey");
                        if (!b_continueOn) {
                            b_continueOn = true;
                            b_continue.setBackground(getResources().
                                    getDrawable
                                            (R.drawable.normal_button));
                        }
                        questioncount = result;
                        e_questioncount.setText(questioncount);
                    }
                }
        );
        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Starting test");
                b_start.setText(R.string.s_b_startload);
                i_start.setImageResource(R.drawable.image_wait);
                questioncount = e_questioncount.getText().toString();
                if (savedInstanceState == null) {
                    Bundle args = new Bundle();
                    args.putString("qcount", questioncount);
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_main, TestFragment.class, args)
                            .commit();
                }
            }
        });
        b_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!b_continueOn)
                    return;
                Log.i(TAG, "Completing test");
                b_continue.setText(R.string.s_b_startload);
                i_start.setImageResource(R.drawable.image_wait);
                if (savedInstanceState == null) {
                    Bundle args = new Bundle();
                    args.putString("qcount", questioncount);
                    getParentFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_main, TestFragment.class, args)
                            .commit();
                }
            }
        });
        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Quiting the program");
                System.exit(0);
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Context context = getContext();
        Toast.makeText(context, "Fragment: onViewStateRestored", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onViewStateRestored called, States: fragment: CREATED; View: CREATED");
    }

    @Override
    public void onStart() {
        super.onStart();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onStart", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onStart called, States: fragment: STARTED; View: STARTED");
    }

    @Override
    public void onResume() {
        super.onResume();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onResume", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onResume called, States: fragment: RESUMED; View: RESUMED");
    }

    @Override
    public void onPause() {
        super.onPause();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onPause", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onPause called, States: fragment: STARTED; View: STARTED");
    }

    @Override
    public void onStop() {
        super.onStop();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onStop", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onStop called, States: fragment: CREATED; View: CREATED");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Context context = getContext();
        Toast.makeText(context, "Fragment: onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onSaveInstanceState called, States: fragment: CREATED; View: CREATED");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onDestroyView", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onDestroyView called, States: fragment: CREATED; View: DESTROYED");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Context context = getContext();
        Toast.makeText(context, "Fragment: onDestroy", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onDestroy called, States: fragment: DESTROYED; View: DESTROYED");
    }
}