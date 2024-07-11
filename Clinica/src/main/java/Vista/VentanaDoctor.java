package Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author 51934
 */
public class VentanaDoctor extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDoctor
     */
    public VentanaDoctor() {
        initComponents();
        setSize(1250, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarCitaDni = new javax.swing.JButton();
        cajaDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        btnVerHistorialMedico = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEnviarDiagnostico = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnVerDetalles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setText("CITAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 130, -1));

        btnBuscarCitaDni.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnBuscarCitaDni.setText("Buscar");
        jPanel1.add(btnBuscarCitaDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 139, -1, -1));
        jPanel1.add(cajaDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 146, 358, -1));

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Detalle", "Horario", "Turno"
            }
        ));
        jScrollPane1.setViewportView(tablaCitas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 203, 680, 333));

        btnVerHistorialMedico.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        btnVerHistorialMedico.setText("Ver Historial Medico");
        btnVerHistorialMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialMedicoActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerHistorialMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 571, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("Detallar Diagnostico: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(825, 274, 290, 150));

        btnEnviarDiagnostico.setBackground(new java.awt.Color(0, 255, 51));
        btnEnviarDiagnostico.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        btnEnviarDiagnostico.setForeground(new java.awt.Color(0, 0, 0));
        btnEnviarDiagnostico.setText("Guardar Diagnóstico");
        btnEnviarDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarDiagnosticoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviarDiagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 179, 52));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel3.setText("Ingresar DNI: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 101, -1, -1));

        btnVerDetalles.setText("Ver Detalles");
        jPanel1.add(btnVerDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, -1, -1));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerHistorialMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerHistorialMedicoActionPerformed

    private void btnEnviarDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarDiagnosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarDiagnosticoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarCitaDni;
    public javax.swing.JButton btnEnviarDiagnostico;
    public javax.swing.JButton btnVerDetalles;
    private javax.swing.JButton btnVerHistorialMedico;
    public javax.swing.JTextField cajaDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
