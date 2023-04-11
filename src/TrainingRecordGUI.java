// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terrain = new JTextField(4);
    private JTextField tempo = new JTextField(4);
    private JTextField recovery = new JTextField(4);
    private JTextField repetitions = new JTextField(4);
    private JTextField where = new JTextField(4);

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labtr = new JLabel("Terrain: ");
    private JLabel labt = new JLabel("Tempo: ");
    private JLabel labr = new JLabel("Recovery: ");
    private JLabel labrep = new JLabel("Repetitions: ");
    private JLabel labw = new JLabel("Where: ");

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton ("Search all by Date");
    private JButton addSwim = new JButton("Add Swimming Entry");
    private JButton addCycle = new JButton("Add Cycling Entry");
    private JButton addRun = new JButton("Add Running Entry");
    private JButton remove = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labtr);
        add(terrain);
        terrain.setEditable(true);
        add(labt);
        add(tempo);
        tempo.setEditable(true);
        add(labr);
        add(recovery);
        recovery.setEditable(true);
        add(labrep);
        add(repetitions);
        repetitions.setEditable(true);
        add(labw);
        add(where);
        where.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
//        add(addSwim);
//        addSwim.addActionListener(this);
//        add(addCycle);
//        addCycle.addActionListener(this);
//        add(addRun);
//        addRun.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if(event.getSource() == findAllByDate){
            message = dateEntry();
        }
//        if (event.getSource() == addSwim){
//            message = addEntry("generic");
//        }
//        if (event.getSource() == addRun){
//            message = addEntry("generic");
//        }
//        if (event.getSource() == addCycle){
//            message = addEntry("generic");
//        }
        if(event.getSource() == remove){
            deleteEntry();

        }

        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());

        String w = where.getText();
        String r = recovery.getText();
        String rr = repetitions.getText();
        String tr = terrain.getText();
        String tm = tempo.getText();

        if (!w.isEmpty()){
            Swim e = new Swim(n, d, m, y, h, mm, s, km,w);
            myAthletes.addEntry(e);
        }
        else if (!tr.isEmpty()|| !tm.isEmpty()){
            Cycle e = new Cycle(n, d, m, y, h, mm, s, km, tr, tm);
            myAthletes.addEntry(e);
        }
        else if (!r.isEmpty()||!rr.isEmpty()){
            Run e = new Run(n, d, m, y, h, mm, s, km, Integer.parseInt(r), Integer.parseInt(rr));
            myAthletes.addEntry(e);
        }
        else{
            Entry e = new Entry(n, d, m, y, h, mm, s, km);
            myAthletes.addEntry(e);
        }
        return message;
    }

    public String deleteEntry(){
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("looking for record to delete...");
        String message = myAthletes.removeEntry(n,d,m,y);
        return message;
    }

    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String dateEntry(){
        //System.out.println("Not implemented yet...");
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up all records...");
        String message = myAthletes.lookupAllEntry(d,m,y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terrain.setText("");
        tempo.setText("");
        recovery.setText("");
        repetitions.setText("");
        where.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

