/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Quanly;

import ChucNang_QL_NhanVien.SuaBaoHiem;
import ChucNang_QL_NhanVien.SuaNVTV;
import ChucNang_QL_NhanVien.Xuatfile_NhanVien;
import ChucNang_QL_NhanVien.SuaNhanVien;
import ChucNang_QL_NhanVien.ThemBaoHiem;
import ChucNang_QL_NhanVien.ThemNVTV;
import ChucNang_QL_NhanVien.ThemNhanVien;
import DAO.BaoHiemDAO;
import DAO.BoPhanDAO;
import DAO.NVDAO;
import DAO.NVThuViecDAO;
import DAO.PhongBanDAO;
import DAO.ThoiViecDAO;
import Model.HoSoThuViec;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import phantichthietkehethong_nhom4.Phantichthietkehethong_nhom4;

/**
 *
 * @author Admin
 */
public class NhanVien extends javax.swing.JPanel {

    /**
     * Creates new form NhanVien
     */
     //Color gradient backGround
    private final Color color1 = new Color(0, 255, 204);
//    private Color color2 = Color.GREEN;
    private final Color color3 = new Color(204, 0, 204);
    
    ThoiViecDAO thoiViecDAO;
    NVThuViecDAO nvtvDAO;
    BaoHiemDAO bhDAO;
    NVDAO nvDAO;
    BoPhanDAO bpDAO;
    PhongBanDAO pbDAO;
    List<Model.ThoiViec> thoiViecList;
    List<Model.HoSoThuViec> NVTV_List;
    List<Model.BaoHiem> BHList;
    List<Model.NhanVien> NVList;
    
    public NhanVien() {
        initComponents();
        
//        panelGradient1.addColor(new ModelColor(color1,0f),new ModelColor(color3, 1f));

        thoiViecDAO = new ThoiViecDAO();
        nvtvDAO = new NVThuViecDAO();
        bhDAO = new BaoHiemDAO();
        nvDAO = new NVDAO();
        bpDAO = new BoPhanDAO();
        pbDAO = new PhongBanDAO();

        thoiViecList = thoiViecDAO.getThoiViecList();
        NVTV_List = nvtvDAO.getNVTVList();
        BHList = bhDAO.getBaoHiemList();
        NVList = nvDAO.getNVList();

        //Load data lên bảng thôi việc
        loadDataToTableThoiViec(thoiViecList);

        //Load data lên bảng nv thử việc
        loadDataToTableThuViec(NVTV_List);
         
        //Load data lên bảng bảo hiểm
        loadDataToTableBaoHiem(BHList);
        
        //Load data lên bảng nhân viên
        loadDataToTableNhanVien(NVList);
        
        //Load data lên combo box BP
        loadMaBPToCB_BP();
        
        //Load data lên combo box PB
        List<String> tenPBList = pbDAO.getTenPBList();
       
        loadMaPBTo_PB(tenPBList);
    }
    
     private void setWhiteColor()
    {
        btnSearch.setForeground(Color.white);
        btnAddNV.setForeground(Color.white);
        btnDeleteNV.setForeground(Color.white);
        btnUpdateNV.setForeground(Color.white);
        btnResetNV.setForeground(Color.white);
        btnXuatFile.setForeground(Color.white);
        btnAddBH.setForeground(Color.white);
        btnDeleteBH.setForeground(Color.white);
        btnUpdateBH.setForeground(Color.white);
        btnAddNVTV.setForeground(Color.white);
        btnDeleteNVTV.setForeground(Color.white);
        
    }
     
    private void adjustColumnWidths(JTable myTable){
        // Giả sử bảng của bạn có tên là "yourTableName"
        JTable table = myTable;

        // Lấy mô hình cột của bảng
        TableColumnModel columnModel = table.getColumnModel();

        // Lặp qua tất cả các cột để đặt chiều rộng nếu cần thiết
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(120); // Bạn có thể tùy chỉnh giá trị này
        }

    }
     
    public void loadDataToTableThuViec(List<Model.HoSoThuViec> nvtvList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã NTVT");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("CMND_CCCD");
        dtm.addColumn("Vị trí");
        dtm.addColumn("Ngày bắt đầu");
        dtm.addColumn("Số tháng TV");
        dtm.addColumn("SDT");
        dtm.addColumn("Học vấn");
        dtm.addColumn("Mã lương TV");
        dtm.addColumn("Ghi chú");
        
        Object[] row = new Object[12];
        for(Model.HoSoThuViec tv: nvtvList){
            row[0] = tv.getMaNVTV();
            row[1] = tv.getHoTen();
            row[2] = tv.getNgaySinh();
            row[3] = tv.getGioiTint();
            row[4] = tv.getCMND_CCCD();
            row[5] = tv.getViTriThuViec();
            row[6] = tv.getNgayBatDau();
            row[7] = tv.getSoThangThuViec();
            row[8] = tv.getSDT();
            row[9] = tv.getHocVan();
            row[10] = tv.getMaLuongTV();
            row[11] = tv.getGhiChu();
            
            dtm.addRow(row);
        }
        tblQuanLyNhanVienThuViec.setModel(dtm);
    }
     
    public void loadDataToTableNhanVien(List<Model.NhanVien> NVList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Dân tộc");
        dtm.addColumn("Chức vụ");
        dtm.addColumn("Loại hợp đồng");
        dtm.addColumn("Ngày đăng ký");
        dtm.addColumn("Thời gian");
        dtm.addColumn("CCCD");
        dtm.addColumn("SDT");
        dtm.addColumn("Học vấn");
        dtm.addColumn("Email");
        dtm.addColumn("Mã PB");
        dtm.addColumn("Mã lương");
        dtm.addColumn("Ghi chú");
        
        
        Object[] row = new Object[15];
        for(Model.NhanVien nv: NVList){
            row[0] = nv.getMaNV();
            row[1] = nv.getHoTen();
            row[2] = nv.getGioiTinh();
            row[3] = nv.getDanToc();
            row[4] = nv.getChucVu();
            row[5] = nv.getLoaiHopDong();
            row[6] = nv.getNgayDangKy();
            row[7] = nv.getThoiGian();
            row[8] = nv.getCMND_CCCD();
            row[9] = nv.getSDT();
            row[10] = nv.getHocVan();
            row[11] = nv.getEmail();
            row[12] = nv.getMaPB();
            row[13] = nv.getMaLuong();
            row[14] = nv.getGhiChu();
            dtm.addRow(row);
        }
        tblThongTinChiTiet.setModel(dtm);
        adjustColumnWidths(tblThongTinChiTiet);
    }
    
    public void loadDataToTableBaoHiem(List<Model.BaoHiem> BHList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã bảo hiểm");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Nơi cấp");
        dtm.addColumn("Ngày cấp");
        dtm.addColumn("Ghi chú");
        
        Object[] row = new Object[5];
        for(Model.BaoHiem bh: BHList){
            row[0] = bh.getMaBaoHiem();
            row[1] = bh.getMaNV();
            row[2] = bh.getNoiCap();
            row[3] = bh.getNgayCap();
            row[4] = bh.getGhiChu();
            dtm.addRow(row);
        }
        tblQuanLyBaoHiem.setModel(dtm);
    }
    
    private void loadDataToTableThoiViec(List<Model.ThoiViec> thoiViecList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Họ tên");
        dtm.addColumn("Ngày thôi việc");
        dtm.addColumn("Lý do");
        
        Object[] row = new Object[4];
        for(Model.ThoiViec tv: thoiViecList){
            row[0] = tv.getMaNV();
            row[1] = tv.getHoTen();
            row[2] = tv.getNgayThoiViec();
            row[3] = tv.getLyDo();
            dtm.addRow(row);
        }
        tblQuanLyNhanVienBiThoiViec.setModel(dtm);
    }
    
    private void loadMaBPToCB_BP(){
        //Load mã bộ phận vào combo box BP
        List<Model.BoPhan> BPList = new ArrayList<>();
        BPList = bpDAO.getBPList();
        List<String> tenBPList = new ArrayList<>();
        for(Model.BoPhan bp: BPList){
            tenBPList.add(bp.getTenBP());
        }
        DefaultComboBoxModel<String> model_bp = new DefaultComboBoxModel<>(tenBPList.toArray(new String[0]));
        cbBP.setModel(model_bp);
    }
    
    private void loadMaPBTo_PB(List<String> tenPBList){
        //Load mã phòng ban vào combo box PB
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(tenPBList.toArray(new String[0]));
        cbPB.setModel(mode_pb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfQuanLyBaoHiem3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelGradient1 = new util.PanelGradient();
        jPNhanVien = new javax.swing.JTabbedPane();
        pnNhanVien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbBP = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbPB = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSearch = new util.ButtonGradient();
        txtThongTinChiTiet = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinChiTiet = new javax.swing.JTable();
        btnDeleteNV = new util.ButtonGradient();
        btnAddNV = new util.ButtonGradient();
        btnUpdateNV = new util.ButtonGradient();
        btnResetNV = new util.ButtonGradient();
        btnXuatFile = new util.ButtonGradient();
        jPanel2 = new javax.swing.JPanel();
        txtQuanLyBaoHiem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQuanLyBaoHiem = new javax.swing.JTable();
        btnAddBH = new util.ButtonGradient();
        btnUpdateBH = new util.ButtonGradient();
        btnDeleteBH = new util.ButtonGradient();
        jPTV_TV = new javax.swing.JPanel();
        txtQuanLyNhanVienThuViec = new javax.swing.JTextField();
        txtQuanLyNhanVienBiThoiViec = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblQuanLyNhanVienThuViec = new javax.swing.JTable();
        btnAddNVTV = new util.ButtonGradient();
        btnDeleteNVTV = new util.ButtonGradient();
        btnDeleteNVTV1 = new util.ButtonGradient();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQuanLyNhanVienBiThoiViec = new javax.swing.JTable();

        tfQuanLyBaoHiem3.setBackground(new java.awt.Color(0, 153, 153));
        tfQuanLyBaoHiem3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tfQuanLyBaoHiem3.setText("Quản lý bảo hiểm");
        tfQuanLyBaoHiem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuanLyBaoHiem3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setPreferredSize(new java.awt.Dimension(1107, 884));

        jPNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jPNhanVien.setPreferredSize(new java.awt.Dimension(1107, 884));

        pnNhanVien.setPreferredSize(new java.awt.Dimension(1107, 884));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel1.setText("Bộ phận");

        cbBP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbBP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbBP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel4.setText("Phòng");

        cbPB.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbPB.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPBActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel5.setText("Họ tên");

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSearch.setText("Tìm kiếm");
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtThongTinChiTiet.setBackground(new java.awt.Color(0, 153, 153));
        txtThongTinChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtThongTinChiTiet.setText("Thông tin chi tiết");
        txtThongTinChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThongTinChiTietActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblThongTinChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ));
        tblThongTinChiTiet.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblThongTinChiTiet);

        btnDeleteNV.setText("Xóa nhân sự");
        btnDeleteNV.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnDeleteNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteNVMouseExited(evt);
            }
        });
        btnDeleteNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVActionPerformed(evt);
            }
        });

        btnAddNV.setText("Thêm nhân sự");
        btnAddNV.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnAddNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddNVMouseExited(evt);
            }
        });
        btnAddNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNVActionPerformed(evt);
            }
        });

        btnUpdateNV.setText("Sửa nhân sự");
        btnUpdateNV.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnUpdateNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateNVMouseExited(evt);
            }
        });
        btnUpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNVActionPerformed(evt);
            }
        });

        btnResetNV.setText("Làm mới");
        btnResetNV.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnResetNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnResetNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnResetNVMouseExited(evt);
            }
        });
        btnResetNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetNVActionPerformed(evt);
            }
        });

        btnXuatFile.setText("Xuất file");
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btnXuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXuatFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXuatFileMouseExited(evt);
            }
        });
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnAddNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDeleteNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnUpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnResetNV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBP, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbPB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThongTinChiTiet)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbPB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbBP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)))
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPNhanVien.addTab("Nhân viên", pnNhanVien);

        txtQuanLyBaoHiem.setBackground(new java.awt.Color(0, 153, 153));
        txtQuanLyBaoHiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQuanLyBaoHiem.setText("Quản lý bảo hiểm");
        txtQuanLyBaoHiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuanLyBaoHiemActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblQuanLyBaoHiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblQuanLyBaoHiem);

        btnAddBH.setText("Thêm bảo hiểm");
        btnAddBH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnAddBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddBHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddBHMouseExited(evt);
            }
        });
        btnAddBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBHActionPerformed(evt);
            }
        });

        btnUpdateBH.setText("Sửa bảo hiểm");
        btnUpdateBH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnUpdateBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateBHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateBHMouseExited(evt);
            }
        });
        btnUpdateBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBHActionPerformed(evt);
            }
        });

        btnDeleteBH.setText("Xóa bảo hiểm");
        btnDeleteBH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDeleteBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteBHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteBHMouseExited(evt);
            }
        });
        btnDeleteBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnAddBH, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnUpdateBH, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(btnDeleteBH, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBH, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateBH, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBH, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuanLyBaoHiem, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQuanLyBaoHiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPNhanVien.addTab("Quản lý chế độ", jPanel2);

        txtQuanLyNhanVienThuViec.setBackground(new java.awt.Color(0, 153, 153));
        txtQuanLyNhanVienThuViec.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQuanLyNhanVienThuViec.setText("Quản lý nhân viên thử việc");
        txtQuanLyNhanVienThuViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuanLyNhanVienThuViecActionPerformed(evt);
            }
        });

        txtQuanLyNhanVienBiThoiViec.setBackground(new java.awt.Color(0, 153, 153));
        txtQuanLyNhanVienBiThoiViec.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQuanLyNhanVienBiThoiViec.setText("Quản lý nhân viên bị thôi việc");
        txtQuanLyNhanVienBiThoiViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuanLyNhanVienBiThoiViecActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblQuanLyNhanVienThuViec.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblQuanLyNhanVienThuViec);

        btnAddNVTV.setText("Thêm nhân viên");
        btnAddNVTV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAddNVTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddNVTVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddNVTVMouseExited(evt);
            }
        });
        btnAddNVTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNVTVActionPerformed(evt);
            }
        });

        btnDeleteNVTV.setText("Xóa nhân viên");
        btnDeleteNVTV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDeleteNVTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteNVTVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteNVTVMouseExited(evt);
            }
        });
        btnDeleteNVTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVTVActionPerformed(evt);
            }
        });

        btnDeleteNVTV1.setText("Sửa nhân viên");
        btnDeleteNVTV1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDeleteNVTV1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteNVTV1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteNVTV1MouseExited(evt);
            }
        });
        btnDeleteNVTV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVTV1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btnAddNVTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnDeleteNVTV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnDeleteNVTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteNVTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteNVTV1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNVTV, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(973, 390));

        tblQuanLyNhanVienBiThoiViec.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblQuanLyNhanVienBiThoiViec);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPTV_TVLayout = new javax.swing.GroupLayout(jPTV_TV);
        jPTV_TV.setLayout(jPTV_TVLayout);
        jPTV_TVLayout.setHorizontalGroup(
            jPTV_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPTV_TVLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPTV_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuanLyNhanVienThuViec)
                    .addComponent(txtQuanLyNhanVienBiThoiViec, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(38, 38, 38))
        );
        jPTV_TVLayout.setVerticalGroup(
            jPTV_TVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTV_TVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQuanLyNhanVienThuViec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtQuanLyNhanVienBiThoiViec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPNhanVien.addTab("Quản lý thử việc/thôi việc", jPTV_TV);

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addComponent(jPNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuanLyBaoHiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuanLyBaoHiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuanLyBaoHiemActionPerformed

    private void tfQuanLyBaoHiem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuanLyBaoHiem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuanLyBaoHiem3ActionPerformed

    private void txtQuanLyNhanVienThuViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuanLyNhanVienThuViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuanLyNhanVienThuViecActionPerformed

    private void txtQuanLyNhanVienBiThoiViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuanLyNhanVienBiThoiViecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuanLyNhanVienBiThoiViecActionPerformed

    private void btnAddNVTVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNVTVMouseEntered
        
        btnAddNVTV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnAddNVTVMouseEntered

    private void btnAddNVTVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNVTVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnAddNVTVMouseExited

    private void btnDeleteNVTVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVTVMouseEntered
        
        btnDeleteNVTV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnDeleteNVTVMouseEntered

    private void btnDeleteNVTVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVTVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnDeleteNVTVMouseExited

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed

        Xuatfile_NhanVien xfnv = new Xuatfile_NhanVien();
        xfnv.setLocationRelativeTo(null);
        xfnv.setVisible(true);
        xfnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void btnXuatFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatFileMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnXuatFileMouseExited

    private void btnXuatFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatFileMouseEntered

        btnXuatFile.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnXuatFileMouseEntered

    private void btnResetNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetNVActionPerformed
        Phantichthietkehethong_nhom4.resetForm(pnNhanVien);
        txtThongTinChiTiet.setText("Thông tin chi tiết");
    }//GEN-LAST:event_btnResetNVActionPerformed

    private void btnResetNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetNVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnResetNVMouseExited

    private void btnResetNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetNVMouseEntered

        btnResetNV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnResetNVMouseEntered

    private void btnUpdateNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNVActionPerformed

        int selectedRow = tblThongTinChiTiet.getSelectedRow();
        if(selectedRow != -1){
            String maNV = (String) tblThongTinChiTiet.getValueAt(selectedRow, 0);
            String hoTen = (String) tblThongTinChiTiet.getValueAt(selectedRow,1);
            String gioiTinh = (String) tblThongTinChiTiet.getValueAt(selectedRow, 2);
            String danToc = (String) tblThongTinChiTiet.getValueAt(selectedRow, 3);
            String chucVu = (String) tblThongTinChiTiet.getValueAt(selectedRow, 4);
            String loaiHopDong = (String) tblThongTinChiTiet.getValueAt(selectedRow, 5);
            Date ngayDangKy = (Date) tblThongTinChiTiet.getValueAt(selectedRow, 6);
            int thoiGian = (int) tblThongTinChiTiet.getValueAt(selectedRow, 7);
            String CCCD = (String) tblThongTinChiTiet.getValueAt(selectedRow, 8);
            String SDT = (String) tblThongTinChiTiet.getValueAt(selectedRow, 9);
            String hocVan = (String) tblThongTinChiTiet.getValueAt(selectedRow, 10);
            String email = (String) tblThongTinChiTiet.getValueAt(selectedRow, 11);
            String maPB = (String) tblThongTinChiTiet.getValueAt(selectedRow, 12);
            String tenPB = pbDAO.getTenPBByMaPB(maPB);
            String maLuong = (String) tblThongTinChiTiet.getValueAt(selectedRow, 13);
            String ghiChu = (String) tblThongTinChiTiet.getValueAt(selectedRow, 14);
            
            SuaNhanVien snv = new SuaNhanVien(this);
            snv.setLocationRelativeTo(null);
            snv.setVisible(true);
            snv.setResizable(false);
            snv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            
            snv.setDataToForm(maNV, hoTen, gioiTinh, danToc, chucVu, loaiHopDong, ngayDangKy.toString(), thoiGian, CCCD, SDT, hocVan, email, tenPB, maLuong, ghiChu);
        }else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn sửa!");
        }
    }//GEN-LAST:event_btnUpdateNVActionPerformed

    private void btnUpdateNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnUpdateNVMouseExited

    private void btnUpdateNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateNVMouseEntered

        btnUpdateNV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnUpdateNVMouseEntered

    private void btnDeleteNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVActionPerformed
        int selectedRow = tblThongTinChiTiet.getSelectedRow();
        if (selectedRow != -1) {
            String maNV = (String) tblThongTinChiTiet.getValueAt(selectedRow, 0);

            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // Kiểm tra phản hồi của người dùng
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện hành động xóa
                nvDAO.xoaNV(maNV);
                NVList = nvDAO.getNVList();
                loadDataToTableNhanVien(NVList);
            }
        }
    }//GEN-LAST:event_btnDeleteNVActionPerformed

    private void btnDeleteNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnDeleteNVMouseExited

    private void btnDeleteNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVMouseEntered

        btnDeleteNV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnDeleteNVMouseEntered

    private void btnAddNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNVActionPerformed

        ThemNhanVien tnv = new ThemNhanVien(this);
        tnv.setLocationRelativeTo(null);
        tnv.setVisible(true);
        tnv.setResizable(false);
        tnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_btnAddNVActionPerformed

    private void btnAddNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNVMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnAddNVMouseExited

    private void btnAddNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddNVMouseEntered

        btnAddNV.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnAddNVMouseEntered

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String name  = txtName.getText().toLowerCase();
        String tenPB = cbPB.getSelectedItem().toString();
        String maPB = pbDAO.getMaPBByTenPB(tenPB);
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa nhập tên nhân viên muốn tìm!");
        }else{
            List<Model.NhanVien> NVList = nvDAO.getNVList();
            List<Model.NhanVien> NVSearch = new ArrayList<>();
            for(Model.NhanVien nv:NVList){
                if(nv.getHoTen().toLowerCase().contains(name)){
                    NVSearch.add(nv);
                }
            }
            loadDataToTableNhanVien(NVSearch);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered

        btnSearch.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void txtThongTinChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThongTinChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThongTinChiTietActionPerformed

    private void btnAddNVTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNVTVActionPerformed
        ThemNVTV tnv = new ThemNVTV(this);
        tnv.setLocationRelativeTo(null);
        tnv.setVisible(true);
        tnv.setResizable(false);
        tnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_btnAddNVTVActionPerformed

    private void btnAddBHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBHMouseExited

    private void btnAddBHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddBHMouseEntered

    private void btnUpdateBHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateBHMouseEntered

    private void btnUpdateBHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateBHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateBHMouseExited

    private void btnDeleteBHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBHMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBHMouseEntered

    private void btnDeleteBHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteBHMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBHMouseExited

    private void btnDeleteBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBHActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblQuanLyBaoHiem.getSelectedRow();
        if(selectedRow != -1){
            String maBaoHiem = (String) tblQuanLyBaoHiem.getValueAt(selectedRow, 0);
            
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa bảo hiểm này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // Kiểm tra phản hồi của người dùng
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện hành động xóa
                            
                bhDAO.deleteBaoHiem(maBaoHiem);
                BHList = bhDAO.getBaoHiemList();
                loadDataToTableBaoHiem(BHList);
            }
        }
    }//GEN-LAST:event_btnDeleteBHActionPerformed

    private void btnDeleteNVTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVTVActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblQuanLyNhanVienThuViec.getSelectedRow();
        if(selectedRow != -1){
            String maNVTV = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 0);
            
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // Kiểm tra phản hồi của người dùng
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện hành động xóa
                nvtvDAO.deleteNVTV(maNVTV);
                NVTV_List = nvtvDAO.getNVTVList();
                loadDataToTableThuViec(NVTV_List);
            }
        }
    }//GEN-LAST:event_btnDeleteNVTVActionPerformed

    private void btnAddBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBHActionPerformed
        // TODO add your handling code here:
        List<String> maNVList = new ArrayList<>();
        maNVList = nvDAO.getMaNVList0BH();
        if(!maNVList.isEmpty()){
            ThemBaoHiem tnv;
            try {
                tnv = new ThemBaoHiem(this);
                tnv.setLocationRelativeTo(null);
                tnv.setVisible(true);
                tnv.setResizable(false);
                tnv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            } catch (SQLException ex) {
                Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tất cả nhân viên đã bảo hiểm!");
        }
    }//GEN-LAST:event_btnAddBHActionPerformed

    private void btnUpdateBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBHActionPerformed
        // TODO add your handling code here:
        SuaBaoHiem sbh = new SuaBaoHiem(this);
        sbh.setLocationRelativeTo(null);
        sbh.setVisible(true);
        sbh.setResizable(false);
        sbh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_btnUpdateBHActionPerformed

    private void cbBPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBPActionPerformed
        // TODO add your handling code here:
        String tenBP = cbBP.getSelectedItem().toString();
        String maBP = bpDAO.getMaBPByTenBP(tenBP);
        List<String> tenPBList = pbDAO.getTenPBListByMaBP(maBP);
        loadMaPBTo_PB(tenPBList);
    }//GEN-LAST:event_cbBPActionPerformed

    private void cbPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPBActionPerformed
        // TODO add your handling code here:
        if(cbPB.getSelectedItem().equals("")){
            
        }else{
            String tenPB = cbPB.getSelectedItem().toString();
            String maPB = pbDAO.getMaPBByTenPB(tenPB);
            List<Model.NhanVien> NVSearch = new ArrayList<>();
            for(Model.NhanVien nv: NVList){
                if(nv.getMaPB().equals(maPB))
                    NVSearch.add(nv);
            }
            loadDataToTableNhanVien(NVSearch);
        }
    }//GEN-LAST:event_cbPBActionPerformed

    private void btnDeleteNVTV1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVTV1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteNVTV1MouseEntered

    private void btnDeleteNVTV1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteNVTV1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteNVTV1MouseExited

    private void btnDeleteNVTV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVTV1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblQuanLyNhanVienThuViec.getSelectedRow();
        if(selectedRow != -1){
            String maNVTV = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 0);
            String hoTen = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 1);
            Date ngaySinh = (Date) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 2);
            String gioiTinh = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 3);
            String CCCD = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 4);
            String viTriThuViec = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 5);
            Date ngayBatDau = (Date) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 6);
            int soThangTV = (int) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 7);
            String SDT = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 8);
            String hocVan = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 9);
            String maLuongTV = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 10);
            String ghiChu = (String) tblQuanLyNhanVienThuViec.getValueAt(selectedRow, 11);
            
            Model.HoSoThuViec nvtv = new HoSoThuViec(maNVTV, hoTen, ngaySinh, gioiTinh, CCCD, viTriThuViec, ngayBatDau, soThangTV, SDT, hocVan, maLuongTV, ghiChu);
            SuaNVTV suaNVTV = new SuaNVTV(this);
            
            suaNVTV.setLocationRelativeTo(null);
            suaNVTV.setVisible(true);
            suaNVTV.setResizable(false);
            suaNVTV.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            
            suaNVTV.setDataToForm(nvtv);
            
        }else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn sửa!");
        }
    }//GEN-LAST:event_btnDeleteNVTV1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnAddBH;
    private util.ButtonGradient btnAddNV;
    private util.ButtonGradient btnAddNVTV;
    private util.ButtonGradient btnDeleteBH;
    private util.ButtonGradient btnDeleteNV;
    private util.ButtonGradient btnDeleteNVTV;
    private util.ButtonGradient btnDeleteNVTV1;
    private util.ButtonGradient btnResetNV;
    private util.ButtonGradient btnSearch;
    private util.ButtonGradient btnUpdateBH;
    private util.ButtonGradient btnUpdateNV;
    private util.ButtonGradient btnXuatFile;
    private javax.swing.JComboBox<String> cbBP;
    private javax.swing.JComboBox<String> cbPB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTabbedPane jPNhanVien;
    private javax.swing.JPanel jPTV_TV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JTable tblQuanLyBaoHiem;
    private javax.swing.JTable tblQuanLyNhanVienBiThoiViec;
    private javax.swing.JTable tblQuanLyNhanVienThuViec;
    private javax.swing.JTable tblThongTinChiTiet;
    public static javax.swing.JTextField tfQuanLyBaoHiem3;
    private javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtQuanLyBaoHiem;
    public static javax.swing.JTextField txtQuanLyNhanVienBiThoiViec;
    public static javax.swing.JTextField txtQuanLyNhanVienThuViec;
    public static javax.swing.JTextField txtThongTinChiTiet;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
