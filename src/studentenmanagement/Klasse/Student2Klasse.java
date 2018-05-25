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
public class Student2Klasse {
    
    int Student_id;
    int Klasse_id;
 
    public Student2Klasse(int a, int b) {
     
        this.Student_id = a;
        this.Klasse_id = b;     
    }
    
    public int getStudent_id(){
     return Student_id;
    }
    
    
    public int getKlase_id(){
     return Klasse_id;
    }

    
}
    
