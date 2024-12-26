/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Quanly;

import DAO.DuAnDAO;
import DAO.NVDAO;
import DAO.PCongDADAO;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import PTPM_NHOM18.PTPM_NHOM18;

/**
 *
 * @author Admin
 */
public class DuAn extends javax.swing.JPanel {

    /**
     * Creates new form DuAn
     */
    
    private final DuAnDAO daDAO;
    private final PCongDADAO pcDAO;
    private List<Model.DuAn> DAList;
    
    public DuAn() {
        initComponents();    
        daDAO = new DuAnDAO();
        pcDAO = new PCongDADAO();
        
        //Load data lên bảng
        DAList = daDAO.getDAList();
        loadDataToTableDA(DAList);
        
        //Load data vào combo box mã DA
        loadMaBPToCB_MaDA();
        
        //Load data vào combo box DA
        loadTenDAToCB_DA();
        
        //Load data vào combo box NV
        loadTenNVToCB_DA();
        
        safetySelectedCB(cbMaDA);
        
        
        loadDataToTablePC_DA(daDAO.getNVInDA(cbDuAn.getSelectedItem().toString()));
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
        btnAdd_DA.setForeground(Color.white);
        btnDelete_DA.setForeground(Color.white);
        btnUpdate_DA.setForeground(Color.white);
        btnReset_DA.setForeground(Color.white);
        btnAdd_PC.setForeground(Color.white);
        btnCancel_PC.setForeground(Color.white);
        btnReset_PC.setForeground(Color.white);
    }
    
    private void loadTenDAToCB_DA(){
        //Load tên dự án vào cb dự án
        List<String> tenDAList = new ArrayList<>();
        tenDAList = daDAO.getTenDAChuaHTList();
        DefaultComboBoxModel<String> model_bp = new DefaultComboBoxModel<>(tenDAList.toArray(new String[0]));
        cbDuAn.setModel(model_bp);
    }
    
    private void loadTenNVToCB_DA(){
        List<String> tenNVList = new ArrayList<>();
        String tenDA = cbDuAn.getSelectedItem().toString();
        tenNVList = daDAO.getNVNotInDA(tenDA);
        DefaultComboBoxModel<String> model_bp = new DefaultComboBoxModel<>(tenNVList.toArray(new String[0]));
        cbNhanVien.setModel(model_bp);
    }
    
    private void loadDataToTableDA(List<Model.DuAn> DAList){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã dự án");
        dtm.addColumn("Tên dự án");
        dtm.addColumn("Địa điểm");
        dtm.addColumn("Giá");
        dtm.addColumn("Hoa Hồng");
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
        tbl_QuanLyDuAn.setModel(dtm);
    }
    
    private void loadDataToTablePC_DA(String[][] data){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã dự án");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Tên nhân viên");
        dtm.addColumn("SDT");
        dtm.addColumn("Ngày phân công");
        
        Object[] row = new Object[5];
        for(int i=0;i<data.length;i++){
            row[0] = data[i][0];
            row[1] = data[i][1];
            row[2] = data[i][2];
            row[3] = data[i][3];
            row[4] = data[i][4];

            
            dtm.addRow(row);
        }
        tbl_PhanCongDuAN.setModel(dtm);
    }
    
    private void loadMaBPToCB_MaDA(){
        //Load mã bộ phận vào combo box DA
        List<String> maDAList = new ArrayList<>();
        maDAList = daDAO.getMaDAList();
        DefaultComboBoxModel<String> model_bp = new DefaultComboBoxModel<>(maDAList.toArray(new String[0]));
        cbMaDA.setModel(model_bp);
    }
    
    private Model.DuAn getDuAnByMaDA(String maDA,List<Model.DuAn> DAList){
        for(Model.DuAn da: DAList){
            if(da.getMaDA().equals(maDA))
                return da;
        }
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelGradient1 = new util.PanelGradient();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPQLDuAn = new javax.swing.JPanel();
        txtQuanLyDuAn = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_QuanLyDuAn = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenDuAn = new javax.swing.JTextField();
        txtDiaDiem = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        txtHoaHong = new javax.swing.JTextField();
        cbk_HoanThan_DA = new javax.swing.JCheckBox();
        btnUpdate_DA = new util.ButtonGradient();
        btnAdd_DA = new util.ButtonGradient();
        btnDelete_DA = new util.ButtonGradient();
        btnReset_DA = new util.ButtonGradient();
        cbMaDA = new javax.swing.JComboBox<>();
        cbk_ChuaTK_DA = new javax.swing.JCheckBox();
        cbk_DangTK_DA = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        chooserNgayBatDau = new com.toedter.calendar.JDateChooser();
        chooserNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPPC_DA = new javax.swing.JPanel();
        txtPhanCongDuAn = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_PhanCongDuAN = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnCancel_PC = new util.ButtonGradient();
        btnAdd_PC = new util.ButtonGradient();
        btnReset_PC = new util.ButtonGradient();
        cbDuAn = new javax.swing.JComboBox<>();
        cbNhanVien = new javax.swing.JComboBox<>();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N

        txtQuanLyDuAn.setBackground(new java.awt.Color(0, 153, 153));
        txtQuanLyDuAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQuanLyDuAn.setText("Quản lý dự án");
        txtQuanLyDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuanLyDuAnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_QuanLyDuAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_QuanLyDuAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToGetDataDA(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_QuanLyDuAn);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
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

        txtTenDuAn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTenDuAn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDiaDiem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtDiaDiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtGia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHoaHong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtHoaHong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtHoaHong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoaHongActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbk_HoanThan_DA);
        cbk_HoanThan_DA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbk_HoanThan_DA.setText("Hoàn thành");

        btnUpdate_DA.setText("Cập nhật dự án");
        btnUpdate_DA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate_DA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdate_DAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdate_DAMouseExited(evt);
            }
        });
        btnUpdate_DA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate_DAActionPerformed(evt);
            }
        });

        btnAdd_DA.setText("Thêm dự án");
        btnAdd_DA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd_DA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdd_DAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdd_DAMouseExited(evt);
            }
        });
        btnAdd_DA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_DAActionPerformed(evt);
            }
        });

        btnDelete_DA.setText("Xóa dự án");
        btnDelete_DA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete_DA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDelete_DAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDelete_DAMouseExited(evt);
            }
        });
        btnDelete_DA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_DAActionPerformed(evt);
            }
        });

        btnReset_DA.setText("Làm mới");
        btnReset_DA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset_DA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReset_DAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReset_DAMouseExited(evt);
            }
        });
        btnReset_DA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_DAActionPerformed(evt);
            }
        });

        cbMaDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaDAActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbk_ChuaTK_DA);
        cbk_ChuaTK_DA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbk_ChuaTK_DA.setText("Chưa triển khai");

        buttonGroup1.add(cbk_DangTK_DA);
        cbk_DangTK_DA.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbk_DangTK_DA.setText("Đang triển khai");
        cbk_DangTK_DA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbk_DangTK_DAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        chooserNgayBatDau.setDateFormatString("yyyy-MM-dd");

        chooserNgayKetThuc.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPQLDuAnLayout = new javax.swing.GroupLayout(jPQLDuAn);
        jPQLDuAn.setLayout(jPQLDuAnLayout);
        jPQLDuAnLayout.setHorizontalGroup(
            jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPQLDuAnLayout.createSequentialGroup()
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPQLDuAnLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuanLyDuAn)))
                    .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPQLDuAnLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAdd_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(btnDelete_DA, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(101, 101, 101)
                            .addComponent(btnUpdate_DA, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93)
                            .addComponent(btnReset_DA, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48))
                        .addGroup(jPQLDuAnLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7)
                                .addComponent(jLabel1))
                            .addGap(40, 40, 40)
                            .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPQLDuAnLayout.createSequentialGroup()
                                        .addGap(557, 557, 557)
                                        .addComponent(txtHoaHong, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPQLDuAnLayout.createSequentialGroup()
                                        .addGap(485, 485, 485)
                                        .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbk_DangTK_DA)
                                            .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(145, 145, 145)))
                                .addGroup(jPQLDuAnLayout.createSequentialGroup()
                                    .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPQLDuAnLayout.createSequentialGroup()
                                            .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtDiaDiem, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                                .addComponent(txtGia))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbk_HoanThan_DA))
                                        .addGroup(jPQLDuAnLayout.createSequentialGroup()
                                            .addComponent(cbMaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6))
                                        .addGroup(jPQLDuAnLayout.createSequentialGroup()
                                            .addComponent(txtTenDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(90, 90, 90)
                                            .addComponent(jLabel3))
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbk_ChuaTK_DA)
                                    .addGap(18, 18, 18))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPQLDuAnLayout.setVerticalGroup(
            jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPQLDuAnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtQuanLyDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtHoaHong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3)
                        .addComponent(txtTenDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(txtDiaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbk_HoanThan_DA)
                    .addComponent(cbk_ChuaTK_DA)
                    .addComponent(cbk_DangTK_DA))
                .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPQLDuAnLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPQLDuAnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPQLDuAnLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dự án", jPQLDuAn);

        txtPhanCongDuAn.setBackground(new java.awt.Color(0, 153, 153));
        txtPhanCongDuAn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPhanCongDuAn.setText("Phân công dự án");
        txtPhanCongDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhanCongDuAnActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbl_PhanCongDuAN.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_PhanCongDuAN);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Dự án");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Nhân viên");

        btnCancel_PC.setText("Hủy phân công");
        btnCancel_PC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancel_PC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancel_PCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancel_PCMouseExited(evt);
            }
        });
        btnCancel_PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel_PCActionPerformed(evt);
            }
        });

        btnAdd_PC.setText("Thêm phân công");
        btnAdd_PC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdd_PC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdd_PCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdd_PCMouseExited(evt);
            }
        });
        btnAdd_PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_PCActionPerformed(evt);
            }
        });

        btnReset_PC.setText("Làm mới");
        btnReset_PC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReset_PC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReset_PCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReset_PCMouseExited(evt);
            }
        });
        btnReset_PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_PCActionPerformed(evt);
            }
        });

        cbDuAn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbDuAn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbDuAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickToUpdateData(evt);
            }
        });
        cbDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDuAnActionPerformed(evt);
            }
        });

        cbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbNhanVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPC_DALayout = new javax.swing.GroupLayout(jPPC_DA);
        jPPC_DA.setLayout(jPPC_DALayout);
        jPPC_DALayout.setHorizontalGroup(
            jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPC_DALayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(btnAdd_PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnCancel_PC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnReset_PC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(jPPC_DALayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel12)
                .addGap(38, 38, 38)
                .addComponent(cbDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(50, 50, 50)
                .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPC_DALayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhanCongDuAn, javax.swing.GroupLayout.DEFAULT_SIZE, 1074, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPPC_DALayout.setVerticalGroup(
            jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPC_DALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPhanCongDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cbDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPPC_DALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset_PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel_PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd_PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPPC_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPPC_DA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Phân công dự án", jPanel2);

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

    private void txtQuanLyDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuanLyDuAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuanLyDuAnActionPerformed

    private void btnDelete_DAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_DAActionPerformed
        // TODO add your handling code here:
        if(cbMaDA.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa chọn dự án muốn xóa!");
        }else{
            String trangThai="";
            if(cbk_ChuaTK_DA.isSelected()){
                trangThai = "Chưa triển khai";
            }if(cbk_DangTK_DA.isSelected()){
                trangThai = "Đang triển khai";
            }if(cbk_HoanThan_DA.isSelected()){
                trangThai = "Hoàn thành";
            }
            
            if(!"Đang triển khai".equalsIgnoreCase(trangThai)){
                String maDA = cbMaDA.getSelectedItem().toString();
                
                // Hiển thị hộp thoại xác nhận
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa dự án này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                // Kiểm tra phản hồi của người dùng
                if (confirm == JOptionPane.YES_OPTION) {
                    // Thực hiện hành động xóa
                    daDAO.xoaDuAn(maDA);
                    DAList = daDAO.getDAList();
                    loadDataToTableDA(DAList);
                    loadMaBPToCB_MaDA();
                    loadTenDAToCB_DA();
                    //resetForm
                    PTPM_NHOM18.resetForm(jPQLDuAn);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Dự án đang triển khai, không thể xóa!");

            }   
        }
    }//GEN-LAST:event_btnDelete_DAActionPerformed

    private void btnAdd_DAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd_DAMouseEntered
        btnAdd_DA.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnAdd_DAMouseEntered

    private void btnAdd_DAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd_DAMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnAdd_DAMouseExited

    private void btnDelete_DAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete_DAMouseEntered
        btnDelete_DA.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnDelete_DAMouseEntered

    private void btnDelete_DAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelete_DAMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnDelete_DAMouseExited

    private void btnUpdate_DAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_DAMouseEntered
        btnUpdate_DA.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnUpdate_DAMouseEntered

    private void btnUpdate_DAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdate_DAMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnUpdate_DAMouseExited

    private void btnReset_DAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_DAMouseEntered
        btnReset_DA.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnReset_DAMouseEntered

    private void btnReset_DAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_DAMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnReset_DAMouseExited

    private void txtPhanCongDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhanCongDuAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhanCongDuAnActionPerformed

    private void btnCancel_PCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancel_PCMouseEntered
        btnCancel_PC.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnCancel_PCMouseEntered

    private void btnCancel_PCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancel_PCMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnCancel_PCMouseExited

    private void btnAdd_PCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd_PCMouseEntered
        btnAdd_PC.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnAdd_PCMouseEntered

    private void btnAdd_PCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd_PCMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnAdd_PCMouseExited

    private void btnReset_PCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_PCMouseEntered
        btnReset_PC.setForeground(new Color(51, 0, 153));
    }//GEN-LAST:event_btnReset_PCMouseEntered

    private void btnReset_PCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReset_PCMouseExited
        setWhiteColor();
    }//GEN-LAST:event_btnReset_PCMouseExited

    private void btnReset_DAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_DAActionPerformed
        // TODO add your handling code here:
        PTPM_NHOM18.resetForm(jPQLDuAn);
        txtQuanLyDuAn.setText("Quản lý dự án");
    }//GEN-LAST:event_btnReset_DAActionPerformed

    private void btnUpdate_DAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate_DAActionPerformed
        // TODO add your handling code here:
        if(PTPM_NHOM18.kiemTraRong(jPQLDuAn)){
            try{
                String tenDA = txtTenDuAn.getText();
                String diaDiem = txtDiaDiem.getText();
                int gia = Integer.parseInt(txtGia.getText());
                int hoaHong = Integer.parseInt(txtHoaHong.getText());
                Date ngayBatDau = new Date(chooserNgayBatDau.getDate().getTime());
                Date ngayKetThuc = new Date(chooserNgayKetThuc.getDate().getTime());
                String trangThai="";
                if(cbk_ChuaTK_DA.isSelected()){
                    trangThai = "Chưa triển khai";
                }if(cbk_DangTK_DA.isSelected()){
                    trangThai = "Đang triển khai";
                }if(cbk_HoanThan_DA.isSelected()){
                    trangThai = "Hoàn thành";
                }
                String maDA = cbMaDA.getSelectedItem().toString();

                daDAO.suaDuAn(tenDA, diaDiem, gia, hoaHong, ngayBatDau, ngayKetThuc, trangThai,maDA);
                JOptionPane.showMessageDialog(null, "Update thành công!");


                //Load data
                DAList = daDAO.getDAList();
                loadDataToTableDA(DAList);
                loadDataToTablePC_DA(daDAO.getNVInDA(cbDuAn.getSelectedItem().toString()));
                loadTenDAToCB_DA();
                loadTenDAToCB_DA();
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Nhập giá và hoa hồng là 1 số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage() + "SQL error: \n", "Database Error", JOptionPane.ERROR_MESSAGE);
            }catch(IllegalArgumentException m){
                    JOptionPane.showMessageDialog(null, "Error: ngày tháng chưa đúng định dạng!", "Error", JOptionPane.ERROR_MESSAGE);
            }catch(Exception j){
                JOptionPane.showMessageDialog(null, "Error: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa điền đầy đủ thông tin!");
        }
    }//GEN-LAST:event_btnUpdate_DAActionPerformed

    private void btnAdd_DAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_DAActionPerformed
        // TODO add your handling code here:
        if(PTPM_NHOM18.kiemTraRong(jPQLDuAn,cbMaDA)){
//            String maDA = cbMaDA.getSelectedItem().toString();
            String tenDA = txtTenDuAn.getText();
            String diaDiem = txtDiaDiem.getText();
            int gia;
            int hoaHong;
            Date ngayBatDau;
            Date ngayKetThuc;
            String trangThai = "Chưa triển khai";
            
            if(daDAO.isTenDaExists(tenDA, DAList)){
                try{
                    gia = Integer.parseInt(txtGia.getText());
                    hoaHong = Integer.parseInt(txtHoaHong.getText());
                    ngayBatDau = new Date(chooserNgayBatDau.getDate().getTime());
                    ngayKetThuc = new Date(chooserNgayKetThuc.getDate().getTime());
                    
                    daDAO.themDuAn(tenDA, diaDiem, gia, hoaHong, ngayBatDau, ngayKetThuc, trangThai);
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    
                    DAList = daDAO.getDAList();
                    loadDataToTableDA(DAList);
                    loadMaBPToCB_MaDA();
                    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Error: Nhập giá và hoa hồng là 1 số!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage() + "SQL error: \n", "Database Error", JOptionPane.ERROR_MESSAGE);
                }catch(IllegalArgumentException m){
                    JOptionPane.showMessageDialog(null, "Error: ngày tháng chưa đúng định dạng!", "Error", JOptionPane.ERROR_MESSAGE);
                }catch(Exception j){
                    JOptionPane.showMessageDialog(null, "Error: " + j.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(panelGradient1, "Tên dự án đã tồn tại!");
            }
        }else{
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa điền đầy đủ thông tin!");
        }
        
    }//GEN-LAST:event_btnAdd_DAActionPerformed

    private void cbk_DangTK_DAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbk_DangTK_DAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbk_DangTK_DAActionPerformed

    private void cbMaDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaDAActionPerformed
        // TODO add your handling code here:
        String maDA = cbMaDA.getSelectedItem().toString();
        if(maDA.equals("")){
            
        }else{
            Model.DuAn da = getDuAnByMaDA(maDA, DAList);
            cbMaDA.setSelectedItem(da.getMaDA());
            txtTenDuAn.setText(da.getTenDA());
            txtDiaDiem.setText(da.getDiaDiem());
            txtGia.setText(String.valueOf(da.getGia()));
            txtHoaHong.setText(String.valueOf(da.getHoaHong()));
            chooserNgayBatDau.setDate(da.getNgayBatDau());
            chooserNgayKetThuc.setDate(da.getNgayKetThuc());
            switch (da.getTrangThai()) {
                case "Hoàn thành":
                    cbk_HoanThan_DA.setSelected(true);
                    break;
                case "Đang triển khai":
                    cbk_DangTK_DA.setSelected(true);
                    break;
                case "Chưa triển khai":
                    cbk_ChuaTK_DA.setSelected(true);
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_cbMaDAActionPerformed

    private void clickToGetDataDA(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToGetDataDA
        // TODO add your handling code here:
        int row = tbl_QuanLyDuAn.getSelectedRow();
        if(row>=0){
            cbMaDA.setSelectedItem(tbl_QuanLyDuAn.getValueAt(row, 0).toString());
            txtTenDuAn.setText(tbl_QuanLyDuAn.getValueAt(row, 1).toString());
            txtDiaDiem.setText(tbl_QuanLyDuAn.getValueAt(row, 2).toString());
            txtGia.setText(tbl_QuanLyDuAn.getValueAt(row, 3).toString());
            txtHoaHong.setText(tbl_QuanLyDuAn.getValueAt(row, 4).toString());
            chooserNgayBatDau.setDate((Date)tbl_QuanLyDuAn.getValueAt(row, 5));
            chooserNgayKetThuc.setDate((Date)tbl_QuanLyDuAn.getValueAt(row, 6));
            if(tbl_QuanLyDuAn.getValueAt(row, 7).toString().equals("Hoàn thành")){
                cbk_HoanThan_DA.setSelected(true);
            }else if(tbl_QuanLyDuAn.getValueAt(row, 7).toString().equals("Đang triển khai")){
                cbk_DangTK_DA.setSelected(true);
            }else if(tbl_QuanLyDuAn.getValueAt(row, 7).toString().equals("Chưa triển khai")){
                cbk_ChuaTK_DA.setSelected(true);
            }
        }
    }//GEN-LAST:event_clickToGetDataDA

    private void cbDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDuAnActionPerformed
        // TODO add your handling code here:
        loadTenNVToCB_DA();
        
        loadDataToTablePC_DA(daDAO.getNVInDA(cbDuAn.getSelectedItem().toString()));
    }//GEN-LAST:event_cbDuAnActionPerformed

    private void btnReset_PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_PCActionPerformed
        // TODO add your handling code here:
        PTPM_NHOM18.resetForm(jPPC_DA);
        txtPhanCongDuAn.setText("Phân công dự án");
    }//GEN-LAST:event_btnReset_PCActionPerformed

    private void btnAdd_PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_PCActionPerformed
        // TODO add your handling code here:
        if(cbDuAn.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa chọn dự án!");
        }else{
            if(cbNhanVien.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(panelGradient1, "Bạn chưa chọn nhân viên muốn phân công!");
            }else{
                String tenNV = cbNhanVien.getSelectedItem().toString();
                NVDAO nvDAO = new NVDAO();
                String maNV = nvDAO.getMANVByTenNV(tenNV);
                
                String tenDA = cbDuAn.getSelectedItem().toString();
                DuAnDAO daDAO = new DuAnDAO();
                String maDA = daDAO.getMaDAByTenDA(tenDA);
                
                PCongDADAO pcDAO = new PCongDADAO();
                pcDAO.themPhanCongDA(maDA, tenDA, maNV);
                
                JOptionPane.showMessageDialog(null, "Thêm thành công!");

                
                loadTenNVToCB_DA();
                loadDataToTablePC_DA(daDAO.getNVInDA(cbDuAn.getSelectedItem().toString()));
            }
        }
    }//GEN-LAST:event_btnAdd_PCActionPerformed

    private void cbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNhanVienActionPerformed

    private void btnCancel_PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel_PCActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_PhanCongDuAN.getSelectedRow();
        if(selectedRow != -1){
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            // Kiểm tra phản hồi của người dùng
            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện hành động xóa
                String maDA = (String) tbl_PhanCongDuAN.getValueAt(selectedRow, 0);
                String maNV = (String) tbl_PhanCongDuAN.getValueAt(selectedRow, 1);

                pcDAO.xoaPC(maDA, maNV);
                
                loadTenNVToCB_DA();
                loadDataToTablePC_DA(daDAO.getNVInDA(cbDuAn.getSelectedItem().toString()));
            }
        }
    }//GEN-LAST:event_btnCancel_PCActionPerformed

    private void clickToUpdateData(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickToUpdateData
        // TODO add your handling code here:
        loadTenDAToCB_DA();
    }//GEN-LAST:event_clickToUpdateData

    private void txtHoaHongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoaHongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoaHongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.ButtonGradient btnAdd_DA;
    private util.ButtonGradient btnAdd_PC;
    private util.ButtonGradient btnCancel_PC;
    private util.ButtonGradient btnDelete_DA;
    private util.ButtonGradient btnReset_DA;
    private util.ButtonGradient btnReset_PC;
    private util.ButtonGradient btnUpdate_DA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDuAn;
    private javax.swing.JComboBox<String> cbMaDA;
    private javax.swing.JComboBox<String> cbNhanVien;
    private javax.swing.JCheckBox cbk_ChuaTK_DA;
    private javax.swing.JCheckBox cbk_DangTK_DA;
    private javax.swing.JCheckBox cbk_HoanThan_DA;
    private com.toedter.calendar.JDateChooser chooserNgayBatDau;
    private com.toedter.calendar.JDateChooser chooserNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPPC_DA;
    private javax.swing.JPanel jPQLDuAn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private util.PanelGradient panelGradient1;
    private javax.swing.JTable tbl_PhanCongDuAN;
    private javax.swing.JTable tbl_QuanLyDuAn;
    private javax.swing.JTextField txtDiaDiem;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtHoaHong;
    public static javax.swing.JTextField txtPhanCongDuAn;
    public static javax.swing.JTextField txtQuanLyDuAn;
    private javax.swing.JTextField txtTenDuAn;
    // End of variables declaration//GEN-END:variables
}
