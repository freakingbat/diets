/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.util;

import diets.objects.Advice;
import diets.objects.DietBase;
import diets.objects.Gym;
import diets.objects.ShopVeg;
import diets.objects.Shop;

import diets.objects.RecipeDessert;
import diets.objects.RecipeDrink;
import diets.objects.RecipeMain;
import diets.objects.RecipeMeat;
import diets.objects.RecipeSoup;
import diets.objects.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Diet")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "")
                    .setProperty("hibernate.connection.pool_size", "20")
                    .setProperty("hibernate.connection.autoReconnect", "true")
                    .setProperty("connection.autoReconnectForPools", "true")
                    .setProperty("connection.is-connection-validation-required", "true")
                    .addAnnotatedClass(DietBase.class)
                    .addAnnotatedClass(Gym.class)
                    .addAnnotatedClass(Shop.class)
                    .addAnnotatedClass(ShopVeg.class)
                    .addAnnotatedClass(RecipeMeat.class)
                    .addAnnotatedClass(RecipeMain.class)
                    .addAnnotatedClass(RecipeDrink.class)
                    .addAnnotatedClass(RecipeDessert.class)
                    .addAnnotatedClass(RecipeSoup.class)
                    .addAnnotatedClass(Advice.class)
                    .addAnnotatedClass(User.class);

            try {
                sessionFactory = configuration.buildSessionFactory();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
