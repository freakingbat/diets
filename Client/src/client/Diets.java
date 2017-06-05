/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.alee.laf.WebLookAndFeel;
import java.io.IOException;

/**
 * Это основной класс, вызывает окно входа
 * @see client.EnterInterface
 * @author Pro
 */
public class Diets {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        WebLookAndFeel.install ();
        
        boolean k = true;
        if(k){
        new EnterInterface();
        
        }
        
        
    }
    
}
