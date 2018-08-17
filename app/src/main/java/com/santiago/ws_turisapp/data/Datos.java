package com.santiago.ws_turisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.santiago.ws_turisapp.Utils.Constantes;
import com.santiago.ws_turisapp.models.Hotel;
import com.santiago.ws_turisapp.models.Restaurante;
import com.santiago.ws_turisapp.models.Sitio;

import java.util.ArrayList;

public class Datos extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public Datos(Context context) {
        super(context, "turisApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constantes.SQL_SITIOS);
        sqLiteDatabase.execSQL(Constantes.SQL_HOTELES);
        sqLiteDatabase.execSQL(Constantes.SQL_RESTAURANTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean guardarSitio(ArrayList<Sitio> sitios){
        db=getWritableDatabase();
        for (int i=0;i<sitios.size();i++){
            ContentValues values=new ContentValues();
            values.put(Constantes.NOMBRE,sitios.get(i).getNombre());
            values.put(Constantes.DESCRIP_CORTA,sitios.get(i).getDescripcionCorta());
            values.put(Constantes.UBICACION,sitios.get(i).getUbicacion());
            values.put(Constantes.DESCRIPCION,sitios.get(i).getDescripcion());
            values.put(Constantes.LATITUD,sitios.get(i).getLatitud());
            values.put(Constantes.LOGITUD,sitios.get(i).getLongitud());
            values.put(Constantes.IMAGEN,sitios.get(i).getImagen());
            db.insert(Constantes.TBL_SITIOS, null, values);
        }
            return true;
    }

    public boolean guardarHoteles(ArrayList<Hotel> hotels){
        db=getWritableDatabase();
        for (int i=0;i<hotels.size();i++){
            ContentValues values=new ContentValues();
            values.put(Constantes.NOMBRE,hotels.get(i).getNombre());
            values.put(Constantes.DESCRIP_CORTA,hotels.get(i).getDescripcionCorta());
            values.put(Constantes.UBICACION,hotels.get(i).getUbicacion());
            values.put(Constantes.DESCRIPCION,hotels.get(i).getDescripcion());
            values.put(Constantes.LATITUD,hotels.get(i).getLatitud());
            values.put(Constantes.LOGITUD,hotels.get(i).getLongitud());
            values.put(Constantes.IMAGEN,hotels.get(i).getImagen());
            db.insert(Constantes.TBL_SITIOS, null, values);
        }
            return true;
    }

    public boolean guardarRestaurantes(ArrayList<Restaurante> restaurantes){
        db=getWritableDatabase();
        for (int i=0;i<restaurantes.size();i++){
            ContentValues values=new ContentValues();
            values.put(Constantes.NOMBRE,restaurantes.get(i).getNombre());
            values.put(Constantes.DESCRIP_CORTA,restaurantes.get(i).getDescripcionCorta());
            values.put(Constantes.UBICACION,restaurantes.get(i).getUbicacion());
            values.put(Constantes.DESCRIPCION,restaurantes.get(i).getDescripcion());
            values.put(Constantes.LATITUD,restaurantes.get(i).getLatitud());
            values.put(Constantes.LOGITUD,restaurantes.get(i).getLongitud());
            values.put(Constantes.IMAGEN,restaurantes.get(i).getImagen());
            db.insert(Constantes.TBL_SITIOS, null, values);
        }
        return true;
    }
}
