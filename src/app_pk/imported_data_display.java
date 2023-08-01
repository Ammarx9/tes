/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_pk;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import database_data.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;


public class imported_data_display {
    
    
    public static TableView<imported_class> imported_taTableView(){
        System.out.println("is here");
        TableView<imported_class> imported_TableView = new TableView<>();
        
        TableColumn imported_id_Column = new TableColumn<imported_class ,Integer>("ID");
        imported_id_Column.setCellFactory(new PropertyValueFactory<imported_class,Integer>("imported_id"));
        
        TableColumn organisation_Column = new TableColumn<imported_class , String>("organisation");
        organisation_Column.setCellValueFactory(new PropertyValueFactory<imported_class,String>("organisation"));
        
         TableColumn category_Column = new TableColumn<imported_class , Button>("category");
         category_Column.setCellValueFactory(new PropertyValueFactory<imported_class,Button>("category"));
        
        TableColumn quantity_Column = new TableColumn<imported_class , Integer>("quantity");
        quantity_Column.setCellValueFactory(new PropertyValueFactory<imported_class,Integer>("quantity"));
        
        
        TableColumn Delivery_date_Column = new TableColumn<imported_class , String>("Delivery_date");
        Delivery_date_Column.setCellValueFactory(new PropertyValueFactory<imported_class,String>("Delivery_date"));
        
        TableColumn user_id_Column = new TableColumn<imported_class , Integer>("user_id");
        user_id_Column.setCellValueFactory(new PropertyValueFactory<imported_class,Integer>("user_id"));
        
        TableColumn user_name_Column = new TableColumn<imported_class , String>("user_name");
        user_name_Column.setCellValueFactory(new PropertyValueFactory<imported_class,String>("user_name"));
        
        imported_TableView.getColumns().addAll(imported_id_Column,organisation_Column,category_Column
                ,quantity_Column,Delivery_date_Column,user_id_Column,user_name_Column);
        
    
    return imported_TableView;
    }
    
    
}
