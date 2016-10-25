package com.anthony;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by id7604ug on 10/25/2016.
 */
public class PetSurvey extends JFrame{
    private JCheckBox cbxCat;
    private JCheckBox cbxFish;
    private JCheckBox cbxDog;
    private JButton btnQuit;
    private JPanel rootPanel;
    private JLabel lblResults;

    // Global variables
    private boolean cat, dog, fish;

    PetSurvey(){
        setContentPane(rootPanel);
        pack();
        setSize(350, 200);
        setTitle("Pet Survey");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cbxCat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = cbxCat.isSelected();
                updateResults();
            }
        });

        cbxDog.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = cbxDog.isSelected();
                updateResults();
            }
        });

        cbxFish.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = cbxFish.isSelected();
                updateResults();
            }
        });


        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this, "Are you sure you want to exit?", "Quit?", JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults() {
        String hasDog = dog ? "a dog" : "no dogs";
        String hasCat = cat ? "a cat" : "no cats";
        String hasFish = fish ? "a fish" : "no fish";
        String results = "You have " + hasDog + " " + hasCat + " and " + hasFish;
        lblResults.setText(results);
    }
}
