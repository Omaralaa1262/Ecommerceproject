package com.example.ecommerceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.material.snackbar.Snackbar;

import model.User_Details;

public class sighnin extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighnin);
        Button btn = (Button) findViewById(R.id.signinbutton);
        Ecommercehelper SQLDB = new Ecommercehelper(this);
        EditText editTextEmail=(EditText)findViewById(R.id.Usernamesignintxt);
        EditText editTextPassword=(EditText)findViewById(R.id.Passwordsignintxt);
        CheckBox remember=(CheckBox)findViewById(R.id.remembercheckbox);
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String flage;
        flage=getIntent().getStringExtra("flage");
        if(!(flage==null)){
            SharedPreferences.Editor preferencesEditor=pref.edit();
            preferencesEditor.clear();
            preferencesEditor.apply();
        }
        String username = pref.getString(PREF_USERNAME, null);
        String password = pref.getString(PREF_PASSWORD, null);
        if (username == null || password == null) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                        //Prompt for username and password
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    //Authenticate user
                    User_Details currentUser = SQLDB.Authenticate(new User_Details(null, Email, null, null, null, null, null, Password, null));
                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(btn, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        Intent i = new Intent(sighnin.this, MainActivity.class);
                        i.putExtra("User_Name",Email);
                        if(remember.isChecked())
                        {
                            getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                                    .edit()
                                    .putString(PREF_USERNAME, Email)
                                    .putString(PREF_PASSWORD, Password)
                                    .commit();
                        }
                        startActivity(i);
                        //User Logged in Successfully Launch You home screen activity
                    }}
            }
        });
        TextView txt = (TextView) findViewById(R.id.textView8);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(sighnin.this, signup.class);
                startActivity(i);
            }
        });
    }
        else{
            signinauth(username,password);

        }
    }
    public void signinauth(String username,String Password){
        /*Ecommercehelper SQLDB = new Ecommercehelper(this);
        User_Details currentUser = SQLDB.Authenticate(new User_Details(null, username, null, null, null, null, null, Password, null));

            Button btn = (Button) findViewById(R.id.signinbutton);
            Snackbar.make(btn, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();*/
        Intent i = new Intent(sighnin.this, MainActivity.class);
        i.putExtra("User_Name",username);
        startActivity(i);

    }
    public boolean validate() {
        EditText editTextEmail=(EditText)findViewById(R.id.Usernamesignintxt);
        EditText editTextPassword=(EditText)findViewById(R.id.Passwordsignintxt);
        boolean valid = false;
        //Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();
        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            editTextEmail.setError("Please enter valid username!");
        } else {
            valid = true;
            editTextEmail.setError(null);
        }
        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            editTextPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                editTextPassword.setError(null);
            } else {
                valid = false;
                editTextPassword.setError("Password is to short!");
            }
        }
        return valid;
    }
}
