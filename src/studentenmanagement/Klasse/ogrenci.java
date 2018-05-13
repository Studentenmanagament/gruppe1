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
    
 
public class ogrenci {
    int Matrikelnummer, TC, Hausnummer, PLZ, Anfangsjahr;
    String Vorname,Nachname,Geschlecht,Ort, Bezirk, Strasse,Fach,Geburtsdatum, Tel,Email;
    
    public ogrenci(int Matrikelnummer, String Vorname,String Nachname,int TC, String Geschlecht,String Ort,String Bezirk, String Strasse,int Hausnummer,int PLZ, String Fach, String Geburtsdatum, String Tel,String Email, int Anfangsjahr) {
        this.Matrikelnummer = Matrikelnummer;
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.TC = TC;
        this.Geschlecht = Geschlecht;
        this.Ort = Ort;
        this.Bezirk = Bezirk;
        this.Strasse = Strasse;
        this.Hausnummer = Hausnummer;
        this.PLZ = PLZ;
        this.Geburtsdatum = Geburtsdatum;
        this.Email = Email; 
        this.Tel = Tel;
        this.Anfangsjahr = Anfangsjahr;
    }

     
     public int getMatrikelnummer(){
        return Matrikelnummer;
    }

    public String getVorname(){
     return Vorname;
}
    public String getNachname(){
     return Nachname;
}
    public int getTC(){
     return TC;
}
    public String getGeschlect(){
    return Geschlecht;
}
    public String getOrt(){
     return Ort;
}
    public String getBezirk(){
     return Bezirk;
}
    public String getStrasse(){
     return Strasse;
}
    public int getHausnummer(){
     return Hausnummer;
}
    public int getPLZ(){
     return PLZ;
}
    public String getFach(){
     return Fach;
}
    public String getGeburtsdatum(){
     return Geburtsdatum;
}  
    public String getTel(){
     return Tel;
}
    public String getEmail(){
    return Email;
}
    public int getAnfangsjahr(){
     return Anfangsjahr;
}
  
}