package canteenmanagementsystem;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;
    public class connection {
        Connection c;
        Statement s;
        connection(){
            String url ="jdbc:mysql://localhost:3306/canteenmanagemntsys";
            String username ="root";
            String password ="Sali@123";

            try{
                c = DriverManager.getConnection(url,username,password);
                s =c.createStatement();
            }
            catch(Exception e){
                System.out.println("e");
            }
        }

        public static void main(String[] args) {
            new canteenmanagementsystem.connection();
        }
    }


