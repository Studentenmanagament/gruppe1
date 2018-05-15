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
    Vector <ogrenci> Student_list = new Vector<>();
    Vector <Raum> raum_list = new Vector<>();
    Vector <JCheckBox> ögrenciBox = new Vector<>();
    Vector <JCheckBox> sinifBox = new Vector<>();
    
    
    public StudentenklasseFenster() {
        initComponents();
       // initDB();
    }
    public void initDB() {

       try { 
           Class.forName("org.hsqldb.jdbcDriver"); 
           String url = "jdbc:hsqldb:file:C:\\Users\\emirhan\\Desktop\\sql\\;shutdown=true";  
           con = DriverManager.getConnection(url,"G1", "1234");
           } catch (ClassNotFoundException ex) {
            Logger.getLogger(LehrersFenster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LehrersFenster.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url = "jdbc:hsqldb:file:C:\\Users\\emirhan\\Desktop\\sql\\;shutdown=true"; 
    }

    
    
    
    /*public void getAllRaum(){
        raum_list.removeAllElements();

        if (con != null) {
        try {
           String query ="SELECT * FROM raum";
           Statement st= con.createStatement();
           rs =st.executeQuery(query);
           Raum raum;
           while(rs.next()){
                raum = new Raum (rs.getInt("ID"), rs.getString("Name"),rs.getString("Lagebeschreibung"),rs.getInt("Kapazitat"));
                raum_list.add(raum);
            }
           } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null,e);
           }
        }
    }
    
    public void show_Raum(){
        
        DefaultTableModel model = (DefaultTableModel) tabelleraum.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for(int i=0;i<raum_list.size();i++){
            row[0]=raum_list.get(i).getID();
            row[1]=raum_list.get(i).getName();
            row[2]=raum_list.get(i).getKapazitat();
            model.addRow(row);
        }
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
        DefaultTableModel model = (DefaultTableModel) tabellestudent.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for(int i=0; i<Student_list.size(); i++){
        row[0]=Student_list.get(i).getMatrikelnummer();
        row[1]=Student_list.get(i).getVorname();
        row[2]=Student_list.get(i).getNachname();
        row[3]=Student_list.get(i).getFach();
        row[4]=Student_list.get(i).getAnfangsjahr();
        model.addRow(row);
        
    }
    }
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        kapazitat = new javax.swing.JTextField();
        btSuchen2 = new javax.swing.JButton();
        btNeu2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ögrenciler = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        siniflar = new javax.swing.JPanel();
        tümsinif = new javax.swing.JCheckBox();
        tümögrenci = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        lbID.setText("ID");

        lbName.setText("Name");

        lbKapazitat.setText("Kapazität");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
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

        javax.swing.GroupLayout ögrencilerLayout = new javax.swing.GroupLayout(ögrenciler);
        ögrenciler.setLayout(ögrencilerLayout);
        ögrencilerLayout.setHorizontalGroup(
            ögrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        ögrencilerLayout.setVerticalGroup(
            ögrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(ögrenciler);

        javax.swing.GroupLayout siniflarLayout = new javax.swing.GroupLayout(siniflar);
        siniflar.setLayout(siniflarLayout);
        siniflarLayout.setHorizontalGroup(
            siniflarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        siniflarLayout.setVerticalGroup(
            siniflarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(siniflar);

        tümsinif.setText("jCheckBox1");

        tümögrenci.setText("jCheckBox2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSuchen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNeu2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSuchen2)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kapazitat)
                        .addComponent(ID)
                        .addComponent(name)))
                .addGap(150, 150, 150))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tümögrenci)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tümsinif)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(265, 265, 265))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btZuteilen)
                        .addGap(100, 100, 100))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btNeu2)
                                .addComponent(btSuchen2))
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
                                    .addComponent(kapazitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btNeu)
                                    .addComponent(btSuchen))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tümsinif)
                            .addComponent(tümögrenci))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btZuteilen)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNeu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNeu2ActionPerformed
        ID.setText("");
        name.setText("");
        kapazitat.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_btNeu2ActionPerformed

    private void btSuchen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuchen2ActionPerformed
        // TODO add your handling code here:
        if(con!=null){
            try{
                String query ="select * from RAUM"; // WHERE Deutschniveau LIKE '%?%'" + tfSuchen.getText();
                
                if (!niveau.getText().equals("")) {
                    query = query + " WHERE id LIKE '" + niveau.getText() + "'";
                } 
                if (!jahr.getText().equals("")) {
                    query = query + " WHERE name LIKE '" + jahr.getText() + "'";
                } 
                if (!fach.getText().equals("")) {
                    query = query + " WHERE kapazitat LIKE '" + fach.getText() + "'";
                }  //Burda her bölüm doldurulunca sql koduna sürekli where where yazacak.Kac bölümde doldurulursa buda kodda hata olucak bu haliyle sadece tek kisim doldurulup aran
                   //abilir. 
               
                Statement st =con.createStatement();
                rs=st.executeQuery(query);

                siniflar.removeAll();
                siniflar.setLayout(null);
                ogrenci raum;
                int i = 0;
                while(rs.next()==true){
                
                        JLabel L1 =new JLabel("" +rs.getInt("ID"));
                        JLabel L2 =new JLabel(rs.getString("Name"));
                        JLabel L3 =new JLabel(rs.getString("Kapazitat"));
                        L1.setLocation(30, 100+50*i);
                        L2.setLocation(130, 100+50*i);
                        L3.setLocation(230, 100+50*i);
                        siniflar.add(L1);
                        siniflar.add(L2);
                        siniflar.add(L3);
                        siniflar.validate();
                        /*for(int x = 0; x < CheckBoxNumber ; x++) {
                            jCheckboxArray[x] = new javax.swing.JCheckBox();
                            jCheckboxArray[x].setText("CheckBox " + x);
                            siniflar.add(jCheckboxArray[x]);
                        }*/
                    
                    
                   
                }
                siniflar.updateUI();                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btSuchen2ActionPerformed

    private void btZuteilenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btZuteilenActionPerformed
        if(con!=null){
          //ögrenci dagitma
        }
    }//GEN-LAST:event_btZuteilenActionPerformed

    private void btNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNeuActionPerformed
        niveau.setText("");
        jahr.setText("");
        fach.setText("");

    }//GEN-LAST:event_btNeuActionPerformed

    private void btSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuchenActionPerformed
System.out.println("dsadsad");     
//   if(con!=null){
            try{
                String query ="select * from Student"; // WHERE Deutschniveau LIKE '%?%'" + tfSuchen.getText();
                
                if (!niveau.getText().equals("")) {
                    query = query + " WHERE Deutschniveau LIKE '" + niveau.getText() + "'";
                } 
                if (!jahr.getText().equals("")) {
                    query = query + " WHERE jahr LIKE '" + jahr.getText() + "'";
                } 
                if (!fach.getText().equals("")) {
                    query = query + " WHERE fach LIKE '" + fach.getText() + "'";
                } 
               
               // Statement st =con.createStatement();
               // rs=st.executeQuery(query);

                ögrenciler.removeAll();
                ogrenci student;
                ögrenciler.setLayout(null);
                int i = 0;
                
                while(i < 10){
                //System.out.println("dasdasd");    
                        
                        JLabel L1 =new JLabel("" +rs.getInt("Matrikelnummer"));
                        JLabel L2 =new JLabel(rs.getString("Vorname"));
                        JLabel L3 =new JLabel(rs.getString("Nachname"));
                        JLabel L4 =new JLabel(rs.getString("Vorname"));
                        L1.setLocation(30, 100+50*i);
                        L2.setLocation(130, 100+50*i);
                        L3.setLocation(230, 100+50*i);
                        L4.setLocation(330, 100+50*i);
                        ögrenciler.add(L1);
                        ögrenciler.add(L2);
                        ögrenciler.add(L3);
                        ögrenciler.add(L4);                        
                        ögrenciler.validate();
                      /*  for(int x = 0; x < CheckBoxNumber ; x++) {
                            jCheckboxArray[x] = new javax.swing.JCheckBox();
                            jCheckboxArray[x].setText("CheckBox " + x);
                            ögrenciler.add(jCheckboxArray[x]);
                        }*/
                    
                    
                   i++;
                }
                ögrenciler.updateUI();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
       // }
    }//GEN-LAST:event_btSuchenActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

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
            java.util.logging.Logger.getLogger(StudentenklasseFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentenklasseFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentenklasseFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentenklasseFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentenklasseFenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton btNeu;
    private javax.swing.JButton btNeu2;
    private javax.swing.JButton btSuchen;
    private javax.swing.JButton btSuchen2;
    private javax.swing.JButton btZuteilen;
    private javax.swing.JTextField fach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jahr;
    private javax.swing.JTextField kapazitat;
    private javax.swing.JLabel lbAnfangsjahr;
    private javax.swing.JLabel lbDeutschniveau;
    private javax.swing.JLabel lbFach;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbKapazitat;
    private javax.swing.JLabel lbName;
    private javax.swing.JTextField name;
    private javax.swing.JTextField niveau;
    private javax.swing.JPanel siniflar;
    private javax.swing.JCheckBox tümsinif;
    private javax.swing.JCheckBox tümögrenci;
    private javax.swing.JPanel ögrenciler;
    // End of variables declaration//GEN-END:variables
}
