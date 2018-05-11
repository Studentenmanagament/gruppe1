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

/**
 *
 * @author Asus
 */
public class Student extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Vector<user> user_list = new Vector<>();
    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
        initDB();
        getAllusers();
        show_user();
        
    }

    
    public void initDB(){
       
        try{
          Class.forName("org.hsqldb.jdbcDriver");
          String url = "jdbc:hsqldb:file:C:\\Users\\Asus\\Desktop\\sql\\;shutdown=true";  
          con = DriverManager.getConnection(url,"G1", "1234");

        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url = "jdbc:hsqldb:file:C:\\Users\\Asus\\Desktop\\sql\\;shutdown=true"; 

    }
    
    
    public void getAllUsers(){
        if (con != null) {
        user_list.removeAllElements();
            
        try { 

            String query ="SELECT * FROM DATABANTABLOADI";
            Statement st= con.createStatement();
            rs =st.executeQuery(query);
            user User;
            while(rs.next()){
            User = new user(rs.getDouble("Martikelnummer"),rs.getString("Vorname"),rs.getString("Nachname"),rs.getInt("TC"),rs.getInt("Geburtsdatum"),rs.getString("Geschlecht"),rs.getString("Fach"),rs.getString("Ort"),rs.getString("Bezirk"),rs.getString("Strasse"),rs.getString("Hausnummer"),rs.getString("Tel"),rs.getString("Email"));
                
                user_list.add(User);
            }
    }catch (Exception e) { 
                   JOptionPane.showMessageDialog(null,"Olmadı");
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablo_Student = new javax.swing.JTable();
        lbMartikel = new javax.swing.JLabel();
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
        tfMartikel = new javax.swing.JTextField();
        tfVorname = new javax.swing.JTextField();
        tfNachname = new javax.swing.JTextField();
        tfTC = new javax.swing.JTextField();
        tfGesclecht = new javax.swing.JTextField();
        tfPLZ = new javax.swing.JTextField();
        tfOrt = new javax.swing.JTextField();
        tfBezirk = new javax.swing.JTextField();
        tfStrasse = new javax.swing.JTextField();
        tfHausnummer = new javax.swing.JTextField();
        tfTel = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        LbSuche = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        btSuchen = new javax.swing.JButton();
        btNeu = new javax.swing.JButton();
        btSpeichern = new javax.swing.JButton();
        btBearbeiten = new javax.swing.JButton();
        btLoeschen = new javax.swing.JButton();
        lbFach = new javax.swing.JLabel();
        tfTemp = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tablo_Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MartikelNummer", "TC", "Vorname", "Nachname", "Fach", "AnfangsJahr"
            }
        ));
        jScrollPane1.setViewportView(Tablo_Student);

        lbMartikel.setText("MartikelNummer");

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

        LbSuche.setText("Suche");

        btSuchen.setText("Suchen");

        btNeu.setText("NeueStudent");

        btSpeichern.setText("Speichern");

        btBearbeiten.setText("Bearbeiten");

        btLoeschen.setText("Löschen");

        lbFach.setText("Fach");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGeburtsdatum)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(LbSuche)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbVorname)
                                            .addComponent(lbNachname)
                                            .addComponent(lbTC)
                                            .addComponent(lbGeschlecht)
                                            .addComponent(lbMartikel)
                                            .addComponent(lbFach))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tfGesclecht)
                                                    .addComponent(tfTC)
                                                    .addComponent(tfNachname)
                                                    .addComponent(tfVorname)
                                                    .addComponent(tfMartikel)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbEmail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbOrt)
                                                    .addComponent(lbBezirk)
                                                    .addComponent(lbStrasse)
                                                    .addComponent(lbHausnummer)
                                                    .addComponent(lbTel)
                                                    .addComponent(lbPLZ))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tfHausnummer, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                                        .addComponent(tfTel)
                                                        .addComponent(tfOrt)
                                                        .addComponent(tfBezirk)
                                                        .addComponent(tfStrasse))
                                                    .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btBearbeiten)
                                            .addComponent(btSpeichern)
                                            .addComponent(btNeu)
                                            .addComponent(btLoeschen)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btSuchen)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbSuche)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSuchen))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMartikel)
                    .addComponent(lbOrt)
                    .addComponent(tfMartikel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNeu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVorname)
                    .addComponent(lbBezirk)
                    .addComponent(tfVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBezirk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNachname)
                    .addComponent(lbStrasse)
                    .addComponent(tfNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpeichern))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTC)
                    .addComponent(lbHausnummer)
                    .addComponent(tfTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHausnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGeschlecht)
                    .addComponent(lbTel)
                    .addComponent(tfGesclecht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBearbeiten))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbPLZ)
                        .addComponent(tfPLZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFach)
                        .addComponent(tfTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGeburtsdatum)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btLoeschen)
                                .addComponent(lbEmail)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbSuche;
    private javax.swing.JTable Tablo_Student;
    private javax.swing.JButton btBearbeiten;
    private javax.swing.JButton btLoeschen;
    private javax.swing.JButton btNeu;
    private javax.swing.JButton btSpeichern;
    private javax.swing.JButton btSuchen;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JLabel lbBezirk;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFach;
    private javax.swing.JLabel lbGeburtsdatum;
    private javax.swing.JLabel lbGeschlecht;
    private javax.swing.JLabel lbHausnummer;
    private javax.swing.JLabel lbMartikel;
    private javax.swing.JLabel lbNachname;
    private javax.swing.JLabel lbOrt;
    private javax.swing.JLabel lbPLZ;
    private javax.swing.JLabel lbStrasse;
    private javax.swing.JLabel lbTC;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbVorname;
    private javax.swing.JTextField tfBezirk;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfGesclecht;
    private javax.swing.JTextField tfHausnummer;
    private javax.swing.JTextField tfMartikel;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfOrt;
    private javax.swing.JTextField tfPLZ;
    private javax.swing.JTextField tfStrasse;
    private javax.swing.JTextField tfTC;
    private javax.swing.JTextField tfTel;
    private javax.swing.JTextField tfTemp;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables
}
