package Model;

public class LuongTV {
	private String maLuongTV;
	private int luongTV;
	private String ghiChu;
	
	public LuongTV(String maLuongTV, int luongTV, String ghiChu) {
		this.maLuongTV = maLuongTV;
		this.luongTV = luongTV;
		this.ghiChu = ghiChu;
	}

	public String getMaLuongTV() {
		return maLuongTV;
	}

	public void setMaLuongTV(String maLuongTV) {
		this.maLuongTV = maLuongTV;
	}

	public int getLuongTV() {
		return luongTV;
	}

	public void setLuongTV(int luongTV) {
		this.luongTV = luongTV;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
