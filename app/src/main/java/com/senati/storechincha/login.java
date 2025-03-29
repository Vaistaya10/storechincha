package com.senati.storechincha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private EditText etUsuario, etPassword;
    private Button btnLogin;
    private TextView tvNoCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvNoCuenta = findViewById(R.id.tvNoCuenta);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí se puede implementar la lógica de autenticación con el web service
                    Toast.makeText(login.this, "Login exitoso", Toast.LENGTH_SHORT).show();

                    // Redirigir al MainActivity
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Evita que el usuario regrese al login con el botón de retroceso
                }
            }
        });

        tvNoCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, registrarusuario.class);
                startActivity(intent);
            }
        });
    }
}
