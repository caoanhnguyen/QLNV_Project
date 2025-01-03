/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package NhanVien;

import DAO.NVDAO;
import DAO.NghiPhepDAO;
import java.awt.Color;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import PTPM_NHOM18.PTPM_NHOM18;

/**
 *
 * @author Admin
 */
public class NghiPhep_NV extends javax.swing.JPanel {

    /**
     * Creates new form NghiPhep_NV
     */
    private final String maNV;
    NghiPhepDAO npDAO;
    NVDAO nvDAO;
    List<Model.NghiPhep> NPListOfNV;
    Model.NhanVien nv;
    
    public NghiPhep_NV(String maNV) {
        initComponents();
        this.maNV = maNV;
        nvDAO = new NVDAO();
        nv = nvDAO.getNVByMaNV(maNV);
        
        npDAO = new NghiPhepDAO();
        NPListOfNV = npDAO.getNPListByMaNV(maNV);
        setData();
        
        //load data lên bảng nghỉ phép
        loadDataToTableNP(NPListOfNV);
    }
    
    private void setWhiteColor()
    {
        btnDangKy.setForeground(Color.white);
        btnHuyDangKy.setForeground(Color.white);
        btnReset.setForeground(Color.white);
        
    }
    
    public void setData(){
        txtNhanVien.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
    }
    
    public void loadDataToTableNP(List<Model.NghiPhep> NPList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nghỉ phép");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Lý do");
        dtm.addColumn("Ngày bắt đầu");
        dtm.addColumn("Ngày kết thúc");
        dtm.addColumn("Trạng thái");
        
        Object[] row = new Object[7];
        for(Model.NghiPhep np: NPList){
            row[0] = np.getMaNghiPhep();
            row[1] = np.getMaNV();
            row[2] = np.getHoTen();
            row[3] = np.getLyDo();
            row[4] = np.getNgayBatDau();
            row[5] = np.getNgayKetThuc();
            row[6] = np.getTrangThai();
            dtm.addRow(row);
        }
        tbl_DangKyNghiPhep.setModel(dtm);
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
        jPDK_NP = new javax.swing.JPanel();
        txtDangKyNghiPhep = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DangKyNghiPhep = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtLyDo = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        btnDangKy = new util.ButtonGradient();
        btnHuyDangKy = new util.ButtonGradient();
        btnReset = new util.ButtonGradient();
        chooserNgayBatDau = new com.toedter.calendar.JDateChooser();
        chooserNgayKetThuc = new com.toedter.calendar.JDateChooser();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtDangKyNghiPhep.setBackground(new java.awt.Color(0, 153, 153));
        txtDangKyNghiPhep.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDangKyNghiPhep.setText("Đăng ký nghỉ phép");
        txtDangKyNghiPhep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDangKyNghiPhepActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_DangKyNghiPhep.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_DangKyNghiPhep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToGetData(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DangKyNghiPhep);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Lý do");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Đến ngày");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Trạng thái");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Mã NV");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Từ ngày");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Họ tên");

        txtNhanVien.setEditable(false);
        txtNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtNhanVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        txtHoTen.setEditable(false);
        txtHoTen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtHoTen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtLyDo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtLyDo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTrangThai.setEditable(false);
        txtTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTrangThai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDangKy.setText("Đăng ký");
        btnDangKy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDangKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDangKyMouseExited(evt);
            }
        });
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        btnHuyDangKy.setText("Hủy đăng ký");
        btnHuyDangKy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyDangKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyDangKyMouseExited(evt);
            }
        });
        btnHuyDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDangKyActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetMouseExited(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        chooserNgayBatDau.setDateFormatString("yyyy-MM-dd");

        chooserNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPDK_NPLayout = new javax.swing.GroupLayout(jPDK_NP);
        jPDK_NP.setLayout(jPDK_NPLayout);
        jPDK_NPLayout.setHorizontalGroup(
            jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDK_NPLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDK_NPLayout.createSequentialGroup()
                        .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDK_NPLayout.createSequentialGroup()
                                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPDK_NPLayout.createSequentialGroup()
                                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPDK_NPLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnHuyDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txtDangKyNghiPhep, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPDK_NPLayout.setVerticalGroup(
            jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDK_NPLayout.createSequentialGroup()
                .addComponent(txtDangKyNghiPhep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPDK_NPLayout.createSequentialGroup()
                        .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPDK_NPLayout.createSequentialGroup()
                        .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPDK_NPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPDK_NP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPDK_NP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Đăng ký nghỉ phép", jPanel1);

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

    private void txtDangKyNghiPhepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDangKyNghiPhepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDangKyNghiPhepActionPerformed

    private void btnDangKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangKyMouseEntered
        btnDangKy.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnDangKyMouseEntered

    private void btnDangKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangKyMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnDangKyMouseExited

    private void btnHuyDangKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyDangKyMouseEntered
        btnHuyDangKy.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnHuyDangKyMouseEntered

    private void btnHuyDangKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyDangKyMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnHuyDangKyMouseExited

    private void btnHuyDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDangKyActionPerformed
        // TODO add your handling code here:
        int row = tbl_DangKyNghiPhep.getSelectedRow();
        if(row>=0){
            String trangThai = (tbl_DangKyNghiPhep.getValueAt(row, 6).toString());
            if(trangThai.equalsIgnoreCase("Chưa xác nhận")){
                //nếu chưa xác nhận thì được hủy
                // Hiển thị hộp thoại xác nhận
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn hủy không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                // Kiểm tra phản hồi của người dùng
                if (confirm == JOptionPane.YES_OPTION) {
                    // Thực hiện hành động xóa
                    String maNghiPhep = (tbl_DangKyNghiPhep.getValueAt(row, 0).toString());
                    npDAO.xoaNghiPhep(maNghiPhep);

                    //reload data
                    NPListOfNV = npDAO.getNPListByMaNV(maNV);
                    loadDataToTableNP(NPListOfNV);
                }
            }else{
                //nếu không thì không được hủy
                JOptionPane.showMessageDialog(panelGradient1, "Nghỉ phép đã được duyệt, không thể hủy!");
            }
        }
    }//GEN-LAST:event_btnHuyDangKyActionPerformed

    private void btnResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseEntered
        btnReset.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnResetMouseEntered

    private void btnResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnResetMouseExited

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        PTPM_NHOM18.resetForm(jPDK_NP);
        txtDangKyNghiPhep.setText("Đăng ký nghỉ phép");
        txtNhanVien.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here
        
        if(chooserNgayBatDau.getDateFormatString().isEmpty()||chooserNgayKetThuc.getDateFormatString().isEmpty()||txtLyDo.getText().isEmpty()){
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa điền đầy đủ thông tin!");
        }else{
            try{
                String maNV1 = txtNhanVien.getText();
                String hoTen = txtHoTen.getText();
                Date ngayBatDau = new Date(chooserNgayBatDau.getDate().getTime());
                Date ngayKetThuc = new Date(chooserNgayKetThuc.getDate().getTime());
                String lyDo = txtLyDo.getText();
                npDAO.themNghiPhep(maNV, hoTen, lyDo, ngayBatDau, ngayKetThuc);
                JOptionPane.showMessageDialog(panelGradient1, "Đăng ký thành công!");

                //reload data
                NPListOfNV = npDAO.getNPListByMaNV(maNV1);
                loadDataToTableNP(NPListOfNV);
            }catch(Exception j){
                JOptionPane.showMessageDialog(null, "Error: Định dạng này không đúng!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed

    private void clickToGetData(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToGetData
        // TODO add your handling code here:
        int row = tbl_DangKyNghiPhep.getSelectedRow();
        if(row>=-1){
            txtLyDo.setText(tbl_DangKyNghiPhep.getValueAt(row, 3).toString());
            chooserNgayBatDau.setDate((Date)tbl_DangKyNghiPhep.getValueAt(row, 4));
            chooserNgayKetThuc.setDate((Date)tbl_DangKyNghiPhep.getValueAt(row, 5));
            txtTrangThai.setText(tbl_DangKyNghiPhep.getValueAt(row, 6).toString());
        }
    }//GEN-LAST:event_clickToGetData


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnDangKy;
    private util.ButtonGradient btnHuyDangKy;
    private util.ButtonGradient btnReset;
    private com.toedter.calendar.JDateChooser chooserNgayBatDau;
    private com.toedter.calendar.JDateChooser chooserNgayKetThuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPDK_NP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tbl_DangKyNghiPhep;
    public static javax.swing.JTextField txtDangKyNghiPhep;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLyDo;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
