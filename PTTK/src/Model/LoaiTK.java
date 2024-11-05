package Model;

public class LoaiTK {
	private String maLoaiTK;
	private String tenLoaiTK;
	private String quyenHan;
	
	public LoaiTK(String maLoaiTK, String tenLoaiTK, String quyenHan) {
		this.maLoaiTK = maLoaiTK;
		this.tenLoaiTK = tenLoaiTK;
		this.quyenHan = quyenHan;
	}
	
	public LoaiTK() {
		
	}

	public String getMaLoaiTK() {
		return maLoaiTK;
	}

	public void setMaLoaiTK(String maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}

	public String getTenLoaiTK() {
		return tenLoaiTK;
	}

	public void setTenLoaiTK(String tenLoaiTK) {
		this.tenLoaiTK = tenLoaiTK;
	}

	public String getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}
	
	
	
}
