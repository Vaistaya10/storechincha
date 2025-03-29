package com.senati.storechincha;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class buscar extends AppCompatActivity {

    private final String URLWS = "http://192.168.1.107/tiendaropa/app/services/service-producto.php";
    RequestQueue requestQueue;

    EditText edtID, edtTipo, edtGenero, edtTalla, edtPrecio;
    Button btnActualizar, btnEliminar, btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        loadUI();

        btnBuscar.setOnClickListener(v -> buscarProducto());
        btnEliminar.setOnClickListener(v -> confirmarEliminacion());
    }

    private void loadUI() {
        edtID = findViewById(R.id.edtID);
        edtTipo = findViewById(R.id.edtTipo);
        edtGenero = findViewById(R.id.edtGenero);
        edtTalla = findViewById(R.id.edtTalla);
        edtPrecio = findViewById(R.id.edtPrecio);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnBuscar = findViewById(R.id.btnBuscar);
    }

    private void buscarProducto() {
        String url = URLWS + "?id=" + edtID.getText().toString().trim();
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        edtTipo.setText(response.getString("tipo"));
                        edtGenero.setText(response.getString("genero"));
                        edtTalla.setText(response.getString("talla"));
                        edtPrecio.setText(response.getString("precio"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("Error", error.toString()));

        requestQueue.add(jsonRequest);
    }

    private void eliminarProducto() {
        String url = URLWS + "?operation=delete&id=" + edtID.getText().toString().trim();
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.DELETE, url, null,
                response -> Log.d("Respuesta", "Producto eliminado"),
                error -> Log.e("Error", error.toString()));

        requestQueue.add(jsonRequest);
    }

    private void confirmarEliminacion() {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Eliminar Producto");
        dialogo.setMessage("¿Seguro que deseas eliminar este producto?");
        dialogo.setCancelable(false);
        dialogo.setNegativeButton("No", null);
        dialogo.setPositiveButton("Sí", (dialog, which) -> eliminarProducto());
        dialogo.create().show();
    }
}
