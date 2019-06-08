/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dbAction.LoginDbAction;
import dbAction.RegistroUsuarioDbAction;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import utils.Mensajes;
import org.apache.commons.codec.digest.DigestUtils;
import org.jboss.weld.context.RequestContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author GALLO
 */
@ManagedBean
@SessionScoped
public class IndexBean {
    private String username;
    private String password;
    
    private String carneReg;
    private String nombreReg;
    private String apellidoReg;
    private String passwordReg;
    private String correoReg;

    public String getCarneReg() {
        return carneReg;
    }

    public void setCarneReg(String carneReg) {
        this.carneReg = carneReg;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public String getApellidoReg() {
        return apellidoReg;
    }

    public void setApellidoReg(String apellidoReg) {
        this.apellidoReg = apellidoReg;
    }

    public String getPasswordReg() {
        return passwordReg;
    }

    public void setPasswordReg(String passwordReg) {
        this.passwordReg = passwordReg;
    }

    public String getCorreoReg() {
        return correoReg;
    }

    public void setCorreoReg(String correoReg) {
        this.correoReg = correoReg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() throws ConnectException, SQLException{
        
        String encriptado = DigestUtils.sha512Hex(String.valueOf(this.getPassword()));
        String resultado = "";
        if(this.getUsername().equals("") || this.getPassword().equals("")){
            Mensajes.errorMessage("Error", "Debe llenar los dos campos");
        }
        else{
            
            LoginDbAction validar = new LoginDbAction();
            resultado = validar.ValidarLogin(this.getUsername(), encriptado);
        }
        
        return resultado;
        
        //FacesContext.getCurrentInstance().addMessage(null,
                //new FacesMessage("Welcome " + username + " " + password));   
    }



    String loguot() {
               this.setUsername("");
        this.setPassword("");
        return "ok";
    }
    
    public void validarUsuario() throws ParseException{
        String resultado = "";
        
        if(this.getCarneReg().equals("") || this.getNombreReg().equals("")){
            Mensajes.errorMessage("Advertencia", "Los campos con * son obligatorios");
        }
        else{
            carneReg = this.getCarneReg();
            nombreReg = this.getNombreReg();
            apellidoReg = this.getApellidoReg();
            String encriptado = DigestUtils.sha512Hex(String.valueOf(this.getPasswordReg()));
            passwordReg = encriptado;
            correoReg = this.getCorreoReg();
            
            RegistroUsuarioDbAction registro = new RegistroUsuarioDbAction();
            resultado = registro.RegistrarUsuario(carneReg, nombreReg, apellidoReg, passwordReg, correoReg);
            if(resultado.equals("exito")){
                limpiarCampos();
            }
        }
    }
    
    private void limpiarCampos() {
        carneReg = "";
        nombreReg = "";
        apellidoReg = "";
        passwordReg = "";
        correoReg = "";
    }
}
