/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diets.objects;

import java.io.Serializable;
import javax.persistence.*;

/**
 *Класс в котором описывается структура объекта "советы"
 * @author Pro
 */
@Entity(name = "advice")
@Table(name = "advice")
public class Advice extends Identifable{
    
    @Column(columnDefinition="TEXT")
    private String advice;
    
    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
    
}
