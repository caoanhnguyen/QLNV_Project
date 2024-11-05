package Model;

public class TaiKhoan {
	private String maTK;
	private String maLoaiTK;
	private String tenChuTK;
	private String tenDangNhap;
	private String matKhau;
	
	public TaiKhoan(String maTK, String maLoaiTK, String tenChuTK, String tenDangNhap, String matKhau) {
		this.maTK = maTK;
		this.maLoaiTK = maLoaiTK;
		this.tenChuTK = tenChuTK;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	
	public TaiKhoan() {
		
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getMaLoaiTK() {
		return maLoaiTK;
	}

	public void setMaLoaiTK(String maLoaiTK) {
		this.maLoaiTK = maLoaiTK;
	}

	public String getTenChuTK() {
		return tenChuTK;
	}

	public void setTenChuTK(String tenChuTK) {
		this.tenChuTK = tenChuTK;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	
	
}
