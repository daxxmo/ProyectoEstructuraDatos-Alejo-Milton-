/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dbAction.LoginDbAction;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 *
 * @author GALLO
 */
@ManagedBean
@SessionScoped
public class IndexBean {
    private String username;
    private String password;

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
        
        String resultado = "";
        if(this.getUsername().equals("") || this.getPassword().equals("")){
            Mensajes.errorMessage("Error", "Debe llenar los dos campos");
        }
        else{
            LoginDbAction validar = new LoginDbAction();
            resultado = validar.ValidarLogin(this.getUsername(), this.getPassword());
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
    
}
