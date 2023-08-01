/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_data;

import java.time.LocalDate;
import javafx.scene.control.Button;

/**
 *
 * @author mrsna
 */
public class Exported_class {
    
    int Exported_id;
    String organisation;
    Button category;
    int quantity;
    LocalDate date;
    int user_id;
    String user_name;

    public Exported_class(int Exported_id, String organisation, Button category, int quantity, LocalDate date, int user_id, String user_name) {
        this.Exported_id = Exported_id;
        this.organisation = organisation;
        this.category = category;
        this.quantity = quantity;
        this.date = date;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getExported_id() {
        return Exported_id;
    }

    public void setExported_id(int Exported_id) {
        this.Exported_id = Exported_id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
