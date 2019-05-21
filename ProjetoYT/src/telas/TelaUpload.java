/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import db.VideoDAO;

/**
 *
 * @author Wagner Carestini
 */
public class TelaUpload extends javax.swing.JFrame {

    /**
     * Creates new form TelaUpload
     */
    public TelaUpload() {
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

        jPanel1 = new javax.swing.JPanel();
        btnVoltaLogin = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnUparVideo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(590, 430));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 0, 153));
        jPanel1.setForeground(new java.awt.Color(51, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVoltaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnVoltar.png"))); // NOI18N
        btnVoltaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltaLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 20, 20));

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setForeground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnFechar.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setText("Titulo do video:");
        jLabel1.setToolTipText("Titulo do  video");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("UPLOAD");
        jLabel2.setToolTipText("UPLOAD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, -1));

        btnUparVideo.setText("Pronto");
        btnUparVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUparVideoActionPerformed(evt);
            }
        });
        jPanel1.add(btnUparVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoFundoTransparente.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltaLoginActionPerformed
        // TODO add your handling code here:
        dispose();
        new TelaPrinc().setVisible(true);
    }//GEN-LAST:event_btnVoltaLoginActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnUparVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUparVideoActionPerformed
        // TODO add your handling code here:
        String titulo = txtTitulo.getText();
        VideoDAO.update(titulo);
    }//GEN-LAST:event_btnUparVideoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaUpload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUpload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUpload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUpload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUpload().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUparVideo;
    private javax.swing.JButton btnVoltaLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
