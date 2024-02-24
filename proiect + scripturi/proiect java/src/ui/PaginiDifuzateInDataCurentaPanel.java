package ui;

import models.Factura;
import models.Localitate;
import models.Pair;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PaginiDifuzateInDataCurentaPanel extends JPanel{
    private JButton resultBtn;
    private JPanel tablePanel;
    private JPanel mainPanel;
    private JLabel enuntLabel;
    private JPanel backPanel;

    public PaginiDifuzateInDataCurentaPanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.6.a) Sa se gaseasca pentru fiecare localitate cate pagini\n" +
                "trebuie difuzate in data curenta."));

        tablePanel.setLayout(new CardLayout());

        List<Pair<Localitate, Integer>> perechi = Repository.paginiDifuzateInDataCurenta();
        tablePanel.removeAll();
        JTable table = creeazaTabel(perechi);
        tablePanel.add(table);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();

        this.setLayout(new CardLayout());
    }

    public JTable creeazaTabel(List<Pair<Localitate, Integer>> perechi) {
        String[] columnNames = {"Denumirea localitatii", "Total numar de pagini"};
        String[][] data = new String[perechi.size()][2];
        for (Pair<Localitate, Integer> pereche : perechi) {
            int i = perechi.indexOf(pereche);
            data[i][0] = pereche.first().getDenumire();
            data[i][1] = String.valueOf(pereche.second());
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
