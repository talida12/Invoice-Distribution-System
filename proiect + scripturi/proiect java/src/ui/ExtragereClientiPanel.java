package ui;

import models.Client;
import repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ExtragereClientiPanel extends JPanel{
    private JPanel mainPanel;
    private JPanel tablePanel;

    public ExtragereClientiPanel(){
        this.add(mainPanel);

        MainGUI.stylePanel(this);
        MainGUI.stylePanel(mainPanel);
        MainGUI.stylePanel(tablePanel);

        tablePanel.setLayout(new CardLayout());
        List<Client> clienti = Repository.extrageClienti();
        tablePanel.removeAll();
        JTable table = creeazaTabel(clienti);
        tablePanel.add(new JScrollPane(table));
        mainPanel.revalidate();
    }

    public JTable creeazaTabel(List<Client> clienti){
        String[] columnNames = {"ID client", "Nume", "Adresa"};
        String data[][] = new String[clienti.size()][3];
        for ( Client client : clienti ){
            int i = clienti.indexOf(client);
            data[i][0] = String.valueOf(client.getIdClient());
            data[i][1] = client.getNume();
            data[i][2] = client.getAdresa();
        }
        JTable table = new JTable(data, columnNames);
        MainGUI.styleTable(table);

        return table;
    }
}
