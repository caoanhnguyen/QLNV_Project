/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.BaoHiem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class BaoHiemDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String GET_BH_LIST = "SELECT * FROM tbl_BaoHiem";
    private static final String DELETE_BH = "DELETE FROM tbl_BaoHiem WHERE maBaoHiem = ?";
    private static final String UPDATE_BH = "UPDATE tbl_BaoHiem set noiCap = ?,ngayCap = ?, ghiChu = ? WHERE maBaoHiem = ?";
    private static final String ADD_BH = "INSERT INTO tbl_BaoHiem VALUES (NULL,?,?,?,?)";
    
    public void themBaoHiem(String maNV,String noiCap,Date ngayCap,String ghiChu)throws SQLException{
        try(PreparedStatement pst = connection.prepareStatement(ADD_BH)){
            pst.setString(1, maNV);
            pst.setString(2, noiCap);
            pst.setString(3, ngayCap.toString());
            pst.setString(4, ghiChu);
            
            pst.executeUpdate();
        }catch(Exception e){
//            e.printStackTrace();
        }
    }
    
    public void updateBaoHiem(String noiCap,Date ngayCap,String ghiChu,String maBaoHiem)throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_BH)){
            pst.setString(1,noiCap);
            pst.setString(2,ngayCap.toString());
            pst.setString(3, ghiChu);
            pst.setString(4,maBaoHiem);
            
            pst.executeUpdate();
        
        }catch(Exception e){
            throw e;
        }
    }
    
    public void deleteBaoHiem(String maBaoHiem){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_BH)){
            pst.setString(1, maBaoHiem);
            pst.executeUpdate();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Model.BaoHiem getBaoHiemByMaBH(String maBH){
        try{
            List<Model.BaoHiem> BHList = getBaoHiemList();
            for(Model.BaoHiem bh: BHList){
                if(bh.getMaBaoHiem().equals(maBH))
                    return bh;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getMaBHList(){
        try{
            List<Model.BaoHiem> BHList = getBaoHiemList();
            List<String> maBHList = new ArrayList<>();
//            maBHList.add("");
            for(Model.BaoHiem bh: BHList){
                maBHList.add(bh.getMaBaoHiem());
            }
            return maBHList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Model.BaoHiem> getBaoHiemList(){
        try(PreparedStatement pst = connection.prepareStatement(GET_BH_LIST)){
            ResultSet result = pst.executeQuery();
            List<Model.BaoHiem> BHList = new ArrayList<>();
            while(result.next()){
                String maBaoHiem = result.getString("maBaoHiem");
                String maNV = result.getString("maNV");
                String noiCap = result.getString("noiCap");
                Date ngayCap = result.getDate("ngayCap");
                String ghiChu = result.getString("ghiChu");
                
                Model.BaoHiem bh = new BaoHiem(maBaoHiem, maNV, noiCap, ngayCap, ghiChu);
                BHList.add(bh);
            }
            return BHList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
