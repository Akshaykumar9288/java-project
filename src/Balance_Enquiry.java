import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Balance_Enquiry {
    JFrame jFrame = new JFrame();
    JLabel jLabel = new JLabel("Balance Enquiry");
   // JTextField jTextField = new JTextField();
    JButton jButton = new JButton("Back");
    JLabel jLabel1 = new JLabel();

    Balance_Enquiry(BigInteger random16){
        jFrame.add(jLabel);
     //   jFrame.add(jTextField);
        jFrame.add(jButton);
        jFrame.add(jLabel1);
        jLabel1.setBounds(125, 40, 210, 22);
        jButton.setBounds(350,380,89,22);
        jLabel.setBounds(125, 20, 210, 22);
     //   jTextField.setBounds(125, 50, 210, 22);
        jFrame.setLayout(null);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "AK_shay2666");
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("select * from atm where card_no = " +random16);
            while (result.next()){
                int RS = result.getInt("RS");
                jLabel1.setText("Your Current Balance is :"+RS);
            }
        }catch (Exception e){
            System.out.println("Error is:"+e);
        }
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jFrame.dispose();
               option option = new option(random16);
            }
        });
    }
}
