
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainPage extends javax.swing.JFrame {

        Connection connection = null;
        DbConnection dbHelper = new DbConnection();
        PreparedStatement statement = null;
   
    public MainPage() {
        initComponents();
        this.setLocation(300, 200); 
        filltableparked();          
        setResizable(false);       
        parkedvehiclecount();      
        findemptyparkplace();      
    }

   

    public String findemptyparkplace(){
        Statement statement = null;
        ResultSet resultSet;
        int parksize = 30; 
        ArrayList<Integer> parkedplace = new ArrayList(); 
        ArrayList<Integer> emptyplace = new ArrayList();  
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select vehicleplace from vehicle where vehicleplace>0 and vehicleplace <=30 ");
            while (resultSet.next()) {
                parkedplace.add(resultSet.getInt("vehicleplace")); 
            }
            for (int i = 1; i <= parksize; i++) {  
                if(!parkedplace.contains(i)){  
                    emptyplace.add(i);
                }
            
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }
        }
        String emptylocation=" "; 
        for(int i=0;i<emptyplace.size();i++){ //
            emptylocation=emptylocation+String.valueOf(emptyplace.get(i))+"-"; 
            }
       return emptylocation;
      
    }
        
                                               
    public void parkedvehiclecount(){
        DefaultTableModel model = (DefaultTableModel) vehicle_parked_table.getModel();
        mainpage_vehicle_count_field.setText(String.valueOf(vehicle_parked_table.getRowCount()));
    }
      public  void filltableparked() {
        DefaultTableModel model = (DefaultTableModel) vehicle_parked_table.getModel();
        model.setRowCount(0); 
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select plate,vehicleplace from vehicle where vehicleplace>0 "); 
            while (resultSet.next()) {                                                                         
                Object[] eklenecek = {resultSet.getString("plate"), resultSet.getInt("vehicleplace")}; 
                model.addRow(eklenecek); 
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }
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

        mainpage_maintitle_label = new javax.swing.JLabel();
        mainpage_register_info_label = new javax.swing.JLabel();
        register_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        vehicle_in_button = new javax.swing.JButton();
        mainpage_plate_label = new javax.swing.JLabel();
        vehicle_exit_button = new javax.swing.JButton();
        plateno_field = new javax.swing.JTextField();
        vehicleplace_field = new javax.swing.JTextField();
        mainpage_vehicleplace_label = new javax.swing.JLabel();
        Customer_info_button = new javax.swing.JButton();
        mainpage_info_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vehicle_parked_table = new javax.swing.JTable();
        mainpage_parked_vehicle_title_label = new javax.swing.JLabel();
        mainpage_title_label = new javax.swing.JLabel();
        mainpage_vehicle_count_info_label = new javax.swing.JLabel();
        mainpage_vehicle_count_field = new javax.swing.JLabel();
        mainpage_emptyplace_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainpage_maintitle_label.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        mainpage_maintitle_label.setText("Park Takip Otomasyonu");

        mainpage_register_info_label.setText("Kullanıcı hesabı yok ise kayıt işlemi için :");

        register_button.setText("Kayıt Ol");
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });

        exit_button.setText("Çıkış");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        vehicle_in_button.setText("Araç Giriş");
        vehicle_in_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle_in_buttonActionPerformed(evt);
            }
        });

        mainpage_plate_label.setText("Plaka no:");

        vehicle_exit_button.setText("Araç Çıkış");
        vehicle_exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicle_exit_buttonActionPerformed(evt);
            }
        });

        mainpage_vehicleplace_label.setText("Araç yeri:");

        Customer_info_button.setText("Müşteri Bilgileri");
        Customer_info_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_info_buttonActionPerformed(evt);
            }
        });

        mainpage_info_label.setForeground(new java.awt.Color(255, 51, 51));

        vehicle_parked_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plaka no", "Araç yeri"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vehicle_parked_table);
        if (vehicle_parked_table.getColumnModel().getColumnCount() > 0) {
            vehicle_parked_table.getColumnModel().getColumn(0).setResizable(false);
            vehicle_parked_table.getColumnModel().getColumn(1).setResizable(false);
        }

        mainpage_parked_vehicle_title_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainpage_parked_vehicle_title_label.setText("Otoparktaki Araçlar ve Yerleri");

        mainpage_title_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainpage_title_label.setText("Taşıt Bilgileri");

        mainpage_vehicle_count_info_label.setText("Taşıt Sayısı:");

        mainpage_vehicle_count_field.setText("Taşıt sayı");

        mainpage_emptyplace_button.setText("Boş Yerler");
        mainpage_emptyplace_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainpage_emptyplace_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(vehicle_in_button)
                        .addGap(18, 18, 18)
                        .addComponent(vehicle_exit_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mainpage_plate_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(plateno_field, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mainpage_vehicleplace_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vehicleplace_field, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mainpage_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainpage_parked_vehicle_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainpage_info_label, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainpage_register_info_label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Customer_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(register_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mainpage_vehicle_count_info_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainpage_vehicle_count_field)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mainpage_emptyplace_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainpage_maintitle_label, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainpage_maintitle_label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainpage_title_label)
                    .addComponent(mainpage_parked_vehicle_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mainpage_plate_label)
                            .addComponent(plateno_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vehicleplace_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainpage_vehicleplace_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainpage_info_label, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vehicle_exit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(vehicle_in_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addComponent(Customer_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainpage_vehicle_count_info_label)
                    .addComponent(mainpage_vehicle_count_field)
                    .addComponent(mainpage_emptyplace_button))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainpage_register_info_label)
                    .addComponent(exit_button)
                    .addComponent(register_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        Register register = new Register();
        register.setVisible(true);
    }//GEN-LAST:event_register_buttonActionPerformed
  
    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exit_buttonActionPerformed
    private void vehicle_in_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle_in_buttonActionPerformed
        mainpage_info_label.setText("");     
        
        if(Integer.valueOf(vehicleplace_field.getText())>0 && Integer.valueOf(vehicleplace_field.getText())<=30){ 
        try {
            connection = dbHelper.getConnection();
            String sql = "update vehicle set vehicleplace=? where plate=?"; 
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(this.vehicleplace_field.getText()));
            statement.setString(2, this.plateno_field.getText());
            boolean ispossible = checkvehicleplace(Integer.valueOf(vehicleplace_field.getText())); 
            if (ispossible) {                                                                     
                statement.executeUpdate();
                parkedvehiclecount();
                JOptionPane.showMessageDialog(this, "Araç yeri güncellendi", "Başarılı", WIDTH);   
            } else {
                mainpage_info_label.setText("Bu araç yeri zaten dolu");
            }

            filltableparked();
            parkedvehiclecount();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                 connection.close();
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }        
        }
        }
       else {
           mainpage_info_label.setText("Hatalı İşlem"); 
       }
       
    }//GEN-LAST:event_vehicle_in_buttonActionPerformed

    private void vehicle_exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle_exit_buttonActionPerformed
         if(Integer.valueOf(vehicleplace_field.getText())>0 && Integer.valueOf(vehicleplace_field.getText())<=30 ){ 
        try {
            connection = dbHelper.getConnection();
            String sql = "update vehicle set vehicleplace=? where plate=?"; 
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(0));
            statement.setString(2, this.plateno_field.getText());
            boolean ispossible = checkvehicleplace(Integer.valueOf(vehicleplace_field.getText()));
            if (!ispossible) {
                statement.executeUpdate(); 
                parkedvehiclecount();     
                JOptionPane.showMessageDialog(this, "Araç çıkış yaptı", "Başarılı", WIDTH);
            }

            filltableparked(); 
            parkedvehiclecount();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }         
       
        }
         }
         else {
             mainpage_info_label.setText("Hatalı İşlem"); 
         }
    }//GEN-LAST:event_vehicle_exit_buttonActionPerformed
    
    private void Customer_info_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_info_buttonActionPerformed
            this.setVisible(false);
            Customer customer = new Customer();
            customer.setVisible(true);
      
    }//GEN-LAST:event_Customer_info_buttonActionPerformed
    
    private void mainpage_emptyplace_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainpage_emptyplace_buttonActionPerformed

        JOptionPane.showMessageDialog(this,"Boş Araç yerleri:" +findemptyparkplace(), "Boş Araç Yerleri", WIDTH);
    }//GEN-LAST:event_mainpage_emptyplace_buttonActionPerformed

   public boolean checkvehicleplace(int vehicleplace) {
       
        Statement statement = null; 
        ResultSet resultSet;
        ArrayList<Integer> list = new ArrayList();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select vehicleplace from vehicle where vehicleplace>0 ");
            while (resultSet.next()) {
                list.add(resultSet.getInt("vehicleplace")); 
            }
            for (int i = 0; i < list.size(); i++) {  
                if (list.get(i).equals(vehicleplace)) {

                    return false;
                }
            }

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                dbHelper.showErrorMessage(ex);
            }
        }
        return true; 
    }

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Customer_info_button;
    private javax.swing.JButton exit_button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainpage_emptyplace_button;
    private javax.swing.JLabel mainpage_info_label;
    private javax.swing.JLabel mainpage_maintitle_label;
    private javax.swing.JLabel mainpage_parked_vehicle_title_label;
    private javax.swing.JLabel mainpage_plate_label;
    private javax.swing.JLabel mainpage_register_info_label;
    private javax.swing.JLabel mainpage_title_label;
    private javax.swing.JLabel mainpage_vehicle_count_field;
    private javax.swing.JLabel mainpage_vehicle_count_info_label;
    private javax.swing.JLabel mainpage_vehicleplace_label;
    private javax.swing.JTextField plateno_field;
    private javax.swing.JButton register_button;
    private javax.swing.JButton vehicle_exit_button;
    private javax.swing.JButton vehicle_in_button;
    private javax.swing.JTable vehicle_parked_table;
    private javax.swing.JTextField vehicleplace_field;
    // End of variables declaration//GEN-END:variables
}
