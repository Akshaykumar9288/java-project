import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;

public  class Main extends JFrame implements ActionListener {
JButton jButton,jButton1,jButton2;
    public Main(){
        // Title
        setTitle("ATM");
        // All Button
         jButton = new JButton("SIGN IN");
         jButton1 = new JButton("CLEAR");
       jButton2 = new JButton("SIGN UP");
       // All label
        JLabel jLabel = new JLabel("WELCOME TO ATM");
        JLabel jLabel1 = new JLabel("Card No:");
        JLabel jLabel2 = new JLabel("PIN:");
        // All textField
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        // Position of textField
        jTextField1.setBounds(160,170,210,22);
        jTextField2.setBounds(160,230,210,22);
        // All label position
        jLabel.setBounds(150,-60,120,200);
        jLabel1.setBounds(80,170,50,22);
        jLabel2.setBounds(80,230,23,22);
        // Button position
        jButton.setBounds(160,300,90,25);
        jButton1.setBounds(280,300,90,25);
        jButton2.setBounds(160,350,210,25);
        // Add all the thing in Frame
        add(jLabel1);
        add(jLabel2);
        add(jButton2);
        add(jButton1);
        add(jTextField1);
        add(jTextField2);
        add(jLabel);
        add(jButton);
        // CLEAR BUTTON
        jButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                jTextField2.setText("");
            }
        });
        // SIGN IN
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   //Connection
                  Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","AK_shay2666");
                   Statement stm = conn.createStatement();
                 //  BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
                   //sql searching
                   if (jTextField1.getText().isBlank()||jTextField2.getText().isBlank()){
                       JOptionPane.showMessageDialog(null,"ALL INFO IS NECESSARY");
                   }
                   if (jTextField1.getText().matches("[a-zA-Z]+")||jTextField2.getText().matches("[a-zA-Z]+")){
                       JOptionPane.showMessageDialog(null,"Enter Only Number");
                   }
                   String card = jTextField1.getText();
                   BigInteger random16 = new BigInteger(card);
                   int num = Integer.parseInt(jTextField2.getText());
                   ResultSet res = stm.executeQuery("select * from atm where card_no = "+random16+" and pin ="+num);
                   // searching operation
                       if(res.next()){
//                           BigInteger CARD_NO = new BigInteger(card);
//                           int PIN = Integer.parseInt(res.getString("pin"));
//                           JOptionPane.showMessageDialog(null,"CARD NO "+CARD_NO+" PIN "+PIN);
                           dispose();
                           option option = new option(random16);
                       }else{
                           JOptionPane.showMessageDialog(null,"Card no or pin is invalid");
                       }
               }catch (Exception e1){
                   System.out.println("Error is "+e1);
               }
            }
        });
        // SIGN UP
        jButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                form fo = new form();
            }
        });
        setLayout(null);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Main ns =  new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}