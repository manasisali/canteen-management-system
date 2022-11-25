package canteenmanagementsystem;

//import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener{

    JButton Login,Cancel;
    JLabel l1,l2,l3;
    JTextField Username;
    JPasswordField password;

    Font f1 = new Font("Tahoma",Font.PLAIN,20);

    login() {

        setSize(600,400);



        //JButton

        Login = new JButton("Login");
        Login.setBounds(120,260,120,50);
        Login.addActionListener(this);
        Login.setFont(f1);
        add(Login);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(300,260,120,50);
        Cancel.addActionListener(this);
        Cancel.setFont(f1);
        add(Cancel);


        //JLabel

        l1 = new JLabel("Username");
        l1.setBounds(80,80,150,50);
        l1.setFont(f1);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(80,160,200,50);
        l2.setFont(f1);
        add(l2);

        l3= new JLabel("  CANTEEN MANAGEMENT SYSTEM  ");
        l3.setBounds(150,10,350,60);
        l3.setFont(f1);
        this.add(l3);

        //textfeild

        Username = new JTextField();
        Username.setBounds(220,80,150,50);
        Username.setFont(f1);
        add(Username);

        password = new JPasswordField();
        password.setBounds(220,160,150,50);
        password.setFont(f1);
        add(password);

        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Login){
            String username = this.Username.getText();
            String password = String.valueOf(this.password.getPassword());
            connection c = new connection();
            try{
                String str1 = "select * from login where username = '"+username+"' and password ='"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successfully");
                    new dashboard();
                    this.setVisible(false);
                }
                else{JOptionPane.showMessageDialog(null,"Invalid credentials!");

               }
            }
            catch(Exception e){
                    System.out.println(e);
                }
            }
        if(ae.getSource()==Cancel){
            System.exit(0);
        }

        }

    public static void main(String[] args) {
        new login();
    }
}
