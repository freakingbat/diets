
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.tabbedpane.TabbedPaneStyle;
import com.alee.laf.tabbedpane.WebTabbedPane;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import layout.TableLayout;

/**
 * Этот класс собирает окно меню
 *
 * @author Pro
 */
public class PageInterface extends JFrame {

    /**
     * В конструкторе создается панель На ней расположены: страница пользователя
     * и разделы меню
     *
     * @see client.InfoInterface
     */
    public PageInterface(User user) throws MalformedURLException {
        super("Начни сегодня!");
        WebLookAndFeel.install();
        JPanel page = new JPanel();
        page.setBackground(new Color(235, 252, 224));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        WebTabbedPane webTabbedPane = new WebTabbedPane();
        webTabbedPane.setBackground(new Color(212, 252, 184));
        webTabbedPane.setTabbedPaneStyle(TabbedPaneStyle.attached);
        webTabbedPane.setPreferredSize(new Dimension(420, 500));
        webTabbedPane.setTabPlacement(WebTabbedPane.NORTH);

        setupTabbedPane(webTabbedPane, user);

        double[][] size_page = {{TableLayout.PREFERRED, TableLayout.PREFERRED},
        {TableLayout.PREFERRED}
        };

        page.setLayout(new TableLayout(size_page));

        InfoInterface info1 = new InfoInterface(user);

        page.add(info1, "0,0");
        page.add(webTabbedPane, "1,0");

        getContentPane().add(page);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        setFocusCycleRoot(true);
        setResizable(false);

        //setSize(630,510);
    }

    /**
     *
     * @param tabbedPane объект класса JTabbedPane на каждый раздел добавляется
     * панель
     * @see SectionDiets
     * @see SectionRecipes
     * @see SectionFitness
     * @see SectionShops
     * @see SectionAdvices
     * @see SectionExit
     */
    private void setupTabbedPane(JTabbedPane tabbedPane, User user) throws MalformedURLException {
        boolean flag = Service.getLoginService().checkToken(user.getLogin(), user.getToken());
        System.out.println(flag);
        JPanel sectionDiets = new SimpleSection(new DescrpDiets(flag, user));
        sectionDiets.setBackground(new Color(235, 252, 224));
        GridBagConstraints c = new GridBagConstraints();
        final JScrollPane sectionDietsScrollPane = new JScrollPane(sectionDiets);
        sectionDietsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sectionDietsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tabbedPane.addTab("Диеты", sectionDietsScrollPane);

        SectionsRecipes sectionRecipes = new SectionsRecipes(flag, user);
        sectionRecipes.setBackground(new Color(235, 252, 224));
        tabbedPane.addTab("Рецепты", sectionRecipes);

        JPanel sectionFitness = new SimpleSection(new DescrpGym(flag, user));
        final JScrollPane sectionFitnessScrollPane = new JScrollPane(sectionFitness);
        sectionFitness.setBackground(new Color(235, 252, 224));
        sectionFitnessScrollPane.setSize(500, 480);
        sectionFitnessScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sectionFitnessScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tabbedPane.addTab("Фитнес", sectionFitnessScrollPane);

        SectionShops sectionShops = new SectionShops(flag, user);
        sectionShops.setBackground(new Color(235, 252, 224));
        tabbedPane.addTab("Магазины", sectionShops);

        JPanel sectionAdvices = new SimpleSection(new DescrpAdvice(flag, user));
        final JScrollPane sectionAdvicesScrollPane = new JScrollPane(sectionAdvices);
        sectionAdvices.setBackground(new Color(235, 252, 224));
        sectionAdvicesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sectionAdvicesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tabbedPane.addTab("Советы", sectionAdvicesScrollPane);

        SectionExit sectionExit = new SectionExit();
        final JScrollPane setionExitScrollPane = new JScrollPane(sectionExit);
        sectionExit.setBackground(new Color(235, 252, 224));
        setionExitScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setionExitScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tabbedPane.addTab("Выход", setionExitScrollPane);

    }

    public void addComponent(GridBagConstraints c, int height, int gx, int gy) {
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = height;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = gx;
        c.gridy = gy;
        c.weightx = 0;
        c.weighty = 0;
    }

}
