/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Quanly;

import DAO.NVDAO;
import DAO.NVThuViecDAO;
import DAO.ThoiViecDAO;
import DAO.TinhLuongDAO;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BaoCaoThongKe extends javax.swing.JPanel {

    /**
     * Creates new form BaoCaoThongKe
     */
    
    private final TinhLuongDAO tlDAO;
    private final NVDAO nvDAO;
    private final NVThuViecDAO nvtvDAO;
    private final ThoiViecDAO tvDAO;
    
    public BaoCaoThongKe() {
        initComponents();
        
        tlDAO = new TinhLuongDAO();
        nvDAO = new NVDAO();
        nvtvDAO = new NVThuViecDAO();
        tvDAO = new ThoiViecDAO();
    }
    
    private int valueToPixel(int value, int maxValue, int maxPixel) {
        return (int) ((value / (double) maxValue) * maxPixel);
    }
    
    
    void chayCotNhanVienChinhThuc()
    {
        int height = 40;
        int maxPixel = 950; // Số pixel tối đa
        int maxValue = 100; // Giá trị tối đa tương ứng với maxPixel

        // Tính toán số pixel tương ứng với giá trị báo cáo
        int nam = cbNam_CCCN.getYear();
        int thang = cbThang_CCCN.getMonth()+1;

        int targetValue = nvDAO.getSoNVByTime(nam,thang);
        txtSoNVCT.setText(String.valueOf(targetValue));
        int targetPixel = valueToPixel(targetValue, maxValue, maxPixel);
        
        new Thread(() -> {
            for(int i = 0; i<targetPixel; i++)
            {
                try {
                    pnNhanVienChinhThuc.setSize(i, height);
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BaoCaoThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start(); 
    }
    
    void chayCotNhanVienThuViec()
    {
        int height = 40;
        
        int maxPixel = 950; // Số pixel tối đa
        int maxValue = 100; // Giá trị tối đa tương ứng với maxPixel

        // Tính toán số pixel tương ứng với giá trị báo cáo
        int nam = cbNam_CCCN.getYear();
        int thang = cbThang_CCCN.getMonth()+1;
        int targetValue = nvtvDAO.getSoNVTVByTime(nam, thang);
        txtSoNVTV.setText(String.valueOf(targetValue));
        int targetPixel = valueToPixel(targetValue, maxValue, maxPixel);
        
        new Thread(() -> {
            for(int i = 0; i<targetPixel; i++)
            {
                try {
                    pnNhanVienThuViec.setSize(i, height);
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BaoCaoThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start(); 
    }
    
    void chayCotNhanVienThoiViec()
    {
        int height = 40;
        
        int maxPixel = 950; // Số pixel tối đa
        int maxValue = 100; // Giá trị tối đa tương ứng với maxPixel

        // Tính toán số pixel tương ứng với giá trị báo cáo
        int nam = cbNam_CCCN.getYear();
        int thang = cbThang_CCCN.getMonth()+1;
        int targetValue = tvDAO.getSoNVTVByTime(nam, thang);
        txtSoNVNV1.setText(String.valueOf(targetValue));
        int targetPixel = valueToPixel(targetValue, maxValue, maxPixel);
        
        new Thread(() -> {
            for(int i = 0; i<targetPixel; i++)
            {
                try {
                    pnNhanVienNghiViec.setSize(i, height);
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BaoCaoThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start(); 
    }
    
     
    void chayCotLuong()
    {
        int height = 40;
        
        int maxPixel = 950; // Số pixel tối đa
        int maxValue = 20000000; // Giá trị tối đa tương ứng với maxPixel

        // Tính toán số pixel tương ứng với giá trị báo cáo
        int nam = cbNam.getYear();
        int thang = cbThang.getMonth()+1;
        float avg = tlDAO.getAVGLuong(thang, nam);
        txtLuongTB_BCL.setText(String.valueOf(avg)+ " VND");
        int targetValue = (int)avg;
        int targetPixel = valueToPixel(targetValue, maxValue, maxPixel);
        
        new Thread(() -> {
            for(int i = 0; i<targetPixel; i++)
            {
                try {
                    pnLuong.setSize(i, height);

                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BaoCaoThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start(); 
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
        txtBaoCaoChiTietNhanSu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBaoCao_BCNS = new util.ButtonGradient();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnNhanVienThuViec = new javax.swing.JPanel();
        pnNhanVienNghiViec = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnNhanVienChinhThuc = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        txtSo_NVCT = new javax.swing.JLabel();
        txtSo_NVTV = new javax.swing.JLabel();
        txtSoNVNV = new javax.swing.JLabel();
        txtSoNVCT = new javax.swing.JLabel();
        txtSoNVTV = new javax.swing.JLabel();
        txtSoNVNV1 = new javax.swing.JLabel();
        cbNam_CCCN = new com.toedter.calendar.JYearChooser();
        cbThang_CCCN = new com.toedter.calendar.JMonthChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtBaoCaoLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnBaoCao_BCL = new util.ButtonGradient();
        jPanel5 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pnLuong = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtLuongTB_BCL = new javax.swing.JLabel();
        cbThang = new com.toedter.calendar.JMonthChooser();
        cbNam = new com.toedter.calendar.JYearChooser();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtBaoCaoChiTietNhanSu.setBackground(new java.awt.Color(0, 153, 153));
        txtBaoCaoChiTietNhanSu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBaoCaoChiTietNhanSu.setText("Báo cáo chi tiết nhân sự");
        txtBaoCaoChiTietNhanSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBaoCaoChiTietNhanSuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Tháng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Năm");

        btnBaoCao_BCNS.setText("Báo cáo");
        btnBaoCao_BCNS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBaoCao_BCNS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCNSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCNSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCNSMouseExited(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setBackground(new java.awt.Color(255, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Nhân viên nghỉ việc");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("Nhân viên thử việc");

        jTextField2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel5.setText("0");

        jLabel6.setText("20");

        jLabel7.setText("40");

        jLabel8.setText("60");

        jLabel9.setText("100");

        pnNhanVienThuViec.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout pnNhanVienThuViecLayout = new javax.swing.GroupLayout(pnNhanVienThuViec);
        pnNhanVienThuViec.setLayout(pnNhanVienThuViecLayout);
        pnNhanVienThuViecLayout.setHorizontalGroup(
            pnNhanVienThuViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnNhanVienThuViecLayout.setVerticalGroup(
            pnNhanVienThuViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        pnNhanVienNghiViec.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout pnNhanVienNghiViecLayout = new javax.swing.GroupLayout(pnNhanVienNghiViec);
        pnNhanVienNghiViec.setLayout(pnNhanVienNghiViecLayout);
        pnNhanVienNghiViecLayout.setHorizontalGroup(
            pnNhanVienNghiViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnNhanVienNghiViecLayout.setVerticalGroup(
            pnNhanVienNghiViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel13.setText("80");

        pnNhanVienChinhThuc.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout pnNhanVienChinhThucLayout = new javax.swing.GroupLayout(pnNhanVienChinhThuc);
        pnNhanVienChinhThuc.setLayout(pnNhanVienChinhThucLayout);
        pnNhanVienChinhThucLayout.setHorizontalGroup(
            pnNhanVienChinhThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnNhanVienChinhThucLayout.setVerticalGroup(
            pnNhanVienChinhThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Nhân viên chính thức");

        jTextField4.setBackground(new java.awt.Color(51, 51, 255));

        txtSoNVCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtSoNVTV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtSoNVNV1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoNVCT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtSoNVTV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoNVNV1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pnNhanVienNghiViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(pnNhanVienChinhThuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(pnNhanVienThuViec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(185, 185, 185)
                                .addComponent(jLabel6)
                                .addGap(169, 169, 169))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtSo_NVCT)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtSo_NVTV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(txtSoNVNV)
                                .addGap(75, 75, 75))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addGap(182, 182, 182)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(185, 185, 185)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnNhanVienChinhThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoNVCT, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnNhanVienThuViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNVTV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoNVNV1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(pnNhanVienNghiViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(139, 139, 139)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSo_NVCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSo_NVTV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoNVNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbThang_CCCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbNam_CCCN, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBaoCao_BCNS, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBaoCaoChiTietNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBaoCaoChiTietNhanSu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbThang_CCCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBaoCao_BCNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbNam_CCCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Báo cáo nhân sự", jPanel1);

        txtBaoCaoLuong.setBackground(new java.awt.Color(0, 153, 153));
        txtBaoCaoLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBaoCaoLuong.setText("Báo cáo lương");
        txtBaoCaoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBaoCaoLuongActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Tháng");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Năm");

        btnBaoCao_BCL.setText("Báo cáo");
        btnBaoCao_BCL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBaoCao_BCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBaoCao_BCLMouseExited(evt);
            }
        });
        btnBaoCao_BCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCao_BCLActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTextField3.setBackground(new java.awt.Color(0, 0, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Lương");

        jLabel14.setText("0");

        jLabel15.setText("5.000.000");

        jLabel16.setText("10.000.000");

        jLabel17.setText("15.000.000");

        jLabel18.setText("20.000.000");

        pnLuong.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout pnLuongLayout = new javax.swing.GroupLayout(pnLuong);
        pnLuong.setLayout(pnLuongLayout);
        pnLuongLayout.setHorizontalGroup(
            pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnLuongLayout.setVerticalGroup(
            pnLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Lương trung bình:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLuongTB_BCL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(pnLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(166, 166, 166)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(186, 186, 186)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addGap(185, 185, 185)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addGap(103, 103, 103))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLuongTB_BCL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(46, 46, 46))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel15, jLabel16, jLabel17, jLabel18});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBaoCao_BCL, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBaoCaoLuong))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBaoCaoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBaoCao_BCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10))
                    .addComponent(cbNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1198, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Báo cáo lương", jPanel2);

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBaoCaoChiTietNhanSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBaoCaoChiTietNhanSuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBaoCaoChiTietNhanSuActionPerformed

    private void btnBaoCao_BCNSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCNSMouseEntered
        btnBaoCao_BCNS.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnBaoCao_BCNSMouseEntered

    private void btnBaoCao_BCNSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCNSMouseExited
        btnBaoCao_BCNS.setForeground(Color.white);
    }//GEN-LAST:event_btnBaoCao_BCNSMouseExited

    private void btnBaoCao_BCNSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCNSMouseClicked
       chayCotNhanVienChinhThuc();
       chayCotNhanVienThuViec();
       chayCotNhanVienThoiViec();
    }//GEN-LAST:event_btnBaoCao_BCNSMouseClicked

    private void txtBaoCaoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBaoCaoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBaoCaoLuongActionPerformed

    private void btnBaoCao_BCLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCLMouseClicked
        chayCotLuong();
    }//GEN-LAST:event_btnBaoCao_BCLMouseClicked

    private void btnBaoCao_BCLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCLMouseEntered
        btnBaoCao_BCL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnBaoCao_BCLMouseEntered

    private void btnBaoCao_BCLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCao_BCLMouseExited
       btnBaoCao_BCL.setForeground(Color.white);
    }//GEN-LAST:event_btnBaoCao_BCLMouseExited

    private void btnBaoCao_BCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCao_BCLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBaoCao_BCLActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnBaoCao_BCL;
    private util.ButtonGradient btnBaoCao_BCNS;
    private com.toedter.calendar.JYearChooser cbNam;
    private com.toedter.calendar.JYearChooser cbNam_CCCN;
    private com.toedter.calendar.JMonthChooser cbThang;
    private com.toedter.calendar.JMonthChooser cbThang_CCCN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private util.PanelGradient panelGradient1;
    private javax.swing.JPanel pnLuong;
    private javax.swing.JPanel pnNhanVienChinhThuc;
    private javax.swing.JPanel pnNhanVienNghiViec;
    private javax.swing.JPanel pnNhanVienThuViec;
    public static javax.swing.JTextField txtBaoCaoChiTietNhanSu;
    public static javax.swing.JTextField txtBaoCaoLuong;
    private javax.swing.JLabel txtLuongTB_BCL;
    private javax.swing.JLabel txtSoNVCT;
    private javax.swing.JLabel txtSoNVNV;
    private javax.swing.JLabel txtSoNVNV1;
    private javax.swing.JLabel txtSoNVTV;
    private javax.swing.JLabel txtSo_NVCT;
    private javax.swing.JLabel txtSo_NVTV;
    // End of variables declaration//GEN-END:variables
}
