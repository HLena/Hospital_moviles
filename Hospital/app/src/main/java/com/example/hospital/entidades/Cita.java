package com.example.hospital.entidades;

public class Cita {


    private Integer id;
    private Integer idHospital;
    private String fecha;
    private Integer numHabitacion;
    private Integer numCama;

    public Cita(Integer id, Integer idHospital,String fecha, Integer numHabitacion, Integer numCama)
    {
        this.id = id;
        this.idHospital=idHospital;
        this.fecha = fecha;
        this.numHabitacion = numHabitacion;
        this.numCama = numCama;
    }

    public  Integer getId()
    {
        return  this.id;
    }

    public  void setId(Integer id)
    {
        this.id=id;
    }

    public  Integer getIdHospital(){return this.idHospital;}

    public void setIdHospital(Integer idHospital){this.idHospital=idHospital;}

    public String getFecha()
    {
        return this.fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha= fecha;
    }

    public Integer getNumHabitacion() {return this.numHabitacion;}

    public  void setNumHabitacion(Integer tipo) {this.numHabitacion=numHabitacion;}

    public Integer getNumCama() {return this.numCama;}

    public  void setNumCama(Integer tipo) {this.numCama=numCama;}

}
