package emerskitchen;

import emerskitchen.App.ProductApp;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ProductGUI extends javax.swing.JFrame {

    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String USER = "root";
    String PASSWORD = " ";
    String URL = "jdbc:mysql://localhost:3308/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel model;

    String ProdCode, ProdName, DeliDate, qtity, sup = "";
    double priceGross, priceShop = 0;

    public ProductGUI() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in the screen
        con = databaseConnection();
        populateJTable();
    }
    
     public Connection databaseConnection() {
        Connection con;

        try {
            //load driver
            Class.forName(DRIVER);
            JOptionPane.showMessageDialog(null, "Loaded");
            //connect to db
            con = DriverManager.getConnection(URL, USER, PASSWORD);
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
    public ArrayList<ProductApp> prodList() {
        ArrayList<ProductApp> prodList = new ArrayList<ProductApp>();
        //SQL
        String sql = "SELECT * FROM emers_db";
        Statement st;
        ResultSet rs;
        ProductApp prodApp = new ProductApp();
        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            //loop the results
            while (rs.next()) {
                //populate stockapp setters

                prodApp.setCode(rs.getInt("prodCode"));
                prodApp.setName(rs.getString("ProdName"));
                prodApp.setGross(rs.getDouble("pgross"));
                prodApp.setShop(rs.getDouble("pshop"));
                prodApp.setDate(rs.getString("date"));
                prodApp.setQtity(rs.getString("qtity"));
                prodApp.setSup(rs.getString("sup"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prodList;
    }

    //populate jTable from db
    public void populateJTable() {
        ArrayList<ProductApp> dataArray = prodList();
        model = (DefaultTableModel) jTableProduct.getModel();

        Object[] row = new Object[6];
        //loop through arraylist to populate jTable
        for (int i = 0; i < dataArray.size(); i++) {
            row[0] = dataArray.get(i).getCode();
            row[1] = dataArray.get(i).getName();
            row[2] = dataArray.get(i).getGross();
            row[3] = dataArray.get(i).getShop();
            row[4] = dataArray.get(i).getDate();
            row[5] = dataArray.get(i).getQtity();
            row[6] = dataArray.get(i).getSup();

            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        MoscowPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("MoscowPU").createEntityManager();
        productQuery = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT p FROM Product p");
        productList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : productQuery.getResultList();
        suppliersQuery = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT s FROM Suppliers s");
        suppliersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suppliersQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextProduct = new javax.swing.JTextField();
        jTextFieldGross = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldShop = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextSupplier = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dateChooser = new datechooser.beans.DateChooserCombo();
        jTextFieldQtity = new javax.swing.JTextField();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSupplier = new javax.swing.JTable();
        jTextDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(168, 187, 201));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data for Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Prod. Price (Shop):");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Prod. Price (Gross):");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("ID:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Quantity:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(new java.awt.Color(168, 187, 201));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableProduct.setBackground(new java.awt.Color(162, 187, 201));
        jTableProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productList, jTableProduct);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodCode}"));
        columnBinding.setColumnName("Prod Code");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodName}"));
        columnBinding.setColumnName("Prod Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodPriceGross}"));
        columnBinding.setColumnName("Prod Price Gross");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodPriceShop}"));
        columnBinding.setColumnName("Prod Price Shop");
        columnBinding.setColumnClass(java.math.BigDecimal.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${deliveryDate}"));
        columnBinding.setColumnName("Delivery Date");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${prodQtity}"));
        columnBinding.setColumnName("Prod Qtity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supId}"));
        columnBinding.setColumnName("Sup Id");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProduct);

        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Add-icon.png"))); // NOI18N
        jButtonAdd.setText("Add Supply");
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

        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Delete-icon.png"))); // NOI18N
        jButtonDelete.setText("Remove");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
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

        jButtonClean.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Actions-edit-clear-icon.png"))); // NOI18N
        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdd))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonClean, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUpload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUpload)
                .addGap(13, 13, 13)
                .addComponent(jButtonClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("-");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("X");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Supplier: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Delivery date:");

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });

        jTableSupplier.setBackground(new java.awt.Color(168, 187, 201));
        jTableSupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suppliersList, jTableSupplier);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${supId}"));
        columnBinding.setColumnName("Sup Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${sname}"));
        columnBinding.setColumnName("Sname");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSupplier);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(153, 153, 153))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldShop, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldQtity, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(jTextSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel11)))
                                .addGap(213, 213, 213)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGross, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldShop, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQtity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        ProdCode = jTextFieldCode.getText();
        ProdName = jTextProduct.getText();
        priceGross = Double.parseDouble(jTextFieldGross.getText());
        priceShop = Double.parseDouble(jTextFieldShop.getText());
        DeliDate = dateChooser.getSelectedDate().toString();
        qtity = jTextFieldQtity.getText();
        sup = jTextSupplier.getText();

        if (ProdCode.isEmpty() || ProdName.isEmpty() || qtity.isEmpty() || sup.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Check if all fields are filled");
        } else {
            try {

                //SQL
                String sql = "INSERT INTO product (prod_name, prod_price_gross, prod_price_shop, delivery_date, prod_qtity, sup_id) VALUE (?, ?, ?, ?, ?, ?)";
                //Connection
                
                //statement
                ps = con.prepareStatement(sql);

                ps.setString(1, jTextProduct.getText());

                ps.setDouble(2, priceGross);
                ps.setDouble(3, priceShop);

                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                String date = dt.format(dateChooser.getSelectedDate().getTime());
                ps.setString(4, date);

                ps.setString(5, jTextFieldQtity.getText());
                ps.setString(6, jTextSupplier.getText());

                ps.executeUpdate();

                model = (DefaultTableModel) jTableProduct.getModel();
                model.setRowCount(0);

                con.close();

                JOptionPane.showMessageDialog(null, "Inserted Successfully");

                //clear field
                clearFields();
                populateJTable();//refresh jTable after add

            } catch (SQLException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        //        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
//        try {
//            
//            String sql = "SELECT pid, prod_name FROM product where pid=?, prod_name=?";
//
//            ps = con.prepareStatement(sql);
//
//            ps.setString(1, jTextFieldSearch.getText());
//
//            rs = ps.executeQuery();
//
//            if (rs.next()) {
//                String add1 = rs.getString("pid");
//                jTextFieldCode.setText(add1);
//                String add2 = rs.getString("prod_name");
//                jTextProduct.setText(add2);
//                String add3 = rs.getString("prod_price_gross");
//                jTextFieldGross.setText(add3);
//                String add4 = rs.getString("prod_price_shop");
//                jTextFieldShop.setText(add4);
//                String add5 = rs.getString("delivery_date");
//                dateChooser.setText(add5);
//                String add6 = rs.getString("prod_qtity");
//                jTextFieldQtity.setText(add6);
//                String add7 = rs.getString("sup-id");
//                jTextSupplier.setText(add7);
//
//            }
//
//        } catch (SQLException | HeadlessException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
////        find_product();


    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jTableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSupplierMouseClicked

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "");
            int row = jTableSupplier.getSelectedRow(); // to get selected row
            String tbclick = (jTableSupplier.getModel().getValueAt(row, 0).toString()); // to get jTable1 model
            String sql = "SELECT sname FROM suppliers WHERE sname=?" + tbclick + "";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) { //display data
                String sname = String.valueOf(rs.getString("sname"));
                jTextSupplier.setText(sname);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jTableSupplierMouseClicked

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed
        try {
            
            int row = jTableProduct.getSelectedRow(); // to get selected row
            String tbclick = (jTableProduct.getModel().getValueAt(row, 0).toString()); // to get jTable1 model
            String sql = "UPDATE product SET  prod_name=?, prod_price_gross=?, prod_price_shop=?, delivery_date=?, prod_qtity=? WHERE pid=" + tbclick + "";
            ps = con.prepareStatement(sql);

            ps.setString(1, jTextProduct.getText());
            ps.setString(2, jTextFieldGross.getText());
            ps.setString(3, jTextFieldShop.getText());
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            String date = dt.format(dateChooser.getSelectedDate().getTime());
            ps.setString(4, date);
            ps.setString(5, jTextFieldQtity.getText());
            ps.setString(6, jTextSupplier.getText());
            ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "Updated Successfully");

            //to clean jTextField
            clearFields();
            populateJTable();//refresh jTable after add
            

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButtonUploadActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        //to clean jTextField

    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            String sql = "DELETE FROM product WHERE pid=?";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, jTextFieldCode.getText());
            ps.executeUpdate();

            con.close();

            JOptionPane.showMessageDialog(null, "Deleted Successfully");
            //clear field
            clearFields();
            populateJTable();//refresh jTable after add

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductMouseClicked
        int b = jTableProduct.getSelectedRow();
        selectRow(b);
    }//GEN-LAST:event_jTableProductMouseClicked

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
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductGUI().setVisible(true);
            }
        });
    }

    private void clearFields() {

        jTextFieldCode.setText("");
        jTextProduct.setText("");
        jTextSupplier.setText("");
        jTextFieldGross.setText("");
        jTextFieldShop.setText("");
        jTextFieldQtity.setText("");
        jTextDate.setText("");;
    }
    
    private void selectRow(int counter) {

        jTextFieldCode.setText(Integer.toString(prodList().get(counter).getCode()));
        jTextProduct.setText(prodList().get(counter).getName());
        jTextFieldGross.setText(Double.toString(prodList().get(counter).getGross()));
        jTextFieldShop.setText(Double.toString(prodList().get(counter).getShop()));
        jTextDate.setText(prodList().get(counter).getDate());
        jTextFieldQtity.setText(prodList().get(counter).getQtity());
//        jTextSupplier.setText(prodList().get(counter).getSup);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager MoscowPUEntityManager;
    private datechooser.beans.DateChooserCombo dateChooser;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableSupplier;
    private javax.swing.JTextField jTextDate;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldGross;
    private javax.swing.JTextField jTextFieldQtity;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldShop;
    private javax.swing.JTextField jTextProduct;
    private javax.swing.JTextField jTextSupplier;
    private java.util.List<emerskitchen.Product> productList;
    private javax.persistence.Query productQuery;
    private java.util.List<emerskitchen.Suppliers> suppliersList;
    private javax.persistence.Query suppliersQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    

}
