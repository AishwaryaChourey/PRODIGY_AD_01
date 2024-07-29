package com.example.calculator;

import android.os.Bundle;
//import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        Button buttonac = findViewById(R.id.buttonac);
        Button buttonoff = findViewById(R.id.buttonoff);
        Button buttonon = findViewById(R.id.buttonon);
        Button buttond = findViewById(R.id.buttond);
        Button buttondiv = findViewById(R.id.buttondiv);
        Button buttonx = findViewById(R.id.buttonx);
        Button button_ = findViewById(R.id.button_);
        Button buttonp = findViewById(R.id.buttonp);
        Button buttone = findViewById(R.id.buttone);
        Button buttondel = findViewById(R.id.buttondel);

        TextView screen = findViewById(R.id.screen);

        buttonac.setOnClickListener(view ->{
            firstNum = 0;
            screen.setText("0");
        });

        buttonoff.setOnClickListener(view -> screen.setVisibility(View.GONE));
        buttonon.setOnClickListener((view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        }));

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(button0);
        nums.add(button1);
        nums.add(button2);
        nums.add(button3);
        nums.add(button4);
        nums.add(button5);
        nums.add(button6);
        nums.add(button7);
        nums.add(button8);
        nums.add(button9);

        for (Button b: nums) {

            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(String.format("%s%s", screen.getText().toString(), b.getText().toString()));
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

    ArrayList<Button> oper = new ArrayList<>();
        oper.add(buttondiv);
        oper.add(buttonx);
        oper.add(button_);
        oper.add(buttonp);

        for(Button b : oper){
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        buttondel.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length()>1){
                screen.setText(num.substring(0,num.length()-1));
            }
            else if(num.length() == 1 && !num.equals("0")){
                screen.setText("0");
            }
        });

    buttond.setOnClickListener(view -> {
        if(!screen.getText().toString().contains(".")){
            screen.setText(String.format("%s.", screen.getText().toString()));

        }
    });

    buttone.setOnClickListener(view ->{
        double secondNum = Double.parseDouble(screen.getText().toString());
        double result;
        switch(operation){
            case "/":
                result = firstNum/secondNum;
                break;
            case "*":
                result = firstNum*secondNum;
                break;
            case "+":
                result = firstNum+secondNum;
                break;
            case "-":
                result = firstNum-secondNum;
                break;
            default:
                result = 0;
        }
        screen.setText(String.valueOf(result));
        firstNum = result;
        });

    }
}