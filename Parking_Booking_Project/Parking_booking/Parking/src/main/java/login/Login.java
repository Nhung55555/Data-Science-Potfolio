/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;


import java.sql.*;
import java.awt.EventQueue;

/**
 *
 * @author rat
 */
public class Login {
    /**
     * @param args the command line arguments
     */
    
    Connection con;
    
   public void Connect(){
        //connect vô database của mình, nguồn là mysql còn db tên là carregis (db phải in đậm mới xài được)
      
        String url="jdbc:mysql://localhost:3306/parkingbooking2";
        String user="root";
        String password="12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            } 
            catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (SQLException throwables) {
            throwables.printStackTrace();
            }
        
    }
    public static void main(String [] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
   }

        
    
        
}
          
   
       
   

