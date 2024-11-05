/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package NhanVien;

import Dangnhap.Dangnhap;
import Quanly.TrangChu;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.HandleImage;

/**
 *
 * @author Admin
 */
public class UI_NhanVien extends javax.swing.JFrame {

    private JPanel pChucNang;
    private final String maNV;
    
    public UI_NhanVien(String maNV) {
        initComponents();
        this.maNV = maNV;
        
        addImage(jbNhanVien, "D:\\KMA_Docs\\Term 3\\PTHT_Project\\PTTK\\Image\\staff.png", 170, 170);
        addImage(jbNhanvien, "D:\\KMA_Docs\\Term 3\\PTHT_Project\\PTTK\\Image\\anhnen.jpg", 170, 170);

        setWhiteColor();
        btnHome.setForeground(new Color(51, 0, 153));
        
        pChucNang = new TrangChu();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
    }
    
      private void setWhiteColor()
    {
        btnHome.setForeground(Color.white);
        btnDuAn_NV.setForeground(Color.white);
        btnNghiPhep_NV.setForeground(Color.white);
        btnThongTinCaNhan_NV.setForeground(Color.white);
        
        
    }
      
       public void addImage(JLabel txt, String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            txt.setIcon(icon);
        } catch (Exception e) {
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

        jPanel5 = new javax.swing.JPanel();
        btnHome = new util.ButtonGradient();
        btnDuAn_NV = new util.ButtonGradient();
        btnNghiPhep_NV = new util.ButtonGradient();
        btnThongTinCaNhan_NV = new util.ButtonGradient();
        jbNhanVien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        jbNhanvien = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnHome.setBackground(new java.awt.Color(255, 204, 0));
        btnHome.setText("Trang chủ");
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomebttTrangchuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomebttTrangchuActionPerformed(evt);
            }
        });

        btnDuAn_NV.setText("Dự án");
        btnDuAn_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDuAn_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDuAn_NVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDuAn_NVMouseExited(evt);
            }
        });
        btnDuAn_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuAn_NVbttNhanvienActionPerformed(evt);
            }
        });

        btnNghiPhep_NV.setText("Nghỉ phép");
        btnNghiPhep_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNghiPhep_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNghiPhep_NVbttBophanActionPerformed(evt);
            }
        });

        btnThongTinCaNhan_NV.setText("Thông tin CN");
        btnThongTinCaNhan_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongTinCaNhan_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinCaNhan_NVbttChamcongActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel5.setText("Nhân Viên");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(jLabel5))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnThongTinCaNhan_NV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(btnNghiPhep_NV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDuAn_NV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnDuAn_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnNghiPhep_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnThongTinCaNhan_NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnMain.setLayout(new java.awt.BorderLayout());
        pnMain.add(jbNhanvien, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Đăng xuất");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tài khoản");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomebttTrangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomebttTrangchuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomebttTrangchuMouseClicked

    private void btnHomebttTrangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomebttTrangchuActionPerformed
        setWhiteColor();
        btnHome.setForeground(new Color(51, 0, 153));
        
        pChucNang = new TrangChu();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate();   
    }//GEN-LAST:event_btnHomebttTrangchuActionPerformed

    private void btnDuAn_NVbttNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuAn_NVbttNhanvienActionPerformed
        setWhiteColor();
        btnDuAn_NV.setForeground(new Color(51, 0, 153));
        
        pChucNang = new DuAn_NV(maNV);
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        DuAn_NV.txtXemDuAn.setEditable(false);
        
        
    }//GEN-LAST:event_btnDuAn_NVbttNhanvienActionPerformed

    private void btnNghiPhep_NVbttBophanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNghiPhep_NVbttBophanActionPerformed
        setWhiteColor();
        btnNghiPhep_NV.setForeground(new Color(51, 0, 153));
        pChucNang = new NghiPhep_NV(maNV);
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        NghiPhep_NV.txtDangKyNghiPhep.setEditable(false);
        
    }//GEN-LAST:event_btnNghiPhep_NVbttBophanActionPerformed

    private void btnThongTinCaNhan_NVbttChamcongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinCaNhan_NVbttChamcongActionPerformed
        setWhiteColor();
        btnThongTinCaNhan_NV.setForeground(new Color(51, 0, 153));
        
        pChucNang = new ThongTinCaNhan(maNV);
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate();
//        ThongTinCaNhan.txtThongTinCaNhan.setEditable(false);
//        ThongTinCaNhan.txtxBangLuongCaNhan.setEditable(false);
//        ThongTinCaNhan.txtChamCongCaNhan.setEditable(false);
//        ThongTinCaNhan.txtChamCong.setEditable(false);
        
        
    }//GEN-LAST:event_btnThongTinCaNhan_NVbttChamcongActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnDuAn_NVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDuAn_NVMouseEntered
       
    }//GEN-LAST:event_btnDuAn_NVMouseEntered

    private void btnDuAn_NVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDuAn_NVMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDuAn_NVMouseExited

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        
        int choice =   JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất");
        if(choice == JOptionPane.YES_OPTION)
        {
            
            Dangnhap dn = new Dangnhap();
            setVisible(false);
            dn.setVisible(true);
        }
    }//GEN-LAST:event_jMenu1MouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
//            new UI_NhanVien(maNV).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnDuAn_NV;
    private util.ButtonGradient btnHome;
    private util.ButtonGradient btnNghiPhep_NV;
    private util.ButtonGradient btnThongTinCaNhan_NV;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jbNhanVien;
    private javax.swing.JLabel jbNhanvien;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables

    
}
