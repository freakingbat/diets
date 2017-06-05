/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.tabbedpane.TabbedPaneStyle;
import com.alee.laf.tabbedpane.WebTabbedPane;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Этот класс реализует заполнение раздела меню магазины
 *
 * @author Pro
 */
public class SectionShops extends JPanel {

    /**
     * В конструкторе собирается подменю раздела магазинов
     */
    boolean  flag;
    User user;
    public SectionShops(boolean flag, User user) {
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
     * Этот метод создает разделы подменю
     *
     * @param sections объект класса WebTabbedPane
     * @see diets.objects.DescrpVegShops
     * @see diets.objects.DescrShops
     */
    private static void setupTabbedPaneSections(WebTabbedPane sections, boolean flag, User user) {

        final JPanel shops = new JPanel();
        shops.setBackground(new Color(235, 252, 224));
        DescrShops d1 = new DescrShops(flag, user);
        d1.setBackground(new Color(235, 252, 224));
        shops.add(d1);
        final JScrollPane shopsScrollPane = new JScrollPane(shops);
        shopsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        shopsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        shopsScrollPane.setBackground(new Color(235, 252, 224));
        sections.addTab("Магазины правильного питания", shopsScrollPane);

        final JPanel vegShops = new JPanel();
        vegShops.setBackground(new Color(235, 252, 224));
        DescrpVegShops v1 = new DescrpVegShops(flag, user);
        v1.setBackground(new Color(235, 252, 224));
        vegShops.add(v1);
        final JScrollPane vegShopsScrollPane = new JScrollPane(vegShops);
        vegShopsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        vegShopsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sections.addTab("Вегетерианские", vegShopsScrollPane);

    }
}
