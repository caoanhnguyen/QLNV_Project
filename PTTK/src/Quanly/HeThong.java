/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Quanly;

import DAO.NVDAO;
import DAO.TaiKhoanDAO;
import Model.TaiKhoan;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import phantichthietkehethong_nhom4.Phantichthietkehethong_nhom4;

/**
 *
 * @author Admin
 */
public class HeThong extends javax.swing.JPanel {

    /**
     * Creates new form HeThong
     */
    private TaiKhoanDAO tkDAO;
    private List<TaiKhoan> TKList;
    private NVDAO nvDAO;
    
    public HeThong() {
        initComponents();
        tkDAO = new TaiKhoanDAO();
        
        //Load data lên bảng tài khoản
        TKList = tkDAO.getTKList();
        loadDataToTableTK(TKList);
        
        //Load data lên combo box maNV
        loadMaNVToCB_MaNV();
        
        safetySelectedCB(cbMaNV);
    }
    
    private void safetySelectedCB(JComboBox myCB){
        if (myCB.getItemCount() > 0 && myCB.getItemAt(0) != null) {
            myCB.setSelectedIndex(0);
        } else {
            myCB.setSelectedItem("");
        }
    }
    
    private void setWhiteColor()
    {
        btnNhapLai.setForeground(Color.white);
        btnUpdate.setForeground(Color.white);
    }
    
    public static String maHoaMK(String password) {
        try {
            // Tạo một đối tượng MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Cập nhật dữ liệu của bộ mã hóa bằng mật khẩu
            md.update(password.getBytes());
            
            // Mã hóa mật khẩu và chuyển đổi thành dạng hexadecimal
            byte[] byteData = md.digest();
            StringBuilder hexString = new StringBuilder();
            for (byte b : byteData) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void loadDataToTableTK(List<TaiKhoan> TKList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã tài khoản");
        dtm.addColumn("Mã loại tài khoản");
        dtm.addColumn("Tên chủ tài khoản");
        dtm.addColumn("Tên đăng nhập");
        dtm.addColumn("Mật khẩu mã hóa");
        
        Object[] row = new Object[5];
        for(Model.TaiKhoan tk: TKList){
            row[0] = tk.getMaTK();
            row[1] = tk.getMaLoaiTK();
            row[2] = tk.getTenChuTK();
            row[3] = tk.getTenDangNhap();
            row[4] = maHoaMK(tk.getMatKhau());
            dtm.addRow(row);
        }
        tblTaiKhoan.setModel(dtm);
    }
    
    private boolean confirmPasswd(String passwd, String reTypePasswd){
        if(passwd.equals(reTypePasswd)){
            return true;
        }
        return false;
    }
    
    private void loadMaNVToCB_MaNV(){
        //Load mã nhân viên vào combo box PB
        List<String> maNVList = new ArrayList<>();
        nvDAO = new NVDAO();
        maNVList = nvDAO.getMaNVList();
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(maNVList.toArray(new String[0]));
        cbMaNV.setModel(mode_pb);
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
        jPTKhoan = new javax.swing.JPanel();
        txtDangKyTaiKhoan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenChuTK = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        txtXacNhanMatKhau = new javax.swing.JTextField();
        btnNhapLai = new util.ButtonGradient();
        btnUpdate = new util.ButtonGradient();
        cbMaNV = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbLoaiTK = new javax.swing.JComboBox<>();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtDangKyTaiKhoan.setBackground(new java.awt.Color(0, 153, 153));
        txtDangKyTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDangKyTaiKhoan.setText("Đăng ký tài khoản");
        txtDangKyTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDangKyTaiKhoanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToGetDataTK(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Chủ tài khoản");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Mật khẩu");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Xác nhận mật khẩu");

        txtTenChuTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTenChuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenChuTKActionPerformed(evt);
            }
        });

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtXacNhanMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnNhapLai.setText("Nhập lại");
        btnNhapLai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhapLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNhapLaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNhapLaiMouseExited(evt);
            }
        });
        btnNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapLaiActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa tài khoản");
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaNVActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Loại tài khoản");

        cbLoaiTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "ADMIN" }));
        cbLoaiTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTKhoanLayout = new javax.swing.GroupLayout(jPTKhoan);
        jPTKhoan.setLayout(jPTKhoanLayout);
        jPTKhoanLayout.setHorizontalGroup(
            jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTKhoanLayout.createSequentialGroup()
                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPTKhoanLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPTKhoanLayout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81))
                            .addComponent(txtDangKyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPTKhoanLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPTKhoanLayout.createSequentialGroup()
                                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenChuTK, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPTKhoanLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(35, 35, 35)
                                .addComponent(cbLoaiTK, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addComponent(btnNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPTKhoanLayout.setVerticalGroup(
            jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDangKyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPTKhoanLayout.createSequentialGroup()
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtXacNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPTKhoanLayout.createSequentialGroup()
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbLoaiTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenChuTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPTKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Tài khoản", jPTKhoan);

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

    private void txtDangKyTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDangKyTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDangKyTaiKhoanActionPerformed

    private void btnNhapLaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseEntered
        btnNhapLai.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnNhapLaiMouseEntered

    private void btnNhapLaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapLaiMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnNhapLaiMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        btnUpdate.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnUpdateMouseExited

    private void txtTenChuTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenChuTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenChuTKActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(Phantichthietkehethong_nhom4.kiemTraRong(jPTKhoan)){
            String maNV = cbMaNV.getSelectedItem().toString();
            if(maNV.equals("")){
                JOptionPane.showMessageDialog(null, "Bạn chưa chọn tài khoản muốn sửa!");
            }else{
                String loaiTK = cbLoaiTK.getSelectedItem().toString();
                if(loaiTK.equals("ADMIN")){
                    loaiTK = "LTK01";
                }else{
                    loaiTK = "LTK02";
                }
                String tenChuTK = txtTenChuTK.getText();
                String matKhau = txtMatKhau.getText();
                String confirmPasswd = txtXacNhanMatKhau.getText();
                if(confirmPasswd(matKhau, confirmPasswd)){
                    tkDAO.suaTaiKhoan(loaiTK,tenChuTK, matKhau, maNV);
                    JOptionPane.showMessageDialog(null, "Update thành công!");
                    TKList = tkDAO.getTKList();
                    loadDataToTableTK(TKList);
                }else{
                    JOptionPane.showMessageDialog(panelGradient1, "Xác nhận mật khẩu chưa khớp!");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaNVActionPerformed
        // TODO add your handling code here:
        String maNV = cbMaNV.getSelectedItem().toString();
        if(maNV.equals("")){
        
        }else{
            TaiKhoan tk = tkDAO.getTKByMaNV(maNV);
            if(tk.getMaLoaiTK().equals("LTK01")){
                cbLoaiTK.setSelectedItem("ADMIN");
            }else{
                cbLoaiTK.setSelectedItem("Nhân viên");
            }
            txtTenChuTK.setText(tk.getTenChuTK());
            txtMatKhau.setText(tk.getMatKhau());
        }
    }//GEN-LAST:event_cbMaNVActionPerformed

    private void cbLoaiTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiTKActionPerformed

    private void btnNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapLaiActionPerformed
        // TODO add your handling code here:
        Phantichthietkehethong_nhom4.resetForm(jPTKhoan);
        txtDangKyTaiKhoan.setText("Đăng ký tài khoản");
    }//GEN-LAST:event_btnNhapLaiActionPerformed

    private void clickToGetDataTK(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToGetDataTK
        // TODO add your handling code here:
        int row = tblTaiKhoan.getSelectedRow();
        if(row>=0){
            if(tblTaiKhoan.getValueAt(row, 1).toString().equals("Nhân viên")){
                cbLoaiTK.setSelectedIndex(0);
            }
            if(tblTaiKhoan.getValueAt(row, 1).toString().equals("ADMIN")){
                cbLoaiTK.setSelectedIndex(1);
            }
            String maNV = tblTaiKhoan.getValueAt(row, 3).toString();
            cbMaNV.setSelectedItem(maNV);
            txtTenChuTK.setText(tblTaiKhoan.getValueAt(row, 2).toString());
            txtMatKhau.setText((tkDAO.getTKByMaNV(maNV)).getMatKhau());
        }
    }//GEN-LAST:event_clickToGetDataTK


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnNhapLai;
    private util.ButtonGradient btnUpdate;
    private javax.swing.JComboBox<String> cbLoaiTK;
    private javax.swing.JComboBox<String> cbMaNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPTKhoan;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tblTaiKhoan;
    public static javax.swing.JTextField txtDangKyTaiKhoan;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenChuTK;
    private javax.swing.JTextField txtXacNhanMatKhau;
    // End of variables declaration//GEN-END:variables
}