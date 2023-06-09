package Final_v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Class1 implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem CountUsers, ClearData, ShowUsers;
    private JFrame GUI1_Frame, GUI2_Frame;
    private JPanel GUI1_Panel, GUI2_Pnl1, GUI2_Pnl2, GUI2_Pnl3;
    private JLabel GUI1_Label1, GUI1_Label2, GUI2_L_Fahren, GUI2_L_Cels;
    private JTextField GUI1_TF_UserName1, GUI1_TF_Password2, GUI2_TF_Fahren, GUI2_TF_Cels;
    private JButton GUI1_SubmitButton, GUI2_Butt_FtoC, GUI2_Butt_CtoF, Reset;
    private FileReader UN_Read, Pass_Read;
    private BufferedReader UN_BuffRead, Pass_BuffRead;
    private ArrayList<String> Usernames, Passwords;
    int NumofLines = 0;
    boolean _isInfo = false;

    public void m1() {
        GUI1_Frame = new JFrame("Temp Converter");
        GUI1_Panel = new JPanel();
        GUI1_Label1 = new JLabel("User Name:");
        GUI1_Label2 = new JLabel("Password:");
        GUI1_TF_UserName1 = new JTextField();
        GUI1_TF_Password2 = new JTextField();
        GUI1_SubmitButton = new JButton("Submit");
        //
        GUI1_SubmitButton.addActionListener(this);
        //
        GUI1_Panel.add(GUI1_Label1);
        GUI1_Panel.add(GUI1_TF_UserName1);
        GUI1_Panel.add(GUI1_Label2);
        GUI1_Panel.add(GUI1_TF_Password2);
        GUI1_Panel.add(GUI1_SubmitButton);
        //
        GUI1_Frame.setSize(500, 300);
        GUI1_Frame.getContentPane().add(GUI1_Panel);
        GUI1_Panel.setLayout(new GridLayout(3, 2));
        GUI1_Frame.setVisible(true);


    }

    public static void main(String[] arr) {

        Class1 x = new Class1();
        x.m2();
        x.m1();
    }
    public boolean checkpass(String UNPath, String PassPath) throws IOException {
        try {
            UN_Read = new FileReader(UNPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        UN_BuffRead = new BufferedReader(UN_Read);
        try {
            Pass_Read = new FileReader(PassPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Pass_BuffRead = new BufferedReader(Pass_Read);
        boolean _isUN = false;
        boolean _isPass = false;
        //
        String temp;
        Usernames = new ArrayList<String>();
        Passwords = new ArrayList<String>();

        for (int i = 0; (temp = UN_BuffRead.readLine()) != null; i++) {
            temp = UN_BuffRead.readLine();
            NumofLines++;
            Usernames.add(temp);
        }
        for (int i = 0; (temp = Pass_BuffRead.readLine()) != null; i++) {
            temp = Pass_BuffRead.readLine();
            //NumofLines++;
            Passwords.add(temp);
        }
        //

        int i;
        for (i = 0; i < NumofLines; i++) {
            if (Usernames.get(i).equals(GUI1_TF_UserName1.getText())) {
                _isUN = true;
            }
            if (_isUN == true) break;
        }
        if (Passwords.get(i).equals(GUI1_TF_Password2.getText())) {
            _isPass = true;
        }
        return _isPass;
    }

    public void read(String UNPath, String PassPath) throws IOException {

        _isInfo = checkpass(UNPath, PassPath);
        if (_isInfo) {
            m2();
        } else {
            JOptionPane.showMessageDialog(GUI1_Frame, "Error");
        }


    }

    public void m2() {
        menuBar = new JMenuBar();
        menu1 = new JMenu("Menu 1");
        menu2 = new JMenu("Menu 2 ");
        CountUsers = new JMenuItem("Count Users");
        ClearData = new JMenuItem(" Claer Data");
        ShowUsers = new JMenuItem("Show Users");

        GUI2_Frame = new JFrame("Temp COnvereter");
        GUI2_Pnl1 = new JPanel();
        GUI2_Pnl2 = new JPanel();
        GUI2_Pnl3 = new JPanel();
        GUI2_L_Fahren = new JLabel("Fahrenheit:");
        GUI2_L_Cels = new JLabel("Celsius:");
        GUI2_TF_Cels = new JTextField();
        GUI2_TF_Fahren = new JTextField();
        Reset = new JButton("Reset");
        GUI2_Butt_FtoC = new JButton("to Celsius");
        GUI2_Butt_CtoF = new JButton("to Fahrenheit");
        //
        Reset.addActionListener(this);
        GUI2_Butt_FtoC.addActionListener(this);
        GUI2_Butt_CtoF.addActionListener(this);
        ClearData.addActionListener(this);
        CountUsers.addActionListener(this);
        ShowUsers.addActionListener(this);
        //
        menu1.add(CountUsers);
        menu1.add(ShowUsers);
        menu2.add(ClearData);
        menuBar.add(menu1);
        menuBar.add(menu2);

        GUI2_Pnl1.add(menuBar);

        GUI2_Pnl2.add(GUI2_L_Fahren);
        GUI2_Pnl2.add(GUI2_TF_Fahren);
        GUI2_Pnl2.add(GUI2_L_Cels);
        GUI2_Pnl2.add(GUI2_TF_Cels);
        GUI2_Pnl3.add(GUI2_Butt_FtoC);
        GUI2_Pnl3.add(GUI2_Butt_CtoF);
        GUI2_Pnl3.add(Reset);

        GUI2_Pnl1.add(GUI2_Pnl2);
        GUI2_Pnl1.add(GUI2_Pnl3);

        //
        GUI2_Frame.setSize(350, 170);
        GUI2_Pnl1.setLayout(new GridLayout(5, 2));
        GUI2_Pnl2.setLayout(new GridLayout(2, 2));
        GUI2_Pnl3.setLayout(new GridLayout(1, 3));

        GUI2_Frame.getContentPane().add(GUI2_Pnl1);
        GUI2_Frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GUI1_SubmitButton) {
            try {
                read("Usernames.txt", "Passwords.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
//            bool readinfo;
//            check UN(){ if UN found then get i then check pass() return true/ false };
//            check pass(){ if TF  == pass at i then return true else false };
//            _boolAll = check Pass(check UN());
//            if true show GUI2 else errorMsg;

        }
        if (e.getSource() == GUI2_Butt_FtoC) {//to Celsius
            String Fah = GUI2_TF_Fahren.getText();
            double Fahrenheit = +  Double.parseDouble(Fah);
            double Celsius = (Fahrenheit - 32) * (5 / 9);
            String x = String.valueOf(Celsius);
            GUI2_TF_Cels.setText(x);
        }
        if (e.getSource() == GUI2_Butt_CtoF) {// tp Fahrenheit
            String Cel = GUI2_TF_Cels.getText();
            double Celsius = Double.parseDouble(Cel);
            double Fahrenheit = (  Celsius * (9/ 5)) + 32;
            String x = String.valueOf(Fahrenheit);
            GUI2_TF_Fahren.setText(x);
        }
        if (e.getSource() == Reset){
            System.out.println(GUI2_TF_Cels.getText());
            System.out.println(GUI2_TF_Fahren.getText());
            GUI2_TF_Cels.setText("0.00");
            GUI2_TF_Fahren.setText("0.00");
        }
        if (e.getSource() == ClearData){
            FileWriter FW = null;
            try {
                FW = new FileWriter("Usernames.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            BufferedWriter BW = new BufferedWriter(FW);
            FileWriter FW2 = null;
            try {
                FW2 = new FileWriter("Passwords.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            BufferedWriter BW2 = new BufferedWriter(FW2);
            try {
                BW.append("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                BW.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                BW2.append("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                BW2.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == ShowUsers){

        }
        if (e.getSource() == CountUsers){
            JOptionPane.showMessageDialog(GUI2_Frame, NumofLines);
        }
    }
}
