package Model;

import java.sql.Date;

public class BaoHiem {
	private String maBaoHiem;
	private String maNV;
	private String noiCap;
	private Date ngayCap;
	private String ghiChu;
	
	public BaoHiem() {
		
	}
	
	public BaoHiem(String maBaoHiem, String maNV, String noiCap, Date ngayCap, String ghiChu) {
		this.maBaoHiem = maBaoHiem;
		this.maNV = maNV;
		this.noiCap = noiCap;
		this.ngayCap = ngayCap;
		this.ghiChu = ghiChu;
	}
	
	public String getMaBaoHiem() {
		return maBaoHiem;
	}
	public void setMaBaoHiem(String maBaoHiem) {
		this.maBaoHiem = maBaoHiem;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getNoiCap() {
		return noiCap;
	}
	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}
	public Date getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
