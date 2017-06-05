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
 * Класс в котором описывается структура объекта "Пользователь"
 * @author Pro
 */
@Entity(name = "user")
@Table(name = "user")
public class User extends Identifable{
    
    @Column
    private String name;

   
    @Column
    private String surname;
   
    @Column
    private String city;
    
    @Column
    private String word;    
    
    @Column
    private String login;
    
    @Column
    private String password;
    
    @Column
    private String weight;
    
    @Column
    private String token;
    
    @Column
    Long diet_id;
    
    public User() {
    }

    public Long getDiet_id() {
        return diet_id;
    }

    public void setDiet_id(Long diet_id) {
        this.diet_id = diet_id;
    }
     
    
     
    public User(String name, int group) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String getWeight() {
        return weight;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public String getWord() {
        return word;
    }

    public String getCity() {
        return city;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  

    public void setDescription(String description) {
       
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
   
    
}
