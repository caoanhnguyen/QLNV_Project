package Model;

import java.sql.Date;

public class PhanCongDA {
	private String maDA;
	private String tenDA;
	private String maNV;
	private Date ngayPhanCong;
	
	public PhanCongDA(String maDA, String tenDA, String maNV, Date ngayPhanCong) {
		this.maDA = maDA;
		this.tenDA = tenDA;
		this.maNV = maNV;
		this.ngayPhanCong = ngayPhanCong;
	}
	
	public PhanCongDA() {
		
	}

	public String getMaDA() {
		return maDA;
	}

	public void setMaDA(String maDA) {
		this.maDA = maDA;
	}

	public String getTenDA() {
		return tenDA;
	}

	public void setTenDA(String tenDA) {
		this.tenDA = tenDA;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayPhanCong() {
		return ngayPhanCong;
	}

	public void setNgayPhanCong(Date ngayPhanCong) {
		this.ngayPhanCong = ngayPhanCong;
	}
	
	
}
