use QLNV; 
CREATE VIEW view_tbl_NhanVien AS 
SELECT * FROM tbl_NhanVien;
SELECT * FROM view_tbl_NhanVien;

CREATE VIEW view_tbl_BaoHiem AS 
SELECT * FROM tbl_BaoHiem;
SELECT * FROM view_tbl_BaoHiem;

CREATE VIEW view_tbl_HoSoThuViec AS 
SELECT * FROM tbl_HoSoThuViec;
SELECT * FROM view_tbl_HoSoThuViec;

CREATE VIEW view_tbl_ThoiViec AS
SELECT * FROM tbl_ThoiViec;

CREATE VIEW view_tbl_PhongBan AS
SELECT * FROM tbl_PhongBan;

CREATE VIEW view_tbl_BoPhan AS
SELECT * FROM tbl_BoPhan;

CREATE VIEW view_tbl_TinhLuong AS
SELECT * FROM tbl_TinhLuong;

CREATE VIEW view_tbl_TinhLuongTV AS
SELECT * FROM tbl_TinhLuongTV;

CREATE VIEW view_tbl_KyLuat AS
SELECT * FROM tbl_KyLuat;

CREATE VIEW view_tbl_KhenThuong AS 
SELECT * FROM tbl_KhenThuong;

CREATE VIEW view_tbl_Luong AS 
SELECT * FROM tbl_Luong;

CREATE VIEW view_tbl_ThayDoiBangLuong AS
SELECT * FROM tbl_ThayDoiBangLuong;

CREATE VIEW view_ChamCong AS
SELECT nv.maNV,hoTen,luongThucNhan,thang,nam,tl.ghiChu
FROM tbl_ChamCong tl JOIN tbl_NhanVien nv
ON tl.maNV = nv.maNV;
SELECT * FROM view_ChamCong;

CREATE VIEW view_tbl_DuAn AS 
SELECT * FROM tbl_DuAn;

CREATE VIEW view_tbl_PhanCongDA AS
SELECT maDA,tenDA,nv.maNV,nv.hoTen,ngayPhanCong
FROM tbl_NhanVien nv
JOIN tbl_PhanCongDA pcda ON nv.maNV = pcda.maNV; 
SELECT * FROM view_tbl_PhanCongDA;

CREATE VIEW view_tbl_NghiPhep AS
SELECT * FROM tbl_NghiPhep;

CREATE VIEW view_tbl_TaiKhoan AS
SELECT * FROM tbl_TaiKhoan;

