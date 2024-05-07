package gui;

import controller.Backend_DAO_List;
import model.HardwareProduct;
import model.Product;
import model.ProductType;
import model.SoftwareProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddNewProductForm extends Component {

    private JLabel jname;
    private JLabel jpricePerUnit;
    private JLabel jdescription;

    private JTextField jnameText;
    private JTextField jdescriptionText;
    private JTextField jpricePerUnitText;
    public JPanel panel;
    private JButton jbuttonOk;
    private JComboBox<ProductType> cmbType;
    private JLabel jtype;
    private JLabel jLabltype;
    private JTextField jtextTpe;

    Backend_DAO_List bdl = Backend_DAO_List.get();




    public AddNewProductForm(ManageCatalogForm m){
        DefaultComboBoxModel<ProductType> model = new DefaultComboBoxModel(ProductType.values());
        cmbType.setModel(model);

          jtextTpe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (!Character.isDigit(e.getKeyChar()) || jtextTpe.getText().length()>=5)
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
          jpricePerUnitText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (!Character.isDigit(e.getKeyChar()) )
                    e.consume();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
          cmbType.setSelectedIndex(0);
          cmbType.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  jLabltype.setText(isInHardwareMode()?"תקופת אחריות":"מספר משתמשים");
              }
          });
         jbuttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Product product=null;
                    if (jnameText.getText().isBlank())
                        throw new Exception("חובה להכניס שם מוצר");

                    if(isInHardwareMode()){
                        product= new HardwareProduct(jnameText.getText(), jdescription.getText(),Float.parseFloat(jpricePerUnitText.getText()),Integer.parseInt(jtextTpe.getText()));

                    }
                    else {
                        product= new SoftwareProduct( jnameText.getText(), jdescription.getText(),Float.parseFloat(jpricePerUnitText.getText()),Integer.parseInt(jtextTpe.getText()));

                    }
                    bdl.AddProduct(product);
                    m.RefreshProductList();

                    JOptionPane.showMessageDialog(AddNewProductForm.this,"הלקוח התווסף בהצלחה");
                    System.out.println(bdl.getAllProducts());
                    System.out.println(product);
                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(AddNewProductForm.this,ex.getMessage());
                }
            }
        });

    }

    private boolean isInHardwareMode()
    {
        return cmbType.getSelectedItem().equals(ProductType.HARDWARE);
    }

}
