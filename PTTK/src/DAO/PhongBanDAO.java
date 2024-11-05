/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhongBan;
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
public class PhongBanDAO {
    private static final Connection connection = DBManager.getConnection();
    private static final String ADD_PB = "INSERT INTO tbl_PhongBan VALUES (null,?,?,NOW(),?)";
    private static final String UPDATE_PB = "UPDATE tbl_PhongBan set tenPB = ?, ghiChu = ? where maPB = ?";
    private static final String GET_PB_LIST = "SELECT * FROM tbl_PhongBan";
    private static final String GET_MA_PB_LIST = "SELECT maPB FROM tbl_PhongBan";
    private static final String GET_PB_BY_MAPB = "SELECT * FROM tbl_PhongBan where maPB = ?";
    private static final String VALID_TENPB = "SELECT * FROM tbl_PhongBan where tenPB = ?";
    private static final String GET_MAPB_BY_TENPB = "SELECT maPB FROM tbl_PhongBan WHERE tenPB = ?";
    private static final String GET_TENPB_BY_MANV = "SELECT tenPB FROM tbl_NhanVien nv JOIN tbl_PhongBan pb ON nv.maPB = pb.maPB WHERE maNV = ?;";
    private static final String GET_TENPB_BY_MAPB = "SELECT tenPB FROM tbl_PhongBan where maPB = ?";
    
    public String getTenPBByMaPB(String maPB){
        try (PreparedStatement pst = connection.prepareStatement(GET_TENPB_BY_MAPB)){
            pst.setString(1, maPB);
            
            ResultSet result = pst.executeQuery();
            result.next();
            String tenPB = result.getString("tenPB");
            return tenPB;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getTenPhongBanByMaNV(String maNV){
        try(PreparedStatement pst = connection.prepareStatement(GET_TENPB_BY_MANV)){
            pst.setString(1,maNV);

            ResultSet result = pst.executeQuery();
            while(result.next()){
                String tenPB = result.getString("tenPB");
                return tenPB ;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void themPB(String maBP,String tenPB,String ghiChu_PB){
        try(PreparedStatement pst = connection.prepareStatement(ADD_PB)){
            pst.setString(1, maBP);
            pst.setString(2, tenPB);
            pst.setString(3, ghiChu_PB);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void suaPB(String tenPB,String ghiChu, String maPB) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_PB)){
            pst.setString(1, tenPB);
            pst.setString(2, ghiChu);
            pst.setString(3, maPB);
            
            pst.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    
    public String getMaPBByTenPB(String tenPB){
        try(PreparedStatement pst = connection.prepareStatement(GET_MAPB_BY_TENPB)){
            String maPB = "";
            pst.setString(1, tenPB);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                maPB = result.getString("maPB");
            }
            return maPB;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<PhongBan> getPBList(){
        try(Statement stm = connection.createStatement()){
            List<PhongBan> PBList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_PB_LIST);
            
            while(result.next()){
                String maPB = result.getString("maPB");
                String maBP = result.getString("maBP");
                String tenPB = result.getString("tenPB");
                Date ngayTLap = result.getDate("ngayTLap");
                String ghiChu = result.getString("ghiChu");
                
                PhongBan pb = new PhongBan(maPB,maBP,tenPB,ngayTLap,ghiChu);
                PBList.add(pb);
            }
            
            return PBList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getMaPBList(){
        try(Statement stm = connection.createStatement()){
            List<String> maPBList = new ArrayList<>();
//            maPBList.add("");
            ResultSet result = stm.executeQuery(GET_MA_PB_LIST);
            
            while(result.next()){
                String maPB = result.getString("maPB");
                maPBList.add(maPB);
            }
            
            return maPBList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    public List<String> getTenPBList(){
        try{
            List<Model.PhongBan> pbList = getPBList();
            List<String> tenPBList = new ArrayList<>();
            for(Model.PhongBan pb: pbList){
                tenPBList.add(pb.getTenPB());
            }
            return tenPBList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getTenPBListByMaBP(String maBP){
        try{
            List<Model.PhongBan> pbList = getPBList();
            List<String> tenPBList = new ArrayList<>();
            
            for(Model.PhongBan pb: pbList){
                if(pb.getMaBP().equals(maBP)){
                    
                    tenPBList.add(pb.getTenPB());
                }
            }
            return tenPBList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getMaPBListByMaBP(String maBP){
        try{
            List<Model.PhongBan> PBList = getPBList();
            List<String> maPBList = new ArrayList<>();
//            maPBList.add("");
            for(Model.PhongBan pb: PBList){
                if(pb.getMaBP().equals(maBP)){
                    maPBList.add(pb.getMaPB());
                }
            }
            return maPBList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public PhongBan getPhongBanByMaPB(String maPBInput){
        try(PreparedStatement pst = connection.prepareStatement(GET_PB_BY_MAPB)){
            pst.setString(1,maPBInput);

            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maPB = result.getString("maPB");
                String maBP = result.getString("maBP");
                String tenPB = result.getString("tenPB");
                Date ngayTLap = result.getDate("ngayTLap");
                String ghiChu = result.getString("ghiChu");
                
                PhongBan pb = new PhongBan(maPB,maBP,tenPB,ngayTLap,ghiChu);
                return pb;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean isTenPBExists(String tenPB){
        try(PreparedStatement pst = connection.prepareStatement(VALID_TENPB)){
            pst.setString(1, tenPB);
            
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}   
