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
    /**
     * Creates new form hocalar
     */
    public hocalar() {
        initComponents();
        show_user();
    }
    
    public ArrayList<user> userList(){
        ArrayList<user> usersList= new ArrayList<>();
        
     try { 
           Class.forName("org.hsqldb.jdbcDriver"); 
           String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";  
           con = DriverManager.getConnection(url,"G1", "1234");
           String query ="SELECT * FROM hoca";
           Statement st= con.createStatement();
           rs =st.executeQuery(query);
           user User;
            while(rs.next()){
                User =new user(rs.getInt("ID"), rs.getString("Vorname"),rs.getString("Nachname"),rs.getString("Benutzername"),rs.getString("Passwort"),rs.getString("Telefonnummer"),rs.getString("Email"));
                usersList.add(User);
                
            
            }
           }
     
            catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
       }
            return usersList;
    }
    public void show_user(){
    ArrayList<user> list = userList();
    DefaultTableModel model = (DefaultTableModel) hoca.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getVorname();
            row[2]=list.get(i).getNachname();
            row[3]=list.get(i).getBenutzername();
            row[4]=list.get(i).getPasswort();
            row[5]=list.get(i).getTel();
            row[6]=list.get(i).getEmail();
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
        such = new javax.swing.JTextField();
        speichern = new javax.swing.JButton();
        suche = new javax.swing.JButton();
        bearbeit = new javax.swing.JButton();
        lösche = new javax.swing.JButton();
        neu = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        id = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        svor = new javax.swing.JTextField();
        snach = new javax.swing.JTextField();
        sID = new javax.swing.JLabel();
        svn = new javax.swing.JLabel();
        snn = new javax.swing.JLabel();
        sbn = new javax.swing.JLabel();
        sben = new javax.swing.JTextField();
        sp = new javax.swing.JLabel();
        stn = new javax.swing.JLabel();
        sem = new javax.swing.JLabel();
        spass = new javax.swing.JTextField();
        stel = new javax.swing.JTextField();
        smail = new javax.swing.JTextField();

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

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });

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

        speichern.setBackground(new java.awt.Color(255, 204, 255));
        speichern.setText("Speichern");
        speichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speichernActionPerformed(evt);
            }
        });

        suche.setBackground(new java.awt.Color(255, 204, 255));
        suche.setText("Suchen");
        suche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheActionPerformed(evt);
            }
        });

        bearbeit.setBackground(new java.awt.Color(153, 0, 153));
        bearbeit.setForeground(new java.awt.Color(255, 255, 255));
        bearbeit.setText("Bearbeiten");
        bearbeit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitActionPerformed(evt);
            }
        });

        lösche.setBackground(new java.awt.Color(0, 102, 204));
        lösche.setForeground(new java.awt.Color(255, 255, 255));
        lösche.setText("Löschen");
        lösche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                löscheActionPerformed(evt);
            }
        });

        neu.setBackground(new java.awt.Color(102, 204, 255));
        neu.setText("Neu");
        neu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuActionPerformed(evt);
            }
        });

        id.setText("ID");

        sID.setText("ID");

        svn.setText("Vorname");

        snn.setText("Nachname");

        sbn.setText("Benutzername");

        sp.setText("Passwort");

        stn.setText("Telefonnummer");

        sem.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(neu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lösche))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vn)
                                    .addComponent(id))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(vor)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tn)
                                    .addComponent(em)
                                    .addComponent(p))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pass)
                                    .addComponent(tel)
                                    .addComponent(mail)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bn)
                                .addGap(31, 31, 31)
                                .addComponent(benutzer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nn)
                                .addGap(53, 53, 53)
                                .addComponent(nach))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(speichern)))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sem)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(304, 304, 304)
                                        .addComponent(bearbeit))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(smail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(143, 143, 143))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(su)
                                        .addComponent(sID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(svn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(snn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sbn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(sp)
                                    .addComponent(stn))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(spass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(snach, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(svor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sid, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(such, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sben, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stel, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addGap(87, 87, 87)
                                .addComponent(suche)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id)
                    .addComponent(su)
                    .addComponent(such, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nn)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(benutzer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bn)
                    .addComponent(svor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(svn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p)
                    .addComponent(snach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(snn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tn)
                    .addComponent(sbn)
                    .addComponent(sben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(em)
                    .addComponent(sp)
                    .addComponent(spass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stn)
                    .addComponent(stel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speichern)
                    .addComponent(sem)
                    .addComponent(smail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(bearbeit)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neu)
                    .addComponent(lösche))
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suchActionPerformed

    private void speichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speichernActionPerformed
   try { 
            System.out.println("Connecting database..."); 
            Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            System.out.println("Database connected!"); 
            String query ="insert into hoca"   
               +"(ID,Vorname,Nachname,Benutzername,Passwort,Telefonnummer,Email)"
               +"values(?,?,?,?,?,?,?)";
                   Connection con = DriverManager.getConnection(url,"G1", "1234"); 
                   PreparedStatement pst = con.prepareStatement(query);
                   pst.setString(1,ID.getText());
                   pst.setString(2,vor.getText()); 
                   pst.setString(3,nach.getText());
                   pst.setString(4,benutzer.getText());
                   pst.setString(5,pass.getText());
                   pst.setString(6,tel.getText());
                   pst.setString(7,mail.getText());
                   pst.executeUpdate();
                  DefaultTableModel model = (DefaultTableModel) hoca.getModel();
                  model.setRowCount(0);
                  show_user();
            JOptionPane.showMessageDialog(null,"Gespeichert!");}      
        catch (ClassNotFoundException | SQLException e) { 
            JOptionPane.showMessageDialog(null,"Sie haben sich falsch angemeldet!");
       }

        // TODO add your handling code here:
    }//GEN-LAST:event_speichernActionPerformed

    private void suchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suchKeyReleased
   


        // TODO add your handling code here:
    }//GEN-LAST:event_suchKeyReleased

    private void sucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheActionPerformed
 // hala aramayı tuşla yaptıramamakla birlikte bulamadım bir de diğer suche olayı da oluyo mu belli değil :(

           try {             
             Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            String query ="select * from hoca WHERE ID=?";
            con = DriverManager.getConnection(url,"G1", "1234"); 
            pst = con.prepareStatement(query);
                pst.setString(1,such.getText()); 
                  rs = pst.executeQuery();
                  if(rs.next()){
                      String sucht1=rs.getString("ID");
                      sid.setText(sucht1);
                      String sucht2=rs.getString("Vorname");
                      svor.setText(sucht2);
                      String sucht3=rs.getString("Nachname");
                      snach.setText(sucht3);   
                      String sucht4=rs.getString("Benutzername");
                      sben.setText(sucht4);
                      String sucht5=rs.getString("Passwort");
                      spass.setText(sucht5);
                      String sucht6=rs.getString("Telefonnummer");
                      stel.setText(sucht6);
                      String sucht7=rs.getString("Email");
                      smail.setText(sucht7);
                      
                  }
            }      
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
       }
     try {             
            Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            String query ="select * from hoca WHERE Vorname=?";
            con = DriverManager.getConnection(url,"G1", "1234"); 
            pst = con.prepareStatement(query);
                pst.setString(1,such.getText()); 
                  rs = pst.executeQuery();
                  if(rs.next()){
                      String sucht1=rs.getString("ID");
                      sid.setText(sucht1);
                      String sucht2=rs.getString("Vorname");
                      svor.setText(sucht2);
                      String sucht3=rs.getString("Nachname");
                      snach.setText(sucht3);   
                      String sucht4=rs.getString("Benutzername");
                      sben.setText(sucht4);
                      String sucht5=rs.getString("Passwort");
                      spass.setText(sucht5);
                      String sucht6=rs.getString("Telefonnummer");
                      stel.setText(sucht6);
                      String sucht7=rs.getString("Email");
                      smail.setText(sucht7);
                      
                  }
            }      
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
       }
        
        try {             
             Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            String query ="select * from hoca WHERE Nachname=?";
            con = DriverManager.getConnection(url,"G1", "1234"); 
            pst = con.prepareStatement(query);
                pst.setString(1,such.getText()); 
                  rs = pst.executeQuery();
                  if(rs.next()){
                      String sucht1=rs.getString("ID");
                      sid.setText(sucht1);
                      String sucht2=rs.getString("Vorname");
                      svor.setText(sucht2);
                      String sucht3=rs.getString("Nachname");
                      snach.setText(sucht3);   
                      String sucht4=rs.getString("Benutzername");
                      sben.setText(sucht4);
                      String sucht5=rs.getString("Passwort");
                      spass.setText(sucht5);
                      String sucht6=rs.getString("Telefonnummer");
                      stel.setText(sucht6);
                      String sucht7=rs.getString("Email");
                      smail.setText(sucht7);
                      
                  }
            }      
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
       }
                 
           try {             
             Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            String query ="select * from hoca WHERE Benutzername=?";
            con = DriverManager.getConnection(url,"G1", "1234"); 
            pst = con.prepareStatement(query);
                pst.setString(1,such.getText()); 
                  rs = pst.executeQuery();
                  if(rs.next()){
                      String sucht1=rs.getString("ID");
                      sid.setText(sucht1);
                      String sucht2=rs.getString("Vorname");
                      svor.setText(sucht2);
                      String sucht3=rs.getString("Nachname");
                      snach.setText(sucht3);   
                      String sucht4=rs.getString("Benutzername");
                      sben.setText(sucht4);
                      String sucht5=rs.getString("Passwort");
                      spass.setText(sucht5);
                      String sucht6=rs.getString("Telefonnummer");
                      stel.setText(sucht6);
                      String sucht7=rs.getString("Email");
                      smail.setText(sucht7);
                      
                  }
            }      
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null,e);
       }         
 
// TODO add your handling code here:
    }//GEN-LAST:event_sucheActionPerformed

    private void löscheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_löscheActionPerformed
    

        int onay = JOptionPane.showConfirmDialog(null, "Sind Sie sicher?", "hoca", JOptionPane.YES_NO_OPTION);

            if (onay == 0) {   
                                         
                 try{ System.out.println("Connecting database..."); 
                 Class.forName("org.hsqldb.jdbcDriver"); 
                 String url = "jdbc:hsqldb:file:C:\\Users\\Destkop\\sql\\;shutdown=true"; 
                 String query ="DELETE FROM G1 WHERE ID =?";                
                 con = DriverManager.getConnection(url,"G1", "1234"); 
                 pst = con.prepareStatement(query);
                  pst.setString(1,ID.getText());
                  pst.executeUpdate();
                  DefaultTableModel model = (DefaultTableModel) hoca.getModel();
                  model.setRowCount(0);
                  rs.deleteRow();
                  show_user();
            JOptionPane.showMessageDialog(null,"Gespeichert!");}
   
                 catch (Exception ex) {
            
                     JOptionPane.showMessageDialog(null, "Nicht Gelöscht!");
        }
                
                
            } else {           

            }
        // TODO add your handling code here:
    }//GEN-LAST:event_löscheActionPerformed

    private void bearbeitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitActionPerformed
    
       try {
             Class.forName("org.hsqldb.jdbcDriver"); 
            String url = "jdbc:hsqldb:file:C:\\Users\\domin\\Desktop\\sql\\;shutdown=true";           
            String query ="select * from hoca WHERE Benutzername=?";
            con = DriverManager.getConnection(url,"G1", "1234"); 
            pst = con.prepareStatement(query); 
            
            rs.updateString("Vorname", vor.getText());
            rs.updateString("Nachname", nach.getText());
            rs.updateString("Benutzername", benutzer.getText());
            rs.updateString("Passwort", pass.getText());
            rs.updateString("Telefonnummer", tel.getText());
            rs.updateString("Email", mail.getText());
    
            rs.updateRow();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nicht Bearbeitet!");
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
        
        // TODO add your handling code here:
    }//GEN-LAST:event_neuActionPerformed

    private void vorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vorActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

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
            java.util.logging.Logger.getLogger(hocalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hocalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hocalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hocalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hocalar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton bearbeit;
    private javax.swing.JTextField benutzer;
    private javax.swing.JLabel bn;
    private javax.swing.JLabel em;
    private javax.swing.JTable hoca;
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lösche;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField nach;
    private javax.swing.JButton neu;
    private javax.swing.JLabel nn;
    private javax.swing.JLabel p;
    private javax.swing.JTextField pass;
    private javax.swing.JLabel sID;
    private javax.swing.JTextField sben;
    private javax.swing.JLabel sbn;
    private javax.swing.JLabel sem;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField smail;
    private javax.swing.JTextField snach;
    private javax.swing.JLabel snn;
    private javax.swing.JLabel sp;
    private javax.swing.JTextField spass;
    private javax.swing.JButton speichern;
    private javax.swing.JTextField stel;
    private javax.swing.JLabel stn;
    private javax.swing.JLabel su;
    private javax.swing.JTextField such;
    private javax.swing.JButton suche;
    private javax.swing.JLabel svn;
    private javax.swing.JTextField svor;
    private javax.swing.JTextField tel;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel vn;
    private javax.swing.JTextField vor;
    // End of variables declaration//GEN-END:variables

private void close() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
