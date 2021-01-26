package com.ChanhTin.model;

import java.util.List;

public class QuocGia {
    private int idQG;
    private String tenQG;
    private List<ThiSinh> danhSachThiSinh;

    public QuocGia() {}

    public QuocGia(int idQG, String tenQG) {
        this.idQG = idQG;
        this.tenQG = tenQG;
    }

    public int getIdQG() {
        return idQG;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }

    public List<ThiSinh> getDanhSachThiSinh() {
        return danhSachThiSinh;
    }

    public void setDanhSachThiSinh(List<ThiSinh> danhSachThiSinh) {
        this.danhSachThiSinh = danhSachThiSinh;
    }
}
