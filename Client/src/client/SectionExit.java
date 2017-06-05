/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Этот класс реелизует заполнение раздела выхода
 *
 * @author Pro
 */
public class SectionExit extends JPanel {

    public SectionExit() {
        JPanel exit = new JPanel();
        exit.setBackground(new Color(235, 252, 224));
        exit.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Font font = new Font("Ossem Rounded", Font.PLAIN, 25);

        JLabel label = new JLabel("Ждём Вас снова!");
        label.setFont(font);
        label.setBackground(new Color(255, 255, 255));
        JButton exitItem = new JButton("Exit");
        exit.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            /**
             * Метод реализует выход из программы
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addComponent(c, 1, 0, 1);
        c.insets = new Insets(60, 0, 0, 0);
        exit.add(label, c);

        addComponent(c, 1, 0, 2);
        c.insets = new Insets(20, 0, 0, 0);
        exit.add(exitItem, c);
        this.add(exit);
    }

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
}
