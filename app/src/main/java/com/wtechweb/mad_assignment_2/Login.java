package com.wtechweb.mad_assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText etName, etFile;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing objects
        init();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString().trim();
                String fileN=etFile.getText().toString().trim();

                Intent intent= new Intent(Login.this,Home.class);
                intent.putExtra("username",name);
                intent.putExtra("filename",fileN);

                startActivity(intent);
                finish();

            }
        });

    }

    private void init() {
        etName=findViewById(R.id.etName);
        etFile=findViewById(R.id.etFile);
        btnSubmit=findViewById(R.id.btnSubmit);

    }
}