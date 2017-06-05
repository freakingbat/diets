/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.label.WebLabel;
import diets.objects.DietBase;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Этот класс собирает страницу пользователя в окне меню
 *
 * @author Pro
 */
public class InfoInterface extends JPanel {

    public InfoInterface(User user) throws MalformedURLException {

        JPanel info = new JPanel();
        info.setPreferredSize(new Dimension(220, 450));
        info.setBackground(new Color(255, 255, 255));
        info.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        final WebLabel user_name = new WebLabel(user.getName() + " " + user.getSurname(), WebLabel.CENTER);
        String kg = user.getWeight();
        String[] diets_variants;
        List<DietBase> dietBase = Service.getDataService().getDietBases();
        diets_variants = new String[dietBase.size()];
        int id = -1;
        if(user.getDiet_id()!=null){
        id = user.getDiet_id().intValue();
        }
        int selected = -1;
        for (int i = 0; i < dietBase.size(); i++) {
            diets_variants[i] = dietBase.get(i).getName();
            if(dietBase.get(i).getId().intValue()==id){
                selected = i;
            }
        }
        JComboBox combo = new JComboBox(diets_variants) {
            public Dimension getPreferredSize() {
                return new Dimension(200, 40);
            }
        };
        if(selected!=-1){
        combo.setSelectedIndex(selected);
        }
        combo.addActionListener((ActionEvent e) -> {
            try {
                Service.getDataService().setDietForUser(user.getLogin(), dietBase.get(combo.getSelectedIndex()).getId());
            } catch (MalformedURLException ex) {
                Logger.getLogger(InfoInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        final WebLabel weight = new WebLabel("Вес при регистрации: " + kg, WebLabel.CENTER);
        final WebLabel diet = new WebLabel("Диета: ", WebLabel.CENTER);
        final WebLabel city = new WebLabel("Город: " + user.getCity(), WebLabel.CENTER);
        final WebLabel userAcc = new WebLabel("Страница пользователя");
        userAcc.setDrawShade(true);

        JLabel imageLabel = new JLabel(new ImageIcon("healthy.png"));

        addComponent(c, 1, 0, 1);
        c.insets = new Insets(0, 0, 0, 0);
        info.add(user_name, c);

        addComponent(c, 1, 0, 2);
        c.insets = new Insets(0, 0, 0, 0);
        info.add(weight, c);

        addComponent(c, 1, 0, 4);
        c.insets = new Insets(0, 0, 0, 0);
        info.add(diet, c);

        addComponent(c, 1, 0, 5);
        c.insets = new Insets(5, 5, 5, 5);
        info.add(combo, c);

        addComponent(c, 1, 0, 6);
        c.insets = new Insets(0, 0, 0, 0);
        info.add(city, c);

        addComponent(c, 1, 0, 0);
        c.insets = new Insets(30, 0, 30, 0);
        info.add(imageLabel, c);

        this.setBackground(new Color(255, 255, 255));
        this.add(info);
    }

    public void addComponent(GridBagConstraints c, int height, int gx, int gy) {
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = height;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridx = gx;
        c.gridy = gy;
        c.weightx = 0;
        c.weighty = 0;
    }

}
