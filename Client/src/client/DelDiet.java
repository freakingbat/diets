/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.DietBase;
import diets.objects.Identifable;
import diets.objects.User;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import java.awt.event.ActionEvent;
import javax.swing.JList;

/**
 *
 * @author Bat
 */
public class DelDiet extends AdminPanel {

    @Override
    public void setButton(List<Identifable> content, DefaultListModel listModel, JList list, AbstractTabulatedPanel inputPanel, User user) {
        final List<Identifable> cont = content;
        this.del.addActionListener((ActionEvent e1) -> {
            int id = list.getSelectedIndex();
            listModel.remove(id);
            try {
                Service.getDataService().deleteDietById(user.getLogin(), user.getToken(), cont.get(id).getId());
                listModel.clear();
                List<Identifable> newIdentifables = (List<Identifable>) setInformation(listModel);
                cont.clear();
                cont.addAll(newIdentifables);

                inputPanel.update(inputPanel.getContent(), inputPanel.flag, user);
                inputPanel.repaint();
                inputPanel.d_some.repaint();
                inputPanel.repaint();
            } catch (MalformedURLException ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @Override
    public List<?> setInformation(DefaultListModel listModel) {
        List<DietBase> content;
        try {
            content = Service.getDataService().getDietBases();
            for (int i = 0; i < content.size(); i++) {
                listModel.addElement(content.get(i).getName());

            }
            return content;
        } catch (MalformedURLException ex) {
            Logger.getLogger(DelDiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
