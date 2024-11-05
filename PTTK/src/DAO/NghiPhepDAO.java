/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NghiPhep;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class NghiPhepDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String GET_NP_LIST = "SELECT * FROM tbl_NghiPhep";
    private static final String DUYET_NP = "UPDATE tbl_NghiPhep SET trangThai = 'Đã xác nhận' WHERE maNghiPhep = ?";
    private static final String TU_CHOI_NP = "UPDATE tbl_NghiPhep SET trangThai = 'Không đồng ý' WHERE maNghiPhep = ?";
    private static final String DELETE_NP = "DELETE FROM tbl_NghiPhep WHERE maNghiPhep = ?";
    private static final String ADD_NP = "INSERT INTO tbl_NghiPhep VALUES (NULL,?,?,?,?,?,'Chưa xác nhận')";
    private static final String GET_SO_NGAY_NGHI_PHEP = "SELECT COUNT(*) AS SoNgayNghi FROM tbl_LSVangMat WHERE maNV = ? AND MONTH(ngayNghi) = ? AND YEAR(ngayNghi) = ?;";
    
    public int getSoNgayNghiPhep(String maNV, int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(GET_SO_NGAY_NGHI_PHEP)){
            pst.setString(1, maNV);
            pst.setInt(2, thang);
            pst.setInt(3, nam);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                int soNgayNghiPhep = result.getInt("SoNgayNghi");
                return soNgayNghiPhep;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public void themNghiPhep(String maNV,String hoTen,String lyDo,Date ngayBatDau,Date ngayKetThuc) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_NP)){
            pst.setString(1, maNV);
            pst.setString(2, hoTen);
            pst.setString(3, lyDo);
            pst.setDate(4, ngayBatDau);
            pst.setDate(5, ngayKetThuc);
            
            pst.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void xoaNghiPhep(String maNghiPhep){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_NP)){
            pst.setString(1, maNghiPhep);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void duyetNghiPhep(int maNP){
        try(PreparedStatement pst  = connection.prepareStatement(DUYET_NP)){
            pst.setInt(1, maNP);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void tuChoiNghiPhep(int maNP){
        try(PreparedStatement pst  = connection.prepareStatement(TU_CHOI_NP)){
            pst.setInt(1, maNP);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<NghiPhep> getNPList(){
        try(Statement stm  = connection.createStatement()){
            List<NghiPhep> NPList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_NP_LIST);
            while(result.next()){
                NghiPhep np = new NghiPhep();
                np.setMaNghiPhep(result.getInt("maNghiPhep"));
                np.setMaNV(result.getString("MaNV"));
                np.setHoTen(result.getString("hoTen"));
                np.setLyDo(result.getString("lyDo"));
                np.setNgayBatDau(result.getDate("ngayBatDau"));
                np.setNgayKetThuc(result.getDate("ngayKetThuc"));
                np.setTrangThai(result.getString("trangThai"));
                
                NPList.add(np);
            }
            
            return NPList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Model.NghiPhep> getNPListByMaNV(String maNV){
        try{
            List<Model.NghiPhep> NPList = getNPList();
            List<Model.NghiPhep> NPListOfMaNV = new ArrayList<>();
            for(Model.NghiPhep np: NPList){
                if(np.getMaNV().equals(maNV))
                    NPListOfMaNV.add(np);
            }
            return NPListOfMaNV;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Model.NghiPhep getNPByMaNV(String maNV){
        try{
            List<Model.NghiPhep> NPList = getNPList();
            for(Model.NghiPhep np: NPList){
                if(np.getMaNV().equals(maNV))
                    return np;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
}
