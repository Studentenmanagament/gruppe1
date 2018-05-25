/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import studentenmanagement.Klasse.*;
import studentenmanagement.LehrersFenster;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author domin
 */
public class StudentenklasseFenster extends javax.swing.JFrame {

    /**
     * Creates new form Studentenklasse
     */
    Connection con = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Vector <Integer> Student_list = new Vector<>();//matrikel numarasini aliyor secilen ögrencinin
    Vector <Klasse> klasse_list = new Vector<>();
    Vector <Integer> raum_list_sekme1 = new Vector<>();
    Vector <Integer> ögrenciBox = new Vector<>();
    Vector <Integer> secilensinif = new Vector<>();
    Vector <Integer> lehrer_list = new Vector<>();
    Vector <Integer> raum_list = new Vector<>();
    Vector <Student2Klasse> student2klasse = new Vector<>();
    private Vector<JCheckBox> studentcheckBoxes = new Vector();
    private Vector<JCheckBox> raumcheckBoxes = new Vector();    
    private JLabel label;
    private JCheckBox box;
    JCheckBox studentSelectAll;
    JCheckBox raumSelectAll;
    //private JPanel siniflar;
    //private JPanel ögrenciler;
    
    public StudentenklasseFenster() {
        initComponents();
        initDB();
        getAllKlasse();
        show_Klasse();
        getAllLehrer();
        getAllRaum();
        show_klasse();
        
    }
    
    /* show_ogrenci  show_raum fonksiyonu tanımlayın sonra ordan 
    DefaultTableModel model = (DefaultTableModel) hoca.getModel();
        model.setRowCount(0);
     bu kodu uyarlayın panel için büyük ihtimal bu kod benzer gelecek ama doğru çıkmayacak kodu araştırın.
    bunla panele çekersiniz sonrada kullanıcıya gösterirsiniz */
    
    public void show_klasse(){
        
        DefaultTableModel model = (DefaultTableModel) klassetabelle.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i=0;i<klasse_list.size();i++){
            row[0]=klasse_list.get(i).getID();
            row[1]=klasse_list.get(i).getName();
            row[2]=klasse_list.get(i).getStufe();
            row[3]=klasse_list.get(i).getLehrer();
            row[4]=klasse_list.get(i).getRaum();
            
            
            model.addRow(row);
        }
    }
    public void initDB() {

       try { 
           Class.forName("org.hsqldb.jdbcDriver"); 
           String url = "jdbc:hsqldb:file:C:\\Users\\emirhan\\Desktop\\sql\\;shutdown=true";  
           con = DriverManager.getConnection(url,"G1", "1234");
           System.out.println("Connection established.");
           } catch (ClassNotFoundException ex) {
               System.out.println(ex);
               Logger.getLogger(LehrersFenster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(LehrersFenster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getAllLehrer(){
        try{
            String query ="select * from hoca";
            System.out.println(query);
            Statement st =con.createStatement();
            rs=st.executeQuery(query);
            LehrerComboBox.removeAllItems();
            while(rs.next()){
                String name =rs.getString("vorname")+" "+rs.getString("nachname");
                LehrerComboBox.addItem(name);
                lehrer_list.add(rs.getInt("id"));
            
            }               
        }catch(Exception e){
        System.out.println(e);
        JOptionPane.showMessageDialog(null, e);
        }  
    
    
    }
    public void getAllRaum(){
        try{
            String query ="select * from raum";
            System.out.println(query);
            Statement st =con.createStatement();
            rs=st.executeQuery(query);
            RaumComboBox.removeAllItems();
            while(rs.next()){
                String name =rs.getString("name");
                RaumComboBox.addItem(name); 
                raum_list.add(rs.getInt("id"));
            
            }               
        }catch(Exception e){
        System.out.println(e);
        JOptionPane.showMessageDialog(null, e);
        }     
    
    }
    
    public void show_Klasse(){
        
        DefaultTableModel model = (DefaultTableModel) klassetable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for(int i=0;i<klasse_list.size();i++){
            row[0]=klasse_list.get(i).getID();
            row[1]=klasse_list.get(i).getName();
            row[2]=klasse_list.get(i).getStufe();            
            row[3]=klasse_list.get(i).getLehrer();
            row[4]=klasse_list.get(i).getRaum();
            model.addRow(row);
        }
    }
    
    public void getAllKlasse(){
        if (con != null) {
        klasse_list.removeAllElements();
            
        try { 
            String query ="SELECT * FROM Klasse";
            Statement st= con.createStatement();
            rs =st.executeQuery(query);
            Klasse klasse;
            while(rs.next()){
                klasse = new Klasse(rs.getInt("ID"),rs.getString("Name"),rs.getString("Stufe"),rs.getInt("Lehrer_id"),rs.getInt("Raum_id"));

                klasse_list.add(klasse);
            }
        }catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Wir haben Problem!");
            }
        }
        
    }
    public void getAllStudent2Klasse(){
        if (con != null) {
        student2klasse.removeAllElements();
            
        try { 

            String query ="SELECT * FROM Student2Klasse";
            Statement st= con.createStatement();
            rs =st.executeQuery(query);
            Student2Klasse x;
            while(rs.next()){
                x = new Student2Klasse(rs.getInt("Student_id"),rs.getInt("Klase_id"));

                student2klasse.add(x);
            }
        }catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Wir haben Problem!");
            }
        }   
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        klassetabelle = new javax.swing.JTable();
        su3 = new javax.swing.JLabel();
        such = new javax.swing.JTextField();
        speichern3 = new javax.swing.JButton();
        suche3 = new javax.swing.JButton();
        bearbeit3 = new javax.swing.JButton();
        lösch = new javax.swing.JButton();
        neu3 = new javax.swing.JButton();
        sname = new javax.swing.JTextField();
        sID = new javax.swing.JLabel();
        svn = new javax.swing.JLabel();
        snn = new javax.swing.JLabel();
        löschen = new javax.swing.JTextField();
        id_label = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        lname = new javax.swing.JLabel();
        RaumComboBox = new javax.swing.JComboBox<>();
        sID1 = new javax.swing.JLabel();
        sstufe = new javax.swing.JTextField();
        LehrerComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        lbDeutschniveau = new javax.swing.JLabel();
        lbAnfangsjahr = new javax.swing.JLabel();
        lbFach = new javax.swing.JLabel();
        niveau = new javax.swing.JTextField();
        jahr = new javax.swing.JTextField();
        fach = new javax.swing.JTextField();
        btSuchen = new javax.swing.JButton();
        btNeu = new javax.swing.JButton();
        btZuteilen = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbKapazitat = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        stufe = new javax.swing.JTextField();
        btSuchen2 = new javax.swing.JButton();
        btNeu2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ogrenciler = new javax.swing.JPanel();
        tümögrenci = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        klassetable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        student2klassetabelle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        klassetabelle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Klasse Name", "Stufe", "Lehrer", "Raum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        klassetabelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                klassetabelleMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(klassetabelle);

        su3.setText("Suche");

        such.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suchActionPerformed(evt);
            }
        });
        such.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                suchKeyReleased(evt);
            }
        });

        speichern3.setBackground(new java.awt.Color(255, 204, 255));
        speichern3.setText("Speichern");
        speichern3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichern3ActionPerformed(evt);
            }
        });

        suche3.setBackground(new java.awt.Color(255, 204, 255));
        suche3.setText("Suchen");
        suche3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suche3ActionPerformed(evt);
            }
        });

        bearbeit3.setBackground(new java.awt.Color(153, 0, 153));
        bearbeit3.setForeground(new java.awt.Color(255, 255, 255));
        bearbeit3.setText("Bearbeiten");
        bearbeit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeit3ActionPerformed(evt);
            }
        });

        lösch.setBackground(new java.awt.Color(0, 102, 204));
        lösch.setForeground(new java.awt.Color(255, 255, 255));
        lösch.setText("Löschen");
        lösch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                löschActionPerformed(evt);
            }
        });

        neu3.setBackground(new java.awt.Color(102, 204, 255));
        neu3.setText("Neu");
        neu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neu3ActionPerformed(evt);
            }
        });

        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });

        sID.setText("Klasse Name");

        svn.setText("Lehrer");

        snn.setText("Raum");

        löschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                löschenActionPerformed(evt);
            }
        });

        id_label.setText("ID");

        sid.setEditable(false);

        lname.setText("Klasse Name");

        RaumComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        RaumComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaumComboBoxActionPerformed(evt);
            }
        });

        sID1.setText("Niveau");

        sstufe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sstufeActionPerformed(evt);
            }
        });

        LehrerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(su3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(such, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suche3)
                                .addGap(0, 111, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(id_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(neu3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(speichern3))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(sID)
                                            .addComponent(snn)
                                            .addComponent(svn)
                                            .addComponent(sID1))))
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sid, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(sname, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(RaumComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sstufe)
                            .addComponent(LehrerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(392, 392, 392))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(löschen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(bearbeit3)
                                .addGap(190, 190, 190)
                                .addComponent(lösch)))
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(su3)
                    .addComponent(such, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suche3))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_label))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(svn)
                    .addComponent(LehrerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(snn)
                    .addComponent(RaumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sID1)
                    .addComponent(sstufe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(löschen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lösch)
                    .addComponent(bearbeit3)
                    .addComponent(speichern3)
                    .addComponent(neu3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Klasse neu", jPanel4);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lbDeutschniveau.setText("Deutschniveau");

        lbAnfangsjahr.setText("Anfangsjahr");

        lbFach.setText("Fach");

        btSuchen.setText("Suchen");
        btSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuchenActionPerformed(evt);
            }
        });

        btNeu.setText("Neu");
        btNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNeuActionPerformed(evt);
            }
        });

        btZuteilen.setText("Zuteilen");
        btZuteilen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btZuteilenActionPerformed(evt);
            }
        });

        ID.setEditable(false);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        lbID.setText("ID");

        lbName.setText("Name");

        lbKapazitat.setText("Niveau");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        stufe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stufeActionPerformed(evt);
            }
        });

        btSuchen2.setText("Suchen");
        btSuchen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuchen2ActionPerformed(evt);
            }
        });

        btNeu2.setText("Neu");
        btNeu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNeu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ogrencilerLayout = new javax.swing.GroupLayout(ogrenciler);
        ogrenciler.setLayout(ogrencilerLayout);
        ogrencilerLayout.setHorizontalGroup(
            ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        ogrencilerLayout.setVerticalGroup(
            ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(ogrenciler);

        tümögrenci.setText("jCheckBox2");
        tümögrenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tümögrenciActionPerformed(evt);
            }
        });

        klassetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Niveau", "Lehrer", "Raum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        klassetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                klassetableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(klassetable);

        student2klassetabelle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Nachname", "Matrikelnummer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(student2klassetabelle);
        if (student2klassetabelle.getColumnModel().getColumnCount() > 0) {
            student2klassetabelle.getColumnModel().getColumn(0).setResizable(false);
            student2klassetabelle.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("STUDENT mit KLASSE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAnfangsjahr)
                            .addComponent(lbFach)
                            .addComponent(lbDeutschniveau)
                            .addComponent(btNeu))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fach, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jahr)
                                    .addComponent(niveau))
                                .addGap(234, 234, 234)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbName)
                                    .addComponent(lbID)
                                    .addComponent(lbKapazitat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(btSuchen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btNeu2)
                                .addGap(68, 68, 68)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stufe)
                                    .addComponent(name)
                                    .addComponent(ID, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(150, 150, 150))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btSuchen2)
                                .addGap(75, 75, 75))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tümögrenci)
                        .addGap(759, 864, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btZuteilen)))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSuchen2)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btNeu2)
                                .addComponent(btSuchen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbDeutschniveau)
                                    .addComponent(niveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbID))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbAnfangsjahr)
                                    .addComponent(jahr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbName)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFach)
                                    .addComponent(fach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbKapazitat)
                                    .addComponent(stufe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(btNeu)))
                        .addGap(20, 20, 20)))
                .addComponent(tümögrenci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btZuteilen))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Klasse Zuteilen", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void löschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_löschenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_löschenActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void neu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neu3ActionPerformed
        name.setText("");
    }//GEN-LAST:event_neu3ActionPerformed

    private void löschActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_löschActionPerformed
        if (con != null) {

                try{
                    String query ="DELETE FROM klasse WHERE NAME=?";
                    pst = con.prepareStatement(query);
                    pst.setString(1,löschen.getText());
                    pst.executeUpdate();

                    getAllKlasse();
                    show_Klasse();
                    JOptionPane.showMessageDialog(null,"Gelöscht!");
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Nicht Gelöscht!");
                }

            } else {

            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_löschActionPerformed

    private void bearbeit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeit3ActionPerformed
        if (con != null) {
            try {
                String query ="UPDATE raum SET Name=?, Lehrer_id=?, Raum_id=?  WHERE ID=?";
                pst = con.prepareStatement(query);

                pst.setString(1,sname.getText());
                //pst.setString(2,LehrerComboBox.getText());
                //pst.setString(3,RaumComboBox.getText());
                pst.executeUpdate();

                getAllKlasse();
                show_Klasse();

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Nicht Bearbeitet!");
            }
        }
    }//GEN-LAST:event_bearbeit3ActionPerformed

    private void suche3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suche3ActionPerformed
        if (con != null) {
            try {
               
                Statement st = con.createStatement();
                rs = st.executeQuery("select * from klasse WHERE NAME LIKE '%" + such.getText() + "%'" );
                klasse_list.removeAllElements();
                Klasse klasse;
                while(rs.next()){
                    klasse = new Klasse(rs.getInt("ID"), rs.getString("Name"),rs.getString("Stufe"), rs.getInt("Lehrer_id"), rs.getInt("Raum_id"));
                    klasse_list.add(klasse);
                }
                show_Klasse();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_suche3ActionPerformed

    private void speichern3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichern3ActionPerformed
        if (con != null) {
            try {
                String query ="insert into klasse"
                +" (Name,Stufe,Lehrer_id,Raum_id)"
                +" values(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,sname.getText());
                pst.setString(2,sstufe.getText());
                
                int s = LehrerComboBox.getSelectedIndex();
                 System.out.println((String) LehrerComboBox.getSelectedItem() + s);
                int l = lehrer_list.get(s);
                System.out.println("afd" + l);
                int s2 = RaumComboBox.getSelectedIndex();
                int m = raum_list.get(s2);
                
                pst.setInt(3, l);
                pst.setInt(4, m);
                //pst.setString(2,LehrerComboBox.getText());
                //pst.setString(3,RaumComboBox.getText());
                                
                pst.executeUpdate();
                System.out.println(pst);
                getAllKlasse();
                show_klasse();
            }
            catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Sie haben sich falsch angemeldet!");
            }
        }
    }//GEN-LAST:event_speichern3ActionPerformed

    private void suchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suchKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_suchKeyReleased

    private void suchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suchActionPerformed

    private void klassetabelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_klassetabelleMouseClicked
        int row=klassetabelle.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) klassetabelle.getModel();

        sid.setText(model.getValueAt(row, 0).toString());
        sname.setText(model.getValueAt(row, 1).toString());
        sstufe.setText(model.getValueAt(row, 2).toString());
        //LehrerComboBox.setText(model.getValueAt(row, 2).toString());
        //RaumComboBox.setText(model.getValueAt(row, 3).toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_klassetabelleMouseClicked

    public void cop() { getAllLehrer();
        try{
            String query ="select * from hoca";
            System.out.println(query);
            Statement st =con.createStatement();
            rs=st.executeQuery(query);
            while(rs.next()){
                int pkey =rs.getInt("id");
                try{
                    query ="UPDATE Klasse SET Lehrer_id=? WHERE ID=?";                
                    pst = con.prepareStatement(query);

                    pst.setInt(1,pkey);
                    
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, e);
                }  
            }             
        }catch(Exception e){
        System.out.println(e);
        JOptionPane.showMessageDialog(null, e);
        
        }
    }
    
    private void RaumComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaumComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_RaumComboBoxActionPerformed

    private void tümögrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tümögrenciActionPerformed
        // TODO add your handling code here:
        for(int i=0; i<= studentcheckBoxes.size(); i++){
            studentcheckBoxes.elementAt(i).setSelected(true);
        }
    }//GEN-LAST:event_tümögrenciActionPerformed

    private void btNeu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNeu2ActionPerformed
        ID.setText("");
        name.setText("");
        stufe.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_btNeu2ActionPerformed

    private void btSuchen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuchen2ActionPerformed
        // TODO add your handling code here:
        if (con != null) {
            try {                       
               
                Statement st = con.createStatement();
                rs = st.executeQuery("select * from klasse WHERE NAME LIKE '%" + name.getText() + "%'" );
                klasse_list.removeAllElements();
                Klasse klasse;
                while(rs.next()){
                    klasse = new Klasse(rs.getInt("ID"), rs.getString("Name"), rs.getString("Stufe"), rs.getInt("Lehrer_id"), rs.getInt("Raum_id"));
                    klasse_list.add(klasse);
                }
                show_Klasse();
            } catch (Exception e) { 
                System.out.println(e);
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btSuchen2ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void btZuteilenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZuteilenActionPerformed
        if(con!=null){
            //ögrenci dagitma
            for(int i=0; i < studentcheckBoxes.size(); i++){
                if(studentcheckBoxes.elementAt(i).isSelected()){
                    //i nci ögrenciyi vektörden al id sinini al,tabelledenesn get selected index (tabelleden)
                 
                        try { 

                            String query ="insert into Student2Klasse"   
                               +"(Student_id, Klase_id)"
                               +" Values(?,?)";
                            PreparedStatement pst = con.prepareStatement(query);
                            
                            int m = Student_list.get(i);
                            
                            int row=klassetable.getSelectedRow();
                            DefaultTableModel model = (DefaultTableModel) klassetable.getModel();
                            int a= (Integer)model.getValueAt(row, 0);
            
                            pst.setInt(1,m); 
                            System.out.println("a");
                            pst.setInt(2,a); 
                               System.out.println("b");
                            pst.executeUpdate();
                               System.out.println("c");
                           

                        }  catch (SQLException e) { 
                            JOptionPane.showMessageDialog(null,"Sie haben sich falsch angemeldet! " + e);
                        }
        
                       System.out.println("d");
                }
            }

        }
    }//GEN-LAST:event_btZuteilenActionPerformed

    private void btNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNeuActionPerformed

        jahr.setText("");
        niveau.setText("");
        fach.setText("");
    }//GEN-LAST:event_btNeuActionPerformed

    private void btSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuchenActionPerformed
        System.out.println("Suchen a basildi");
        if(con!=null){
            try{
                String query ="select * from Student"; // WHERE Deutschniveau LIKE '%?%'" + tfSuchen.getText();

                if (!niveau.getText().equals("")) {
                    query = query + " WHERE Stufe=" + niveau.getText();
                }
                if (!jahr.getText().equals("")) {
                    query = query + " WHERE anfangsjahr =" + jahr.getText();
                }
                if (!fach.getText().equals("")) {
                    query = query + " WHERE fach LIKE '%" + fach.getText() + "%'";
                }

                System.out.println(query);
                Statement st =con.createStatement();
                rs=st.executeQuery(query);

                Student_list.removeAllElements();
                ogrenciler.removeAll();
                ogrenciler.updateUI();
                ogrenci student;
                int i = 0;

                while(rs.next()){
                    System.out.println("Ögrenciler paneline girildi");

                    JLabel L1 =new JLabel("" + rs.getInt("Matrikelnummer"));
                    JLabel L2 =new JLabel(rs.getString("Vorname"));
                    JLabel L3 =new JLabel(rs.getString("Nachname"));
                    JLabel L4 =new JLabel(rs.getString("Geschlecht"));
                    JLabel L5 =new JLabel(rs.getString("Stufe"));
                    JLabel L6 =new JLabel("" +rs.getInt("Anfangsjahr"));
                    JLabel L7 =new JLabel(rs.getString("Fach"));
                    JCheckBox a =new JCheckBox();
                    
                        Student_list.add(rs.getInt("Matrikelnummer"));
                        studentcheckBoxes.add(a);
                                 
                    
                    // x y genislik yukseklik
                    int y = 10+50*i;
                    System.out.println(y);
                    a.setBounds(0, y, 40, 40);
                    L1.setBounds(20,  y, 100, 40);
                    L2.setBounds(120, y, 100, 40);
                    L3.setBounds(220, y, 100, 40);
                    L4.setBounds(320, y, 100, 40);
                    L5.setBounds(420, y, 100, 40);
                    L6.setBounds(520, y, 100, 40);
                    L7.setBounds(620, y, 100, 40);
                    /* L1.setLocation(30, 100+50*i);
                    L2.setLocation(130, 100+50*i);
                    L3.setLocation(230, 100+50*i);
                    L4.setLocation(330, 100+50*i); */
                    ogrenciler.add(L1);
                    ogrenciler.add(L2);
                    ogrenciler.add(L3);
                    ogrenciler.add(L4);
                    ogrenciler.add(L5);
                    ogrenciler.add(L6);
                    ogrenciler.add(L7);
                    ogrenciler.add(a);
                    
                   
                    /*
                    for(int x = 0; x < CheckBoxNumber ; x++) {
                        jCheckboxArray[x] = new javax.swing.JCheckBox();
                        jCheckboxArray[x].setText("CheckBox " + x);
                        ögrenciler.add(jCheckboxArray[x]);
                    }*/
                    i++;
                }
                ogrenciler.updateUI();
            }catch(SQLException e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btSuchenActionPerformed

    private void stufeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stufeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stufeActionPerformed

    private void klassetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_klassetableMouseClicked
        // TODO add your handling code here:
            int row2=klassetable.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) klassetable.getModel();
            int a= (Integer)model.getValueAt(row2, 0);
      
            if (con != null) {
            try {                       
                String query ="select * from Student2Klasse WHERE Klase_id=" +a;
                Statement st = con.createStatement();
                rs=st.executeQuery(query);
                
                DefaultTableModel model2 = (DefaultTableModel) student2klassetabelle.getModel();
                model2.setRowCount(0);
                   System.out.println("a " + a);
                while(rs.next()){
                    
                        int c =rs.getInt("Student_id");
                        String y ="select * from Student WHERE Matrikelnummer=" +c;
                  
                        Statement stm = con.createStatement();
                        ResultSet rsm=stm.executeQuery(y);
                        
                        if (rsm.next()) {
                            
                            String name= rsm.getString("Vorname");
                            String nachname = rsm.getString("Nachname");


                            Object[] row = new Object[3];
                            row[0]=name;
                            row[1]=nachname;
                            row[2]=rsm.getInt("Matrikelnummer");
                            model2.addRow(row);
                            
                        }
                              
                      
                }

            } catch (Exception e) { 
                System.out.println(e);
                JOptionPane.showMessageDialog(null,e);
            }
        }
                                                           
            
            /*ID.setText(model.getValueAt(row, 0).toString());                      
                name.setText(model.getValueAt(row, 1).toString());                      
                stufe.setText(model.getValueAt(row, 2).toString());   
            */
                //.setText(model.getValueAt(row, 3).toString()); 
    }//GEN-LAST:event_klassetableMouseClicked

    private void sstufeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sstufeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sstufeActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> LehrerComboBox;
    private javax.swing.JComboBox<String> RaumComboBox;
    private javax.swing.JButton bearbeit3;
    private javax.swing.JButton btNeu;
    private javax.swing.JButton btNeu2;
    private javax.swing.JButton btSuchen;
    private javax.swing.JButton btSuchen2;
    private javax.swing.JButton btZuteilen;
    private javax.swing.JTextField fach;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jahr;
    private javax.swing.JTable klassetabelle;
    private javax.swing.JTable klassetable;
    private javax.swing.JLabel lbAnfangsjahr;
    private javax.swing.JLabel lbDeutschniveau;
    private javax.swing.JLabel lbFach;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbKapazitat;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lname;
    private javax.swing.JButton lösch;
    private javax.swing.JTextField löschen;
    private javax.swing.JTextField name;
    private javax.swing.JButton neu3;
    private javax.swing.JTextField niveau;
    private javax.swing.JPanel ogrenciler;
    private javax.swing.JLabel sID;
    private javax.swing.JLabel sID1;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    private javax.swing.JLabel snn;
    private javax.swing.JButton speichern3;
    private javax.swing.JTextField sstufe;
    private javax.swing.JTable student2klassetabelle;
    private javax.swing.JTextField stufe;
    private javax.swing.JLabel su3;
    private javax.swing.JTextField such;
    private javax.swing.JButton suche3;
    private javax.swing.JLabel svn;
    private javax.swing.JCheckBox tümögrenci;
    // End of variables declaration//GEN-END:variables
}
