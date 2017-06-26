/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.*;



/**
 *
 * @author Minions
 */
public class background extends Canvas{ 
    @Override
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("Untitled.png");  
        g.drawImage(i, 578,228,this);
    }
}

