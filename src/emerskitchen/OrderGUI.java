package emerskitchen;

import emerskitchen.App.StockApp;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OrderGUI extends javax.swing.JFrame {

    String DRIVER = "com.mysql.cj.jdbc.Driver";
    String USER = "root";
    String PASSWORD = " ";
    String URL = "jdbc:mysql://localhost:3306/emers_db";
    //had problems and the db was asking for timezone
    String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel model;

    String prod, qtity, category, order, orderedby, date = "";

    public OrderGUI() {
        initComponents();
        con = databaseConnection();

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
        String sql = "SELECT * FROM emers_db";
        Statement st;
        ResultSet rs;
        StockApp stockApp = new StockApp();
        try {

            st = con.createStatement();
            rs = st.executeQuery(sql);
            //loop the results
            while (rs.next()) {
                //populate stockapp setters
                stockApp.setStockCode(rs.getInt("stockCode"));
                stockApp.setProdName(rs.getString("ProdName"));
                stockApp.setCategory(rs.getString("category"));
                stockApp.setQtity(rs.getString("qtity"));
                stockApp.setStockDate(rs.getString("date"));
                stockApp.setProdCode(rs.getString("id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockList;
    }

    //populate jTable from db
    public void populateJTable() {
        ArrayList<StockApp> dataArray = stockList();
        model = (DefaultTableModel) jTableCafe.getModel();

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

        MoscowPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("MoscowPU").createEntityManager();
        stockQuery = java.beans.Beans.isDesignTime() ? null : MoscowPUEntityManager.createQuery("SELECT s FROM Stock s");
        stockList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : stockQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jButtonRemove = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jButtonSend = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonPrint = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOrder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldOrdered = new javax.swing.JTextField();
        jTextFieldDate = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldProd = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBoxCategory = new javax.swing.JComboBox<>();
        jTextFieldQtity = new javax.swing.JTextField();
        jButtonSendto = new javax.swing.JButton();
        jButtonSendtoC = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCafe = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKitchen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(168, 187, 201));

        jPanel1.setBackground(new java.awt.Color(168, 187, 201));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jButtonRemove.setBackground(new java.awt.Color(168, 187, 201));
        jButtonRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Delete-icon.png"))); // NOI18N
        jButtonRemove.setText("Revome Product");

        jButtonClear.setBackground(new java.awt.Color(168, 187, 201));
        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Actions-edit-clear-icon.png"))); // NOI18N
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jButtonSend.setBackground(new java.awt.Color(168, 187, 201));
        jButtonSend.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/email-send-icon.png"))); // NOI18N
        jButtonSend.setText("Export Excel");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(168, 187, 201));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Other-Power-Log-Off-Metro-icon.png"))); // NOI18N
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("X");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("-");

        jButtonPrint.setBackground(new java.awt.Color(168, 187, 201));
        jButtonPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/print (1).png"))); // NOI18N
        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(130, 130, 130)))
                .addComponent(jLabel9))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButtonSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRemove)
                .addGap(18, 18, 18)
                .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSend)
                            .addComponent(jButtonRemove)
                            .addComponent(jButtonClear)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPrint)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(168, 187, 201));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Order No:");

        jLabel2.setBackground(new java.awt.Color(168, 187, 201));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Date:");

        jLabel7.setBackground(new java.awt.Color(168, 187, 201));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Ordered by:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldOrdered, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldOrdered)
                    .addComponent(jTextFieldDate))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(168, 187, 201));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(168, 187, 201));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Product:");

        jLabel5.setBackground(new java.awt.Color(168, 187, 201));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Category:");

        jButtonAdd.setBackground(new java.awt.Color(168, 187, 201));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/Folder-Add-icon.png"))); // NOI18N
        jButtonAdd.setText("Add to List");
        jButtonAdd.setActionCommand("");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(168, 187, 201));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantity:");

        jTextField7.setForeground(new java.awt.Color(204, 204, 255));
        jTextField7.setText("Search");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jComboBoxCategory.setBackground(new java.awt.Color(168, 187, 201));
        jComboBoxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cafe", "Kitchen" }));

        jButtonSendto.setBackground(new java.awt.Color(168, 187, 201));
        jButtonSendto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSendto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/table-row-insert-icon.png"))); // NOI18N
        jButtonSendto.setText("Send to Table K");
        jButtonSendto.setActionCommand("");
        jButtonSendto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendtoActionPerformed(evt);
            }
        });

        jButtonSendtoC.setBackground(new java.awt.Color(168, 187, 201));
        jButtonSendtoC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSendtoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emerskitchen/icons/table-row-insert-icon.png"))); // NOI18N
        jButtonSendtoC.setText("Send to Table C");
        jButtonSendtoC.setActionCommand("");
        jButtonSendtoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendtoCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSendto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSendtoC, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldProd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldQtity, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQtity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSendto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSendtoC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(168, 187, 201));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cafe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableCafe.setBackground(new java.awt.Color(168, 187, 201));
        jTableCafe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableCafe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCafe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(168, 187, 201));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kitchen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableKitchen.setBackground(new java.awt.Color(168, 187, 201));
        jTableKitchen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableKitchen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableKitchen);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        //System.exit(0);
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        order = jTextFieldOrder.getText();
        date = jTextFieldDate.getText();
        orderedby = jTextFieldOrdered.getText();
        prod = jTextFieldProd.getText();
        category = jComboBoxCategory.getSelectedItem().toString();
        qtity = jTextFieldQtity.getText();

        if (order.isEmpty() || date.isEmpty() || orderedby.isEmpty() || prod.isEmpty() || qtity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Check if all fields are filled");
        } else {
            try {
                //SQL
                String sql = "INSERT INTO order (prod, category, qtity) VALUE (?,?,?)";
                //Connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "");
                //statement
                ps = this.con.prepareStatement(sql);

//            ps.setInt(0,Integer.parseInt(jTextFieldProd.getText()));
                ps.setString(1, order);
                ps.setString(2, date);
                ps.setString(3, orderedby);
                ps.setString(4, prod);
                ps.setString(5, category);
                ps.setString(6, qtity);

                int dataInserted = ps.executeUpdate();
                if (dataInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Inserted successfully");
                    clearFields();
                    populateJTable();//refresh jTable after add
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        String CurrentDirectoryFilePath = "C:\\Users\\florm\\OneDrive\\Documentos\\NetBeansProjects\\EmersKitchen";
        JFileChooser excelExportChooser = new JFileChooser(CurrentDirectoryFilePath);
        //Filter only excel
        FileNameExtensionFilter excelFNEF = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelExportChooser.setFileFilter(excelFNEF);
        //dialog box
        excelExportChooser.setDialogTitle("Saving Excel");
        int excelChooser = excelExportChooser.showSaveDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            //add excel library 
            XSSFWorkbook excelXSSFWorkbookExporter = new XSSFWorkbook();
            XSSFSheet excelSheet = excelXSSFWorkbookExporter.createSheet("JTable Order Data");

            //Loop through jtable columns and rows
            for (int e = 0; e < model.getRowCount(); e++) {
                XSSFRow excelRow = excelSheet.createRow(e);
                for (int x = 0; x < model.getColumnCount(); x++) {
                    XSSFCell excelCell = excelRow.createCell(x);

                    excelCell.setCellValue(model.getValueAt(e, x).toString());
                }

            }
            //create unique name by using excel file .xlsx
            FileOutputStream excelaFIS;
            BufferedOutputStream excelBOU;

            try {
                excelaFIS = new FileOutputStream(excelExportChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelaFIS);
                excelXSSFWorkbookExporter.write(excelBOU);
                excelBOU.close();
                excelXSSFWorkbookExporter.close();
                
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jButtonSendtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendtoActionPerformed
        TableModel model1 = jTableCafe.getModel();
        int[] index = jTableCafe.getSelectedRows();
        Object[] row = new Object[4];
        model = (DefaultTableModel) jTableKitchen.getModel();
        //loop through arraylist to populate jTable
        for (int t = 0; t < index.length; t++) {
            row[0] = model1.getValueAt(index[t], 0);
            row[1] = model1.getValueAt(index[t], 1);
            row[2] = model1.getValueAt(index[t], 2);
            row[3] = model1.getValueAt(index[t], 3);
            row[4] = model1.getValueAt(index[t], 4);
            model.addRow(row);

        }
    }//GEN-LAST:event_jButtonSendtoActionPerformed

    private void jButtonSendtoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendtoCActionPerformed
        TableModel model1 = jTableKitchen.getModel();
        int[] index = jTableKitchen.getSelectedRows();
        Object[] row = new Object[4];
        model = (DefaultTableModel) jTableCafe.getModel();
        //loop through arraylist to populate jTable
        for (int t = 0; t < index.length; t++) {
            row[0] = model1.getValueAt(index[t], 0);
            row[1] = model1.getValueAt(index[t], 1);
            row[2] = model1.getValueAt(index[t], 2);
            row[3] = model1.getValueAt(index[t], 3);
            row[4] = model1.getValueAt(index[t], 4);
            model.addRow(row);

        }
    }//GEN-LAST:event_jButtonSendtoCActionPerformed

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearFields();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        try {
            boolean printJTable = jTableCafe.print();
            JOptionPane.showMessageDialog(null, "Order printed successfully");
            if(!printJTable){
                JOptionPane.showMessageDialog(null, "Unable to print");
            }
               boolean printJTable2 = jTableKitchen.print();
               JOptionPane.showMessageDialog(null, "Order printed successfully");
               if(!printJTable2){
                JOptionPane.showMessageDialog(null, "Unable to print");
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        
    }//GEN-LAST:event_jTextField7KeyReleased

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
            java.util.logging.Logger.getLogger(OrderGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderGUI().setVisible(true);
            }
        });
    }

    private void clearFields() {

        jTextFieldOrder.setText("");
        jTextFieldProd.setText("");
        jTextFieldDate.setText("");
        jTextFieldOrdered.setText("");
        jComboBoxCategory.setSelectedIndex(0);
        jTextFieldQtity.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager MoscowPUEntityManager;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonSendto;
    private javax.swing.JButton jButtonSendtoC;
    private javax.swing.JComboBox<String> jComboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCafe;
    private javax.swing.JTable jTableKitchen;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldOrder;
    private javax.swing.JTextField jTextFieldOrdered;
    private javax.swing.JTextField jTextFieldProd;
    private javax.swing.JTextField jTextFieldQtity;
    private java.util.List<emerskitchen.Stock> stockList;
    private javax.persistence.Query stockQuery;
    // End of variables declaration//GEN-END:variables

}
