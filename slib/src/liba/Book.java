/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kobinath
 */
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Book() {
        initComponents();
        Connect();
        Author();
        Category();
        table_update();
    }
     Connection con;
    PreparedStatement pst;
    
    
public class CategoryItem
{ 
int id; 
String name; 

public CategoryItem( int id, String name ) 
{ 
this.id = id; 
this.name = name; 
} 

public String toString() 
{ 
return name; 
} 
}
      
      
   public class Authoritem
{ 
int id; 
String name; 

public Authoritem( int id, String name ) 
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

        private void Author()
    {

        try {
           
            pst = con.prepareStatement("select * from author");
            ResultSet rs = pst.executeQuery();
            txtauthor.removeAllItems();
            
            while(rs.next())
            {                
                txtauthor.addItem(new Authoritem(rs.getInt(1),rs.getString(2)) );    
            }             
        } 
        catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        private void Category()
    {

        try {
          
            pst = con.prepareStatement("select * from category");
            ResultSet rs = pst.executeQuery();
            txtcat.removeAllItems();
            
            while(rs.next())
            {                
                txtcat.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)) );    
            }             
        }  catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     
    
    
     private void table_update()
    {
       
            int c;
            try {
               
                 //pst = con.prepareStatement("SELECT book.id,book.bookname,c.category,a.name,book.contents,book.nopages,book.edition FROM books book JOIN category c ON book.cat_id = c.id JOIN author a ON book.author_id = a.id");
                 pst=con.prepareStatement("SELECT * from books");
                 ResultSet rs = pst.executeQuery();
                 
                 ResultSetMetaData rsd = rs.getMetaData();
                 c = rsd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector v2 = new Vector(); 
                     for(int i=0; i<=c; i++)
                     {
                         //v2.add(rs.getString("book.id"));
                         //v2.add(rs.getString("book.bookname"));
                         //v2.add(rs.getString("c.category"));
                         //v2.add(rs.getString("a.name"));  
                         //v2.add(rs.getString("book.contents"));  
                         //v2.add(rs.getString("book.nopages"));
                         //v2.add(rs.getString("book.edition"));      
                         v2.add(rs.getString("id"));
                         v2.add(rs.getString("bookname"));
                         v2.add(rs.getString("cat_id"));
                         v2.add(rs.getString("author_id"));  
                         v2.add(rs.getString("contents"));  
                         v2.add(rs.getString("nopages"));
                         v2.add(rs.getString("edition"));
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
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtcontents = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtcat = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtpages = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtpeditor = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(52, 49, 72));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158)), "Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 1, 36), new java.awt.Color(215, 196, 158))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(215, 196, 158));
        jLabel9.setText("Book Name :-");

        txtname.setText("ghfgh");
        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(215, 196, 158));
        jButton1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(52, 49, 72));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(215, 196, 158));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(52, 49, 72));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(215, 196, 158));
        jButton3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(52, 49, 72));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(215, 196, 158));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "BOOK NAME", "CATEGORY", "AUTHOR", "CONTENTS", "NO OF PAGES", "EDITION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jLabel11.setText("Category :-");

        jLabel12.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(215, 196, 158));
        jLabel12.setText("No of Pages :-");

        txtcontents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));

        jLabel13.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(215, 196, 158));
        jLabel13.setText("Author :-");

        txtcat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));

        txtauthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));

        jLabel15.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(215, 196, 158));
        jLabel15.setText("Contents :-");

        txtpages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));

        jLabel16.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(215, 196, 158));
        jLabel16.setText("Edition :-");

        txtpeditor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 196, 158), 3));

        jButton4.setBackground(new java.awt.Color(215, 196, 158));
        jButton4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(52, 49, 72));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtpeditor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcontents, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtauthor, javax.swing.GroupLayout.Alignment.LEADING, 0, 194, Short.MAX_VALUE)
                            .addComponent(txtpages, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton4)
                        .addGap(0, 25, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtauthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtcontents, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtpeditor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name = txtname.getText();       
        String category = txtcat.getSelectedItem().toString();
        String author = txtauthor.getSelectedItem().toString();
        String contents = txtcontents.getText();
        String pages = txtpages.getText();
        String editor = txtpeditor.getText();


        try {
            pst = con.prepareStatement("insert into books(bookname,cat_id,author_id,contents,nopages,edition)values(?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setString(3, author);
            pst.setString(4, contents);
            pst.setString(5, pages);
            pst.setString(6, editor);
          
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Book Adddeddd Successfully!!!!!!!!!!!!!!!");
             table_update();
            txtname.setText("");
            txtcat.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtpeditor.setText("");
        
            txtname.requestFocus();
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
         
        
        
        
      

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String name = txtname.getText();
        String citem = txtcat.getSelectedItem().toString();       
        String author = txtauthor.getSelectedItem().toString();
        String content = txtcontents.getText();
        String pages = txtpages.getText();
        String edition = txtpeditor.getText();
        try {
           
            pst = con.prepareStatement("update books set bookname=?,cat_id=?,author_id=?,contents=?,nopages=?,edition=? where id= ?");
            
            pst.setString(1, name);
            pst.setString(2,citem);
            pst.setString(3, author);
            pst.setString(4, content);
            pst.setString(5, pages);
            pst.setString(6, edition);
            pst.setInt(7, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Books Updateddd");
            table_update();
            
            txtname.setText("");
            txtcat.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtpeditor.setText("");
            txtname.requestFocus();

        } 
        catch (SQLException ex) {
            Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record","Warning",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION)
        {
          
            try {
                pst = con.prepareStatement("delete from books where id =?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Book Deletedd");
                table_update();
            txtname.setText("");
            txtcat.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtcontents.setText("");
            txtpages.setText("");
            txtpeditor.setText("");
            txtname.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
            }
              

         

        }


       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        

        txtname.setText(d1.getValueAt(selectIndex, 1).toString());     
        txtcat.setSelectedItem(d1.getValueAt(selectIndex,2).toString());
        txtauthor.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
        txtcontents.setText(d1.getValueAt(selectIndex, 4).toString());
        txtpages.setText(d1.getValueAt(selectIndex, 5).toString());
        txtpeditor.setText(d1.getValueAt(selectIndex, 6).toString());

      

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcat;
    private javax.swing.JTextField txtcontents;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpages;
    private javax.swing.JTextField txtpeditor;
    // End of variables declaration//GEN-END:variables
}
