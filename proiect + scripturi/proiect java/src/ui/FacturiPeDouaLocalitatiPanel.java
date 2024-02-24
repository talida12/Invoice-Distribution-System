package ui;

import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FacturiPeDouaLocalitatiPanel extends JPanel {
    private JTextField JTextFieldL1;
    private JTextField JTextFieldL2;
    private JPanel tablePanel;
    private JLabel JLabelL2;
    private JLabel JLabelL1;
    private JButton resultBtn;
    private JPanel mainPanel;
    private JPanel optionsPanel;
    private JLabel enuntLabel;


    public FacturiPeDouaLocalitatiPanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.4.a) Sa se gaseasca numele clientilor care au facturi\n" +
                "corespunzatoare difuzarii in localitatile Oradea si Alesd."));

        tablePanel.setLayout(new CardLayout());
        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String localitate1 = JTextFieldL1.getText();
                String localitate2 = JTextFieldL2.getText();

                List<models.Client> clienti = Repository.facturiPeDouaLocalitati(localitate1, localitate2);
                tablePanel.removeAll();
                JTable table = creeazaTabel(clienti);
                tablePanel.add(table);
                tablePanel.add(new JScrollPane(table));
                mainPanel.revalidate();

            }
        });
        this.setLayout(new CardLayout());
    }

    public JTable creeazaTabel(List<models.Client> clienti) {
      String[] columnNames = {"Nume client"};
      String[][] data = new String[clienti.size()][1];
      for ( models.Client client : clienti ){
          int i = clienti.indexOf(client);
          data[i][0] = String.valueOf(client.getNume());
      }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
