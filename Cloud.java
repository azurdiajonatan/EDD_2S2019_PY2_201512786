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
import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList rutas;
    
    public Cloud() {
        initComponents();
    }

    public Cloud(HashTable actualtable, Stack actualstack,HashNode actualnode){
        initComponents();
        this.newtable = actualtable;
        this.newstack = actualstack;
        this.actualuser = actualnode;
        this.setTitle(actualnode.getName());
        GetAll("/");
        rutas = new ArrayList();
        rutas.add(0,"/");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modifyfolder = new javax.swing.JButton();
        deletefolder = new javax.swing.JButton();
        backto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        foldettable = new javax.swing.JTable();
        rutaactual = new javax.swing.JTextField();
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

        modifyfolder.setText("Agregar");
        modifyfolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyfolderActionPerformed(evt);
            }
        });

        deletefolder.setText("Eliminar");

        backto.setText("<---");
        backto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtoActionPerformed(evt);
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
        foldettable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foldettableMouseClicked(evt);
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

        jMenuItem2.setText("Grafo Report");
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deletefolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(modifyfolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backto)
                        .addGap(89, 89, 89)
                        .addComponent(modifyfolder)
                        .addGap(18, 18, 18)
                        .addComponent(deletefolder))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void modifyfolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyfolderActionPerformed
        try{
        Matrix mtx = actualuser.getNewmatrix();
        String rutatotal = "";
        String path =  JOptionPane.showInputDialog("Escribe el nombre de la carpeta)");
        if(rutas.size()>1){
            rutas.add("/");
            rutas.add(path);
            
            for(Object element : rutas){
                rutatotal += (String)element;
            }
            rutaactual.setText(rutatotal);
            mtx.Add(rutatotal);
            Clean();
            GetAll((String) rutas.get(rutas.size()-1));
            newstack.Insert_Node("Se creo la carpeta path",actualuser.getName());
        }else{
            rutas.add(path);
            for(Object element : rutas){
                rutatotal += (String)element;
            }
            rutaactual.setText(rutatotal);
            mtx.Add(rutatotal);
            Clean();
            GetAll((String) rutas.get(rutas.size()-1));
            newstack.Insert_Node("Se creo la carpeta path",actualuser.getName());
        }
        }catch(Exception ios){
                JOptionPane.showMessageDialog(null,"Ingrese un nombre");
        }
    }//GEN-LAST:event_modifyfolderActionPerformed
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Index newindex = new Index(newtable,newstack);
        newindex.show();
        this.dispose();
        newstack.Insert_Node("Cerro sesion",actualuser.getName());
    }//GEN-LAST:event_formWindowClosed
    private void backtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtoActionPerformed
        String getruta = "";
        if(rutas.size()>2){
            rutas.remove(rutas.size()-1);
            rutas.remove(rutas.size()-1);
            for(Object element : rutas){
                getruta += (String)element;
            }
            rutaactual.setText(getruta);
            Clean();
            GetAll((String) rutas.get(rutas.size()-1));
        }else{
            if(rutas.get(rutas.size()-1).equals("/")){
                for(Object element : rutas){
                    getruta += (String)element;
                }
                rutaactual.setText(getruta);
                Clean();
                GetAll((String) rutas.get(rutas.size()-1));
            }else{
               rutas.remove(rutas.size()-1);
                for(Object element : rutas){
                    getruta += (String)element;
                }
                 rutaactual.setText(getruta); 
                 Clean();
                 GetAll((String) rutas.get(rutas.size()-1));
            }  
        }
    }//GEN-LAST:event_backtoActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       newstack.Insert_Node("Se genero el reporte de su matriz",actualuser.getName());
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
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       newstack.Insert_Node("Se genero el reporte del grafo de la matriz",actualuser.getName());
        try{
            actualuser.newmatrix.GraphMatrix(actualuser.getName(), actualuser.getNewmatrix());
            Images newimage = new Images();
            String image_name = new java.io.File("grafo_"+actualuser.getName()+".jpg").getAbsolutePath();
            String htmlcode = "<img src=\"file:"+image_name+"\"></img>";
            newimage.ShowImage(htmlcode);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void foldettableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foldettableMouseClicked
        DefaultTableModel model = (DefaultTableModel) foldettable.getModel();
        int line = foldettable.rowAtPoint(evt.getPoint());
        int column = foldettable.columnAtPoint(evt.getPoint());
        if(line > -1 && column > -1){
            String rutatotal = "";
            String value = (String) model.getValueAt(line, column);
            Clean();
            GetAll(value);
            if(rutas.size()>1){
            rutas.add("/");
            rutas.add(value);
            
            for(Object element : rutas){
                rutatotal += (String)element;
            }
            rutaactual.setText(rutatotal);
            Clean();
            GetAll((String) rutas.get(rutas.size()-1));
            MatrixNode getfiles = actualuser.newmatrix.ReturnSon((String) rutas.get(rutas.size()-1));
            if(getfiles!=null){
                Files sfile = new Files(newtable,newstack,actualuser,getfiles);
                sfile.show();
            }
        }else{
            rutas.add(value);
            for(Object element : rutas){
                rutatotal += (String)element;
            }
            rutaactual.setText(rutatotal);
            Clean();
            GetAll((String) rutas.get(rutas.size()-1));
        }
            
        }
    }//GEN-LAST:event_foldettableMouseClicked
    private void Clean(){
        DefaultTableModel mdl = (DefaultTableModel) foldettable.getModel();
        while(mdl.getRowCount()>0){
            mdl.removeRow(0);
        }
    }
    
    private void GetAll(String getfather){
        DefaultTableModel model = (DefaultTableModel) foldettable.getModel();
        Matrix actualmtx = actualuser.getNewmatrix();
        MatrixNode header = actualmtx.Search_Father(getfather);
        if(header.right != null){
            MatrixNode temporal = header.right;
            while(temporal != null){
                MatrixNode assistand = temporal.up;
                if(assistand != null){
                    Object [] astd = new Object[1];
                    astd[0] = assistand.getLocation();
                    model.addRow(astd);
                }
                temporal = temporal.right;
            }
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
    private javax.swing.JButton backto;
    private javax.swing.JButton deletefolder;
    private javax.swing.JTable foldettable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyfolder;
    private javax.swing.JTextField rutaactual;
    // End of variables declaration//GEN-END:variables

    

}
