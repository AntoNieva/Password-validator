package com.example.acme.csci3130_demo;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private EditText etPassword;

    private Button validate;

    private TextView validateResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPassword = (EditText)findViewById(R.id.et_password);
        validate = (Button)findViewById(R.id.bt_validate);
        validateResult = (TextView)findViewById(R.id.validate_result);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String passwordStr = etPassword.getText().toString();
                String validateResultStr = new Validator().validatePassword(passwordStr);

                validateResult.setText(validateResultStr);

                setProgressBarColour(Validator.GRADE_SCORE);
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                closeSoftKeyboard();
            }
        });

    }



    public void closeSoftKeyboard(){
        InputMethodManager imm = (InputMethodManager) getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etPassword.getWindowToken(), 0);
    }

    private void setProgressBarColour(int score) {
        int color = 0;
        if (score < 30) {
            color = getResources().getColor(R.color.bg_red);
        }else if (score <60){
            color = getResources().getColor(R.color.bg_2);
        }else if (score < 70) {
            color = getResources().getColor(R.color.bg_orangef);
        } else if (score<90){
            color = getResources().getColor(R.color.bg_4);
        }else {
            color = getResources().getColor(R.color.bg_green11);
        }
        ClipDrawable d = new ClipDrawable(new ColorDrawable(color), Gravity.
                LEFT, ClipDrawable.HORIZONTAL);
        progressBar.setProgressDrawable(d);
        progressBar.setProgress(score);
    }
}

