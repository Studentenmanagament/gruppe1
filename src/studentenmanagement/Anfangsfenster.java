/* Sonunda bir commit
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement;


 
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import studentenmanagement.Klasse.*;

   

/**
 *
 * @author mertcenk
 */
public class Anfangsfenster extends javax.swing.JFrame {

    
    File studenten_file = null;
    File raum_file = null;
    File klasse_file = null;
    File lehrer_file = null;
    Connection con = null;
    /**
     * Creates new form Anfangsfenster
     * 
     * new change
     */
    public Anfangsfenster() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Student = new javax.swing.JButton();
        Lehrer = new javax.swing.JButton();
        Klasse = new javax.swing.JButton();
        Raum = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Student.setText("Student");
        Student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentActionPerformed(evt);
            }
        });

        Lehrer.setText("Lehrer");
        Lehrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LehrerActionPerformed(evt);
            }
        });

        Klasse.setText("Klasse");
        Klasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KlasseActionPerformed(evt);
            }
        });

        Raum.setText("Raum");
        Raum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaumActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Raum, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Klasse, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lehrer, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Student, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Lehrer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Klasse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Raum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RaumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaumActionPerformed
        RaumFenster frame= new RaumFenster();
        frame.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_RaumActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void StudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentActionPerformed
        // TODO add your handling code here:
        StudentFenster frame= new StudentFenster();
        frame.setVisible(true);
    }//GEN-LAST:event_StudentActionPerformed

    private void LehrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LehrerActionPerformed
        // TODO add your handling code here:
        LehrersFenster frame= new LehrersFenster();
        frame.setVisible(true);
    }//GEN-LAST:event_LehrerActionPerformed

    private void KlasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KlasseActionPerformed
        StudentenklasseFenster frame = new StudentenklasseFenster ();
        frame.setVisible (true);// TODO add your handling code here:
    }//GEN-LAST:event_KlasseActionPerformed

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

 

            System.out.println("Connecting database..."); 

            Class.forName("org.hsqldb.jdbcDriver"); 

            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\"; 

            Connection con = DriverManager.getConnection(url, "G1", "1234"); 

            System.out.println("Database connected!"); 

 

        } catch (ClassNotFoundException e) { 

            System.out.println("Database connection error. ClassNotFoundException"); 

        } catch (SQLException e) { 

            System.out.println("Database connection error. SQLException"); 

        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Anfangsfenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Klasse;
    private javax.swing.JButton Lehrer;
    private javax.swing.JButton Raum;
    private javax.swing.JButton Student;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
