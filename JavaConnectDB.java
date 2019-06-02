package imdbFacetSearch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;


/**
 *
 * @author User
 */
public class JavaConnectDB {
    
    public static void CloseConnectionDB(Connection conn){
        try{
            conn.close();
            System.out.println("Connection Closed Successfully");
            return;
        } catch (Exception e) {
            System.out.println("Failed to close connection");
        }
    
    }
    public static Connection ConnectDB(){
        //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        try{
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:orcl","scott","tiger");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system" , "123");
            System.out.println("It connected");
            return conn;
        }
        catch (SQLException e) {
            System.out.println("It did not connect with error" + e.getMessage());
            return null;
        }
    }
    
}
