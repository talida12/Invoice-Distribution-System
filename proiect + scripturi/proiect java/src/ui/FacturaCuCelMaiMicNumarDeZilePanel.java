package ui;

import models.Client;
import models.Factura;
import models.Pair;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FacturaCuCelMaiMicNumarDeZilePanel extends JPanel{
    private JTextField anulTF;
    private JPanel tablePanel;
    private JPanel mainPanel;
    private JLabel errorLbl;
    private JButton resultBtn;
    private JPanel optionsPanel;
    private JLabel enuntLabel;

    public FacturaCuCelMaiMicNumarDeZilePanel(){
        this.add(mainPanel);
        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);
        enuntLabel.setText(MainGUI.convertToMultiline("5.5.b) Sa se gaseasca numele clientului care are factura\n" +
                "cu cel mai mic numar de zile în anul 2022."));
        errorLbl.setText("");
        tablePanel.setLayout(new CardLayout());

        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int an = Integer.parseInt(anulTF.getText());

                    if (an > 2023) {
                        throw new Exception("Valoarea maxima a anului trebuie sa fie 2023!");
                    }

                    List<Pair<Client, Factura>> perechi = Repository.clientFacturaCelMaiMicNumarDeZileDinAn(an);
                    errorLbl.setText("");

                    tablePanel.removeAll();
                    JTable table = creeazaTabel(perechi);
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
    public JTable creeazaTabel(List<Pair<Client, Factura>> perechi) {
        String[] columnNames = {"Nume client", "Numar de zile"};
        String[][] data = new String[perechi.size()][2];
        for (Pair<Client, Factura> pereche : perechi) {
            int i = perechi.indexOf(pereche);
            data[i][0] = pereche.first().getNume();
            data[i][1] = String.valueOf(pereche.second().getNrZile());
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }

}
