package com.example.ali.latihansqlite;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends ActionBarActivity {
    DBHelper dbHelper;
    Button buttonLogin, buttonExit;
    EditText textUser, textPasswd;
    String Username = "admin", Password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        dbHelper = new DBHelper(this);
        textUser = (EditText) findViewById(R.id.editText);
        textPasswd = (EditText) findViewById(R.id.editText2);
        buttonLogin = (Button) findViewById(R.id.button);
        buttonExit = (Button) findViewById(R.id.button2);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String User = textUser.getText().toString();
                String Pass = textPasswd.getText().toString();
                if (User.equals("") || Pass.equals("")) {
                    Toast.makeText(login.this, "Username atau Password belum diisi", Toast.LENGTH_SHORT).show();
                } else {
                    if (!User.equals(Username) || !Pass.equals(Password)) {
                        Toast.makeText(login.this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login.this, "Berhasil Login!", Toast.LENGTH_SHORT).show();
                        dbHelper.SimpanUser(User, Pass);
                        finish();
                        Intent im = new Intent(login.this, Menu.class);
                        startActivity(im);
                    }
                }
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                moveTaskToBack(true);
            }
        });
    }
}
