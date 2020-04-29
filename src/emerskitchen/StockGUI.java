package emerskitchen;

import emerskitchen.App.StockApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StockGUI extends javax.swing.JFrame {

    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String USER = "root";
    String PASSWORD = " ";
    String URL = "jdbc:mysql://localhost:3306/emers_db";
    //had problems and the db was asking for timezone
    String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    String ProdCode = "";
    String ProdName = "";
    String Category = "";
    String StockDate = "";
    String Qtity = "";
    String StockCode;
    Connection con;
    DefaultTableModel model;

    public StockGUI() {

        initComponents();
        this.setLocationRelativeTo(null); // center form in the screen
        con = databaseConnection();
        populateJTable();//populateing jTable
    }

    public Connection databaseConnection() {
        Connection con;

        try {
            //load driver
            Class.forName(DRIVER);
            JOptionPane.showMessageDialog(null, "Loaded");
            //connect to db
            con = DriverManager.getConnection(URL + timeZone, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Connected");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //store db results in arraylist
    public ArrayList<StockApp> stockList() {
        ArrayList<StockApp> stockList = new ArrayList<StockApp>();
        //SQL
        String sql = "SELECT * FROM stock.emers_db";
        Statement st;
        ResultSet rs;
        StockApp stockApp = new StockApp();
        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            //loop the results
            while (rs.next()) {
                //populate stockapp setters
                stockApp.setStockCode(rs.getInt("stid"));
                stockApp.setProdName(rs.getString("prodname"));
                stockApp.setCategory(rs.getString("category"));
                stockApp.setQtity(rs.getString("quantity_in_stock"));
                stockApp.setStockDate(rs.getString("date"));
                stockApp.setProdCode(rs.getString(""));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockList;
    }

    //populate jTable from db
    public void populateJTable() {
        ArrayList<StockApp> dataArray = stockList();
        model = (DefaultTableModel) jTableStock.getModel();

        Object[] row = new Object[6];
        //loop through arraylist to populate jTable
        for (int i = 0; i < dataArray.size(); i++) {
            row[0] = dataArray.get(i).getProdCode();
            row[1] = dataArray.get(i).getProdName();
            row[2] = dataArray.get(i).getCategory();
            row[3] = dataArray.get(i).getStockDate();
            row[4] = dataArray.get(i).getQtity();
            row[5] = dataArray.get(i).getStockCode();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        MoscowPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("MoscowPU").createEntityManager();
        stockQuery = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT s FROM Stock s");
        stockList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : stockQuery.getResultList();
        productQuery = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT p FROM Product p");
        productList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productQuery.getResultList();
        stockQuery1 = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT s FROM Stock s");
        stockList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : stockQuery1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jTextFieldStockcd = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        searchdata = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        dateChooser = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox<>();
        jButtonClean = new javax.swing.JButton();
        qtity = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(162, 187, 201));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(162, 187, 201));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Stock taking date:");

        jLabel2.setBackground(new java.awt.Color(162, 187, 201));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Stock code:");

        jLabel5.setBackground(new java.awt.Color(162, 187, 201));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("ID:");

        jLabel6.setBackground(new java.awt.Color(162, 187, 201));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity in stock:");

        jTextFieldStockcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStockcdActionPerformed(evt);
            }
        });

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Add-icon.png"))); // NOI18N
        jButtonAdd.setText("Add ");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Misc-Upload-Database-icon.png"))); // NOI18N
        jButtonUpload.setText("Upload");
        jButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        jButtonRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Delete-icon.png"))); // NOI18N
        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Other-Power-Log-Off-Metro-icon.png"))); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        searchdata.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdataKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("X");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("-");

        jButtonSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Misc-Upload-Database-icon.png"))); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(162, 187, 201));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name:");

        jLabel10.setBackground(new java.awt.Color(162, 187, 201));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Category:");

        jComboBoxCategory.setBackground(new java.awt.Color(168, 187, 201));
        jComboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cafe", "Kitchen" }));

        jButtonClean.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Actions-edit-clear-icon.png"))); // NOI18N
        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel9)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchdata)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldStockcd)
                            .addComponent(Date)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextFieldName)
                            .addComponent(jTextFieldCode)
                            .addComponent(jComboBoxCategory, 0, 102, Short.MAX_VALUE)
                            .addComponent(qtity, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRemove)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(qtity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStockcd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );

        jTableProduct.setBackground(new java.awt.Color(162, 187, 201));
        jTableProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        jTableProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productList, jTableProduct);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodCode}"));
        columnBinding.setColumnName("Prod Code");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodName}"));
        columnBinding.setColumnName("Prod Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supId}"));
        columnBinding.setColumnName("Sup Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTableProduct);

        jTableStock.setBackground(new java.awt.Color(162, 187, 201));
        jTableStock.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        jTableStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Category", "Date", "Quantity", "Stock code"
            }
        ));
        jTableStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStockMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableStock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldStockcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStockcdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStockcdActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        ProdCode = jTextFieldCode.getText();
        ProdName = jTextFieldName.getText();
        Category = jComboBoxCategory.getSelectedItem().toString();
        StockDate = Date.getText();
        Qtity = Date.getText();
        StockCode = jTextFieldStockcd.getText();
//        StockCode = Integer.parseInt(jTextFieldStockcd.getText());

        if (Qtity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Check if all fields are filled");
        } else {
            try {
                //SQL
                String sql = "INSERT INTO stock (stock_name, stock_price_gross, stock_price_shop, delivery_date, prod_qtity, sup_id) VALUE (?, ?, ?, ?, ?, ?)";
                //Connection
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "");
                //statement
                PreparedStatement ps = this.con.prepareStatement(sql);
                ps.setString(1, ProdCode);
                ps.setString(2, ProdName);
                ps.setString(3, Category);
                ps.setString(4, StockDate);
                ps.setString(5, Qtity);
                ps.setString(6, StockCode);

                int dataInserted = ps.executeUpdate();
                if (dataInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Inserted successfully");
                    clearFields();
                    populateJTable();//refresh jTable after add
                }

            } catch (SQLException e) {
                e.printStackTrace();//to handle exceptions and errors.
            }

        }


    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed
        ProdCode = jTextFieldCode.getText();
        ProdName = jTextFieldName.getText();
        Category = jComboBoxCategory.getSelectedItem().toString();
        StockDate = Date.getText();
        Qtity = Date.getText();
        StockCode = jTextFieldStockcd.getText();

        if (Qtity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Check if all fields are filled");
        } else {
            try {
                //SQL
                String sql = "UPDATE stock SET stock_name=? stock_code=? stock_taking_date=?, category=?, qtity=? WHERE stock_id=?";
                //Connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "");
                //statement
                PreparedStatement ps = this.con.prepareStatement(sql);
                ps.setString(1, ProdCode);
                ps.setString(2, ProdName);
                ps.setString(3, Category);
                ps.setString(4, StockDate);
                ps.setString(5, Qtity);
                ps.setInt(6, Integer.parseInt(StockCode));
                
                int dataInserted = ps.executeUpdate();
                if (dataInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Updated successfully");
                    clearFields();//cleaning the fields
                    populateJTable();//refresh jTable aff add
                    ps.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();//to handle exceptions and errors.
            }
            
            
            
        }
    }//GEN-LAST:event_jButtonUploadActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        //delete from db
        Connection conn = null;
        PreparedStatement ps = null;
        if (jTextFieldStockcd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID is empty");
        } else {
            //SQL
            String sql = "DELETE FROM stock WHERE stock_code = ?";

            try {
                conn = this.con;
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(jTextFieldStockcd.getText()));
                int delete = ps.executeUpdate();
                if (delete > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    //clear all the fields
                    clearFields();
                    //reflesh jTable
                    populateJTable();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally { //to close connection
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    
                } catch (SQLException ex) {
                    ex.getMessage();
                }
            }
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        //        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void searchdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdataKeyReleased

    }//GEN-LAST:event_searchdataKeyReleased

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        //write the code to save data in the db????

        OrderGUI in = new OrderGUI();
        in.setVisible(true);
//        .setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        //to clean jTextField

        clearFields();

    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jTableStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStockMouseClicked
        //display selected row
        int jTableSelectedRow = jTableStock.getSelectedRow();
        selectRow(jTableSelectedRow);


    }//GEN-LAST:event_jTableStockMouseClicked

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
            java.util.logging.Logger.getLogger(StockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockGUI().setVisible(true);
            }
        });
    }

    private void clearFields() {

        jTextFieldCode.setText("");
        jTextFieldName.setText("");
        Date.setText("");
        jTextFieldStockcd.setText("");
        jComboBoxCategory.setSelectedIndex(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.persistence.EntityManager MoscowPUEntityManager;
    private datechooser.beans.DateChooserCombo dateChooser;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableStock;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldStockcd;
    private java.util.List<emerskitchen.Product> productList;
    private javax.persistence.Query productQuery;
    private javax.swing.JTextField qtity;
    private javax.swing.JTextField searchdata;
    private java.util.List<emerskitchen.Stock> stockList;
    private java.util.List<emerskitchen.Stock> stockList1;
    private javax.persistence.Query stockQuery;
    private javax.persistence.Query stockQuery1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void selectRow(int counter) {

        jTextFieldCode.setText(stockList().get(counter).getProdCode());
        jTextFieldName.setText(stockList().get(counter).getProdName());

        String category = stockList().get(counter).getCategory();
        for (int c = 0; c < jComboBoxCategory.getItemCount(); c++) {
            jComboBoxCategory.setSelectedIndex(c);
        }

        Date.setText(stockList().get(counter).getStockDate());
        qtity.setText(stockList().get(counter).getQtity());
        jTextFieldStockcd.setText(Integer.toString(stockList().get(counter).getStockCode()));
    }

}
