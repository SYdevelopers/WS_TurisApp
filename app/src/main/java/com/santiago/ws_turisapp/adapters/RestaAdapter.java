package com.santiago.ws_turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.models.Restaurante;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaAdapter extends RecyclerView.Adapter<RestaAdapter.ViewHolder> {
    private int layout;
    private ArrayList<Restaurante>restaurantes;
    private onItemClickListener listener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Bind(restaurantes.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
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

        public void Bind(final Restaurante restaurante, final onItemClickListener listener) {
            nombre.setText(restaurante.getNombre());
            descripcion.setText(restaurante.getDescripcionCorta());
            ubicacion.setText(restaurante.getUbicacion());
            Picasso.get().load(restaurante.getImagen()).error(R.drawable.error).placeholder(R.drawable.loading).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(restaurante,getAdapterPosition());
                }
            });
        }
    }

    public interface onItemClickListener{
        void itemClick(Restaurante restaurante,int position);
    }
}
