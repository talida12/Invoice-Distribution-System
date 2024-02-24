package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JButton facturiCuValoareaIntreBtn;
    private JButton localitatiCareContinSubsirulBtn;
    private JButton facturiPeDouaLocalitatiBtn;
    private JButton perechiDeLocalitatiBtn;
    private JButton difuzariInLunaValoareSubBtn;
    private JButton clientFacturaCelMaiMicNumarDeZileDinAnBtn;
    private JButton paginiDifuzateInDataBtn;
    private JButton statisticaPentruAnulBtn;
    private JPanel mainPanel;
    private JPanel windowPanel;
    private JPanel buttonsPanel;
    private JLabel logoLabel;
    private JButton listaDifuzariButton;
    private JButton listaClientiButton;
    private JButton listaFacturiButton;
    private JButton listaLocalitatiButton;
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JPanel upperPanel;
    private JPanel logoPanel;
    private JPanel upperButtonsPanel;

    public static void makeButtonStyle(JButton btn) {
        btn.setBackground(new Color(0, 40, 80));
        btn.setForeground(new Color(255, 255, 255));
        btn.setFont(new Font("Arial", Font.BOLD, 12));
    }

    public static void stylePanel(JPanel pnl) {
        pnl.setBackground(new Color(0, 80, 160));
        pnl.setForeground(new Color(255, 255, 255));
    }

    public static void styleTable(JTable tbl) {
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setFont(new Font("Segoue UI", Font.BOLD, 15));
        tbl.getTableHeader().setOpaque(false);
        tbl.getTableHeader().setBackground(new Color(32, 136, 203));
        tbl.getTableHeader().setForeground(new Color(255,255,255));

        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl.setRowHeight(25);
        tbl.setSelectionBackground(new java.awt.Color(52, 156, 223));
        tbl.setShowVerticalLines(false);
        tbl.getTableHeader().setReorderingAllowed(false);

        tbl.setPreferredScrollableViewportSize(tbl.getPreferredSize());
        tbl.setPreferredScrollableViewportSize(new
                Dimension(500, (int) tbl.getPreferredSize().getHeight()));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );

        for(int x = 0; x < tbl.getColumnCount(); x++){
            tbl.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }

        tbl.removeEditor();
    }

    public static String convertToMultiline(String orig)
    {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    public void manageButtons() {
        mainPanel.setLayout(new CardLayout());
        buttonsPanel.setBackground(new Color(0, 50, 100));
        logoPanel.setBackground(new Color(0, 50, 100));
        stylePanel(windowPanel);
        stylePanel(mainPanel);
        stylePanel(upperPanel);
        stylePanel(upperButtonsPanel);
        logoLabel.setIcon(new ImageIcon("data/sdf.png"));

        imageLabel.setIcon(new ImageIcon("data/buildings.png"));
        imagePanel.setBackground(new Color(0, 0, 0, 0));
        imageLabel.setBackground(new Color(0, 0, 0, 0));

        makeButtonStyle(listaClientiButton);
        listaClientiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new ExtragereClientiPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(listaFacturiButton);
        listaFacturiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new ExtragereFacturiPanel());
                windowPanel.revalidate();
            }
        });
        makeButtonStyle(listaDifuzariButton);
        listaDifuzariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new ExtragereDifuzariPanel());
                windowPanel.revalidate();
            }
        });
        makeButtonStyle(listaLocalitatiButton);
        listaLocalitatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new ExtragereLocalitatiPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(facturiCuValoareaIntreBtn);
        facturiCuValoareaIntreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new FacturiCuValoareaIntrePanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(localitatiCareContinSubsirulBtn);
        localitatiCareContinSubsirulBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new LocalitatiCareContinSubsirulPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(facturiPeDouaLocalitatiBtn);
        facturiPeDouaLocalitatiBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new FacturiPeDouaLocalitatiPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(perechiDeLocalitatiBtn);
        perechiDeLocalitatiBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new PerechiDeLocalitatiPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(difuzariInLunaValoareSubBtn);
        difuzariInLunaValoareSubBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new DifuzariInLunaDataCuValoareMaiMicaPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(clientFacturaCelMaiMicNumarDeZileDinAnBtn);
        clientFacturaCelMaiMicNumarDeZileDinAnBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new FacturaCuCelMaiMicNumarDeZilePanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(paginiDifuzateInDataBtn);
        paginiDifuzateInDataBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new PaginiDifuzateInDataCurentaPanel());
                windowPanel.revalidate();
            }
        });

        makeButtonStyle(statisticaPentruAnulBtn);
        statisticaPentruAnulBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPanel.removeAll();
                mainPanel.add(new StatisticaPentruUnAnPanel());
                windowPanel.revalidate();
            }
        });

    }

    public MainGUI(String titlu) {
        super(titlu);

        manageButtons();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(windowPanel);
        this.setIconImage((new ImageIcon("data/city.png")).getImage());
        this.pack();
    }

    public static void main(String[] args) {
        MainGUI mainFrame = new MainGUI("Sistem difuzare facturi");
        mainFrame.setSize(new Dimension(1200, 600));
        mainFrame.setVisible(true);
    }
}
