package com.shrarn.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton button1;
    private androidx.appcompat.widget.AppCompatButton button2;
    private androidx.appcompat.widget.AppCompatButton button3;
    private androidx.appcompat.widget.AppCompatButton button4;
    private androidx.appcompat.widget.AppCompatButton button5;
    private androidx.appcompat.widget.AppCompatButton button6;
    private androidx.appcompat.widget.AppCompatButton button7;
    private androidx.appcompat.widget.AppCompatButton button8;
    private androidx.appcompat.widget.AppCompatButton button9;
    private androidx.appcompat.widget.AppCompatButton button0;
    private androidx.appcompat.widget.AppCompatButton about;
    private androidx.appcompat.widget.AppCompatButton equal;
    private androidx.appcompat.widget.AppCompatButton plus;
    private androidx.appcompat.widget.AppCompatButton minus;
    private androidx.appcompat.widget.AppCompatButton divide;
    private androidx.appcompat.widget.AppCompatButton multiply;
    private androidx.appcompat.widget.AppCompatButton percent;
    private androidx.appcompat.widget.AppCompatButton delete;
    private androidx.appcompat.widget.AppCompatButton clear;
    private androidx.appcompat.widget.AppCompatButton decimal;
    private TextView info;
    private TextView result;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;


    private  final char Addition = '+';
    private  final char Multiplication = 'x';
    private  final char Division = '/';
    private  final char Substraction = '-';
    private  final char Percentage = '%';
    private final char Equal = '=';
    private char ACTION;

    private double val1 = Double.NaN;
    private double val2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupUI();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);





        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               info.setText(info.getText().toString()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+"9");
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString()+".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText("");
                result.setText("");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Substraction;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Addition;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Multiplication;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Division;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Equal;
                result.setText(String.valueOf(val1));
                // 5 + 4 = 9
                info.setText(null);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = Percentage;
                result.setText(String.valueOf(val1) + "%");
                info.setText(null);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newDialog();
            }
        });

    }


    public void newDialog()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View AboutMe = getLayoutInflater().inflate(R.layout.popup,null);
        dialogBuilder.setView(AboutMe);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    private void SetupUI()
    {
        button1 = findViewById(R.id.But1);
        button2 = findViewById(R.id.But2);
        button3 = findViewById(R.id.But3);
        button4 = findViewById(R.id.But4);
        button5 = findViewById(R.id.But5);
        button6 = findViewById(R.id.But6);
        button7 = findViewById(R.id.But7);
        button8 = findViewById(R.id.But8);
        button9 = findViewById(R.id.But9);
        button0 = findViewById(R.id.But0);

        equal = findViewById(R.id.Equals);
        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Minus);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        percent = findViewById(R.id.percent);
        delete = findViewById(R.id.delete);
        clear = findViewById(R.id.Clear);
        decimal = findViewById(R.id.decimal);
        about = findViewById(R.id.About);

        info = findViewById(R.id.Text);
        result = findViewById(R.id.text2);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION){
                case Addition:
                    val1 = val1 + val2;
                    break;
                case Substraction:
                    val1 = val1 - val2;
                    break;
                case Multiplication:
                    val1 = val1 * val2;
                    break;
                case Division:
                    val1 = val1 / val2;
                    break;
                case Percentage:
                    val1 = (val1*val2)/100;
                    break;
                case Equal:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}