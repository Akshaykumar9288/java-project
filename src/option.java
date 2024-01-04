import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;

public class option {

        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel("Please Select Your Transaction");
        JButton jButton = new JButton("DEPOSIT");
        JButton jButton1 = new JButton("WITHDRAWAL");
        JButton jButton2 = new JButton("Balance Enquiry");
        JButton jButton3 = new JButton("Pin Change");
        option(BigInteger random16){
        jFrame.add(jLabel);
        jFrame.add(jButton);
        jFrame.add(jButton1);
        jFrame.add(jButton2);
        jFrame.add(jButton3);
        jLabel.setBounds(125, 20, 210, 22);
        jButton.setBounds(100,100,89,22);
        jButton1.setBounds(250,150,115,22);
        jButton2.setBounds(90,150,126,22);
        jButton3.setBounds(250,100,115,22);

        jFrame.setLayout(null);
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        jButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        transaction transaction = new transaction(random16);
                        jFrame.dispose();
                }
        });
        jButton1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        withdrawal withdrawal =  new withdrawal(random16);
                        jFrame.dispose();
                }
        });
        jButton2.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        Balance_Enquiry balanceEnquiry = new Balance_Enquiry(random16);
                        jFrame.dispose();
                }
        });
        jButton3.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        pin_change pinChange = new pin_change(random16);
                        jFrame.dispose();
                }
        });
    }


}
