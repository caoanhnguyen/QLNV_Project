/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ThoiViec;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class ThoiViecDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String GET_THOIVIEC_LIST = "SELECT * FROM tbl_ThoiViec".toLowerCase();
    private static final String GET_SO_NV_BY_TIME = "SELECT COUNT(*) FROM tbl_ThoiViec WHERE ngayThoiViec >= DATE_FORMAT(CONCAT(?, '-', ?, '-01'), '%Y-%m-%d');".toLowerCase();
   
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
        
    public List<Model.ThoiViec> getThoiViecList(){
        try(PreparedStatement pst = connection.prepareStatement(GET_THOIVIEC_LIST)){
            ResultSet result = pst.executeQuery();
            List<Model.ThoiViec> thoiViecList = new ArrayList<>();
            while(result.next()){
                String maNV = result.getString("maNV");
                String hoTen = result.getString("hoTen");
                Date ngayThoiViec = result.getDate("ngayThoiViec");
                String lyDo = result.getString("lyDo");
                
                Model.ThoiViec tv = new ThoiViec(maNV, hoTen, ngayThoiViec, lyDo);
                thoiViecList.add(tv);
            }
            return thoiViecList;
        }catch(Exception e){
            e.printStackTrace();
        }return null;
    }
}
