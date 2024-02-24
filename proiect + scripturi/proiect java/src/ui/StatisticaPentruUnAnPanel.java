package ui;

import models.Factura;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StatisticaPentruUnAnPanel extends JPanel{
    private JTextField anulTF;
    private JButton resultBtn;
    private JPanel tablePanel;
    private JPanel mainPanel;
    private JLabel errorLbl;
    private JPanel optionsPanel;
    private JLabel enuntLabel;

    public StatisticaPentruUnAnPanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.6.b) Sa se gaseasca valoare totala minima, medie si\n" +
                "maxima pentru facturile emise in anul 2022."));
        errorLbl.setText("");
        tablePanel.setLayout(new CardLayout());

        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int an = Integer.parseInt(anulTF.getText());

                    if (an > 2023) {
                        throw new Exception("Valoarea maxima a anului este 2023!");
                    }

                    double valori[] = Repository.statisticaPentruAnul(an);
                    errorLbl.setText("");
                    tablePanel.removeAll();
                    JTable table = creeazaTabel(valori);
                    tablePanel.add(table);
                    tablePanel.add(new JScrollPane(table));
                    mainPanel.revalidate();

                } catch (Exception except) {
                    errorLbl.setText(except.getMessage());
                }
            }
        });

        this.setLayout(new CardLayout());
    }

    public JTable creeazaTabel(double[] valori) {
        String[] columnNames = {"Valoare minima", "Valoare medie", "Valoare maxima"};
        String[][] data = new String[1][valori.length];
        for (int i = 0; i < valori.length; i++){
            data[0][i] = String.valueOf(valori[i]);
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
