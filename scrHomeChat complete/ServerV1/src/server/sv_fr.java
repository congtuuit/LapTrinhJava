/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
import java.util.logging.Logger;


/**
 *
 * @author Minions
 */
public class sv_fr extends javax.swing.JFrame {

    /**
     * Creates new form sv_fr
     * @throws java.net.UnknownHostException
     */
    public sv_fr() throws UnknownHostException {
        initComponents();
        InetAddress addr = InetAddress.getLocalHost();
        String ipAddress = addr.getHostAddress();
        setTitle("Server HomeChat!");
        Font f = new Font("Arial",Font.BOLD,18);
        sv.setFont(f);
        sv.setForeground(Color.red);
        txtbox.setEditable(false);
        setResizable(false);
        bstop.enable(true);
      
        
    }
    ArrayList clientOutputStreams;
    ArrayList<String> users;
    PrintWriter writer;
    static ServerSocket ss;
    static Socket s;

    public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;

       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader is = new InputStreamReader(sock.getInputStream());// lay du lieu vao
                reader = new BufferedReader(is);
            }
            catch (Exception ex) 
            {
                txtbox.append("Unexpected error! \n");
            }

       }
       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" ;
            String[] data;
            try 
            {
                while ((message = reader.readLine()) != null) //message doc tung du lieu nhan vao
                {
                    txtbox.append("Received: " + message + "\n");
                    data = message.split(":");
                    
                    for (String token:data) 
                    {
                        txtbox.append(token + ":");
                    }

                    if (data[2].equals(connect)) 
                    {
                        Everyone((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        Everyone((data[0] + ":has disconnected." + ":" + chat));
                        userRemove(data[0]);
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        Everyone(message);
                    } 
                    else 
                    {
                        
                    }
                } 
             } 
             catch (Exception ex) 
             {
                txtbox.append("Lost a connection. \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
             } 
	} 
    }
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  

            try 
            {
                ss = new ServerSocket(9999);

                while (true) 
                {
				Socket clientSock = ss.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);

				Thread listener = new Thread(new ClientHandler(clientSock, writer));
				listener.start();
				txtbox.append("Has a connection. \n");
                }
            }
            catch (Exception ex)
            {
                txtbox.append("Error Serverstart. \n");
            }
        }
    }
    
    public void userAdd (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        ///txtbox.append(name + " added. \n");
        users.add(name);
        //txtbox.append(name + " added. \n");
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            Everyone(message);
        }
        Everyone(done);
    }
    
    public void userRemove (String data) 
    {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        users.remove(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token:tempList) 
        {
            message = (token + add);
            Everyone(message);
        }
        Everyone(done);
    }
    
    public void Everyone(String message) 
    {
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
		txtbox.append("Sending: " + message + "\n");
                writer.flush();
                txtbox.setCaretPosition(txtbox.getDocument().getLength());

            } 
            catch (Exception ex) 
            {
		txtbox.append("Error telling everyone. \n");
            }
        } 
    }
public void ip(){
    try {
         Enumeration<NetworkInterface> eni = NetworkInterface.getNetworkInterfaces();
         while (eni.hasMoreElements()) {
              NetworkInterface ni = eni.nextElement();
              Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
              while (inetAddresses.hasMoreElements()) {
                  InetAddress ia = inetAddresses.nextElement();
                  txtbox.append(ni.getName() + "   IP: " + ia.getHostAddress()+"\n");
             }
         }
     } catch (Exception ex) {
     }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbox = new javax.swing.JTextArea();
        bstart = new javax.swing.JButton();
        bstop = new javax.swing.JButton();
        sv = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbox.setBackground(java.awt.SystemColor.controlHighlight);
        txtbox.setColumns(20);
        txtbox.setRows(5);
        txtbox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(txtbox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 413, 160));

        bstart.setText("Start");
        bstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstartActionPerformed(evt);
            }
        });
        getContentPane().add(bstart, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 152, 70, -1));

        bstop.setText("Stop");
        bstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstopActionPerformed(evt);
            }
        });
        getContentPane().add(bstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 190, 70, -1));

        sv.setText("Server");
        getContentPane().add(sv, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 13, 61, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 36, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 140, 210));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1logo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstartActionPerformed

        Thread starter = new Thread(new ServerStart());
        starter.start();
        CreateWifi wf=new CreateWifi();
        try {
            wf.run();
        } catch (Exception ex) {
           
        }
            txtbox.append("Hostpot: wifi-homechat\nPassword: 12345678\n");
            bstart.setEnabled(false);
            bstop.setEnabled(true);
            txtbox.append("Server runing!\n");    
    }//GEN-LAST:event_bstartActionPerformed
    
    private void bstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstopActionPerformed
        // TODO add your handling code here:
        StopWifi wf=new StopWifi();
        try {
            wf.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(sv_fr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(sv_fr.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] tempList = new String[(users.size())];
        for (String token:tempList) 
        {
            
             Everyone(token+"Server stopped!: :Connect");
        }
        Everyone("Server: :Done");
       
        txtbox.append("Stopped. \n");
        txtbox.setText("");
         try 
        {
            Thread.sleep(5000);                 //5000 milliseconds is five second.
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
         bstop.setEnabled(false);
         bstart.setEnabled(true);
    }//GEN-LAST:event_bstopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sv_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sv_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sv_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sv_fr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new sv_fr().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(sv_fr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bstart;
    private javax.swing.JButton bstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sv;
    private javax.swing.JTextArea txtbox;
    // End of variables declaration//GEN-END:variables
}
