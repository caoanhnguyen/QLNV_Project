/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.LSChamCong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YENMC
 */
public class ChamCongDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String GET_SO_NGAY_CHAM_CONG = "SELECT COUNT(*) AS SoNgayChamCong FROM tbl_LSChamCong WHERE maNV = ? AND MONTH(ngayChamCong) = ? AND YEAR(ngayChamCong) = ?;";
    private static final String ADD_CC = "INSERT INTO tbl_LSChamCong VALUES (null,?,NOW())";
    private static final String CHECK_IN = "SELECT * FROM tbl_LSChamCong WHERE ngayChamCong = ? AND maNV = ?";
    
    public void addChamCong(String maNV){
        try(PreparedStatement pst = connection.prepareStatement(ADD_CC)){
            pst.setString(1, maNV);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Model.LSChamCong> checkCC(String ngayChamCong,String maNV){
        try(PreparedStatement pst = connection.prepareStatement(CHECK_IN)){
            pst.setString(1, ngayChamCong);
            pst.setString(2, maNV);
            ResultSet result = pst.executeQuery();
            
            List<Model.LSChamCong> lscc = new ArrayList<>();
            while(result.next()){
                Model.LSChamCong ls = new LSChamCong();
                ls.setMaLSChamCong(result.getString("maLSChamCong"));
                ls.setMaNV(result.getString("maNV"));
                ls.setNgayChamCong(result.getDate("ngayChamCong"));
                
                lscc.add(ls);
            }
            return lscc;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public int getSoNgayChamCong(String maNV, int thang, int nam){
        try(PreparedStatement pst = connection.prepareStatement(GET_SO_NGAY_CHAM_CONG)){
            pst.setString(1, maNV);
            pst.setInt(2, thang);
            pst.setInt(3, nam);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                int soNgayChamCong = result.getInt("SoNgayChamCong");
                return soNgayChamCong;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
