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
import utils.Conexion;
import utils.Mensajes;

/**
 *
 * @author Alejandro
 */
public class RegistroUsuarioDbAction {

    public RegistroUsuarioDbAction() {
    }
    
    
    public String RegistrarUsuario(String carneReg, String nombreReg, String apellidoReg, String passwordReg, String correoReg) {
        String resultado = "";
        boolean result;
        
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement();
            String query = "insert into usuario (nickname_usuario,nombre_usuario,apellido_usuario,password_usuario,correo_usuario,id_rol,id_estado) VALUES ('" + carneReg + "','" + nombreReg + "','" + apellidoReg + "','" + passwordReg + "','" + correoReg + "',2,1)";
            stmt.execute(query);
            ResultSet rs = null;
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getBoolean(1);
                    if (result == true) {
                        resultado = "error";
                        Mensajes.infoMessage("Registro", "Error al realizar la transaccion");
                    }
                    else {
                        resultado = "error";
                        Mensajes.infoMessage("Registro", "El alumno ya se encuentra resgistrado");
                    }
                }
            }
            else {
                resultado = "exito";
                Mensajes.infoMessage("Registro", "Alumno registrado exitosamente");
            }
        }
        
        catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
            resultado = "error";
            Mensajes.errorMessage("Registro", "Error al conectarse a la base de datos");
        }
        
        return resultado;
    }
}
