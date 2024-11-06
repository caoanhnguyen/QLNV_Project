/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.kyLuat;
import com.mysql.cj.protocol.Resultset;
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
public class KyLuatDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String ADD_KL = "INSERT INTO tbl_KyLuat (maKyLuat,tienKyLuat,lyDo) VALUES (null, ?,?);".toLowerCase();
    private static final String UPDATE_Kl = "UPDATE tbl_KyLuat SET tienKyLuat = ? , lyDo =? WHERE maKyLuat =?;".toLowerCase();
    private static final String DELETE_Kl = "DELETE FROM tbl_KyLuat WHERE maKyLuat =?".toLowerCase();
    private static final String GET_KL_BY_MAKL = "SELECT * FROM tbl_KyLuat WHERE maKyLuat = ?".toLowerCase();
    private static final String GET_LIST_MAKL = "SELECT maKyLuat FROM tbl_KyLuat".toLowerCase();
    private static final String GET_LIST_KL = "SELECT * FROM tbl_KyLuat".toLowerCase();
    private static final String VALID_LYDO = "SELECT * FROM tbl_KyLuat WHERE lyDo = ?".toLowerCase();
    
    public void themKyLuat(int tienKyLuat,String lyDo)throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_KL)){
            pst.setInt(1, tienKyLuat);
            pst.setString(2, lyDo);
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public void suaKyLuat (String maKyLuat,int tienKyLuat, String lyDo) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_Kl)){
            pst.setInt(1, tienKyLuat);
            pst.setString(2, lyDo);
            pst.setString(3,maKyLuat );
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public void xoaKyLuat(String maKyLuat){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_Kl)){
            pst.setString(1, maKyLuat);
            pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Model.kyLuat getKyLuatByMaKyLuat(String maKyLuatInPut){
        try(PreparedStatement pst = connection.prepareStatement(GET_KL_BY_MAKL)){
            pst.setString(1, maKyLuatInPut);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maKyLuat = result.getString("maKyLuat");
                int tienKyLuat = result.getInt("tienKyLuat");
                String lyDo = result.getString("lyDo");
                
                kyLuat kl = new kyLuat(maKyLuat,tienKyLuat, lyDo);
                return kl;           
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<String> getListMaKyLuat(){
        try(Statement stm = connection.createStatement()){
            List<String> KLList = new ArrayList<>();
//            KLList.add("");
            ResultSet result = stm.executeQuery(GET_LIST_MAKL);
            while(result.next()){
                String maKyLuat = result.getString("maKyLuat");
                KLList.add(maKyLuat);
            }
            return KLList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Model.kyLuat> getListKyLuat(){
        try(Statement stm = connection.createStatement()){
            List<Model.kyLuat> KLList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_LIST_KL);
            while(result.next()){
                String maKyLuat = result.getString("maKyLuat");
                int tienKyLuat = result.getInt("tienKyLuat");
                String lyDo = result.getString("lyDo");
                Model.kyLuat kl = new kyLuat(maKyLuat, tienKyLuat, lyDo);
                KLList.add(kl);
                
            }
            result.close();
            return KLList;
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        return null;
    }
    public boolean islyDoExists(String lyDo){
        try(PreparedStatement pst = connection.prepareStatement(VALID_LYDO)){
            pst.setString(1, lyDo);
            
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
