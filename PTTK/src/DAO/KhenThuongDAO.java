/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.KhenThuong;
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
public class KhenThuongDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String ADD_KT = "INSERT INTO tbl_KhenThuong(maThuong,tienThuong,lyDo) VALUES (null ,?,?);" ;
    private static final String UPDATE_KT = "UPDATE tbl_KhenThuong SET tienThuong = ? , lyDo = ? WHERE maThuong = ?";
    private static final String DELETE_KT = "DELETE FROM tbl_KhenThuong WHERE maThuong = ?";
    private static final String GET_KT_BY_MAKT = "SELECT * FROM tbl_KhenThuong WHERE maThuong = ?";
    private static final String GET_LIST_MAKT = "SELECT maThuong FROM tbl_KhenThuong";
    private static final String GET_LIST_KT = "SELECT * FROM tbl_KhenThuong";
    private static final String VALID_LYDO = "SELECT * FROM tbl_KhenThuong WHERE lyDo = ?";
    
    public void themKhenThuong(int tienKhenThuong,String lyDo)throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(ADD_KT)){
            pst.setInt(1, tienKhenThuong);
            pst.setString(2, lyDo);
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public void suaKhenThuong (String maThuong,int tienThuong, String lyDo) throws Exception{
        try(PreparedStatement pst = connection.prepareStatement(UPDATE_KT)){
            pst.setInt(1, tienThuong);
            pst.setString(2, lyDo);
            pst.setString(3,maThuong );
            pst.executeUpdate();
        }
        catch(Exception e){
            throw e;
        }
    }
    public void xoaKhenThuong(String maThuong){
        try(PreparedStatement pst = connection.prepareStatement(DELETE_KT)){
            pst.setString(1, maThuong);
            pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public Model.KhenThuong getKhenThuongByMaThuong(String maThuongInPut){
        try(PreparedStatement pst = connection.prepareStatement(GET_KT_BY_MAKT)){
            pst.setString(1, maThuongInPut);
            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maThuong = result.getString("maThuong");
                int tienThuong = result.getInt("tienThuong");
                String lyDo = result.getString("lyDo");
                KhenThuong kt = new KhenThuong(maThuong, tienThuong, lyDo);
                return kt;
            }
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        return null;
    }
    public List<String> getListMaThuong(){
        try(Statement stm = connection.createStatement()){
            List<String> KTList = new ArrayList<>();
//            KTList.add("");
            ResultSet result = stm.executeQuery(GET_LIST_MAKT);
            while(result.next()){
                String maThuong = result.getString("maThuong");
                KTList.add(maThuong);
            }
            return KTList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Model.KhenThuong> getListKhenThuong(){
        try(Statement stm = connection.createStatement()){
            List<Model.KhenThuong> KTList = new ArrayList<>();
            ResultSet result = stm.executeQuery(GET_LIST_KT);
            while(result.next()){
                String maThuong = result.getString("maThuong");
                int tienThuong = result.getInt("tienThuong");
                String lyDo = result.getString("lyDo");
                Model.KhenThuong kt = new KhenThuong(maThuong, tienThuong, lyDo);
                KTList.add(kt);
            }
            result.close();
            return KTList;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }public boolean islyDoExists(String lyDo){
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
