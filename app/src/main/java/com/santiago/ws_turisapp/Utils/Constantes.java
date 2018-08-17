package com.santiago.ws_turisapp.Utils;

import android.provider.BaseColumns;

public class Constantes implements BaseColumns {

    public static final String TBL_SITIOS="tbl_sitios";
    public static final String TBL_HOTELES="tbl_hoteles";
    public static final String TBL_RESTAURANTES="tbl_restaurantes";
    public static final String NOMBRE="nombre";
    public static final String DESCRIP_CORTA="descripcion_corta";
    public static final String UBICACION="ubicacion";
    public static final String DESCRIPCION="descripcion";
    public static final String LATITUD="latitud";
    public static final String LOGITUD="longitud";
    public static final String IMAGEN="imagen";

    public static final String SQL_SITIOS="CREATE TABLE "+ TBL_SITIOS+"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NOMBRE + " TEXT,"+
            DESCRIP_CORTA + " TEXT,"+
            UBICACION + " TEXT,"+
            DESCRIPCION + " TEXT,"+
            LATITUD + " INTEGER,"+
            LOGITUD + " INTEGER,"+
            IMAGEN + " INTEGER)";



    public static final String SQL_HOTELES="CREATE TABLE "+ TBL_HOTELES+"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NOMBRE + " TEXT,"+
            DESCRIP_CORTA + " TEXT,"+
            UBICACION + " TEXT,"+
            DESCRIPCION + " TEXT,"+
            LATITUD + " INTEGER,"+
            LOGITUD + " INTEGER,"+
            IMAGEN + " INTEGER)";

    public static final String SQL_RESTAURANTES="CREATE TABLE "+ TBL_RESTAURANTES+"("+
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            NOMBRE + " TEXT,"+
            DESCRIP_CORTA + " TEXT,"+
            UBICACION + " TEXT,"+
            DESCRIPCION + " TEXT,"+
            LATITUD + " INTEGER,"+
            LOGITUD + " INTEGER,"+
            IMAGEN + " INTEGER)";
}
