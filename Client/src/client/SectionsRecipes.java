package client;

import com.alee.laf.tabbedpane.TabbedPaneStyle;
import com.alee.laf.tabbedpane.WebTabbedPane;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Этот класс реализует заполнение раздела меню рецепты
 *
 * @author Pro
 */
public class SectionsRecipes extends JPanel {

    /**
     * В конструкторе собирается подменю раздела рецептов
     */
    boolean flag;
    User user;
    public SectionsRecipes(boolean flag, User user) {
        this.flag = flag;
        this.user = user;
        WebTabbedPane sections = new WebTabbedPane();
        sections.setBackground(new Color(212, 252, 184));
        sections.setTabbedPaneStyle(TabbedPaneStyle.attached);
        sections.setPreferredSize(new Dimension(420, 470));
        sections.setTabPlacement(WebTabbedPane.NORTH);
        setupTabbedPaneSections(sections, this.flag, this.user);
        this.add(sections);
    }

    /**
     * Этот метод создает разделы рецептов
     *
     * @param sections объект класса WebTabbedPane
     * @see diets.objects.DescrpDeserts
     * @see diets.objects.DescrpBeverages
     * @see diets.objects.DescrpMain
     * @see diets.objects.DescrpSoup
     * @see diets.objects.DescrpMeat
     */
    private static void setupTabbedPaneSections(WebTabbedPane sections, boolean flag, User user) {

        final JPanel desserts = new JPanel();
        desserts.setBackground(new Color(235, 252, 224));
        DescrpDeserts descrpDeserts = new DescrpDeserts(flag, user);
        descrpDeserts.setBackground(new Color(235, 252, 224));
        desserts.add(descrpDeserts);
        final JScrollPane dessertsScrollPane1 = new JScrollPane(desserts);
        dessertsScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dessertsScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Десерты", dessertsScrollPane1);

        final JPanel meat = new JPanel();
        meat.setBackground(new Color(235, 252, 224));
        DescrpMeat descrpMeat = new DescrpMeat(flag, user);
        descrpMeat.setBackground(new Color(235, 252, 224));
        meat.add(descrpMeat);
        final JScrollPane meatScrollPane = new JScrollPane(meat);
        meatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        meatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Мясные блюда", meatScrollPane);

        final JPanel drink = new JPanel();
        drink.setBackground(new Color(235, 252, 224));
        DescrpBeverages descrpBeverages = new DescrpBeverages(flag, user);
        descrpBeverages.setBackground(new Color(235, 252, 224));
        drink.add(descrpBeverages);
        final JScrollPane drinkScrollPane = new JScrollPane(drink);
        drinkScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        drinkScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Напитки", drinkScrollPane);

        final JPanel main = new JPanel();
        main.setBackground(new Color(235, 252, 224));
        DescrpMain descrpMain = new DescrpMain(flag, user);
        descrpMain.setBackground(new Color(235, 252, 224));
        main.add(descrpMain);
        final JScrollPane mainScrollPane = new JScrollPane(descrpMain);
        mainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Гарниры", mainScrollPane);

        final JPanel soup = new JPanel();
        soup.setBackground(new Color(235, 252, 224));
        DescrpSoup descrpSoup = new DescrpSoup(flag, user);
        descrpSoup.setBackground(new Color(235, 252, 224));
        soup.add(descrpSoup);
        final JScrollPane soupScrollPane = new JScrollPane(soup);
        soupScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        soupScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Супы", soupScrollPane);

    }

}
