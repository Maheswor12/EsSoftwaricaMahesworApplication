package com.example.essoftwaricamahesworapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtUsername, txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            if (TextUtils.isEmpty(txtUsername.getText().toString())) {
                txtUsername.setError("Enter Username");
                txtUsername.requestFocus();
                return;
            } else if (txtUsername.length() < 3) {
                txtUsername.setError("at least 3 characters");
                txtUsername.requestFocus();
                return;
            } else if (TextUtils.isEmpty(txtPassword.getText().toString())) {
                txtPassword.setError("Enter Password");
                txtPassword.requestFocus();
                return;
            } else if (txtPassword.length() < 4 || txtPassword.length() > 10) {
                txtPassword.setError("between 4 and 10 alphanumeric characters");
                txtPassword.requestFocus();
                return;
            }

            String Username = txtUsername.getText().toString();
            String Password = txtPassword.getText().toString();

            if (Username.equals("Maheswor") && Password.equals("admin")) {
                Toast.makeText(this, "Login Successful, Welcome: " + Username, Toast.LENGTH_SHORT).show();
                txtUsername.setText("");
                txtPassword.setText("");
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                Intent intent = new Intent(this, BottomNavigationActivity.class);
//                startActivity(intent);
            } else {
                Toast.makeText(this, "Username && Password did not match", Toast.LENGTH_SHORT).show();
                txtUsername.setText("");
                txtPassword.setText("");
            }

        }
    }
}
