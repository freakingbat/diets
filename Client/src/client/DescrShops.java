/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.Shop;
import diets.objects.User;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Этот класс - содержимое раздела магазинов
 *
 * @author Pro
 */
public class DescrShops extends AbstractTabulatedPanel {

    DescrShops(boolean flag, User user) {
        super(flag);
        if (flag) {
            button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddShop(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            );

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelShop().main(this, user);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | MalformedURLException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    public void update(List<String> content, boolean flag, User user) {
        setDate(content, flag);
        if (flag) {
            this.button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddShop(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelShop().main(this, user);
                    this.d_some.repaint();
                    this.repaint();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | MalformedURLException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @Override
    public List<String> getContent() {
        List<Shop> shop;
        List<String> content = new ArrayList<>();
        try {
            shop = Service.getDataService().getShop();
            for (int i = 0; i < shop.size(); i++) {
                String name = "<html><div width = 350><h3>" + shop.get(i).getName() + "</h3><br>" + shop.get(i).getAdress() + "<br>" + shop.get(i).getDescrip() + "</div><hr></html>";
                content.add(name);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescrShops.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}
