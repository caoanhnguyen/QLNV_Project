package Model;

import java.sql.Date;

public class NghiPhep {
	private int maNghiPhep;
	private String maNV;
	private String hoTen;
	private String lyDo;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String trangThai;
	
	public NghiPhep(int maNghiPhep, String maNV, String hoTen, String lyDo, Date ngayBatDau, Date ngayKetThuc,
			String trangThai) {
		this.maNghiPhep = maNghiPhep;
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.lyDo = lyDo;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
	}
	
	public NghiPhep() {
		
	}

	public int getMaNghiPhep() {
		return maNghiPhep;
	}

	public void setMaNghiPhep(int maNghiPhep) {
		this.maNghiPhep = maNghiPhep;
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

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
