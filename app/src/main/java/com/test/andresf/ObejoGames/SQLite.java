package com.test.andresf.ObejoGames;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AndresF on 24/01/2017.
 */

public class SQLite extends SQLiteOpenHelper {



    public SQLite(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }
    //se crea la tabla con los campos
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table personas(contraseña text primary key, gamertag text, email text)");


    }
    //si no existe crea la tabla con los respectiivos campos
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists personas");
        db.execSQL("create table personas(contraseña text primary key, gamertag text, email text)");


    }
}
