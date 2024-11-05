package Model;

import java.sql.Date;

public class ThoiViec {
	private String maNV;
	private String hoTen;
	private Date ngayThoiViec;
	private String lyDo;
	
	public ThoiViec(String maNV, String hoTen, Date ngayThoiViec, String lyDo) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngayThoiViec = ngayThoiViec;
		this.lyDo = lyDo;
	}
	
	public ThoiViec() {
		
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

	public Date getNgayThoiViec() {
		return ngayThoiViec;
	}

	public void setNgayThoiViec(Date ngayThoiViec) {
		this.ngayThoiViec = ngayThoiViec;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
	
}
