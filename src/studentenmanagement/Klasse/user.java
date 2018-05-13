/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement.Klasse;

/**
 *
 * @author domin
 */
public class user {
    private int ID;
    private String Vorname;
    private String Nachname,Benutzername,Passwort,Tel,Email;
    
    public user(int ID, String Vorname,String Nachname,String Benutzername,String Passwort,String Tel,String Email) {
        this.ID = ID;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Benutzername = Benutzername;
        this.Passwort = Passwort;
        this.Tel = Tel;
        this.Email = Email;  
    }
    
   
     public int getID(){
        return ID;
    }

    public String getVorname(){
     return Vorname;
    }
    public String getNachname(){
     return Nachname;
    }
    public String getBenutzername(){
     return Benutzername;
    }
    public String getPasswort(){
    return Passwort;
    }
    public String getTel(){
     return Tel;
    }
    public String getEmail(){
    return Email;
    }
}