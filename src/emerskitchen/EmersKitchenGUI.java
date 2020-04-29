
package emerskitchen;


public class EmersKitchenGUI extends javax.swing.JFrame {

    /**
     * Creates new form EmersKitchenGUI
     */
    public EmersKitchenGUI() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in the screen
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonCreateOrder = new javax.swing.JButton();
        jButtonFindItem = new javax.swing.JButton();
        jButtonStock = new javax.swing.JButton();
        jButtonSupply = new javax.swing.JButton();
        jButtonStaff = new javax.swing.JButton();
        jButtonProduct = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 187, 201));

        jButtonCreateOrder.setBackground(new java.awt.Color(204, 204, 255));
        jButtonCreateOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCreateOrder.setForeground(new java.awt.Color(0, 0, 153));
        jButtonCreateOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Order-history-icon.png"))); // NOI18N
        jButtonCreateOrder.setText("Create Order");
        jButtonCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateOrderActionPerformed(evt);
            }
        });

        jButtonFindItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonFindItem.setForeground(new java.awt.Color(0, 0, 153));
        jButtonFindItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/img/database-search-icon.png"))); // NOI18N
        jButtonFindItem.setText("Find Item");
        jButtonFindItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindItemActionPerformed(evt);
            }
        });

        jButtonStock.setBackground(new java.awt.Color(204, 204, 255));
        jButtonStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonStock.setForeground(new java.awt.Color(0, 0, 153));
        jButtonStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/img/Box-icon.png"))); // NOI18N
        jButtonStock.setText("Stock-taking");
        jButtonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStockActionPerformed(evt);
            }
        });

        jButtonSupply.setBackground(new java.awt.Color(204, 204, 255));
        jButtonSupply.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSupply.setForeground(new java.awt.Color(0, 0, 153));
        jButtonSupply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/folder-blue-documents-icon.png"))); // NOI18N
        jButtonSupply.setText("Suppliers");
        jButtonSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupplyActionPerformed(evt);
            }
        });

        jButtonStaff.setBackground(new java.awt.Color(204, 204, 255));
        jButtonStaff.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonStaff.setForeground(new java.awt.Color(0, 0, 153));
        jButtonStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/folder-users-icon.png"))); // NOI18N
        jButtonStaff.setText("Users");
        jButtonStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStaffActionPerformed(evt);
            }
        });

        jButtonProduct.setBackground(new java.awt.Color(204, 204, 255));
        jButtonProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonProduct.setForeground(new java.awt.Color(0, 0, 153));
        jButtonProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/folder-blue-documents-icon.png"))); // NOI18N
        jButtonProduct.setText("Products");
        jButtonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductActionPerformed(evt);
            }
        });

        jButtonLogout.setBackground(new java.awt.Color(204, 204, 255));
        jButtonLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Other-Power-Log-Off-Metro-icon.png"))); // NOI18N
        jButtonLogout.setText("Log out");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(162, 187, 201));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/img/download.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("X");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSupply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonFindItem, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonStock, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(jButtonProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonStock, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonFindItem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCreateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateOrderActionPerformed
        OrderGUI in = new OrderGUI();
        in.setVisible(true);
    }//GEN-LAST:event_jButtonCreateOrderActionPerformed

    private void jButtonFindItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindItemActionPerformed
        StockGUI sto = new StockGUI();
        sto.setVisible(true);
    }//GEN-LAST:event_jButtonFindItemActionPerformed

    private void jButtonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStockActionPerformed
        StockGUI sto = new StockGUI();
        sto.setVisible(true);
    }//GEN-LAST:event_jButtonStockActionPerformed

    private void jButtonSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupplyActionPerformed
        SupplierGUI su = new SupplierGUI();
        su.setVisible(true); //to call supply sheet
    }//GEN-LAST:event_jButtonSupplyActionPerformed

    private void jButtonStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStaffActionPerformed
        employeeFormGUI uf = new employeeFormGUI();
        uf.setVisible(true);
    }//GEN-LAST:event_jButtonStaffActionPerformed

    private void jButtonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductActionPerformed
        ProductGUI pro = new ProductGUI();
        pro.setVisible(true); //to call product sheet
    }//GEN-LAST:event_jButtonProductActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed

        LoginGUI lg = new LoginGUI();
        lg.setVisible(true);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(EmersKitchenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmersKitchenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmersKitchenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmersKitchenGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmersKitchenGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateOrder;
    private javax.swing.JButton jButtonFindItem;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonProduct;
    private javax.swing.JButton jButtonStaff;
    private javax.swing.JButton jButtonStock;
    private javax.swing.JButton jButtonSupply;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
