package com.ChanhTin.dao;

import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TinhThanh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThiSinhDao implements InterfaceThiSinhDAO {
    private static final String jdbcURL;
    private static final String jdbcUsername;
    private static final String jdbcPassword;
    private static final String SELECT_ALL_THISINH_SQL;
    private static final String INSERT_THISINH_SQL;
    private static final String UPDATE_THISINH_SQL;
    private static final String DELETE_THISINH_SQL;
    private static final String GET_THISINH_BYID_SQL;
    public static final String CALL_GET_THISINH_BY_NAME;
    public static final String SELECT_THISINH_DA_DUYET_SQL;

    static {

        jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
        jdbcUsername = "root";
        jdbcPassword = "123123";
        SELECT_ALL_THISINH_SQL = "select * from hoahau.hosothisinh;";
        INSERT_THISINH_SQL = "insert into hoahau.hosothisinh (HoTen, NgaySinh, DiaChiCuTru, SoDienThoai, Email, " +
                "SoCMT/HoChieu, NgheNghiep, maTDVH, DanToc, DonViCongTac/HocTap, ChieuCao, CanNang, NangKhieu, " +
                "AnhCaNhan, maTP, maQG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        UPDATE_THISINH_SQL = "update hoahau.hosothisinh set HoTen=?, NgaySinh=?, DiaChiCuTru=?, SoDienThoai=?, " +
                "Email=?, SoCMT/HoChieu=?, NgheNghiep=?, maTDVH=?, DanToc=?, DonViCongTac/HocTap=?, ChieuCao=?, " +
                "CanNang=?, NangKhieu=?, AnhCaNhan=?, maTP=?, maQG=?, TrangThai=?  where id = ?;";
        DELETE_THISINH_SQL = "delete from hoahau.hosothisinh where id = ?;";
        GET_THISINH_BYID_SQL = "{call get_thisinh_by_id(?)}";
        CALL_GET_THISINH_BY_NAME = "{call get_thisinh_by_name(?)}";
        SELECT_THISINH_DA_DUYET_SQL = "select * from hoahau.hosothisinh where TrangThai='Đã duyệt'";

    }

    public ThiSinhDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<ThiSinh> getAll() throws Exception {
        System.out.println(SELECT_ALL_THISINH_SQL);
        List<ThiSinh> danhSachThiSinh = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THISINH_SQL);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int maHSTS = rs.getInt("maHSTS");
            String hoTen = rs.getString("HoTen");
            String ngaySinh = rs.getString("NgaySinh");
            String diaChiCuTru = rs.getString("DiaChiCuTru");
            String soDienThoai = rs.getString("SoDienThoai");
            String email = rs.getString("Email");
            String soCMT = rs.getString("SoCMT/HoChieu");
            String ngheNghiep = rs.getString("NgheNghiep");
            int maTDVH = Integer.parseInt(rs.getString("maTDVH"));
            String danToc = rs.getString("DanToc");
            String donViCongTac = rs.getString("DonViCongTac/HocTap");
            float chieuCao = Float.parseFloat(rs.getString("ChieuCao"));
            float canNang = Float.parseFloat(rs.getString("CanNang"));
            String nangKhieu = rs.getString("NangKhieu");
            String anhCaNhan = rs.getString("AnhCaNhan");
            int maTP = Integer.parseInt(rs.getString("maTP"));
            int maQG = Integer.parseInt(rs.getString("maQG"));
            String trangThai = rs.getString("TrangThai");

            danhSachThiSinh.add(new ThiSinh(maHSTS, hoTen, ngaySinh, diaChiCuTru, soDienThoai, email, soCMT, ngheNghiep,
                    maTDVH, danToc, donViCongTac, chieuCao, canNang, nangKhieu, anhCaNhan, maTP, maQG, trangThai));
        }

        return danhSachThiSinh;
    }

    @Override
    public boolean save(ThiSinh thiSinh) throws Exception {
        System.out.println(INSERT_THISINH_SQL);

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THISINH_SQL);

        preparedStatement.setString(1, thiSinh.getHoTen());
        preparedStatement.setString(2, thiSinh.getNgaySinh());
        preparedStatement.setString(3, thiSinh.getDiaChiCuTru());
        preparedStatement.setString(4, thiSinh.getSdt());
        preparedStatement.setString(5, thiSinh.getEmail());
        preparedStatement.setString(6, thiSinh.getChungMinhNhanDan());
        preparedStatement.setString(7, thiSinh.getNgheNghiep());
        preparedStatement.setInt(8, thiSinh.getIdHocVan());
        preparedStatement.setString(9, thiSinh.getDanToc());
        preparedStatement.setString(10, thiSinh.getDonViCongTac());
        preparedStatement.setFloat(11, thiSinh.getChieuCao());
        preparedStatement.setFloat(12, thiSinh.getCanNang());
        preparedStatement.setString(13, thiSinh.getNangKieuKhac());
        preparedStatement.setString(14, thiSinh.getAnhCaNhan());
        preparedStatement.setInt(15, thiSinh.getIdTinh());
        preparedStatement.setInt(16, thiSinh.getIdQuocGia());

        System.out.println(preparedStatement);

        return preparedStatement.executeUpdate() > 0;

    }

    @Override
    public boolean update(int id, ThiSinh thiSinh) throws Exception {

        System.out.println(UPDATE_THISINH_SQL);
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_THISINH_SQL);

        preparedStatement.setString(1, thiSinh.getHoTen());
        preparedStatement.setString(2, thiSinh.getNgaySinh());
        preparedStatement.setString(3, thiSinh.getDiaChiCuTru());
        preparedStatement.setString(4, thiSinh.getSdt());
        preparedStatement.setString(5, thiSinh.getEmail());
        preparedStatement.setString(6, thiSinh.getChungMinhNhanDan());
        preparedStatement.setString(7, thiSinh.getNgheNghiep());
        preparedStatement.setInt(8, thiSinh.getIdHocVan());
        preparedStatement.setString(9, thiSinh.getDanToc());
        preparedStatement.setString(10, thiSinh.getDonViCongTac());
        preparedStatement.setFloat(11, thiSinh.getChieuCao());
        preparedStatement.setFloat(12, thiSinh.getCanNang());
        preparedStatement.setString(13, thiSinh.getNangKieuKhac());
        preparedStatement.setString(14, thiSinh.getAnhCaNhan());
        preparedStatement.setInt(15, thiSinh.getIdTinh());
        preparedStatement.setInt(16, thiSinh.getIdQuocGia());

        System.out.println(preparedStatement);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception {
        System.out.println(DELETE_THISINH_SQL);
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_THISINH_SQL);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public ThiSinh findById(int id) throws Exception {

        System.out.println(GET_THISINH_BYID_SQL);
        ThiSinh thiSinh = null;

        Connection connection = getConnection();

        CallableStatement callableStatement = connection.prepareCall(GET_THISINH_BYID_SQL);

        callableStatement.setInt(1, id);

        ResultSet rs = callableStatement.executeQuery();


        while (rs.next()) {
            int maHSTS = rs.getInt("maHSTS");
            String hoTen = rs.getString("HoTen");
            String ngaySinh = rs.getString("NgaySinh");
            String diaChiCuTru = rs.getString("DiaChiCuTru");
            String soDienThoai = rs.getString("SoDienThoai");
            String email = rs.getString("Email");
            String soCMT = rs.getString("SoCMT/HoChieu");
            String ngheNghiep = rs.getString("NgheNghiep");
            int maTDVH = Integer.parseInt(rs.getString("maTDVH"));
            String danToc = rs.getString("DanToc");
            String donViCongTac = rs.getString("DonViCongTac/HocTap");
            float chieuCao = Float.parseFloat(rs.getString("ChieuCao"));
            float canNang = Float.parseFloat(rs.getString("CanNang"));
            String nangKhieu = rs.getString("NangKhieu");
            String anhCaNhan = rs.getString("AnhCaNhan");
            int maTP = Integer.parseInt(rs.getString("maTP"));
            int maQG = Integer.parseInt(rs.getString("maQG"));
            String trangThai = rs.getString("TrangThai");

            thiSinh = new ThiSinh(maHSTS, hoTen, ngaySinh, diaChiCuTru, soDienThoai, email, soCMT, ngheNghiep,
                    maTDVH, danToc, donViCongTac, chieuCao, canNang, nangKhieu, anhCaNhan, maTP, maQG, trangThai);
        }
        return thiSinh;
    }

    @Override
    public List<ThiSinh> danhSachThiSinh() throws Exception {
        return new ArrayList<>(getAll());
    }

    @Override
    public List<ThiSinh> findByName(String tenThiSinh) throws Exception {

        System.out.println(CALL_GET_THISINH_BY_NAME);
        List<ThiSinh> danhSachThiSinh = new ArrayList<>();
        Connection connection = getConnection();

        CallableStatement callableStatement = connection.prepareCall(CALL_GET_THISINH_BY_NAME);

        callableStatement.setString(1, tenThiSinh);

        ResultSet rs = callableStatement.executeQuery();


        while (rs.next()) {
            int maHSTS = rs.getInt("maHSTS");
            String hoTen = rs.getString("HoTen");
            String ngaySinh = rs.getString("NgaySinh");
            String diaChiCuTru = rs.getString("DiaChiCuTru");
            String soDienThoai = rs.getString("SoDienThoai");
            String email = rs.getString("Email");
            String soCMT = rs.getString("SoCMT/HoChieu");
            String ngheNghiep = rs.getString("NgheNghiep");
            int maTDVH = Integer.parseInt(rs.getString("maTDVH"));
            String danToc = rs.getString("DanToc");
            String donViCongTac = rs.getString("DonViCongTac/HocTap");
            float chieuCao = Float.parseFloat(rs.getString("ChieuCao"));
            float canNang = Float.parseFloat(rs.getString("CanNang"));
            String nangKhieu = rs.getString("NangKhieu");
            String anhCaNhan = rs.getString("AnhCaNhan");
            int maTP = Integer.parseInt(rs.getString("maTP"));
            int maQG = Integer.parseInt(rs.getString("maQG"));
            String trangThai = rs.getString("TrangThai");

            danhSachThiSinh.add(new ThiSinh(maHSTS,hoTen, ngaySinh, diaChiCuTru, soDienThoai, email, soCMT, ngheNghiep,
                    maTDVH, danToc, donViCongTac, chieuCao, canNang, nangKhieu, anhCaNhan, maTP, maQG, trangThai));
        }

        return danhSachThiSinh;
    }

    @Override
    public List<ThiSinh> findByTinhThanh(int idTinhThanh) throws Exception {
        System.out.println("CALL_GET_THISINH_BY_TINHTHANH");
        List<ThiSinh> danhSachThiSinh = new ArrayList<>();
        Connection connection = getConnection();

        CallableStatement callableStatement = connection.prepareCall("CALL_GET_THISINH_BY_TINHTHANH");

        callableStatement.setInt(1, idTinhThanh);

        ResultSet rs = callableStatement.executeQuery();


        while (rs.next()) {
            int maHSTS = rs.getInt("maHSTS");
            String hoTen = rs.getString("HoTen");
            String ngaySinh = rs.getString("NgaySinh");
            String diaChiCuTru = rs.getString("DiaChiCuTru");
            String soDienThoai = rs.getString("SoDienThoai");
            String email = rs.getString("Email");
            String soCMT = rs.getString("SoCMT/HoChieu");
            String ngheNghiep = rs.getString("NgheNghiep");
            int maTDVH = Integer.parseInt(rs.getString("maTDVH"));
            String danToc = rs.getString("DanToc");
            String donViCongTac = rs.getString("DonViCongTac/HocTap");
            float chieuCao = Float.parseFloat(rs.getString("ChieuCao"));
            float canNang = Float.parseFloat(rs.getString("CanNang"));
            String nangKhieu = rs.getString("NangKhieu");
            String anhCaNhan = rs.getString("AnhCaNhan");
            int maTP = Integer.parseInt(rs.getString("maTP"));
            int maQG = Integer.parseInt(rs.getString("maQG"));
            String trangThai = rs.getString("TrangThai");

            danhSachThiSinh.add(new ThiSinh(maHSTS,hoTen, ngaySinh, diaChiCuTru, soDienThoai, email, soCMT, ngheNghiep,
                    maTDVH, danToc, donViCongTac, chieuCao, canNang, nangKhieu, anhCaNhan, maTP, maQG, trangThai));
        }

        return danhSachThiSinh;

    }

    @Override
    public List<ThiSinh> danhSachDaDuyet() throws Exception {
        System.out.println(SELECT_THISINH_DA_DUYET_SQL);
        List<ThiSinh> danhSachThiSinh = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareCall(SELECT_THISINH_DA_DUYET_SQL);

        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {
            int maHSTS = rs.getInt("maHSTS");
            String hoTen = rs.getString("HoTen");
            String ngaySinh = rs.getString("NgaySinh");
            String diaChiCuTru = rs.getString("DiaChiCuTru");
            String soDienThoai = rs.getString("SoDienThoai");
            String email = rs.getString("Email");
            String soCMT = rs.getString("SoCMT/HoChieu");
            String ngheNghiep = rs.getString("NgheNghiep");
            int maTDVH = Integer.parseInt(rs.getString("maTDVH"));
            String danToc = rs.getString("DanToc");
            String donViCongTac = rs.getString("DonViCongTac/HocTap");
            float chieuCao = Float.parseFloat(rs.getString("ChieuCao"));
            float canNang = Float.parseFloat(rs.getString("CanNang"));
            String nangKhieu = rs.getString("NangKhieu");
            String anhCaNhan = rs.getString("AnhCaNhan");
            int maTP = Integer.parseInt(rs.getString("maTP"));
            int maQG = Integer.parseInt(rs.getString("maQG"));
            String trangThai = rs.getString("TrangThai");

            danhSachThiSinh.add(new ThiSinh(maHSTS,hoTen, ngaySinh, diaChiCuTru, soDienThoai, email, soCMT, ngheNghiep,
                    maTDVH, danToc, donViCongTac, chieuCao, canNang, nangKhieu, anhCaNhan, maTP, maQG, trangThai));
        }

        return danhSachThiSinh;

    }
}
