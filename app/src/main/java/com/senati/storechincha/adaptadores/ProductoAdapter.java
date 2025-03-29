package com.senati.storechincha.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.senati.storechincha.R;
import com.senati.storechincha.entidades.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> listaProductos;

    public ProductoAdapter(Context context, ArrayList<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() { return listaProductos.size(); }

    @Override
    public Object getItem(int position) { return listaProductos.get(position); }

    @Override
    public long getItemId(int position) { return listaProductos.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        }

        TextView txtTipo = convertView.findViewById(R.id.txtTipo);
        TextView txtGenero = convertView.findViewById(R.id.txtGenero);
        TextView txtTalla = convertView.findViewById(R.id.txtTalla);
        TextView txtPrecio = convertView.findViewById(R.id.txtPrecio);

        Producto producto = listaProductos.get(position);

        txtTipo.setText("Tipo: " + producto.getTipo());
        txtGenero.setText("Género: " + producto.getGenero());
        txtTalla.setText("Talla: " + producto.getTalla());
        txtPrecio.setText("S/ " + producto.getPrecio());

        return convertView;
    }
}
