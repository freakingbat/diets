/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diets.api;

import diets.objects.User;

/**
 *Этот класс реализует работу с базой данных пользователей
 * @author User
 */
public interface LoginService {
       void newUser(User user);
       User logIn(String login, String pass);
       String Check(String login, String word);
       User getUser (String login);
       boolean changePassStepOne(String login, String word);
       boolean changePassStepTwo(String login, String pass, String passConformity);
       boolean checkToken(String login, String token);
}
