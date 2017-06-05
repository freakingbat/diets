/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.RecipeDessert;
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
 * Этот класс - содержимое подраздела десертов из раздела рецептов
 *
 * @author Pro
 */
public class DescrpDeserts extends AbstractTabulatedPanel {

    DescrpDeserts(boolean flag, User user) {
        super(flag);
        if (flag) {
            button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddRecipeDessert(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelRecipeDessert().main(this, user);
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
                    new AddRecipeDessert(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelRecipeDessert().main(this, user);
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
        List<RecipeDessert> dessert;
        List<String> content = new ArrayList<>();
        try {
            dessert = Service.getDataService().getRecipeDessert();
            for (int i = 0; i < dessert.size(); i++) {
                String name = "<html><div width=350><h3>" + dessert.get(i).getName() + "</h3><br>" + dessert.get(i).getDescrip() + "</div><hr></html>";
                content.add(name);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescrShops.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}
