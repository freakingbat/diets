
package client;

import com.alee.extended.date.WebDateField;
import diets.objects.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
 import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Этот класс собирает окно регистрации
 * @author Pro
 */

public final class RegistrationInterface extends JFrame {


    /**
     * В конструкторе создается панель
     */
    public RegistrationInterface()
    { 
      
        super("Регистрация пользователя");
      

        JPanel reg = new JPanel();
        reg.setBackground( new Color (255, 255, 255) );
        reg.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        String[] cities = new String[] { "Москва", "Санкт-Петербург"};
         
         JComboBox combo1 = new JComboBox(cities){
              @Override
              public Dimension getPreferredSize(){
              return new Dimension(120,40);
              }
          }; 
         
         
        JLabel text_city = new JLabel("Выберите свой город: ");
        JLabel text_date = new JLabel("Введите дату рождения:");
        JLabel text_name = new JLabel("Введите имя: *");
        JLabel text_word = new JLabel("Введите секретное слово: *");
        JLabel text_surname = new JLabel("Введите фамилию: *");
        JLabel text_weight = new JLabel("Текущий вес: *");
        JLabel text_login = new JLabel("Логин: *");
        JLabel text_password = new JLabel("Пароль: *");
        JLabel warning = new JLabel("Заполните выделенные поля!");
        warning.setBackground(Color.red);
        
        final JTextField field_word = new JTextField(20);
        final JTextField field_name = new JTextField(20);
        final JTextField field_surname = new JTextField(20);
        final JTextField field_login = new JTextField(20);
        final JPasswordField field_password = new JPasswordField(20);
        field_password.setEchoChar('*');
        final JTextField field_weight = new JTextField(20);
        
        


         
        JButton button_finish = new JButton("Зарегистрироваться"){
              @Override
              public Dimension getPreferredSize(){
              return new Dimension(140,40);
              }
          };
        
        button_finish.addActionListener((ActionEvent e) -> {
            if(checkWeight(field_weight.getText())
                    &&(field_word.getText().length()!=0)
                    &&(checkLogin(field_login.getText()))&& (checkLogin(field_password.getText()))
                    &(checkName(field_name.getText()))&&(checkName(field_surname.getText()))){
                try {
                    User user = new User();
                    user.setLogin(field_login.getText());
                    user.setName(field_name.getText());
                    user.setSurname(field_surname.getText());
                    user.setWeight(field_weight.getText());
                    user.setWord(field_word.getText());
                    user.setPassword(new String(field_password.getPassword()));
                    user.setCity(combo1.getSelectedItem().toString());
                    Service.getLoginService().newUser(user);
                    setVisible(false);
                    new EnterInterface();
                } catch (IOException ex) {
                    Logger.getLogger(RegistrationInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                try {
                    new Error();
                } catch (IOException ex) {
                    Logger.getLogger(RegistrationInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } /**
         * Этот метод вызывает окно меню при нажатии кнопки
         * добавлены условия
         */ ); 
         
        WebDateField dateField = new WebDateField ( new Date() );
        dateField.setHorizontalAlignment ( SwingConstants.CENTER );

         
        
        addComponent(c,1, 0, 0);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_name, c);
        
        c.insets = new Insets(5,0,0,0); 
        
         addComponent(c,1, 1, 0);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_name, c);
        
        addComponent(c,1, 0, 1);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_surname, c);
        
        addComponent(c,1, 1, 1);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_surname, c);
        
        addComponent(c,1, 0, 2);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_date, c);
        
        addComponent(c,1, 1, 2);
        c.insets = new Insets(0,0,0,0);
        reg.add(dateField, c);
        
        addComponent(c,1, 0, 3);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_weight, c);
       
        addComponent(c,1, 1, 3);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_weight, c);
        
        addComponent(c,1, 0, 4);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_city, c);
        
        addComponent(c,1, 1, 4);
        c.insets = new Insets(0,0,0,0);
        reg.add(combo1, c);
        
        addComponent(c,1, 0, 5);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_word, c);
        
        addComponent(c,1, 1, 5);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_word, c);
        
        addComponent(c,1, 0, 6);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_login, c);
        
        addComponent(c,1, 1, 6);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_login, c);
        
        addComponent(c,1, 0, 7);
        c.insets = new Insets(0,0,0,0);
        reg.add(text_password, c);
        
        addComponent(c,1, 1, 7);
        c.insets = new Insets(0,0,0,0);
        reg.add(field_password, c);
        
        c.insets = new Insets(30,0,0,0);
        
        addComponent(c,1, 1, 8);
        c.insets = new Insets(0,0,0,0);
        reg.add(button_finish, c);
        
        
        getContentPane().add(reg); 
        
        pack();
        setLocationRelativeTo(null);
         
        setVisible(true);
        setSize(400,400);
    }

    public void addComponent(GridBagConstraints c, int height, int gx, int gy) { 
      c.anchor = GridBagConstraints.WEST;
      c.fill = GridBagConstraints.NONE;
      c.gridheight = height;
      c.gridx = gx;
      c.gridy = gy; 
            }  
    /**
     * Этот метод реализует проверку ввода в строку почты
     * через регулярные выражения
     * @param testString введённые данные
     * @return true или false после проверки на соответсвие рег.выражению
     */
//      public static boolean checkMail(String testString){  
//        Pattern p = Pattern.compile(".+\\.(com|ua|ru)");  
//        Matcher m = p.matcher(testString);  
//        return m.matches(); 
//      }
      
    /**
     * Этот метод реализует проверку ввода в строку логина
     * @param userNameString введённые данные
     * @return true или false после проверки на соответсвие рег.выражению
     */
       public static boolean checkLogin(String userNameString){  
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");  
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    } 
    /**
     * Этот метод реализует проверку ввода в строку имя или фамилия
     * @param testString введённые данные
     * @return  true или false после проверки на соответсвие рег.выражению
     */
        public static boolean checkName(String testString){  
        Pattern p = Pattern.compile("^[\\D]{3,15}$");  
        Matcher m = p.matcher(testString);  
        return m.matches();  
    } 
    /**
     * Этот метод реализует проверку ввода в строку веса
     * @param userNameString введённые данные
     * @return  true или false после проверки на соответсвие рег.выражению
     */    
     public static boolean checkWeight(String userNameString){  
        Pattern p = Pattern.compile("^[\\d]{2,3}$");  
        Matcher m = p.matcher(userNameString);  
        return m.matches();  
    } 
 
}
 