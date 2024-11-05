/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ChucNang_QL_ChamCong;

import Model.KhenThuong;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import DAO.KhenThuongDAO;
import java.sql.JDBCType;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class DanhSachKhenThuong extends javax.swing.JFrame {
    /**
     * Creates new form DanhSachKhenThuong
     */
    private KhenThuongDAO khenThuongDAO;
    private List<Model.KhenThuong> khenThuongList;
    private Quanly.ChamCong CCform;
    
    public DanhSachKhenThuong(Quanly.ChamCong CCform) {
        initComponents();
        khenThuongDAO = new KhenThuongDAO();
        khenThuongList = new ArrayList<>();
        khenThuongList = khenThuongDAO.getListKhenThuong();
        loadDataToTableKT(khenThuongList);
        this.CCform = CCform;
        tfSoTien_DanhSachKhenThuong.setEditable(false);
        tfTienSanCo_DanhSachKhenThuong.setEditable(false);
        tfTongTien_DanhSachKhenThuong.setEditable(false);
        
    }
    
    
     private void setWhiteColor()
    {
        bttCongThem_DanhSachKhenThuong.setForeground(Color.white);
        bttThoatDanhSachKhenThuong.setForeground(Color.white);    
    }
     private void loadDataToTableKT(List<Model.KhenThuong> KhenThuongList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã khen thưởng");
        dtm.addColumn("tiền khen thưởng");
        dtm.addColumn("Lý do");
        
        Object[] row = new Object[3];
        for(Model.KhenThuong kt : KhenThuongList){
            row[0] = kt.getMaThuong();
            row[1] = kt.getTienThuong();
            row[2] = kt.getLyDo();
            dtm.addRow(row);
        }
        tbl_KhenThuong.setModel(dtm);
    }
    public void updateTextField(String text){
        tfTongTien_DanhSachKhenThuong.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new util.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhenThuong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfSoTien_DanhSachKhenThuong = new javax.swing.JTextField();
        tfSoLan_DanhSachKhenThuong = new javax.swing.JTextField();
        tfTienSanCo_DanhSachKhenThuong = new javax.swing.JTextField();
        tfTongTien_DanhSachKhenThuong = new javax.swing.JTextField();
        bttCongThem_DanhSachKhenThuong = new util.ButtonGradient();
        bttThoatDanhSachKhenThuong = new util.ButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khen thưởng");

        tbl_KhenThuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_KhenThuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhenThuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhenThuong);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Số tiền");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Số lần");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tiền sẵn có");

        tfSoTien_DanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfSoTien_DanhSachKhenThuong.setText("0");
        tfSoTien_DanhSachKhenThuong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfSoTien_DanhSachKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoTien_DanhSachKhenThuongActionPerformed(evt);
            }
        });

        tfSoLan_DanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfSoLan_DanhSachKhenThuong.setText("0");
        tfSoLan_DanhSachKhenThuong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfSoLan_DanhSachKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSoLan_DanhSachKhenThuongActionPerformed(evt);
            }
        });

        tfTienSanCo_DanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfTienSanCo_DanhSachKhenThuong.setText("0");
        tfTienSanCo_DanhSachKhenThuong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tfTongTien_DanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfTongTien_DanhSachKhenThuong.setText("0");
        tfTongTien_DanhSachKhenThuong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bttCongThem_DanhSachKhenThuong.setText("Cộng thêm");
        bttCongThem_DanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttCongThem_DanhSachKhenThuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttCongThem_DanhSachKhenThuongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttCongThem_DanhSachKhenThuongMouseExited(evt);
            }
        });
        bttCongThem_DanhSachKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCongThem_DanhSachKhenThuongActionPerformed(evt);
            }
        });

        bttThoatDanhSachKhenThuong.setText("Thoát");
        bttThoatDanhSachKhenThuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttThoatDanhSachKhenThuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttThoatDanhSachKhenThuongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttThoatDanhSachKhenThuongMouseExited(evt);
            }
        });
        bttThoatDanhSachKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThoatDanhSachKhenThuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSoTien_DanhSachKhenThuong)
                            .addComponent(tfSoLan_DanhSachKhenThuong)
                            .addComponent(tfTienSanCo_DanhSachKhenThuong)
                            .addComponent(tfTongTien_DanhSachKhenThuong, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bttCongThem_DanhSachKhenThuong, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(bttThoatDanhSachKhenThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(92, 92, 92))))
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(tfSoTien_DanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfSoLan_DanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfTienSanCo_DanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTongTien_DanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(bttCongThem_DanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttThoatDanhSachKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttCongThem_DanhSachKhenThuongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCongThem_DanhSachKhenThuongMouseEntered
        bttCongThem_DanhSachKhenThuong.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_bttCongThem_DanhSachKhenThuongMouseEntered

    private void bttCongThem_DanhSachKhenThuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCongThem_DanhSachKhenThuongMouseExited
        setWhiteColor();
    }//GEN-LAST:event_bttCongThem_DanhSachKhenThuongMouseExited

    private void bttThoatDanhSachKhenThuongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttThoatDanhSachKhenThuongMouseEntered
        bttThoatDanhSachKhenThuong.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_bttThoatDanhSachKhenThuongMouseEntered

    private void bttThoatDanhSachKhenThuongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttThoatDanhSachKhenThuongMouseExited
        setWhiteColor();
    }//GEN-LAST:event_bttThoatDanhSachKhenThuongMouseExited

    private void bttThoatDanhSachKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThoatDanhSachKhenThuongActionPerformed
        CCform.txtKhenThuong_CC.setText(tfTongTien_DanhSachKhenThuong.getText());
        this.dispose();
    }//GEN-LAST:event_bttThoatDanhSachKhenThuongActionPerformed

    private void bttCongThem_DanhSachKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCongThem_DanhSachKhenThuongActionPerformed
        int tienSanCo = Integer.parseInt(tfTienSanCo_DanhSachKhenThuong.getText());
        int tongTien = Integer.parseInt(tfTongTien_DanhSachKhenThuong.getText())+ tienSanCo;
        tfTongTien_DanhSachKhenThuong.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_bttCongThem_DanhSachKhenThuongActionPerformed

    private void tbl_KhenThuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhenThuongMouseClicked
        // TODO add your handling code here:
        int row = tbl_KhenThuong.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tbl_KhenThuong.getModel();
        String tienThuong = dtm.getValueAt(row, 1).toString();
        tfSoTien_DanhSachKhenThuong.setText(tienThuong);
        tfSoTien_DanhSachKhenThuong.setEditable(false);
        int soTien = Integer.parseInt(tfSoTien_DanhSachKhenThuong.getText());
        int soLan = Integer.parseInt(tfSoLan_DanhSachKhenThuong.getText());
        int tienSanCo = soTien * soLan;
        tfTienSanCo_DanhSachKhenThuong.setText(String.valueOf(tienSanCo));
    }//GEN-LAST:event_tbl_KhenThuongMouseClicked

    private void tfSoTien_DanhSachKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoTien_DanhSachKhenThuongActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tfSoTien_DanhSachKhenThuongActionPerformed

    private void tfSoLan_DanhSachKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSoLan_DanhSachKhenThuongActionPerformed
        // TODO add your handling code here:
        int soTien = Integer.parseInt(tfSoTien_DanhSachKhenThuong.getText());
        int soLan = Integer.parseInt(tfSoLan_DanhSachKhenThuong.getText());
        int tienSanCo = soTien * soLan;
        tfTienSanCo_DanhSachKhenThuong.setText(String.valueOf(tienSanCo));
        
    }//GEN-LAST:event_tfSoLan_DanhSachKhenThuongActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachKhenThuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachKhenThuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachKhenThuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachKhenThuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DanhSachKhenThuong().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient bttCongThem_DanhSachKhenThuong;
    private util.ButtonGradient bttThoatDanhSachKhenThuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tbl_KhenThuong;
    private javax.swing.JTextField tfSoLan_DanhSachKhenThuong;
    public javax.swing.JTextField tfSoTien_DanhSachKhenThuong;
    private javax.swing.JTextField tfTienSanCo_DanhSachKhenThuong;
    public javax.swing.JTextField tfTongTien_DanhSachKhenThuong;
    // End of variables declaration//GEN-END:variables
}
