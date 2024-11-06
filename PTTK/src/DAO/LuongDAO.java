/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Luong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a cao anh
 */
public class LuongDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String GET_LUONG_LIST = "SELECT * FROM tbl_Luong".toLowerCase();
    private static final String ADD_LUONG = "INSERT INTO tbl_Luong VALUES (null,?,?,?,?)".toLowerCase();
    private static final String UPDATE_LUONG = "UPDATE tbl_Luong SET luongCoBan = ?,phuCapCV = ?,phuCapKhac = ?,ghiChu = ? WHERE maLuong = ?".toLowerCase();
    private static final String DELETE_LUONG = "DELETE FROM tbl_Luong WHERE maLuong = ?".toLowerCase();
    private static final String GET_LUONG_BY_MANV = "SELECT l.maLuong ,luongCoBan,phuCapCV,phuCapKhac,l.ghiChu FROM tbl_Luong l JOIN tbl_NhanVien nv ON l.maLuong = nv.maLuong WHERE maNV = ?; ".toLowerCase();
    
    public void themLuong(int luongCB,int phuCapCV,int phuCapKhac,String ghiChu) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_LUONG)){
            pst.setInt(1, luongCB);
            pst.setInt(2, phuCapCV);
            pst.setInt(3, phuCapKhac);
            pst.setString(4, ghiChu);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public void suaLuong(String maLuong,int luongCB,int phuCapCV,int phuCapKhac,String ghiChu) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_LUONG)){
            pst.setInt(1, luongCB);
            pst.setInt(2, phuCapCV);
            pst.setInt(3, phuCapKhac);
            pst.setString(4, ghiChu);
            pst.setString(5, maLuong);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public void xoaLuong(String maLuong) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(DELETE_LUONG)){
            pst.setString(1, maLuong);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public List<String> getMaLuongList(){
        try{
            List<String> maLuongList = new ArrayList<>();
            List<Model.Luong> LuongList = new ArrayList<>();
            LuongList = getLuongList();
//            maLuongList.add("");
            for(Model.Luong luong: LuongList){
                maLuongList.add(luong.getMaLuong());
            }
            return maLuongList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Model.Luong getLuongByMaLuong(String maLuong){
        try{
            Model.Luong Luong = new Luong();
            List<Model.Luong> LuongList = new ArrayList<>();
            LuongList = getLuongList();
            for(Model.Luong luong: LuongList){
                if(luong.getMaLuong().equals(maLuong)){
                    return luong;
                }
            }
            return Luong;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Model.Luong> getLuongList(){
        try(PreparedStatement pst = connection.prepareStatement(GET_LUONG_LIST)){
            ResultSet result = pst.executeQuery();
            List<Model.Luong> LuongList = new ArrayList<>();
            while(result.next()){
                Model.Luong luong = new Luong();
                luong.setMaLuong(result.getString("maLuong"));
                luong.setLuongCoBan(result.getInt("luongCoBan"));
                luong.setPhuCapCV(result.getInt("phuCapCV"));
                luong.setPhuCapKhac(result.getInt("phuCapKhac"));
                luong.setGhiChu(result.getString("ghiChu"));
                
                LuongList.add(luong);
            }
            return LuongList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Model.Luong getLuongByMaNV(String maNV){
        try(PreparedStatement pst = connection.prepareStatement(GET_LUONG_BY_MANV)){
            pst.setString(1, maNV);
            ResultSet result = pst.executeQuery();
            Luong luong ;
            while(result.next()){
                String maLuong = result.getString("maLuong");
                int luongCoBan = result.getInt("luongCoBan");
                int phuCapCV = result.getInt("phuCapCV");
                int phuCapKhac = result.getInt("phuCapKhac");
                String ghiChu = result.getString("ghiChu");
                luong = new Luong(maLuong, luongCoBan, phuCapCV, phuCapKhac, ghiChu);
                
                return luong;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
