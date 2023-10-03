package com.hopecoding.handlerrunnablejava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.hopecoding.handlerrunnablejava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Handler handler;

    private Runnable runnable;

    private static Integer time=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.stopbtn.setEnabled(false);
    }

    @SuppressLint("DefaultLocale")
    public void start(View view){
        handler=new Handler();
        runnable= () -> {
            time++;
            handler.postDelayed(runnable,1000);
            binding.timeText.setText(String.format("Time:%d", time));
        };
        handler.post(runnable);

        binding.startbtn.setEnabled(false);
        binding.stopbtn.setEnabled(true);
    }

    @SuppressLint("SetTextI18n")
    public void stop(View view){
        time=0;
        handler.removeCallbacks(runnable);
        binding.timeText.setText("Time has stopped");
        binding.startbtn.setEnabled(true);
        binding.stopbtn.setEnabled(false);
    }


}