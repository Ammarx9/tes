/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_pk;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mrsna
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
        boolean check = database_sql.sql_code.get_Connection();
       
        if(check == true){
            System.out.println("good con");
        }
        else{
            System.out.println("no con");
        }
        Parent imported_node = FXMLLoader.load(getClass().getResource("main_page.fxml"));
        Scene main_Scene = new Scene(imported_node,600,400);
        primaryStage.setScene(main_Scene);
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
