package Model;

public class TinhLuong {
	private String maNV;
	private Luong luong;
	private int thang;
	private int nam;
	private int tienThuong;
	private int tienKyLuat;
	private int tienHoaHong;
	private int soNgayCong;
	private int luongThucNhan;
        private String ghiChu;
	
	public TinhLuong(String maNV, Luong luong, int thang, int nam, int tienThuong, int tienKyLuat, int tienHoaHong,
			int soNgayCong, int luongThucNhan, String ghiChu) {
		this.maNV = maNV;
		this.luong = luong;
		this.thang = thang;
		this.nam = nam;
		this.tienThuong = tienThuong;
		this.tienKyLuat = tienKyLuat;
		this.tienHoaHong = tienHoaHong;
		this.soNgayCong = soNgayCong;
		this.luongThucNhan = luongThucNhan;
                this.ghiChu = ghiChu;
	}

	public TinhLuong() {
		
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Luong getLuong() {
		return luong;
	}

	public void setLuong(Luong luong) {
		this.luong = luong;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int getTienThuong() {
		return tienThuong;
	}

	public void setTienThuong(int tienThuong) {
		this.tienThuong = tienThuong;
	}

	public int getTienKyLuat() {
		return tienKyLuat;
	}

	public void setTienKyLuat(int tienKyLuat) {
		this.tienKyLuat = tienKyLuat;
	}

	public int getTienHoaHong() {
		return tienHoaHong;
	}

	public void setTienHoaHong(int tienHoaHong) {
		this.tienHoaHong = tienHoaHong;
	}

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public int getLuongThucNhan() {
		return luongThucNhan;
	}

	public void setLuongThucNhan(int luongThucNhan) {
		this.luongThucNhan = luongThucNhan;
	}

        public String getGhiChu() {
            return ghiChu;
        }

        public void setGhiChu(String ghiChu) {
            this.ghiChu = ghiChu;
        }
	
}
