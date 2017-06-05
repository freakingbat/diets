/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diets.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *Класс в котором описывается структура объекта "Фитнес-зал"
 * @author Pro
 */
@Entity(name = "gym")
@Table(name = "gym")
public class Gym extends Identifable{
    
    
    @Column
    private String name;
    @Column
    private String adress;
   
    @Column(columnDefinition="TEXT")
    private String descrip; 
    
     public Gym() {
    }
    public Gym(String name, int group) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public String getAdress() {
        return adress;
    }
    
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    public String getDescrip() {
        return descrip;
    }


    
}

