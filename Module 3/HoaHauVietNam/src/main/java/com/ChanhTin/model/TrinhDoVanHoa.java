package com.ChanhTin.model;

import java.util.List;

public class TrinhDoVanHoa {
    private int idTrinhDoVanHoa;
    private String tenTrinhDoVanHoa;

    private List<ThiSinh> danhSachThiSinh;

    public TrinhDoVanHoa() {
    }

    public TrinhDoVanHoa(int idTrinhDoVanHoa, String tenTrinhDoVanHoa) {
        this.idTrinhDoVanHoa = idTrinhDoVanHoa;
        this.tenTrinhDoVanHoa = tenTrinhDoVanHoa;
    }

    public int getIdTrinhDoVanHoa() {
        return idTrinhDoVanHoa;
    }

    public String getTenTrinhDoVanHoa() {
        return tenTrinhDoVanHoa;
    }

    public void setTenTrinhDoVanHoa(String tenTrinhDoVanHoa) {
        this.tenTrinhDoVanHoa = tenTrinhDoVanHoa;
    }

    public List<ThiSinh> getDanhSachThiSinh() {
        return danhSachThiSinh;
    }

    public void setDanhSachThiSinh(List<ThiSinh> danhSachThiSinh) {
        this.danhSachThiSinh = danhSachThiSinh;
    }
}
