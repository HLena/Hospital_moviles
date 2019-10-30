package com.example.hospital.entidades;

import java.io.Serializable;

public class Paciente implements Serializable {

    private Integer id;
    private String nombre;
    private Integer idHospital;
    private Integer tipo;

    public Paciente(Integer id,Integer idHospital,String nombre,Integer tipo)
    {
        this.idHospital=idHospital;
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public Integer getTipo() {return this.tipo;}

    public  void setTipo(Integer tipo) {this.tipo=tipo;}

}
