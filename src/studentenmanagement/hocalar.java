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
 * @author domin
 */
public class hocalar extends javax.swing.JFrame {

    
    Connection con = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Vector<user> user_list = new Vector<>();
    
    /**
     * Creates new form hocalar
     */
    public hocalar() {
        initComponents();
        initDB();
        getAllUsers();
        show_user();
    }
    
    public void initDB() {
        
        try { 
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";  
            con = DriverManager.getConnection(url,"G1", "1234");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(hocalar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(hocalar.class.getName()).log(Level.SEVERE, null, ex);
        }
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true"; 
    }
    
    public void getAllUsers(){
        
        
        if (con != null) {
            user_list.removeAllElements();
            try { 

                String query ="SELECT * FROM hoca";
                Statement st= con.createStatement();
                rs =st.executeQuery(query);
                user User;
                while(rs.next()){
                     User =new user(rs.getInt("ID"), rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Benutzername"),rs.getString("Passwort"),rs.getString("Telefonnummer"),rs.getString("Email"));
                     user_list.add(User);
                }
            } catch (Exception e) { 
                   JOptionPane.showMessageDialog(null,e);
            }
        }
        
    }
    
    public void show_user(){
        
        DefaultTableModel model = (DefaultTableModel) hoca.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for(int i=0;i<user_list.size();i++){
            row[0]=user_list.get(i).getID();
            row[1]=user_list.get(i).getVorname();
            row[2]=user_list.get(i).getNachname();
            row[3]=user_list.get(i).getBenutzername();
            row[4]=user_list.get(i).getPasswort();
            row[5]=user_list.get(i).getTel();
            row[6]=user_list.get(i).getEmail();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        hoca = new javax.swing.JTable();
        vn = new javax.swing.JLabel();
        nn = new javax.swing.JLabel();
        bn = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        em = new javax.swing.JLabel();
        su = new javax.swing.JLabel();
        vor = new javax.swing.JTextField();
        nach = new javax.swing.JTextField();
        benutzer = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        such1 = new javax.swing.JTextField();
        speichern = new javax.swing.JButton();
        suche = new javax.swing.JButton();
        bearbeit = new javax.swing.JButton();
        lösche = new javax.swing.JButton();
        neu = new javax.swing.JButton();
        sid = new javax.swing.JTextField();
        sID = new javax.swing.JLabel();
        löschen = new javax.swing.JTextField();
        idl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        hoca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vorname", "Nachname", "Benutzername", "Passwort", "Telefonnummer", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hoca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hocaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hoca);

        vn.setText("Vorname");

        nn.setText("Nachname");

        bn.setText("Benutzername");

        p.setText("Passwort");

        tn.setText("Telefonnummer");

        em.setText("Email");

        su.setText("Suche");

        vor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vorActionPerformed(evt);
            }
        });

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

        such1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                such1ActionPerformed(evt);
            }
        });
        such1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                such1KeyReleased(evt);
            }
        });

        speichern.setBackground(new java.awt.Color(0, 102, 255));
        speichern.setForeground(new java.awt.Color(255, 255, 255));
        speichern.setText("Speichern");
        speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichernActionPerformed(evt);
            }
        });

        suche.setBackground(new java.awt.Color(0, 102, 255));
        suche.setForeground(new java.awt.Color(255, 255, 255));
        suche.setText("Suchen");
        suche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheActionPerformed(evt);
            }
        });

        bearbeit.setBackground(new java.awt.Color(0, 102, 255));
        bearbeit.setForeground(new java.awt.Color(255, 255, 255));
        bearbeit.setText("Bearbeiten");
        bearbeit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitActionPerformed(evt);
            }
        });

        lösche.setBackground(new java.awt.Color(0, 102, 255));
        lösche.setForeground(new java.awt.Color(255, 255, 255));
        lösche.setText("Löschen");
        lösche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                löscheActionPerformed(evt);
            }
        });

        neu.setBackground(new java.awt.Color(0, 102, 255));
        neu.setForeground(new java.awt.Color(255, 255, 255));
        neu.setText("Neu");
        neu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuActionPerformed(evt);
            }
        });

        sid.setEnabled(false);

        sID.setText("ID");

        idl.setText("Benutzername");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(neu)
                        .addGap(188, 188, 188)
                        .addComponent(speichern)
                        .addGap(148, 148, 148)
                        .addComponent(bearbeit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lösche))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(su)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(such1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(suche)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(em)
                                    .addComponent(p)
                                    .addComponent(bn)
                                    .addComponent(tn)
                                    .addComponent(nn)
                                    .addComponent(vn)
                                    .addComponent(sID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98)
                                        .addComponent(idl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(löschen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nach, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(such1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(su, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suche))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sID))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vn)
                    .addComponent(vor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nn)
                    .addComponent(nach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bn))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(em)
                    .addComponent(löschen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idl))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bearbeit)
                    .addComponent(speichern)
                    .addComponent(neu)
                    .addComponent(lösche))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void such1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_such1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_such1ActionPerformed

    private void speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichernActionPerformed
         
        if (con != null) {
            try { 
            
                String query ="insert into hoca"   
                   +"(Vorname,Nachname,Benutzername,Passwort,Telefonnummer,Email)"
                   +"values(?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setString(1,vor.getText()); 
                pst.setString(2,nach.getText());
                pst.setString(3,benutzer.getText());
                pst.setString(4,pass.getText());
                pst.setString(5,tel.getText());
                pst.setString(6,mail.getText());
                pst.executeUpdate();
                
                getAllUsers();
                show_user();              
               
            }  catch (SQLException e) { 
                JOptionPane.showMessageDialog(null,"Sie haben sich falsch angemeldet!");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_speichernActionPerformed

    private void such1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_such1KeyReleased
   


        // TODO add your handling code here:
    }//GEN-LAST:event_such1KeyReleased

    private void sucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheActionPerformed

        if (con != null) {
           
            try {             
                       
                String query ="select * from hoca WHERE VORNAME LIKE '%?%'";
                Statement st = con.createStatement();
                rs = st.executeQuery("select * from hoca WHERE VORNAME LIKE '%" + such1.getText() + "%'" +
                        " OR NACHNAME LIKE '%" + such1.getText() + "%' OR BENUTZERNAME LIKE '%" + such1.getText() + "%'");
            
                
                user_list.removeAllElements();
                user User;
                while(rs.next() == true){
                     User =new user(rs.getInt("ID"), rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Benutzername"),rs.getString("Passwort"),rs.getString("Telefonnummer"),rs.getString("Email"));
                     user_list.add(User);
                }
                show_user();
                
        }  catch (SQLException e) { 
            JOptionPane.showMessageDialog(null,e);
        }
     
        }
// TODO add your handling code here:
    }//GEN-LAST:event_sucheActionPerformed

    private void löscheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_löscheActionPerformed
    
        if (con != null) {
            int onay = JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "hoca", JOptionPane.YES_NO_OPTION);

            if (onay == JOptionPane.YES_OPTION) {   
                                         
                try{ 
                    String query ="DELETE FROM hoca WHERE Benutzername=?";                
                    pst = con.prepareStatement(query);
                    pst.setString(1,löschen.getText());
                    pst.executeUpdate();
                    
                    
                    getAllUsers();
                    show_user();
                    JOptionPane.showMessageDialog(null,"Gelöscht!");
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Nicht Gelöscht!");
                }
                     
            } else {           

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_löscheActionPerformed

    private void bearbeitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitActionPerformed
         
        if (con != null) {
            int yes= JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "hoca", JOptionPane.YES_NO_OPTION);
            if (yes == 0) {  
            
                try { 

                    String query ="UPDATE hoca SET Vorname=?,Nachname=?,Benutzername=?,Passwort=?,Telefonnummer=?,Email=? WHERE ID=?";                
                    pst = con.prepareStatement(query);

                    pst.setString(1,vor.getText());
                    pst.setString(2,nach.getText());
                    pst.setString(3,benutzer.getText());
                    pst.setString(4,pass.getText());
                    pst.setString(5,tel.getText());
                    pst.setString(6,mail.getText());
                    pst.setInt(7,Integer.parseInt(sid.getText()));   
                    pst.executeUpdate();
                    
                    
                    getAllUsers();
                    show_user();
                    JOptionPane.showMessageDialog(null,"Bearbeitet!");
                } catch ( SQLException e) { 
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"Sie haben sich falsch angemeldet!");
                }
          } else {
              JOptionPane.showMessageDialog(null,"Nicht bearbeitet!");
          }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bearbeitActionPerformed

    private void neuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuActionPerformed

        vor.setText("");
        nach.setText("");
        benutzer.setText("");
        pass.setText("");
        tel.setText("");
        mail.setText("");
        such1.setText("");
        sid.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_neuActionPerformed

    private void vorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vorActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void hocaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hocaMouseClicked
  
     int row=hoca.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) hoca.getModel();
       
                      
                      sid.setText(model.getValueAt(row, 0).toString());                      
                      vor.setText(model.getValueAt(row, 1).toString());                      
                      nach.setText(model.getValueAt(row, 2).toString());                      
                      benutzer.setText(model.getValueAt(row, 3).toString());                      
                      pass.setText(model.getValueAt(row, 4).toString());
                      tel.setText(model.getValueAt(row, 5).toString());
                      mail.setText(model.getValueAt(row, 6).toString());


      // TODO add your handling code here:
    }//GEN-LAST:event_hocaMouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bearbeit;
    private javax.swing.JTextField benutzer;
    private javax.swing.JLabel bn;
    private javax.swing.JLabel em;
    private javax.swing.JTable hoca;
    private javax.swing.JLabel idl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lösche;
    private javax.swing.JTextField löschen;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nach;
    private javax.swing.JButton neu;
    private javax.swing.JLabel nn;
    private javax.swing.JLabel p;
    private javax.swing.JTextField pass;
    private javax.swing.JLabel sID;
    private javax.swing.JTextField sid;
    private javax.swing.JButton speichern;
    private javax.swing.JLabel su;
    private javax.swing.JTextField such1;
    private javax.swing.JButton suche;
    private javax.swing.JTextField tel;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel vn;
    private javax.swing.JTextField vor;
    // End of variables declaration//GEN-END:variables

private void close() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
