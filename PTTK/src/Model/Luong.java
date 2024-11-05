package Model;

public class Luong {
	private String maLuong;
	private int luongCoBan;
	private int phuCapCV;
	private int phuCapKhac;
	private String ghiChu;
	
	public Luong(String maLuong, int luongCoBan, int phuCapCV, int phuCapKhac, String ghiChu) {
		this.maLuong = maLuong;
		this.luongCoBan = luongCoBan;
		this.phuCapCV = phuCapCV;
		this.phuCapKhac = phuCapKhac;
		this.ghiChu = ghiChu;
	}

	public Luong() {
		
	}

	public String getMaLuong() {
		return maLuong;
	}

	public void setMaLuong(String maLuong) {
		this.maLuong = maLuong;
	}

	public int getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(int luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public int getPhuCapCV() {
		return phuCapCV;
	}

	public void setPhuCapCV(int phuCapCV) {
		this.phuCapCV = phuCapCV;
	}

	public int getPhuCapKhac() {
		return phuCapKhac;
	}

	public void setPhuCapKhac(int phuCapKhac) {
		this.phuCapKhac = phuCapKhac;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
