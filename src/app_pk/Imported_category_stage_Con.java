/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app_pk;

import com.mysql.cj.xdevapi.Table;
import database_data.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * 
 */
public class Imported_category_stage_Con implements Initializable {
    
    int Imported_id_val;

   @FXML
   ChoiceBox <String> category_ChoiceBox = new ChoiceBox<>();
   @FXML
    VBox table_vbox = new VBox();
   
    TableView<ram_class> ram_table = new TableView<>();
    TableView<Hrad_disk_class> disk_table = new TableView<>();
    
    // so we make obj to give Imported_id_val vlaue
    public Imported_category_stage_Con(int Imported_id_val ){
        
        this.Imported_id_val = Imported_id_val;
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        category_ChoiceBox.getItems().addAll("ram","Hrad-disk");
        
        ram_table = ram_class.ram_table();
        disk_table = Hrad_disk_class.hard_disk_table();
        
        
        // will check if this Imported_id have in this category
        if(!database_sql.sql_code.ram_category_check(Imported_id_val)){
            category_ChoiceBox.getItems().remove("ram");
            
        }
        if(!database_sql.sql_code.Hrad_disk_category_check(Imported_id_val)){
              category_ChoiceBox.getItems().remove("Hrad-disk");
        }
        
        category_ChoiceBox.setOnAction(e -> {
            
            String option_val = category_ChoiceBox.getValue();
            
            if("ram".equals(option_val)){
                table_vbox.getChildren().clear();
                table_vbox.getChildren().add(ram_table);
                
                database_sql.sql_code.ram_category_table(ram_table , Imported_id_val);
            }
            
            if("Hrad-disk".equals(option_val)){
                table_vbox.getChildren().clear();
                table_vbox.getChildren().add(disk_table);
                
                database_sql.sql_code.Hrad_disk_category_table(disk_table , Imported_id_val);
                
            }
            
        });
        
        
        
        
        
    }    
    
}
