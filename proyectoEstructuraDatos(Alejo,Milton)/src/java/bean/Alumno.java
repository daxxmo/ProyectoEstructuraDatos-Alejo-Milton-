/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dbAction.ActualizarAlumnoDbAction;
import dbAction.RegistroAlumnoDbAction;
import java.text.ParseException;
import utils.Mensajes;

/**
 *
 * @author m!lton
 */
class Alumno {
    String carnet;
    String nombre;
    String apellido;
    String carrera;
    String año;
    String ciclo;
    String foto;
    Integer estado;

    public Alumno(String carnet, String nombre, String apellido, String carrera, String año, String ciclo, String foto, Integer estado) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.año = año;
        this.ciclo = ciclo;
        this.foto = foto;
        this.estado = estado;
    }

    Alumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public String regresarMenu(){
        return "regresarMenu";
    }
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
      public void validarAlumno() throws ParseException{
        String resultado = "";
        if(this.getCarnet().equals("") || this.getNombre().equals("")){
            Mensajes.errorMessage("Advertencia", "Los campos con * son obligatorios");
        }
        else{
            carnet = this.getCarnet();
            nombre = this.getNombre();
            apellido = this.getApellido();
            carrera = this.getCarrera();
            año = this.getAño();
            ciclo = this.getCiclo();
            foto = this.getFoto();
            RegistroAlumnoDbAction registro = new RegistroAlumnoDbAction();
            resultado = registro.registrarAlumno(carnet, nombre, apellido, carrera, año, ciclo, foto);
            if(resultado.equals("exito")){
          
            }
        }
    }
      
     
    
}
