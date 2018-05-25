/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement.Klasse;

/**
 */
public class Klasse {
    int ID;
    String Name, Stufe;
    int Lehrer_id;
    int Raum_id;
 
    public Klasse(int ID, String Name, String c, int a, int b) {
        this.ID = ID;
        this.Name = Name;
        this.Stufe = c;
        this.Lehrer_id = a;
        this.Raum_id = b;     
    }
    
    public int getID(){
     return ID;
    }

    public String getName(){
     return Name;
    }
    
    public String getStufe(){
     return Stufe;
    }
         
    public int getLehrer(){
     return Lehrer_id;
    }
    
    
    public int getRaum(){
     return Raum_id;
    }

    
}
