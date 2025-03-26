package com.senati.storechincha.adaptadores;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.senati.storechincha.R;
import com.senati.storechincha.entidades.Producto;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {
    private Context context;
    private List<Producto> listaProductos;
    public ProductoAdapter(@NonNull Context context, List<Producto> listaProductos) {
        super(context, R.layout.activity_listar, listaProductos);
        this.context = context;
        this.listaProductos = listaProductos;
    }

    private void showModal (String message) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this.context);
        dialogo.setTitle("Store Chincha");
        dialogo.setMessage(message);
        dialogo.setCancelable(false);

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {dialog.dismiss();}
        });
        dialogo.create().show();
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_listar,parent,false);
        }

        Producto producto = listaProductos.get(position);

        TextView txtItemProducto = convertView.findViewById(R.id.txtItemProducto);
        TextView txtItemGenero = convertView.findViewById(R.id.txtItemGenero);
        Button button = convertView.findViewById(R.id.btnInLineItem);

        txtItemProducto.setText(producto.getTipo() );
        txtItemGenero.setText(producto.getGenero());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String mensaje = "";
                 mensaje += "Talla: " + producto.getTalla() + "\n";
                 mensaje += "Precio: " + producto.getPrecio() + "\n";
                 showModal(mensaje);

            }
        });
        return convertView;





    }

}
