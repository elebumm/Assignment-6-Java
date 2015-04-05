/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.krb5.Credentials;

/**
 *
 * @author lewismenelaws
 */
public class Database {
    
    
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbc = "jdbc:mysql://localhost/products";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(jdbc, user, pass);            
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Credentials.class.getName()).log(Level.SEVERE, null,ex);
        }
        return conn;
    }
    
    public static String getResults(String query, String... params) throws SQLException {
        StringBuilder sb = new StringBuilder();
        try (Connection conn = Database.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++){
                pstmt.setString(i, params[i - 1]);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sb.append(String.format("{ \"productId\" : %s, \"name\" : %s, \"description\" : %s, \"quantity\" : %s }", rs.getInt("ProductID"), rs.getString("Name"), rs.getString("Description"), rs.getInt("Quantity")));
            }
            
        }
        catch (SQLException ex){
                    
                    }
        return sb.toString();
    }

public static int doUpdate(String query, String... params) throws SQLException {
    for (int i = 0; i < params.length; i++){
        System.out.println(params[i]);
    }
    int Changes = 0;
    try (Connection conn = Database.getConnection()) {
        PreparedStatement pstmt = conn.prepareStatement(query);
        for (int i = 1; i <= params.length; i++){
            pstmt.setString(i, params[i - 1]);
        }
        Changes = pstmt.executeUpdate();
    } catch (SQLException ex) {
        
    }
    return Changes;
}

}
