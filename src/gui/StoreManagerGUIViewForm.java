package gui;

import controller.Backend_DAO_List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagerGUIViewForm {
        private JButton AddCustomer;
        private JPanel Home;
        private JButton Products;
        private JButton NewOrder;
        private JButton Orders;




    public StoreManagerGUIViewForm() {

            AddCustomer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddCustomer form = null;
                    try {
                        form = new AddCustomer();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    form.setVisible(true);
                }
            });
            Products.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("ManageCatalogForm");
                    frame.setContentPane(new ManageCatalogForm().panel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
            Orders.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            NewOrder.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });



        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("חנות מחשבים");
            frame.setContentPane(new StoreManagerGUIViewForm().Home);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setPreferredSize(new Dimension(1000, 1000));
            frame.pack();
            frame.setVisible(true);
        }
    }

