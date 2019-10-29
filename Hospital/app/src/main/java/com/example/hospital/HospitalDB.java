package com.example.hospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HospitalDB extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="HospitalDB.db";


    //Especificando las tablas
    private static final String HOSPITAL_TABLE = "CREATE TABLE Hospitals(hospital_id INTEGER PRIMARY KEY AUTOINCREMENT, name_hospital TEXT)";
    //private static final String PATIENT_TABLE = "CREATE TABLE Patients(id_patient INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT, comment TEXT)";
    private static final String DOCTOR_TABLE = "CREATE TABLE Doctors(doctor_id INTEGER PRIMARY KEY AUTOINCREMENT, doctor_name TEXT, address TEXT, telf TEXT, hospital_id INTEGER)";
    private static final String BOOKING_TABLE = "CREATE TABLE Booking(number_booking INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, room_number TEXT, bed_number TEXT, hospital_id INTEGER, patient_id INTEGER)";
    //private static final String CONTINUOU_TABLE = "CREATE TABLE Continuos(patient_id INTEGER PRIMARY KEY AUTOINCREMENT, name_patient TEXT)";
    //private static final String NOT_CONTINUOU_TABLE = "CREATE TABLE NotContinuos(name TEXT, telf TEXT, address TEXT)";

    public HospitalDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HOSPITAL_TABLE);
        db.execSQL(DOCTOR_TABLE);
        db.execSQL(BOOKING_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void  InsertHospitals(SQLiteDatabase db){


    }

}
