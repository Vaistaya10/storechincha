package com.senati.storechincha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.senati.storechincha.R;

public class registrarusuario extends AppCompatActivity {
    private EditText etNombre, etNuevoUsuario, etNuevaPassword;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarusuario);

        etNombre = findViewById(R.id.etNombre);
        etNuevoUsuario = findViewById(R.id.etNuevoUsuario);
        etNuevaPassword = findViewById(R.id.etNuevaPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString().trim();
                String usuario = etNuevoUsuario.getText().toString().trim();
                String password = etNuevaPassword.getText().toString().trim();

                if (nombre.isEmpty() || usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(registrarusuario.this, "Completa los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí se puede implementar la lógica de registro con el web service
                    Toast.makeText(registrarusuario.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}