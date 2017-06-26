package client;


import client_voice.r;
import client_voice.Client_voice;
import client_voice.*;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.C;
import javax.swing.JFileChooser;
import javax.swing.*;
/**
 *
 * @author Minions
 */
public class Client_fr extends javax.swing.JFrame {

    static void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String username, address,ipfile;
    static JFileChooser files;
    static File selectedFile;
    ArrayList<String> users = new ArrayList();
    int port = 9999;
    Boolean isConnected = false;
    
    static Socket sock;
    static BufferedReader reader;
    static PrintWriter writer;
    public Client_fr() {
        initComponents();
        Font f = new Font("Arial",Font.BOLD,20);
        txtbox.setFont(f);
        //lbsend.setForeground(Color);
        Font fs = new Font("Arial",Font.BOLD,14);
        lbsend.setFont(fs);
        setTitle("Client HomeChat!");
        txtbox.setEditable(false);
        setResizable(false);
        dconnect.setEnabled(false);
        Font fi = new Font("Time new roman",Font.ITALIC,12);
        name.setFont(fi);
        name.setForeground(Color.BLUE);
        txtbox.append("Welcome to HomeChat! \nClick 'Connect' to get started!\n");
        s_file.setEnabled(true);
        call.setEnabled(false);
        name.setEditable(false);
        senf.setEnabled(false);
        //ListenFile ls=new ListenFile();
        //ls.run();
    }
    

    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
         Thread ls=new Thread(new ListenFile());
         ls.start();
    }
    public void userAdd(String data) 
    {
         users.add(data);
    }
    public void userRemove(String data) 
    {
         txtbox.append(data + " offline.\n");
    }
    public void writeUsers() 
    {
         String[] tempList = new String[(users.size())];
         users.toArray(tempList);
    }
    public void sendDisconnect() 
    {
        String out = (username + ": :Disconnect");
        try
        {
            writer.println(out); 
            writer.flush(); 
        } catch (Exception e) 
        {
            txtbox.append("Could not send message.\n");
        }
    }
    public void Disconnect() //close sock
    {
        try 
        {
            txtbox.append("Disconnected.\n");
            sock.close();
        } catch(Exception ex) {
            txtbox.append("Failed. \n");
        }
        isConnected = false;
        cn1.setEnabled(true);
        name.setEditable(true);
    }

    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(":");
                     System.out.println(data[0]);

                     if (data[2].equals(chat)) 
                     {
                        if(data[0].equals(name.getText())){
                            txtbox.append("Me"+ ": " + data[1] + "\n");
                            txtbox.setCaretPosition(txtbox.getDocument().getLength());
                        }
                        else {
                        txtbox.append(data[0] + ": " + data[1] + "\n");
                        txtbox.setCaretPosition(txtbox.getDocument().getLength());
                        }
                     } 
                     else if (data[2].equals(connect))
                     {
                        txtbox.removeAll();
                        userAdd(data[0]);
                     } 
                     else if (data[2].equals(disconnect)) 
                     {
                         userRemove(data[0]);
                     } 
                     else if (data[2].equals(done)) 
                     {
                        //users.setText("");
                        writeUsers();
                        users.clear();
                     }
                }
           }catch(Exception ex) { }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbox = new javax.swing.JTextArea();
        name = new javax.swing.JTextField();
        senf = new javax.swing.JButton();
        cn1 = new javax.swing.JButton();
        dconnect = new javax.swing.JButton();
        send_msg = new javax.swing.JTextField();
        bsend = new javax.swing.JButton();
        s_file = new javax.swing.JButton();
        r_file = new javax.swing.JButton();
        IPDetails = new javax.swing.JButton();
        lbsend = new javax.swing.JLabel();
        ips = new javax.swing.JTextField();
        call = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        status = new javax.swing.JProgressBar();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 0, 0));
        setMaximumSize(new java.awt.Dimension(741, 422));
        setMinimumSize(new java.awt.Dimension(745, 453));
        setPreferredSize(new java.awt.Dimension(741, 453));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbox.setBackground(new java.awt.Color(233, 233, 233));
        txtbox.setColumns(20);
        txtbox.setRows(5);
        jScrollPane1.setViewportView(txtbox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 13, 587, 310));

        name.setText("Your name");
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 13, 90, -1));

        senf.setText("OK");
        senf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senfActionPerformed(evt);
            }
        });
        getContentPane().add(senf, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        cn1.setBackground(new java.awt.Color(204, 204, 255));
        cn1.setText("Connect");
        cn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cn1ActionPerformed(evt);
            }
        });
        getContentPane().add(cn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 90, 30));

        dconnect.setText("Disconnect");
        dconnect.setMaximumSize(new java.awt.Dimension(83, 25));
        dconnect.setMinimumSize(new java.awt.Dimension(83, 25));
        dconnect.setPreferredSize(new java.awt.Dimension(83, 25));
        dconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dconnectActionPerformed(evt);
            }
        });
        getContentPane().add(dconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 90, 30));

        send_msg.setText("Enter your messages...");
        send_msg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                send_msgMouseClicked(evt);
            }
        });
        send_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_msgActionPerformed(evt);
            }
        });
        send_msg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                send_msgKeyPressed(evt);
            }
        });
        getContentPane().add(send_msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 362, 520, 30));

        bsend.setText("Send");
        bsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsendActionPerformed(evt);
            }
        });
        getContentPane().add(bsend, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, -1, 30));

        s_file.setText("Browser...");
        s_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_fileActionPerformed(evt);
            }
        });
        getContentPane().add(s_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 80, -1));

        r_file.setText("Received");
        r_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_fileActionPerformed(evt);
            }
        });
        getContentPane().add(r_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 90, -1));

        IPDetails.setText("IP Details");
        IPDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(IPDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 90, 30));

        lbsend.setText("Send file to:");
        getContentPane().add(lbsend, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 334, 100, -1));

        ips.setText("192.168.137.1");
        getContentPane().add(ips, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 109, -1));

        call.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rainy\\Desktop\\HomeChat clientvoice\\HomeChat complete\\ClientV1\\src\\emergency-repairs.png")); // NOI18N
        call.setText("Call");
        call.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callActionPerformed(evt);
            }
        });
        getContentPane().add(call, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled-1.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 740, 450));

        status.setStringPainted(true);
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 310, 200, -1));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String ip;
    private void cn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cn1ActionPerformed
        
            try 
            {
                
                name.setText(username);
                name.setEditable(false);
                
                try
                {
                    sock = new Socket(address, port);//port 9999
                    InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                    InetAddress addr = InetAddress.getLocalHost();
                    String ipAddress = addr.getHostAddress();
                    reader = new BufferedReader(streamreader);
                    writer = new PrintWriter(sock.getOutputStream());
                    txtbox.append("");
                    writer.println(username + " :has connected ("+ipAddress+").:Connect");
                    writer.flush();
                    isConnected = true;
                    dconnect.setEnabled(true);
                    cn1.setEnabled(false);
                    s_file.setEnabled(true);
                    call.setEnabled(true);
                    txtbox.setText("");
                }
                catch (Exception ex)
                {
                    txtbox.append("Not found server, try again!! \n");
                    name.setEditable(true);
                }
                InetAddress addr = InetAddress.getLocalHost();
                String ipAddress = addr.getHostAddress();
                r.ip_myself=ipAddress;
                ListenThread();
                // lang nghe voice chat
                Thread t2= new Thread(new r());
                t2.start();
                
            } 
            catch (UnknownHostException ex) 
            {
                Logger.getLogger(Client_fr.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_cn1ActionPerformed
public void CloseFrame(){
    super.dispose();
}
    private void dconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dconnectActionPerformed
        sendDisconnect();
        Disconnect();
        CloseFrame();
        login l=new login();
        l.setVisible(true);
    }//GEN-LAST:event_dconnectActionPerformed

    private void bsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsendActionPerformed
        String send_ms = "";
        if ((send_msg.getText()).equals(send_ms)) {
            send_msg.setText("");
            send_msg.requestFocus();
        } else {
            try {
               writer.println(username + ":" + send_msg.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                txtbox.append("Message was not sent. \n");
            }
            send_msg.setText("");
            send_msg.requestFocus();
        }

        send_msg.setText("");
        send_msg.requestFocus();
    }//GEN-LAST:event_bsendActionPerformed

    private void send_msgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_send_msgKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    String send_ms = "";
        if ((send_msg.getText()).equals(send_ms)) {
            send_msg.setText("");
            send_msg.requestFocus();
        } else {
            try {
               writer.println(username + ":" + send_msg.getText() + ":" + "Chat");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                txtbox.append("Message was not send. \n");
            }
            send_msg.setText("");
            send_msg.requestFocus();
        }

        send_msg.setText("");
        send_msg.requestFocus();
        }
    }//GEN-LAST:event_send_msgKeyPressed

    //boolean file_tmp=false;
    private void s_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_fileActionPerformed
      
        files = new JFileChooser();
        files.setCurrentDirectory(new File(System.getProperty("user.home")));
         int result = files.showOpenDialog(this);
         if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = files.getSelectedFile();
         }
         if (selectedFile.exists()){
             senf.setEnabled(true);
         }else senf.setEnabled(false);
         
    }//GEN-LAST:event_s_fileActionPerformed

    private void IPDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPDetailsActionPerformed

try {
    InetAddress addr = InetAddress.getLocalHost();
    String ipAddress = addr.getHostAddress();
    //r.ip_myself=ipAddress;
    txtbox.append("Your IP: "+ipAddress+"\n");

     } catch (Exception ex) {
         ex.printStackTrace();
     }
     //new IP().setVisible(true);
    }//GEN-LAST:event_IPDetailsActionPerformed

    private void r_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_fileActionPerformed
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().open(new File("C:\\Users\\public"));
        } catch (IOException ex) {
            Logger.getLogger(Client_fr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_r_fileActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked

String st="Ngon ngu lap trinh JAVA.\nHome Chat 1.0\n";
           txtbox.append(st);
      
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void callActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callActionPerformed
        client_fr fr=new client_fr();
        fr.setVisible(true);
    }//GEN-LAST:event_callActionPerformed

    private void send_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_msgActionPerformed
        // TODO add your handling code here:
       send_msg.setText("");
            
    }//GEN-LAST:event_send_msgActionPerformed

    private void send_msgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_msgMouseClicked
        // TODO add your handling code here:
        send_msg.requestFocus();
        send_msg.selectAll();
    }//GEN-LAST:event_send_msgMouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        // TODO add your handling code here:
        name.selectAll();
    }//GEN-LAST:event_nameMouseClicked

    private void senfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senfActionPerformed
        ipfile=ips.getText();
        if(ipfile.length()<11){
        String ti=JOptionPane.showInputDialog(null, "Send to ip:");
        ips.setText(ti);
    }
        else
        if (selectedFile.exists())
                    try {
                                Socket s = new Socket(ipfile,8778); 
                                System.out.println("Conectsockkk");
                                FileInputStream inSend;
                                try (OutputStream out = s.getOutputStream()) {
                                    inSend = new FileInputStream(selectedFile);
                                    byte []buffer=new byte[1024];
                                    int count,xy=0;
                                    while ((count=inSend.read(buffer))>=0){
                                        out.write(buffer,0,count);
                                        xy++;
                                        System.out.println(""+xy);
                                    }
                                }
                                inSend.close();
                                String ms="\nSent file!\n";
                                txtbox.append(ms);
                                s.close();
                    }catch (IOException ex){
                        txtbox.append("\nCannot send!\n");
                        System.out.println(""+ex);
                    }
    }//GEN-LAST:event_senfActionPerformed

    /**
     * @param args the command line arguments
     */
    static DataInputStream din;
    static DataOutputStream dout;
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client_fr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IPDetails;
    private javax.swing.JButton bsend;
    private javax.swing.JButton call;
    private javax.swing.JButton cn1;
    private javax.swing.JButton dconnect;
    private javax.swing.JTextField ips;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbsend;
    private javax.swing.JTextField name;
    private javax.swing.JButton r_file;
    private javax.swing.JButton s_file;
    private javax.swing.JTextField send_msg;
    private javax.swing.JButton senf;
    private javax.swing.JProgressBar status;
    public static javax.swing.JTextArea txtbox;
    // End of variables declaration//GEN-END:variables
}
