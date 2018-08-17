package com.santiago.ws_turisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        super(context, "turisApp", null, 1);
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
public boolean validarTablas(String tabla){
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM " +tabla,null);
        if (!cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
}
    public boolean guardarSitio(ArrayList<Sitio> sitios){
        if (validarTablas(Constantes.TBL_SITIOS)){
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
        }
        return true;
    }

    public boolean guardarHoteles(ArrayList<Hotel> hotels){
        if (validarTablas(Constantes.TBL_HOTELES)) {
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
                db.insert(Constantes.TBL_HOTELES, null, values);
            }
        }
        return true;
    }

    public boolean guardarRestaurantes(ArrayList<Restaurante> restaurantes){
        if (validarTablas(Constantes.TBL_RESTAURANTES)) {
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
                db.insert(Constantes.TBL_RESTAURANTES, null, values);
            }
        }
        return true;
    }

    public ArrayList<Sitio> listarSitios(){
        Sitio sitio;
        ArrayList<Sitio>sitios=null;
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_SITIOS,null);
        if (cursor.moveToFirst()){
            sitios=new ArrayList<>();
            do {
                sitio=new Sitio();
                sitio.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.NOMBRE)));
                sitio.setDescripcionCorta(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIP_CORTA)));
                sitio.setUbicacion(cursor.getString(cursor.getColumnIndex(Constantes.UBICACION)));
                sitio.setDescripcion(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIPCION)));
                sitio.setLatitud(cursor.getLong(cursor.getColumnIndex(Constantes.LATITUD)));
                sitio.setLongitud(cursor.getLong(cursor.getColumnIndex(Constantes.LOGITUD)));
                sitio.setImagen(cursor.getInt(cursor.getColumnIndex(Constantes.IMAGEN)));
                sitios.add(sitio);
            }while (cursor.moveToNext());
        }
        return sitios;
    }

    public ArrayList<Hotel> listarHoteles(){
        Hotel hotel;
        ArrayList<Hotel>hotels=null;
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_HOTELES,null);
        if (cursor.moveToFirst()){
            hotels=new ArrayList<>();
            do {
                hotel=new Hotel();
                hotel.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.NOMBRE)));
                hotel.setDescripcionCorta(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIP_CORTA)));
                hotel.setUbicacion(cursor.getString(cursor.getColumnIndex(Constantes.UBICACION)));
                hotel.setDescripcion(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIPCION)));
                hotel.setLatitud(cursor.getLong(cursor.getColumnIndex(Constantes.LATITUD)));
                hotel.setLongitud(cursor.getLong(cursor.getColumnIndex(Constantes.LOGITUD)));
                hotel.setImagen(cursor.getInt(cursor.getColumnIndex(Constantes.IMAGEN)));
                hotels.add(hotel);
            }while (cursor.moveToNext());
        }
        return hotels;
    }

    public ArrayList<Restaurante> listarRestaurantes(){
        Restaurante restaurante;
        ArrayList<Restaurante>restaurantes=null;
        db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Constantes.TBL_RESTAURANTES,null);
        if (cursor.moveToFirst()){
            restaurantes=new ArrayList<>();
            do {
                restaurante=new Restaurante();
                restaurante.setNombre(cursor.getString(cursor.getColumnIndex(Constantes.NOMBRE)));
                restaurante.setDescripcionCorta(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIP_CORTA)));
                restaurante.setUbicacion(cursor.getString(cursor.getColumnIndex(Constantes.UBICACION)));
                restaurante.setDescripcion(cursor.getString(cursor.getColumnIndex(Constantes.DESCRIPCION)));
                restaurante.setLatitud(cursor.getLong(cursor.getColumnIndex(Constantes.LATITUD)));
                restaurante.setLongitud(cursor.getLong(cursor.getColumnIndex(Constantes.LOGITUD)));
                restaurante.setImagen(cursor.getInt(cursor.getColumnIndex(Constantes.IMAGEN)));
                restaurantes.add(restaurante);
            }while (cursor.moveToNext());
        }
        return restaurantes;
    }


}
