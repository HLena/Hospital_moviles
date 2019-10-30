package com.example.hospital;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;

import com.example.hospital.utilidades.Utilidades;


public class ConexionSQLiteHelper extends SQLiteOpenHelper{


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_HOSPITAL);
        db.execSQL(Utilidades.CREAR_TABLA_MEDICO);
        db.execSQL(Utilidades.CREAR_TABLA_PACIENTE);
        db.execSQL(Utilidades.CREAR_TABLA_CITA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS hospitales ");
        db.execSQL("DROP TABLE IF EXISTS medicos ");
        db.execSQL("DROP TABLE IF EXISTS pacientes ");
        db.execSQL("DROP TABLE IF EXISTS citas ");
        onCreate(db);
    }
}
