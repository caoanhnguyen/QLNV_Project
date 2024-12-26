package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NVDAO {
	private static final Connection connection = DBManager.getConnection();
        private static final String GET_MANV_LIST = "SELECT tenDNhap AS maNV FROM tbl_taikhoan where maLoaiTK = 'LTK02' ORDER BY maLoaiTK".toLowerCase();
        private static final String GET_MANV_0ADMIN_LIST = "SELECT tenDNhap AS maNV FROM tbl_taikhoan where maLoaiTK = 'LTK02' ORDER BY maLoaiTK".toLowerCase();
        private static final String GET_NV_BY_MANV = "SELECT * FROM tbl_NhanVien WHERE maNV = ? ORDER BY maNV".toLowerCase();
        private static final String GET_NV_LIST = "SELECT * FROM tbl_NhanVien ORDER BY maNV".toLowerCase();
        private static final String GET_MANV_BY_TENNV = "SELECT maNV FROM tbl_NhanVien WHERE hoTen = ?".toLowerCase();
        private static final String ADD_NV = "INSERT INTO tbl_NhanVien VALUES (NULL,?,?,?,?,?,NOW(),?,?,?,?,?,?,?,?)".toLowerCase();
        private static final String DELETE_NV = "DELETE FROM tbl_NhanVien WHERE maNV = ?".toLowerCase();
        private static final String UPDATE_NV = "UPDATE tbl_NhanVien SET hoTen = ?, gioiTinh = ?, danToc = ?, chucVu = ?,loaiHopDong = ?,thoiGian = ?, CMND_CCCD = ?, SDT = ?,hocVan = ?,email = ?, maPB = ?, ghiChu = ? WHERE maNV = ?".toLowerCase();
        private static final String GET_SO_NV_BY_TIME = "SELECT COUNT(*) FROM tbl_NhanVien WHERE ngayDangKy >= DATE_FORMAT(CONCAT(?, '-', ?, '-01'), '%Y-%m-%d');".toLowerCase();
        private static final String GET_MANV_LIST_0BH = "select maNV from tbl_nhanvien where maNV not in (select maNV from tbl_baohiem) ORDER BY maNV".toLowerCase();
        
        public int getSoNVByTime(int nam, int thang){
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
        
        public void themNV(String hoTen, String gioiTinh,String danToc,String chucVu,String loaiHopDong,int thoiGian, String CCCD, String SDT,String hocVan,String email,String maPB,String maLuong,String ghiChu)throws Exception{
            try(PreparedStatement pst = connection.prepareStatement(ADD_NV)){
                pst.setString(1, hoTen);
                pst.setString(2, gioiTinh);
                pst.setString(3, danToc);
                pst.setString(4, chucVu);
                pst.setString(5, loaiHopDong);
                pst.setInt(6, thoiGian);
                pst.setString(7, CCCD);
                pst.setString(8, SDT);
                pst.setString(9, hocVan);
                pst.setString(10, email);
                pst.setString(11, maPB);
                pst.setString(12, maLuong);
                pst.setString(13, ghiChu);
                
                pst.executeUpdate();
            }catch(Exception j){
                throw j;
            }
            
        }
        
        public void suaNV(String hoTen, String gioiTinh,String danToc,String chucVu,String loaiHopDong,int thoiGian, String CCCD, String SDT,String hocVan,String email,String maPB,String ghiChu,String maNV)throws Exception{
            try(PreparedStatement pst = connection.prepareStatement(UPDATE_NV)){
                pst.setString(1, hoTen);
                pst.setString(2, gioiTinh);
                pst.setString(3, danToc);
                pst.setString(4, chucVu);
                pst.setString(5, loaiHopDong);
                pst.setInt(6, thoiGian);
                pst.setString(7, CCCD);
                pst.setString(8, SDT);
                pst.setString(9, hocVan);
                pst.setString(10, email);
                pst.setString(11, maPB);
                pst.setString(12, ghiChu);
                pst.setString(13, maNV);
                
                pst.executeUpdate();
            }catch(Exception e){
                throw e;
            }
        }
        
        public void xoaNV(String maNV){
            try(PreparedStatement pst = connection.prepareStatement(DELETE_NV)){
                pst.setString(1, maNV);
                pst.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        
        public NhanVien getNVByMaNV(String maNV){
            NhanVien nv = new NhanVien();
            try(PreparedStatement pst = connection.prepareStatement(GET_NV_BY_MANV)){
                pst.setString(1, maNV);
                
                ResultSet result = pst.executeQuery();
                while(result.next()){
                    nv.setMaNV(result.getString("maNV"));
                    nv.setHoTen(result.getString("hoTen"));
                    nv.setGioiTinh(result.getString("gioiTinh"));
                    nv.setDanToc(result.getString("danToc"));
                    nv.setChucVu(result.getString("chucVu"));
                    nv.setLoaiHopDong(result.getString("loaiHopDong"));
                    nv.setNgayDangKy(result.getDate("ngayDangKy"));
                    nv.setThoiGian(result.getInt("thoiGian"));
                    nv.setCMND_CCCD(result.getString("CMND_CCCD"));
                    nv.setSDT(result.getString("SDT"));
                    nv.setHocVan(result.getString("hocVan"));
                    nv.setEmail(result.getString("email"));
                    nv.setMaPB(result.getString("maPB"));
                    nv.setMaLuong(result.getString("maLuong"));
                    nv.setGhiChu(result.getString("ghiChu"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return nv;
        }
        
        public String getMANVByTenNV(String tenNV){
            String maNV="";
            try(PreparedStatement pst = connection.prepareStatement(GET_MANV_BY_TENNV)){
                pst.setString(1, tenNV);
                
                ResultSet result = pst.executeQuery();
                while(result.next()){
                    maNV = result.getString("maNV");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return maNV;
        }
        
        public List<NhanVien> getNVList(){
            try(Statement stm = connection.createStatement()){
                List<NhanVien> NVList = new ArrayList<>();
                ResultSet result = stm.executeQuery(GET_NV_LIST);

                while(result.next()){
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(result.getString("maNV"));
                    nv.setHoTen(result.getString("hoTen"));
                    nv.setGioiTinh(result.getString("gioiTinh"));
                    nv.setDanToc(result.getString("danToc"));
                    nv.setChucVu(result.getString("chucVu"));
                    nv.setLoaiHopDong(result.getString("loaiHopDong"));
                    nv.setNgayDangKy(result.getDate("ngayDangKy"));
                    nv.setThoiGian(result.getInt("thoiGian"));
                    nv.setCMND_CCCD(result.getString("CMND_CCCD"));
                    nv.setSDT(result.getString("SDT"));
                    nv.setHocVan(result.getString("hocVan"));
                    nv.setEmail(result.getString("email"));
                    nv.setMaPB(result.getString("maPB"));
                    nv.setMaLuong(result.getString("maLuong"));
                    nv.setGhiChu(result.getString("ghiChu"));
                    
                    NVList.add(nv);
                    
                }
            
                return NVList;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        
        
        public List<String> getMaNVList(){
            try(Statement stm = connection.createStatement()){
                List<String> maNVList = new ArrayList<>();
//                maNVList.add("");
                ResultSet result = stm.executeQuery(GET_MANV_LIST);

                while(result.next()){
                    String maNV = result.getString("maNV");
                    maNVList.add(maNV);
                }
            
                return maNVList;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        
        public List<String> getMaNV_0ADMINList(){
            try(Statement stm = connection.createStatement()){
                List<String> maNVList = new ArrayList<>();
//                maNVList.add("");
                ResultSet result = stm.executeQuery(GET_MANV_0ADMIN_LIST);

                while(result.next()){
                    String maNV = result.getString("maNV");
                    maNVList.add(maNV);
                }
            
                return maNVList;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
        
        public List<String> getMaNVList0BH(){
            try(Statement stm = connection.createStatement()){
                List<String> maNVList = new ArrayList<>();
//                maNVList.add("");
                ResultSet result = stm.executeQuery(GET_MANV_LIST_0BH);

                while(result.next()){
                    String maNV = result.getString("maNV");
                    maNVList.add(maNV);
                }
            
                return maNVList;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }
}
