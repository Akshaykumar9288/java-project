import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseDate;
import java.util.Random;

public class form {


JFrame jFrame = new JFrame();
JLabel jLabel = new JLabel();
JLabel jLabel1 = new JLabel();
JLabel jLabel2 = new JLabel();
JLabel jLabel3 = new JLabel();
JLabel jLabel4 = new JLabel();
JLabel jLabel5 = new JLabel();
JLabel jLabel6 = new JLabel();
JLabel jLabel7 = new JLabel();
JLabel jLabel8 = new JLabel();
JLabel jLabel9 = new JLabel();
//Name
JTextField jTextField = new JTextField();
JTextField jTextField1 = new JTextField();
JRadioButton jRadioButton = new JRadioButton("Male");
JRadioButton jRadioButton1 = new JRadioButton("Female");
JTextField jTextField3 =new JTextField();
JRadioButton jRadioButton2 = new JRadioButton("Married");
JRadioButton jRadioButton3 = new JRadioButton("Unmarried");
JTextField jTextField5 = new JTextField();
JTextField jTextField6 = new JTextField();
JTextField jTextField7 = new JTextField();
JTextField jTextField8 = new JTextField();
JButton jButton = new JButton();
ButtonGroup buttonGroup = new ButtonGroup();
ButtonGroup buttonGroup1 = new ButtonGroup();

    form(){
        //for generating random form number
        int number;
        Random random = new Random();
        number = random.nextInt(6);
        //JLabel
        jLabel.setText("APPLICATION FORM NO."+number);
        jLabel1.setText("Name:");
        jLabel2.setText("Father Name:");
        jLabel3.setText("Gender:");
        jLabel4.setText("Email Address:");
        jLabel5.setText("Marital status:");
        jLabel6.setText("Address:");
        jLabel7.setText("City:");
        jLabel8.setText("Pin Code:");
        jLabel9.setText("State:");
        jButton.setText("Next");
        jFrame.add(jLabel);
        jFrame.add(jLabel1);
        jFrame.add(jLabel2);
        jFrame.add(jLabel3);
        jFrame.add(jLabel4);
        jFrame.add(jLabel5);
        jFrame.add(jLabel6);
        jFrame.add(jLabel7);
        jFrame.add(jLabel8);
        jFrame.add(jLabel9);
        jFrame.add(jTextField);
        jFrame.add(jTextField1);
        jFrame.add(jRadioButton);
        jFrame.add(jRadioButton1);
        jFrame.add(jTextField3);
        jFrame.add(jTextField5);
        jFrame.add(jTextField6);
        jFrame.add(jTextField7);
        jFrame.add(jTextField8);
        jFrame.add(jButton);
        jFrame.add(jRadioButton2);
        jFrame.add(jRadioButton3);
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        jButton.setBounds(307,370,80,22);
        jTextField.setBounds(180,85,210,22);
        jTextField1.setBounds(180,110,210,22);
        jRadioButton.setBounds(200,140,60,22);
        jRadioButton1.setBounds(320,140,70,22);
        jTextField3.setBounds(180,170,210,22);
        jRadioButton2.setBounds(320,200,70,22);
        jRadioButton3.setBounds(200,200,84,22);
        jTextField5.setBounds(180,230,210,22);
        jTextField6.setBounds(180,260,210,22);
        jTextField7.setBounds(180,290,210,22);
        jTextField8.setBounds(180,315,210,22);
        jLabel.setBounds(140,20,210,22);
        jLabel1.setBounds(60,89,210,22);
        jLabel2.setBounds(60,110,210,22);
        jLabel3.setBounds(60,140,210,22);
        jLabel4.setBounds(60,170,210,22);
        jLabel5.setBounds(60,200,210,22);
        jLabel6.setBounds(60,230,210,22);
        jLabel7.setBounds(60,260,210,22);
        jLabel8.setBounds(60,290,210,22);
        jLabel9.setBounds(60,315,210,22);
        jFrame.setLayout(null);
                    jFrame.setSize(500,500);
                    jFrame.setVisible(true);
                    jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().isBlank()||jTextField1.getText().isBlank()||jTextField3.getText().isBlank()||
                        jTextField5.getText().isBlank()||jTextField6.getText().isBlank()||jTextField7.getText().isBlank()||
                        jTextField8.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,"Fill all information");
                }else if (jTextField7.getText().matches("[a-zA-Z]+")){
                    JOptionPane.showMessageDialog(null,"Your pin code is incorrect");
                } else{
                    jFrame.dispose();
                    form1 fom = new form1();
                }
            }
        });
    }
}
