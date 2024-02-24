package ui;

import models.Localitate;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class LocalitatiCareContinSubsirulPanel extends JPanel {
    private JTextField subsirTF;
    private JButton resultBtn;
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JPanel optionsPanel;
    private JLabel enuntLabel;


    public LocalitatiCareContinSubsirulPanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.3.b) Sa se gaseasca denumirea localitatilor care au in\n" +
                "denumire litera ’j’ ordonat alfabetic."));

        tablePanel.setLayout(new CardLayout());
        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String subsir = subsirTF.getText();

                List<Localitate> localitati = Repository.localitatiCareContinSubsirul(subsir);

                tablePanel.removeAll();
                JTable table = creeazaTabel(localitati);
                tablePanel.add(table);
                tablePanel.add(new JScrollPane(table));
                mainPanel.revalidate();
            }
        });
        this.setLayout(new CardLayout());
    }

    public JTable creeazaTabel(List<Localitate> localitati) {
        String[] columnNames = {"Denumirea localitatii"};
        String[][] data = new String[localitati.size()][1];
        for ( Localitate localitate : localitati) {
            int i = localitati.indexOf(localitate);
            data[i][0] = localitate.getDenumire();
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}




