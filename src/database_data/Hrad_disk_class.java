/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_data;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Hrad_disk_class {
    
    
    int Hrad_disk_id;
    String Hrad_disk_type;
    String size;
    int quantity;
    int imported_id;
    int user_id;
    String user_name;

    public Hrad_disk_class(int Hrad_disk_id, String Hrad_disk_type, String size, int quantity, int imported_id, int user_id, String user_name) {
        this.Hrad_disk_id = Hrad_disk_id;
        this.Hrad_disk_type = Hrad_disk_type;
        this.size = size;
        this.quantity = quantity;
        this.imported_id = imported_id;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getHrad_disk_id() {
        return Hrad_disk_id;
    }

    public void setHrad_disk_id(int Hrad_disk_id) {
        this.Hrad_disk_id = Hrad_disk_id;
    }

    public String getHrad_disk_type() {
        return Hrad_disk_type;
    }

    public void setHrad_disk_type(String Hrad_disk_type) {
        this.Hrad_disk_type = Hrad_disk_type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImported_id() {
        return imported_id;
    }

    public void setImported_id(int imported_id) {
        this.imported_id = imported_id;
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
    
//    int Hrad_disk_id;
//    String Hrad_disk_type;
//    String size;
//    int quantity;
//    int imported_id;
//    int user_id;
//    String user_name;
    
    public static TableView<Hrad_disk_class> hard_disk_table(){
        
        TableView<Hrad_disk_class> disk_TableView = new TableView<>();
        
         TableColumn Hrad_disk_id_Column = new TableColumn<Hrad_disk_class ,Integer>("Hrad_disk_id");
         Hrad_disk_id_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,Integer>("Hrad_disk_id"));
         
         TableColumn Hrad_disk_type_Column = new TableColumn<Hrad_disk_class ,String>("Hrad_disk_type");
         Hrad_disk_type_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,String>("Hrad_disk_type"));
         
         TableColumn size_Column = new TableColumn<Hrad_disk_class ,String>("size");
         size_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,String>("size"));
         
         TableColumn quantity_Column = new TableColumn<Hrad_disk_class ,Integer>("quantity");
         quantity_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,Integer>("quantity"));
         
         TableColumn imported_id_Column = new TableColumn<Hrad_disk_class ,Integer>("imported_id");
         imported_id_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,Integer>("imported_id"));
         
         TableColumn user_id_Column = new TableColumn<Hrad_disk_class ,Integer>("user_id");
         user_id_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,Integer>("user_id"));
         
         TableColumn user_name_Column = new TableColumn<Hrad_disk_class ,String>("user_name");
         user_name_Column.setCellValueFactory(new PropertyValueFactory<Hrad_disk_class,String>("user_name"));
         
         disk_TableView.getColumns().addAll(Hrad_disk_id_Column,Hrad_disk_type_Column,size_Column,
                 quantity_Column, imported_id_Column , user_id_Column , user_name_Column);
         disk_TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         return disk_TableView;
        
        
    }
    
    
}
