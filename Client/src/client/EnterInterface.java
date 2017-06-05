/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.text.WebPasswordField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.alee.laf.text.WebTextField;
import diets.objects.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Этот класс собирает окно входа, перенаправляет на окна регистрации, меню или
 * восстановление пароля
 *
 * @see client.PageInterface
 * @see client.PasswordInterface
 * @see client.RegistrationInterface
 * @author Pro
 */
public class EnterInterface extends JFrame {

    public EnterInterface() throws IOException {
        super("Вход");
        JPanel enter = new JPanel();
        enter.setBackground(new Color(255, 255, 255));
        enter.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //setDefaultCloseOperation( EXIT_ON_CLOSE);
        JLabel text_login = new JLabel("Введите логин:");
        final WebTextField loginField = new WebTextField(15);
        loginField.setPreferredSize(new Dimension(20, 30));
        JLabel text_password = new JLabel("Введите пароль:");
        final WebPasswordField passwordField = new WebPasswordField(15);
        passwordField.setEchoChar('*');
        passwordField.setPreferredSize(new Dimension(20, 30));
        JButton button_enter = new JButton("Вход");
        button_enter.addActionListener((ActionEvent e) -> {
            try {
                User user = Service.getLoginService().logIn(loginField.getText(), new String(passwordField.getPassword()));
                new PageInterface(user);
                setVisible(false);

            } catch (MalformedURLException ex) {
                Logger.getLogger(EnterInterface.class.getName()).log(Level.SEVERE, null, ex);

            } catch (VerifyError ex) {
                try {
                    new Error();
                } catch (IOException ex1) {
                    Logger.getLogger(EnterInterface.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        });
        /**
         * Этот метод вызывает окно меню при нажатии кнопки
         */
        JButton button_registration = new JButton("Регистрация");
        button_registration.addActionListener((ActionEvent e) -> {
            new RegistrationInterface();
            setVisible(false);
        });

        JButton forgotten_password = new JButton("Забыли пароль?");
        forgotten_password.addActionListener((ActionEvent e) -> {
            try {
                new PasswordInterface();
            } catch (IOException ex) {
                Logger.getLogger(EnterInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        } /**
         * Этот метод вызывает окно восстановления пароля при нажатии кнопки
         */
        );

        addComponent(c, 1, 1, 1);
        c.insets = new Insets(0, 0, 0, 0);
        enter.add(text_login, c);

        addComponent(c, 1, 1, 2);
        c.insets = new Insets(5, 0, 0, 0);
        enter.add(loginField, c);

        addComponent(c, 1, 1, 3);
        c.insets = new Insets(5, 0, 0, 0);
        enter.add(text_password, c);

        addComponent(c, 1, 1, 4);
        c.insets = new Insets(5, 0, 0, 0);
        enter.add(passwordField, c);

        addComponent(c, 1, 1, 5);
        c.insets = new Insets(30, 0, 0, 0);
        enter.add(button_enter, c);

        addComponent(c, 1, 1, 6);
        c.insets = new Insets(10, 0, 0, 0);
        enter.add(button_registration, c);

        addComponent(c, 1, 1, 7);
        c.insets = new Insets(10, 0, 0, 0);
        enter.add(forgotten_password, c);

        getContentPane().add(enter);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
        getContentPane().setBackground(new Color(235, 252, 224));
        setSize(400, 400);

    }

    /**
     * Этот метод определяет параметры размещения компонентов
     *
     * @param c объект класса GridBagConstraints
     * @param height количество ячеек, занимаемых компонентом в высоту
     * @param gx номер столбца компонента
     * @param gy номер строки компонента
     */
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
