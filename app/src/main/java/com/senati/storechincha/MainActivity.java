package com.senati.storechincha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnActListar, btnActRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadUI();

        btnActRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(registrar.class);
            }
        });
        btnActListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(listar.class);
            }
        });
    }

    private void openActivity (Class myClass){
        Intent intent = new Intent(getApplicationContext(),myClass);
        startActivity(intent);
    }

    private void loadUI(){
        btnActListar = findViewById(R.id.btnActListar);
        btnActRegistrar = findViewById(R.id.btnActRegistrar);
    }
}