import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame {


    public static void main(String[] args) {
        login frameTabel = new login();

    }

    JButton login = new JButton("Login");
    JPanel panel = new JPanel();
    JTextField user = new JTextField(20);
    JPasswordField passwrd = new JPasswordField(20);


    login(){
        super("DECLAN NEE FYP LOGIN");
        setSize(350,200);
        setLocation(500,280);
        panel.setLayout(null);

        user.setBounds(100,30,150,20);
        passwrd.setBounds(100,65,150,20);
        login.setBounds(130,100,80,20);

        panel.add(login);
        panel.add(user);
        panel.add(passwrd);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
    }

    public void actionlogin(){
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String username = user.getText();
                String password = passwrd.getText();
                if(username.equals("declan") && password.equals("dec1993")) {
                    MicApp regFace =new MicApp();
                    regFace.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null,"Wrong Password / Username");
                    user.setText("");
                    passwrd.setText("");
                    user.requestFocus();
                }

            }
        });
    }
}