/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_pk;

import database_data.imported_class;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author mrsna
 */
public class imported_page_data_con implements Initializable{
    
    Stage window;
    Scene imported_Scene;
    @FXML
    TableView<imported_class> imported_TableView;
    
    @FXML
    private TableColumn<imported_class, LocalDate> Delivery_date;

    @FXML
    private TableColumn<imported_class, Button> category;

    @FXML
    private TableColumn<imported_class, Integer> imported_id;

    @FXML
    private TableColumn<imported_class, String> organisation;

    @FXML
    private TableColumn<imported_class, Integer> quantity;

    @FXML
    private TableColumn<imported_class, Integer> user_id;

    @FXML
    private TableColumn<imported_class, String> user_name;

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        imported_id.setCellValueFactory(new PropertyValueFactory<imported_class,Integer>("imported_id"));
        organisation.setCellValueFactory(new PropertyValueFactory<imported_class,String>("organisation"));
        category.setCellValueFactory(new PropertyValueFactory<imported_class,Button>("category"));
        quantity.setCellValueFactory(new PropertyValueFactory<imported_class,Integer>("quantity"));
        Delivery_date.setCellValueFactory(new PropertyValueFactory<imported_class,LocalDate>("Delivery_date"));
        user_id.setCellValueFactory(new PropertyValueFactory<imported_class,Integer>("user_id"));
        user_name.setCellValueFactory(new PropertyValueFactory<imported_class,String>("user_name"));
        
        
        
         category.setCellFactory(column -> new TableCell<imported_class, Button>() {
            @Override
            protected void updateItem(Button button, boolean empty) {
                super.updateItem(button, empty);
                if (empty || button == null) {
                    setGraphic(null);
                } else {
                    // Set the event handler for the button
                    button.setOnAction(event -> {
                        // Retrieve the corresponding row object
                        imported_class rowItem = getTableView().getItems().get(getIndex());
                        int importedId = rowItem.getImported_id(); // Get the "imported_id"
                        // Now you can use the "importedId" as needed
                       // System.out.println("Clicked Imported ID: " + importedId);
                       
                        try {
                       Stage category_Stage = new Stage();
                       // make obj of the control so can give Imported_id_val value
                       Imported_category_stage_Con categoryController = new Imported_category_stage_Con(importedId);
                       
                       FXMLLoader loader = new FXMLLoader(getClass().getResource("imported_category_stage.fxml"));
                       // give the obj for control so to work need to delete in fxml file it is fx:controller
                       loader.setController(categoryController);
                        Parent imported_category_node = loader.load();
                       Scene imported_category_Scene = new Scene(imported_category_node );
                        
                       category_Stage.setScene(imported_category_Scene);
                       category_Stage.show();
                       
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                       
                      
                       
                       

                    });
                    setGraphic(button);
                }
            }
        });
         
        // give date value
        //LocalDate date = LocalDate.parse("2000-05-12");
        //imported_TableView.getItems().add(new imported_class(5,"55",new Button("click me"),66,date,5,"ammar") );
        
        database_sql.sql_code.get_Imported(imported_TableView);
          

    }
    

    @FXML
     public void imported_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("imported_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
    }
     @FXML
     public void main_page(ActionEvent event) throws IOException{
       
        Parent imported_node = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        imported_Scene = new Scene(imported_node );
        
        window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(imported_Scene);
    }
    
    
    
}
