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


public class Files extends javax.swing.JFrame {
    
    HashTable newtable;
    Stack newstack;
    HashNode actualuser;
    MatrixNode actualmtx;
        
    public Files() {
        initComponents();
    }
    
    public Files(HashTable actualtable, Stack actualstack, HashNode actualnode,MatrixNode actualpt){
        initComponents();
        this.newtable = actualtable;
        this.newstack = actualstack;
        this.actualuser = actualnode;
        this.actualmtx = actualpt;
        ShowFiles(actualpt.getInside_tree());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablescroll = new javax.swing.JScrollPane();
        filetable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        filetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File", "Content"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        filetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filetableMouseClicked(evt);
            }
        });
        tablescroll.setViewportView(filetable);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");

        jButton4.setText("Sobreescribir");

        jButton5.setText("Descargar");

        jButton6.setText("Compartir");

        jButton7.setText("Subir archivos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jMenu1.setText("Report");

        jMenuItem1.setText("AVL Report");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(tablescroll, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tablescroll, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       newstack.Insert_Node("Se genero el reporte de su matrix",actualuser.getName());
        try{
            actualmtx.inside_tree.Graph_Avl(actualmtx.getFather(), actualmtx.getInside_tree());
            Images newimage = new Images();
            String image_name = new java.io.File("avl_"+actualmtx.getFather()+".jpg").getAbsolutePath();
            String htmlcode = "<img src=\"file:"+image_name+"\"></img>";
            newimage.ShowImage(htmlcode);
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null,ios);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{
          AVLTree gettree = actualmtx.getInside_tree();
           String path =  JOptionPane.showInputDialog("Escribe el nombre del archivo");
           boolean getdot = path.contains(".");
           if(!getdot){
               path+=".txt";
           }
           String content =  JOptionPane.showInputDialog("Escribe la frase que contendra el archivo");
           gettree.Insert_New_Node(path, content,actualuser.getName());
           Clean();
           ShowFiles(actualmtx.getInside_tree());
           newstack.Insert_Node("Se creo la carpeta: "+path,actualuser.getName());
      }catch(Exception ios){
          JOptionPane.showMessageDialog(null, "No se ingreso ningun dato");
      }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser search = new JFileChooser();
        search.showOpenDialog(search);
        try{
            String path = search.getSelectedFile().getAbsolutePath();
            Load_Files(path);
            Clean();
            ShowFiles(actualmtx.getInside_tree());
            newstack.Insert_Node("Se agregaron archivos al avl",actualuser.getName());
        }catch(Exception ios){
            JOptionPane.showMessageDialog(null, ios);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void filetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filetableMouseClicked
        DefaultTableModel model = (DefaultTableModel) filetable.getModel();
        int line = filetable.rowAtPoint(evt.getPoint());
        int column = filetable.columnAtPoint(evt.getPoint());
        if(line > -1 && column > -1){
            System.out.println(model.getValueAt(line, column));
        }
    }//GEN-LAST:event_filetableMouseClicked

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
            java.util.logging.Logger.getLogger(Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Files.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Files().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable filetable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane tablescroll;
    // End of variables declaration//GEN-END:variables
    private void Clean(){
        DefaultTableModel mdl = (DefaultTableModel) filetable.getModel();
        while(mdl.getRowCount()>0){
            mdl.removeRow(0);
        }
    }
    
    private void ShowFiles(AVLTree actualtree){
        GetInfo(actualtree.root);
    }

    private void GetInfo(NodeAvl actualnode){
        DefaultTableModel model = (DefaultTableModel) filetable.getModel();
        if(actualnode != null){
            Object [] astd = new Object[2];
            astd[0] = actualnode.getFilename();
            astd[1] = actualnode.getContent();
            model.addRow(astd);
            GetInfo(actualnode.subleft);
            GetInfo(actualnode.subright);
        }
        filetable.setModel(model);
    }
    
    
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
                actualmtx.inside_tree.Insert_New_Node(filename, content,actualuser.getName());
            }
            br.close();
        }catch(FileNotFoundException ios){
            JOptionPane.showMessageDialog(null, ios);
        }
   }
    
}
