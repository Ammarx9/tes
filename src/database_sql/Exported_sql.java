/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database_sql;


import database_data.*;
import static database_sql.sql_code.get_name;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class Exported_sql {
    
     private static PreparedStatement stm = null;
      private static ResultSet res_set = null;
    
    
    private static Connection  conn;

//    public Exported_sql() {
//        this.conn = sql_code.getConn();
//    }

    public static void setConn(Connection conn) {
        Exported_sql.conn = conn;
    }
    
    public static int get_Exported_id(){
        try {
            String que = "SELECT MAX(Exported_id) AS AUTO_INCREMENT FROM exported";
            stm = conn.prepareStatement(que);
            res_set = stm.executeQuery();
            res_set.next();
            int Imported_id = res_set.getInt("AUTO_INCREMENT");
            return Imported_id;
            
        } catch (Exception e) {
            System.err.println("eror in get_Exported_id "+ e.getMessage());
            
        }
        return 0;
    }
    
     public  static void Exported_add (ArrayList exoported_ArrayList , int total_que ){
        try {
             String que = "INSERT INTO exported (organisation,quantity,date,user_id) Values (?,?,?,?)";
             
             String temp_organisation = (String)exoported_ArrayList.get(0);
             
             LocalDate temp_date = (LocalDate)exoported_ArrayList.get(1);
             Date sqlDate = Date.valueOf(temp_date);
             stm = conn.prepareStatement(que);
             stm.setString(1, temp_organisation);
             stm.setInt(2, total_que);
             stm.setDate(3, sqlDate);
             // fix later
             stm.setInt(4, 1);
             int done = stm.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("erorr in Exported_add \n\n "+e.getMessage());
        }
       
        
    }
    //done
    public static void Imported_que_emty (){
        try {
            String sql = "DELETE FROM imported where quantity =0";
            
            stm = conn.prepareStatement(sql);
            
//            stm.setInt(1, Imported_id);
            stm.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            System.err.println("Imported_que_emty method err\n"+e.getMessage());
        }
    }
    
    
    
    
    //done
     public static void Imported_que_del (int quenty , int Imported_id ){
        try {
            String sql = "UPDATE Imported SET quantity = quantity - ? WHERE Imported_id = ?";
            
            stm = conn.prepareStatement(sql);
            stm.setInt(1, quenty);
            int imoprted_id = Imported_id;
            stm.setInt(2, imoprted_id);
            stm.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            System.err.println("Imported_que_del method err\n"+e.getMessage());
        }
    }
     //done
      public static void Hrad_disk_add_exo(ArrayList disk_ArrayList, int Exported_id){
         try {
             String que = "INSERT INTO Hrad_disk_exported (Hrad_disk_type,size,quantity,exported_id,user_id) Values (?,?,?,?,?)";
             
             String disk_type = (String) disk_ArrayList.get(1);
             String disk_size_temp = (String) disk_ArrayList.get(2);
             String disk_size = disk_size_temp+" GB";
             int dsik_que = (Integer) disk_ArrayList.get(3);
             
             stm = conn.prepareStatement(que);
             
             stm.setString(1, disk_type);
             stm.setString(2, disk_size);
             stm.setInt(3, dsik_que);
             stm.setInt(4, Exported_id);
             // fix later
             stm.setInt(5, 1);
             
             int done = stm.executeUpdate();
             
             
         } catch (Exception e) {
             System.err.println(" erorr in Hrad_disk_add_exo \n "+e.getMessage());
         }
    }
     //done
     public static void ram_add_exo(ArrayList ram_ArrayList, int Exported_id){
        
        try {
            String que = "INSERT INTO ram_exported (DDR_Type,size,quantity,exported_id,user_id) Values (?,?,?,?,?)";
        
        String temp_ddr_type = (String)ram_ArrayList.get(1);
        String temp_size = (String)ram_ArrayList.get(2)+" GB";
        
        int temp_que = (Integer)ram_ArrayList.get(3);
        
        stm = conn.prepareStatement(que);
        stm.setString(1, temp_ddr_type);
        stm.setString(2, temp_size);
        stm.setInt(3, temp_que);
        
        stm.setInt(4, Exported_id);
        // fix later
        stm.setInt(5, 1);
        
        int done = stm.executeUpdate();
        } catch (Exception e) {
            System.err.println("eror in ram_add_exo " +e.getMessage());
        }
    }
    
    
    //done
    public static void ram_que_del (ArrayList ram_ArrayList ){
        try {
            String sql = "UPDATE ram SET quantity = quantity - ? WHERE ram_id = ?";
            
            stm = conn.prepareStatement(sql);
            stm.setInt(1, (Integer)ram_ArrayList.get(3));
            stm.setInt(2, (Integer)ram_ArrayList.get(0));
            stm.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            System.err.println("ram_que_del method err\n"+e.getMessage());
        }
    }
    
    public static void disk_que_del (ArrayList disk_ArrayList ){
        try {
            String sql = "UPDATE Hrad_disk SET quantity = quantity - ? WHERE Hrad_disk_id = ?";
            
            stm = conn.prepareStatement(sql);
            stm.setInt(1, (Integer)disk_ArrayList.get(3));
            stm.setInt(2, (Integer)disk_ArrayList.get(0));
            stm.executeUpdate();
            
            
            
            
        } catch (Exception e) {
            System.err.println("disk_que_del method err\n"+e.getMessage());
        }
    }
    
    
    
    
    
    
    public static void ram_get_Exported(TableView<ram_class> ram_TableView){
        
        try {
             String que = "select * from ram";
             stm = conn.prepareStatement(que);
             
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
    
    public static  void disk_get_Exported(TableView<Hrad_disk_class> disk_TableView){
        
        try {
             String que = "select * from Hrad_disk";
             stm = conn.prepareStatement(que);
             
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
    
    
}
