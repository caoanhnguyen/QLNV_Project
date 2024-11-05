/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Quanly;


import Dangnhap.Dangnhap;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class UI_QuanLy1 extends javax.swing.JFrame {

    private JPanel pChucNang;
    
    public UI_QuanLy1() {
        initComponents();
        addImage(jbAdmin1, "D:\\KMA_Docs\\Term 3\\PTHT_Project\\PTTK\\Image\\admin.png", 170, 170);
//        addImage(jLabel1, "D:\\KMA_Docs\\Term 3\\PTHT_Project\\PTTK\\Image\\anhnen.jpg", 1100, 890);

        
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
        btnNV.setForeground(Color.white);
        btnBP.setForeground(Color.white);
        btnCC.setForeground(Color.white);
        btnBL.setForeground(Color.white);
        btnDA.setForeground(Color.white);
        btnNP.setForeground(Color.white);
        btnBCTK.setForeground(Color.white);
        btnTCTT.setForeground(Color.white);
        btnHT.setForeground(Color.white);
        
    }
      
       public void addImage(JLabel txt, String filePath, int width, int height) {
        try {
            BufferedImage bfImage = null;
            bfImage = ImageIO.read(new File(filePath));
            Image i = HandleImage.getScaledImage(bfImage, width, height);
            ImageIcon icon = new ImageIcon(i);
            txt.setIcon(icon);
        } catch (IOException e) {
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
        btnNV = new util.ButtonGradient();
        btnBP = new util.ButtonGradient();
        btnCC = new util.ButtonGradient();
        btnBL = new util.ButtonGradient();
        btnDA = new util.ButtonGradient();
        btnNP = new util.ButtonGradient();
        btnBCTK = new util.ButtonGradient();
        btnTCTT = new util.ButtonGradient();
        btnHT = new util.ButtonGradient();
        jLabel5 = new javax.swing.JLabel();
        jbAdmin1 = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        jbAnhNen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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

        btnNV.setText("Nhân viên");
        btnNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNVMouseExited(evt);
            }
        });
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVbttNhanvienActionPerformed(evt);
            }
        });

        btnBP.setText("Bộ phận");
        btnBP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBPbttBophanActionPerformed(evt);
            }
        });

        btnCC.setText("Chấm công");
        btnCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCbttChamcongActionPerformed(evt);
            }
        });

        btnBL.setText("Bảng lương");
        btnBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBLbttBangluongActionPerformed(evt);
            }
        });

        btnDA.setText("Dự án");
        btnDA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAbttDuanActionPerformed(evt);
            }
        });

        btnNP.setText("Nghỉ phép");
        btnNP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNPbttNghiphepActionPerformed(evt);
            }
        });

        btnBCTK.setText("Báo cáo TK");
        btnBCTK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBCTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBCTKbttBaocaothongkeActionPerformed(evt);
            }
        });

        btnTCTT.setText("Tra cứu TT");
        btnTCTT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTCTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTCTTbttTracuuthongtinActionPerformed(evt);
            }
        });

        btnHT.setText("Hệ thống");
        btnHT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHTbttHethongActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel5.setText("Admin");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(btnNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBL, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(btnCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTCTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBCTK, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jbAdmin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jbAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBCTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnTCTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pnMain.setLayout(new java.awt.BorderLayout());
        pnMain.add(jbAnhNen, java.awt.BorderLayout.LINE_END);
        pnMain.add(jLabel1, java.awt.BorderLayout.CENTER);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnNVbttNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVbttNhanvienActionPerformed
        setWhiteColor();
        btnNV.setForeground(new Color(51, 0, 153));
        
        pChucNang = new NhanVien();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        NhanVien.txtThongTinChiTiet.setEditable(false);
        NhanVien.txtQuanLyBaoHiem.setEditable(false);
//        NhanVien.txtQuanLyThaiSan.setEditable(false);
        NhanVien.txtQuanLyNhanVienThuViec.setEditable(false);
        NhanVien.txtQuanLyNhanVienBiThoiViec.setEditable(false);
        
        
    }//GEN-LAST:event_btnNVbttNhanvienActionPerformed

    private void btnBPbttBophanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBPbttBophanActionPerformed
        setWhiteColor();
        btnBP.setForeground(new Color(51, 0, 153));
        pChucNang = new BoPhan();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        BoPhan.txtQuanLyPhongBan.setEditable(false);
        BoPhan.txtQuanLyBoPhan.setEditable(false);
        
    }//GEN-LAST:event_btnBPbttBophanActionPerformed

    private void btnCCbttChamcongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCCbttChamcongActionPerformed
        setWhiteColor();
        btnCC.setForeground(new Color(51, 0, 153));
        
        pChucNang = new ChamCong();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        ChamCong.txtQuanLyChamCong.setEditable(false);
        ChamCong.txtBangQuanLyChamCongThuViec.setEditable(false);
        ChamCong.txtThongTinKhenThuong.setEditable(false);
        ChamCong.txtThongTinKyLuat.setEditable(false);
        
    }//GEN-LAST:event_btnCCbttChamcongActionPerformed

    private void btnBLbttBangluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBLbttBangluongActionPerformed
        setWhiteColor();
        btnBL.setForeground(new Color(51, 0, 153));
        
       
        
        pChucNang = new BangLuong();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        BangLuong.txtThongTinBangLuong.setEditable(false);
        BangLuong.txtBangTinhLuong.setEditable(false);
        BangLuong.txtThayDoiBangLuong.setEditable(false);
    }//GEN-LAST:event_btnBLbttBangluongActionPerformed

    private void btnDAbttDuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAbttDuanActionPerformed
        setWhiteColor();
        btnDA.setForeground(new Color(51, 0, 153));
        
        pChucNang = new DuAn();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        DuAn.txtQuanLyDuAn.setEditable(false);
        DuAn.txtPhanCongDuAn.setEditable(false);
    }//GEN-LAST:event_btnDAbttDuanActionPerformed

    private void btnNPbttNghiphepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNPbttNghiphepActionPerformed
        setWhiteColor();
        btnNP.setForeground(new Color(51, 0, 153));
        
        pChucNang = new NghiPhep();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        NghiPhep.txtQuanLyNghiPhep.setEditable(false);
        
    }//GEN-LAST:event_btnNPbttNghiphepActionPerformed

    private void btnBCTKbttBaocaothongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBCTKbttBaocaothongkeActionPerformed
        setWhiteColor();
        btnBCTK.setForeground(new Color(51, 0, 153));
        
        pChucNang = new BaoCaoThongKe();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        BaoCaoThongKe.txtBaoCaoChiTietNhanSu.setEditable(false);
        BaoCaoThongKe.txtBaoCaoLuong.setEditable(false);
    }//GEN-LAST:event_btnBCTKbttBaocaothongkeActionPerformed

    private void btnTCTTbttTracuuthongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTCTTbttTracuuthongtinActionPerformed
        setWhiteColor();
        btnTCTT.setForeground(new Color(51, 0, 153));
        
        pChucNang = new TraCuuThongTin();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        TraCuuThongTin.txtTraCuuThongTin.setEditable(false);
        
    }//GEN-LAST:event_btnTCTTbttTracuuthongtinActionPerformed

    private void btnHTbttHethongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHTbttHethongActionPerformed
        setWhiteColor();
        btnHT.setForeground(new Color(51, 0, 153));
        
        pChucNang = new HeThong();
        pnMain.removeAll();
        pnMain.add(pChucNang);
        pnMain.validate(); 
        HeThong.txtDangKyTaiKhoan.setEditable(false);
    }//GEN-LAST:event_btnHTbttHethongActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNVMouseEntered
       
    }//GEN-LAST:event_btnNVMouseEntered

    private void btnNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNVMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNVMouseExited

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        int choice =   JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất");
        if(choice == JOptionPane.YES_OPTION)
        {
            Dangnhap dn = new Dangnhap();
            this.dispose();
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
            java.util.logging.Logger.getLogger(UI_QuanLy1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UI_QuanLy1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnBCTK;
    private util.ButtonGradient btnBL;
    private util.ButtonGradient btnBP;
    private util.ButtonGradient btnCC;
    private util.ButtonGradient btnDA;
    private util.ButtonGradient btnHT;
    private util.ButtonGradient btnHome;
    private util.ButtonGradient btnNP;
    private util.ButtonGradient btnNV;
    private util.ButtonGradient btnTCTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jbAdmin1;
    private javax.swing.JLabel jbAnhNen;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables

    
}
