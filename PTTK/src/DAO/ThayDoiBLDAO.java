/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ThayDoiBangLuong;
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
public class ThayDoiBLDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String GET_TDBL_LIST = "SELECT * FROM tbl_ThayDoiBangLuong";
    private static final String ADD_TDBL = "INSERT INTO tbl_ThayDoiBangLuong VALUES (?,?,?,NOW(),?)";
    
    
    public List<ThayDoiBangLuong> getTDBL_List(){
        try(PreparedStatement pst = connection.prepareStatement(GET_TDBL_LIST)){
            List<Model.ThayDoiBangLuong> tdblList = new ArrayList<>();
            ResultSet result = pst.executeQuery();
            while(result.next()){
                String maNV = result.getString("maNV");
                String maLuongCu = result.getString("maLuongCu");
                String maLuongMoi = result.getString("maLuongMoi");
                Date ngaySua = result.getDate("ngaySua");
                String lyDo = result.getString("lyDo");
                
                ThayDoiBangLuong tdbl = new ThayDoiBangLuong(maNV, maLuongCu, maLuongMoi, ngaySua, lyDo);
                tdblList.add(tdbl);
            }
            return tdblList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void addTDBL(String maNV,String maLuongCu,String maLuongMoi,String lyDo){
        try(PreparedStatement pst = connection.prepareStatement(ADD_TDBL)){
            pst.setString(1, maNV);
            pst.setString(2, maLuongCu);
            pst.setString(3, maLuongMoi);
            pst.setString(4, lyDo);
            
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
