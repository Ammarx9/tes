/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app_pk;

import java.net.URL;
import java.util.ArrayList;
import database_data.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * 
 */
public class Exported_page_add_con implements Initializable {
    
    ram_class selectedRam;
    Hrad_disk_class selectedDisk;
    
     ArrayList<String> done_ArrayList = new ArrayList();
    
    
    
    @FXML
    GridPane Exported_add_grid = new GridPane();
    @FXML
    Button Exported_add_back = new Button();
    @FXML
    Button Exported_add_next  = new Button();
    @FXML
    Button Exported_add_done = new Button();
    @FXML
    Button Exported_add_button = new Button();
    @FXML
    ChoiceBox<String> Exported_add_ChoiceBox = new ChoiceBox<>();
    @FXML
    HBox box_button = new HBox();
    @FXML
    VBox VBox_grid_table = new VBox();
    
    @FXML
    TextField organisation_text = new TextField();
    @FXML
    DatePicker Date_pic = new DatePicker();
    
    // take the quantity for Exported
    GridPane Exported_que_grid = new GridPane();
    Label Exported_que_Label = new Label("quantity");
    TextField Exported_que_texf = new TextField();
    
    int total_que = 0;
    
    // ArrayList for data and table
    
     // for import
     ArrayList Exported_add_ArrayList = new ArrayList();
    // for ram
    ArrayList ram_add_ArrayList = new ArrayList();
    TableView<ram_class> ram_TableView = new TableView<>();
    int ram_id;
    String ram_DDR_Type;
    String ram_size;
    int ram_quantity;
    int ram_imported_id;
    int ram_user_id;
    String ram_user_name;
    
    // for disk
     ArrayList disk_add_ArrayList = new ArrayList();
     TableView<Hrad_disk_class> disk_TableView = new TableView<>();
     int Hrad_disk_id;
    String Hrad_disk_type;
    String disk_size;
    int disk_quantity;
    int disk_imported_id;
    int disk_user_id;
    String disk_user_name;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        Exported_que_grid.add(Exported_que_Label, 0, 0);
        Exported_que_grid.add(Exported_que_texf, 1, 0);
        Exported_que_grid.setHgap(10);
        
//        Exported_add_grid.setColumnSpan(ram_TableView,5);
        // rady the table
        ram_TableView = ram_class.ram_table();
        disk_TableView = Hrad_disk_class.hard_disk_table();
        
        Exported_add_ChoiceBox.getItems().addAll("ram","Hrad-disk");
        Exported_add_ChoiceBox.setVisible(false);
        Exported_add_done.setVisible(false);
        Exported_add_button.setVisible(false);
        
        Exported_add_done.setOnAction(e ->{
            
            done_set();
        });
        
        // use to take value from row form tables
       Exported_add_button.setOnAction(e ->{
           
            selectedRam = ram_TableView.getSelectionModel().getSelectedItem();
            selectedDisk = disk_TableView.getSelectionModel().getSelectedItem();
            // check there is row selcted
            System.out.println(selectedRam);
            System.out.println(selectedDisk);
                if (selectedRam != null) {
                    // check que not large then the que of the storge
                   if(selectedRam.getQuantity()>= Integer.parseInt(Exported_que_texf.getText())){
                    
                    ram_id = selectedRam.getRam_id();
                    ram_DDR_Type = selectedRam.getDDR_Type();
                    ram_size = selectedRam.getSize();
                    ram_quantity = selectedRam.getQuantity();
                      
                    total_que += Integer.parseInt(Exported_que_texf.getText());
                     System.out.println(total_que);
                    ram_imported_id = selectedRam.getImported_id();
                    ram_user_id = selectedRam.getUser_id();
                    
                    
                    ram_add_ArrayList.add(ram_id);
                    ram_add_ArrayList.add(ram_DDR_Type);
                    ram_add_ArrayList.add(ram_size);
                    ram_add_ArrayList.add(Integer.parseInt(Exported_que_texf.getText()));
                    ram_add_ArrayList.add(ram_imported_id);
                    ram_add_ArrayList.add(ram_user_id);
                    
                    done_ArrayList.add("ram");
                    
                   } 
                   
                } 
                
                
               
                if (selectedDisk != null) {
                    if(selectedDisk.getQuantity() >= Integer.parseInt(Exported_que_texf.getText())){
                   Hrad_disk_id = selectedDisk.getHrad_disk_id();
                   Hrad_disk_type = selectedDisk.getHrad_disk_type();
                   disk_size = selectedDisk.getSize();
                   disk_quantity = selectedDisk.getQuantity();
                   
                   total_que += Integer.parseInt(Exported_que_texf.getText());
                        System.out.println(total_que);
                   disk_imported_id = selectedDisk.getImported_id();
                   disk_user_id = selectedDisk.getUser_id();
                  
                   
                   disk_add_ArrayList.add(Hrad_disk_id);
                   disk_add_ArrayList.add(Hrad_disk_type);
                   disk_add_ArrayList.add(disk_size);
                   disk_add_ArrayList.add(Integer.parseInt(Exported_que_texf.getText()));
                   disk_add_ArrayList.add(disk_imported_id);
                   disk_add_ArrayList.add(disk_user_id);
                   
                   done_ArrayList.add("Hrad-disk");
                   
                  
                    }
                    
                }
                
                selectedRam = null;
                selectedDisk = null;
                

               
           });
        
        
        Exported_add_next.setOnAction(e -> {
            
            
            
           
           
             Exported_add_ChoiceBox.setVisible(true);
             Exported_add_done.setVisible(true);
             Exported_add_button.setVisible(true);
            Exported_add_next.setVisible(false);
             
              Exported_add_ArrayList.add(organisation_text.getText());
              Exported_add_ArrayList.add(Date_pic.getValue());
             
             VBox_grid_table.getChildren().clear();
              
              
             
            
            
        });
        Exported_add_ChoiceBox.setOnAction(e -> {
           
           
             selectedRam = null;
             selectedDisk = null;
            
            String option_val = Exported_add_ChoiceBox.getValue();
            
            if("ram".equals(option_val)){
                
                 VBox_grid_table.getChildren().clear();
                 VBox_grid_table.getChildren().add(Exported_que_grid);
                 VBox_grid_table.getChildren().add(ram_TableView);
                 database_sql.Exported_sql.ram_get_Exported(ram_TableView);
                
                
            }
            
             if("Hrad-disk".equals(option_val)){
                  
               selectedDisk = disk_TableView.getSelectionModel().getSelectedItem();
               
                 VBox_grid_table.getChildren().clear();
                 VBox_grid_table.getChildren().add(Exported_que_grid);
                 VBox_grid_table.getChildren().add(disk_TableView);
                 database_sql.Exported_sql.disk_get_Exported(disk_TableView);
                  
                 
             }
                
                 
                 
            
            
        });
        
        
    }

     public void done_set(){
         
         database_sql.Exported_sql.Exported_add(Exported_add_ArrayList, total_que);
         int exported_id = database_sql.Exported_sql.get_Exported_id();
         
         if(done_ArrayList.contains("ram")){
             database_sql.Exported_sql.ram_add_exo(ram_add_ArrayList, exported_id);
             
             int Imported_id = (Integer)ram_add_ArrayList.get(4);
             int que = (Integer)ram_add_ArrayList.get(3);
             
             database_sql.Exported_sql.Imported_que_del(que,Imported_id);
             database_sql.Exported_sql.ram_que_del(ram_add_ArrayList);
             
//             database_sql.Exported_sql.Imported_que_emty();
             
         }
         if(done_ArrayList.contains("Hrad-disk"))
             database_sql.Exported_sql.Hrad_disk_add_exo(disk_add_ArrayList ,exported_id);
             database_sql.Exported_sql.disk_que_del(disk_add_ArrayList);
             
             int Imported_id = (Integer)disk_add_ArrayList.get(4);
             int que = (Integer)disk_add_ArrayList.get(3);
             database_sql.Exported_sql.Imported_que_del(que,Imported_id);
              
//             database_sql.Exported_sql.Imported_que_emty();
     }
    
}
