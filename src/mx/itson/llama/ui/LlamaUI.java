/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.llama.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.llama.entitites.entities.Movie;
import mx.itson.llama.entitites.entities.User;

/**
 *
 * @author asterium
 */
public class LlamaUI extends javax.swing.JFrame {

    /**
     * Creates new form LlamaUI
     */
    public LlamaUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblDespliegue = new javax.swing.JScrollPane();
        tblMovie = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMovie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Schedule", "Room"
            }
        ));
        tblDespliegue.setViewportView(tblMovie);
        tblMovie.getAccessibleContext().setAccessibleParent(this);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnShow.setText("Show Table");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblDespliegue, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(tblDespliegue, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(btnBack))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            int mId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la pelicua"));
            Movie.delete(mId);
            
            
            
            
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error"+ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       
        try{


           int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el ID de la pelicula"));
           String name = JOptionPane.showInputDialog("Ingrese el nombre de la pelicula");          
           String type = JOptionPane.showInputDialog("Ingrese la clasificacion");
           String schedule = JOptionPane.showInputDialog("Ingrese la fecha de cartelera");
           int room = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la  sala"));
           
           
           Movie.add(id, name, type, schedule, room);
           
           
           
           
       }catch(Exception ex){
           System.out.println("Ocurrio un erros"+ex.getMessage());
       }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        
        try{
            int fila = tblMovie.getSelectedRow();
            if(fila != -1){
                int id = (int) tblMovie.getValueAt(fila,0);
                String name = (String) tblMovie.getValueAt(fila,1);
                String type = (String) tblMovie.getValueAt(fila,2);
                String schedule = (String) tblMovie.getValueAt(fila,3);
                int room = (int) tblMovie.getValueAt(fila,4);
                
                int newId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id",id));
                if (newId < 0) {
             return; 
                }
                String newName = JOptionPane.showInputDialog("Ingrese el nuevo nombre",name); 
                if (newName == null) {
            return;
            }
                String newType = JOptionPane.showInputDialog("Ingrese la nueva categoria",type);
                if (newType == null) {
            return;
            }
                String newSchedule = JOptionPane.showInputDialog("Ingrese el nuevo horario",schedule);
                if (newSchedule == null) {
            return;
            }
                int newRoom = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva sala",room));
                if (newRoom <0) {
            return;
            }
                
                Movie.update(newId, newName, newType, newSchedule, newRoom);
                

            }else{
               JOptionPane.showMessageDialog(rootPane, "Seleccione una pelicula");
            }
            
        }catch(Exception ex){
            System.out.println("Ocurrio un erros"+ex.getMessage());
        }
           
                
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try{
            String filtro = txtSearch.getText();
            List<Movie> movie = Movie.getAll(filtro);
            DefaultTableModel tableModel = (DefaultTableModel)tblMovie.getModel();
            tableModel.setRowCount(0);
            for(Movie movies : movie){
                Object[]rowDate = {movies.getId(),movies.getName(),movies.getType(),movies.getSchedule(),movies.getRoom(),movies.getDate()};
                tableModel.addRow(rowDate);
            }
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error"+ex.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
     try{
            String filtro = txtSearch.getText();
            List<Movie> movie = Movie.getAll(filtro);
            DefaultTableModel tableModel = (DefaultTableModel)tblMovie.getModel();
            tableModel.setRowCount(0);
            for(Movie movies : movie){
                Object[]rowDate = {movies.getId(),movies.getName(),movies.getType(),movies.getSchedule(),movies.getRoom(),movies.getDate()};
                tableModel.addRow(rowDate);
            }
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error"+ex.getMessage());
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainUI main = new MainUI();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(LlamaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LlamaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LlamaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LlamaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LlamaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane tblDespliegue;
    private javax.swing.JTable tblMovie;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
