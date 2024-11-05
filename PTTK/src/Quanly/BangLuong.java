/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Quanly;

import ChucNang_QL_ChamCong.Xuatfile_BangCong;
import DAO.LuongDAO;
import DAO.NVDAO;
import DAO.ThayDoiBLDAO;
import DAO.TinhLuongDAO;
import java.awt.Color;
import java.sql.SQLException;
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
public class BangLuong extends javax.swing.JPanel {

    /**
     * Creates new form BangLuong
     */
    
    LuongDAO luongDAO;
    TinhLuongDAO tlDAO;
    ThayDoiBLDAO tdblDAO;
    NVDAO nvDAO;
    List<Model.TinhLuong> tinhLuongList;
    List<Model.ThayDoiBangLuong> tdblList;
    List<Model.Luong> LuongList;
    List<String> maLuongList;
    List<String> maNVList;
    
    public BangLuong() {
        initComponents();
    
        luongDAO = new LuongDAO();
        LuongList = new ArrayList<>();
        maLuongList = new ArrayList<>();
        
        tlDAO = new TinhLuongDAO();
        tinhLuongList = new ArrayList<>();
        
        tdblDAO = new ThayDoiBLDAO();
        tdblList = new ArrayList<>();
        
        nvDAO = new NVDAO();
//        maNVList = nvDAO.getMaNVList();

        //load data lên combo box maNV
        loadMaNVToCB_MaNV();
        
        //load data lên bảng Lương
        LuongList = luongDAO.getLuongList();
        loadDataToTableLuong(LuongList);
        
        //Load data lên combo box maLuong
        loadDataToCB_MALUONG();
        
        //load data lên bảng TDBL
        tdblList = tdblDAO.getTDBL_List();
        loadDataToTableTDBL(tdblList);
        
        //load data lên combo box mã lương
        loadMaLuongToCB_MaLuongMoi();
        
        //Load data lên bảng Tính lương
        tinhLuongList = tlDAO.getTinhLuongList(Integer.parseInt((String) cbThang_BTL.getSelectedItem()), Integer.parseInt((String) cbNam_BTL.getSelectedItem()));
        loadDataToTableTinhLuong(tinhLuongList);
        
        safetySelectedCB(cbMaLuong);
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
        btnAddLuong_BL.setForeground(Color.white);
        btnDelete_BL.setForeground(Color.white);
        btnUpdate_BL.setForeground(Color.white);
        btnReset_LM.setForeground(Color.white);
        btnUpdate_TDBL.setForeground(Color.white);
//        btnReset_TDBL.setForeground(Color.white);
        btnReset_BTL.setForeground(Color.white);
        btnXuatFile_BTL.setForeground(Color.white);
        
        
    }
    
    private void loadDataToCB_MALUONG(){
        maLuongList = luongDAO.getMaLuongList();
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(maLuongList.toArray(new String[0]));
        cbMaLuong.setModel(mode_pb);
    }
    
    private void loadDataToTableLuong(List<Model.Luong> LuongList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã lương");
        dtm.addColumn("Lương cơ bản");
        dtm.addColumn("Phụ cấp công việc");
        dtm.addColumn("Phụ cấp khác");
        dtm.addColumn("Ghi chú");
        
        Object[] row = new Object[5];
        for(Model.Luong luong: LuongList){
            row[0] = luong.getMaLuong();
            row[1] = luong.getLuongCoBan();
            row[2] = luong.getPhuCapCV();
            row[3] = luong.getPhuCapKhac();
            row[4] = luong.getGhiChu();
            dtm.addRow(row);
        }
        tbl_TTBL.setModel(dtm);
    }
    
    private void loadDataToTableTinhLuong(List<Model.TinhLuong> tinhLuongList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Mã lương");
        dtm.addColumn("Tháng");
        dtm.addColumn("Năm");
        dtm.addColumn("Lương cơ bản");
        dtm.addColumn("Phụ cấp CV");
        dtm.addColumn("Phụ cấp khác");
        dtm.addColumn("Tiền thưởng");
        dtm.addColumn("Tiền kỷ luật");
        dtm.addColumn("Tiền hoa hồng");
        dtm.addColumn("Số ngày công");
        dtm.addColumn("Lương thực nhận");
        dtm.addColumn("Ghi chú");
        
        Object[] row = new Object[13];
        for(Model.TinhLuong tl: tinhLuongList){
            row[0] = tl.getMaNV();
            row[1] = tl.getLuong().getMaLuong();
            row[2] = tl.getThang();
            row[3] = tl.getNam();
            row[4] = tl.getLuong().getLuongCoBan();
            row[5] = tl.getLuong().getPhuCapCV();
            row[6] = tl.getLuong().getPhuCapKhac();
            row[7] = tl.getTienThuong();
            row[8] = tl.getTienKyLuat();
            row[9] = tl.getTienHoaHong();
            row[10] = tl.getSoNgayCong();
            row[11] = tl.getLuongThucNhan();
            row[12] = tl.getGhiChu();
            dtm.addRow(row);
        }
        tbl_BTL.setModel(dtm);
    }
    
    private void loadDataToTableTDBL(List<Model.ThayDoiBangLuong> tdblList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Mã lương cũ");
        dtm.addColumn("Mã lương mới");
        dtm.addColumn("Ngày sửa");
        dtm.addColumn("Lý do");
        
        Object[] row = new Object[5];
        for(Model.ThayDoiBangLuong tdbl: tdblList){
            row[0] = tdbl.getMaNV();
            row[1] = tdbl.getMaLuongCu();
            row[2] = tdbl.getMaLuongMoi();
            row[3] = tdbl.getNgaySua();
            row[4] = tdbl.getLyDo();
            dtm.addRow(row);
        }
        tbl_TDBL.setModel(dtm);
    }
    
    private void loadMaNVToCB_MaNV(){
        //Load mã phòng ban vào combo box PB
        maNVList = nvDAO.getMaNVList();
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(maNVList.toArray(new String[0]));
        cbMaNV.setModel(mode_pb);
    }
    
    private void loadMaLuongToCB_MaLuongMoi(){
        //Load mã phòng ban vào combo box PB
        maLuongList = luongDAO.getMaLuongList();
        DefaultComboBoxModel<String> mode_pb = new DefaultComboBoxModel<>(maLuongList.toArray(new String[0]));
        cbMaLuongMoi.setModel(mode_pb);
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
        jPanel2 = new javax.swing.JPanel();
        jPLuong = new javax.swing.JPanel();
        txtThongTinBangLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPCK_BL = new javax.swing.JTextField();
        txtPCCV_BL = new javax.swing.JTextField();
        txtLuongCB_BL = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_TTBL = new javax.swing.JTable();
        btnAddLuong_BL = new util.ButtonGradient();
        btnUpdate_BL = new util.ButtonGradient();
        btnDelete_BL = new util.ButtonGradient();
        btnReset_LM = new util.ButtonGradient();
        cbMaLuong = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPBangLuong = new javax.swing.JPanel();
        txtBangTinhLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_BTL = new javax.swing.JTable();
        btnXuatFile_BTL = new util.ButtonGradient();
        btnReset_BTL = new util.ButtonGradient();
        cbThang_BTL = new javax.swing.JComboBox<>();
        cbNam_BTL = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPTDBL = new javax.swing.JPanel();
        txtThayDoiBangLuong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaLuong_TDBL = new javax.swing.JTextField();
        txtTenNhanVien_TDBL = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_TDBL = new javax.swing.JTable();
        btnUpdate_TDBL = new util.ButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        txtLyDo_TDBL = new javax.swing.JTextField();
        cbMaNV = new javax.swing.JComboBox<>();
        cbMaLuongMoi = new javax.swing.JComboBox<>();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtThongTinBangLuong.setBackground(new java.awt.Color(0, 153, 153));
        txtThongTinBangLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtThongTinBangLuong.setText("Thông tin bảng lương");
        txtThongTinBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThongTinBangLuongActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Mã lương");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Lương cơ bản");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Phụ cấp CV");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Phụ cấp khác");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Ghi chú");

        txtPCK_BL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPCK_BL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPCCV_BL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPCCV_BL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtLuongCB_BL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtLuongCB_BL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_TTBL.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_TTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToGetDataLuong(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_TTBL);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        btnAddLuong_BL.setText("Thêm lương mới");
        btnAddLuong_BL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddLuong_BL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddLuong_BLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddLuong_BLMouseExited(evt);
            }
        });
        btnAddLuong_BL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLuong_BLActionPerformed(evt);
            }
        });

        btnUpdate_BL.setText("Sửa lương");
        btnUpdate_BL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate_BL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdate_BLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdate_BLMouseExited(evt);
            }
        });
        btnUpdate_BL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate_BLActionPerformed(evt);
            }
        });

        btnDelete_BL.setText("Xóa lương");
        btnDelete_BL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete_BL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDelete_BLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDelete_BLMouseExited(evt);
            }
        });
        btnDelete_BL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_BLActionPerformed(evt);
            }
        });

        btnReset_LM.setText("Làm mới");
        btnReset_LM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset_LM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReset_LMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReset_LMMouseExited(evt);
            }
        });
        btnReset_LM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_LMActionPerformed(evt);
            }
        });

        cbMaLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaLuongActionPerformed(evt);
            }
        });

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane6.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPLuongLayout = new javax.swing.GroupLayout(jPLuong);
        jPLuong.setLayout(jPLuongLayout);
        jPLuongLayout.setHorizontalGroup(
            jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLuongLayout.createSequentialGroup()
                .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLuongLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPCCV_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongCB_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPCK_BL)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPLuongLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnAddLuong_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnUpdate_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnDelete_BL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnReset_LM, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
            .addGroup(jPLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtThongTinBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPLuongLayout.setVerticalGroup(
            jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLuongLayout.createSequentialGroup()
                .addComponent(txtThongTinBangLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLuongLayout.createSequentialGroup()
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtLuongCB_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPCCV_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPLuongLayout.createSequentialGroup()
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPCK_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLuongLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(62, 62, 62))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71)
                .addGroup(jPLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddLuong_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset_LM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete_BL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jPLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bảng lương", jPanel2);

        txtBangTinhLuong.setBackground(new java.awt.Color(0, 153, 153));
        txtBangTinhLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBangTinhLuong.setText("Bảng tính lương");
        txtBangTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBangTinhLuongActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setText("Tháng");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setText("Năm");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        tbl_BTL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbl_BTL);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        btnXuatFile_BTL.setText("Xuất file");
        btnXuatFile_BTL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatFile_BTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXuatFile_BTLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXuatFile_BTLMouseExited(evt);
            }
        });
        btnXuatFile_BTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFile_BTLActionPerformed(evt);
            }
        });

        btnReset_BTL.setText("Làm mới");
        btnReset_BTL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset_BTL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReset_BTLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReset_BTLMouseExited(evt);
            }
        });
        btnReset_BTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_BTLActionPerformed(evt);
            }
        });

        cbThang_BTL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbThang_BTL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbThang_BTL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbNam_BTL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbNam_BTL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016" }));
        cbNam_BTL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbNam_BTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNam_BTLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBangLuongLayout = new javax.swing.GroupLayout(jPBangLuong);
        jPBangLuong.setLayout(jPBangLuongLayout);
        jPBangLuongLayout.setHorizontalGroup(
            jPBangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBangLuongLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel16)
                .addGap(28, 28, 28)
                .addComponent(cbThang_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(cbNam_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnReset_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnXuatFile_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(jPBangLuongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBangTinhLuong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBangLuongLayout.setVerticalGroup(
            jPBangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBangLuongLayout.createSequentialGroup()
                .addComponent(txtBangTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPBangLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(cbThang_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile_BTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bảng tính lương", jPanel3);

        txtThayDoiBangLuong.setBackground(new java.awt.Color(0, 153, 153));
        txtThayDoiBangLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtThayDoiBangLuong.setText("Thay đổi bảng lương");
        txtThayDoiBangLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThayDoiBangLuongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Mã nhân viên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Tên nhân viên");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Mã lương");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setText("Mã lương mới");

        txtMaLuong_TDBL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtMaLuong_TDBL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenNhanVien_TDBL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenNhanVien_TDBL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbl_TDBL.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbl_TDBL);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        btnUpdate_TDBL.setText("Thay đổi");
        btnUpdate_TDBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate_TDBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdate_TDBLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdate_TDBLMouseExited(evt);
            }
        });
        btnUpdate_TDBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate_TDBLActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Lý do");

        txtLyDo_TDBL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtLyDo_TDBL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtLyDo_TDBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLyDo_TDBLActionPerformed(evt);
            }
        });

        cbMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPTDBLLayout = new javax.swing.GroupLayout(jPTDBL);
        jPTDBL.setLayout(jPTDBLLayout);
        jPTDBLLayout.setHorizontalGroup(
            jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTDBLLayout.createSequentialGroup()
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPTDBLLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtThayDoiBangLuong)))
                    .addGroup(jPTDBLLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(btnUpdate_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPTDBLLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtLyDo_TDBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(txtTenNhanVien_TDBL, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMaNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMaLuongMoi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaLuong_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(188, 188, 188))
        );
        jPTDBLLayout.setVerticalGroup(
            jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTDBLLayout.createSequentialGroup()
                .addComponent(txtThayDoiBangLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPTDBLLayout.createSequentialGroup()
                        .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTenNhanVien_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPTDBLLayout.createSequentialGroup()
                        .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMaLuong_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cbMaLuongMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(jPTDBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLyDo_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnUpdate_TDBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPTDBL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPTDBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thay đổi bảng lương", jPanel7);

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

    private void txtThongTinBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThongTinBangLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThongTinBangLuongActionPerformed

    private void btnAddLuong_BLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddLuong_BLMouseEntered
        btnAddLuong_BL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnAddLuong_BLMouseEntered

    private void btnAddLuong_BLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddLuong_BLMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnAddLuong_BLMouseExited

    private void btnUpdate_BLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_BLMouseEntered
        btnUpdate_BL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnUpdate_BLMouseEntered

    private void btnUpdate_BLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_BLMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnUpdate_BLMouseExited

    private void btnDelete_BLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete_BLMouseEntered
        btnDelete_BL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnDelete_BLMouseEntered

    private void btnDelete_BLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete_BLMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnDelete_BLMouseExited

    private void btnReset_LMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_LMMouseEntered
       btnReset_LM.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnReset_LMMouseEntered

    private void btnReset_LMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_LMMouseExited
       setWhiteColor();
    }//GEN-LAST:event_btnReset_LMMouseExited

    private void btnDelete_BLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_BLActionPerformed
        // TODO add your handling code here:
        String maLuong = cbMaLuong.getSelectedItem().toString();
        if(maLuong.equals("")){
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa chọn mã lương muốn xóa!");
        }else{
            try{
                // Hiển thị hộp thoại xác nhận
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa mã lương này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                // Kiểm tra phản hồi của người dùng
                if (confirm == JOptionPane.YES_OPTION) {
                    // Thực hiện hành động xóa
                    luongDAO.xoaLuong(maLuong);

                    //Load data
                    LuongList = luongDAO.getLuongList();
                    loadDataToTableLuong(LuongList);
                    loadDataToCB_MALUONG();

                    //reset form
                    Phantichthietkehethong_nhom4.resetForm(jPLuong);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Nhập lương và phụ cấp là 1 số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "SQL error: Mã lương này đang được sử dụng!", "Database Error", JOptionPane.ERROR_MESSAGE);
            }catch(Exception j){
                JOptionPane.showMessageDialog(null, "Error: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelete_BLActionPerformed

    private void txtThayDoiBangLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThayDoiBangLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThayDoiBangLuongActionPerformed

    private void btnUpdate_TDBLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_TDBLMouseEntered
       btnUpdate_TDBL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnUpdate_TDBLMouseEntered

    private void btnUpdate_TDBLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_TDBLMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnUpdate_TDBLMouseExited

    private void btnUpdate_TDBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate_TDBLActionPerformed
        // TODO add your handling code here:
        if(Phantichthietkehethong_nhom4.kiemTraRong(jPTDBL)){
            String maNV = cbMaNV.getSelectedItem().toString();
            String maLuongCu = txtMaLuong_TDBL.getText();
            String maLuongMoi = cbMaLuongMoi.getSelectedItem().toString();
            String lyDo = txtLyDo_TDBL.getText();
            tdblDAO.addTDBL(maNV, maLuongCu, maLuongMoi,lyDo);
            JOptionPane.showMessageDialog(null, "Thay đổi thành công!");
            //resetForm & load data
            tdblList = tdblDAO.getTDBL_List();
            loadDataToTableTDBL(tdblList);
        }else{
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa nhập đủ thông tin!");
        }
    }//GEN-LAST:event_btnUpdate_TDBLActionPerformed

    private void txtLyDo_TDBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLyDo_TDBLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLyDo_TDBLActionPerformed

    private void txtBangTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBangTinhLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBangTinhLuongActionPerformed

    private void btnXuatFile_BTLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatFile_BTLMouseEntered
        btnXuatFile_BTL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnXuatFile_BTLMouseEntered

    private void btnXuatFile_BTLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatFile_BTLMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnXuatFile_BTLMouseExited

    private void btnReset_BTLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_BTLMouseEntered
        btnReset_BTL.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnReset_BTLMouseEntered

    private void btnReset_BTLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_BTLMouseExited
      setWhiteColor();
    }//GEN-LAST:event_btnReset_BTLMouseExited

    private void btnReset_BTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_BTLActionPerformed
        // TODO add your handling code here:
//        Phantichthietkehethong_nhom4.resetForm(jPBangLuong);
        tinhLuongList = tlDAO.getTinhLuongList(Integer.parseInt((String) cbThang_BTL.getSelectedItem()), Integer.parseInt((String) cbNam_BTL.getSelectedItem()));
        loadDataToTableTinhLuong(tinhLuongList);
    }//GEN-LAST:event_btnReset_BTLActionPerformed

    private void cbNam_BTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNam_BTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNam_BTLActionPerformed

    private void btnXuatFile_BTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFile_BTLActionPerformed
        Xuatfile_BangCong xfbc = new Xuatfile_BangCong();
        xfbc.setLocationRelativeTo(null);
        xfbc.setResizable(false);
        xfbc.setVisible(true);
    }//GEN-LAST:event_btnXuatFile_BTLActionPerformed

    private void cbMaLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaLuongActionPerformed
        // TODO add your handling code here:
        if(cbMaLuong.getSelectedItem().toString().equals("")){
            Phantichthietkehethong_nhom4.resetForm(jPLuong);
        }else{
            String maLuong = cbMaLuong.getSelectedItem().toString();
            Model.Luong luong = luongDAO.getLuongByMaLuong(maLuong);
            txtLuongCB_BL.setText(String.valueOf(luong.getLuongCoBan()));
            txtPCCV_BL.setText(String.valueOf(luong.getPhuCapCV()));
            txtPCK_BL.setText(String.valueOf(luong.getPhuCapKhac()));
            txtGhiChu.setText(luong.getGhiChu());
        }
    }//GEN-LAST:event_cbMaLuongActionPerformed

    private void btnReset_LMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_LMActionPerformed
        // TODO add your handling code here:
        Phantichthietkehethong_nhom4.resetForm(jPLuong);
        txtGhiChu.setText("");
        txtThongTinBangLuong.setText("Thông tin bảng lương");
    }//GEN-LAST:event_btnReset_LMActionPerformed

    private void clickToGetDataLuong(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToGetDataLuong
        // TODO add your handling code here:
        int row = tbl_TTBL.getSelectedRow();
        if(row>=0){
            cbMaLuong.setSelectedItem(tbl_TTBL.getValueAt(row, 0).toString());
            txtLuongCB_BL.setText(tbl_TTBL.getValueAt(row, 1).toString());
            txtPCCV_BL.setText(tbl_TTBL.getValueAt(row, 2).toString());
            txtPCK_BL.setText(tbl_TTBL.getValueAt(row, 3).toString());
            txtGhiChu.setText(tbl_TTBL.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_clickToGetDataLuong

    private void btnAddLuong_BLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLuong_BLActionPerformed
        // TODO add your handling code here:
        if(Phantichthietkehethong_nhom4.kiemTraRong(jPLuong,cbMaLuong)){
            try{
                int luongCB = Integer.parseInt(txtLuongCB_BL.getText());
                int phuCapCV = Integer.parseInt(txtPCCV_BL.getText());
                int phuCapKhac = Integer.parseInt(txtPCK_BL.getText());
                String ghiChu = txtGhiChu.getText();

                luongDAO.themLuong(luongCB, phuCapCV, phuCapKhac, ghiChu);
                JOptionPane.showMessageDialog(null, "Thêm thành công!");

                //load data
                LuongList = luongDAO.getLuongList();
                loadDataToTableLuong(LuongList);
                loadDataToCB_MALUONG();
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Nhập lương và phụ cấp là 1 số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "SQL error: ", "Database Error", JOptionPane.ERROR_MESSAGE);
            }catch(Exception j){
                JOptionPane.showMessageDialog(null, "Error: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa nhập đủ thông tin!");
        }
    }//GEN-LAST:event_btnAddLuong_BLActionPerformed

    private void btnUpdate_BLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate_BLActionPerformed
        if(!"".equals(txtGhiChu.getText()) && Phantichthietkehethong_nhom4.kiemTraRong(jPLuong)){
            try{
                String maLuong = cbMaLuong.getSelectedItem().toString();

                int luongCB = Integer.parseInt(txtLuongCB_BL.getText());
                int phuCapCV = Integer.parseInt(txtPCCV_BL.getText());
                int phuCapKhac = Integer.parseInt(txtPCK_BL.getText());
                String ghiChu = txtGhiChu.getText();

                luongDAO.suaLuong(maLuong,luongCB, phuCapCV, phuCapKhac, ghiChu);
                JOptionPane.showMessageDialog(null, "Update thành công!");
                
                
                //Load data
                LuongList = luongDAO.getLuongList();
                loadDataToTableLuong(LuongList);
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Nhập lương và phụ cấp là 1 số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "SQL error: ", "Database Error", JOptionPane.ERROR_MESSAGE);
            }catch(Exception j){
                JOptionPane.showMessageDialog(null, "Error: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa nhập đủ thông tin!");
        }
    }//GEN-LAST:event_btnUpdate_BLActionPerformed

    private void cbMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaNVActionPerformed
        // TODO add your handling code here:
        String maNV = cbMaNV.getSelectedItem().toString();
        Model.NhanVien nv = nvDAO.getNVByMaNV(maNV);
        
        txtTenNhanVien_TDBL.setText(nv.getHoTen());
        txtMaLuong_TDBL.setText(nv.getMaLuong());
    }//GEN-LAST:event_cbMaNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnAddLuong_BL;
    private util.ButtonGradient btnDelete_BL;
    private util.ButtonGradient btnReset_BTL;
    private util.ButtonGradient btnReset_LM;
    private util.ButtonGradient btnUpdate_BL;
    private util.ButtonGradient btnUpdate_TDBL;
    private util.ButtonGradient btnXuatFile_BTL;
    private javax.swing.JComboBox<String> cbMaLuong;
    private javax.swing.JComboBox<String> cbMaLuongMoi;
    private javax.swing.JComboBox<String> cbMaNV;
    private javax.swing.JComboBox<String> cbNam_BTL;
    private javax.swing.JComboBox<String> cbThang_BTL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPBangLuong;
    private javax.swing.JPanel jPLuong;
    private javax.swing.JPanel jPTDBL;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tbl_BTL;
    private javax.swing.JTable tbl_TDBL;
    private javax.swing.JTable tbl_TTBL;
    public static javax.swing.JTextField txtBangTinhLuong;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtLuongCB_BL;
    private javax.swing.JTextField txtLyDo_TDBL;
    private javax.swing.JTextField txtMaLuong_TDBL;
    private javax.swing.JTextField txtPCCV_BL;
    private javax.swing.JTextField txtPCK_BL;
    private javax.swing.JTextField txtTenNhanVien_TDBL;
    public static javax.swing.JTextField txtThayDoiBangLuong;
    public static javax.swing.JTextField txtThongTinBangLuong;
    // End of variables declaration//GEN-END:variables
}
