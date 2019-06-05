/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ismael Ruiz
 */
public class Conexion {


    //Atributos de la clase
    private String host = "localhost";
    private String port;
    private String userName = "root";
    private String password = "master";
    private String dbName = "carnetuvg";
     private String urlReportesPdf = "http://localhost:8080/proyectoEstructuraDatos(Alejo,Milton)/Reportes/";
    public static String usuariogmail;
    public static String passwordgmail;
    //Metodo que obtiene la conexion a la base de datos
    public Connection connect() throws ConnectException, SQLException {
        Connection conn;
        try {
            // Creamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + dbName;
            conn = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    
    //Metodo que cierra una conexion a la base de datos
    public void disconnect(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Metodos gets y sets
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    
        public String getUrlReportesPdf() {
        return urlReportesPdf;
    }

    public void setUrlReportesPdf(String urlReportesPdf) {
        this.urlReportesPdf = urlReportesPdf;
    } 
}
