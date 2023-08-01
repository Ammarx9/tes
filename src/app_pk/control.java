/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_pk;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import database_data.*;
import javafx.event.Event;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;



public class control {
    
    
   static Stage window;
    static Scene imported_Scene;

    public static Stage getWindow() {
        return window;
    }

    public static Scene getImported_Scene() {
        return imported_Scene;
    }
    
    
     
     
    
    public void imported_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("imported_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
        
        
        
        
        
    }
    
    public  void exported_page(ActionEvent e) throws IOException{
        
        Parent imported_node = FXMLLoader.load(getClass().getResource("exported_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
        
    }
    
    
    public void main_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
    }
    
     
    public void imported_data_display_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("imported_data_display.fxml"));
        
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
    }
    
    public  void imported_page_add(ActionEvent e) throws IOException{
        
        Parent imported_node = FXMLLoader.load(getClass().getResource("imported_page_add.fxml"));
        
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
        
        
    }
     
    @FXML
    public  void exported_page_add_con(ActionEvent e) throws IOException{
        
        Parent imported_node = FXMLLoader.load(getClass().getResource("exported_page_add.fxml"));
        
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
        
        
    }
    
    
    
    
}
