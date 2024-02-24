package ui;

import models.Localitate;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;
import java.util.List;
public class DifuzariInLunaDataCuValoareMaiMicaPanel extends JPanel {
    private JTextField lunaTF;
    private JTextField anulTF;
    private JTextField valoareMaximaTextField;
    private JPanel tablePanel;
    private JPanel mainPanel;
    private JLabel errorLbl;
    private JButton resultBtn;
    private JPanel backPanel;
    private  JPanel optionsPanel;
    private JLabel enuntLabel;

    public DifuzariInLunaDataCuValoareMaiMicaPanel() {
        this.add(mainPanel);

        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(optionsPanel);
        MainGUI.stylePanel(tablePanel);

        enuntLabel.setText(MainGUI.convertToMultiline("5.5.a) Sa se gaseasca denumirea localitatilor unde au\n" +
                "existat difuzari in luna octombrie 2022 si factura are\nvaloarea sub 100."));
        errorLbl.setText(" ");
        tablePanel.setLayout(new CardLayout());
        resultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int luna = Integer.parseInt(lunaTF.getText());
                    int an = Integer.parseInt(anulTF.getText());
                    double valoare = Double.parseDouble(valoareMaximaTextField.getText());

                    List <Localitate> localitati = Repository.difuzariInLunaValoareSub(YearMonth.of(an, luna), valoare);
                    errorLbl.setText("");
                    tablePanel.removeAll();
                    JTable table = creeazaTabel(localitati);
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

    public JTable creeazaTabel(List<Localitate> localitati) {
        String[] columnNames = {"Denumirea localitatii"};
        String[][] data = new String[localitati.size()][1];
        for (Localitate localitate : localitati) {
            int i = localitati.indexOf(localitate);
            data[i][0] = localitate.getDenumire();
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        //table.setBackground(new Color(238, 238, 238));
        table.setFillsViewportHeight(true);
        MainGUI.styleTable(table);
        return table;
    }
}
