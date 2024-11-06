/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DuAn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a cao anh
 */
public class DuAnDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String ADD_DUAN = "INSERT INTO tbl_DuAn VALUES (null, ?,?,?,?,?,?,?)".toLowerCase();
    private static final String GET_MADA_BY_TENDA = "SELECT maDA FROM tbl_DuAn WHERE tenDA = ?".toLowerCase();
    private static final String GET_ADLIST = "SELECT * FROM tbl_DuAn".toLowerCase();
    private static final String GET_MA_DA_LIST = "SELECT maDA FROM tbl_DuAn".toLowerCase();
    private static final String GET_TEN_DA_LIST = "SELECT tenDA FROM tbl_DuAn".toLowerCase();
    private static final String DELETE_DA = "DELETE FROM tbl_DuAn WHERE maDA = ?".toLowerCase();
    private static final String UPDATE_DA = "UPDATE tbl_DuAn SET tenDA = ?,diaDiem = ?,gia = ?,hoaHong = ?,ngayBatDau = ?,ngayKetThuc = ?,trangThai = ? WHERE maDA = ?".toLowerCase();
    private static final String GET_NV_NOT_IN_DA = "select hoTen from tbl_nhanvien where maNV not in (select nv.maNV from tbl_NhanVien nv join tbl_phancongda pcda on nv.maNV = pcda.maNV where tenDA = ?);".toLowerCase();
    private static final String GET_NV_IN_DA = "select maDA,nv.maNV,hoTen,SDT,ngayPhanCong from tbl_nhanvien nv join tbl_phancongda pc on nv.maNV = pc.maNV where tenDA = ?;".toLowerCase();
    private static final String GET_COUNT_NV_IN_DA = "select count(*) from tbl_nhanvien nv join tbl_phancongda pc on nv.maNV = pc.maNV where tenDA = ?;".toLowerCase();
    private static final String GET_HOAHONG_BY_MANV = "SELECT SUM(hoaHong) AS tongHoaHong FROM tbl_DuAn AS da INNER JOIN tbl_PhanCongDA AS pc ON da.maDA = pc.maDA WHERE pc.maNV = ? and ngayKetThuc >= DATE_FORMAT(CONCAT(?, '-', ?, '-01'), '%Y-%m-%d') and ngayBatDau <= DATE_FORMAT(CONCAT(?, '-', ?, '-01'), '%Y-%m-%d');".toLowerCase();
    private static final String GET_DA_CHUA_HOAN_THANH = "select tenDA from tbl_duan where trangThai not in ('Hoàn thành');".toLowerCase();
    
    public int hoaHongNVInDA(String maNV,int nam,int thang){
        try(PreparedStatement pst = connection.prepareStatement(GET_HOAHONG_BY_MANV)){
            pst.setString(1, maNV);
            pst.setInt(2, nam);
            pst.setInt(3, thang);
            pst.setInt(4, nam);
            pst.setInt(5, thang);


            ResultSet result = pst.executeQuery();
            int hoaHong = 0;
            while(result.next()){
                hoaHong = result.getInt("tongHoaHong");
            }
            return hoaHong;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void themDuAn(String tenDA, String diaDiem, int gia,int hoaHong,Date ngayBatDau,Date ngayKetThuc,String trangThai) throws Exception{
        try(PreparedStatement stm = connection.prepareStatement(ADD_DUAN)){
            stm.setString(1, tenDA);
            stm.setString(2, diaDiem);
            stm.setInt(3, gia);
            stm.setInt(4, hoaHong);
            stm.setDate(5, ngayBatDau);
            stm.setDate(6, ngayKetThuc);
            stm.setString(7, trangThai);
            
            stm.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void suaDuAn(String tenDA,String diaDiem,int gia,int hoaHong,Date ngayBatDau,Date ngayKetThuc,String trangThai,String maDA) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_DA)){
            pst.setString(1, tenDA);
            pst.setString(2, diaDiem);
            pst.setInt(3, gia);
            pst.setInt(4, hoaHong);
            pst.setDate(5, ngayBatDau);
            pst.setDate(6, ngayKetThuc);
            pst.setString(7, trangThai);
            pst.setString(8, maDA);
            
            pst.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void xoaDuAn(String maDA){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_DA)){
            pst.setString(1, maDA);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String getMaDAByTenDA(String tenDA){
        try(PreparedStatement pst = connection.prepareStatement(GET_MADA_BY_TENDA)){
            pst.setString(1, tenDA);
            ResultSet result = pst.executeQuery();
            String maDA="";
            while(result.next()){
                maDA = result.getString("maDA");
            }
            return maDA;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<DuAn> getDAList(){
        try(PreparedStatement stm = connection.prepareStatement(GET_ADLIST)){
            List<DuAn> DAList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_ADLIST);
            
            while(result.next()){
                DuAn da = new DuAn();
                da.setMaDA(result.getString("maDA"));
                da.setTenDA(result.getString("tenDA"));
                da.setDiaDiem(result.getString("diaDiem"));
                da.setGia(result.getInt("gia"));
                da.setHoaHong(result.getInt("hoaHong"));
                da.setNgayBatDau(result.getDate("ngayBatDau"));
                da.setNgayKetThuc(result.getDate("ngayKetThuc"));
                da.setTrangThai(result.getString("trangThai"));
                
                DAList.add(da);
            }
            return DAList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Model.DuAn getDAByMaDA(String maDA){
        try{
            List<Model.DuAn> DAList = getDAList();
            for(Model.DuAn da: DAList){
                if(da.getMaDA().equals(maDA))
                    return da;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getMaDAList(){
        try(Statement stm = connection.createStatement()){
            List<String> maDAList = new ArrayList<>();
//            maDAList.add("");
            ResultSet result = stm.executeQuery(GET_MA_DA_LIST);
            
            while(result.next()){
                String maBP = result.getString("maDA");
                maDAList.add(maBP);
            }
            
            return maDAList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getTenDAList(){
        try(Statement stm = connection.createStatement()){
            List<String> tenDAList = new ArrayList<>();
            tenDAList.add("");
            ResultSet result = stm.executeQuery(GET_TEN_DA_LIST);
            
            while(result.next()){
                String maBP = result.getString("tenDA");
                tenDAList.add(maBP);
            }
            
            return tenDAList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getTenDAChuaHTList(){
        try(Statement stm = connection.createStatement()){
            List<String> tenDAList = new ArrayList<>();
            tenDAList.add("");
            ResultSet result = stm.executeQuery(GET_DA_CHUA_HOAN_THANH);
            
            while(result.next()){
                String maBP = result.getString("tenDA");
                tenDAList.add(maBP);
            }
            
            return tenDAList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getNVNotInDA(String tenDA){
        try(PreparedStatement pst = connection.prepareStatement(GET_NV_NOT_IN_DA)){
            List<String> tenNVList = new ArrayList<>();
            tenNVList.add("");
            
            pst.setString(1,tenDA);
            ResultSet result = pst.executeQuery();
            
            while(result.next()){
                String tenNV = result.getString("hoTen");
                tenNVList.add(tenNV);
            }
            
            return tenNVList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int countNVInDA(String tenDA){
        try(PreparedStatement pst = connection.prepareStatement(GET_COUNT_NV_IN_DA)){
            pst.setString(1, tenDA);
            ResultSet result = pst.executeQuery();
            int count=0;
            while(result.next()){
                count = result.getInt("count(*)");
            }
            return count;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public String[][] getNVInDA(String tenDA){
        try(PreparedStatement pst = connection.prepareStatement(GET_NV_IN_DA)){
            pst.setString(1, tenDA);
            ResultSet result = pst.executeQuery();
//            ResultSet result2 = pst.executeQuery();
            int count = countNVInDA(tenDA);
            String[][] data = new String[count][5];
            int i=0;
            while(result.next()){
                data[i][0] = result.getString("maDA");
                data[i][1] = result.getString("maNV");
                data[i][2] = result.getString("hoTen");
                data[i][3] = result.getString("SDT");
                data[i][4] = result.getDate("ngayPhanCong").toString();
                i++;
            }
            return data;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean isTenDaExists(String tenDA,List<Model.DuAn> DAList){
        for(Model.DuAn da: DAList){
            if(da.getTenDA().equals(tenDA)){
                return false;
            }
        }
        return true;
    }
}
