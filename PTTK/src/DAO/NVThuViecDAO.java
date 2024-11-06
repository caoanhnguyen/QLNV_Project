/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.HoSoThuViec;
import Model.TinhLuongTV;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a Cao Anh
 */
public class NVThuViecDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String GET_NVTV_LIST = "SELECT * FROM tbl_HoSoThuViec".toLowerCase();
    private static final String DELETE_NVTV = "DELETE FROM tbl_HoSoThuViec WHERE maNVTV = ?".toLowerCase();
    private static final String ADD_NVTV = "INSERT INTO tbl_HoSoThuViec VALUES (null,?,?,?,?,?,NOW(),?,?,?,?,?)".toLowerCase();
    private static final String GET_LIST_MANVTV = "SELECT maNVTV FROM tbl_HoSoThuViec".toLowerCase();
    private static final String GET_LUONGTV_BY_MANVTV = "SELECT LuongTV FROM tbl_HoSoThuViec hstv JOIN tbl_LuongTV ltv ON hstv.maLuongTV = ltv.maLuongTV WHERE maNVTV = ?;".toLowerCase();
    private static final String GET_MALUONGTV_BY_MANVTV = "SELECT hstv.maLuongTV FROM tbl_HoSoThuViec hstv JOIN tbl_LuongTV ltv ON hstv.maLuongTV = ltv.maLuongTV WHERE maNVTV = ?;".toLowerCase();
    private static final String GET_SO_NV_BY_TIME = "SELECT COUNT(*) FROM tbl_HoSoThuViec WHERE ngayBatDau >= DATE_FORMAT(CONCAT(?, '-', ?, '-01'), '%Y-%m-%d');".toLowerCase();
    private static final String UPDATE_NVTV = "UPDATE tbl_HoSoThuViec SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, CMND_CCCD = ?, viTriThuViec = ?, soThangThuViec = ?, SDT = ?, hocVan = ?, maLuongTV = ?, ghiChu = ? WHERE maNVTV = ?;".toLowerCase();
    
    
    public void updateNVTV(String hoTen,Date ngaySinh,String gioiTinh,String CCCD,String viTri,int soThangTV,String SDT,String hocVan,String maLuongTV,String ghiChu,String maNVTV) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_NVTV)){
            pst.setString(1, hoTen);
            pst.setDate(2, ngaySinh);
            pst.setString(3, gioiTinh);
            pst.setString(4, CCCD);
            pst.setString(5, viTri);
            pst.setInt(6, soThangTV);
            pst.setString(7, SDT);
            pst.setString(8, hocVan);
            pst.setString(9, maLuongTV);
            pst.setString(10, ghiChu);
            pst.setString(11, maNVTV);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public int getSoNVTVByTime(int nam,int thang){
        try(PreparedStatement pst = connection.prepareStatement(GET_SO_NV_BY_TIME)) {
            pst.setInt(1, nam);
            pst.setInt(2, thang);
            
            ResultSet result = pst.executeQuery();
            result.next();
            int soNV = result.getInt(1);
            return soNV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<TinhLuongTV> getListTinhLuongTV(){
        try(Statement stm = connection.createStatement()){
            List<TinhLuongTV> TLList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_NVTV_LIST);
            while(result.next()){
                String maNVTV = result.getString("maNVTV");
                String maLuongTV = result.getString("maLuongTV");
                int thang = result.getInt("thang");
                int nam = result.getInt("nam");
                int luongTV = result.getInt("luongTV");
                int soNgayCong = result.getInt("soNgayCong");
                int luongThucNhan = result.getInt("luongThucNhan");
                String ghiChu = result.getString("ghiChu");
            }
            return TLList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<String> getListMaNVTV(){
        try(Statement stm = connection.createStatement()){
            List<String> ListMaNVTV = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_NVTV_LIST);
            while(result.next()){
                String maNVTV;
                maNVTV = result.getString("maNVTV");
                ListMaNVTV.add(maNVTV);
                
            }
            return ListMaNVTV;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int getLuongTVByMaNVTV(String maNVTV){
        try(PreparedStatement pst = connection.prepareStatement(GET_LUONGTV_BY_MANVTV)){
            pst.setString(1, maNVTV);
            int luong = 0 ;
            ResultSet result = pst.executeQuery();
            while(result.next()){
                luong = result.getInt("LuongTV");
            }
            return luong;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public String getMaLuongTVByMaNVTV(String maNVTV){
        try(PreparedStatement pst = connection.prepareStatement(GET_MALUONGTV_BY_MANVTV)){
            pst.setString(1, maNVTV);
            String maLuongTV ="" ;
            ResultSet result = pst.executeQuery();
            while(result.next()){
                maLuongTV = result.getString("maLuongTV");
            }
            return maLuongTV;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void addNVTV(String hoTen,Date ngaySinh,String gioiTinh,String CCCD,String viTriTV,int soThangTV,String SDT,String hocVan,String maLuongTV,String ghiChu) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_NVTV)){
            pst.setString(1, hoTen);
            pst.setDate(2, ngaySinh);
            pst.setString(3, gioiTinh);
            pst.setString(4, CCCD);
            pst.setString(5, viTriTV);
            pst.setInt(6, soThangTV);
            pst.setString(7, SDT);
            pst.setString(8, hocVan);
            pst.setString(9, maLuongTV);
            pst.setString(10, ghiChu);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteNVTV(String maNVTV){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_NVTV)){
            pst.setString(1, maNVTV);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Model.HoSoThuViec> getNVTVList(){
        try(PreparedStatement pst = connection.prepareStatement(GET_NVTV_LIST)){
            ResultSet result = pst.executeQuery();
            List<Model.HoSoThuViec> NVTV_List = new ArrayList<>();
            while(result.next()){
                String maNVTV = result.getString("maNVTV");
                String hoTen = result.getString("hoTen");
                Date ngaySinh = result.getDate("ngaySinh");
                String gioiTinh = result.getString("gioiTinh");
                String CMND_CCCD = result.getString("CMND_CCCD");
                String viTriThuViec = result.getString("viTriThuViec");
                Date ngayBatDau = result.getDate("ngayBatDau");
                int soThangThuViec = result.getInt("soThangThuViec");
                String SDT = result.getString("SDT");
                String hocVan = result.getString("hocVan");
                String maLuongTV = result.getString("maLuongTV");
                String ghiChu = result.getString("ghiChu");
                
                Model.HoSoThuViec tv = new HoSoThuViec(maNVTV, hoTen, ngaySinh, gioiTinh, CMND_CCCD, viTriThuViec, ngayBatDau, soThangThuViec, SDT, hocVan, maLuongTV, ghiChu);
                NVTV_List.add(tv);
            }
            return NVTV_List;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
