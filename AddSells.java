package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddSells extends JFrame implements ActionListener{

    JButton AddCustomer, Cancel,  Back;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField CustomerName, MobileNo, product, Quantity,TotalPrice;
    Font f1 = new Font("Tahoma", Font.PLAIN, 17);

    int labX = 300;
    int labW = 280;
    int labH = 40;

    AddSells() {
        setSize(700, 600);

        //JButton

        AddCustomer = new JButton("Save Product");
        AddCustomer.setBounds(240, 450, 120, 50);
        AddCustomer.addActionListener(this);
        add(AddCustomer);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(380, 450, 120, 50);
        Cancel.addActionListener(this);
        add(Cancel);



        Back = new JButton("Back<<");
        Back.setBounds(600, 0, 80, 40);
        Back.addActionListener(this);
        add(Back);


        //JLabels

        l1 = new JLabel("Customer Name");
        l1.setBounds(50, 130, 200, 50);
        l1.setFont(f1);
        this.add(l1);

        l2 = new JLabel("Mobile No.");
        l2.setBounds(50, 200, 200, 50);
        l2.setFont(f1);
        this.add(l2);

        l3 = new JLabel("Product");
        l3.setBounds(50, 260, 200, 50);
        l3.setFont(f1);
        this.add(l3);

        l4 = new JLabel("Quantity");
        l4.setBounds(50, 320, 200, 50);
        l4.setFont(f1);
        this.add(l4);

        l5 = new JLabel("  Customer Details  ");
        l5.setBounds(250, 60, 300, 60);
        l5.setFont(f1);
        this.add(l5);

        l6 = new JLabel("TotalPrice");
        l6.setBounds(50, 380, 200, 50);
        l6.setFont(f1);
        this.add(l6);


        //JTextfelid

        CustomerName = new JTextField();
        CustomerName.setBounds(labX, 130, labW, labH);
        CustomerName.setFont(f1);
        this.add(CustomerName);

        MobileNo = new JTextField();
        MobileNo.setBounds(labX, 200, labW, labH);
        MobileNo.setFont(f1);
        this.add(MobileNo);

        product = new JTextField();
        product.setBounds(labX, 260, labW, labH);
        product.setFont(f1);
        this.add(product);

        Quantity = new JTextField();
        Quantity.setBounds(labX, 320, labW, labH);
        Quantity.setFont(f1);
        this.add(Quantity);

        TotalPrice = new JTextField();
        TotalPrice.setBounds(labX, 380, labW, labH);
        TotalPrice.setFont(f1);
        this.add(TotalPrice);


        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == AddCustomer) {
            String CustomerName = this.CustomerName.getText();
            String MobileNo = this.MobileNo.getText();
            String product = this.product.getText();
            String Quantity = this.Quantity.getText();
            String TotalPrice = this.TotalPrice.getText();


            connection c = new connection();
            String str = "insert into customer_details (CustomerName,MobileNo, product, Quantity,TotalPrice) values('" +CustomerName + "','" + MobileNo+ "','" + product + "','" + Quantity  + "','" + TotalPrice + "');";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully !!");
            }
             catch (Exception e)
                {
                    System.out.println(e);
                }
        }
        if(ae.getSource()==  Back){
            new dashboard();
            this.setVisible(false);
        }
        if(ae.getSource()==Cancel) {
            new dashboard();
            this.setVisible(false);
        }
    }

        public static void main (String[]args){
            new AddSells();
        }


}

