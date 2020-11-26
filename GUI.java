import Backend.ABFRAGE;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener, FocusListener
{
    private JMenuBar menuBar;
    private JButton searchButton;
    private JCheckBox dateCheckbox;
    private JCheckBox SizeCheckbox;
    private JCheckBox RateCheckbox;
    private JCheckBox favoriteCheckbox;
    private JLabel fileType;
    private JLabel fileName;
    private JLabel dateLabel;
    private JLabel sizeLabel;
    private JCheckBox mp3Checkbox;
    private JCheckBox mp4Checkbox;
    private JComboBox RateCombobox;
    private JLabel ProjectLabel;
    private JPanel inputpanel;
    private JTextField filename;
    private JTextField day;
    private JTextField month;
    private JTextField year;
    private JTextField minSize;
    private JTextField maxSize;    
    static JTable Output;
    private JPanel outputpanel;
    String filenameIN;
    int datarateIN;
    int mp4value;
    int mp3value;
    int ratevalue;
    int sizevalue;
    int filesizeIN;
    int datevalue;
    String dateIN;
    ABFRAGE abfrage;
    
    //Constructor 
    public GUI() throws Exception
    {
        this.setTitle("Schwammerl-Sucher 9000");
        this.setSize(1280,720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        //menu generate method
        //generateMenu();   
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1280,720));
        contentPane.setBounds(0,0,780,720);
        contentPane.setBackground(new Color(192,192,192)); 
        
        ImageIcon iconimg = new ImageIcon("mushroomicon.png");
        this.setIconImage(iconimg.getImage());

        String[] comboBoxListe = {"160", "192", "360"};
               
        String[] headline = {"number", "filename", "filetype", "category", "creator", "date", "filesize", "data-/bitrate", "favorite"};
                                
        Object[][] data = {};

        searchButton = new JButton();
        searchButton.setBounds(350,650,100,35);
        searchButton.setBackground(new Color(103,103,103));
        searchButton.setForeground(new Color(214,217,223));
        searchButton.setEnabled(true);
        searchButton.setFont(new Font("sansserif",0,14));
        searchButton.setText("Search");
        searchButton.setVisible(true);

        mp3Checkbox = new JCheckBox();
        mp3Checkbox.setBounds(200,150,50,35);
        mp3Checkbox.setBackground(new Color(214,217,223));
        mp3Checkbox.setForeground(new Color(0,0,0));
        mp3Checkbox.setEnabled(true);
        mp3Checkbox.setFont(new Font("sansserif",0,12));
        mp3Checkbox.setText("mp3");
        mp3Checkbox.setVisible(true);
        
        mp4Checkbox = new JCheckBox(); 
        mp4Checkbox.setBounds(270,150,50,35);
        mp4Checkbox.setBackground(new Color(214,217,223));
        mp4Checkbox.setForeground(new Color(0,0,0));
        mp4Checkbox.setEnabled(true);
        mp4Checkbox.setFont(new Font("sansserif",0,12));
        mp4Checkbox.setText("mp4");
        mp4Checkbox.setVisible(true);

        fileType = new JLabel();
        fileType.setBounds(50,150,120,35);
        fileType.setBackground(new Color(214,217,223));
        fileType.setForeground(new Color(0,0,0));
        fileType.setEnabled(true);
        fileType.setFont(new Font("sansserif",0,12));
        fileType.setText("Filetype");
        fileType.setVisible(true);
    
        fileName = new JLabel();
        fileName.setBounds(50,70,120,30);
        fileName.setBackground(new Color(214,217,223));
        fileName.setForeground(new Color(0,0,0));
        fileName.setEnabled(true);
        fileName.setFont(new Font("sansserif",0,12));
        fileName.setText("Enter Filename:");

        dateCheckbox = new JCheckBox();
        dateCheckbox.setBounds(50,220,120,35);
        dateCheckbox.setBackground(new Color(214,217,223));
        dateCheckbox.setForeground(new Color(0,0,0));
        dateCheckbox.setEnabled(true);
        dateCheckbox.setFont(new Font("sansserif",0,12));
        dateCheckbox.setText("Date");
        dateCheckbox.setVisible(true);
        
        dateLabel = new JLabel();
        dateLabel.setBounds(330,217,120,30);
        dateLabel.setBackground(new Color(214,217,223));
        dateLabel.setForeground(new Color(0,0,0));
        dateLabel.setEnabled(true);
        dateLabel.setFont(new Font("sansserif",0,12));
        dateLabel.setText("(dd|mm|yyyy)");
        dateLabel.setVisible(false);

        SizeCheckbox = new JCheckBox();
        SizeCheckbox.setBounds(50,290,120,35);
        SizeCheckbox.setBackground(new Color(214,217,223));
        SizeCheckbox.setForeground(new Color(0,0,0));
        SizeCheckbox.setEnabled(true);
        SizeCheckbox.setFont(new Font("sansserif",0,12));
        SizeCheckbox.setText("File-Size (MB) ");
        SizeCheckbox.setVisible(true);

        RateCheckbox = new JCheckBox();
        RateCheckbox.setBounds(50,360,120,35);
        RateCheckbox.setBackground(new Color(214,217,223));
        RateCheckbox.setForeground(new Color(0,0,0));
        RateCheckbox.setEnabled(true);
        RateCheckbox.setFont(new Font("sansserif",0,12));
        RateCheckbox.setText("Data-/Bitrate");
        RateCheckbox.setVisible(true);

        favoriteCheckbox = new JCheckBox();
        favoriteCheckbox.setBounds(50,430,120,35);
        favoriteCheckbox.setBackground(new Color(214,217,223));
        favoriteCheckbox.setForeground(new Color(0,0,0));
        favoriteCheckbox.setEnabled(true);
        favoriteCheckbox.setFont(new Font("sansserif",0,12));
        favoriteCheckbox.setText("Favorite");
        favoriteCheckbox.setVisible(true);

        RateCombobox = new JComboBox(comboBoxListe);
        RateCombobox.setBounds(200,360,70,35);
        RateCombobox.setBackground(new Color(214,217,223));
        RateCombobox.setForeground(new Color(0,0,0));
        RateCombobox.setEnabled(true);
        RateCombobox.setFont(new Font("sansserif",0,12));
        RateCombobox.setVisible(false);        

        ProjectLabel = new JLabel();
        ProjectLabel.setBounds(50,0,600,20);
        ProjectLabel.setBackground(new Color(214,217,223));
        ProjectLabel.setForeground(new Color(0,0,0));
        ProjectLabel.setEnabled(true);
        ProjectLabel.setFont(new Font("sansserif",0,10));
        ProjectLabel.setText("Effizienter bei der Schwammerl-Suche als ein professionell ausgebildeter Drexler!");
        ProjectLabel.setVisible(true);

        inputpanel = new JPanel(null);
        inputpanel.setBorder(BorderFactory.createEtchedBorder(1));
        inputpanel.setBounds(780,0,500,720);
        inputpanel.setBackground(new Color(214,217,223));
        inputpanel.setForeground(new Color(0,0,0));
        inputpanel.setEnabled(true);
        inputpanel.setFont(new Font("sansserif",0,12));
        inputpanel.setVisible(true);
    
        filename = new JTextField();
        filename.setBounds(200,70,250,30);
        filename.setBackground(new Color(255,255,255));
        filename.setForeground(new Color(0,0,0));
        filename.setFont(new Font("sansserif",0,12));
        filename.setVisible(true);
        filename.setColumns(60);

        day = new JTextField();
        day.setBounds(200,220,25,25);
        day.setBackground(new Color(255,255,255));
        day.setForeground(new Color(0,0,0));
        day.setEnabled(true);
        day.setFont(new Font("sansserif",0,12));
        day.setText("");
        day.setVisible(false);
        
        
        month = new JTextField();
        month.setBounds(230,220,25,25);
        month.setBackground(new Color(255,255,255));
        month.setForeground(new Color(0,0,0));
        month.setEnabled(true);
        month.setFont(new Font("sansserif",0,12));
        month.setText("");
        month.setVisible(false); 
        

        year = new JTextField();
        year.setBounds(260,220,45,25);
        year.setBackground(new Color(255,255,255));
        year.setForeground(new Color(0,0,0));
        year.setEnabled(true);
        year.setFont(new Font("sansserif",0,12));
        year.setText("");
        year.setVisible(false); 
        

        sizeLabel = new JLabel();
        sizeLabel.setBounds(295,287,60,30);
        sizeLabel.setBackground(new Color(214,217,223));
        sizeLabel.setForeground(new Color(0,0,0));
        sizeLabel.setEnabled(true);
        sizeLabel.setFont(new Font("sansserif",0,12));
        sizeLabel.setText("min to max");
        sizeLabel.setVisible(false);
        
        minSize = new JTextField();
        minSize.setBounds(200,290,90,25);
        minSize.setBackground(new Color(255,255,255));
        minSize.setForeground(new Color(0,0,0));
        minSize.setEnabled(true);
        minSize.setFont(new Font("sansserif",0,12));
        minSize.setText("");
        minSize.setVisible(false); 
        
        maxSize = new JTextField();
        maxSize.setBounds(360,290,90,25);
        maxSize.setBackground(new Color(255,255,255));
        maxSize.setForeground(new Color(0,0,0));
        maxSize.setEnabled(true);
        maxSize.setFont(new Font("sansserif",0,12));
        maxSize.setText("");
        maxSize.setVisible(false);

        //adding components to contentPane panel
        inputpanel.add(searchButton);
        inputpanel.add(dateCheckbox);
        inputpanel.add(SizeCheckbox);
        inputpanel.add(RateCheckbox);
        inputpanel.add(favoriteCheckbox);
        inputpanel.add(mp3Checkbox);
        inputpanel.add(fileType);
        inputpanel.add(fileName);
        inputpanel.add(dateLabel);
        inputpanel.add(mp4Checkbox);
        inputpanel.add(RateCombobox);
        inputpanel.add(ProjectLabel);
        inputpanel.add(filename);
        inputpanel.add(day);
        inputpanel.add(month);
        inputpanel.add(year);
        inputpanel.add(minSize);
        inputpanel.add(maxSize);
        inputpanel.add(sizeLabel);
        
            
        mp3Checkbox.addActionListener(this);
        mp4Checkbox.addActionListener(this);
        dateCheckbox.addActionListener(this);
        SizeCheckbox.addActionListener(this);       
        RateCheckbox.addActionListener(this);
        favoriteCheckbox.addActionListener(this);
        RateCombobox.addActionListener(this);
        searchButton.addActionListener(this);
        day.addFocusListener(this);
        month.addFocusListener(this);
        year.addFocusListener(this);
        minSize.addFocusListener(this);
        maxSize.addFocusListener(this);       
                        
        outputpanel = new JPanel(null);
        //outputpanel.setBorder(BorderFactory.createEtchedBorder(1));
        outputpanel.setBounds(0,0,780,720);
        outputpanel.setBackground(new Color(103,103,103));
        outputpanel.setForeground(new Color(0,0,0));
        outputpanel.setEnabled(true);
        outputpanel.setFont(new Font("sansserif",0,12));
        outputpanel.setVisible(true);
        //outputpanel.setBorder(BorderFactory.createEtchedBorder(1));
        
        Output = new JTable(data, headline);
        Output.setBounds(0, 0, 780, 720);
        Output.setVisible(true);         
        Output.setForeground(new Color(0,0,0));
        Output.setPreferredScrollableViewportSize(new Dimension(780, 720));
        Output.setFillsViewportHeight(true);
        Output.setEnabled(false);
        //JTableHeader headline = Output.getTableHeader();
        //headline.setBackground(new Color(103,103,103));           
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(Output);
        outputpanel.setLayout(new BorderLayout());
        outputpanel.add(Output, BorderLayout.CENTER);
        outputpanel.add(Output.getTableHeader(), BorderLayout.NORTH);

        //Add the scroll pane to this panel.
        contentPane.add(inputpanel);
        contentPane.add(outputpanel);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        //Add the scroll pane to this panel.
        add(scrollPane);

        Scanner filenameIN = new Scanner(System.in); //evtl. damit userinput abgefangen wird (?)       
        //Scanner dateIN = new Scanner(System.in);
        Scanner filesizeIN = new Scanner(System.in);   
        
        abfrage = new ABFRAGE("jdbc:mysql://localhost:3306/exmat?user=root"); //"http://localhost/phpmyadmin/sql.php?user=root"
    }
    public void generateMenu()
    {
    menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu tools = new JMenu("Tools");
    JMenu help = new JMenu("Help");
    JMenuItem open = new JMenuItem("Open   ");
    JMenuItem save = new JMenuItem("Save   ");
    JMenuItem exit = new JMenuItem("Exit   ");
    JMenuItem preferences = new JMenuItem("Preferences   ");
    JMenuItem about = new JMenuItem("About   ");

    file.add(open);
    file.add(save);
    file.addSeparator();
    file.add(exit);
    tools.add(preferences);
    help.add(about);
    menuBar.add(file);
    menuBar.add(tools);
    menuBar.add(help);
    }
    public static void main(String[] args) throws Exception
    {
       // System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        Icon icon = new ImageIcon("loading.gif");
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(icon);                        
        label.setBounds(440,160,400,400);
        panel.setBackground(new Color(38,38,38));
        panel.setBounds(0,0,1280,720);
        panel.add(label, BorderLayout.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        JFrame frame = new JFrame("Schwammerl-Sucher 9000");
        frame.getContentPane().add(label);
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
        frame.setVisible(true);
        //frame.setSize(1280,720);
        frame.setResizable(false);
        frame.add(panel);
        
        for (int i = 0;i < 10; i++)
        {
            Thread.sleep(240);
        }
        
        frame.dispose();
        new GUI();        
    }
     public void actionPerformed (ActionEvent ae)
     {
        try{
         if(ae.getSource() == this.mp3Checkbox)
        {
            //System.out.println("mp3");
            //filetypeIN = ;
        }
        else if(ae.getSource() == this.mp4Checkbox)
        {
            //System.out.println("mp4");            
        }
        else if (ae.getSource() == this.dateCheckbox)
        {
            if (dateCheckbox.isSelected())
            {
                datevalue = 1;
                day.setVisible(true);
                month.setVisible(true);
                year.setVisible(true);
                dateLabel.setVisible(true);
            }
            else
            {
                datevalue = 0;
                day.setVisible(false);
                month.setVisible(false);
                year.setVisible(false);
                dateLabel.setVisible(false);
            }
            //System.out.println("date");                        
        }
        else if (ae.getSource() == this.favoriteCheckbox)
        {
            //System.out.println("favoriteCheckbox");
        }
        else if (ae.getSource() == this.searchButton)
        {
            abfrage.zuruecksetzen();
            
            abfrage.where_anweisung.dateiname_setzen(filename.getText()); 
            
            abfrage.where_anweisung.favorit(favoriteCheckbox.isSelected());
            
            if (mp4Checkbox.isSelected() && mp3Checkbox.isSelected())
            {
                 abfrage.where_anweisung.format_setzen("mp4");
                 abfrage.where_anweisung.oder_hinzufuegen();
                 abfrage.where_anweisung.format_setzen("mp3");
            }
            else if(mp3Checkbox.isSelected())
            {
                abfrage.where_anweisung.format_setzen("mp3");
            }
            else if(mp4Checkbox.isSelected())
            {
                abfrage.where_anweisung.format_setzen("mp4");
            }
            if (ratevalue == 1)
            {  
                abfrage.where_anweisung.daten_bitrate_setzen(Objects.requireNonNull(RateCombobox.getSelectedItem()).toString());
            }
            if (sizevalue == 1)
            {
                   String minfilesizevalue = minSize.getText();
                   String  maxfilesizevalue = maxSize.getText();
                   String anweisung = "Größe < " + maxfilesizevalue + " && " + "Größe > " + minfilesizevalue;
                   abfrage.where_anweisung.anweisung_hinzufuegen(anweisung);
            }
            if (datevalue == 1)
            {
                   dateIN = year.getText()+"-"+month.getText()+"-"+day.getText();
                   abfrage.where_anweisung.erstellungsdatum_setzen(dateIN);
            }
            
            String[][] ergebnis = abfrage.abfrage_ausfuehren();

            for(int i = 0; i < ergebnis.length; i++)
            {
                AddRow(ergebnis[i][1], ergebnis[i][2], ergebnis[i][3], ergebnis[i][4], ergebnis[i][5], ergebnis[i][6], ergebnis[i][7], ergebnis[i][8], ergebnis[i][9]);
            }
        }
        if (ae.getSource() == this.SizeCheckbox)
        {
            if (SizeCheckbox.isSelected())
            {
                sizevalue = 1;
                minSize.setVisible(true);
                maxSize.setVisible(true);
                sizeLabel.setVisible(true);
            }
            else
            {
                sizevalue = 0;
                minSize.setVisible(false);
                maxSize.setVisible(false);
                sizeLabel.setVisible(false);
            }
            //System.out.println("size");            
        }
        else if (ae.getSource() == this.RateCheckbox)
        {
            //System.out.println("Rate");
            if (RateCheckbox.isSelected())
            {
                //System.out.println("rate true");
                RateCombobox.setVisible(true);
                ratevalue = 1;
                String datarateIN = String.valueOf(RateCombobox.getSelectedItem());
            }
            else
            {
                //System.out.println("rate false");
                RateCombobox.setVisible(false);
                ratevalue = 0;
            }
        }
    } 
    catch(Exception e)
    {
       e.printStackTrace();
    }
    }
    public void focusLost(FocusEvent e)
    {
        if(e.getSource() == day)
        {
            if (Integer.parseInt(day.getText()) > 31)
            { 
                day.setText("31");                
            }
            else if(Integer.parseInt(day.getText()) < 1)
            day.setText("1");
            //System.out.println("Day: " + day.getText());
        }
                if(e.getSource() == month)
        {
            if (Integer.parseInt(month.getText()) > 12)
            { 
                month.setText("12");                
            }
            else if(Integer.parseInt(month.getText()) < 1)
            month.setText("1");
            //System.out.println("Month: " + month.getText());
        }
        if(e.getSource() == year)
        {
            if (Integer.parseInt(year.getText()) > 3000)
            { 
                year.setText("3000");                
            }
            else if(Integer.parseInt(year.getText()) <0)
            year.setText("0");
            //System.out.println("Year: " + year.getText());
        }
        if(e.getSource() == minSize)
        {
            if (Integer.parseInt(minSize.getText()) > Integer.parseInt(maxSize.getText()))
            { 
                maxSize.setText("");
                System.out.println("Minimum Size has to be smaller than Maximum Size!");
            }
            else if(Integer.parseInt(year.getText()) <0)
            
            minSize.setText("0");
            //System.out.println("minSize: " + minSize.getText());
        }
        if(e.getSource() == maxSize)
        {
            if (Integer.parseInt(minSize.getText()) > Integer.parseInt(maxSize.getText()))
            { 
                maxSize.setText("");
                System.out.println("Maximum Size has to be bigger than Minimum Size!");
            }
            else if(Integer.parseInt(maxSize.getText()) <0)
            
            maxSize.setText("0");
            //System.out.println("maxSize: " + maxSize.getText());        
        }        
    }
    public void focusGained(FocusEvent e)
    {
        if(e.getSource() == day)
             day.setText("");
        else if(e.getSource() == month)
             month.setText("");
        else if(e.getSource() == year)
             year.setText("");
        else if(e.getSource() == filename)
             filename.setText("");
        else if(e.getSource() == minSize)
             minSize.setText("");
        else if(e.getSource() == maxSize)
             maxSize.setText("");
    }
    public void AddRow(String filenumberOUT, String filenameOUT, String filetypeOUT, String filecategoryOUT, String filecreatorOUT, String dateOUT, String filesizeOUT, String datarateOUT, String favoritevalueOUT)
    {
        DefaultTableModel outModel = (DefaultTableModel) Output.getModel();
        outModel.addRow(new Object[]
            {
                filenumberOUT, filenameOUT, filetypeOUT, filecategoryOUT, filecreatorOUT, dateOUT, filesizeOUT, datarateOUT, favoritevalueOUT
            });
    }
}