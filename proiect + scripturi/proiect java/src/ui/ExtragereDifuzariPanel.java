package ui;

import models.Difuzare;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExtragereDifuzariPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel tablePanel;
    public ExtragereDifuzariPanel(){
        this.add(mainPanel);

        MainGUI.stylePanel(this);
        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        tablePanel.setLayout(new CardLayout());
        java.util.List<Difuzare> difuzari = Repository.extrageDifuzari();
        tablePanel.removeAll();
        JTable table = creeazaTabel(difuzari);
        tablePanel.add(table);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();
    }

    public JTable creeazaTabel(List<Difuzare> difuzari){
        String[] columnNames = {"ID factura", "ID localitate", "Data inceput", "Data sfarsit"};
        String data[][] = new String[difuzari.size()][4];
        for ( Difuzare difuzare : difuzari ){
            int i = difuzari.indexOf(difuzare);
            data[i][0] = String.valueOf(difuzare.getIdFactura());
            data[i][1] = String.valueOf(difuzare.getIdLocalitate());
            data[i][2] = String.valueOf(difuzare.getDatai());
            data[i][3] = String.valueOf(difuzare.getDatas());
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
       table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
