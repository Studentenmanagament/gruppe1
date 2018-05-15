/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//SATIR 454 501 VE DAHA BİRÇOK YER İÇİN KODUN BAZI YERLERİNİ ANLAYAMADIĞIM İÇİN HATA ÇIKICAK U YÜZDEN LÜTFENAKTİF OLUNCAYARDIMCI OLUN İYİ ÇALIŞMALAR
//Studentte deisiklik yorumu.
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

/**
 *
 * @author Asus
 */
public class StudentFenster extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Vector<ogrenci> Student_list = new Vector<>();
    /**
     * Creates new form Student
     */
    public StudentFenster() {
        initComponents();
        initDB();
        getAllUsers();
        show_user();
        
    }

    
    public void initDB(){
       
        try{
          Class.forName("org.hsqldb.jdbcDriver");
          String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";  
          con = DriverManager.getConnection(url,"G1", "1234");

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentFenster.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(StudentFenster.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true"; 

    }
    
    
    public void getAllUsers(){
        if (con != null) {
        Student_list.removeAllElements();
            
        try { 

            String query ="SELECT * FROM Student";
            Statement st= con.createStatement();
            rs =st.executeQuery(query);
            ogrenci student;
            while(rs.next()){
            student = new ogrenci(rs.getInt("Matrikelnummer"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getInt("TC"),rs.getString("Geschlecht"),rs.getString("Ort"),rs.getString("Bezirk"),rs.getString("Strasse"),rs.getInt("Hausnummer"),rs.getInt("PLZ"), rs.getString("Fach"),rs.getString("Geburtsdatum"),rs.getString("Tel"),rs.getString("Email"),rs.getInt("AnfangsJahr"));
                
                Student_list.add(student);
            }
    }catch (Exception e) { 
                   JOptionPane.showMessageDialog(null,"Wir haben Problem!");
            }
        }
        
    }
    
    public void show_user(){
        DefaultTableModel model = (DefaultTableModel) ogrenciler.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i=0; i<Student_list.size(); i++){
        row[0]=Student_list.get(i).getMatrikelnummer();
        row[1]=Student_list.get(i).getTC();
        row[2]=Student_list.get(i).getVorname();
        row[3]=Student_list.get(i).getNachname();
        row[4]=Student_list.get(i).getFach();
        row[5]=Student_list.get(i).getAnfangsjahr();
        model.addRow(row);
        
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMatrikel = new javax.swing.JLabel();
        lbVorname = new javax.swing.JLabel();
        lbNachname = new javax.swing.JLabel();
        lbTC = new javax.swing.JLabel();
        lbGeschlecht = new javax.swing.JLabel();
        lbPLZ = new javax.swing.JLabel();
        lbGeburtsdatum = new javax.swing.JLabel();
        lbOrt = new javax.swing.JLabel();
        lbBezirk = new javax.swing.JLabel();
        lbStrasse = new javax.swing.JLabel();
        lbHausnummer = new javax.swing.JLabel();
        lbTel = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        tfMatrikel = new javax.swing.JTextField();
        tfVorname = new javax.swing.JTextField();
        tfNachname = new javax.swing.JTextField();
        tfTC = new javax.swing.JTextField();
        tfGeschlecht = new javax.swing.JTextField();
        tfPLZ = new javax.swing.JTextField();
        tfOrt = new javax.swing.JTextField();
        tfBezirk = new javax.swing.JTextField();
        tfStrasse = new javax.swing.JTextField();
        tfHausnummer = new javax.swing.JTextField();
        tfTel = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        lbSuche = new javax.swing.JLabel();
        tfSuchen = new javax.swing.JTextField();
        btSuchen = new javax.swing.JButton();
        btNeu = new javax.swing.JButton();
        btSpeichern = new javax.swing.JButton();
        btBearbeiten = new javax.swing.JButton();
        btLoeschen = new javax.swing.JButton();
        lbFach = new javax.swing.JLabel();
        tfFach = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbAnfangsJahr = new javax.swing.JLabel();
        tfAnfangsJahr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ogrenciler = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lbMatrikel.setText("MatrikelNummer");

        lbVorname.setText("Vorname");

        lbNachname.setText("Nachname");

        lbTC.setText("TC");

        lbGeschlecht.setText("Geschlecht");

        lbPLZ.setText("PLZ");

        lbGeburtsdatum.setText("Geburtsdatum");

        lbOrt.setText("Ort");

        lbBezirk.setText("Bezirk");

        lbStrasse.setText("Strasse");

        lbHausnummer.setText("Hausnummer");

        lbTel.setText("Telefonnummer");

        lbEmail.setText("Email");

        tfTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTCActionPerformed(evt);
            }
        });

        tfOrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOrtActionPerformed(evt);
            }
        });

        tfStrasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStrasseActionPerformed(evt);
            }
        });

        lbSuche.setText("Suche");

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

        btSpeichern.setText("Speichern");
        btSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpeichernActionPerformed(evt);
            }
        });

        btBearbeiten.setText("Bearbeiten");
        btBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBearbeitenActionPerformed(evt);
            }
        });

        btLoeschen.setText("Löschen");
        btLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoeschenActionPerformed(evt);
            }
        });

        lbFach.setText("Fach");

        tfFach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFachActionPerformed(evt);
            }
        });

        lbAnfangsJahr.setText("AnfangsJahr");

        ogrenciler.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        ogrenciler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrikelnummer", "TC", "Vorname", "Nachname", "Fach", "Anfangsjahr"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ogrenciler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ogrencilerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ogrenciler);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSuche)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSuchen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbVorname)
                            .addComponent(lbNachname)
                            .addComponent(lbTC)
                            .addComponent(lbGeschlecht)
                            .addComponent(lbMatrikel))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfGeschlecht, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(tfTC)
                            .addComponent(tfNachname)
                            .addComponent(tfVorname)
                            .addComponent(tfMatrikel)))
                    .addComponent(btNeu, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btSpeichern)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBearbeiten))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbPLZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbHausnummer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(tfHausnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbStrasse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbBezirk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfBezirk, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbOrt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btSuchen)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbTel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbFach)
                            .addGap(73, 73, 73)
                            .addComponent(tfFach, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbAnfangsJahr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btLoeschen)
                                .addComponent(tfAnfangsJahr, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbGeburtsdatum)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSuche)
                    .addComponent(tfSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSuchen))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMatrikel)
                                .addComponent(tfMatrikel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbFach)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfFach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbOrt)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbVorname)
                        .addComponent(lbBezirk)
                        .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfBezirk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbGeburtsdatum))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNachname)
                    .addComponent(lbStrasse)
                    .addComponent(tfNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTC)
                    .addComponent(lbHausnummer)
                    .addComponent(tfTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHausnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTel)
                    .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGeschlecht)
                    .addComponent(tfGeschlecht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPLZ)
                    .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAnfangsJahr)
                    .addComponent(tfAnfangsJahr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNeu)
                    .addComponent(btSpeichern)
                    .addComponent(btBearbeiten)
                    .addComponent(btLoeschen))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfOrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOrtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOrtActionPerformed

    private void tfTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTCActionPerformed

    private void tfStrasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStrasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStrasseActionPerformed

    private void tfFachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFachActionPerformed

    private void btLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoeschenActionPerformed
        if(con!=null){
            int onay = JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "Student", JOptionPane.YES_NO_OPTION);
            
            if(onay==JOptionPane.YES_OPTION){
                try{ 
                    //DATABANK TABLOSUNUN ADINI HENÜZ BİLMİYORUZ
                    String query ="DELETE FROM Student WHERE Matrikelnummer=?";                
                    pst = con.prepareStatement(query);
                    //SILME İSLEMİNİ SOR
                    pst.setInt(1,Integer.parseInt(tfSuchen.getText()));
                    pst.executeUpdate();
                    
                    
                    getAllUsers();
                    show_user();
                    JOptionPane.showMessageDialog(null,"Gelöscht!");
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Nicht Gelöscht!");
                }
 
            }else {           

            }

        }
    }//GEN-LAST:event_btLoeschenActionPerformed

    private void btNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNeuActionPerformed
        tfMatrikel.setText("");
        tfVorname.setText("");
        tfNachname.setText("");
        tfTC.setText("");
        tfGeschlecht.setText("");
        jDateChooser1.setDateFormatString("");
        tfOrt.setText("");
        tfBezirk.setText("");
        tfStrasse.setText("");
        tfHausnummer.setText("");
        tfPLZ.setText("");
        tfFach.setText("");
        tfEmail.setText("");
        tfTel.setText("");
        tfAnfangsJahr.setText("");
               
    }//GEN-LAST:event_btNeuActionPerformed

    private void btSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpeichernActionPerformed
       if(con!=null){
           try{
               
               String query = "insert into Student"
                       +" (Matrikelnummer,Vorname,Nachname,TC,Geburtsdatum,Geschlecht,PLZ,Ort,Bezirk,Strasse,Hausnummer,Tel,Email,Fach,AnfangsJahr)"
                       +" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement pst = con.prepareStatement(query);

               pst.setInt(1,Integer.parseInt(tfMatrikel.getText()));
               pst.setString(2,tfVorname.getText());
               pst.setString(3,tfNachname.getText());
               pst.setString(4,tfTC.getText());
               pst.setString(5,jDateChooser1.getDateFormatString());
               pst.setString(6,tfGeschlecht.getText());
               pst.setInt(7,Integer.parseInt(tfPLZ.getText()));
               pst.setString(8,tfOrt.getText());
               pst.setString(9,tfBezirk.getText());
               pst.setString(10,tfStrasse.getText());
               pst.setInt(11,Integer.parseInt(tfHausnummer.getText()));
               pst.setString(12,tfTel.getText());
               pst.setString(13,tfEmail.getText());
               pst.setString(14,tfFach.getText());
               pst.setInt(15,Integer.parseInt(tfAnfangsJahr.getText()));
               pst.executeUpdate();
               
               
               getAllUsers();
               show_user();
               JOptionPane.showMessageDialog(null,"Gespeichert!");
               
           }catch(SQLException e){
               System.out.println(e);
                              JOptionPane.showMessageDialog(null,"falsch angemeldet!"); 
           }
       }
    }//GEN-LAST:event_btSpeichernActionPerformed

    private void btSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuchenActionPerformed
        if(con!=null){
            try{
                String query ="select * from Student WHERE MATRIKELNUMMER LIKE '%?%' ";
                Statement st =con.createStatement();
                rs=st.executeQuery("select * from Student WHERE MATRIKELNUMMER LIKE '%"+ tfSuchen.getText()+"%'");
    
                Student_list.removeAllElements();
                ogrenci student;
                while(rs.next()==true){
                    student = new ogrenci(rs.getInt("Matrikelnummer"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getInt("TC"),rs.getString("Geschlecht"),rs.getString("Ort"),rs.getString("Bezirk"),rs.getString("Strasse"),rs.getInt("Hausnummer"),rs.getInt("PLZ"), rs.getString("Fach"),rs.getString("Geburtsdatum"),rs.getString("Tel"),rs.getString("Email"),rs.getInt("AnfangsJahr"));
                    Student_list.add(student);                
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btSuchenActionPerformed

    private void btBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBearbeitenActionPerformed
        if(con!=null){
            int soru = JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "student", JOptionPane.YES_NO_OPTION);
            
            if(soru==0){
                
                try{
                String query = "UPDATE Student SET Matrikelnummer=?, Vorname=?,Nachname=?,TC=?,Geburtsdatum=?,Geschlecht=?,Ort=?,Bezirk=?,Strasse=?,Hausnummer=?,PLZ=?,Tel=?,Email=?,Fach=?,AnfangsJahr=?";
                pst=con.prepareStatement(query);
                
                pst.setString(1,tfMatrikel.getText());
                pst.setString(2,tfVorname.getText());
                pst.setString(3,tfNachname.getText());
                pst.setInt(4,Integer.parseInt(tfTC.getText()));
                pst.setString(5,tfGeschlecht.getText());
                pst.setString(6,tfOrt.getText());
                pst.setString(7,tfBezirk.getText());
                pst.setString(8,tfStrasse.getText());
                pst.setInt(9,Integer.parseInt(tfHausnummer.getText()));
                pst.setInt(10,Integer.parseInt(tfPLZ.getText()));
                pst.setString(11,tfFach.getText());
                pst.setString(12,tfEmail.getText());
                pst.setString(13,tfTel.getText());
                pst.setInt(14, Integer.parseInt(tfAnfangsJahr.getText()));
                pst.executeUpdate();
                
                getAllUsers();
                show_user();
                JOptionPane.showMessageDialog(null,"Bearbeitet!");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"falsch angemeldet!");
            }
        }else{
              JOptionPane.showMessageDialog(null,"Nicht bearbeitet!");    
            }
        }
   
    
    }//GEN-LAST:event_btBearbeitenActionPerformed

    private void ogrencilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ogrencilerMouseClicked

        int row=ogrenciler.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) ogrenciler.getModel();

        tfMatrikel.setText(model.getValueAt(row, 0).toString());
        tfTC.setText(model.getValueAt(row, 1).toString());
        tfVorname.setText(model.getValueAt(row, 2).toString());
        tfNachname.setText(model.getValueAt(row, 3).toString());
        tfFach.setText(model.getValueAt(row, 4).toString());
        tfAnfangsJahr.setText(model.getValueAt(row, 5).toString());
        

        // TODO add your handling code here:
    }//GEN-LAST:event_ogrencilerMouseClicked
    

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBearbeiten;
    private javax.swing.JButton btLoeschen;
    private javax.swing.JButton btNeu;
    private javax.swing.JButton btSpeichern;
    private javax.swing.JButton btSuchen;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAnfangsJahr;
    private javax.swing.JLabel lbBezirk;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFach;
    private javax.swing.JLabel lbGeburtsdatum;
    private javax.swing.JLabel lbGeschlecht;
    private javax.swing.JLabel lbHausnummer;
    private javax.swing.JLabel lbMatrikel;
    private javax.swing.JLabel lbNachname;
    private javax.swing.JLabel lbOrt;
    private javax.swing.JLabel lbPLZ;
    private javax.swing.JLabel lbStrasse;
    private javax.swing.JLabel lbSuche;
    private javax.swing.JLabel lbTC;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbVorname;
    private javax.swing.JTable ogrenciler;
    private javax.swing.JTextField tfAnfangsJahr;
    private javax.swing.JTextField tfBezirk;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFach;
    private javax.swing.JTextField tfGeschlecht;
    private javax.swing.JTextField tfHausnummer;
    private javax.swing.JTextField tfMatrikel;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfOrt;
    private javax.swing.JTextField tfPLZ;
    private javax.swing.JTextField tfStrasse;
    private javax.swing.JTextField tfSuchen;
    private javax.swing.JTextField tfTC;
    private javax.swing.JTextField tfTel;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables
}

