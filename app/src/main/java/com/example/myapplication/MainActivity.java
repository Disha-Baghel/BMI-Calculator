package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult ;

        LinearLayout llMain;

        edtWeight = findViewById(R.id.editWeight);
        edtHeightFt = findViewById(R.id.feetHeight);
        edtHeightIn = findViewById(R.id.inchesHeight);
        btnCalculate = findViewById(R.id.btn_calculate);
        txtResult = findViewById(R.id.result);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htft = Integer.parseInt(edtHeightFt.getText().toString());
                int htin = Integer.parseInt(edtHeightIn.getText().toString());

                double totalH = (double)((htft*12 + htin)*2.53)/100;

                double bmi = wt/(totalH*totalH);
                if (bmi>25){
                    txtResult.setText("You are Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.overweight));
                }
                else if (bmi<18){
                    txtResult.setText("You are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underwt));
                }
                else{
                    txtResult.setText("You are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

    }

}