/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import diets.objects.Advice;
import diets.objects.Identifable;
import diets.objects.User;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Bat
 */
public class DelAdvice extends AdminPanel{

    public DelAdvice() {
        super();
    }
    
    
    
    
    @Override
    public void setButton(List<Identifable> content, DefaultListModel listModel, JList list, AbstractTabulatedPanel inputPanel, User user) {
        final List<Identifable> cont = content;
        this.del.addActionListener((ActionEvent e1) -> {
            int id = list.getSelectedIndex();
            listModel.remove(id);
            try {
                Service.getDataService().deleteAdviceById(user.getLogin(), user.getToken(), cont.get(id).getId());
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
        List<Advice> content;
        try {
            content = Service.getDataService().getAdvice();
            for (int i = 0; i < content.size(); i++) {
                listModel.addElement(content.get(i).getAdvice());

            }
            return content;
        } catch (MalformedURLException ex) {
            Logger.getLogger(DelDiet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
