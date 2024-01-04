import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class form2 {

        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel("Account Details");
        JLabel jLabel1 = new JLabel("Account Type:");
        JRadioButton jRadioButton = new JRadioButton("Saving Account");
        JRadioButton jRadioButton1 = new JRadioButton("Fixed Deposit Account");
        JRadioButton jRadioButton2 = new JRadioButton("Current Account");
        JRadioButton jRadioButton3 = new JRadioButton("Recurring Deposit Account");
        JLabel jLabel2 = new JLabel("Card Number:");
        JLabel jLabel4 = new JLabel("PIN:");
        JLabel jLabel5 = new JLabel("XXXX");
        JLabel jLabel3 = new JLabel("XXXX-XXXX-XXXX-4184");
        JLabel jLabel6 = new JLabel("Service Required:");
        JCheckBox jCheckBox = new JCheckBox("ATM Card");
        JCheckBox jCheckBox1 = new JCheckBox("Internet Banking");
        JCheckBox jCheckBox2 = new JCheckBox("Mobile Banking");
        JCheckBox jCheckBox4 = new JCheckBox("Cheque Book");
        JButton jButton = new JButton("Submit");
        ButtonGroup buttonGroup = new ButtonGroup();
        form2() {
            jFrame.add(jButton);
            jFrame.add(jCheckBox);
            jFrame.add(jCheckBox1);
            jFrame.add(jCheckBox2);
            jFrame.add(jCheckBox4);
            jFrame.add(jRadioButton1);
            jFrame.add(jRadioButton3);
            jFrame.add(jRadioButton2);
            jFrame.add(jRadioButton);
            jFrame.add(jLabel1);
            jFrame.add(jLabel);
            buttonGroup.add(jRadioButton);
            buttonGroup.add(jRadioButton1);
            buttonGroup.add(jRadioButton2);
            buttonGroup.add(jRadioButton3);
            jFrame.add(jLabel2);
            jFrame.add(jLabel3);
            jFrame.add(jLabel4);
            jFrame.add(jLabel5);
            jFrame.add(jLabel6);
            jCheckBox.setBounds(60, 300, 81, 22);
            jCheckBox1.setBounds(230, 333, 119, 22);
            jCheckBox2.setBounds(60, 333, 113, 22);
            jCheckBox4.setBounds(230, 300, 103, 22);
            jLabel6.setBounds(60, 270, 110, 22);
            jLabel5.setBounds(220, 230, 40, 22);
            jLabel4.setBounds(60, 230, 30, 22);
            jLabel3.setBounds(220, 190, 140, 22);
            jLabel2.setBounds(60, 190, 80, 22);
            jRadioButton.setBounds(60, 120, 120, 22);
            jRadioButton1.setBounds(220, 120, 160, 22);
            jRadioButton2.setBounds(60, 150, 120, 22);
            jRadioButton3.setBounds(220, 150, 180, 22);
            jLabel1.setBounds(60, 89, 210, 22);
            jLabel.setBounds(175, 20, 210, 22);
            jButton.setBounds(250,380,80,22);
            jFrame.setLayout(null);
            jFrame.setSize(500, 500);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

            // logic
           jButton.addActionListener(new AbstractAction() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   Random random = new Random();
                   BigInteger random16 = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(1000000000000000L, 10000000000000000L));
                   int randomNumber = random.nextInt((int) Math.pow(10, 16));
                   String randomNumberString = String.valueOf(randomNumber);
                   randomNumberString = String.format("%016d", randomNumber);
                   Random rand = new Random();
                   int randomNumber1 = rand.nextInt(10000);
                   String fourDigitRandomNumber = String.format("%04d", randomNumber1);
                   try {
                       Class.forName("com.mysql.cj.jdbc.Driver");
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","AK_shay2666");
                       Statement stm = conn.createStatement();
                       int result = stm.executeUpdate("insert into atm (card_no,pin) values ("+random16+","+fourDigitRandomNumber+")");
                       JOptionPane.showMessageDialog(null,"card Number:"+random16 +"\nYour Pin:"+fourDigitRandomNumber);
                       jFrame.dispose();
                       transaction transaction = new transaction(random16);
                   }catch (Exception e1){
                       System.out.println("Error is:"+e1);
                   }

               }
           });
        }
    }
