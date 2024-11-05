package Model;

import java.sql.Date;

public class PhongBan {
	private String maPB;
	private String maBP;
	private String tenPB;
	private Date ngayTLap;
	private String ghiChu;
	
	public PhongBan(String maPB, String maBP, String tenPB, Date ngayTLap, String ghiChu) {
		this.maPB = maPB;
		this.maBP = maBP;
		this.tenPB = tenPB;
		this.ngayTLap = ngayTLap;
		this.ghiChu = ghiChu;
	}
	
	public PhongBan() {
		
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public String getMaBP() {
		return maBP;
	}

	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}

	public String getTenPB() {
		return tenPB;
	}

	public void setTenPB(String tenPB) {
		this.tenPB = tenPB;
	}

	public Date getNgayTLap() {
		return ngayTLap;
	}

	public void setNgayTLap(Date ngayTLap) {
		this.ngayTLap = ngayTLap;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
