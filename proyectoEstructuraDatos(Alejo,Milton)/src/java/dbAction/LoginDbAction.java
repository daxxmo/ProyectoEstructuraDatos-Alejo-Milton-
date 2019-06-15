/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAction;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utils.Conexion;
import utils.Mensajes;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@SessionScoped
public class LoginDbAction {

    public LoginDbAction() {
    }
    
    public String ValidarLogin(String username, String password) throws ConnectException, SQLException{
        String resultado = "";
        String correo;
        
        try{
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement();
            String query = "select id_rol, id_estado, correo_usuario, count(1) as total from usuario " +
               "where nickname_usuario like '"+username+"' and password_usuario like '"+password+"' and id_estado=1";
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs != null) {
                while (rs.next()) {
                    //Asignamos el resulSet a variables locales
                    int rolUsuario = rs.getInt("id_rol");
                    int statusUsuario = rs.getInt("id_estado");
                    correo=rs.getString("correo_usuario");
                    //Creamos las variables de sesion para los accesos
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_ROL", rolUsuario);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_STATUS", statusUsuario);
		    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_USERNAME", username);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("SESSION_PASSWORD", password);
                    if (statusUsuario == 2) {
                        resultado = "error";
                        Mensajes.errorMessage("ERROR", "Usuario Inactivo");
                    } //Validamos que sea administrador y que este activo
                    else if (rolUsuario == 1 && statusUsuario == 1) {
                        resultado = "administrador";
                    } //Validamos que sea vendedor y que este activo
                    else if (rolUsuario == 2 && statusUsuario == 1) {
                        resultado = "alumno";
                    }
                }
            }
            else {
                Mensajes.errorMessage("ERROR", "Usuario y/o Contraseña incorrectos");
                resultado = "error";
            }
        }
        catch (SQLException e){
            resultado = "error";
            e.printStackTrace();
        }         
    return resultado;
    }
}
