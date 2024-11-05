package Model;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private String gioiTinh;
	private String danToc;
	private String chucVu;
	private String loaiHopDong;
	private Date ngayDangKy;
	private int thoiGian;
	private String CMND_CCCD;
	private String SDT;
	private String hocVan;
	private String email;
	private String maPB;
	private String maLuong;
	private String ghiChu;
	
	public NhanVien() {
		
	}
	
	
	
	public NhanVien(String maNV, String hoTen, String gioiTinh, String danToc, String chucVu, String loaiHopDong, 
			Date ngayDangKy, int thoiGian, String cMND_CCCD, String sDT, String hocVan, String email, String maPB,
			String maLuong, String ghiChu) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.danToc = danToc;
		this.chucVu = chucVu;
		this.loaiHopDong = loaiHopDong;
		this.ngayDangKy = ngayDangKy;
		this.thoiGian = thoiGian;
		CMND_CCCD = cMND_CCCD;
		SDT = sDT;
		this.hocVan = hocVan;
		this.email = email;
		this.maPB = maPB;
		this.maLuong = maLuong;
		this.ghiChu = ghiChu;
	}



	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDanToc() {
		return danToc;
	}
	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getLoaiHopDong() {
		return loaiHopDong;
	}
	public void setLoaiHopDong(String loaiHopDong) {
		this.loaiHopDong = loaiHopDong;
	}
	public Date getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public int getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(int thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getCMND_CCCD() {
		return CMND_CCCD;
	}
	public void setCMND_CCCD(String cMND_CCCD) {
		CMND_CCCD = cMND_CCCD;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getHocVan() {
		return hocVan;
	}
	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMaPB() {
		return maPB;
	}
	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}
	public String getMaLuong() {
		return maLuong;
	}
	public void setMaLuong(String maLuong) {
		this.maLuong = maLuong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", danToc=" + danToc
				+ ", chucVu=" + chucVu + ", loaiHopDong=" + loaiHopDong + ", ngayDangKy=" + ngayDangKy + ", thoiGian="
				+ thoiGian + ", CMND_CCCD=" + CMND_CCCD + ", SDT=" + SDT + ", hocVan=" + hocVan + ", email=" + email
				+ ", maPB=" + maPB + ", maLuong=" + maLuong + ", ghiChu=" + ghiChu + "]";
	}
	
}
