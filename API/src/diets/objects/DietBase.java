/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diets.objects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Класс в котором описывается структура объекта "Диета"
 * @author Pro
 */
@Entity (name = "dietBase")
@Table(name = "dietBase")
public class DietBase extends Identifable{
    
    @Column
    private String name; //название диеты
    
    @Column
    private Long duration;
    
    @Column(columnDefinition="TEXT")
    private String text; //текст диеты
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
   public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    } 
    
    
}
