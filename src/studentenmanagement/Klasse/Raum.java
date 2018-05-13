/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement.Klasse;

/**
 */
public class Raum {
    int ID;
    String Lagebeschreibung;
    String Name;
    int Kapazitat;
 
    public Raum(int ID,String Name, String Lagebeschreibung, int Kapazitat) {
        this.ID = ID;
        this.Name = Name;
        this.Lagebeschreibung = Lagebeschreibung;
        this.Kapazitat = Kapazitat;     
    }
    
     public int getID(){
     return ID;
    }

    public String getName(){
    return Name;
    }
         
    public String getLagebeschreibung(){
      return Lagebeschreibung;
    }
    
    
    public int getKapazitat(){
      return Kapazitat;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
