/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.label.WebLabel;
import diets.objects.User;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bat
 */
public abstract class AbstractTabulatedPanel extends JPanel {

    JPanel d_some;
    GridBagConstraints c;
    GridBagLayout bagLayout;
    JButton button_new;
    JButton button_del;
    boolean flag;

    AbstractTabulatedPanel(boolean flag) {
        d_some = new JPanel();
        this.flag = flag;
        setDate(getContent(), flag);

    }

    public void setDate(List<String> content, boolean flag) {
        d_some.removeAll();
        this.d_some.setBackground(new Color(235, 252, 224));
        this.bagLayout = new GridBagLayout();
        this.d_some.setLayout(bagLayout);
        this.c = new GridBagConstraints();
        if (flag) {
            this.button_new = new JButton("Добавить");
            this.button_del = new JButton("Удалить");
            this.addComponent(c, 1, 1, 0);
            this.c.insets = new Insets(0, 0, 0, 0);
            this.d_some.add(button_new, c);
            this.addComponent(c, 1, 1, 1);
            this.c.insets = new Insets(0, 0, 0, 0);
            this.d_some.add(button_del, c);
        }

        for (int i = 0; i < content.size(); i++) {
            String name = content.get(i);
            this.addComponent(c, 1, 1, i + 2);
            this.c.insets = new Insets(0, 0, 0, 0);
            this.d_some.add(text(name), c);
        }
        this.add(d_some);
    }

    public abstract List<String> getContent();

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

    public abstract void update(List<String> content, boolean flag, User user);

    public static WebLabel text(String string) {
        final WebLabel some_name = new WebLabel(string, WebLabel.CENTER);
        some_name.setBackground(new Color(235, 252, 224));
        some_name.setMaximumWidth(350);
        return (some_name);
    }

}
