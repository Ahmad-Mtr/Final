package Final;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class GUI implements ActionListener {
    private JFrame _Frame;
    private JPanel _Panel, p2, p3, p4, p5, p6;
    private JButton _Finds_Employees, _PrinttoTextFile, _Clear, _Count;
    private JLabel _MaxSalary, _MinSalary, _EmpHASMinS, _EmpHASMaxP;
    private JTextField TF_MaxSalary, TF_MinSalary, TF_EmpHASMinS, TF_EmpHASMaxP;
    private FileReader _IDReader, _RanksReader, _SalariesReader;
    private BufferedReader _BuffReaderID,_BuffReaderRanks,_BuffReaderSalaries;

    private ArrayList<Employee> Employees;
    private String x1, x2, x3;
    private String res1, res2, res3, res4;

    public void m1() {
        // 1 Initil Components
        _Frame = new JFrame("Employees");
        _Panel = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();

        _Finds_Employees = new JButton("Finds Employees");
        _PrinttoTextFile = new JButton("Print to Text File");
        _Clear = new JButton("Clear");
        _Count = new JButton("Count");

        _MaxSalary = new JLabel("Max Salary:");
        _MinSalary = new JLabel("Min Salary:");
        _EmpHASMinS = new JLabel("Employee that has Min Salary:");
        _EmpHASMaxP = new JLabel("Employee that has Max Performance:");

        TF_MaxSalary = new JTextField();
        TF_MinSalary = new JTextField();
        TF_EmpHASMinS = new JTextField();
        TF_EmpHASMaxP = new JTextField();
        // 2 Register Buttons
        _Finds_Employees.addActionListener(this);
        _PrinttoTextFile.addActionListener(this);
        _Count.addActionListener(this);
        _Clear.addActionListener(this);
        // 3 Add
        _Panel.add(_Finds_Employees);

        p2.add(_MaxSalary);
        p2.add(TF_MaxSalary);

        p3.add(_MinSalary);
        p3.add(TF_MinSalary);

        p4.add(_EmpHASMinS);
        p4.add(TF_EmpHASMinS);

        p5.add(_EmpHASMaxP);
        p5.add(TF_EmpHASMaxP);

        p6.add(_PrinttoTextFile);
        p6.add(_Clear);
        p6.add(_Count);

        _Panel.add(p2);
        _Panel.add(p3);
        _Panel.add(p4);
        _Panel.add(p5);
        _Panel.add(p6);

        // 4 Extra
        _Frame.setSize(500, 600);
        _Panel.setLayout(new GridLayout(6, 1));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        p4.setLayout(new GridLayout(1, 2));
        p5.setLayout(new GridLayout(1, 2));
        p6.setLayout(new GridLayout(1, 3));


        _Frame.getContentPane().add(_Panel);
        _Frame.setVisible(true);
    }
    public void read(){

        Employees = new ArrayList<Employee>();
        try {
            _IDReader = new FileReader("C:\\Users\\a.mahmoud\\IdeaProjects\\Final\\src\\Final\\IDs.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            _RanksReader = new FileReader("C:\\Users\\a.mahmoud\\IdeaProjects\\Final\\src\\Final\\Ranks.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            _SalariesReader = new FileReader("C:\\Users\\a.mahmoud\\IdeaProjects\\Final\\src\\Final\\Salaries.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        _BuffReaderID = new BufferedReader(_IDReader);
        _BuffReaderRanks =new BufferedReader(_RanksReader);
        _BuffReaderSalaries = new BufferedReader(_SalariesReader);
        int i = 0;

        while (true){
            try {
                if (!((x1 = _BuffReaderID.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } // Assign Data to the Employee in the Arraylist
            try {
                x1 = _BuffReaderID.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                x2 = _BuffReaderRanks.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                x3 = _BuffReaderSalaries.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Employees.get(i).setID(x1);
            Employees.get(i).setRank(x2);
            Employees.get(i).setSalary(x3);
            i++;
        }
        int  MaxPerf = Integer.parseInt( Employees.get(0).getRank()) ;
        int  MaxPerfID = Employees.get(0).getID() );

        int MinSalary = Employees.get(0).getSalary());
        int maxSalary = Employees.get(0).getSalary());

        int ID_minSalary = Employees.get(0).getID());


        for (int j = 0; j < Employees.size(); j++) {        // Get Data
            if (Integer.parseInt( Employees.get(j).getSalary()) > maxSalary){  // MaxSalary
                maxSalary = Employees.get(j).getSalary();

            }
            if (Integer.parseInt( Employees.get(j).getRank()) > MaxPerf){  //  max Perf
                MaxPerf = Employees.get(j).getRank();
                MaxPerfID = Employees.get(j).getID();
            }
            if (Integer.parseInt( Employees.get(j).getSalary()) < MinSalary){  //  min Salary
                MinSalary = Employees.get(j).getSalary();
                ID_minSalary = Employees.get(j).getID();
            }
        }

        res1 =String.valueOf(maxSalary);
        res2 = String.valueOf(MinSalary);
        res3 = String.valueOf(ID_minSalary);
        res4 =String.valueOf(MaxPerfID);

        TF_MaxSalary.setText(res1);

        TF_MinSalary.setText(res2);
        TF_EmpHASMinS.setText(res3);
        TF_EmpHASMaxP.setText(res4);


    }
    //public void B(){}
   // public void print(){}
    public static void main(String[] args) {
        GUI x = new GUI();
        x.m1();
        System.out.println("Hello world!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == _Finds_Employees){
                read();
            }
            if(e.getSource() == _PrinttoTextFile){
                //print();
            }
            if(e.getSource() == _Clear){
                TF_EmpHASMaxP.setText(" ");
                TF_MinSalary.setText(" ");
                TF_EmpHASMinS.setText(" ");
                TF_MaxSalary.setText(" ");

            }
            if (e.getSource() == _Count){
                int c = Employees.size();
                String xxxx = ""+ c;
                JOptionPane.showMessageDialog(_Frame, "Employees" + xxxx);

            }
    }
}