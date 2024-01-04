import javax.swing.*;
import java.awt.event.ActionEvent;

public class form1 {
    String religion [] = {"Other","Hindu","Muslim","Sikh","Christan"};
    String category [] = {"Other","General","OBC","SC","ST"};
    String income [] = {"Null","<1,50,000","<2,00,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
    String Education [] = {"Non-Graduation","Graduation","Post-Graduation","Diploma"};
    String occupation [] = {"Other","Salaried","Self-Employee","Business","Student"};
        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel("Additional Details:");
        JLabel jLabel1 = new JLabel("Religion");
        JLabel jLabel2 = new JLabel("Category:");
        JLabel jLabel3 = new JLabel("Income:");
        JLabel jLabel4 = new JLabel("Education " + "Qualification:");
        JLabel jLabel5 = new JLabel("Occupation:");
        JLabel jLabel6 = new JLabel("PAN Number:");
        JLabel jLabel7 = new JLabel("Aadhar Number");
        JButton jButton = new JButton("Next");
        JComboBox jTextField = new JComboBox(religion);
        JComboBox jTextField1 = new JComboBox(category);
        JComboBox jTextField2 = new JComboBox(income);
        JComboBox jTextField3 = new JComboBox(Education);
        JComboBox jTextField4 = new JComboBox(occupation);
        JTextField jTextField5 = new JTextField();
        JTextField jTextField6 = new JTextField();
        form1() {
            jFrame.add(jButton);
            jFrame.add(jTextField);
            jFrame.add(jTextField1);
            jFrame.add(jTextField2);
            jFrame.add(jTextField3);
            jFrame.add(jTextField4);
            jFrame.add(jTextField5);
            jFrame.add(jTextField6);
            jFrame.add(jLabel7);
            jFrame.add(jLabel6);
            jFrame.add(jLabel5);
            jFrame.add(jLabel4);
            jFrame.add(jLabel3);
            jFrame.add(jLabel2);
            jFrame.add(jLabel1);
            jFrame.add(jLabel);
            jButton.setBounds(307, 370, 80, 22);
            jTextField.setBounds(230, 85, 210, 22);
            jTextField1.setBounds(230, 113, 210, 22);
            jTextField2.setBounds(230, 140, 210, 22);
            jTextField3.setBounds(230, 170, 210, 22);
            jTextField4.setBounds(230, 200, 210, 22);
            jTextField5.setBounds(230, 230, 210, 22);
            jTextField6.setBounds(230, 260, 210, 22);
            jLabel7.setBounds(60, 260, 210, 22);
            jLabel6.setBounds(60, 230, 210, 22);
            jLabel5.setBounds(60, 200, 210, 22);
            jLabel4.setBounds(60, 170, 210, 22);
            jLabel3.setBounds(60, 140, 210, 22);
            jLabel2.setBounds(60, 114, 210, 22);
            jLabel1.setBounds(60, 89, 210, 22);
            jLabel.setBounds(175, 20, 210, 22);
            jFrame.setLayout(null);
            jFrame.setSize(500, 500);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.isEditable() || jTextField1.isEditable() || jTextField2.isEditable()|| jTextField3.isEditable() ||
                        jTextField4.isEditable() || jTextField5.getText().isBlank() || jTextField6.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Fill All Information");
                } else if (jTextField6.getText().matches("[a-zA-Z]+") || jTextField6.getText().length() > 16 || jTextField6.getText().length() < 16) {
                    JOptionPane.showMessageDialog(null, "Enter Correct Aadhar Number");
                }else {
                    jFrame.dispose();
                    form2 form2 = new form2();
                }
            }
        });
        }
        }


