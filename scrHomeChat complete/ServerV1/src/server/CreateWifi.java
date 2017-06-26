/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Windows 10
 */
public class CreateWifi {
    public void run() throws InterruptedException { 
            try { 
            Process rt = Runtime.getRuntime().exec("netsh wlan set hostednetwork mode=allow ssid=wifi-homechat key=12345678"); 
                try {
                    rt.waitFor();
                } catch (InterruptedException ex) {
                    Logger.getLogger(CreateWifi.class.getName()).log(Level.SEVERE, null, ex);
                }
            rt = Runtime.getRuntime().exec("netsh wlan start hostednetwork");
            rt.waitFor();
            } catch (IOException ex) { 
           // Logger.getLogger(CreateWifi.class.getName()).log(Level.SEVERE, null, ex); 
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateWifi.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
}
