/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.DietBase;
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
 * Этот класс - содержимое раздела диет
 *
 * @author Pro
 */
public class DescrpDiets extends AbstractTabulatedPanel {

    DescrpDiets(boolean flag, User user) {
        super(flag);
        if (flag) {
            this.button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddDiet(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelDiet().main(this, user);
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
                    new AddDiet(this, user);
                    this.repaint();
                    this.d_some.repaint();

                } catch (IOException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelDiet().main(this, user);
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
        List<DietBase> dietBase;
        List<String> content = new ArrayList<>();
        try {
            dietBase = Service.getDataService().getDietBases();
            for (int i = 0; i < dietBase.size(); i++) {
                String name = "<html><div width = 350><h3>" + dietBase.get(i).getName() + "</h3><br>" + dietBase.get(i).getText() + "</div><hr></html>";
                content.add(name);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescrShops.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}
