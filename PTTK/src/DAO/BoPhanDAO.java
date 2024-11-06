/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.BoPhan;
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
public class BoPhanDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String ADD_BP = "INSERT INTO tbl_BoPhan (maBP, tenBP, ngayTLap, ghiChu) VALUES (null,?,NOW(),?)".toLowerCase();
    private static final String UPDATE_BP = "UPDATE tbl_BoPhan SET tenBP = ?, ghiChu = ? WHERE maBP = ?".toLowerCase();
    private static final String GET_BP_LIST = "SELECT * FROM tbl_BoPhan".toLowerCase();
    private static final String GET_MA_BP_LIST = "SELECT maBP FROM tbl_BoPhan".toLowerCase();
    private static final String GET_BP_BY_MABP = "SELECT * FROM tbl_BoPhan where maBP = ?".toLowerCase();
    private static final String VALID_TENBP = "SELECT * FROM tbl_BoPhan where tenBP = ?".toLowerCase();
    
    
    public void themBP(String tenBP, String ghiChu){
        try(PreparedStatement pst = connection.prepareStatement(ADD_BP)){
            pst.setString(1, tenBP);
            pst.setString(2, ghiChu);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void suaBP(String maBP,String tenBP,String ghiChu){
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_BP)){
            pst.setString(1, tenBP);
            pst.setString(2, ghiChu);
            pst.setString(3, maBP);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<BoPhan> getBPList(){
        try(Statement stm = connection.createStatement()){
            List<BoPhan> BPList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_BP_LIST);
            
            while(result.next()){
                String maBP = result.getString("maBP");
                String tenBP = result.getString("tenBP");
                Date ngayTLap = result.getDate("ngayTLap");
                String ghiChu = result.getString("ghiChu");
                
                BoPhan bp = new BoPhan(maBP,tenBP,ngayTLap,ghiChu);
                BPList.add(bp);
            }
            
            return BPList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<String> getMaBPList(){
        try(Statement stm = connection.createStatement()){
            List<String> maBPList = new ArrayList<>();
//            maBPList.add("");
            ResultSet result = stm.executeQuery(GET_MA_BP_LIST);
            
            while(result.next()){
                String maBP = result.getString("maBP");
                maBPList.add(maBP);
            }
            
            return maBPList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getMaBPByTenBP(String tenBPInput){
        try(Statement stm = connection.createStatement()){
            List<BoPhan> BPList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_BP_LIST);
            
            while(result.next()){
                String maBP = result.getString("maBP");
                String tenBP = result.getString("tenBP");
                Date ngayTLap = result.getDate("ngayTLap");
                String ghiChu = result.getString("ghiChu");
                
                BoPhan bp = new BoPhan(maBP,tenBP,ngayTLap,ghiChu);
                BPList.add(bp);
            }
            
            for(Model.BoPhan bp:BPList){
                if(bp.getTenBP().equals(tenBPInput)){
                    return bp.getMaBP();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Model.BoPhan getBoPhanByMaBP(String maBPInput){
        try(PreparedStatement pst = connection.prepareStatement(GET_BP_BY_MABP)){
            pst.setString(1,maBPInput);

            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maBP = result.getString("maBP");
                String tenBP = result.getString("tenBP");
                Date ngayTLap = result.getDate("ngayTLap");
                String ghiChu = result.getString("ghiChu");
                
                BoPhan bp = new BoPhan(maBP,tenBP,ngayTLap,ghiChu);
                return bp;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean isTenBPExists(String tenBP){
        try(PreparedStatement pst = connection.prepareStatement(VALID_TENBP)){
            pst.setString(1, tenBP);
            
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
