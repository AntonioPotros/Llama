/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.llama.ui;

import java.sql.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import mx.itson.llama.persistence.MySQLConnection;

/**
 *
 * @author asterium
 */
public class RoomUI extends javax.swing.JFrame {

    /**
     * Creates new form RoomUI
     */
    public RoomUI() {
        initComponents();
        setLocationRelativeTo(null);
        botones();
        buscarAsientosReservados();
    }
    
    int filas = 5;
    int columnas = 6;
 int largoBoton = 140;
 int anchoBoton = 60;
 int ejeX = 20;
 int ejeY = 20;
 public static Connection conexion;
 public static PreparedStatement sentenciaPreparada;
 public static ResultSet result;

 
 
 public JToggleButton [][] JTBotones = new JToggleButton[filas][columnas];
 
 public void botones(){
     int seatCount = 1;
     JTBotones = new JToggleButton[filas][columnas];
     for(int i = 0;i < filas; i++){
         for(int j = 0;j<columnas;j++){
             JTBotones [i][j] = new JToggleButton();
             JTBotones [i][j].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
             JTBotones [i][j].setText("seat"+" "+seatCount);
             JTBotones [i][j].setBackground(Color.GREEN);
           
             ActionBotones accion = new ActionBotones();
             JTBotones[i][j].addActionListener(accion);
             
             pnlBotones.add(JTBotones[i][j]);
             seatCount++;
             ejeX  += 160;
         }
         ejeX = 20;
         ejeY += 70;
     }
 } 
    public void reservar(int numSeat){
        try{
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE reservation SET reserved = 'si' where num_seat = "+numSeat;
            PreparedStatement statement = conexion.prepareStatement(query);
            int mensaje = statement.executeUpdate();
            if(mensaje>0){
                JOptionPane.showMessageDialog(null, "Asiento reservado");               
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado del asiento");
            }
                
            
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error"+ex.getMessage());
        }
    }
        
    public void sinReservar(int numSeat){
        try{
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE reservation SET reserved = 'no' where num_seat = "+numSeat;
            PreparedStatement statement = conexion.prepareStatement(query);
            int mensaje = statement.executeUpdate();
            if(mensaje>0){
                JOptionPane.showMessageDialog(null, "Sin reservar");               
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado del asiento");
            }
                
            
            
        }catch(Exception ex){
            System.out.println("Ocurrio un error"+ex.getMessage());
        }
    }
    
    public void buscarAsientosReservados(){
        try{
            Connection conexion = MySQLConnection.get();
            String query = "SELECT num_seat,reserved FROM reservation";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.executeQuery();
            
            int num;
            String reserved;
            
            while(result.next()){
                num = result.getInt("num_seat");
                reserved = result.getString("reserved");
                for(int i = 0; i<filas; i++){
                    for(int j = 0; j<columnas; j++){
                        if(JTBotones[i][j].getText().length()==6){
                            
                            String numLetra = JTBotones[i][j].getText().charAt(5)+"";
                            int numero = Integer.parseInt(numLetra);
                            if((num == numero) && (reserved.equals("si"))){
                                JTBotones[i][j].setBackground(Color.red);
                                JTBotones[i][j].setSelected(true);                               
                            }
                            
                        }else if(JTBotones[i][j].getText().length()==7){
                            String numLetra = JTBotones[i][j].getText().charAt(5)+""+JTBotones[i][j].getText().charAt(6);
                            int numero = Integer.parseInt(numLetra);
                            if((num == numero) && (reserved.equals("si"))){
                                JTBotones[i][j].setBackground(Color.red);
                                JTBotones[i][j].setSelected(true);                               
                            }
                            
                        }
                    }
                }
                
                
            }
            
        }catch(Exception ex){
            System.out.println("Ocurrion un error"+ex.getMessage());
        }
    }
    
    public class ActionBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            for(int i = 0; i<filas; i++){
                for(int j = 0;j<columnas; j++ ){
                    if(ae.getSource().equals(JTBotones[i][j])){
                        if(JTBotones[i][j].isSelected()){
                            JTBotones[i][j].setBackground(Color.red);
                            
                            if(JTBotones[i][j].getText().length()==6){
                                String numLetra = JTBotones[i][j].getText().charAt(5)+"";
                                int num = Integer.parseInt(numLetra);
                                reservar(num); 
                                
                            }else if(JTBotones[i][j].getText().length()==6){
                                 String numLetra = JTBotones[i][j].getText().charAt(5)+" "+JTBotones[i][j].getText().charAt(6);
                                int num = Integer.parseInt(numLetra);
                                reservar(num);
                                
                            }
                            
                        }else{
                            JTBotones[i][j].setBackground(Color.GREEN);
                            
                                                        if(JTBotones[i][j].getText().length()==6){
                                String numLetra = JTBotones[i][j].getText().charAt(5)+"";
                                int num = Integer.parseInt(numLetra);
                                sinReservar(num); 
                                
                            }else if(JTBotones[i][j].getText().length()==6){
                                 String numLetra = JTBotones[i][j].getText().charAt(5)+" "+JTBotones[i][j].getText().charAt(6);
                                int num = Integer.parseInt(numLetra);
                                sinReservar(num);
                                
                            }
                            
                        }
                    }
                }
            }
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

        bntBack = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        jblSeat = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bntBack.setText("Back");
        bntBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBackActionPerformed(evt);
            }
        });

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jblSeat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jblSeat.setText("Pick your seat");

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Asiento Disponible");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Asiento Reservado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelect)
                .addGap(99, 99, 99)
                .addComponent(bntBack)
                .addGap(30, 30, 30))
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jblSeat)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jblSeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntBack)
                    .addComponent(btnSelect))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBackActionPerformed
        Option option = new Option();
        option.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bntBackActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
    
    }//GEN-LAST:event_btnSelectActionPerformed

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
            java.util.logging.Logger.getLogger(RoomUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBack;
    private javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jblSeat;
    private javax.swing.JPanel pnlBotones;
    // End of variables declaration//GEN-END:variables
}
