package com.example.hospital.utilidades;

public class Utilidades {


    /*
        TABLA HOSPITAL
     */
    public static final String TABLA_HOSPITAL ="hospitales";
    public static final String CAMPO_ID ="id";
    public static final String CAMPO_NOMBRE ="nombre";

    public static final String CREAR_TABLA_HOSPITAL ="CREATE   TABLE "+TABLA_HOSPITAL+" ("+CAMPO_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+CAMPO_NOMBRE+" TEXT)";

    /*
        TABLA MEDICO
     */
    // NOMBRE DE LA TABLA
    public static final String TABLA_MEDICO ="medicos";
    // CAMPOS
    public static final String CAMPO_ID_MEDICO ="id";
    public static final String CAMPO_NOMBRE_MEDICO ="nombre";
    public static final String CAMPO_ID_HOSPITAL_MEDICO ="idHospital";

    public static final String CREAR_TABLA_MEDICO ="CREATE   TABLE "+TABLA_MEDICO+ " ("+
                                    CAMPO_ID_MEDICO+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+
                                    CAMPO_NOMBRE_MEDICO+" TEXT,"+
                                    CAMPO_ID_HOSPITAL_MEDICO+" INTEGER)";
    /*
        TABLA PACIENTE
     */
    // NOMBRE DE LA TABLA
    public static final String TABLA_PACIENTE ="pacientes";
    // CAMPOS
    public static final String CAMPO_ID_PACIENTE ="id";
    public static final String CAMPO_NOMBRE_PACIENTE ="nombre";
    public static final String CAMPO_ID_HOSPITAL_PACIENTE ="idHospital";
    public static final String CAMPO_TIPO_PACIENTE ="tipo";


    public static final String CREAR_TABLA_PACIENTE ="CREATE   TABLE "+TABLA_PACIENTE+ " ("+
            CAMPO_ID_PACIENTE+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+
            CAMPO_NOMBRE_PACIENTE+" TEXT,"+
            CAMPO_ID_HOSPITAL_PACIENTE+" INTEGER"+
            CAMPO_TIPO_PACIENTE+" INTEGER )";

    /*
        TABLA CITA
     */
    // NOMBRE DE LA TABLA
    public static final String TABLA_CITA ="citas";
    // CAMPOS
    public static final String CAMPO_ID_CITA ="id";
    public static final String CAMPO_ID_HOSPITAL_CITA ="idHospital";
    public static final String CAMPO_FECHA_CITA ="fecha";
    public static final String CAMPO_NUM_HABITACION_CITA ="numHabitacion";
    public static final String CAMPO_NUM_CAMA_CITA ="numCama";


    public static final String CREAR_TABLA_CITA ="CREATE   TABLE "+TABLA_CITA+ " ("+
            CAMPO_ID_CITA+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+
            CAMPO_ID_HOSPITAL_CITA+" INTEGER"+
            CAMPO_FECHA_CITA+" DATE,"+
            CAMPO_NUM_HABITACION_CITA+" INTEGER "+
            CAMPO_TIPO_PACIENTE +" INTEGER)";



}
