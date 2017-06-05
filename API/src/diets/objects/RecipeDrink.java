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
 *Класс в котором описывается структура объекта "Напитки"
 * @author Pro
 */
@Entity(name = "recipeDrink")
@Table(name = "recipeDrink")
public class RecipeDrink extends Identifable{
    
    
    @Column
    private String name;
   
   
    @Column(columnDefinition="TEXT")
    private String descrip; 
    
     public RecipeDrink() {
    }
    public RecipeDrink(String name, int group) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    public String getDescrip() {
        return descrip;
    }


    
}
