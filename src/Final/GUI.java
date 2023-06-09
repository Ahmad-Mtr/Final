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
    private BufferedReader _BuffReaderID, _BuffReaderRanks, _BuffReaderSalaries;
    private ArrayList<Integer> ArrIDs, ArrRanks, ArrSalaries;

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

    public void inputIDs(String path) {
        ArrIDs = new ArrayList<>();
        try {
            _IDReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _BuffReaderID = new BufferedReader(_IDReader);
        String line;


        while (true) {
            try {
                if ((line = _BuffReaderID.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ArrIDs.add(Integer.parseInt(line));


        }

    }

    public void inputRanks(String path) {
        ArrRanks = new ArrayList<>();
        try {
            _RanksReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _BuffReaderRanks = new BufferedReader(_RanksReader);
        String line;


        while (true) {
            try {
                if ((line = _BuffReaderRanks.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ArrRanks.add(Integer.parseInt(line));


        }

        int maxRank = ArrRanks.get(0);
        int IndexMaxrank = 0;
        for (int i = 1; i < ArrRanks.size(); i++) {
            if (maxRank < ArrRanks.get(i)) {
                maxRank = ArrRanks.get(i);
                IndexMaxrank = i;
            }
        }
        String v = String.valueOf(ArrIDs.get(IndexMaxrank));
        TF_EmpHASMaxP.setText(v);
    }

    public void inputSalaries(String path) {
        ArrSalaries = new ArrayList<>();
        try {
            _SalariesReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        _BuffReaderSalaries = new BufferedReader(_SalariesReader);
        String line;


        while (true) {
            try {
                if ((line = _BuffReaderSalaries.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ArrSalaries.add(Integer.parseInt(line));


        }

        int maxSalary = ArrSalaries.get(0);
        int minSalary = ArrSalaries.get(0);
        int IndexMinSalary = 0;
        for (int i = 1; i < ArrSalaries.size(); i++) {  //Max Salary
            if (maxSalary < ArrSalaries.get(i))
                maxSalary = ArrSalaries.get(i);
        }
        for (int i = 1; i < ArrSalaries.size(); i++) {  //Min Salary
            if (minSalary > ArrSalaries.get(i)) {
                minSalary = ArrSalaries.get(i);
                IndexMinSalary = i;
            }
        }
        String v = String.valueOf(ArrIDs.get(IndexMinSalary));
        TF_EmpHASMinS.setText(v);
        TF_MaxSalary.setText(String.valueOf(maxSalary));
        TF_MinSalary.setText(String.valueOf(minSalary));
    }

    public void read() {


        //
        //  Input IDs
        inputIDs("C:\\Users\\YOUSEF MAHMOUD\\IdeaProjects\\Final\\src\\Final\\IDs.txt");
        //  test IDs
        //          DONE!
        //  Input Salaries
        inputSalaries("C:\\Users\\YOUSEF MAHMOUD\\IdeaProjects\\Final\\src\\Final\\Salaries.txt");

        //  Input Ranks
        inputRanks("C:\\Users\\YOUSEF MAHMOUD\\IdeaProjects\\Final\\src\\Final\\Ranks.txt");

    }

    //public void B(){}
    // public void print(){}
    public static void main(String[] args) {
        GUI x = new GUI();
        x.m1();
        System.out.println("Hello world!");
    }

    public void print() {
        String data = "";
        String tf1, tf2, tf3, tf4;
        tf1 = TF_MaxSalary.getText();
        tf2 = TF_MinSalary.getText();
        tf3 = TF_EmpHASMinS.getText();
        tf4 = TF_EmpHASMaxP.getText();
        data = "Max Salary: " + tf1 + "\n" + "Min Salary: " +  tf2 + "\n"  + "Employee --> Min Salary: " +  tf3 + "\n" + "Emp --> Max Performance: " + tf4 + "\n";
        FileWriter f1 = null;
        try {
            f1 = new FileWriter("C:\\Users\\YOUSEF MAHMOUD\\IdeaProjects\\Final\\src\\Final\\Data.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter BuffWrite = new BufferedWriter(f1);
        try {
            BuffWrite.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BuffWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == _Finds_Employees) {
            read();
        }
        if (e.getSource() == _PrinttoTextFile) {
            print();
        }
        if (e.getSource() == _Clear) {
            TF_EmpHASMaxP.setText(" ");
            TF_MinSalary.setText(" ");
            TF_EmpHASMinS.setText(" ");
            TF_MaxSalary.setText(" ");

        }
        if (e.getSource() == _Count) {
            int c = ArrIDs.size();
            String xxxx = "" + c;
            JOptionPane.showMessageDialog(_Frame, "Num of Employees: " + xxxx);

        }
    }
}