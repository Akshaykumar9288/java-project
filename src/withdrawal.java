import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class withdrawal {
    JFrame jFrame = new JFrame();
    JLabel jLabel = new JLabel("Enter Amount You Want To Withdrawal");
    JTextField jTextField = new JTextField();
    JButton jButton = new JButton("Withdrawal");
    JButton jButton1 = new JButton("Back");

    withdrawal(BigInteger random16){
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(jButton1);
        jButton1.setBounds(350,350,89,22);
        jButton.setBounds(350,380,97,22);
        jLabel.setBounds(125, 20, 210, 22);
        jTextField.setBounds(125, 50, 210, 22);
        jFrame.setLayout(null);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().matches("[a-zA-Z]+")){
                    JOptionPane.showMessageDialog(null,"Enter Only Amount");
                }else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","AK_shay2666");
                        Statement stm = conn.createStatement();
                        int amount = Integer.parseInt(jTextField.getText());
                        ResultSet resultSet = stm.executeQuery("select * from atm where card_no = "+ random16);
                        while (resultSet.next()){
                            if (amount > resultSet.getInt("RS")){
                                JOptionPane.showMessageDialog(null,"Insuffient Balance");

                            }else {
                                int result = stm.executeUpdate("update atm set RS = RS -"+amount+" where card_no = "+ random16);
                                JOptionPane.showMessageDialog(null,"Your Amount Withdrawal Successfully");
                                option option = new option(random16);
                                jFrame.dispose();
                            }
                        }

//                        jFrame.dispose();
//                        option option = new option(random16);
                    }catch (Exception e1){
                        System.out.println("Error is :"+e1);
                    }

                }
            }
        });
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                option option = new option(random16);
            }
        });
    }
}
