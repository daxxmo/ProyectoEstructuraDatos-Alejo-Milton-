/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAction;
import utils.Conexion;
import utils.Mensajes;
import java.io.Serializable;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import static javax.swing.UIManager.getBoolean;

public class RegistroAlumnoDbAction {
    
    public RegistroAlumnoDbAction() {
    }

        //Metodo que registra el docente en la base de datos
    public String registrarAlumno(String carnet, String nombre, String apellido, String carrera, String año, String ciclo, String foto) {
        String resultado = "";
        boolean result;
        try {
            Connection conect;
            Conexion conexion = new Conexion();
            conect = conexion.connect();
            Statement stmt = conect.createStatement();
            String query = "insert into alumno (carnet_alumno,nombre_alumno,apellido_alumno,carrera_alumno,anio_alumno,ciclo_alumno,foto_alumno,id_estado) VALUES ('" + carnet + "','" + nombre + "','" + apellido + "','" + carrera + "','" + año + "','" + ciclo + "','" + foto + "',1)";
            stmt.execute(query);
            ResultSet rs = null;
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getBoolean(1);
                    if (result == true) {
                        resultado = "exito";
                        Mensajes.infoMessage("Registro", "Error al realizar la transaccion");
                    } else {
                        resultado = "error";
                        Mensajes.infoMessage("Registro", "El alumno ya se encuentra resgistrado");
                    }
                }
            } else {
                resultado = "error";
                Mensajes.infoMessage("Registro", "Alumno registrado exitosamente");
            }
        } catch (ConnectException | SQLException ex) {
            ex.printStackTrace();
            resultado = "error";
            Mensajes.errorMessage("Registro", "Error al conectarse a la base de datos");

        }
        return resultado;
    }

}