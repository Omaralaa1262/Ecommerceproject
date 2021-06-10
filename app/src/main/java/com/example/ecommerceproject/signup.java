package com.example.ecommerceproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.DatePicker;
import java.util.Calendar;


import androidx.appcompat.app.AppCompatActivity;

import model.User_Details;

public class signup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView txt=(TextView)findViewById(R.id.producategoryproductdetails);
        EditText txtusername=(EditText)findViewById(R.id.UserNameSignup);
        EditText txtemail=(EditText)findViewById(R.id.txtsgnupemail);
        EditText txtpassword=(EditText)findViewById(R.id.txtsignuppassword);
        EditText txtfirstname=(EditText)findViewById(R.id.FirstNameSignup);
        EditText txtlastname=(EditText)findViewById(R.id.LastNameSignup);
        EditText txtmobile=(EditText)findViewById(R.id.MobileSignup);
        RadioButton male=(RadioButton)findViewById(R.id.maleRB);
        RadioButton female=(RadioButton)findViewById(R.id.femaleRB);
        RadioGroup sex=(RadioGroup)findViewById(R.id.sex);
        EditText txtdateofbirth=(EditText)findViewById(R.id.DateOfBirthSignup);
        final DatePickerDialog[] picker = new DatePickerDialog[1];

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(signup.this,sighnin.class);
                startActivity(i);
            }
        });
        txtdateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker[0] = new DatePickerDialog(signup.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            txtdateofbirth.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                picker[0].show();

            }
        });

        Button btn=(Button)findViewById(R.id.SignUpbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sexselect=sex.getCheckedRadioButtonId();
                RadioButton sexRB=(RadioButton)findViewById(sexselect);
                User_Details user=new User_Details(null,txtusername.getText().toString(),txtfirstname.getText().toString(),txtlastname.getText().toString(),null,sexRB.getText().toString(),txtemail.getText().toString(),txtpassword.getText().toString(),txtmobile.getText().toString());
                final Ecommercehelper signup=new Ecommercehelper(com.example.ecommerceproject.signup.this);
                signup.Register(user);
                Toast.makeText(getApplicationContext(), "registration successful!", Toast.LENGTH_LONG).show();
                Intent x=new Intent(com.example.ecommerceproject.signup.this,MainActivity.class);
                x.putExtra("User_Name",txtusername.getText().toString());
                startActivity(x);
                finish();
            }
        });

    }}
