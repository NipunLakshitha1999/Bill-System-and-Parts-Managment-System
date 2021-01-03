/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.view;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.MyProject.Controller.ItemDetail;
import lk.ijse.MyProject.Model.ItemModel;

/**
 *
 * @author Nipun Lakshitha
 */
public class NewItem extends javax.swing.JFrame {

    /**
     * Creates new form NewItem
     */
    public NewItem() {
        initComponents();
        LoadAllItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newItem = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtItemCode1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtItemName1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtItemPrice1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQTYOnHand1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newItem.setBackground(new java.awt.Color(106, 137, 204));
        newItem.setPreferredSize(new java.awt.Dimension(1061, 587));
        newItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Item Code");
        newItem.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txtItemCode1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemCode1KeyPressed(evt);
            }
        });
        newItem.add(txtItemCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Item Name");
        newItem.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtItemName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemName1KeyPressed(evt);
            }
        });
        newItem.add(txtItemName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 200, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Selling Price");
        newItem.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        txtItemPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemPrice1KeyPressed(evt);
            }
        });
        newItem.add(txtItemPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 200, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("QTY On Hand");
        newItem.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        txtQTYOnHand1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQTYOnHand1KeyPressed(evt);
            }
        });
        newItem.add(txtQTYOnHand1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 200, -1));

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemCode", "Item Name", "UnitPrice", "QTY On Hand"
            }
        ));
        ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ItemTable);

        newItem.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 790, 140));

        btnSave.setBackground(new java.awt.Color(130, 204, 221));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(130, 204, 221)));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        newItem.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 80, 40));

        jButton2.setBackground(new java.awt.Color(96, 163, 188));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        newItem.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, 40));

        jButton3.setBackground(new java.awt.Color(60, 99, 130));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(60, 99, 130)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        newItem.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, 81, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        newItem.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 41, -1, -1));

        jButton1.setBackground(new java.awt.Color(56, 173, 169));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(56, 173, 169)));
        newItem.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 81, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Desktop\\wp4043155.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        newItem.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1060, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemPrice1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemPrice1KeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtItemPrice1.setEditable(false);
        } else {
            txtItemPrice1.setEditable(true);
        }
    }//GEN-LAST:event_txtItemPrice1KeyPressed

    private void txtQTYOnHand1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTYOnHand1KeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtQTYOnHand1.setEditable(false);
        } else {
            txtQTYOnHand1.setEditable(true);
        }
    }//GEN-LAST:event_txtQTYOnHand1KeyPressed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        int rowIndex = ItemTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        txtItemCode1.setText(model.getValueAt(rowIndex, 0).toString());
        txtItemName1.setText(model.getValueAt(rowIndex, 1).toString());
        txtItemPrice1.setText(model.getValueAt(rowIndex, 2).toString());
        txtQTYOnHand1.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_ItemTableMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (txtItemCode1.getText().trim().length() > 0 && txtItemName1.getText().length() > 0 && txtItemPrice1.getText().length() > 0 && txtQTYOnHand1.getText().length() > 0) {
            String itemCode = txtItemCode1.getText();
            String itemName = txtItemName1.getText();
            double unitPrice = Double.parseDouble(txtItemPrice1.getText());

            boolean detail = false;
            int qty = Integer.parseInt(txtQTYOnHand1.getText());

            //detail = new ItemDetail().AddItem(new Item(itemCode, itemName, unitPrice, qty));
            detail = new ItemDetail().AddItem(new ItemModel(itemCode, itemName, unitPrice, qty));
            if (detail == true) {
                JOptionPane.showMessageDialog(rootPane, "Success");
            } else {
                JOptionPane.showMessageDialog(rootPane, "try");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
        LoadAllItem();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtItemCode1.getText().trim().length() > 0) {
            String itemCode = txtItemCode1.getText();
            String itemName = txtItemName1.getText();
            double unitPrice = Double.parseDouble(txtItemPrice1.getText());
            int qty = Integer.parseInt(txtQTYOnHand1.getText());

            boolean update = false;
            update = new ItemDetail().UpdateItem(new ItemModel(itemCode, itemName, unitPrice, qty));

            if (update == true) {
                JOptionPane.showMessageDialog(rootPane, "Update");
            } else {
                JOptionPane.showMessageDialog(rootPane, "try");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT ITEM ID");
        }
        LoadAllItem();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (txtItemCode1.getText().trim().length() > 0) {
            String itemCode = txtItemCode1.getText();

            boolean delete = new ItemDetail().DeleteItem(itemCode);

            if (delete == true) {
                JOptionPane.showMessageDialog(rootPane, "Deleted");
            } else {
                JOptionPane.showMessageDialog(rootPane, "try");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT ITEM ID");
        }
        LoadAllItem();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        for (ItemModel s : new ItemDetail().SearchItem(txtItemName1.getText())) {
            txtItemCode1.setText(s.getCode());
            txtItemPrice1.setText(Double.toString(s.getUnitPrice()));
            txtQTYOnHand1.setText(Integer.toString(s.getQTYOnHand()));
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtItemCode1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemCode1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtItemName1.requestFocus();
        }
    }//GEN-LAST:event_txtItemCode1KeyPressed

    private void txtItemName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemName1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        txtItemPrice1.requestFocus();
        }

    }//GEN-LAST:event_txtItemName1KeyPressed

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
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel newItem;
    private javax.swing.JTextField txtItemCode1;
    private javax.swing.JTextField txtItemName1;
    private javax.swing.JTextField txtItemPrice1;
    private javax.swing.JTextField txtQTYOnHand1;
    // End of variables declaration//GEN-END:variables

    private void LoadAllItem() {
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        model.setRowCount(0);
        for (ItemModel item : new ItemDetail().getAllItem()) {
            model.addRow(new Object[]{
                item.getCode(),
                item.getName(),
                item.getUnitPrice(),
                item.getQTYOnHand()
            });
        }
    }
}
