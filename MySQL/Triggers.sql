use QLNV;

-- Trigger for tbl_BoPhan
DELIMITER //
CREATE TRIGGER trg_BeforeInsertBoPhan
BEFORE INSERT ON tbl_BoPhan
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã BP lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maBP, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_BoPhan;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã BP mới với định dạng BPxxx
    SET NEW.maBP = CONCAT('BP', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_PhongBan
DELIMITER //
CREATE TRIGGER trg_BeforeInsertPhongBan
BEFORE INSERT ON tbl_PhongBan
FOR EACH ROW
BEGIN
	DECLARE nextID INT;
    -- Lấy giá trị mã PB lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maPB, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_PhongBan;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã PB mới với định dạng PBxxx
    SET NEW.maPB = CONCAT('PB', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_LoaiTK
DELIMITER //
CREATE TRIGGER trg_BeforeInsertLoaiTK
BEFORE INSERT ON tbl_LoaiTK
FOR EACH ROW
BEGIN
	DECLARE nextID INT;
    -- Lấy giá trị mã LoaiTK lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maLoaiTK, 4) AS UNSIGNED)) + 1 INTO nextID FROM tbl_LoaiTK;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã TK mới với định dạng LTKxx
    SET NEW.maLoaiTK = CONCAT('LTK', LPAD(nextID, 2, '0'));
END;
//
DELIMITER ;


-- Trigger for tbl_TaiKhoan
DELIMITER //
CREATE TRIGGER trg_BeforeInsertTK
BEFORE INSERT ON tbl_TaiKhoan 
FOR EACH ROW
BEGIN
	DECLARE nextID INT;
    -- Lấy giá trị mã TK lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maTK, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_TaiKhoan;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã TK mới với định dạng TKxxx
    SET NEW.maTK = CONCAT('TK', LPAD(nextID,3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_Luong
DELIMITER //
CREATE TRIGGER trg_BeforeInsertLuong
BEFORE INSERT ON tbl_Luong 
FOR EACH ROW
BEGIN
	DECLARE nextID INT;
    -- Lấy giá trị mã Luong lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maLuong, 6) AS UNSIGNED)) + 1 INTO nextID FROM tbl_Luong;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã Luong mới với định dạng Luongx
    SET NEW.maLuong = CONCAT('LUONG', LPAD(nextID,1, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_LuongTV
DELIMITER //
CREATE TRIGGER trg_BeforeInsertLuongTV
BEFORE INSERT ON tbl_LuongTV
FOR EACH ROW
BEGIN
	DECLARE nextID INT;
    -- Lấy giá trị mã LuongTV lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maLuongTV, 8) AS UNSIGNED)) + 1 INTO nextID FROM tbl_LuongTV;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã LuongTV mới với định dạng LuongTVx
    SET NEW.maLuongTV = CONCAT('LUONGTV', LPAD(nextID,1, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_NhanVien
DELIMITER //
CREATE TRIGGER trg_BeforeInsertNhanVien
BEFORE INSERT ON tbl_NhanVien
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã NV lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maNV, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_NhanVien;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã NV mới với định dạng NVxxx
    SET NEW.maNV = CONCAT('NV', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_BaoHiem
DELIMITER //
CREATE TRIGGER trg_BeforeInsertBaoHiem
BEFORE INSERT ON tbl_BaoHiem
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã BH lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maBaoHiem, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_BaoHiem;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã BH mới với định dạng BHxxx
    SET NEW.maBaoHiem = CONCAT('BH', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_HoSoThuViec
DELIMITER //
CREATE TRIGGER trg_BeforeInsertHSTV
BEFORE INSERT ON tbl_HoSoThuViec
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã NVTV lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maNVTV, 5) AS UNSIGNED)) + 1 INTO nextID FROM tbl_HoSoThuViec;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã NVTV mới với định dạng NVTVxxx
    SET NEW.maNVTV = CONCAT('NVTV', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_DuAn
DELIMITER //
CREATE TRIGGER trg_BeforeInsertDuAn
BEFORE INSERT ON tbl_DuAn
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã DuAn lớn nhất trong bảng
    SELECT MAX(CAST(SUBSTRING(maDA, 3) AS UNSIGNED)) + 1 INTO nextID FROM tbl_DuAn;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã DuAn mới với định dạng DAxxx
    SET NEW.maDA = CONCAT('DA', LPAD(nextID, 3, '0'));
END;
//
DELIMITER ;

-- Trigger for tbl_LSChamCong
DELIMITER //
CREATE TRIGGER trg_BeforeInsertLSChamCong
BEFORE INSERT ON tbl_LSChamCong
FOR EACH ROW
BEGIN
    DECLARE nextID INT;

    -- Lấy giá trị mã LSChamCong lớn nhất trong bảng, bỏ qua phần 'LSCC'
    SELECT MAX(CAST(SUBSTRING(maLSChamCong, 5) AS UNSIGNED)) + 1 INTO nextID FROM tbl_LSChamCong;

    -- Nếu nextID là NULL, gán giá trị là 1
    IF nextID IS NULL THEN
        SET nextID = 1;
    END IF;

    -- Tạo mã LSChamCong mới với định dạng LSCCxxxx, đảm bảo ít nhất 4 chữ số trong phần số
    SET NEW.maLSChamCong = CONCAT('LSCC', LPAD(nextID, 4, '0'));
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS trg_BeforeInsertLSChamCong;

-- Trigger tự động tạo tài khoản sau khi tạo nhân viên
DELIMITER //
CREATE TRIGGER trg_AfterInsertNhanVien
AFTER INSERT ON tbl_NhanVien
FOR EACH ROW
BEGIN
  INSERT INTO tbl_TaiKhoan (maLoaiTK, tenChuTK, tenDNhap, matKhau)
  VALUES ('LTK02', NEW.hoTen, NEW.MaNV, "12345");

END;
//
DELIMITER ;

-- Trigger update bảng dự án
DELIMITER // 
CREATE TRIGGER trg_AfterUpdateDuAn
AFTER UPDATE ON tbl_DuAn
FOR EACH ROW
BEGIN
	IF NEW.tenDA <> OLD.tenDA THEN
		UPDATE tbl_PhanCongDA
		SET tenDA= NEW.tenDA
		WHERE maDA = NEW.maDA;
	END IF;
END;
//
DELIMITER ;

-- Trigger update luong
DELIMITER //
CREATE TRIGGER trg_AfterInsertLuong
AFTER INSERT ON tbl_ThayDoiBangLuong
FOR EACH ROW
BEGIN
    update tbl_NhanVien
    set maLuong = NEW.maLuongMoi
    where maNV = NEW.maNV;
END;
//
DELIMITER ;

-- 
DELIMITER //

CREATE TRIGGER trg_AfterUpdateNghiPhep AFTER UPDATE ON tbl_NghiPhep
FOR EACH ROW
BEGIN
	DECLARE currentDate DATE;
    IF NEW.trangThai = 'Đã xác nhận' THEN
        SET currentDate = NEW.ngayBatDau;
        WHILE currentDate <= NEW.ngayKetThuc DO
            INSERT INTO tbl_LSVangMat (maNV, ngayNghi, ghiChu) VALUES (NEW.maNV, currentDate, NEW.lyDo);
            SET currentDate = DATE_ADD(currentDate, INTERVAL 1 DAY);
        END WHILE;
    END IF;
END;
//
DELIMITER ;
DROP TRIGGER IF EXISTS nghi_phep_trigger;
-- Trigger xóa nhân viên thì xóa tài khoản  
DELIMITER //
CREATE TRIGGER trg_AfterDeleteNhanVien
AFTER DELETE ON tbl_NhanVien
FOR EACH ROW
BEGIN

	DELETE FROM tbl_TaiKhoan
	WHERE tenDNhap = OLD.maNV;
    DELETE FROM tbl_LSVangMat
    WHERE maNV = OLD.maNV;
    DELETE FROM tbl_LSChamCong
    WHERE maNV = OLD.maNV;
    DELETE FROM tbl_ThayDoiBangLuong
    WHERE maNV = OLD.maNV;
    DELETE FROM tbl_tinhluong
    WHERE maNV = OLD.maNV;
END;
//
DELIMITER ;


select * from tbl_taikhoan;

drop trigger trg_AfterInsertLuong;

show triggers;

INSERT INTO tbl_Luong VALUES
(null,5000000,1500000,500000,'Luong cap 1'),
(null,7000000,2500000,700000,'Luong cap 2');
select * from tbl_Luong;
SELECT l.maLuong ,luongCoBan,phuCapCV,phuCapKhac,l.ghiChu FROM tbl_Luong l JOIN tbl_NhanVien nv ON l.maLuong = nv.maLuong WHERE maNV = 'NV001';

INSERT INTO tbl_LuongTV VALUES
(null,3000000,'Thu viec 1'),
(null,3500000,'Thu viec 2');
select * from tbl_LuongTV;

INSERT INTO TBL_PhongBan VALUES 
(NULL,'BP001','Phong chong ma toe',NOW(),'PHONG CHONG MA TOE'),
(NULL,'BP002','Phong ke toan',NOW(),'TINH LUONG');
select * from tbl_PhongBan;
delete from tbl_phongban where maPB = 'PB005';

INSERT INTO tbl_BoPhan (maBP, tenBP, ngayTLap, ghiChu) VALUES 
(null, 'Quản lý', NOW(), 'Bộ phận quản lý tổng thể của công ty'),
(null, 'Nhân sự', NOW(), 'Bộ phận quản lý nhân sự và các vấn đề liên quan');
select * from tbl_BoPhan;
delete from tbl_bophan where maBP = 'BP003';

use QLNV;
DELETE from tbl_BoPhan where maBP = "BP003";

INSERT INTO tbl_LoaiTK VALUES
(null,'ADMIN','Full Controls'), 
(null,'USER','Limited Controls');
select * from tbl_LoaiTK;

INSERT INTO tbl_TaiKhoan VALUES
(null,'LTK01','Nguyen Manh Cao Anh','Caoanhdeptrai9103','12345'),
(null,'LTK02','Mai Van Tinh','Tinhngu123','12345');
select * from tbl_TaiKhoan;
delete from tbl_TaiKhoan where maTK = "TK001";
UPDATE tbl_taiKhoan SET maLoaiTK = 'LTK01' where tenDNhap = 'NV001';

INSERT INTO tbl_NhanVien (maNV, hoTen, gioiTinh, danToc, chucVu, loaiHopDong, ngayDangKy, thoiGian, CMND_CCCD, SDT, hocVan, email, maPB, maLuong, ghiChu) VALUES 
(NULL, 'Nguyen Van A', 'Nam', 'Kinh', 'Nhan Vien', 'Hop dong thu viec', NOW(), 8, '123456789012', '0123456789', 'Dai Hoc', 'a@example.com', 'PB001', 'LUONG3', 'Ghi chu test'),
(NULL, 'Nguyen Van B', 'Nam', 'Kinh', 'Nhan Vien', 'Hop dong dai han', NOW(), 8, '123456789013', '0123456788', 'Dai Hoc', 'a@example.com', 'PB003', 'LUONG2', 'Ghi chu test'),
(NULL, 'Nguyen Van C', 'Nam', 'Kinh', 'Quan Ly', 'Hop dong dai han', NOW(), 8, '123456789014', '0123456788', 'Cap 3', 'a@example.com', 'PB004', 'LUONG2', 'Ghi chu test');
select * from tbl_NhanVien;

INSERT INTO tbl_BaoHiem VALUES
(null,'NV001','Ha Noi','2022-03-07','Ghi Chu'),
(null,'NV002','Thanh Hoa','2022-03-07','Ghi Chu');
select * from tbl_BaoHiem;

INSERT INTO tbl_HoSoThuViec (maNVTV, hoTen, ngaySinh, gioiTinh, CMND_CCCD, viTriThuViec, ngayBatDau, soThangThuViec, SDT, hocVan, maLuongTV, ghiChu) VALUES 
(null, 'Nguyen Van B', '1990-01-01', 'Nam', '123456789012', 'Quản lý Marketing', NOW(), 6, '0123456789', 'Đại học', 'LTV001', 'Hồ sơ thử việc cho nhân viên NVTV001'),
(null, 'Tran Thi C', '1995-02-15', 'Nữ', '987654321012', 'Nhân viên Kế toán', NOW(), 4, '0987654321', 'Cao đẳng', 'LTV002', 'Hồ sơ thử việc cho nhân viên NVTV002');
select * from tbl_HoSoThuViec;

INSERT INTO tbl_LSChamCong (maLSChamCong, maNV, ngayChamCong) VALUES 
(null, 'NV001', '2024-03-01 08:00:00'),
(null, 'NV002', '2024-03-02 09:30:00');
select * from tbl_LSChamCong;
delete from tbl_lschamcong where maNV = 'NV003';
INSERT INTO tbl_LSChamCong VALUES (null,'NV005',NOW());

INSERT INTO tbl_DuAn (maDA, tenDA, diaDiem, gia, hoaHong, ngayBatDau, ngayKetThuc, trangThai) VALUES 
(null, 'Dự Án ABC', 'Hanoi', 1000000000, 50000000, '2024-03-01', '2024-12-31', 'Đang triển khai'),
(null, 'Dự Án XYZ', 'HCMC', 800000000, 40000000, '2024-04-01', '2025-01-31', 'Chưa triển khai');
select * from tbl_DuAn;

select pc.maNV, da.maDA, da.tenDA, diaDiem, gia, hoaHong, ngayBatDau, ngayKetThuc, trangThai from tbl_DuAn da left join tbl_PhanCongDA pc on da.maDA = pc.maDA where maNV = 'NV001';

INSERT INTO tbl_tinhluong VALUES
('NV001', 'LUONG1', 3, 2024, 5000000, 1500000, 500000, 1000000, 0, 0, 15, 8000000, 'Ghi chu test 5'),
('NV002', 'LUONG2', 3, 2024, 7000000, 2500000, 700000, 1500000, 0, 0, 16, 11700000, 'Ghi chu test 6');
select * from tbl_tinhluong;
select * from tbl_Luong;
SELECT l.maLuong ,luongCoBan,phuCapCV,phuCapKhac,l.ghiChu FROM tbl_Luong l JOIN tbl_NhanVien nv ON l.maLuong = nv.maLuong WHERE maNV = 'NV001';

INSERT INTO tbl_TinhLuongTV VALUES
('NVTV001', 'LUONGTV1', 3, 2024, 3000000, 20, 2, 5100000, 'Ghi chu test 7'),
('NVTV002', 'LUONGTV2', 3, 2024, 3500000, 18, 1, 5550000, 'Ghi chu test 8');
select * from tbl_TinhLuongTV;
select * from tbl_LuongTV;

INSERT INTO tbl_ThoiViec VALUES
('NV005', 'Le Thi F', '2024-03-09', 'Nghỉ tự nguyện'),
('NV006', 'Nguyen Van G', '2024-03-09', 'Nghỉ tự nguyện');
select * from tbl_ThoiViec;

INSERT INTO tbl_KhenThuong VALUES
(1, 1000000, 'Duyet xuat sac'),
(2, 1500000, 'Thực hiện tốt nhiệm vụ');
select * from tbl_KhenThuong;

INSERT INTO tbl_KyLuat VALUES
(1, 500000, 'Vi phạm quy tắc công ty'),
(2, 700000, 'Gây gỗ trong nơi làm việc');
select * from tbl_KyLuat;

INSERT INTO tbl_PhanCongDA VALUES
('DA001', 'Du an XYZ', 'NV002', '2024-03-02'),
('DA002', 'Du an LMN', 'NV001', '2024-03-02');
select * from tbl_PhanCongDA;
select * from tbl_DuAn;

DELETE FROM tbl_PhanCongDA WHERE maDA ='' and maNV = '';

alter table tbl_phancongda
drop primary key;


select count(*)
from tbl_nhanvien nv join tbl_phancongda pc on nv.maNV = pc.maNV
where tenDA = 'Dự Án ABC';

select hoTen
from tbl_nhanvien
where maNV not in 
	(select nv.maNV
	from tbl_NhanVien nv join tbl_phancongda pcda on nv.maNV = pcda.maNV
	where tenDA = 'Du an ABC');

select nv.maNV,hoTen,maDA,tenDA,ngayPhanCong
from tbl_NhanVien nv join tbl_phancongda pcda on nv.maNV = pcda.maNV
where maDA = 'DA002'; 

INSERT INTO tbl_NghiPhep VALUES
(1, 'NV001', 'Nguyen Van A', 'Điều trị bệnh', '2024-03-10', '2024-03-15', 'Chưa xác nhận'),
(2, 'NV002', 'Nguyen Van B', 'Nghỉ phép cá nhân', '2024-03-10', '2024-03-15', 'Đã xác nhận');
select * from tbl_NghiPhep;
select * from tbl_NhanVien;
UPDATE tbl_NghiPhep SET trangThai = 'Chưa xác nhận' WHERE maNghiPhep = 2;
delete from tbl_nghiphep where maNghiPhep = 1;

INSERT INTO tbl_LSVangMat VALUES
('NV001', '2024-03-05', 'Nghỉ 1 ngày không lương'),
('NV002', '2024-03-06', 'Nghỉ 1 ngày có lương');
select * from tbl_LSVangMat;

INSERT INTO tbl_ThayDoiBangLuong VALUES
('NV001', 'LUONG2', 'LUONG1', '2024-03-07', 'Tăng lương'),
('NV002', 'LUONG1', 'LUONG2', '2024-03-07', 'Giảm lương');
select * from tbl_ThayDoiBangLuong;
delete from tbl_thaydoibangluong where lyDo = 'test';

