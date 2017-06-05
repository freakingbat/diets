/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.label.WebLabel;
import com.alee.laf.scroll.WebScrollPane;
import com.alee.laf.text.WebTextArea;
import diets.objects.Advice;
import diets.objects.Gym;
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
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

/**
 * Кнопка, при нажатии на которую добавляется совет в БД
 *
 * @author Pro
 */
public class AddAdvice extends JFrame {

    public AddAdvice(DescrpAdvice panel, User user) throws IOException {
        super("Внесение изменений");

        JPanel smth = new JPanel();
        smth.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        smth.setBackground(new Color(255, 255, 255));

        WebLabel text = new WebLabel("Введите совет");

        WebTextArea textArea = new WebTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new BasicBorders.FieldBorder(Color.yellow, Color.darkGray, Color.lightGray, Color.lightGray));
        WebScrollPane areaScroll = new WebScrollPane(textArea);
        areaScroll.setPreferredSize(new Dimension(350, 200));

        JButton button_finish = new JButton("Добавить") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 30);
            }
        };

        button_finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Advice advice = new Advice();
                advice.setAdvice(textArea.getText());

                try {
                    Service.getDataService().newAdvice(user.getLogin(), user.getToken(), advice);
                    setVisible(false);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(AddDiet.class.getName()).log(Level.SEVERE, null, ex);
                }
                panel.update(panel.getContent(), panel.flag, user);
                panel.repaint();
                panel.d_some.repaint();
                panel.repaint();
                panel.d_some.repaint();
            }
        });

        addComponent(c, 1, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);
        smth.add(text, c);

        addComponent(c, 1, 1, 2);
        c.insets = new Insets(5, 0, 0, 0);
        smth.add(areaScroll, c);

        addComponent(c, 1, 1, 3);
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