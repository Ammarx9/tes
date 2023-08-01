/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_sql;
import database_data.*;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class sql_code {
    
     private static final String db_url = "jdbc:mysql://localhost:3306/pc_hardware_parts";
     private static final String db_username = "root";
     private static final String db_password = "Alikalid12!";
     
     
      private static PreparedStatement stm = null;
      private static ResultSet res_set = null;
    
    
    private static Connection  conn;

    public static Connection getConn() {
        return conn;
    }
    
    
    
    
    public static boolean get_Connection() {
    try {
        conn = DriverManager.getConnection(db_url, db_username, db_password);
        Exported_sql.setConn(conn);
        System.out.println("Database connection established successfully.");
        return true;
    } catch (SQLException e) {
        System.err.println("Error while establishing the database connection: " + e.getMessage());
       return false;
    }
     
    
}
    
    public  static String get_name (int id){
        
        String name = "";
        
        try {
             String que = "SELECT names FROM users WHERE user_id = ?";
            
            stm = conn.prepareStatement(que);
            
            stm.setInt(1, id);
            
            ResultSet name_ResultSet = stm.executeQuery();
            
            name_ResultSet.next();
            name = name_ResultSet.getString("names");
            return name;
            
        } catch (Exception e) {
            System.err.println("eorr in get_name \n"+e);
        }
        return name;
    }
    
    public static void get_Imported (TableView<imported_class> Imported_TableView ){
        try {
            Imported_TableView.getItems().clear();
            String que = "select * from imported";
            
            stm = conn.prepareStatement(que);
            
            res_set = stm.executeQuery();
            
            while(res_set.next()){
                int id = res_set.getInt("imported_id");
                String organisation = res_set.getString("organisation");
                int quantity = res_set.getInt("quantity");
                Date temp_date = res_set.getDate("Delivery_date");
                LocalDate date = temp_date.toLocalDate();
                int user_id = res_set.getInt("user_id");
                String user_name = get_name(user_id);
                
                Imported_TableView.getItems().add(new imported_class(id, organisation, new Button("info"), quantity, date, user_id, user_name));
            }
            
            
        } catch (Exception e) {
            System.err.println("eorr in get_Imported \n"+e);
            
        }
    }
    
    
    public  static void Imported_add (ArrayList Imported_data , int total_que ){
        try {
             String que = "INSERT INTO imported (organisation,quantity,Delivery_date,user_id) Values (?,?,?,?)";
             
             String temp_organisation = (String)Imported_data.get(0);
             
             LocalDate temp_date = (LocalDate)Imported_data.get(1);
             Date sqlDate = Date.valueOf(temp_date);
             stm = conn.prepareStatement(que);
             stm.setString(1, temp_organisation);
             stm.setInt(2, total_que);
             stm.setDate(3, sqlDate);
             // fix later
             stm.setInt(4, 1);
             int done = stm.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("erorr in Imported_add \n\n "+e.getMessage());
        }
       
        
    }
    public static int get_Imported_id(){
        try {
            String que = "SELECT MAX(imported_id) AS AUTO_INCREMENT FROM imported";
            stm = conn.prepareStatement(que);
            res_set = stm.executeQuery();
            res_set.next();
            int Imported_id = res_set.getInt("AUTO_INCREMENT");
            return Imported_id;
            
        } catch (Exception e) {
            System.err.println("eror in get_Imported_id "+ e.getMessage());
            
        }
        return 0;
    }
    
    public static void ram_add(ArrayList ram_ArrayList, int imported_id){
        
        try {
            String que = "INSERT INTO ram (DDR_Type,size,quantity,imported_id,user_id) Values (?,?,?,?,?)";
        
        String temp_ddr_type = (String)ram_ArrayList.get(0);
        String temp_size = (String)ram_ArrayList.get(1)+" GB";
        
        int temp_que = Integer.parseInt((String)ram_ArrayList.get(2));
        
        stm = conn.prepareStatement(que);
        stm.setString(1, temp_ddr_type);
        stm.setString(2, temp_size);
        stm.setInt(3, temp_que);
        
        stm.setInt(4, imported_id);
        // fix later
        stm.setInt(5, 1);
        
        int done = stm.executeUpdate();
        } catch (Exception e) {
            System.err.println("eror in ram_add " +e.getMessage());
        }
    }
    
     public static void Hrad_disk_add(ArrayList disk_ArrayList , int imported_id){
         try {
             String que = "INSERT INTO Hrad_disk (Hrad_disk_type,size,quantity,imported_id,user_id) Values (?,?,?,?,?)";
             
             String disk_type = (String) disk_ArrayList.get(0);
             int disk_size_temp = Integer.parseInt((String) disk_ArrayList.get(1));
             String disk_size = disk_size_temp+" GB";
             int dsik_que = Integer.parseInt((String) disk_ArrayList.get(2));
             
             stm = conn.prepareStatement(que);
             
             stm.setString(1, disk_type);
             stm.setString(2, disk_size);
             stm.setInt(3, dsik_que);
             stm.setInt(4, imported_id);
             // fix later
             stm.setInt(5, 1);
             
             int done = stm.executeUpdate();
             
             
         } catch (Exception e) {
             System.err.println(" erorr in Hrad_disk_add ");
         }
    }
     
     // if any ram have same imported_id will show it in category_ChoiceBox in class Imported_category_stage_Con
     public static boolean Hrad_disk_category_check(int Imported_id_val){
         
         try {
             String que = "select imported_id from Hrad_disk WHERE imported_id = ?";
             stm = conn.prepareStatement(que);
             stm.setInt(1, Imported_id_val);
             res_set = stm.executeQuery();
             return res_set.next();
             
         } catch (Exception e) {
         }
         return false;
     }
     
      public static void Hrad_disk_category_table(TableView<Hrad_disk_class> disk_TableView , int Imported_id_val){
         
         try {
             String que = "select * from Hrad_disk WHERE imported_id = ?";
             stm = conn.prepareStatement(que);
             stm.setInt(1, Imported_id_val);
             res_set = stm.executeQuery();
             
             while(res_set.next()){
                 int Hrad_disk_id = res_set.getInt("Hrad_disk_id");
                 String Hrad_disk_type = res_set.getString("Hrad_disk_type");
                 String size = res_set.getString("size");
                 int quantity = res_set.getInt("quantity");
                 int imported_id = res_set.getInt("imported_id");
                 int user_id = res_set.getInt("user_id");
                 String user_name = get_name(user_id);
                 disk_TableView.getItems().add(new Hrad_disk_class(Hrad_disk_id, Hrad_disk_type, size, 
                         quantity, imported_id, user_id, user_name));
                 
                 
             }
             
             
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
         
     }
      
      public static void ram_category_table(TableView<ram_class> ram_TableView , int Imported_id_val ){
         
         try {
             String que = "select * from ram WHERE imported_id = ?";
             stm = conn.prepareStatement(que);
             stm.setInt(1, Imported_id_val);
             res_set = stm.executeQuery();
             
             while(res_set.next()){
                 int ram_id = res_set.getInt("ram_id");
                 String DDR_Type = res_set.getString("DDR_Type");
                 String size = res_set.getString("size");
                 int quantity = res_set.getInt("quantity");
                 int imported_id = res_set.getInt("imported_id");
                 int user_id = res_set.getInt("user_id");
                 String user_name = get_name(user_id);
                 ram_TableView.getItems().add(new ram_class(ram_id, DDR_Type, size, quantity, imported_id, user_id, user_name));
                 
             }
             
             
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
        
     }
     
     public static boolean ram_category_check(int Imported_id_val){
         
         try {
             String que = "select imported_id from ram WHERE imported_id = ?";
             stm = conn.prepareStatement(que);
              stm.setInt(1, Imported_id_val);
             res_set = stm.executeQuery();
             return res_set.next();
             
         } catch (Exception e) {
         }
         return false;
     }
    
    
}
