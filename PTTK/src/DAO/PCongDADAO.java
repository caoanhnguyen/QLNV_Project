/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.DuAn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class PCongDADAO {
    private static Connection connection = DBManager.getConnection();
    private static final String ADD_PC_DA = "INSERT INTO tbl_PhanCongDA VALUES (?,?,?,NOW())".toLowerCase();
    private static final String DELETE_PC_DA = "DELETE FROM tbl_PhanCongDA WHERE maDA =? and maNV = ?".toLowerCase();
    private static final String GET_DA_BY_MANV = "select pc.maNV, da.maDA, da.tenDA, diaDiem, gia, hoaHong, ngayBatDau, ngayKetThuc, trangThai from tbl_DuAn da left join tbl_PhanCongDA pc on da.maDA = pc.maDA where maNV = ?".toLowerCase();
    
    public void themPhanCongDA(String maDA,String tenDA,String maNV){
        try(PreparedStatement pst = connection.prepareStatement(ADD_PC_DA)){
            pst.setString(1, maDA);
            pst.setString(2, tenDA);
            pst.setString(3, maNV);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void xoaPC(String maDA,String maNV){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_PC_DA)){
            pst.setString(1, maDA);
            pst.setString(2, maNV);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Model.DuAn> getDAByMaNV(String maNV){
        try(PreparedStatement pst = connection.prepareStatement(GET_DA_BY_MANV)){
            pst.setString(1, maNV);
            List<Model.DuAn> DAList = new ArrayList<>();
            ResultSet result = pst.executeQuery();
            while(result.next()){
                Model.DuAn da = new DuAn();
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
    
}
