/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_data;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mrsna
 */
public class ram_class {
    
    int ram_id;
    String DDR_Type;
    String size;
    int quantity;
    int imported_id;
    int user_id;
    String user_name;

    public ram_class(int ram_id, String DDR_Type, String size, int quantity, int imported_id, int user_id, String user_name) {
        this.ram_id = ram_id;
        this.DDR_Type = DDR_Type;
        this.size = size;
        this.quantity = quantity;
        this.imported_id = imported_id;
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getRam_id() {
        return ram_id;
    }

    public void setRam_id(int ram_id) {
        this.ram_id = ram_id;
    }

    public String getDDR_Type() {
        return DDR_Type;
    }

    public void setDDR_Type(String DDR_Type) {
        this.DDR_Type = DDR_Type;
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
    
//    int ram_id;
//    String DDR_Type;
//    String size;
//    int quantity;
//    int imported_id;
//    int user_id;
//    String user_name;
    
    public static TableView<ram_class> ram_table(){
        
        TableView<ram_class> ram_tableTableView = new TableView<>();
        
         TableColumn ram_id_Column = new TableColumn<ram_class ,Integer>("ram_id");
         ram_id_Column.setCellValueFactory(new PropertyValueFactory<ram_class,Integer>("ram_id"));
         
         TableColumn DDR_Type_Column = new TableColumn<ram_class ,String>("DDR_Type");
         DDR_Type_Column.setCellValueFactory(new PropertyValueFactory<ram_class,String>("DDR_Type"));
         
         TableColumn size_Column = new TableColumn<ram_class ,String>("size");
         size_Column.setCellValueFactory(new PropertyValueFactory<ram_class,String>("size"));
         
         TableColumn quantity_Column = new TableColumn<ram_class ,Integer>("quantity");
         quantity_Column.setCellValueFactory(new PropertyValueFactory<ram_class,Integer>("quantity"));
         
         TableColumn imported_id_Column = new TableColumn<ram_class ,Integer>("imported_id");
         imported_id_Column.setCellValueFactory(new PropertyValueFactory<ram_class,Integer>("imported_id"));
         
         TableColumn user_id_Column = new TableColumn<ram_class ,Integer>("user_id");
         user_id_Column.setCellValueFactory(new PropertyValueFactory<ram_class,Integer>("user_id"));
         
         TableColumn user_name_Column = new TableColumn<ram_class ,String>("user_name");
         user_name_Column.setCellValueFactory(new PropertyValueFactory<ram_class,String>("user_name"));
        
        ram_tableTableView.getColumns().addAll(ram_id_Column,DDR_Type_Column,size_Column,
                quantity_Column , imported_id_Column , user_id_Column , user_name_Column);
        
        return  ram_tableTableView;
    }
    
}
