/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import diets.api.DataService;
import diets.objects.Advice;
import diets.objects.DietBase;
import diets.objects.Gym;
import diets.objects.Shop;
import diets.objects.ShopVeg;
import diets.objects.RecipeDessert;
import diets.objects.RecipeDrink;
import diets.objects.RecipeMain;
import diets.objects.RecipeMeat;
import diets.objects.RecipeSoup;
import diets.objects.User;
import java.util.List;
import org.hibernate.Session;

/**
 * В этом классе происходит реализация методов из DataService
 *
 * @author User
 */
public class DataServiceImplementation implements DataService {

    @Override
    public List<DietBase> getDietBases() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<DietBase> diets = session.createQuery("SELECT E FROM dietBase E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return diets;

    }

    @Override
    public DietBase getDiet(String name) {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DietBase diet = (DietBase) session.createQuery("SELECT E FROM dietBase E WHERE E.name = :name").uniqueResult();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return diet;

    }

    @Override
    public void newDiet(String login, String token, DietBase diet) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(diet);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<Shop> getShop() {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Shop> shops = session.createQuery("SELECT E FROM PP E").getResultList();
            session.getTransaction().commit();

            return shops;
        }
    }

    @Override
    public void newShop(String login, String token, Shop shop) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(shop);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<ShopVeg> getShopVeg() {
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<ShopVeg> shops1 = session.createQuery("SELECT E FROM Veg E").getResultList();
            session.getTransaction().commit();
            return shops1;
        }
    }

    @Override
    public void newShop1(String login, String token, ShopVeg shop1) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(shop1);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка досутпа!");
        }
    }

    @Override
    public List<Gym> getGym() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Gym> gyms = session.createQuery("SELECT E FROM gym E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return gyms;
    }

    @Override
    public void newGym(String login, String token, Gym gym) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(gym);
                session.getTransaction().commit();

            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<RecipeMeat> getRecipeMeat() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RecipeMeat> meats = session.createQuery("SELECT E FROM recipeMeat E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return meats;
    }

    @Override
    public void newRecipeMeat(String login, String token, RecipeMeat meat) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(meat);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<RecipeMain> getRecipeMain() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RecipeMain> mains = session.createQuery("SELECT E FROM recipeMain E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return mains;
    }

    @Override
    public void newRecipeMain(String login, String token, RecipeMain main) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(main);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<RecipeDrink> getRecipeDrink() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RecipeDrink> drinks = session.createQuery("SELECT E FROM recipeDrink E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return drinks;
    }

    @Override
    public void newRecipeDrink(String login, String token, RecipeDrink drink) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(drink);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа");
        }
    }

    @Override
    public List<RecipeSoup> getRecipeSoup() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RecipeSoup> soups = session.createQuery("SELECT E FROM recipeSoup E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return soups;
    }

    @Override
    public void newRecipeSoup(String login, String token, RecipeSoup soup) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(soup);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<RecipeDessert> getRecipeDessert() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<RecipeDessert> desserts = session.createQuery("SELECT E FROM recipeDessert E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return desserts;
    }

    @Override
    public void newRecipeDessert(String login, String token, RecipeDessert dessert) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(dessert);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public List<Advice> getAdvice() {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Advice> advices = session.createQuery("SELECT E FROM advice E").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return advices;
    }

    @Override
    public void newAdvice(String login, String token, Advice advice) {
        if (new LoginServiceImplementation().checkToken(login, token)) {
            try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.save(advice);
                session.getTransaction().commit();
            }
        } else {
            throw new VerifyError("Ошибка доступа");
        }
    }

    @Override
    public void updateDietBase(DietBase diet, Long id) {
        Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DietBase updiet = (DietBase) session.createQuery("SELECT E FROM dietBase E WHERE E.id =:id").uniqueResult();
        session.update(diet);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void deleteDietById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM dietBase WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteAdviceById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM advice WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteGymById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM gym WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteDessertById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM recipeDessert WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteDrinkById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM recipeDrink WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteMainById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM recipeMain WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteMeatById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM recipeMeat WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteSoupById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM recipeSoup WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteShopById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM PP WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void deleteShopVegById(String login, String token, Long id) {
        if(new LoginServiceImplementation().checkToken(login, token)){
        try (Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Veg WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        } else {
            throw new VerifyError("Ошибка доступа!");
        }
    }

    @Override
    public void setDietForUser(String login, Long id) {
        try(Session session = hibernate.util.HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = (User) session.createQuery("SELECT E FROM user E WHERE E.login=:login")
                    .setParameter("login", login)
                    .uniqueResult();
            user.setDiet_id(id);
            session.update(user);
            session.getTransaction().commit();
        }
    }

}
