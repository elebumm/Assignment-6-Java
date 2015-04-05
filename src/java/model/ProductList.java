/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

/**
 *
 * @author lewismenelaws
 */
public class ProductList {

    private List<Product> productList;

    public ProductList() {
        productList = new ArrayList<>();
        try (Connection conn = Database.database.getConnection()) {
            String query = "SELECT * FROM products";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("productID"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
                productList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JsonArray toJSON() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Product p : productList) {
            json.add(p.toJSON());
        }
        return json.build();

    }

    public void add(Product product) throws SQLException, Exception {
        int rowsUpdated = database.Database.doUpdate("INSERT INTO products (Name, Description, Quantity) VALUES (?,?,?)", product.getName(), product.getDescription(), String.valueOf(product.getQuantity()));
        if (rowsUpdated == 1) {
            productList.add(product);
        } 
        else {
            throw new Exception("");
        }
    }

    public void remove(int id) {

    }

    public void set(int id, Product product) {

    }
}
