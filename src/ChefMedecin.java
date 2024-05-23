
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author anischetouane
 */
public class ChefMedecin extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    /**
     * Creates new form ChefMedecin
     */
    public ChefMedecin() {
        initComponents();
        conn = db.connect();

        /*if (conn != null) {
            db.setupDatabase(conn, "database_setup.sql");
        }*/

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);
        update_Table_Reservation();
    }
    void update_Table_Reservation() {
        try {
            String sql = "SELECT numero_reservation, nss, date_reservation, TIME(date_reservation) AS heur, type, service, etat FROM reservation where etat=1";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            this.pst = pstmt;
             rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) reservation_Table.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int numRes = rs.getInt("numero_reservation");
                String nss = rs.getString("nss");
                Date date = rs.getDate("date_reservation");
                String heure = rs.getString("heur");
                heure = heure.substring(0, 5);
                String type = rs.getString("type");
                String service = rs.getString("service");
                int etat = rs.getInt("etat");
                Object[] row = {numRes, nss, date, heure, type, service, etat};

                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        jScrollPane5 = new javax.swing.JScrollPane();
        reservation_Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        NumResText = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        HeureText = new javax.swing.JLabel();
        TypeText = new javax.swing.JLabel();
        ServiceText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        nsstext = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));

        reservation_Table.setForeground(new java.awt.Color(0, 102, 102));
        reservation_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "num_res", "NSS", "Date", "Heure", "Type", "Service", "Etat"
            }
        ));
        reservation_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservation_TableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(reservation_Table);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Select Reservation:");

        jLabel29.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel29.setText("Numero Reservation :");

        NumResText.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        NumResText.setText("0");

        jLabel34.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel34.setText("Date :");

        jLabel33.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel33.setText("Type :");

        jLabel37.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel37.setText("Service :");

        jLabel31.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel31.setText("Heure :");

        jButton1.setText("Choisir medcin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Eras Medium ITC", 0, 20)); // NOI18N
        jLabel35.setText("NSS :");

        nsstext.setText("jLabel2");

        jButton2.setText("Choisir INfermier");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NumResText))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel33)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateText)
                            .addComponent(HeureText)
                            .addComponent(TypeText)
                            .addComponent(ServiceText)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nsstext)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(NumResText))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(nsstext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(dateText))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(HeureText))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(TypeText))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(ServiceText))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservation_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservation_TableMouseClicked
        int row = reservation_Table.getSelectedRow();
        String num_res = reservation_Table.getModel().getValueAt(row, 0).toString();
        String nss = reservation_Table.getModel().getValueAt(row, 1).toString();
        String date = reservation_Table.getModel().getValueAt(row, 2).toString();
        String time = reservation_Table.getModel().getValueAt(row, 3).toString();
        String type = reservation_Table.getModel().getValueAt(row, 4).toString();
        String service = reservation_Table.getModel().getValueAt(row, 5).toString();

        // Set the values in the text fields and combo boxes
        NumResText.setText(num_res);
        nsstext.setText(nss);
        dateText.setText(date);
        HeureText.setText(time);
        ServiceText.setText(service);

        // Set the selected value in the TypeResComboBox
        TypeText.setText(type);
        
    }//GEN-LAST:event_reservation_TableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nss =nsstext.getText();
        Timestamp date= java.sql.Timestamp.valueOf(dateText.getText() + " " + HeureText.getText() + ":00");
        String service = ServiceText.getText();
        EmployeeList emp = new EmployeeList(nss, date, service,1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nss =nsstext.getText();
        Timestamp date= java.sql.Timestamp.valueOf(dateText.getText() + " " + HeureText.getText() + ":00");
        String service = ServiceText.getText();
        EmployeeList emp = new EmployeeList(nss, date, service,2);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ChefMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChefMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChefMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChefMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChefMedecin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeureText;
    private javax.swing.JLabel NumResText;
    private javax.swing.JLabel ServiceText;
    private javax.swing.JLabel TypeText;
    private javax.swing.JLabel dateText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nsstext;
    private javax.swing.JTable reservation_Table;
    // End of variables declaration//GEN-END:variables
}
