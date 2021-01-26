package com.ChanhTin.model;

public class ThiSinh {
    private int idThiSinh;
    private String hoTen;
    private String ngaySinh;
    private String diaChiCuTru;
    private String sdt;
    private String email;
    private String chungMinhNhanDan;
    private String ngheNghiep;
    private String danToc;
    private String donViCongTac;
    private float chieuCao;
    private float canNang;
    private String nangKieuKhac;
    private String anhCaNhan;
    private String trangThaiDuyet="Chờ duyệt";
    private int idTinh;
    private int idQuocGia;
    private int idHocVan;
    private TinhThanh tinhThanh;
    private TrinhDoVanHoa hocVan;
    private QuocGia quocGia;

    public ThiSinh() {
    }

    public ThiSinh(int idThiSinh, String hoTen, String ngaySinh, String diaChiCuTru, String sdt, String email,
                   String chungMinhNhanDan, String ngheNghiep, int idHocVan, String danToc,
                   String donViCongTac, float chieuCao, float canNang, String nangKieuKhac,
                   String anhCaNhan, int idTinh, int idQuocGia, String trangThaiDuyet) {
        this.idThiSinh = idThiSinh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChiCuTru = diaChiCuTru;
        this.sdt = sdt;
        this.email = email;
        this.chungMinhNhanDan = chungMinhNhanDan;
        this.ngheNghiep = ngheNghiep;
        this.idHocVan = idHocVan;
        this.danToc = danToc;
        this.donViCongTac = donViCongTac;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nangKieuKhac = nangKieuKhac;
        this.anhCaNhan = anhCaNhan;
        this.idTinh = idTinh;
        this.idQuocGia = idQuocGia;
        this.trangThaiDuyet=trangThaiDuyet;
    }

    public ThiSinh(String hoTen, String ngaySinh, String diaChiCuTru, String sdt, String email,
                   String chungMinhNhanDan, String ngheNghiep, int idHocVan, String danToc,
                   String donViCongTac, float chieuCao, float canNang, String nangKieuKhac,
                   String anhCaNhan, int idTinh, int idQuocGia) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChiCuTru = diaChiCuTru;
        this.sdt = sdt;
        this.email = email;
        this.chungMinhNhanDan = chungMinhNhanDan;
        this.ngheNghiep = ngheNghiep;
        this.idHocVan = idHocVan;
        this.danToc = danToc;
        this.donViCongTac = donViCongTac;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nangKieuKhac = nangKieuKhac;
        this.anhCaNhan = anhCaNhan;
        this.idTinh = idTinh;
        this.idQuocGia = idQuocGia;
    }

    public ThiSinh(String hoTen, String ngaySinh, String diaChiCuTru, String sdt, String email,
                   String chungMinhNhanDan, String ngheNghiep, int idHocVan, String danToc,
                   String donViCongTac, float chieuCao, float canNang, String nangKieuKhac,
                   String anhCaNhan, int idTinh, int idQuocGia, String trangThaiDuyet) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChiCuTru = diaChiCuTru;
        this.sdt = sdt;
        this.email = email;
        this.chungMinhNhanDan = chungMinhNhanDan;
        this.ngheNghiep = ngheNghiep;
        this.idHocVan = idHocVan;
        this.danToc = danToc;
        this.donViCongTac = donViCongTac;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.nangKieuKhac = nangKieuKhac;
        this.anhCaNhan = anhCaNhan;
        this.idTinh = idTinh;
        this.idQuocGia = idQuocGia;
        this.trangThaiDuyet=trangThaiDuyet;
    }

    public int getIdThiSinh() {
        return idThiSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChiCuTru() {
        return diaChiCuTru;
    }

    public void setDiaChiCuTru(String diaChiCuTru) {
        this.diaChiCuTru = diaChiCuTru;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChungMinhNhanDan() {
        return chungMinhNhanDan;
    }

    public void setChungMinhNhanDan(String chungMinhNhanDan) {
        this.chungMinhNhanDan = chungMinhNhanDan;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public int getIdHocVan() {
        return idHocVan;
    }

    public void setIdHocVan(int idHocVan) {
        this.idHocVan = idHocVan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getDonViCongTac() {
        return donViCongTac;
    }

    public void setDonViCongTac(String donViCongTac) {
        this.donViCongTac = donViCongTac;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public float getCanNang() {
        return canNang;
    }

    public void setCanNang(float canNang) {
        this.canNang = canNang;
    }

    public String getNangKieuKhac() {
        return nangKieuKhac;
    }

    public void setNangKieuKhac(String nangKieuKhac) {
        this.nangKieuKhac = nangKieuKhac;
    }

    public String getAnhCaNhan() {
        return anhCaNhan;
    }

    public void setAnhCaNhan(String anhCaNhan) {
        this.anhCaNhan = anhCaNhan;
    }

    public int getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(int idTinh) {
        this.idTinh = idTinh;
    }

    public int getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(int idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    public String getTrangThaiDuyet() {
        return trangThaiDuyet;
    }

    public void setTrangThaiDuyet(String trangThaiDuyet) {
        this.trangThaiDuyet = trangThaiDuyet;
    }

    public TinhThanh getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(TinhThanh tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public TrinhDoVanHoa getHocVan() {
        return hocVan;
    }

    public void setHocVan(TrinhDoVanHoa hocVan) {
        this.hocVan = hocVan;
    }

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }
}
