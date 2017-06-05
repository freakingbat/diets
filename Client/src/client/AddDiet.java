/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.label.WebLabel;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.text.WebTextArea;
import diets.objects.DietBase;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Кнопка, при нажатии на которую добавляется совет в БД
 *
 * @author Pro
 */
public class AddDiet extends JFrame {

    public AddDiet(DescrpDiets panel, User user ) throws IOException {
        super("Внесение изменений");

        JPanel smth = new JPanel();
        smth.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        smth.setBackground(new Color(255, 255, 255));

        WebLabel name = new WebLabel("Введите название");
        WebLabel descrip = new WebLabel("Введите описание");
        WebLabel duration = new WebLabel("Введите продолжительность");

        final JTextField field_name = new JTextField(20);

        WebTextArea textArea = new WebTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new BasicBorders.FieldBorder(Color.yellow, Color.darkGray, Color.lightGray, Color.lightGray));
        WebScrollPane areaScroll = new WebScrollPane(textArea);
        areaScroll.setPreferredSize(new Dimension(350, 200));
        final JTextField field_duration = new JTextField(20);

        JButton button_finish = new JButton("Добавить") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 30);
            }
        };

        button_finish.addActionListener((ActionEvent e) -> {
            DietBase diet = new DietBase();
            diet.setName(field_name.getText());
            diet.setText(textArea.getText());
            diet.setDuration(new Long(field_duration.getText()));
            try {
                Service.getDataService().newDiet(user.getLogin(), user.getToken(), diet);
                panel.update(panel.getContent(), panel.flag, user);
                panel.repaint();
                panel.d_some.repaint();
                panel.repaint();
                panel.d_some.repaint();
                setVisible(false);
            } catch (MalformedURLException ex) {
                Logger.getLogger(AddDiet.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        addComponent(c, 1, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);
        smth.add(name, c);

        addComponent(c, 1, 1, 2);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(field_name, c);

        addComponent(c, 1, 1, 3);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(descrip, c);

        addComponent(c, 1, 1, 4);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(areaScroll, c);

        addComponent(c, 1, 1, 5);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(duration, c);

        addComponent(c, 1, 1, 6);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(field_duration, c);

        addComponent(c, 1, 1, 7);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(button_finish, c);

        getContentPane().add(smth);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        setSize(400, 400);
    }

    public void addComponent(GridBagConstraints c, int height, int gx, int gy) {
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.gridheight = height;
        c.gridx = gx;
        c.gridy = gy;
    }

}
