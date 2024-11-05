package Model;

import java.sql.Date;

public class DuAn {
	private String maDA;
	private String tenDA;
	private String diaDiem;
	private int gia;
	private int hoaHong;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private String trangThai;
	
	public DuAn(String maDA, String tenDA, String diaDiem, int gia, int hoaHong, Date ngayBatDau, Date ngayKetThuc,
			String trangThai) {
		this.maDA = maDA;
		this.tenDA = tenDA;
		this.diaDiem = diaDiem;
		this.gia = gia;
		this.hoaHong = hoaHong;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.trangThai = trangThai;
	}
	
	public DuAn() {
		
	}

	public String getMaDA() {
		return maDA;
	}

	public void setMaDA(String maDA) {
		this.maDA = maDA;
	}

	public String getTenDA() {
		return tenDA;
	}

	public void setTenDA(String tenDA) {
		this.tenDA = tenDA;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public int getHoaHong() {
		return hoaHong;
	}

	public void setHoaHong(int hoaHong) {
		this.hoaHong = hoaHong;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
