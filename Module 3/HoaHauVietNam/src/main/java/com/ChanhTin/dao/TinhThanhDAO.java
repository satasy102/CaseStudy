package com.ChanhTin.dao;

import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TinhThanh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TinhThanhDAO implements BaseDAO<TinhThanh> {
    private static final String jdbcURL;
    private static final String jdbcUsername;
    private static final String jdbcPassword;
    private static final String SELECT_ALL_TINHTHANH_SQL;
    private static final String INSERT_TINHTHANHPHO_SQL;
    private static final String UPDATE_TINHTHANH_SQL;
    private static final String DELETE_TINHTHANH_SQL;
    private static final String GET_TINHTHANH_BYID_SQL;

    static {
        jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
        jdbcUsername = "root";
        jdbcPassword = "123123";
        SELECT_ALL_TINHTHANH_SQL = "select * from hoahau.tinhthanhpho;";
        INSERT_TINHTHANHPHO_SQL = "insert into hoahau.tinhthanhpho (tenTP, loaiTP, maQG) VALUES (?, ?, ?);";
        UPDATE_TINHTHANH_SQL = "update hoahau.tinhthanhpho set tenTP = ?,loaiTP= ?, maQG =? where id = ?;";
        DELETE_TINHTHANH_SQL = "delete from hoahau.tinhthanhpho where id = ?;";
        GET_TINHTHANH_BYID_SQL = "{call get_tinhthanh_by_id(?)}";
    }

    public TinhThanhDAO() {
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
    public List<TinhThanh> getAll() throws Exception {

        List<TinhThanh> danhSachTinhThanh = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TINHTHANH_SQL);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int maTP = rs.getInt("maTP");
            String tenTP = rs.getString("tenTP");
            String loaiTP = rs.getString("loaiTP");
            int maQG = Integer.parseInt(rs.getString("maQG"));
            danhSachTinhThanh.add(new TinhThanh(maTP, tenTP, loaiTP, maQG));
        }

        return danhSachTinhThanh;
    }

    @Override
    public boolean save(TinhThanh tinhThanh) throws Exception {

        System.out.println(INSERT_TINHTHANHPHO_SQL);

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TINHTHANHPHO_SQL);

        preparedStatement.setString(1, tinhThanh.getTenTinh());
        preparedStatement.setString(2, tinhThanh.getLoaiTinh());
        preparedStatement.setInt(3, tinhThanh.getIdQG());

        System.out.println(preparedStatement);

        return preparedStatement.executeUpdate() > 0;

    }

        @Override
    public boolean update(int idTinh, TinhThanh tinhThanh) throws Exception {

        System.out.println(UPDATE_TINHTHANH_SQL);
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TINHTHANH_SQL);
        preparedStatement.setString(1, tinhThanh.getTenTinh());
        preparedStatement.setString(2, tinhThanh.getLoaiTinh());
        preparedStatement.setInt(3, tinhThanh.getIdQG());
        preparedStatement.setInt(4, idTinh);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception {
        System.out.println(DELETE_TINHTHANH_SQL);
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TINHTHANH_SQL);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public TinhThanh findById(int id) throws Exception {
        TinhThanh tinhThanh = null;

        Connection connection = getConnection();

        CallableStatement callableStatement = connection.prepareCall(GET_TINHTHANH_BYID_SQL);

        callableStatement.setInt(1, id);

        ResultSet rs = callableStatement.executeQuery();

        while (rs.next()) {

            String tenTinh = rs.getString("tenTinh");

            String loaiTinh = rs.getString("loaiTinh");

            int maQG = rs.getInt("maQG");

            tinhThanh = new TinhThanh(id, tenTinh, loaiTinh, maQG);
        }

        return tinhThanh;
    }

    @Override
    public List<ThiSinh> danhSachThiSinh() throws Exception{
        return null;
    }
}
