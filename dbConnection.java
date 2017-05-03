/**
 * Created by user on 19/04/2017.
 */
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.*;

    public class dbConnection extends JFrame{
        JLabel JL_fname,JL_lname,JL_TimeDate,JL_RecordingOfName;
        JTextField JT_fname,JT_lname,JT_TimeDate,JT_RecordingOfName;
        JButton btn_insert,btn_Change,btn_delete,btn_Webpage;


        public dbConnection(){
            super("DECLAN NEE FYP");
            JL_RecordingOfName = new JLabel("Recording Name:");
            JL_fname = new JLabel("Fname:");
            JL_lname = new JLabel("Lname:");
            JL_TimeDate = new JLabel("Date/Time");
            JL_RecordingOfName.setBounds(20, 20, 100, 20);
            JL_fname.setBounds(20, 50, 100, 20);
            JL_lname.setBounds(20, 80, 100, 20);
            JL_TimeDate.setBounds(20, 110, 100, 20);

            JT_RecordingOfName = new JTextField(20);
            JT_fname = new JTextField(20);
            JT_lname = new JTextField(20);
            JT_TimeDate = new JTextField(20);
            JT_RecordingOfName.setBounds(130,20,150,20);
            JT_fname.setBounds(130, 50, 150, 20);
            JT_lname.setBounds(130, 80, 150, 20);
            JT_TimeDate.setBounds(130, 110, 150, 20);
            btn_insert = new JButton("Insert");
            btn_Change = new JButton("Change");
            btn_delete = new JButton("Delete");
            btn_Webpage = new JButton("Webpage");
            btn_insert.setBounds(300, 50, 90, 20);
            btn_Change.setBounds(300, 80, 90, 20);
            btn_delete.setBounds(300, 110, 90, 20);
            btn_Webpage.setBounds(300, 140, 90, 20);


            setLayout(null);
            add(JL_RecordingOfName);
            add(JL_fname);
            add(JL_lname);
            add(JL_TimeDate);
            add(JT_RecordingOfName);
            add(JT_fname);
            add(JT_lname);
            add(JT_TimeDate);
            add(btn_insert);
            add(btn_Change);
            add(btn_delete);
            add(btn_Webpage);

            //button insert
            btn_insert.addActionListener(new  ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try{
                        insertDb(JT_RecordingOfName.getText().toString(),JT_fname.getText().toString(),JT_lname.getText().toString()
                                ,JT_TimeDate.getText().toString());
                    }
                    catch(Exception ex){}
                }
            });

            //button change
            btn_Change.addActionListener(new  ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try{
                        String rec = JT_RecordingOfName.getText().toString();
                        String name = JT_fname.getText().toString();
                        changeDb(rec,name);
                    }
                    catch(Exception ex){}
                }
            });

            //button delete
            btn_delete.addActionListener(new  ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try{
                        String name = JT_fname.getText().toString();
                        deleteDb(name);

                    }
                    catch(Exception ex){}
                }
            });

            btn_Webpage.addActionListener(new  ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try{

                        String URL = "file:///C:/Users/user/Documents/College%20work/Year%204/Project/Project/Website/FinalWebsite.html#toc/";
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
                    }
                    catch(Exception ex){}
                }
            });



            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLocationRelativeTo(null);
            setSize(500,200);

        }

        public void insertDb(String rec,String first,String last,String time){
            try {
                Class.forName("com.mysql.jdbc.Driver");  // load the driver
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recorder", "root", "root");
                String query = "insert into data(recording1,firstname,lastname,time_date)" + "values(?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,rec);
                preparedStatement.setString(2,first);
                preparedStatement.setString(3,last);
                preparedStatement.setString(4,time);
                preparedStatement.execute();
                con.close();

            }catch(Exception io){

            }
        }
        public void changeDb(String rec,String first){
            try {
                Class.forName("com.mysql.jdbc.Driver");  // load the driver
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recorder", "root", "root");
                String query = "update data set recording1 = ? where firstname = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,rec);
                preparedStatement.setString(2,first);

                preparedStatement.execute();
                con.close();

            }catch(Exception io){

            }
        }

        public void deleteDb(String name){
            try {
                Class.forName("com.mysql.jdbc.Driver");  // load the driver
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recorder", "root", "root");
                String query = "delete from data where firstname = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.execute();
                con.close();

            }catch(Exception io){

            }
        }

        public static void main(String[] args){

            new  dbConnection();
        }
    }