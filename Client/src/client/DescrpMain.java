/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.RecipeMain;
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
 * Этот класс - содержимое подраздела гарниры из раздела рецепты
 *
 * @author Pro
 */
public class DescrpMain extends AbstractTabulatedPanel {

    DescrpMain(boolean flag, User user) {
        super(flag);
        if (flag) {
            button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddRecipeMain(this, user );
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelRecipeMain().main(this, user);
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
                    new AddRecipeMain(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelRecipeMain().main(this, user);
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
        List<RecipeMain> main;
        List<String> content = new ArrayList<>();
        try {
            main = Service.getDataService().getRecipeMain();
            for (int i = 0; i < main.size(); i++) {
                String name = "<html><div width=350><h3>" + main.get(i).getName() + "</h3><br>" + main.get(i).getDescrip() + "</div><hr></html>";
                content.add(name);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescrShops.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}
