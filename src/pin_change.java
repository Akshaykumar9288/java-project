import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class pin_change {
    JFrame jFrame = new JFrame();
    JLabel jLabel = new JLabel("Pin Change");
    JTextField jTextField = new JTextField();
    JButton jButton = new JButton("Pin Change");
    JButton jButton1 = new JButton("Back");

    pin_change(BigInteger random16) {
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(jButton1);
       jButton1.setBounds(350,350,89,22);
        jButton.setBounds(350, 380, 100, 22);
        jLabel.setBounds(125, 20, 210, 22);
        jTextField.setBounds(125, 50, 210, 22);
        jFrame.setLayout(null);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(null, "Enter Only pin");
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "AK_shay2666");
                        Statement stm = conn.createStatement();
                        int pin = Integer.parseInt(jTextField.getText());
                        int result = stm.executeUpdate("update atm set pin = " +pin+ " where card_no = " + random16);
                        JOptionPane.showMessageDialog(null, "Your Pin Updated Successfully");
                        jFrame.dispose();
                        option option;

                    } catch (Exception e1) {

                    }
                }
            }

        });
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option option1 = new option(random16);
                jFrame.dispose();
            }
        });
    }}

