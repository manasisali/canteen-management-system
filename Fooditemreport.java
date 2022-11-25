package canteenmanagementsystem;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Fooditemreport extends JFrame implements ActionListener {
    JButton Back;
    JTable t1;
    JScrollPane sp1;

    Font f1 = new Font("Tahoma",Font.PLAIN,15);
    Fooditemreport() {
        setSize(600, 650);

        sp1 = new JScrollPane();
        sp1.setBounds(50, 50, 500, 300);
        sp1.setFont(f1);
        this.add(sp1);

        Back = new JButton("Back<<");
        Back.setBounds(400, 500, 100, 40);
        Back.addActionListener(this);
        add(Back);


        t1 = new JTable();
        t1.setFont(f1);
        sp1.setViewportView(t1);
        try {
            connection c = new connection();
            String str = "Select ProductName, CostPerUnit, CompanyName, Type from fooditem_details;";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));


        } catch (Exception e) {
            System.out.println(e);
        }


        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Back) {
            new dashboard();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Fooditemreport();
    }

}