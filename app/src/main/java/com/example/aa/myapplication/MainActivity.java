package com.example.aa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.cat);
    }
    private EditText ed1,ed2,ed3;
    private TextView tv1;
    int size=15;
    public void BMI(View v){
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        tv1=findViewById(R.id.tv1);
        float height=Float.parseFloat(ed2.getText().toString());
        float weight=Float.parseFloat(ed3.getText().toString());
        float BMI1=calculateBMI(weight,height);
        String BMI2=String.valueOf(BMI1);

        tv1.setTextSize(size);
        tv1.setText(ed1.getText().toString()+",Hello"+"\n"+"your BMI is "+BMI2);
        Toast.makeText(this,standBMI(BMI1),Toast.LENGTH_LONG).show();

    }
    private float calculateBMI(float w,float h){
        float BMI =(float)(w/Math.pow((h/100),2));
        return BMI;
    }
    private String standBMI(double st){
        String alert="";

        if(st>25){
            alert=String.valueOf("You are too heavy!!");
            getWindow().setBackgroundDrawableResource(R.drawable.angry);
        }
        else if(st<18.5){
            alert=String.valueOf("You are too slim");
            getWindow().setBackgroundDrawableResource(R.drawable.cry);
        }
        else{
            alert=String.valueOf("Your body is good!");
        }
        return alert;
    }
}
