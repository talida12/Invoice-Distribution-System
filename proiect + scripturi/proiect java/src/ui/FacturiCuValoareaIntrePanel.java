package ui;

import models.Factura;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FacturiCuValoareaIntrePanel extends JPanel {

    private JPanel mainPanel;
    private JTextField valMinFld;
    private JTextField valMaxFld;
    private JPanel tablePanel;
    private JButton resultBtn;
    private JLabel errorLbl;
    private JPanel optionsPanel;
    private JPanel backPanel;
    private JLabel enuntLabel;

    public FacturiCuValoareaIntrePanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);
        MainGUI.stylePanel(backPanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.3.a) Sa se afiseze detaliile pentru facturile cu valoare\n" +
                "intre 500 si 1000 ordonat descrescator dupa data si\n" +
                "crescator dupa valoare."));
        errorLbl.setText("");
        tablePanel.setLayout(new CardLayout());

        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double min = Integer.parseInt(valMinFld.getText());
                    int max = Integer.parseInt(valMaxFld.getText());

                    if (min > max) {
                        throw new Exception("Valoarea minima trebuie sa fie mai mica decat cea maxima!");
                    }

                    List<Factura> facturi = Repository.facturiCuValoareaIntre(min, max);
                    errorLbl.setText("");

                    tablePanel.removeAll();
                    JTable table = creeazaTabel(facturi);
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

    public JTable creeazaTabel(List<Factura> facturi) {
        String[] columnNames = {"ID", "Data", "Pagini", "Cost/pag", "Zile", "Valoare", "TVA", "ID client", "Total"};
        String[][] data = new String[facturi.size()][9];
        for (Factura factura : facturi) {
            int i = facturi.indexOf(factura);
            data[i][0] = String.valueOf(factura.getIdFactura());
            data[i][1] = factura.getData().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
