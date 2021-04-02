/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan_and_refund;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MJ
 */
public class DashboardTemp extends javax.swing.JFrame {
    
    private static final String username = "root";
    private static final String password = "";
    private static final String ConnString = "jdbc:mysql://localhost/loanscheme";
    private Connection conn = null;
    private Statement st;
    String[][] data1 = new String[200][19];

    /**
     * Creates new form Dashboard
     */
    public DashboardTemp() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        tab1_Panel.setVisible(true);
        tab2_Panel.setVisible(false);
        tab3_Panel.setVisible(false);
        tab4_Panel.setVisible(false);
    }
    
    public void connect() {
        try {
            conn = DriverManager.getConnection(ConnString, username, password);
            st = conn.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Network Connection Error Check Your Database Connection!!!");
        }
    }
    
    public void display(){
        int row = 0;
        try {
            String query = "Select fullname,email,phone,bank,accountno from beneficiaryreg";
            connect();
            st.executeQuery(query);
            ResultSet rs = st.getResultSet();
            while (rs.next())
             {
                for (int i = 0; i < 5;i++) {
                    int q = i + 1;
                    data1[row][i] = rs.getString(q);
             }
                    row++;
             }
                    rs.close();
          
           } catch (SQLException ex) 
           {
                   JOptionPane.showMessageDialog(this, ex);
           }
           Object[][]data2 = new Object[row][5];
           for(int i = 0;i<row;i++)
           {
            System.arraycopy(data1[i], 0, data2[i], 0,5);
           }
           final Object[] Column = {"Full Name", "Email", "Phone", "Bank Name", "Account Number"};
           beneficiarytbl.setModel(new javax.swing.table.DefaultTableModel(data2,Column));
           beneficiarytbl.setShowHorizontalLines(false);
           beneficiarytbl.setShowVerticalLines(false);
   }
    
    public boolean exist(){
        boolean ok =false;
        try {
           String Query = "SELECT *FROM BeneficiaryReg where phone='" + phone.getText()+"' and accountno='"+accountno.getText()+"'";
            connect();
            st.execute(Query);
            ResultSet rs = st.getResultSet();
            if(rs.next())
                ok = true;
            else {
                ok = false;
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());  
        }
        return ok;  
    }
    
    public  String getTid(){
        int no=0;
        try {
            String sql = "SELECT max(id)from beneficiaryreg ";
            connect();
            st.executeQuery(sql); 
            ResultSet rs = st.getResultSet();
            while(rs.next()) {      
                no = rs.getInt(1)+1;
            }  
        } 
        catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex +"Error Generating ID");
        }     
            return no+"";  
    }
    
    public void onSave(){ 
        fname.setEditable(false);
       // bID.setEditable(false);
        lname.setEditable(false);
        gender.setEnabled(false);
        email.setEditable(false);
        phone.setEditable(false);
        bank.setEnabled(false);
        accountno.setEditable(false);
        address.setEditable(false);
        
        save.setEnabled(false);
        update.setEnabled(false);
        addNew.setEnabled(true);
        delete.setEnabled(false);   
    }//End onSave
    
    public void onaddNew(){ 
        fname.setEditable(true);
       // bID.setEditable(true);
        lname.setEditable(true);
        gender.setEnabled(true);
        email.setEditable(true);
        phone.setEditable(true);
        bank.setEnabled(true);
        accountno.setEditable(true);
        address.setEditable(true);
        
        fname.setText(null);
       // bID.setText(null);
        lname.setText(null);
        gender.setSelectedIndex(0);
        email.setText(null);
        phone.setText(null);
        bank.setSelectedIndex(0);
        accountno.setText(null);
        address.setText(null);
        
        save.setEnabled(true);
        update.setEnabled(false);
        addNew.setEnabled(true);
        delete.setEnabled(false);   
    }//End onSave

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        navigationBar = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tab5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        contentCard = new javax.swing.JPanel();
        tab1_Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        bank = new javax.swing.JComboBox<>();
        accountno = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        addNew = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        oldPhone = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        beneficiarytbl = new javax.swing.JTable();
        tab2_Panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tab3_Panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tab4_Panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        navigationBar.setBackground(new java.awt.Color(0, 153, 153));
        navigationBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 2));

        tab1.setBackground(new java.awt.Color(153, 255, 255));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Beneficiary Registration");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        tab2.setBackground(new java.awt.Color(153, 255, 255));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Loan Request");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        tab3.setBackground(new java.awt.Color(153, 255, 255));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Loan Payment");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        tab4.setBackground(new java.awt.Color(153, 255, 255));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Business");

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        tab5.setBackground(new java.awt.Color(153, 255, 255));
        tab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab5MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Logout");

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout navigationBarLayout = new javax.swing.GroupLayout(navigationBar);
        navigationBar.setLayout(navigationBarLayout);
        navigationBarLayout.setHorizontalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tab5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navigationBarLayout.setVerticalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentCard.setBackground(new java.awt.Color(0, 102, 102));
        contentCard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab1_Panel.setBackground(new java.awt.Color(153, 0, 153));
        tab1_Panel.setForeground(new java.awt.Color(51, 51, 0));
        tab1_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(232, 227, 247));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(103, 71, 199)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ID:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Forenames:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Lastname:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Phone:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Bank Name:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Gender:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Account Number:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Address:");

        fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        gender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "Female", "Male" }));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        phone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        bank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select", "Access Bank", "Access Bank (Diamond Bank)", "CitiBank Nigeria", "Ecobank Nigeria", "Enterprise Bank", "Fidelity Bank", "First Bank Nigeria", "First City Monument Bank (FCMB)", "Guaranty Trust Bank (GTB)", "Heritage Bank", "Keystone Bank", "Mainstreet Bank Afribank ", "Skye Bank", "Stanbic IBTC Bank", "Standard Chartered Bank", "Sterling Bank", "SunTrust Bank Nigeria", "Union Bank", "United Bank For Africa (UBA)", "Unity Bank", "Wema Bank", "Zenith Bank" }));

        accountno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        save.setBackground(new java.awt.Color(103, 71, 199));
        save.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("SAVE");
        save.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(103, 71, 199), 2, true));
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(103, 71, 199));
        update.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(103, 71, 199), 2, true));
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        addNew.setBackground(new java.awt.Color(103, 71, 199));
        addNew.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        addNew.setForeground(new java.awt.Color(255, 255, 255));
        addNew.setText("NEW");
        addNew.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(103, 71, 199), 2, true));
        addNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(103, 71, 199));
        delete.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(103, 71, 199), 2, true));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        oldPhone.setText("jLabel11");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 91, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(addNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(jLabel12)
                                .addComponent(id)
                                .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(fname)
                                    .addComponent(email)
                                    .addComponent(accountno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(oldPhone))
                            .addComponent(lname, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(phone)
                            .addComponent(address))))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel16)
                        .addGap(8, 8, 8)
                        .addComponent(bank, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(37, 37, 37))
                                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(oldPhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(8, 8, 8)
                                .addComponent(accountno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(8, 8, 8)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tab1_Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 820, 260));

        jPanel3.setBackground(new java.awt.Color(232, 227, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(103, 71, 199)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        beneficiarytbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        beneficiarytbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Full Name", "Email", "Phone", "Bank Name", "Account Number"
            }
        ));
        beneficiarytbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                beneficiarytblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(beneficiarytbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab1_Panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 820, 180));

        contentCard.add(tab1_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 840, 480));

        tab2_Panel.setBackground(new java.awt.Color(255, 204, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Loan Request");

        javax.swing.GroupLayout tab2_PanelLayout = new javax.swing.GroupLayout(tab2_Panel);
        tab2_Panel.setLayout(tab2_PanelLayout);
        tab2_PanelLayout.setHorizontalGroup(
            tab2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        tab2_PanelLayout.setVerticalGroup(
            tab2_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2_PanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        contentCard.add(tab2_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 54, 840, 470));

        tab3_Panel.setBackground(new java.awt.Color(51, 204, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Loan Payment");

        javax.swing.GroupLayout tab3_PanelLayout = new javax.swing.GroupLayout(tab3_Panel);
        tab3_Panel.setLayout(tab3_PanelLayout);
        tab3_PanelLayout.setHorizontalGroup(
            tab3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        tab3_PanelLayout.setVerticalGroup(
            tab3_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3_PanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        contentCard.add(tab3_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 830, 470));

        tab4_Panel.setBackground(new java.awt.Color(255, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Manage Business");

        javax.swing.GroupLayout tab4_PanelLayout = new javax.swing.GroupLayout(tab4_Panel);
        tab4_Panel.setLayout(tab4_PanelLayout);
        tab4_PanelLayout.setHorizontalGroup(
            tab4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        tab4_PanelLayout.setVerticalGroup(
            tab4_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4_PanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        contentCard.add(tab4_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 58, 830, 470));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Page Title Here");
        contentCard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentCard, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(contentCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        tab1_Panel.setVisible(true);
        tab2_Panel.setVisible(false);
        tab3_Panel.setVisible(false);
        tab4_Panel.setVisible(false);
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        tab1_Panel.setVisible(false);
        tab2_Panel.setVisible(true);
        tab3_Panel.setVisible(false);
        tab4_Panel.setVisible(false);
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
        tab1_Panel.setVisible(false);
        tab2_Panel.setVisible(false);
        tab3_Panel.setVisible(true);
        tab4_Panel.setVisible(false);
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        tab1_Panel.setVisible(false);
        tab2_Panel.setVisible(false);
        tab3_Panel.setVisible(false);
        tab4_Panel.setVisible(true);
    }//GEN-LAST:event_tab4MouseClicked

    private void tab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab5MouseClicked
        tab1_Panel.setVisible(false);
        tab2_Panel.setVisible(false);
        tab3_Panel.setVisible(false);
        tab4_Panel.setVisible(false);
    }//GEN-LAST:event_tab5MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String errorMsg = "";
        if ("".equals(fname.getText())) {
            errorMsg += " First Name is required \n";
        }

        if ("".equals(lname.getText())) {
            errorMsg += " Last Name is required \n";
        }

        if (gender.getSelectedIndex()== 0) {
            errorMsg += " Gender is required \n";
        }

        if ("".equals(email.getText())) {
            errorMsg += " Email is required \n";
        }

        if ("".equals(phone.getText())) {
            errorMsg += " Phone is required \n";
        }

        if (bank.getSelectedIndex()== 0) {
            errorMsg += " Bank Name is required \n";
        }

        if ("".equals(accountno.getText())) {
            errorMsg += " Account Number is required \n";
        }

        if ("".equals(address.getText())) {
            errorMsg += " Address is required \n";
        }

        if("".equals(errorMsg)){

            if(exist()){
                JOptionPane.showMessageDialog(this, "Beneficiary already exit!");
                onSave();
                return ;
            }
            try{
                connect();
                String sql = "INSERT INTO beneficiaryreg (fname,lname,fullname,gender,email,phone,bank,accountno,address)VALUES('"
                + fname.getText()+ "'," + "'"
                + lname.getText() + "'," + "'"
                + lname.getText() + " "+fname.getText()+"',"+"'"
                + gender.getSelectedItem()  + "'," + "'"
                + email.getText().toLowerCase()+ "'," + "'"
                + phone.getText() + "'," + "'"
                + bank.getSelectedItem() + "'," + "'"
                + accountno.getText() + "'," + "'"
                + address.getText()+ "')" ;

                st.execute(sql);
                JOptionPane.showMessageDialog(this, "Beneficiary succefully saved");
                id.setText(getTid());
                onSave();
                display();
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
            double amt = 0;
            String cAmt = String.format("%.2f", amt);
            try {
                connect();
                String sql = "INSERT INTO deptcheck(phone,accountno,balamount,status)VALUES('"
                + phone.getText()+ "'," + "'"
                + accountno.getText()+ "'," + "'"
                + cAmt + "'," + "'"
                + "0" + "')" ;
                st.execute(sql);
                //JOptionPane.showMessageDialog(this, "Loan request is succefully");
                display();
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
        else {
            JOptionPane.showMessageDialog(this, errorMsg,"Error Message: Required Field(s)",JOptionPane.ERROR_MESSAGE);
            return;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to update beneficiary record?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            double amt = 0 ;
            String cAmt = String.format("%.2f", amt);
            try {
                connect();
                String sql = "UPDATE deptcheck SET phone='" + phone.getText()
                + "' WHERE phone='" + oldPhone.getText() + "'";
                st.execute(sql);
                //  JOptionPane.showMessageDialog(this, "Loan request is succefully");
                display();
            }
            catch(Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
            try {
                connect();
                String sql = "UPDATE beneficiaryreg SET fname='" + fname.getText()
                + "',lname='" +lname.getText()
                + "',fullname='" +lname.getText()+" "+fname.getText()
                + "',gender='" + gender.getSelectedItem()
                + "',email='" + email.getText().toLowerCase()
                + "',phone='" +phone.getText()
                + "',bank='" + bank.getSelectedItem()
                + "',accountno='" + accountno.getText()
                + "',address='" +address.getText()
                + "' WHERE phone='" + oldPhone.getText() + "'";
                st.executeUpdate(sql);
                ResultSet rs = st.getResultSet();
                JOptionPane.showMessageDialog(this, "Beneficiary record updated succeful", "SUCCESS MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                display();
                id.setText(getTid());
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Beneficiary record updating has failed", " EEROR", 1);
            }
        }
        else if (n == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Beneficiary record updating is cancel", " INFORMATION", 1);
        } else {
            JOptionPane.showMessageDialog(this, "Thank you...");
        }
        onSave();
        update.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_updateActionPerformed

    private void addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewActionPerformed
        onaddNew();
        id.setText(getTid());
        display();
    }//GEN-LAST:event_addNewActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete beneficiary record?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            try {
                String query = "DELETE from beneficiaryreg WHERE phone ='" + phone.getText() + "'";
                connect();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Beneficiary record deleted successfully", "SUCCESS MESSAGE", 1);
                display();
                id.setText(getTid());
            }
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Beneficiary record deleting has failed", " EEROR", 1);
            }
        }
        else if (n == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(this, "Beneficiary record deleting is canceled", " INFORMATION", 1);
        } else {
            JOptionPane.showMessageDialog(this, "Thank you...");
        }
        onaddNew();
    }//GEN-LAST:event_deleteActionPerformed

    private void beneficiarytblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beneficiarytblMouseClicked
        try {
            connect();
            int row = beneficiarytbl.getSelectedRow();
            String table_click = beneficiarytbl.getModel().getValueAt(row, 2).toString();
            String sql = "SELECT *from beneficiaryreg WHERE phone='" + table_click + "'";
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                fname.setText(rs.getString("fname"));
                //bID.setText();
                lname.setText(rs.getString("lname"));
                gender.setSelectedItem(rs.getString("gender"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                oldPhone.setText(rs.getString("phone"));
                phone.setEditable(false);
                bank.setSelectedItem(rs.getString("bank"));
                accountno.setText(rs.getString("accountno"));
                address.setText(rs.getString("address"));
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        update.setEnabled(true);
        delete.setEnabled(true);
        save.setEnabled(false);
    }//GEN-LAST:event_beneficiarytblMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardTemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardTemp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountno;
    private javax.swing.JButton addNew;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox<String> bank;
    private javax.swing.JTable beneficiarytbl;
    private javax.swing.JPanel contentCard;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lname;
    private javax.swing.JPanel navigationBar;
    private javax.swing.JLabel oldPhone;
    private javax.swing.JTextField phone;
    private javax.swing.JButton save;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab1_Panel;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab2_Panel;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab3_Panel;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab4_Panel;
    private javax.swing.JPanel tab5;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
