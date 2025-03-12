/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liba;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kobinath
 */
public class Lend extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Lend() {
        initComponents();
        Connect();
        Book();      
        table_update();
    }
     Connection con;
    PreparedStatement pst;
    
    
      public class BookItem 
{ 
int id; 
String name; 

public BookItem( int id, String name ) 
{ 
this.id = id; 
this.name = name; 
} 

public String toString() 
{ 
return name; 
} 
}
      
      

   
   

   
   
   
   
   
   
    
    
    @SuppressWarnings("unchecked")
    
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/slibr","root","");
        } catch (ClassNotFoundException ex) {
            
        } catch (SQLException ex) {
            
        }
           
        
    }
    
       
    
        private void Book()
    {

        try {
          
            pst = con.prepareStatement("select * from books");
            ResultSet rs = pst.executeQuery();
            txtbook.removeAllItems();
            
            while(rs.next())
            {                
                txtbook.addItem(new BookItem(rs.getInt(1),rs.getString(2)) );    
            }             
        }  catch (SQLException ex) {
            Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
  
    
    
     private void table_update()
    {
       
            int c;
            try {
               
                 pst = con.prepareStatement("SELECT l.id,m.name,b.bookname,l.issuedate,l.returndate FROM lend l JOIN member m ON l.memberid = m.id JOIN books b ON b.id = l.bookid ");
                 ResultSet rs = pst.executeQuery();
                 
                 ResultSetMetaData rsd = rs.getMetaData();
                 c = rsd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector v2 = new Vector(); 
                     for(int i=1; i<=c; i++)
                     {
                         v2.add(rs.getString("l.id"));
                         v2.add(rs.getString("m.name"));
                         v2.add(rs.getString("b.bookname"));
                         v2.add(rs.getString("l.issuedate"));  
                         v2.add(rs.getString("l.returndate"));
                         
                     }             
                     d.addRow(v2);
                     
                 }
        } catch (SQLException ex) {
            Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtbook = new javax.swing.JComboBox();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txttdate = new com.toedter.calendar.JDateChooser();
        txtrdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(52, 49, 72));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Issue Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 36), new java.awt.Color(215, 196, 158))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(14, 198, 153));

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(215, 196, 158));
        jLabel9.setText("Member ID :-");

        jTable1.setBackground(new java.awt.Color(215, 196, 158));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MEMBER NAME", "BOOK", "ISSUE DATE", "RETURN DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(215, 196, 158));
        jLabel11.setText("Book :-");

        jLabel13.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(215, 196, 158));
        jLabel13.setText("Date :-");

        jLabel14.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(215, 196, 158));
        jLabel14.setText("Return :-");

        txtbook.setBackground(new java.awt.Color(215, 196, 158));
        txtbook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 198, 153), 0));
        txtbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookActionPerformed(evt);
            }
        });

        txtid.setBackground(new java.awt.Color(215, 196, 158));
        txtid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 198, 153), 0));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        txtname.setBackground(new java.awt.Color(215, 196, 158));
        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 198, 153), 0));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(215, 196, 158));
        jLabel10.setText("Member Name :-");

        jButton4.setBackground(new java.awt.Color(215, 196, 158));
        jButton4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(52, 49, 72));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(215, 196, 158));
        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(52, 49, 72));
        jButton1.setText("Issue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtid)
                    .addComponent(txtname)
                    .addComponent(txtbook, 0, 194, Short.MAX_VALUE)
                    .addComponent(txttdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtrdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jButton4)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(154, 154, 154))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(txtbook))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txttdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(237, 237, 237))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

            String id = txtid.getText();

            try {
                pst = con.prepareStatement("select * from member where id=?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"Member ID not Found");
                }
                else
                {
                    String productname = rs.getString("name");

                    txtname.setText(productname.trim());

                }
            } catch (SQLException ex) {
                Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_txtidKeyPressed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtidActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = txtid.getText();
        
        BookItem  book = (BookItem) txtbook.getSelectedItem();

         SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
         String date = Date_Format.format(txttdate.getDate());
          
          SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
          String date1 = Date_Format1.format(txtrdate.getDate());
       

        try {
            pst = con.prepareStatement("insert into lend(memberid,bookid,issuedate,returndate)values(?,?,?,?)");
            pst.setString(1, id);
            pst.setInt(2, book.id);
            pst.setString(3, date);
            pst.setString(4,date1);
          

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Book ISSUED");
            table_update();
            txtid.setText("");
            txtbook.setSelectedIndex(-1);
            txtname.setText("");
            txtid.requestFocus();
            
            table_update();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbookActionPerformed

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
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private com.toedter.calendar.JDateChooser txtrdate;
    private com.toedter.calendar.JDateChooser txttdate;
    // End of variables declaration//GEN-END:variables
}
