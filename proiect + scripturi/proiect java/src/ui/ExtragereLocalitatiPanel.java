package ui;

import models.Localitate;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExtragereLocalitatiPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel tablePanel;
    public ExtragereLocalitatiPanel(){
        this.add(mainPanel);

        MainGUI.stylePanel(this);
        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        tablePanel.setLayout(new CardLayout());
        java.util.List<Localitate> localitati = Repository.extrageLocalitati();
        tablePanel.removeAll();
        JTable table = creeazaTabel(localitati);
        tablePanel.add(table);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();
    }

    public JTable creeazaTabel(List<Localitate> localitati){
        String[] columnNames = {"ID Localitate", "Denumire Localitate"};
        String data[][] = new String[localitati.size()][2];
        for ( Localitate localitate : localitati ){
            int i = localitati.indexOf(localitate);
            data[i][0] = String.valueOf(localitate.getIdLocalitate());
            data[i][1] = String.valueOf(localitate.getDenumire());
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
