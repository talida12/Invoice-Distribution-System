package ui;

import models.Factura;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ExtragereFacturiPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel tablePanel;
    public ExtragereFacturiPanel(){
        this.add(mainPanel);

        MainGUI.stylePanel(this);
        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        tablePanel.setLayout(new CardLayout());
        java.util.List<Factura> facturi = Repository.extrageFacturi();
        tablePanel.removeAll();
        JTable table = creeazaTabel(facturi);
        tablePanel.add(table);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();
    }

    public JTable creeazaTabel(List<Factura> facturi){
        String[] columnNames = {"ID", "Data", "Pagini", "Cost/pag", "Zile", "Valoare", "TVA", "ID client", "Total"};
        String data[][] = new String[facturi.size()][9];
        for ( Factura factura : facturi ){
            int i = facturi.indexOf(factura);
            data[i][0] = String.valueOf(factura.getIdFactura());
            data[i][1] = String.valueOf(factura.getData());
            data[i][2] = String.valueOf(factura.getNrPagini());
            data[i][3] = String.valueOf(factura.getCostPagina());
            data[i][4] = String.valueOf(factura.getNrZile());
            data[i][5] = String.valueOf(factura.getValoare());
            data[i][6] = String.valueOf(factura.getTva());
            data[i][7] = String.valueOf(factura.getIdClient());
            data[i][8] = String.valueOf(factura.getValoareTotala());

        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
