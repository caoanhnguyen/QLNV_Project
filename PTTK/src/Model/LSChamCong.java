package Model;

import java.sql.Date;

public class LSChamCong {
	private String maLSChamCong;
	private String maNV;
	private Date ngayChamCong;
	
	public LSChamCong(String maLSChamCong, String maNV, Date ngayChamCong) {
		this.maLSChamCong = maLSChamCong;
		this.maNV = maNV;
		this.ngayChamCong = ngayChamCong;
	}
	
	public LSChamCong() {
		
	}

	public String getMaLSChamCong() {
		return maLSChamCong;
	}

	public void setMaLSChamCong(String maLSChamCong) {
		this.maLSChamCong = maLSChamCong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayChamCong() {
		return ngayChamCong;
	}

	public void setNgayChamCong(Date ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}
	
	
}
