/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;



import utils.Mensajes;
import java.text.ParseException;
import java.util.Date;
import dbAction.RegistroAlumnoDbAction;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import utils.Conexion;
import dbAction.RegistroSolicitudDbAction;

/**
 *
 * @author m!lton
 */
public class SolicitarCarnetBean  {
    private String carnet;
    private String nombre;
    private String apellido;
    private String carrera;
    private String año;
    private String ciclo;
    private String foto;
    private Integer estado;
    
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
    
   public void validarCarnet() throws ParseException{
        String resultado = "";
        if(this.getCarnet().equals("")){
            Mensajes.errorMessage("Advertencia", "Los campos con * son obligatorios");
        }
        else{
            carnet = this.getCarnet();
            RegistroSolicitudDbAction registro = new RegistroSolicitudDbAction();
            resultado = registro.registrarSolicitud(carnet);
            if(resultado.equals("exito")){
                limpiarCampos();
            }
        }
    }
      
 


    private void limpiarCampos() {
        this.setCarnet("");

    }
   
    
}
