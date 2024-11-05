package Model;

public class kyLuat {
	private String maKyLuat;
	private int tienKyLuat;
	private String lyDo;
	
	public kyLuat(String maKyLuat, int tienKyLuat, String lyDo) {
		this.maKyLuat = maKyLuat;
		this.tienKyLuat = tienKyLuat;
		this.lyDo = lyDo;
	}

	public kyLuat() {
		
	}

	public String getMaKyLuat() {
		return maKyLuat;
	}

	public void setMaKyLuat(String maKyLuat) {
		this.maKyLuat = maKyLuat;
	}

	public int getTienKyLuat() {
		return tienKyLuat;
	}

	public void setTienKyLuat(int tienKyLuat) {
		this.tienKyLuat = tienKyLuat;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	
}
