package com.santiago.ws_turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.models.Sitio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SitiosAdpater extends RecyclerView.Adapter<SitiosAdpater.ViewHolder> {
    private int layout;
    private ArrayList<Sitio> sitios;
    private onItemClickListener listener;

    public SitiosAdpater(int layout, ArrayList<Sitio> sitios, onItemClickListener listener) {
        this.layout = layout;
        this.sitios = sitios;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Bind(sitios.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return sitios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView descripcion;
        public TextView ubicacion;

        public ViewHolder(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.contentImg);
            nombre = itemView.findViewById(R.id.contentName);
            descripcion = itemView.findViewById(R.id.contentDesc);
            ubicacion = itemView.findViewById(R.id.contentUbic);
        }
        public void Bind(final Sitio sitio, final onItemClickListener listener) {
            nombre.setText(sitio.getNombre());
            descripcion.setText(sitio.getDescripcionCorta());
            ubicacion.setText(sitio.getUbicacion());
            Picasso.get().load(sitio.getImagen()).error(R.drawable.error).placeholder(R.drawable.loading).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(sitio,getAdapterPosition());
                }
            });


        }
    }

    public interface onItemClickListener{
        void itemClick(Sitio sitio,int positio);
    }
}
