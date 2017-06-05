/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import Util.BCrypt;
import Util.GenerateUUID;
import diets.api.LoginService;
import diets.objects.User;
import org.hibernate.Session;

/**
 * В этом классе происходит реализация методов из Loginervice
 *
 * @author Bat
 */
public class LoginServiceImplementation implements LoginService {

    @Override
    public void newUser(User user) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User testUser = (User) session.createQuery("SELECT E FROM user E WHERE E.login=:login")
                    .setParameter("login", user.getLogin())
                    .uniqueResult();
            if (user != null) {
                user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
                user.setWord(BCrypt.hashpw(user.getWord(), BCrypt.gensalt()));
                session.save(user);
                session.getTransaction().commit();
            } else {
                throw new VerifyError("Пользователь с таким логином уже существует");
            }
        }
    }

    @Override
    public User getUser(String login) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login = :login").uniqueResult();
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public User logIn(String login, String pass) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login = :login")
                    .setParameter("login", login)
                    .uniqueResult();
            if (user != null) {
                if (pass == null ? user.getPassword() == null : BCrypt.checkpw(pass, user.getPassword())) {
                    if(user.getToken()!=null){
                        user.setToken(GenerateUUID.generate());
                        session.update(user);
                    } 
                    session.getTransaction().commit();
                    user.setId(null);
                    user.setPassword(null);
                    return user;
                } else {
                    throw new VerifyError("Неверный пароль");
                }
            } else {
                throw new VerifyError("Не существует пользователя с таким логином.");
            }
        }
    }

    @Override
    public String Check(String login, String word) {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login = :login")
                .setParameter("login", login)
                .uniqueResult();

        if (user != null) {
            if (word == null ? user.getWord() == null : BCrypt.checkpw(word, user.getWord())) {
                return "грусть";
            } else {
                throw new VerifyError("Неверный пароль");
            }
        } else {
            throw new VerifyError("Не существует пользователя с таким логином.");
        }
    }

    @Override
    public boolean changePassStepOne(String login, String word) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login=:login")
                    .setParameter("login", login)
                    .uniqueResult();
            if (user != null) {
                if (BCrypt.checkpw(word, user.getWord())) {
                    return true;
                } else {
                    throw new VerifyError("Неверное секретное слово!");
                }
            } else {
                throw new VerifyError("Пользователя с таким логином не существует!");
            }
        }
    }

    @Override
    public boolean changePassStepTwo(String login, String pass, String passConformity) {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login=:login")
                    .setParameter("login", login)
                    .uniqueResult();
            if (pass == null ? passConformity == null : pass.equals(passConformity)) {
                user.setPassword(BCrypt.hashpw(pass, BCrypt.gensalt()));
                session.update(user);
                session.getTransaction().commit();
                return true;
            } else {
                throw new VerifyError("Пароли не совпадают!");
            }
        }
    }

    @Override
    public boolean checkToken(String login, String token) {
        try(Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login=:login")
                    .setParameter("login", login)
                    .uniqueResult();
            session.getTransaction().commit();
            if(user!=null){
                if(user.getToken()!=null){
                    if(user.getToken().equals(token)){
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                throw new VerifyError("Пользователя с таким логином не существует");
            }
        }
    }
}
