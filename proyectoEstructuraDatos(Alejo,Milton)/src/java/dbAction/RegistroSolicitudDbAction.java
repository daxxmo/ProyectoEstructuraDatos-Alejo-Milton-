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
 * @author m!lton
 */
public class RegistroSolicitudDbAction {

    public String registrarSolicitud(String carnet) {
     
           String resultado = "";
        boolean result;
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement();
            String query = "insert into solicitud (carnet_solicitud,id_estado) VALUES ('" + carnet + "',1)";
            stmt.execute(query);
            ResultSet rs = null;
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getBoolean(1);
                    if (result == true) {
                        resultado = "error";
                        Mensajes.infoMessage("Registro", "Error al realizar la transaccion");
                    } else {
                        resultado = "error";
                        Mensajes.infoMessage("Registro", "El carnet ya esta solicitado");
                    }
                }
            } else {
                resultado = "exito";
                Mensajes.infoMessage("Registro", "Carnet solicitado exitosamente");
            }
        } catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
            resultado = "error";
            Mensajes.errorMessage("Registro", "Error al conectarse a la base de datos");

        }
        return resultado;
    }
    
}
