/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Luong;
import Model.TinhLuong;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;
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
public class TinhLuongDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String ADD_TINH_lUONG = "INSERT INTO tbl_TinhLuong VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
    private static final String GET_LIST_TINHLUONG = "SELECT * FROM tbl_TinhLuong";
    private static final String KTRA_TON_TAI = "SELECT * FROM tbl_TinhLuong WHERE maNV = ? AND thang = ? AND NAM = ?";
    private static final String GET_TINH_LUONG_LIST = "SELECT * FROM tbl_TinhLuong WHERE nam = ? and thang = ?";
    private static final String GET_AVG_LUONG = "SELECT AVG(luongThucNhan) from tbl_tinhLuong where nam = ? and thang = ?";
    
    public float getAVGLuong(int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(GET_AVG_LUONG)) {
            pst.setInt(1,nam);
            pst.setInt(2, thang);
            
            ResultSet result  = pst.executeQuery();
            result.next();
            float avg = result.getFloat(1);
            return avg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<Model.TinhLuong> getTinhLuongList(int thangInput,int namInput){
        List<Model.TinhLuong> tinhLuongList = new ArrayList<>();
        try(PreparedStatement pst = connection.prepareStatement(GET_TINH_LUONG_LIST)){
            pst.setInt(1, namInput);
            pst.setInt(2, thangInput);
            
            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maNV = result.getString("maNV");
                String maLuong = result.getString("maLuong");
                int thang = result.getInt("thang");
                int nam = result.getInt("nam");
                int luongCoBan = result.getInt("luongCoBan");
                int phuCapCV = result.getInt("phuCapCV");
                int phuCapKhac = result.getInt("phuCapKhac");
                int tienThuong = result.getInt("tienThuong");
                int tienKyLuat = result.getInt("tienKyLuat");
                int tienHoaHong = result.getInt("tienHoaHong");
                int soNgayCong = result.getInt("soNgayCong");
                int luongThucNhan = result.getInt("luongThucNhan");
                String ghiChu = result.getString("ghiChu");
                
                Luong luong = new Luong(maLuong, luongCoBan, phuCapCV, phuCapKhac, ghiChu);
                TinhLuong tl = new TinhLuong(maNV, luong, thang, nam, tienThuong, tienKyLuat, tienHoaHong, soNgayCong, luongThucNhan,ghiChu);
                
                tinhLuongList.add(tl);
            }
            return tinhLuongList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void them_Tinh_Luong(String maNV, Luong luong, int thang, int nam, int tienThuong, int tienKyLuat, int tienHoaHong,
			int soNgayCong, int luongThucNhan,String ghiChu){
        try(PreparedStatement pst = connection.prepareStatement(ADD_TINH_lUONG)){
            pst.setString(1, maNV);
            pst.setString(2,luong.getMaLuong() );
            pst.setInt(3,thang );
            pst.setInt(4,nam );
            pst.setInt(5,luong.getLuongCoBan() );
            pst.setInt(6,luong.getPhuCapCV() );
            pst.setInt(7,luong.getPhuCapKhac() );
            pst.setInt(8,tienThuong );
            pst.setInt(9,tienKyLuat );
            pst.setInt(10, tienHoaHong);
            pst.setInt(11,soNgayCong );
            pst.setInt(12,luongThucNhan );
            pst.setString(13,ghiChu);
            pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean kiemTraTonTai(String maNV, int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(KTRA_TON_TAI)){
            pst.setString(1, maNV);
            pst.setInt(2, thang);
            pst.setInt(3, nam);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return true;
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<TinhLuong> getListTinhLuong(){
        try(Statement stm = connection.createStatement()){
            List<TinhLuong> TLList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_LIST_TINHLUONG);
            while(result.next()){
                String maNV = result.getString("maNV");
                String maLuong = result.getString("maLuong");
                int thang = result.getInt("thang");
                int nam = result.getInt("nam");
                int luongCoBan = result.getInt("luongCoBan");
                int phuCapCV = result.getInt("phuCapCV");
                int phuCapKhac = result.getInt("phuCapKhac");
                int tienThuong = result.getInt("tienThuong");
                int tienKyLuat = result.getInt("tienKyLuat");
                int tienHoaHong = result.getInt("tienHoaHong");
                int soNgayCong = result.getInt("soNgayCong");
                int luongThucNhan = result.getInt("luongThucNhan");
                String ghiChu = result.getString("ghiChu");
                Luong luong = new Luong(maLuong, luongCoBan, phuCapCV, phuCapKhac, "");
                TinhLuong tl = new TinhLuong(maNV, luong, thang, nam, tienThuong, tienKyLuat, tienHoaHong, soNgayCong, luongThucNhan,ghiChu);
                TLList.add(tl);
            }
            return TLList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
