package Model;

public class KhenThuong {
	private String maThuong;
	private int tienThuong;
	private String lyDo;
	
	public KhenThuong(String maThuong, int tienThuong, String lyDo) {
		this.maThuong = maThuong;
		this.tienThuong = tienThuong;
		this.lyDo = lyDo;
	}

	public KhenThuong() {
		
	}

	public String getMaThuong() {
		return maThuong;
	}

	public void setMaThuong(String maThuong) {
		this.maThuong = maThuong;
	}

	public int getTienThuong() {
		return tienThuong;
	}

	public void setTienThuong(int tienThuong) {
		this.tienThuong = tienThuong;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
}
