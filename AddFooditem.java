package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFooditem extends JFrame implements ActionListener {
    JButton SaveProduct, Cancel ,Back;
    JLabel l1, l2, l3, l4, l5;
    JTextField ProductName, CostPerUnit, CompanyName, Type;

    int labX = 280;
    int labW = 280;
    int labH = 40;

    Font f1 = new Font("Tahoma", Font.PLAIN, 17);

    AddFooditem() {
        setSize(700, 580);

        //labels
        l1 = new JLabel("Product Name");
        l1.setBounds(50, 130, 200, 50);
        l1.setFont(f1);
        this.add(l1);

        l2 = new JLabel("Cost Per Unit");
        l2.setBounds(50, 200, 200, 50);
        l2.setFont(f1);
        this.add(l2);

        l3 = new JLabel("Company Name");
        l3.setBounds(50, 260, 200, 50);
        l3.setFont(f1);
        this.add(l3);

        l4 = new JLabel("Type");
        l4.setBounds(50, 330, 200, 50);
        l4.setFont(f1);
        this.add(l4);

        l5 = new JLabel("  Product Management  ");
        l5.setBounds(250, 50, 300, 60);
        l5.setFont(f1);
        this.add(l5);


        //TextFeild

        ProductName = new JTextField();
        ProductName.setBounds(labX, 130, labW, labH);
        ProductName.setFont(f1);
        this.add(ProductName);

        CostPerUnit = new JTextField();
        CostPerUnit.setBounds(labX, 200, labW, labH);
        CostPerUnit.setFont(f1);
        this.add(CostPerUnit);

        CompanyName = new JTextField();
        CompanyName.setBounds(labX, 260, labW, labH);
        CompanyName.setFont(f1);
        this.add(CompanyName);

        Type = new JTextField();
        Type.setBounds(labX, 320, labW, labH);
        Type.setFont(f1);
        this.add(Type);


        //JButton
        SaveProduct = new JButton("Save Product");
        SaveProduct.setBounds(180, 440, 120, 50);
        SaveProduct.addActionListener(this);
        add(SaveProduct);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(380, 440, 120, 50);
        Cancel.addActionListener(this);
        add(Cancel);

        Back = new JButton("Back<<");
        Back.setBounds(550, 0, 100, 40);
        Back.addActionListener(this);
        add(Back);



        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SaveProduct) {
            String ProductName = this.ProductName.getText();
            String CostPerUnit = this.CostPerUnit.getText();
            String CompanyName = this.CompanyName.getText();
            String Type = this.Type.getText();


            connection c = new connection();
            String str = "insert into fooditem_details (ProductName,CostPerUnit, CompanyName, Type) values('" + ProductName + "','" + CostPerUnit + "','" + CompanyName + "','" + Type + "');";

            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Product Added Successfully !!");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (ae.getSource() == Back) {
            new dashboard();
            this.setVisible(false);
        }
        if (ae.getSource() == Cancel) {
            new dashboard();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddFooditem();
    }
}
