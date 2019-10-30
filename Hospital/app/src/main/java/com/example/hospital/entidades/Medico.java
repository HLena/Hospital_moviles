package com.example.hospital.entidades;
import  android.app.Application;
import java.io.Serializable;

public class Medico extends Application implements Serializable {


    private Integer id;
    private String nombre;
    private Integer idHospital;


    public Medico(Integer id,Integer idHospital,String nombre)
    {
        this.idHospital=idHospital;
        this.id = id;
        this.nombre = nombre;
    }

    public  Integer getId()
    {
        return  this.id;
    }

    public  void setId(Integer id)
    {
        this.id=id;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }

    public Integer getIdHospital() {return this.idHospital;}

    public  void setIdHospital(Integer idHospital){this.idHospital=idHospital;}



}
