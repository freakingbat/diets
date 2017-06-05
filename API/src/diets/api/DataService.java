/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diets.api;

//import client.Example;
import diets.objects.Advice;
import diets.objects.DietBase;
import diets.objects.Gym;
import diets.objects.RecipeDessert;
import diets.objects.RecipeDrink;
import diets.objects.RecipeMain;
import diets.objects.RecipeMeat;
import diets.objects.RecipeSoup;
import diets.objects.Shop;
import diets.objects.ShopVeg;
import diets.objects.User;
import java.util.List;

//import java.util.List;
/**
 * Этот класс описывает методы работы с базами данных
 *
 * @author User
 */
public interface DataService {

    List<DietBase> getDietBases();

    DietBase getDiet(String name);

    void updateDietBase(DietBase diet, Long id);

    List<Shop> getShop();

    List<ShopVeg> getShopVeg();

    List<Gym> getGym();

    List<RecipeMeat> getRecipeMeat();

    List<RecipeMain> getRecipeMain();

    List<RecipeDrink> getRecipeDrink();

    List<RecipeSoup> getRecipeSoup();

    List<RecipeDessert> getRecipeDessert();

    List<Advice> getAdvice();

    void newAdvice(String login, String token, Advice advice);

    void newRecipeDessert(String login, String token, RecipeDessert dessert);

    void newRecipeSoup(String login, String token, RecipeSoup soup);

    void newRecipeDrink(String login, String token, RecipeDrink drink);

    void newRecipeMain(String login, String token, RecipeMain main);

    void newRecipeMeat(String login, String token, RecipeMeat meat);

    void newGym(String login, String token, Gym gym);

    void newShop1(String login, String token, ShopVeg shop1);

    void newShop(String login, String token, Shop shop);

    void newDiet(String login, String token, DietBase diet);

    void deleteDietById(String login, String token,Long id);

    void deleteAdviceById(String login, String token,Long id);

    void deleteGymById(String login, String token,Long id);

    void deleteDessertById(String login, String token,Long id);

    void deleteDrinkById(String login, String token,Long id);

    void deleteMainById(String login, String token,Long id);

    void deleteMeatById(String login, String token,Long id);

    void deleteSoupById(String login, String token,Long id);

    void deleteShopById(String login, String token,Long id);

    void deleteShopVegById(String login, String token,Long id);
    
    void setDietForUser(String login, Long id);

}
