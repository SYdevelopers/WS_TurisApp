package com.santiago.ws_turisapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.models.Hotel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HotelesAdapter extends RecyclerView.Adapter<HotelesAdapter.ViewHolder> {
    private int layout;
    private ArrayList<Hotel> hotels;
    private onItemClickListener listener;

    public HotelesAdapter(int layout, ArrayList<Hotel> hotels, onItemClickListener listener) {
        this.layout = layout;
        this.hotels = hotels;
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
        holder.Bind(hotels.get(position),listener);

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;
        public TextView descri;
        public TextView ubicacion;
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void Bind(final Hotel hotel, final onItemClickListener listener) {
            nombre.setText(hotel.getNombre());
            descri.setText(hotel.getDescripcionCorta());
            ubicacion.setText(hotel.getUbicacion());
            Picasso.get().load(hotel.getImagen()).error(R.drawable.error).placeholder(R.drawable.loading).fit().into(imagen);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(hotel,getAdapterPosition());
                }
            });

        }
    }

    public interface onItemClickListener{
        void itemClick(Hotel hotel,int position);
    }
}
