/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author lewismenelaws
 */
public class Product {
    private int productID;
    private String name;
    private String description;
    private int quantity;

    public Product(int productID, String name, String description, int quantity) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    
    public Product(JsonObject json) {
        productID = json.getInt("productID");
        name = json.getString("name");
        description = json.getString("description");
        quantity = json.getInt("quantity");
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("productID", productID)
                .add("name", name)
                .add("description", description)
                .add("quantity", quantity)
                .build();
    }
        
}
