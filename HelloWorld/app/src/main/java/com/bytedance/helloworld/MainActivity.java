package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tv1.setText("What a wonderful day!");

            }
        });

        RadioGroup rg = findViewById(R.id.rg_feel);
        RadioButton rb1 = findViewById(R.id.rb_good);
        RadioButton rb2 = findViewById(R.id.rb_soso);
        RadioButton rb3 = findViewById(R.id.rb_bad);

        rg.setOnCheckedChangeListener(new MyRadioButtonListener());

        SeekBar seekBar=findViewById(R.id.sbar);
        final TextView tvbar=findViewById(R.id.tvbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvbar.setText(progress+"%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                System.out.println("com.example.screenBrightnessTest.MyActivity.onStartTrackingTouch");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("com.example.screenBrightnessTest.MyActivity.onStopTrackingTouch");
            }
        });

        Log.d(TAG, "MainActivity");
    }

    class MyRadioButtonListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 选中状态改变时被触发
            switch (checkedId) {
                case R.id.rb_good:
                    Log.i("emotion", "The user feels good today");
                    break;
                case R.id.rb_soso:
                    Log.i("emotion", "The user feels soso today");
                    break;
                case R.id.rb_bad:
                    Log.i("emotion", "The user feels bad today");
                    break;
            }
        }
    }
}
