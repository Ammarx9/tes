/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_data;

import java.time.LocalDate;
import javafx.scene.control.Button;


public class imported_class {
    int imported_id;
    String organisation;
    Button category;
    int quantity;
    LocalDate Delivery_date;
    int user_id;
    String user_name;

    public imported_class(int imported_id, String organisation, Button category, int quantity, LocalDate Delivery_date, int user_id, String user_name) {
        this.imported_id = imported_id;
        this.organisation = organisation;
        this.category = category;
        this.quantity = quantity;
        this.Delivery_date = Delivery_date;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getImported_id() {
        return imported_id;
    }

    public void setImported_id(int imported_id) {
        this.imported_id = imported_id;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public Button getCategory() {
        return category;
    }

    public void setCategory(Button category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDelivery_date() {
        return Delivery_date;
    }

    public void setDelivery_date(LocalDate Delivery_date) {
        this.Delivery_date = Delivery_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
}
