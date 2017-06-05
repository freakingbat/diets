/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.UUID;

public class GenerateUUID {
    public static String generate(){
        return (UUID.randomUUID()).toString();
    }
} 