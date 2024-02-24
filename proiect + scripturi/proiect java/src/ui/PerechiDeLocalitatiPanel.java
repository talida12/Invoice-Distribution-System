package ui;

import models.Factura;
import models.Localitate;
import models.Pair;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
public class PerechiDeLocalitatiPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JLabel enuntLabel;

    public PerechiDeLocalitatiPanel(){
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.4.b) Sa se gaseasca perechi de localitati (id_l1, id_l2) cu\n" +
                "conditia difuzarea sa apara pe aceeasi factura si sa se suprapuna\n" +
                "perioadele de difuzare. O pereche este unica in rezultat."));

        tablePanel.setLayout(new CardLayout());
        List<Pair<Localitate, Localitate>> perechi = Repository.perechiDeLocalitati();
        tablePanel.removeAll();
        JTable table = creeazaTabel(perechi);
        tablePanel.add(table);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();

        this.setLayout(new CardLayout());
    }
    public JTable creeazaTabel(List<Pair<Localitate, Localitate>>  perechi) {
        String[] columnNames = {"Localitate1", "Localitate2"};
        String[][] data = new String[perechi.size()][2];
        for (Pair<Localitate, Localitate> pereche : perechi) {
            int i = perechi.indexOf(pereche);
            data[i][0] = String.valueOf(pereche.first().getIdLocalitate());
            data[i][1] = String.valueOf(pereche.second().getIdLocalitate());
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}


