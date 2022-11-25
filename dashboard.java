package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JButton AddFooditem, AddSells, Fooditemreport, Salesdetail, Logout;

    JLabel l5;
    Font f1 = new Font("Tahoma", Font.BOLD, 25);
    dashboard() {
        setSize(700, 500);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/screenshort.png"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(150,60,550,450);
        add(i3);

        mb = new JMenuBar();
        mb.setBounds(0, 0, 150, 450);
       // mb.setBackground(Color.getColor("white", 40));
        mb.setLayout(new GridLayout(5, 1, 0, 15));
        add(mb);

        AddFooditem = new JButton("Add Food Item");
        mb.add(AddFooditem);
        AddFooditem.addActionListener(this);
        add(mb);

        AddSells = new JButton("Add Sales");
        mb.add(AddSells);
        AddSells.addActionListener(this);
        add(mb);

        Fooditemreport = new JButton("Food Item Report");
        mb.add(Fooditemreport);
        Fooditemreport.addActionListener(this);
        add(mb);

        Salesdetail = new JButton("Sales Detail");
        mb.add(Salesdetail);
        Salesdetail.addActionListener(this);
        add(mb);

        Logout = new JButton("Logout");
        mb.add(Logout);
        Logout.addActionListener(this);
        add(mb);


        l5 = new JLabel("  Canteen Management System ");
        l5.setBounds(200, 0, 450, 70);
        l5.setFont(f1);
        l5.setBackground(Color.getColor("white", 100));
        this.add(l5);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==AddFooditem){
            new AddFooditem();
            this.setVisible(false);
        }
        if(ae.getSource()==AddSells){
            new AddSells();
            this.setVisible(false);
        }
        if(ae.getSource()==Fooditemreport){
            new Fooditemreport();
            this.setVisible(false);
        }
        if(ae.getSource()==Salesdetail){
            new Selesdetail();
            this.setVisible(false);
        }
        if(ae.getSource()==Logout){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new dashboard();
    }

}