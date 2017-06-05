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
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Этот класс собирает окно уведомления
 * об ошибке при вводе данных
 * @author Pro
 */
public class Error extends JFrame{
    
    public Error() throws IOException{
        super("Ошибка!");
      
    JPanel error = new JPanel();
    error.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    error.setBackground( new Color (255, 255, 255) );
    
    WebLabel text = new WebLabel("Проверьте формат ввода!");
    JButton button_finish = new JButton("Закрыть"){
              @Override
              public Dimension getPreferredSize(){
              return new Dimension(100,30);
              }
          };
    
    button_finish.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
         } 
        }); 
    
    addComponent(c,1, 1, 1);
    c.insets = new Insets(0,0,0,0);
    error.add(text, c);
   
    addComponent(c,1, 1, 2);
    c.insets = new Insets(5,0,0,0);
    error.add(button_finish, c);
    
    getContentPane().add(error); 
        
    pack();
    setLocationRelativeTo(null);
         
    setVisible(true);
    setSize(200,200);
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
