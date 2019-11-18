package proyectofinaledd2019;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Signup extends javax.swing.JFrame {

    HashTable newtable;
    Stack newstack;
            
    public Signup() {
        initComponents();
    }
    
    public Signup(HashTable table,Stack actualstack){
        initComponents();
        this.newtable = table;
        this.newstack = actualstack;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        signbutton = new javax.swing.JButton();
        signpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("[EDD DRIVE] SIGN UP");

        jLabel2.setText("User");

        signuser.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel3.setText("Password");

        signbutton.setText("Sign Up");
        signbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(signpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(signuser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(signbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signbuttonActionPerformed
       if(signuser.getText() != null && signpassword.getText() !=null){
           if(newtable.Search_user(signuser.getText().replace(" ","")) == false){
               if(signpassword.getText().replace(" ","").length()>=8){
                   try {
                       String newsha = getHexString(getSha256(signpassword.getText().replace(" ","")));
                       newtable.Add_New(signuser.getText().replace(" ",""),newsha);
                       newtable.Show_Table();
                       newstack.Insert_Node("Se creo un nuevo usuario",signuser.getText());
                       HashNode getnode = newtable.ReturnUser(signuser.getText(), newsha);
                       Cloud cld = new Cloud(newtable,newstack,getnode);
                       cld.show();
                       newstack.Insert_Node("Se inicio sesion: ",signuser.getText());
                       this.setVisible(false);
                   } catch (NoSuchAlgorithmException ex) {
                       Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }else{
                   JOptionPane.showMessageDialog(null,"La contrasena es menor a 8 caracteres. Ingrese una contrasena mayor a 8 caracteres");
               }
           }else{
               JOptionPane.showMessageDialog(null,"Este usuario ya existe. Por favor ingrese otro nombre de usuario");
           }
       }
    }//GEN-LAST:event_signbuttonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Index pt = new Index(newtable,newstack);
        pt.show();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

 
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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton signbutton;
    private javax.swing.JPasswordField signpassword;
    private javax.swing.JTextField signuser;
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
