/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinaledd2019;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonat
 */
public class Cloud extends javax.swing.JFrame {

    AVLTree newtree;
    HashTable newtable;
    Stack newstack;
    HashNode actualuser;
    
    
    public Cloud() {
        initComponents();
    }

    public Cloud(HashTable actualtable, Stack actualstack,HashNode actualnode){
        initComponents();
        this.newtable = actualtable;
        this.newstack = actualstack;
        this.actualuser = actualnode;
        this.setTitle(actualnode.getName());
        ShowFolders();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createfolder = new javax.swing.JButton();
        modifyfolder = new javax.swing.JButton();
        deletefolder = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        foldettable = new javax.swing.JTable();
        rutaactual = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        createfolder.setText("Crear");
        createfolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createfolderActionPerformed(evt);
            }
        });

        modifyfolder.setText("Modificar");
        modifyfolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyfolderActionPerformed(evt);
            }
        });

        deletefolder.setText("Eliminar");

        upload.setText("Subir");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        foldettable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Carpetas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(foldettable);

        rutaactual.setText("/");
        rutaactual.setEnabled(false);

        jMenu1.setText("Reports");

        jMenuItem1.setText("Matrix Report");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(upload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deletefolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifyfolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createfolder, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rutaactual)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rutaactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(createfolder)
                        .addGap(18, 18, 18)
                        .addComponent(modifyfolder)
                        .addGap(18, 18, 18)
                        .addComponent(deletefolder)
                        .addGap(18, 18, 18)
                        .addComponent(upload))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(374, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyfolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyfolderActionPerformed
     String newname = JOptionPane.showInputDialog("Escriba el nombre de la nueva carpeta");
     Matrix mtx = actualuser.getNewmatrix();
     mtx.Add(rutaactual+"newname");
     rutaactual.setText(rutaactual.getText()+"newname"+"/");
     ShowFolders();
    }//GEN-LAST:event_modifyfolderActionPerformed

    private void createfolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createfolderActionPerformed
        String path =  JOptionPane.showInputDialog("Escribe la ruta separada por / (diagonal)");
        Matrix mtx = actualuser.getNewmatrix();
        mtx.Add(path);
        mtx.PrintX();
        Clean();
        ShowFolders();
        newstack.Insert_Node("Se creo la carpeta: "+path,actualuser.getName());
    }//GEN-LAST:event_createfolderActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      Index newindex = new Index(newtable,newstack);
      newindex.show();
      this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
       
    }//GEN-LAST:event_uploadActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       newstack.Insert_Node("Se genero el reporte de su matrix",actualuser.getName());
        try{
            actualuser.newmatrix.GraphMatrix(actualuser.getName(), actualuser.getNewmatrix());
            Images newimage = new Images();
            String image_name = new java.io.File("mtx_"+actualuser.getName()+".jpg").getAbsolutePath();
            String htmlcode = "<img src=\"file:"+image_name+"\"></img>";
            newimage.ShowImage(htmlcode);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Clean(){
        DefaultTableModel mdl = (DefaultTableModel) foldettable.getModel();
        while(mdl.getRowCount()>0){
            mdl.removeRow(0);
        }
    }
            
    
    private void ShowFolders(){
        DefaultTableModel model = (DefaultTableModel) foldettable.getModel();
        Matrix actualmtx = actualuser.getNewmatrix();
        MatrixNode theader = actualmtx.head.right;
        while(theader !=null){
            MatrixNode temporal = theader.down;
            if(temporal != null){
                Object [] astd = new Object[1];
                astd[0] = temporal.getFolder();
                model.addRow(astd);
            }
            theader = theader.right;
        }
        foldettable.setModel(model);
    }
    
    
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
            java.util.logging.Logger.getLogger(Cloud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cloud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cloud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cloud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cloud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createfolder;
    private javax.swing.JButton deletefolder;
    private javax.swing.JTable foldettable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyfolder;
    private javax.swing.JTextField rutaactual;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables

    private void Load_Files(String path) throws IOException{
        final String separator = ",";
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(path));
            String getline = br.readLine();
            while((getline = br.readLine())!=null){
                String[] save = getline.split(separator);
                String filename = save[0];
                String content = save[1];
                //newtree.Insert_New_Node(filename, content);
            }
            br.close();
        }catch(FileNotFoundException ios){
            JOptionPane.showMessageDialog(null, ios);
        }
   }
    
    private void Search_File(){
        JFileChooser search = new JFileChooser();
        search.showOpenDialog(search);
        try{
            String path = search.getSelectedFile().getAbsolutePath();
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }
    }

}
