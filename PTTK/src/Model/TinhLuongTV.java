package Model;

public class TinhLuongTV {
	private String maNVTV;
	private LuongTV luongTV;
	private int thang;
	private int nam;
	private int soNgayCong;
	private int soGioLamThem;
	private int luongThucNhan;
        private String ghiChu ;
	
	public TinhLuongTV(String maNVTV, LuongTV luongTV, int thang, int nam, int soNgayCong, int soGioLamThem,
			int luongThucNhan, String ghiChu) {
		this.maNVTV = maNVTV;
		this.luongTV = luongTV;
		this.thang = thang;
		this.nam = nam;
		this.soNgayCong = soNgayCong;
		this.soGioLamThem = soGioLamThem;
		this.luongThucNhan = luongThucNhan;
                this.ghiChu = ghiChu;
	}

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

	public String getMaNVTV() {
		return maNVTV;
	}

	public void setMaNVTV(String maNVTV) {
		this.maNVTV = maNVTV;
	}

	public LuongTV getLuongTV() {
		return luongTV;
	}

	public void setLuongTV(LuongTV luongTV) {
		this.luongTV = luongTV;
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

	public int getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(int soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

	public int getSoGioLamThem() {
		return soGioLamThem;
	}

	public void setSoGioLamThem(int soGioLamThem) {
		this.soGioLamThem = soGioLamThem;
	}

	public int getLuongThucNhan() {
		return luongThucNhan;
	}

	public void setLuongThucNhan(int luongThucNhan) {
		this.luongThucNhan = luongThucNhan;
	}
	
	
}
