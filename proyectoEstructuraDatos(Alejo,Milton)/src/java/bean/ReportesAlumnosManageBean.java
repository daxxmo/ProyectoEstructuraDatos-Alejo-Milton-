/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.net.ConnectException;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author m!lton
 */
public class ReportesAlumnosManageBean {

    /**
     * Creates a new instance of ReportesAlumnosManageBean
     */
    public ReportesAlumnosManageBean() {
    }
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ConnectException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteAlumnosBean rAlumnos = new ReporteAlumnosBean();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/Alumnos.jasper");
       
        rAlumnos.getReporte(ruta);        
        FacesContext.getCurrentInstance().responseComplete();               
    }
    
    
}
