package Model;

import java.sql.Date;

public class BoPhan {
	private String maBP;
	private String tenBP;
	private Date ngayTLap;
	private String ghiChu;
	
	public BoPhan(String maBP, String tenBP, Date ngayTLap, String ghiChu) {
		this.maBP = maBP;
		this.tenBP = tenBP;
		this.ngayTLap = ngayTLap;
		this.ghiChu = ghiChu;
	}
	
	public BoPhan() {
		
	}

	public String getMaBP() {
		return maBP;
	}

	public void setMaBP(String maBP) {
		this.maBP = maBP;
	}

	public String getTenBP() {
		return tenBP;
	}

	public void setTenBP(String tenBP) {
		this.tenBP = tenBP;
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
