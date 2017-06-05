/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author tatul
 */
public class SimpleSection extends JPanel {

    public SimpleSection(JPanel descr) {
        descr.setBackground(new Color(235, 252, 224));
        this.add(descr);
    }

}
