/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.*;
/**
 *
 * @author Windows 10
 */
public class StopWifi {
    public void run() throws IOException, InterruptedException{

    Process rt = Runtime.getRuntime().exec("netsh wlan stop hostednetwork");
    rt.waitFor();
    rt = Runtime.getRuntime().exec("netsh wlan set hostednetwork mode=disallow ssid=wifi-homechat key=12345678");
    //rt.waitFor();
    }
}