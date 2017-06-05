/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.label.WebLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bat
 */
public class ChangePass extends JFrame {

    public ChangePass(String login) throws IOException {
        super("Восстановление пароля");

        JPanel pass = new JPanel();
        pass.setBackground(new Color(255, 255, 255));
        pass.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        WebLabel text_login = new WebLabel("Введите новый пароль:");
        final JTextField fieldPass = new JTextField(20);
        WebLabel text_word = new WebLabel("Подтверждение пароля:");
        final JTextField fieldPassConfrim = new JTextField(20);

        JButton button_finish = new JButton("Принять") {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 30);
            }
        };
        button_finish.addActionListener((ActionEvent e) -> {
            try {
                if (Service.getLoginService().changePassStepTwo(login, fieldPass.getText(), fieldPassConfrim.getText())) {
                    new EnterInterface();
                }
            } catch (IOException ex) {
                Logger.getLogger(PasswordInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        } /**
         * Этот метод вызывает окно входа при нажатии кнопки
         *
         * @param e
         */
        );
        addComponent(c, 1, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);
        pass.add(text_login, c);

        addComponent(c, 1, 1, 2);
        c.insets = new Insets(5, 0, 0, 0);
        pass.add(fieldPass, c);

        addComponent(c, 1, 1, 3);
        c.insets = new Insets(0, 0, 0, 0);
        pass.add(text_word, c);

        addComponent(c, 1, 1, 4);
        c.insets = new Insets(5, 0, 0, 0);
        pass.add(fieldPassConfrim, c);

        addComponent(c, 1, 1, 5);
        c.insets = new Insets(5, 0, 0, 0);
        pass.add(button_finish, c);

        getContentPane().add(pass);

        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        setSize(400, 400);

    }

    public final void addComponent(GridBagConstraints c, int height, int gx, int gy) {
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
