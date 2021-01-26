package com.ChanhTin.model;

import java.util.List;

public class TinhThanh {
    private int idTinh;
    private String tenTinh;
    private String loaiTinh;
    private int idQG;
    private QuocGia quocGia;
    List<ThiSinh> danhSachThiSinh;


    public TinhThanh() {}

    public TinhThanh(int idTinh, String tenTinh, String loaiTinh, int idQG) {
        this.idTinh = idTinh;
        this.tenTinh = tenTinh;
        this.loaiTinh=loaiTinh;
        this.idQG=idQG;
    }

    public int getIdTinh() { return idTinh;}

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public String getLoaiTinh() {
        return loaiTinh;
    }

    public void setLoaiTinh(String loaiTinh) {
        this.loaiTinh = loaiTinh;
    }

    public int getIdQG() {
        return idQG;
    }

    public void setIdQG(int idQG) {
        this.idQG = idQG;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    public List<ThiSinh> getDanhSachThiSinh() { return danhSachThiSinh;}

    public void setDanhSachThiSinh(List<ThiSinh> danhSachThiSinh) { this.danhSachThiSinh = danhSachThiSinh;}
}
