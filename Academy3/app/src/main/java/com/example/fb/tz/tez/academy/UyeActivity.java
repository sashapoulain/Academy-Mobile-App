package com.example.fb.tz.tez.academy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UyeActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmailUye,editTextPasswordUye, editTextPhone, editTextAdress;
    private Button buttonKayıt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye);

        editTextName=findViewById(R.id.editTextName);
        editTextPasswordUye=findViewById(R.id.editTextPasswordUye);
        editTextEmailUye=findViewById(R.id.editTextEmailUye);
        editTextPhone=findViewById(R.id.editTextPhone);
        editTextAdress=findViewById(R.id.editTextAdress);
        buttonKayıt=findViewById(R.id.buttonKayıt);
        buttonKayıt.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Kayıt başarılı", Toast.LENGTH_LONG).show();
            }
        });
    }
}