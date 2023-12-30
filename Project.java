/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class Project {
   static int id =0;
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        System.out.println(dbconnection());
        System.out.println(returnid());
        System.out.println(returnid());
    }

    /**
     * @param args the command line arguments
     */
    public static Connection dbconnection() throws ClassNotFoundException, SQLException {
     Connection c=null;
        try{
        String user ="root";
        String password ="mir@emma101";
        String url = "jdbc:mysql://localhost:3306/mir";
        Class.forName("com.mysql.cj.jdbc.Driver");
         c = DriverManager.getConnection(url,user,password);   
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
         return c;
    }
    public static int returnid(){
        return id+1;
    }
    public static DB getDB(){
        DB db = null;
        MongoClient mongoClient  = new MongoClient( "localhost" , 27017 );
        //create database / if already created just get that database
        db = mongoClient.getDB("project");
        return db;

    }
}
