drop database  if exists QLNV;
create database QLNV;
use QLNV;

create table tbl_LoaiTK
(
	maLoaiTK varchar(5) primary key not null,
    tenLoaiTK nvarchar(50),
    quyenHan nvarchar(50)
);

create table tbl_Luong
(
	maLuong varchar(6) primary key not null,
    luongCoBan bigint,
    phuCapCV bigint,
    phuCapKhac bigint,
    ghiChu nvarchar(255)
);

create table tbl_LuongTV
(
	maLuongTV varchar(8) primary key not null,
    luongTV bigint,
    ghiChu nvarchar(255)
);

create table tbl_PhongBan
(
	maPB varchar(5) primary key not null,
    maBP varchar(5),
    tenPB nvarchar(50),
    ngayTLap date,
    ghiChu nvarchar(255)
);

create table tbl_BoPhan
(
	maBP varchar(5) primary key not null,
    tenBP nvarchar(50),
    ngayTLap date,
    ghiChu nvarchar(255)
);

create table tbl_NhanVien
(
	maNV varchar(5) primary key not null,
    hoTen nvarchar(255),
    gioiTinh nvarchar(4),
    danToc nvarchar(20),
    chucVu nvarchar(50),
    loaiHopDong nvarchar(50),
    ngayDangKy date,
    thoiGian int,
    CMND_CCCD varchar(12) unique,
    SDT varchar(12),
    hocVan nvarchar(50),
    email varchar(50),
    maPB varchar(5) not null,
    maLuong varchar(6) not null,
    ghiChu nvarchar(255)
);

SELECT count(*)
FROM tbl_NhanVien
WHERE ngayDangKy >= DATE_FORMAT(CONCAT(2020, '-', 5, '-01'), '%Y-%m-%d');
select * from tbl_nhanvien;

create table tbl_TaiKhoan
(
	maTK varchar(5) primary key not null,
    maLoaiTK varchar(5) not null,
    tenChuTK nvarchar(255),
    tenDNhap nvarchar(50),
    matKhau nvarchar(50)
);
use QLNV;
select * from tbl_TaiKhoan;

create table tbl_BaoHiem
(
	maBaoHiem varchar(5) primary key not null,
    maNV varchar(5),
    noiCap nvarchar(255),
    ngayCap date,
    ghiChu nvarchar(255)
);

alter table tbl_baohiem
add constraint unique_maNV unique (maNV);

select * from tbl_nhanvien where maNV not in (select maNV from tbl_baohiem);

create table tbl_HoSoThuViec
(
	maNVTV varchar(7) primary key not null,
    hoTen nvarchar(50),
    ngaySinh datetime,
    gioiTinh nvarchar(4),
    CMND_CCCD varchar(12) unique,
    viTriThuViec nvarchar(50),
    ngayBatDau datetime,
    soThangThuViec int,
    SDT varchar(12),
    hocVan nvarchar(50),
    maLuongTV varchar(8),
    ghiChu nvarchar(255)
);

UPDATE tbl_HoSoThuViec
SET
    hoTen = 'Tên Mới',
    ngaySinh = '1990-01-01 00:00:00',
    gioiTinh = 'Nam',
    CMND_CCCD = '123456789012',
    viTriThuViec = 'Vị trí mới',
    ngayBatDau = '2024-01-01 00:00:00',
    soThangThuViec = 6,
    SDT = '0901234567',
    hocVan = 'Cử nhân',
    maLuongTV = 'MLTV001',
    ghiChu = 'Ghi chú mới'
WHERE
    maNVTV = 'NVTV007';


select * from tbl_hosothuviec;

create table tbl_TinhLuong
(
	maNV varchar(5) not null,
    maLuong varchar(6),
    thang int,
    nam int,
    luongCoBan bigint,
    phuCapCV bigint,
    phuCapKhac bigint,
    tienThuong bigint,
    tienKyLuat bigint,
    tienHoaHong bigint,
    soNgayCong int,
    luongThucNhan bigint,
    ghiChu nvarchar(255)
);

create table tbl_TinhLuongTV
(
	maNVTV varchar(7) not null,
    maLuongTV varchar(8),
    thang int,
    nam int,
    luongTV bigint,
    soNgayCong int,
    soGioLamThem int,
    luongThucNhan bigint,
    ghiChu nvarchar(255)
);

use QLNV;
select avg(luongThucNhan) from tbl_tinhluong;
select * from tbl_tinhluong;
SELECT AVG(luongThucNhan) from tbl_tinhLuong where nam = 2024 and thang = 7;
delete from tbl_tinhluong where nam = 2016;
select * from tbl_nhanvien;

create table tbl_ThoiViec
(
	maNV varchar(5) primary key not null,
    hoTen nvarchar(50),
    ngayThoiViec date,
    lyDo nvarchar(255)
);

create table tbl_KhenThuong
(
	maThuong int auto_increment primary key not null,
    tienThuong bigint,
    lyDo nvarchar(255)
);

use QLNV;
select * from tbl_KhenThuong;
select * from tbl_nhanVien;

create table tbl_KyLuat
(
	maKyLuat int auto_increment primary key not null,
    tienKyLuat bigint,
    lyDo nvarchar(255)
);

create table tbl_DuAn
(
	maDA varchar(5) primary key not null,
    tenDA nvarchar(50),
    diaDiem nvarchar(50),
    gia bigint,
    hoaHong bigint,
    ngayBatDau date,
    ngayKetThuc date,
    trangThai nvarchar(50)
);

select * from tbl_duan where trangThai not in ('Hoàn thành');

use QLNV;
select * from tbl_duan;

create table tbl_PhanCongDA
(
	maDA varchar(5) primary key not null,
    tenDA nvarchar(50),
    maNV varchar(5) not null,
    ngayPhanCong date
);
use QLNV;
select * from tbl_PhanCongDA;

create table tbl_NghiPhep
(
	maNghiPhep int auto_increment primary key not null,
    maNV varchar(5) not null,
    hoTen nvarchar(50),
    lyDo nvarchar(255),
    ngayBatDau date,
    ngayKetThuc date,
    trangThai nvarchar(50)
);

create table tbl_LSVangMat
(
	maNV varchar(5) not null,
    ngayNghi date not null,
    ghiChu nvarchar(255)
);
drop table tbl_LSVangMat;
create table tbl_ThayDoiBangLuong
(
	maNV varchar(5),
    maLuongCu varchar(6),
    maLuongMoi varchar(6),
    ngaySua date,
    lyDo nvarchar(255)
);

create table tbl_LSChamCong
(
	maLSChamCong varchar(8) primary key,
	maNV varchar(5),
    ngayChamCong date
);

delete from tbl_LSChamCong;
SELECT * FROM tbl_LSChamCong WHERE ngayChamCong = '2024-08-08';
SELECT * FROM tbl_LSChamCong WHERE ngayChamCong = '2024-08-08' AND maNV = 'NV005';

alter table tbl_TaiKhoan
add constraint fk_maLoaiTK foreign key (maLoaiTK) references tbl_LoaiTK(maLoaiTK);

alter table tbl_NhanVien
add constraint fk_maLuong_NhanVien foreign key (maLuong) references tbl_Luong(maLuong),
add constraint fk_maPB_NhanVien foreign key (maPB) references tbl_PhongBan(maPB);

alter table tbl_ThayDoiBangLuong
add constraint fk_maLuongCu foreign key (maLuongCu) references tbl_Luong(maLuong),
add constraint fk_maLuongMoi foreign key (maLuongMoi) references tbl_Luong(maLuong);

alter table tbl_PhanCongDA
add constraint fk_maDA_PhanCongDA foreign key (maDA) references tbl_DuAn(maDA),
add constraint fk_maNV_PhanCongDA foreign key (maNV) references tbl_NhanVien(maNV);

alter table tbl_NghiPhep
add constraint fk_maNV_NghiPhep foreign key (maNV) references tbl_NhanVien(maNV);

alter table tbl_PhongBan
add constraint fk_maBP_PhongBan foreign key (maBP) references tbl_BoPhan(maBP);

alter table tbl_ChamCongTV
add constraint fk_maNVTV_ChamCongTV foreign key (maNVTV) references tbl_HoSoThuViec(maNVTV);

alter table tbl_BaoHiem
add constraint fk_maNV_BaoHiem foreign key (maNV) references tbl_NhanVien(maNV);

alter table tbl_ChamCong
add constraint fk_maNV_ChamCong foreign key (maNV) references tbl_NhanVien(maNV);

-- thêm khóa ngoại bảng tài khoản
alter table tbl_TaiKhoan
add constraint fk_maLoaiTK foreign key (maLoaiTK) references tbl_LoaiTK(maLoaiTK) on delete cascade;

-- Thêm khóa ngoại bảng nhân viên
alter table tbl_NhanVien
add constraint fk_maLuong_NhanVien foreign key (maLuong) references tbl_Luong(maLuong) on delete cascade,
add constraint fk_maPB_NhanVien foreign key (maPB) references tbl_PhongBan(maPB) on delete cascade;

use QLNV;
-- Bước 1: Xóa ràng buộc khóa ngoại hiện tại
ALTER TABLE tbl_NhanVien
DROP FOREIGN KEY fk_maLuong_NhanVien,
DROP FOREIGN KEY fk_maPB_NhanVien;

-- Bước 2: Thêm lại ràng buộc khóa ngoại với ON DELETE RESTRICT (khi xóa một mã lương hay một phòng ban thì nếu có nhân viên nào đó tham chiếu tới thì sẽ không xóa được)
ALTER TABLE tbl_NhanVien
ADD CONSTRAINT fk_maLuong_NhanVien FOREIGN KEY (maLuong) REFERENCES tbl_Luong(maLuong) ON DELETE RESTRICT,
ADD CONSTRAINT fk_maPB_NhanVien FOREIGN KEY (maPB) REFERENCES tbl_PhongBan(maPB) ON DELETE RESTRICT;

select * from tbl_luong;

-- Thêm khóa ngoại bảng thay đổi bảng lương
alter table tbl_ThayDoiBangLuong
add constraint fk_maLuongCu foreign key (maLuongCu) references tbl_Luong(maLuong) on delete cascade,
add constraint fk_maLuongMoi foreign key (maLuongMoi) references tbl_Luong(maLuong) on delete cascade;

-- Thêm khóa ngoại bảng phân công dự án
alter table tbl_PhanCongDA
add constraint fk_maDA_PhanCongDA foreign key (maDA) references tbl_DuAn(maDA) on delete cascade,
add constraint fk_maNV_PhanCongDA foreign key (maNV) references tbl_NhanVien(maNV) on delete cascade;

-- Thêm khóa ngoại bảng nghỉ phép
alter table tbl_NghiPhep
add constraint fk_maNV_NghiPhep foreign key (maNV) references tbl_NhanVien(maNV) on delete cascade;

-- Thêm khóa ngoại bảng phòng ban
alter table tbl_PhongBan
add constraint fk_maBP_PhongBan foreign key (maBP) references tbl_BoPhan(maBP) on delete cascade;

-- Thêm khóa ngoại bảng tính lương thử việc
alter table tbl_TinhLuongTV
add constraint fk_maNVTV_TinhLuongTV foreign key (maNVTV) references tbl_HoSoThuViec(maNVTV) on delete cascade;

-- Thêm khóa ngoại bảng bảo hiểm
alter table tbl_BaoHiem
add constraint fk_maNV_BaoHiem foreign key (maNV) references tbl_NhanVien(maNV) on delete cascade;

-- Thêm khóa ngoại bảng tính lương
alter table tbl_TinhLuong
add constraint fk_maNV_TinhLuong foreign key (maNV) references tbl_NhanVien(maNV) on delete cascade;

-- Xóa khóa ngoại bảng tài khoản
alter table tbl_TaiKhoan 
drop foreign key fk_maLoaiTK;

-- Xóa khóa ngoại bảng Nhân viên
alter table tbl_NhanVien
drop foreign key fk_maLuong_NhanVien,
drop foreign key fk_maPB_NhanVien;

-- Xóa khóa ngoại bảng thay đổi bảng lương
alter table tbl_ThayDoiBangLuong
drop foreign key fk_maLuongCu,
drop foreign key fk_maLuongMoi;

-- Xóa khóa ngoại bảng phân công dự án
alter table tbl_PhanCongDA
drop foreign key fk_maDA_PhanCongDA,
drop foreign key fk_maNV_PhanCongDA;

-- Xóa khóa ngoại bảng nghỉ phép
alter table tbl_NghiPhep
drop foreign key fk_maNV_NghiPhep;

-- Xóa khóa ngoại bảng phòng ban
alter table tbl_PhongBan
drop foreign key fk_maBP_PhongBan;

-- Xóa khóa ngoại bảng tính lương thử việc
alter table tbl_TinhLuongTV
drop foreign key fk_maNVTV_ChamCongTV;

-- Xóa khóa ngoại bảng bảo hiểm
alter table tbl_BaoHiem
drop foreign key fk_maNV_BaoHiem;

-- Xóa khóa ngoại bảng tính lương
alter table tbl_TinhLuong
drop foreign key fk_maNV_ChamCong;

