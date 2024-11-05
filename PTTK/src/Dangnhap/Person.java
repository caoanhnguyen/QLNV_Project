/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dangnhap;

/**
 *
 * @author Admin
 */
public class Person {
    private String taiKhoan; //MaKH - MaNV
    private String matKhau;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh; //Gioi tinh
    private String diaChi;
    private String SDT;

    public Person() {
    }

    public Person(String taiKhoan, String matKhau, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String SDT) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public String getSDT() {
        return SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "Person{" + "taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", SDT=" + SDT + '}';
    }
    
    public String toStringFile()
    {
        return taiKhoan+"$"+matKhau+"$"+hoTen+"$"+ngaySinh+"$"+gioiTinh+"$"+diaChi+"$"+SDT;
    }
    
    public int kiemTraTaiKhoanHopLe(String taiKhoan)
    {
        if(taiKhoan.contains(" "))
            return 1;//Tài khoản chứa dấu cách -> ko hợp lệ
        if(taiKhoan.length()==0)
            return 2;//Tài khoản chưa nhập
        return 0;//Tài khoản hợp lệ
    }
    
    public int kiemTraMatKhauHopLe(String matKhau)
    {
        if(matKhau.contains(" "))
            return 1;//Mật khẩu chứa dấu cách -> ko hợp lệ
        if(matKhau.length()==0)
            return 2;//Mật khẩu chưa nhập
        return 0;//Mật khẩu hợp lệ
    }
}