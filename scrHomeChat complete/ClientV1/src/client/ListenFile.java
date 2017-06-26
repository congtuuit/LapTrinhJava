/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Minions
 */
public class ListenFile implements Runnable{
        @Override
        public void run() {
             try 
            {
                ServerSocket ss = new ServerSocket(8778);
                while (true){
                System.out.println("nhansock");
                Socket s=ss.accept();
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("Hhmmss");
                String tm= sdf.format(cal.getTime());
                String t="Received_chatbox"+tm+".rar";
                //System.out.println(t);
                String time="C:\\Users\\Public/"+t;
                FileOutputStream outFile = new FileOutputStream(time); 
                InputStream in = s.getInputStream();
                byte[]buffer =new byte [1024];
                int count;
                while((count =in.read(buffer))>=0){
                    outFile.write(buffer,0,count);
                }
                outFile.close();
                Client_fr.txtbox.append("Received a file!\n");
                
        }
            } catch (IOException ex) {
                //Logger.getLogger(sv_fr.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
    }

