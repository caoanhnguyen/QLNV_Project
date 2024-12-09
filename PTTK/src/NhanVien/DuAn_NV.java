/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package NhanVien;

import DAO.DuAnDAO;
import DAO.PCongDADAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DuAn_NV extends javax.swing.JPanel {

    /**
     * Creates new form DuAn_NV
     */
    private final String maNV;
    private final PCongDADAO pcDAO;
    private final DuAnDAO daDAO;
    private final List<Model.DuAn> DAList;
    
    public DuAn_NV(String maNV) {
        initComponents();
        this.maNV = maNV;
        
        pcDAO = new PCongDADAO();
        daDAO = new DuAnDAO();
        DAList = pcDAO.getDAByMaNV(maNV);
        
        //load data lên bảng dự án
        loadDataToTableDA(DAList);
        
        //load data lên combo box mã da
        loadMaPBToCB_MaDA();
        
        if (cbMaDA.getItemCount() > 0 && cbMaDA.getItemAt(0) != null) {
            cbMaDA.setSelectedIndex(0);
        } else {
            cbMaDA.setSelectedItem("");
        }

    }
    
    private void loadDataToTableDA(List<Model.DuAn> DAList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã dự án");
        dtm.addColumn("Tên dự án");
        dtm.addColumn("Địa điểm");
        dtm.addColumn("Giá");
        dtm.addColumn("Hoa hồng");
        dtm.addColumn("Ngày bắt đầu");
        dtm.addColumn("Ngày kết thúc");
        dtm.addColumn("Trạng thái");
        
        Object[] row = new Object[8];
        for(Model.DuAn da: DAList){
            row[0] = da.getMaDA();
            row[1] = da.getTenDA();
            row[2] = da.getDiaDiem();
            row[3] = da.getGia();
            row[4] = da.getHoaHong();
            row[5] = da.getNgayBatDau();
            row[6] = da.getNgayKetThuc();
            row[7] = da.getTrangThai();
            dtm.addRow(row);
        }
        tbl_XemDuAn.setModel(dtm);
    }
    
    private void loadMaPBToCB_MaDA(){
        List<Model.DuAn> DAList = pcDAO.getDAByMaNV(maNV);
        List<String> MaDAList = new ArrayList<>();
        for(Model.DuAn da: DAList){
            MaDAList.add(da.getMaDA());
        }
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(MaDAList.toArray(new String[0]));
        cbMaDA.setModel(mode_pb);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtXemDuAn = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_XemDuAn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenDuAn_XDA = new javax.swing.JTextField();
        txtDiaDiem_XDA = new javax.swing.JTextField();
        txtGia_XDA = new javax.swing.JTextField();
        txtHoaHong_XDA = new javax.swing.JTextField();
        cbMaDA = new javax.swing.JComboBox<>();
        txtTrangThai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        chooserNgayBatDau = new com.toedter.calendar.JDateChooser();
        chooserNgayKetThuc = new com.toedter.calendar.JDateChooser();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtXemDuAn.setBackground(new java.awt.Color(0, 153, 153));
        txtXemDuAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtXemDuAn.setText(" Dự án được phân công");
        txtXemDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtXemDuAnActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbl_XemDuAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_XemDuAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToGetDataDA(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_XemDuAn);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Giá");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Địa điểm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Ngày kết thúc");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Mã dự án");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Hoa hồng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tên dự án");

        txtTenDuAn_XDA.setEditable(false);
        txtTenDuAn_XDA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenDuAn_XDA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDiaDiem_XDA.setEditable(false);
        txtDiaDiem_XDA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtDiaDiem_XDA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtGia_XDA.setEditable(false);
        txtGia_XDA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGia_XDA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHoaHong_XDA.setEditable(false);
        txtHoaHong_XDA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtHoaHong_XDA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbMaDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaDAActionPerformed(evt);
            }
        });

        txtTrangThai.setEditable(false);
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTrangThai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Trạng thái");

        chooserNgayBatDau.setDateFormatString("yyyy-MM-dd");

        chooserNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(557, 557, 557)
                                .addComponent(txtHoaHong_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaDiem_XDA, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                            .addComponent(txtGia_XDA))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbMaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtTenDuAn_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(txtXemDuAn)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtXemDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtHoaHong_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(txtTenDuAn_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtDiaDiem_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGia_XDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1121, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Xem dự án", jPanel1);

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtXemDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtXemDuAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtXemDuAnActionPerformed

    private void cbMaDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaDAActionPerformed
        // TODO add your handling code here:
        String maDA = cbMaDA.getSelectedItem().toString();
        Model.DuAn da = daDAO.getDAByMaDA(maDA);
        if(maDA.equals("")){
        
        }else{
            txtTenDuAn_XDA.setText(da.getTenDA());
            txtDiaDiem_XDA.setText(da.getDiaDiem());
            txtGia_XDA.setText(String.valueOf(da.getGia()));
            txtHoaHong_XDA.setText(String.valueOf(da.getHoaHong()));
            chooserNgayBatDau.setDate(da.getNgayBatDau());
            chooserNgayKetThuc.setDate(da.getNgayKetThuc());
            txtTrangThai.setText(da.getTrangThai());
        }
    }//GEN-LAST:event_cbMaDAActionPerformed

    private void clickToGetDataDA(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToGetDataDA
        // TODO add your handling code here:
        int row = tbl_XemDuAn.getSelectedRow();
        if(row>=0){
            cbMaDA.setSelectedItem(tbl_XemDuAn.getValueAt(row, 0).toString());
            txtTenDuAn_XDA.setText(tbl_XemDuAn.getValueAt(row, 1).toString());
            txtDiaDiem_XDA.setText(tbl_XemDuAn.getValueAt(row, 2).toString());
            txtGia_XDA.setText(tbl_XemDuAn.getValueAt(row, 3).toString());
            txtHoaHong_XDA.setText(tbl_XemDuAn.getValueAt(row, 4).toString());
            chooserNgayBatDau.setDate((Date)tbl_XemDuAn.getValueAt(row, 5));
            chooserNgayKetThuc.setDate((Date)tbl_XemDuAn.getValueAt(row, 6));
            txtTrangThai.setText(tbl_XemDuAn.getValueAt(row, 7).toString());
        }
    }//GEN-LAST:event_clickToGetDataDA


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMaDA;
    private com.toedter.calendar.JDateChooser chooserNgayBatDau;
    private com.toedter.calendar.JDateChooser chooserNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tbl_XemDuAn;
    private javax.swing.JTextField txtDiaDiem_XDA;
    private javax.swing.JTextField txtGia_XDA;
    private javax.swing.JTextField txtHoaHong_XDA;
    private javax.swing.JTextField txtTenDuAn_XDA;
    private javax.swing.JTextField txtTrangThai;
    public static javax.swing.JTextField txtXemDuAn;
    // End of variables declaration//GEN-END:variables
}
