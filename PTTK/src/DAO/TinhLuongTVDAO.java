/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LuongTV;
import Model.TinhLuongTV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YENMC
 */
public class TinhLuongTVDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String GET_LIST_TINHLUONGTV = "SELECT * FROM tbl_TinhLuongTV ".toLowerCase();
    private static final String ADD_TINHLUONGTV = "INSERT INTO tbl_TinhLuongTV VALUES(?,?,?,?,?,?,?,?,?)".toLowerCase();
    private static final String GET_LIST_TLTV_BY_THANG_NAM = "SELECT * FROM tbl_TinhLuongTV WHERE thang =? and nam = ? ".toLowerCase();
    private static final String UPDATE_TINHLUONGTV ="UPDATE tbl_TinhLuongTV SET soNgayCong = ?,soGioLamThem = ?,ghiChu = ?,luongThucNhan = ? WHERE maNVTV = ? and thang = ? and nam = ? ".toLowerCase();
    private static final String DELETE_TINHLUONGTV = "DELETE FROM tbl_TinhLuongTV WHERE maNVTV =? and thang =? and nam = ?".toLowerCase();
    
    public List<TinhLuongTV> getListTinhLuongTV(){
        try(Statement stm = connection.createStatement()){
            List<TinhLuongTV> TLList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_LIST_TINHLUONGTV);
            while(result.next()){
                String maNVTV = result.getString("maNVTV");
                String maLuongTV = result.getString("maLuongTV");
                int luongTV = result.getInt("luongTV");
                int thang = result.getInt("thang");
                int nam = result.getInt("nam");
                int soNgayCong = result.getInt("soNgayCong");
                int soGioLamThem = result.getInt("soGioLamThem");
                int luongThucNhan = result.getInt("luongThucNhan");
                String ghiChu = result.getString("ghiChu");
                LuongTV ltv = new LuongTV(maLuongTV, luongTV, ghiChu);
                TinhLuongTV tltv = new TinhLuongTV(maNVTV, ltv, thang, nam, soNgayCong, soGioLamThem, luongThucNhan, ghiChu);
                TLList.add(tltv);
            }
            return TLList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void UpdateTinhLuongTV(int soNgayCong, int soGioThem, String ghiChu,String maNVTV,int thang, int nam, int luongThucNhan) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_TINHLUONGTV)){
            pst.setInt(1, soNgayCong);
            pst.setInt(2, soGioThem);
            pst.setString(3, ghiChu);
            pst.setInt(4, luongThucNhan);
            pst.setString(5, maNVTV);
            pst.setInt(6, thang);
            pst.setInt(7, nam);
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public List<TinhLuongTV> getListTinhLuongTVByThangNam(int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(GET_LIST_TLTV_BY_THANG_NAM)){
            List<TinhLuongTV> TLList = new ArrayList<>();
            pst.setInt(1, thang);
            pst.setInt(2, nam);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maNVTV = result.getString("maNVTV");
                String maLuongTV = result.getString("maLuongTV");
                int luongTV = result.getInt("luongTV");
                int soNgayCong = result.getInt("soNgayCong");
                int soGioLamThem = result.getInt("soGioLamThem");
                int luongThucNhan = result.getInt("luongThucNhan");
                String ghiChu = result.getString("ghiChu");
                LuongTV ltv = new LuongTV(maLuongTV, luongTV, ghiChu);
                TinhLuongTV tltv = new TinhLuongTV(maNVTV, ltv, thang, nam, soNgayCong, soGioLamThem, luongThucNhan, ghiChu);
                TLList.add(tltv);
            }
            return TLList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addTinhLuongTV(String maNVTV,String maLuongTV,int thang,int nam,int luongTV,int soNgayCong,int soGioLamThem,int luongThucNhan,String ghiChu) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_TINHLUONGTV)){
            pst.setString(1,maNVTV );
            pst.setString(2, maLuongTV);
            pst.setString(3, String.valueOf(thang));
            pst.setString(4, String.valueOf(nam));
            pst.setString(5, String.valueOf(luongTV));
            pst.setString(6, String.valueOf(soNgayCong));
            pst.setString(7, String.valueOf(soGioLamThem));
            pst.setString(8, String.valueOf(luongThucNhan));
            pst.setString(9, ghiChu);
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public void delTinhLuongTV(String maNVTV,int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_TINHLUONGTV)){
            pst.setString(1,maNVTV );
            pst.setInt(2, thang);
            pst.setInt(3, nam);
            pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
