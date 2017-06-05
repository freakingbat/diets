/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.Advice;
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
 * Этот класс - содержимое раздела советов
 *
 * @author Pro
 */
public class DescrpAdvice extends AbstractTabulatedPanel {

    public DescrpAdvice(boolean flag, User user) {

        super(flag);
        if (flag) {
            button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddAdvice(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelAdvice().main(this, user);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | MalformedURLException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @Override
    public void update(List<String> content, boolean flag, User user) {
        setDate(content, flag);
        if (flag) {
            this.button_new.addActionListener((ActionEvent e) -> {
                try {
                    new AddAdvice(this, user);
                } catch (IOException ex) {
                    Logger.getLogger(DescrpAdvice.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            this.button_del.addActionListener((ActionEvent e) -> {
                try {
                    new DelAdvice().main(this, user);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | MalformedURLException ex) {
                    Logger.getLogger(DescrpDiets.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @Override
    public List<String> getContent() {
        List<Advice> advice;
        List<String> content = new ArrayList<>();
        try {
            advice = Service.getDataService().getAdvice();
            for (int i = 0; i < advice.size(); i++) {
                String name = "<html><div width = 350>" + advice.get(i).getAdvice() + "</div><hr></html>";
                content.add(name);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DescrShops.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
}
