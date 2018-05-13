/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentenmanagement.Klasse;

/**
 *
 * @author emirhan
 */
public class user {

private String Vorname,Nachname,Benutzername,Passwort,Tel,Email;
    
    public user(String Vorname,String Nachname,String Benutzername,String Passwort,String Tel,String Email) {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Benutzername = Benutzername;
        this.Passwort = Passwort;
        this.Tel = Tel;
        this.Email = Email;  
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