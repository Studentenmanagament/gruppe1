/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement.Klasse;

/**
 */
public class Raum {
    int id;
    String Lagebeschreibung;
    String Name;
    int Kapazitat;
 
    public Raum(int i, String l,String n,int k) {
        this.id = i;
        this.Lagebeschreibung = l;
        this.Name = n;
        this.Kapazitat = k;     
    }

    public String getLagebeschreibung(){
      return Lagebeschreibung;
    }
    
    public String getName(){
      return Name;
    }
    
    public int getKapazitat(){
      return Kapazitat;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
