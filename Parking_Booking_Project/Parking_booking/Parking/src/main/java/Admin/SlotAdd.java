/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ACER
 */
public class SlotAdd extends javax.swing.JFrame {

    /**
     * Creates new form SeatAdd
     */
    public SlotAdd() {
        initComponents();
        Connect();
        this.setLocationRelativeTo(null);
    }
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;

    
   
    
   
    
    public void Connect(){
        //connect vô database của mình, nguồn là mysql còn db tên là carregis (db phải in đậm mới xài được)
      
        String url="jdbc:mysql://localhost:3306/parkingbooking2";
        String user="root";
        String password="12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            } 
            catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (SQLException throwables) {
            throwables.printStackTrace();
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
        txtpark = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtdate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtparkaddress = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(13, 17, 22));

        jPanel1.setBackground(new java.awt.Color(13, 17, 22));

        txtpark.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1111", "2222" }));
        txtpark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtparkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SLOT ADD");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ParkNo");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date");

        jButton2.setBackground(new java.awt.Color(36, 118, 237));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.setBorderPainted(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("G4PARK");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Park Address");

        txtparkaddress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Street A", "Street B" }));
        txtparkaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtparkaddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtpark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtparkaddress, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpark, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtparkaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1))
                                .addGap(39, 39, 39))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        HomePage h1 = new HomePage();
        h1.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        
        
            String parkid = txtpark.getSelectedItem().toString();
            String address = txtparkaddress.getSelectedItem().toString();

            java.util.Date selectedDate = txtdate.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(selectedDate);

            try{
            for (int day = 1; day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++) {
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                java.sql.Date currentDate = new java.sql.Date(calendar.getTimeInMillis());

                
//                && address.equals("Street A")
            if (parkid.equals("1111") && address.equals("Street A")) {
                for (int i = 1; i <= 20; i++) {
                    int slot_id = i;

            try {
                // Start a transaction
                con.setAutoCommit(false);

                // Check if the lot_id already exists in the parking_lot table
                String checkLotIdQuery = "SELECT COUNT(*) FROM parking_lot WHERE lot_id = ?";
                pst = con.prepareStatement(checkLotIdQuery);
                pst.setString(1, parkid);
                ResultSet rs = pst.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    // The lot_id does not exist, so insert a new row into the parking_lot table
                    pst1 = con.prepareStatement("insert into parking_lot(address, lot_id) values(?, ?)");
                    pst1.setString(1, address);
                    pst1.setString(2, parkid);
                    pst1.executeUpdate();
                }

                // Insert the row into the parking_slot table
                pst = con.prepareStatement("insert into parking_slot(slot_id, date, lot_id) values(?, ?, ?)");
                pst.setInt(1, slot_id);
                pst.setDate(2, currentDate);
                pst.setString(3, parkid);
                pst.executeUpdate();

                // Commit the transaction
                con.commit();
                
            } catch (SQLException ex) {
                try {
                    // Roll back the transaction in case of any error
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    // Reset the auto-commit mode
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } else if (parkid.equals("2222")&& address.equals("Street B")) {
        for (int i = 21; i <= 40; i++) {
            int slot_id = i;

            try {
                // Start a transaction
                con.setAutoCommit(false);

                // Check if the lot_id already exists in the parking_lot table
                String checkLotIdQuery = "SELECT COUNT(*) FROM parking_lot WHERE lot_id = ?";
                pst = con.prepareStatement(checkLotIdQuery);
                pst.setString(1, parkid);
                ResultSet rs = pst.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    // The lot_id does not exist, so insert a new row into the parking_lot table
                    pst1 = con.prepareStatement("insert into parking_lot(address, lot_id) values(?, ?)");
                    pst1.setString(1, address);
                    pst1.setString(2, parkid);
                    pst1.executeUpdate();
                }

                // Insert the row into the parking_slot table
                pst = con.prepareStatement("insert into parking_slot(slot_id, date, lot_id) values(?, ?, ?)");
                pst.setInt(1, slot_id);
                pst.setDate(2, currentDate);
                pst.setString(3, parkid);
                pst.executeUpdate();

                // Commit the transaction
                con.commit();
            } catch (SQLException ex) {
                try {
                    // Roll back the transaction in case of any error
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    // Reset the auto-commit mode
                    con.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SlotAdd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    } 
            JOptionPane.showMessageDialog(rootPane, "Slot added");
            } catch (Exception e){
                JOptionPane.showMessageDialog(rootPane, "Error");
            }           
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtparkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtparkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparkActionPerformed

    private void txtparkaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtparkaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtparkaddressActionPerformed

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
            java.util.logging.Logger.getLogger(SlotAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SlotAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SlotAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SlotAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SlotAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox<String> txtpark;
    private javax.swing.JComboBox<String> txtparkaddress;
    // End of variables declaration//GEN-END:variables
}
