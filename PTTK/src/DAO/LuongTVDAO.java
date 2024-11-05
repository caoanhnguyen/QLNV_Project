/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class LuongTVDAO {
    private static Connection connection = DBManager.getConnection();
    private static final String GET_MALTV_LIST = "SELECT MaLuongTV FROM tbl_LuongTV";
    
    public List<String> getMaLTVList(){
        try(PreparedStatement pst = connection.prepareStatement(GET_MALTV_LIST)){
            ResultSet result = pst.executeQuery();
            List<String> MaLTVList = new ArrayList<>();
            while(result.next()){
                String maLuongTV = result.getString("maLuongTV");
                MaLTVList.add(maLuongTV);
            }
            return MaLTVList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
