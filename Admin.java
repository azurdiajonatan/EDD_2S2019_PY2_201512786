package proyectofinaledd2019;

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Admin extends javax.swing.JFrame {
    
    HashTable newtable;
    Stack newstack;
    static ArrayList<String> saveusers = new ArrayList();
    int approved = 0;
    int not_approved = 0;
    
    public Admin() {
        initComponents();   
    }
    
    public Admin(HashTable actual,Stack actualstack){
        initComponents();
        this.newtable = actual;
        this.newstack = actualstack;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonselect = new javax.swing.JButton();
        textpath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelnousers = new javax.swing.JLabel();
        labelusers = new javax.swing.JLabel();
        buttonload = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel1.setText("Administrador");

        buttonselect.setText("Seleccionar archivo");
        buttonselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonselectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setText("Usuarios Cargados");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("Usuarios Rechazados");

        labelnousers.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        labelnousers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelusers.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        labelusers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        buttonload.setText("Load Users");
        buttonload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonloadActionPerformed(evt);
            }
        });

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Reports");

        jMenuItem1.setText("Hash Table Report");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Stack Report");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelusers, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(123, 123, 123)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelnousers, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(148, 148, 148))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonselect)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textpath, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(buttonload)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonselect)
                            .addComponent(textpath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonload)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnousers, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelusers, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void buttonselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonselectActionPerformed
        JFileChooser search = new JFileChooser();
        search.showOpenDialog(search);
        try{
            String path = search.getSelectedFile().getAbsolutePath();
            textpath.setText(path);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null, ios);
        }
    }//GEN-LAST:event_buttonselectActionPerformed
    private void buttonloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonloadActionPerformed
        if(textpath.getText() != null){
            if (!"".equals(textpath.getText())) { 
                Load_User(textpath.getText());
                newstack.Insert_Node("Se insertaron nuevos usuarios al programa","Admin");
            }
        }
    }//GEN-LAST:event_buttonloadActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Table st = new Table(newtable);
      st.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Index pt = new Index(newtable,newstack);
        pt.show();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        newstack.Insert_Node("Se genero el reporte de usuarios","Admin");
        try{
            newtable.Graph_Hash();
            Images newimage = new Images();
            String image_name = new java.io.File("Users.png").getAbsolutePath();
            String htmlcode = "<img src=\"file:"+image_name+"\"></img>";
            newimage.ShowImage(htmlcode);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        newstack.Insert_Node("Se genero el reporte de de acciones","Admin");
        try{
            newstack.Graph_Stack();
            Images newimage = new Images();
            String image_name = new java.io.File("Actions.png").getAbsolutePath();
            String htmlcode = "<img src=\"file:"+image_name+"\"></img>";
            newimage.ShowImage(htmlcode);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
    
    private void Load_User(String path){
        final String separator = ",";
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(path));
            String getline = br.readLine();
            while((getline = br.readLine())!= null){
                String[] save = getline.split(separator);
                
                String getname = save[0];
                String getpass = save[1];
                if(Check_Password(getpass) == true){
                    if(newtable.Search_user(getname) == false){
                        String newpass = getHexString(getSha256(getpass));
                        newtable.Add_New(getname,newpass);
                        approved++;
                    }else{
                        JOptionPane.showMessageDialog(null,"El usuario "+getname+" ya existe");
                        saveusers.add(getname+","+getpass+","+"El usuario ya existe");
                        not_approved++;
                    }
                }else{
                    saveusers.add(getname+","+getpass+","+"La contrasena es menor a 8 caracteres");
                    not_approved++;
                }
            }
            br.close();
        }catch(HeadlessException | IOException | NoSuchAlgorithmException ios){
            JOptionPane.showMessageDialog(null, ios);
        }
        
        labelusers.setText(String.valueOf(approved));
        labelnousers.setText(String.valueOf(not_approved));
        System.out.println("---------------- aqui metodo");
        newtable.Show_Table();
    }
    
    private boolean Check_Password(String password){
        boolean check = false;
        if(password.length()>7){
            check = true;
        }
        return check;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonload;
    private javax.swing.JButton buttonselect;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel labelnousers;
    private javax.swing.JLabel labelusers;
    private javax.swing.JTextField textpath;
    // End of variables declaration//GEN-END:variables

    private  byte[] getSha256(String string_input) throws NoSuchAlgorithmException{
        MessageDigest message = MessageDigest.getInstance("SHA-256");
        return message.digest(string_input.getBytes(StandardCharsets.UTF_8));
    }
    
    private  String getHexString(byte[] new_hash){
        BigInteger number = new BigInteger(1,new_hash);
        StringBuilder string_hex = new StringBuilder(number.toString(16));
        while(string_hex.length() < 32){
            string_hex.insert(0,'0');
        }
        return string_hex.toString();
    }

}
