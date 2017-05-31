/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jquesadaabeijon
 */
public class Methods{
    static Connection con = null;
    static Statement s = null;
    public static String db;
    public static String url = "jdbc:sqlite:" +db;

    public Methods() {
    }
    
    public Methods(String db){
        this.db = "base.db";
    }
    
    
    public boolean connect(){

        try {
            con = DriverManager.getConnection(url);
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("El driver es " + meta.getDriverName());
            System.out.println("Estás conectado");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public void createTable(String name){
//        String url = "jdbc:sqlite:" +db;
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellidos text NOT NULL,\n"
                + "     edad REAL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int insert(Element l){
    String sql = "INSERT INTO Alumnos(id,nombre,apellidos,edad) VALUES(?,?,?,?)";
            
            try {
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setObject(1, l.getId());
                pstmt.setString(2, l.getNombre());
                pstmt.setString(3, l.getApellido());
                pstmt.setObject(4, l.getEdad());
                pstmt.executeUpdate();
                System.out.println("Datos insertados");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return 0;
            }
            return 1;
    }
    
    public int delete(String id) {
        String sql = "DELETE FROM alumnos WHERE id = " +id;
        
        try {
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
    
    public int update(Element l){
        String sql = "UPDATE alumnos SET nombre='"+l.getNombre()+"', apellidos='"+l.getApellido()+"', edad="+l.getEdad()+" WHERE id = " +l.getId();
        
        try {
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return 1;
    }
}
