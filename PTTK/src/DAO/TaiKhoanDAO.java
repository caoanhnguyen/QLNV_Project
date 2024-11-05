package DAO;

import Model.BoPhan;
import Model.TaiKhoan;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {
	private static Connection connection = DBManager.getConnection();
	private static final String ADD_NEW_TK = "INSERT INTO tbl_TaiKhoan VALUES (null,?,?,?,?)";
	private static final String DELETE_TK = "DELETE FROM tbl_taiKhoan where maTK = ?";
	private static final String UPDATE_TK = "UPDATE tbl_taiKhoan SET maLoaiTK = ?, tenChuTK = ?, matKhau = ? where tenDNhap = ?";
	private static final String VALID_ACC = "SELECT * FROM tbl_TaiKhoan WHERE tenDNhap = ? AND matKhau = ?";
        private static final String GET_TK_LIST = "SELECT * FROM tbl_TaiKhoan";
        private static final String GET_TK_BY_TENDNHAP = "SELECT * FROM tbl_TaiKhoan WHERE tenDNhap = ?";
	
	public void themTaiKhoan(String maLoaiTK,String tenChuTK,String tenDangNhap,String matKhau) {
		try(PreparedStatement pst = connection.prepareStatement(ADD_NEW_TK)){
			pst.setString(1, maLoaiTK);
			pst.setString(2, tenChuTK);
			pst.setString(3, tenDangNhap);
			pst.setString(4, matKhau);
			
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaTaiKhoan(String maTK) {
		try(PreparedStatement pst = connection.prepareStatement(DELETE_TK)){
			pst.setString(1, maTK);
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void suaTaiKhoan(String maLoaiTK,String tenChuTK,String matKhau,String tenDNhap) {
		try(PreparedStatement pst = connection.prepareStatement(UPDATE_TK)){
                        pst.setString(1, maLoaiTK);
			pst.setString(2, tenChuTK);
			pst.setString(3, matKhau);
			pst.setString(4, tenDNhap);
			
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Model.TaiKhoan isValidAccount(String tenDangNhap, String matKhau) {
		try(PreparedStatement pst = connection.prepareStatement(VALID_ACC)){
                    pst.setString(1, tenDangNhap);
                    pst.setString(2, matKhau);
                    ResultSet result = pst.executeQuery();
                    Model.TaiKhoan tk = new TaiKhoan();
                    if(result.next()) {
                        tk.setMaTK(result.getString("maTK"));
                        tk.setMaLoaiTK(result.getString("maLoaiTK"));
                        tk.setTenChuTK(result.getString("tenChuTK"));
                        tk.setTenDangNhap(result.getString("tenDNhap"));
                        tk.setMatKhau(result.getString("matKhau"));
                        
                        return tk;
                    }else {
                        return null;
                    }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        
        public List<TaiKhoan> getTKList(){
            try(Statement stm = connection.createStatement()){
                List<TaiKhoan> TKList = new ArrayList<>();
                ResultSet result = stm.executeQuery(GET_TK_LIST);

                while(result.next()){
                    String maTK = result.getString("maTK");
                    String maLoatTK = result.getString("maLoaiTK");
                    String tenChuTK = result.getString("tenChuTK");
                    String tenDNhap = result.getString("tenDNhap");
                    String matKhau = result.getString("matKhau");

                    TaiKhoan tk = new TaiKhoan(maTK, maLoatTK, tenChuTK, tenDNhap, matKhau);
                    TKList.add(tk);
                }
                return TKList;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        
        public TaiKhoan getTKByMaNV(String maNV){ //Quy định mã nhân viên là tên đăng nhập
            TaiKhoan tk = new TaiKhoan();
            try(PreparedStatement pst = connection.prepareStatement(GET_TK_BY_TENDNHAP)){
                pst.setString(1, maNV);
                
                ResultSet result = pst.executeQuery();
                while(result.next()){
                    tk.setMaTK(result.getString("maTK"));
                    tk.setMaLoaiTK(result.getString("maLoaiTK"));
                    tk.setTenChuTK(result.getString("tenChuTK"));
                    tk.setTenDangNhap(result.getString("tenDNhap"));
                    tk.setMatKhau(result.getString("matKhau"));
                }
                return tk;
            }catch(Exception e){
                e.printStackTrace();
            }
            return tk;
        }
}
