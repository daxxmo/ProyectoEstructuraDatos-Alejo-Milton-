/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
public class ReportesBean {
    
   public void ReporteAlumnosActivos() {
 
 try {
  // Llamamos al metodo para obtener la conexion
  Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
 
  // Revisar si esta es la dirección donde esta tu reporte .jasper
  File file = new File(
    "C:\\Users\\m!lton\\Documents\\NetBeansProjects\\proyectoEstructuraDatos\\ProyectoEstructuraDatos-Alejo-Milton-\\proyectoEstructuraDatos(Alejo,Milton)\\web\\Reportes\\AlumnosActivos.jasper");
 
  byte[] documento = JasperRunManager.runReportToPdf(file.getPath(),
    null, conect);
   
  String fileType = "inline";
  String reportSetting = fileType + "; filename=\""
    + "reporteAlumnosActivos.pdf\"";
   
  HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
    .getCurrentInstance().getExternalContext().getResponse();
  httpServletResponse.setContentType("application/pdf");
  httpServletResponse.setHeader("Content-Disposition",
    "inline; flename=\reporteAlumnosActivos.pdf\"");
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
      public void ReporteAlumnosInactivos() {
 
 try {
  // Llamamos al metodo para obtener la conexion
  Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
 
  // Revisar si esta es la dirección donde esta tu reporte .jasper
  File file = new File(
    "C:\\Users\\m!lton\\Documents\\NetBeansProjects\\proyectoEstructuraDatos\\ProyectoEstructuraDatos-Alejo-Milton-\\proyectoEstructuraDatos(Alejo,Milton)\\web\\Reportes\\AlumnosInactivos.jasper");
 
  byte[] documento = JasperRunManager.runReportToPdf(file.getPath(),
    null, conect);
   
  String fileType = "inline";
  String reportSetting = fileType + "; filename=\""
    + "reporteAlumnosInactivos.pdf\"";
   
  HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
    .getCurrentInstance().getExternalContext().getResponse();
  httpServletResponse.setContentType("application/pdf");
  httpServletResponse.setHeader("Content-Disposition",
    "inline; flename=\reporteAlumnosInactivos.pdf\"");
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
         public void ReporteAlumnosCarrera() {
 
 try {
  // Llamamos al metodo para obtener la conexion
  Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
 
  // Revisar si esta es la dirección donde esta tu reporte .jasper
  File file = new File(
    "C:\\Users\\m!lton\\Documents\\NetBeansProjects\\proyectoEstructuraDatos\\ProyectoEstructuraDatos-Alejo-Milton-\\proyectoEstructuraDatos(Alejo,Milton)\\web\\Reportes\\AlumnosCarrera.jasper");
 
  byte[] documento = JasperRunManager.runReportToPdf(file.getPath(),
    null, conect);
   
  String fileType = "inline";
  String reportSetting = fileType + "; filename=\""
    + "reporteAlumnosCarrera.pdf\"";
   
  HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
    .getCurrentInstance().getExternalContext().getResponse();
  httpServletResponse.setContentType("application/pdf");
  httpServletResponse.setHeader("Content-Disposition",
    "inline; flename=\reporteAlumnosCarrera.pdf\"");
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
 
}
