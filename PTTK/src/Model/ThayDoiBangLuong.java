package Model;

import java.sql.Date;

public class ThayDoiBangLuong {
	private String maNV;
	private String maLuongCu;
	private String maLuongMoi;
	private Date ngaySua;
	private String lyDo;
	
	public ThayDoiBangLuong(String maNV, String maLuongCu, String maLuongMoi, Date ngaySua, String lyDo) {
		this.maNV = maNV;
		this.maLuongCu = maLuongCu;
		this.maLuongMoi = maLuongMoi;
		this.ngaySua = ngaySua;
		this.lyDo = lyDo;
	}
	
	public ThayDoiBangLuong() {
		
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaLuongCu() {
		return maLuongCu;
	}

	public void setMaLuongCu(String maLuongCu) {
		this.maLuongCu = maLuongCu;
	}

	public String getMaLuongMoi() {
		return maLuongMoi;
	}

	public void setMaLuongMoi(String maLuongMoi) {
		this.maLuongMoi = maLuongMoi;
	}

	public Date getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		this.ngaySua = ngaySua;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
	
}
