/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package app_pk;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mrsna
 */
public class Imported_page_addCon implements Initializable {
    
     Stage window = control.getWindow();
    Scene imported_Scene = control.getImported_Scene();

    @FXML
    TextField organisation_text;
    
    @FXML
    DatePicker Date_pic;
    
    @FXML
    Button add_button;
    
    @FXML
    Button done_button;
    
    @FXML
    Button next_Button;
    @FXML
    HBox slect_add_hbox;
    
    // take que total and take the type that will be send to sql
    @FXML
    GridPane add_grid;
    
    
    
    int total_que;
    
    
    // hard-disk
     ChoiceBox<String> disk_type_choseB = new ChoiceBox<>();
    TextField disk_size_texf = new TextField();
    TextField disk_que_texf = new TextField();
    
    
    // ram
    ChoiceBox<String> drr_cbox = new ChoiceBox<>();
    TextField ram_size_tsxtf = new TextField();
    TextField ram_que_texf = new TextField();
    
    // will check all type that been add in set_add method and start enter data in sql
    ArrayList<String> done_ArrayList = new ArrayList();
    
    // for import
    ArrayList Imported_add_ArrayList = new ArrayList();
    // for ram
    ArrayList ram_add_ArrayList = new ArrayList();
    // for disk
     ArrayList disk_add_ArrayList = new ArrayList();
    
     ChoiceBox <String> seclet_add_cBox = new ChoiceBox<>();
    
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        
        disk_type_choseB.getItems().addAll("SSD","HDD","M.2");
        drr_cbox.getItems().addAll("DDR1","DDR2","DDR3","DDR4","DDR5");
        add_button.setVisible(false);
        done_button.setVisible(false);
       
        seclet_add_cBox.getItems().addAll("ram","Hrad-disk");
        next_Button.setOnAction(e ->{
            add_button.setVisible(true);
            done_button.setVisible(true);
            next_Button.setVisible(false);
            
            Imported_add_ArrayList.add(organisation_text.getText());
            Imported_add_ArrayList.add(Date_pic.getValue());
            
            
            
            
            
          //del the intal node and then add node with position    
          add_grid.getChildren().clear();
          
          
          
          slect_add_hbox.getChildren().add(seclet_add_cBox);
        });
        
        // when value is secleted will show add for the vlaue
        seclet_add_cBox.setOnAction(e -> {
            
            String option_val = seclet_add_cBox.getValue();
            
            if("ram".equals(option_val)){
                 add_grid.getChildren().clear();
                 // DDR Type
                 add_grid.add(new Label("DDR Type"), 0, 0);
                 add_grid.add(drr_cbox, 1, 0);
                 
                 
                 // size of ram
                 
                 
                 add_grid.add(new Label("Ram size"), 0, 1);
                 add_grid.add(ram_size_tsxtf, 1, 1);
                 
                 
                 // ram que
                 add_grid.add(new Label("quantity"), 0, 2);
                 add_grid.add(ram_que_texf, 1, 2);
                 
                 
                 
                 
                 
                
            }
            
            if("Hrad-disk".equals(option_val)){
                 add_grid.getChildren().clear();
                 
                 
                 // disk type
                 add_grid.add(new Label("disk type"), 0, 0);
                 add_grid.add(disk_type_choseB, 1, 0);
                 
                 // hard-disk size
                 add_grid.add(new Label("size"), 0, 1);
                 add_grid.add(disk_size_texf, 1, 1);
                
                 
                 // quantity
                  add_grid.add(new Label("quantity"), 0, 2);
                  add_grid.add(disk_que_texf, 1, 2);
            }
            
            
            
        });
        
        
       
    }
    
    
    public  void set_add (){
        
       
       
        if ("ram".equals(seclet_add_cBox.getValue())) {
            
            ram_add_ArrayList.add(drr_cbox.getValue());
            ram_add_ArrayList.add(ram_size_tsxtf.getText());
            ram_add_ArrayList.add(ram_que_texf.getText());
          total_que +=  Integer.parseInt(ram_que_texf.getText());
          done_ArrayList.add("ram");
            
        }
        else if("Hrad-disk".equals(seclet_add_cBox.getValue())){
            disk_add_ArrayList.add(disk_type_choseB.getValue());
            disk_add_ArrayList.add(disk_size_texf.getText());
            disk_add_ArrayList.add(disk_que_texf.getText());
            
            total_que +=  Integer.parseInt(disk_que_texf.getText());
            done_ArrayList.add("Hrad-disk");
        
    }
       
       
      
    }
    
     public void sql_enter_data(){
         
         database_sql.sql_code.Imported_add(Imported_add_ArrayList,total_que);
         
         int imported_id = database_sql.sql_code.get_Imported_id();
         
         if(done_ArrayList.contains("ram")){
             database_sql.sql_code.ram_add(ram_add_ArrayList,imported_id);
         }
          if(done_ArrayList.contains("Hrad-disk")){
             
             database_sql.sql_code.Hrad_disk_add(disk_add_ArrayList,imported_id);
             
         }
         
         
         
         
     
            
        }
     @FXML
     public void imported_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("imported_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
        
        
        
        
        
    }


    
    
}
