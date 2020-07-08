/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feetinches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * @author Ashad Nadeem
 */
public class Gui extends JFrame {
    private static final int width = 500;
    private static final int hieght = 300;
    private JLabel introL, FeetL , InchesL,AnsL;
    private JTextField FeetTF,InchesTF, AnsTF;
    private JButton exitB, simplifyB;
    private ExitButtonHandler ebHandler;
    private SimplifyButtonHandler sbHandler;
    
    public Gui(){
        //Labels
        setTitle("FeetInchesConverter by AShCorp");
        introL = new JLabel("ThankYou for using FeetInchesConverter",SwingConstants.CENTER);
        FeetL = new JLabel("Enter the Feet: ",SwingConstants.RIGHT);
        InchesL = new JLabel("Enter the Inches: ",SwingConstants.RIGHT);
        AnsL = new JLabel("Answer: ",SwingConstants.RIGHT);
        
        //TextFields
        FeetTF = new JTextField("0");
        InchesTF = new JTextField("0");
        AnsTF = new JTextField();
        AnsTF.setForeground(Color.green);
       
        // EXit button
        exitB = new JButton("Exit");
        exitB.setBackground(Color.red);
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
        
        //SimplifyB
        simplifyB = new JButton("Simplify");
        simplifyB.setBackground(Color.yellow);
        sbHandler = new SimplifyButtonHandler();
        simplifyB.addActionListener(sbHandler);
        
        //pane
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5,1));
        pane.add(FeetL);
        pane.add(FeetTF);
        pane.add(InchesL);
        pane.add(InchesTF);
        pane.add(AnsL);
        pane.add(AnsTF);
        pane.add(exitB);
        pane.add(simplifyB);
        pane.add(introL);
        setSize(width,hieght);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class ExitButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent press){
            System.exit(0);
        }
    }
    private class SimplifyButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent press){
            int feet, inch;
            feet = Math.abs((int)Double.parseDouble(FeetTF.getText()));
            inch = Math.abs((int)Double.parseDouble(InchesTF.getText()));
            FeetInches obj = new FeetInches(feet,inch);
            obj.simplify();
            FeetTF.setText("" + obj.getFeet());
            InchesTF.setText("" + obj.getInches());
            AnsTF.setText(obj.toString());
        }
    }
    
    
}
