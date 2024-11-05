package Model;

import java.sql.Date;

public class HoSoThuViec {
	private String maNVTV;
	private String hoTen;
	private Date ngaySinh;
	private String gioiTint;
	private String CMND_CCCD;
	private String viTriThuViec;
	private Date ngayBatDau;
	private int soThangThuViec;
	private String SDT;
	private String hocVan;
	private String maLuongTV;
	private String ghiChu;
	
	public HoSoThuViec(String maNVTV, String hoTen, Date ngaySinh, String gioiTint, String cMND_CCCD,
			String viTriThuViec, Date ngayBatDau, int soThangThuViec, String sDT, String hocVan, String maLuongTV,
			String ghiChu) {
		this.maNVTV = maNVTV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTint = gioiTint;
		CMND_CCCD = cMND_CCCD;
		this.viTriThuViec = viTriThuViec;
		this.ngayBatDau = ngayBatDau;
		this.soThangThuViec = soThangThuViec;
		SDT = sDT;
		this.hocVan = hocVan;
		this.maLuongTV = maLuongTV;
		this.ghiChu = ghiChu;
	}

	public String getMaNVTV() {
		return maNVTV;
	}

	public void setMaNVTV(String maNVTV) {
		this.maNVTV = maNVTV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTint() {
		return gioiTint;
	}

	public void setGioiTint(String gioiTint) {
		this.gioiTint = gioiTint;
	}

	public String getCMND_CCCD() {
		return CMND_CCCD;
	}

	public void setCMND_CCCD(String cMND_CCCD) {
		CMND_CCCD = cMND_CCCD;
	}

	public String getViTriThuViec() {
		return viTriThuViec;
	}

	public void setViTriThuViec(String viTriThuViec) {
		this.viTriThuViec = viTriThuViec;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public int getSoThangThuViec() {
		return soThangThuViec;
	}

	public void setSoThangThuViec(int soThangThuViec) {
		this.soThangThuViec = soThangThuViec;
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

	public String getMaLuongTV() {
		return maLuongTV;
	}

	public void setMaLuongTV(String maLuongTV) {
		this.maLuongTV = maLuongTV;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
	
}
