package Model;

import java.sql.Date;

public class LSVangMat {
	private String maNV;
	private Date ngayNghi;
	private String ghiChu;
	
	public LSVangMat(String maNV, Date ngayNghi, String ghiChu) {
		this.maNV = maNV;
		this.ngayNghi = ngayNghi;
		this.ghiChu = ghiChu;
	}
	
	public LSVangMat() {
		
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayNghi() {
		return ngayNghi;
	}

	public void setNgayNghi(Date ngayNghi) {
		this.ngayNghi = ngayNghi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
