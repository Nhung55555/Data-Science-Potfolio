/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Admin;

import Home.BookingForUser;
import static java.lang.String.format;
import java.math.BigDecimal;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Date;
import static java.text.MessageFormat.format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGUYEN LIN
 */
public class BookingForAdmin extends javax.swing.JFrame {
    private String username;
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }

    /**
     * Creates new form Booking
     */
    public BookingForAdmin() {
        initComponents();
        Connect();
        this.setLocationRelativeTo(null);
    }
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    
    ResultSet rs;
    
    
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
    
//To modify your code so that it displays slots from the selected txtdchooser date to the txtddchooser due date when the "Show" button is clicked, you need to update the Load() method to use both dates for querying the database. Here's how you can do it:


    public void Load() {
    try {

//pst = con.prepareStatement("SELECT seat.parkno, seat.seats, seat.status, parkbook.carnum, parkbook.mobile, ? AS date, ? AS due_date "
//                + "FROM seat LEFT JOIN parkbook ON seat.parkno = parkbook.parkno AND seat.seats = parkbook.seat AND seat.date = parkbook.date "
//                + "WHERE seat.date BETWEEN ? AND ? AND seat.status = 'Available' "
//                + "AND NOT EXISTS (SELECT 1 FROM parkbook "
//                + "WHERE seat.parkno = parkbook.parkno AND seat.seats = parkbook.seat AND parkbook.date BETWEEN ? AND ?) "
//                + "GROUP BY seat.parkno, seat.seats, seat.status, parkbook.carnum, parkbook.mobile;");


//seat là parking_slot (chỉ có date thui) còn reservation nó là parkbook ( có cả date và due_ date)

           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            java.util.Date fromDate = txtdchooser.getDate();
            java.util.Date dueDate = txtddchooser.getDate();
            
            
//            pst = con.prepareStatement("SELECT parking_slot.slot_id, parking_slot.lot_id, parking_slot.status, reservation.vehicle_num, reservation.price, ? AS date, ? AS due_date "
//                    + "FROM parking_slot LEFT JOIN reservation ON parking_slot.slot_id = reservation.slot_id AND parking_slot.date = reservation.date "
//                    + "WHERE parking_slot.date BETWEEN ? AND ? AND parking_slot.status = 'Available' "
//                    + "AND NOT EXISTS (SELECT 1 FROM reservation "
//                    + "WHERE reservation.slot_id = parking_slot.slot_id AND reservation.date BETWEEN ? AND ?) "
//                    + "group by parking_slot.slot_id, parking_slot.lot_id, parking_slot.status, reservation.vehicle_num, reservation.price");


//            pst.setDate(1, new java.sql.Date(fromDate.getTime()));
//            pst.setDate(2, new java.sql.Date(dueDate.getTime()));
//            pst.setDate(3, new java.sql.Date(fromDate.getTime()));
//            pst.setDate(4, new java.sql.Date(dueDate.getTime()));
//            pst.setDate(5, new java.sql.Date(fromDate.getTime()));
//            pst.setDate(6, new java.sql.Date(dueDate.getTime()));
            pst = con.prepareStatement("SELECT parking_slot.slot_id, parking_slot.lot_id, parking_slot.status, reservation.vehicle_num, reservation.price, ? AS date, ? AS due_date "
        + "FROM parking_slot LEFT JOIN reservation ON parking_slot.slot_id = reservation.slot_id AND parking_slot.date = reservation.date "
        + "WHERE parking_slot.date BETWEEN ? AND ? AND parking_slot.status = 'Available' "
        + "AND NOT EXISTS (SELECT 1 FROM reservation "
        + "WHERE reservation.slot_id = parking_slot.slot_id AND reservation.date BETWEEN ? AND ?) "
        + "AND ? <> ? "
        + "group by parking_slot.slot_id, parking_slot.lot_id, parking_slot.status, reservation.vehicle_num, reservation.price");

        pst.setDate(1, new java.sql.Date(fromDate.getTime()));
        pst.setDate(2, new java.sql.Date(dueDate.getTime()));
        pst.setDate(3, new java.sql.Date(fromDate.getTime()));
        pst.setDate(4, new java.sql.Date(dueDate.getTime()));
        pst.setDate(5, new java.sql.Date(fromDate.getTime()));
        pst.setDate(6, new java.sql.Date(dueDate.getTime()));
        pst.setDate(7, new java.sql.Date(fromDate.getTime()));
        pst.setDate(8, new java.sql.Date(dueDate.getTime()));




        if (fromDate.equals(dueDate)) {
    // Display an error message or handle the case where fromDate and dueDate are the same
            JOptionPane.showMessageDialog(rootPane, "From date and due date cannot be the same.");
            return;
        }

            rs = pst.executeQuery();

            DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                    Vector v2 = new Vector();
                v2.add(rs.getString("slot_id"));
                v2.add(rs.getString("lot_id"));
                v2.add(rs.getString("status"));
               v2.add(format.format(fromDate)); // Add formatted fromDate
                v2.add(format.format(dueDate)); 
                d.addRow(v2);
            }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(BookingForAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtveno = new javax.swing.JTextField();
        txtlotno = new javax.swing.JTextField();
        txtsno = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtddate = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtdchooser = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtddchooser = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(13, 17, 22));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(13, 17, 22));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Start Date");

        jLabel3.setBackground(new java.awt.Color(13, 17, 22));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lot No");

        jLabel4.setBackground(new java.awt.Color(13, 17, 22));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vehicle No.");

        jLabel5.setBackground(new java.awt.Color(13, 17, 22));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Slot No");

        txtveno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvenoActionPerformed(evt);
            }
        });

        txtlotno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlotnoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(36, 118, 237));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(13, 17, 22));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Booking For Admin");

        jLabel9.setBackground(new java.awt.Color(13, 17, 22));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Due Date");

        txtddate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtddateActionPerformed(evt);
            }
        });

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addComponent(jLabel1))
                        .addGap(50, 50, 50)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtddate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtveno)
                        .addComponent(txtsno)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtlotno, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 89, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtveno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
        );

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("From:");

        jButton3.setText("Show");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "slot_id", "lot_id", "status", "date", "due_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("To:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdchooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtddchooser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton3)
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(txtddchooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(txtdchooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Load();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        int role=1;
//        int x=0;
//        try{
//            String sql = "SELECT * FROM customer WHERE role =?";
//            pst = con.prepareCall(sql);           
//            pst.setInt(1,role);           
//            rs = pst.executeQuery();
//      
//        if(rs.next()){
//           this.hide();
//           if(role ==1){
               this.hide();
               HomePage home = new HomePage();
               home.setUsername(username);
               home.show();
//           }else if(role==x){
////               this.hide();
//               BookingForUser boo = new BookingForUser();
//                boo.setUsername(username);
//                boo.show();
//           } 
//           else{
//                JOptionPane.showMessageDialog(rootPane, "Error");
//           }
//        }
//
//        } catch (Exception e){
//            JOptionPane.showMessageDialog(rootPane, "Error");
//        }   



//      try {
//    String sql = "SELECT * FROM customer WHERE role = ?";
//    pst = con.prepareStatement(sql);
//    pst.setInt(1, 0);
//    rs = pst.executeQuery();
//
//    if (rs.next()) {
//        this.hide();
//        int roleFromDB = rs.getInt("role");
//
//        if (roleFromDB == 0) {
//            BookingForUser uspage = new BookingForUser();
//            uspage.setUsername(getUsername());
//            uspage.show();
//        } else if (roleFromDB == 1) {
//            HomePage home = new HomePage();
//            home.setUsername(getUsername());
//            home.show();
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Login failed");
//            this.show();
//        }
//    } else {
//        JOptionPane.showMessageDialog(rootPane, "Login failed");
//        this.show();
//    }
//} catch (Exception e) {
//    JOptionPane.showMessageDialog(rootPane, "Error");
//}



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selected = jTable1.getSelectedRow();
        
        String status = d1.getValueAt(selected, 2).toString();
        
        if(!status.equals("Booked"))
        {
            String lot_id = d1.getValueAt(selected, 1).toString();
            String slot_id = d1.getValueAt(selected, 0).toString();
            String date = d1.getValueAt(selected,3).toString();
            String ddate = d1.getValueAt(selected,4).toString();
            txtlotno.setText(lot_id);
            txtsno.setText(slot_id);
            txtdate.setText(date);
            txtddate.setText(ddate);
            txtprice.setText(callPrice().toString());
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Slot Bokked");
        }
        
    }//GEN-LAST:event_jTable1MouseClicked
    
    public String callPrice(){
            long price = 0;
            try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fromDateStr = format.format(txtdchooser.getDate());
            String dueDateStr = format.format(txtddchooser.getDate());
            
            Date fromDate = new Date(format.parse(fromDateStr).getTime());
            Date dueDate = new Date(format.parse(dueDateStr).getTime());

            long daysDifference = (dueDate.getTime() - fromDate.getTime());
          
            if(daysDifference >0){
                long hours = daysDifference / (60 * 60 * 1000);
                long days = hours / 24;
                price = days * 10;
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            return String.valueOf(price);
            
        }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            
            DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
            int selected = jTable1.getSelectedRow();
            
            String slot_id = d1.getValueAt(selected, 0).toString();
            
            String carnum = txtveno.getText();
            String lot_id = txtlotno.getText();
            String date = txtdate.getText();
            String ddate = txtddate.getText();
            String price = txtprice.getText();
          
            
            pst = con.prepareStatement("insert into reservation(slot_id, vehicle_num, date, username, price, due_date)values(?,?,?,?,?,?)");
            pst.setString(1, slot_id);
            
            pst.setString(2, carnum);
            pst.setString(3, date);
            pst.setString(4, getUsername());
            pst.setString(5, price);
            pst.setString(6,ddate);
            pst.executeUpdate();
//            
            pst1 = con.prepareStatement("update parking_slot set status = 'Booked' where slot_id = ? and lot_id = ? and date BETWEEN ? AND ?" );
//            pst1.setString(1, "Booked");
            pst1.setString(1, slot_id);         
            pst1.setString(2,lot_id);          
            pst1.setString(3,date);
            pst1.setString(4,ddate);

            pst1.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this, "Slot Booked");
            Load();

            txtveno.setText("");
            txtlotno.setText("");
            txtsno.setText("");
            txtdate.setText("");
            txtddate.setText("");
            txtprice.setText("");
////            
        } catch (SQLException ex) {
            Logger.getLogger(BookingForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtvenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvenoActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtddateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtddateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtddateActionPerformed

    private void txtlotnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlotnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlotnoActionPerformed

    

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
            java.util.logging.Logger.getLogger(BookingForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingForAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtdate;
    private com.toedter.calendar.JDateChooser txtdchooser;
    private javax.swing.JTextField txtddate;
    private com.toedter.calendar.JDateChooser txtddchooser;
    private javax.swing.JTextField txtlotno;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsno;
    private javax.swing.JTextField txtveno;
    // End of variables declaration//GEN-END:variables
}
