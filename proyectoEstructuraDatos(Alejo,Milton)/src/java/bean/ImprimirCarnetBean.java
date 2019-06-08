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
import java.sql.Connection;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;
import utils.Conexion;

/**
 *
 * @author m!lton
 */
public class ImprimirCarnetBean {
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
                limpiarCampos();
            }
        }
    }
      
        public void consultarAlumno(){

    } 
              public void imprimirCarnet() {
 
 try {
  // Llamamos al metodo para obtener la conexion
  Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
 
  // Revisar si esta es la dirección donde esta tu reporte .jasper
  File file = new File(
    "C:\\Users\\m!lton\\Documents\\NetBeansProjects\\proyectoEstructuraDatos\\ProyectoEstructuraDatos-Alejo-Milton-\\proyectoEstructuraDatos(Alejo,Milton)\\web\\Reportes\\Alumnos.jasper");
 
  byte[] documento = JasperRunManager.runReportToPdf(file.getPath(),
    null, conect);
   
  String fileType = "inline";
  String reportSetting = fileType + "; filename=\""
    + "reporteAlumnos.pdf\"";
   
  HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
    .getCurrentInstance().getExternalContext().getResponse();
  httpServletResponse.setContentType("application/pdf");
  httpServletResponse.setHeader("Content-Disposition",
    "inline; flename=\reporteAlumnos.pdf\"");
  httpServletResponse.setHeader("Cache-Control", "private");
  httpServletResponse.setContentLength(documento.length);
 
  ServletOutputStream servletOutputStream = httpServletResponse
    .getOutputStream();
  servletOutputStream.write(documento, 0, documento.length);
  servletOutputStream.flush();
  servletOutputStream.close();
 
  conect.close();
   
  FacesContext.getCurrentInstance().responseComplete();
 } catch (Exception e) {
  e.printStackTrace();
 }
}

    private void limpiarCampos() {
        this.setCarnet("");
        this.setNombre("");
        this.setApellido("");
        this.setCarrera("");
        this.setAño("");
        this.setCiclo("");
        this.setFoto("");
    }
    
}
