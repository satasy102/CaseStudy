package com.ChanhTin.dao;

import com.ChanhTin.model.QuocGia;
import com.ChanhTin.model.ThiSinh;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuocGiaDAO extends DAOHelper implements BaseDAO<QuocGia> {
    private static final String SELECT_ALL_QUOCGIA_SQL;
    private static final String INSERT_QUOCGIA_SQL;
    private static final String UPDATE_QUOCGIA_SQL;
    private static final String DELETE_QUOCGIA_SQL;
    private static final String GET_QUOCGIA_BYID_SQL;

    static {
        SELECT_ALL_QUOCGIA_SQL = "select * from hoahau.quocgia;";
        INSERT_QUOCGIA_SQL = "insert into hoahau.quocgia tenTP VALUES ?;";
        UPDATE_QUOCGIA_SQL = "update hoahau.quocgia set tenTDVH = ? where id = ?;";
        DELETE_QUOCGIA_SQL = "delete from hoahau.quocgia where id = ?;";
        GET_QUOCGIA_BYID_SQL = "{call get_quocgia_by_id(?)}";
    }

    public QuocGiaDAO() {
    }


    @Override
    public List<QuocGia> getAll() throws SQLException {

        List<QuocGia> danhSachQuocGia = new ArrayList<>();

        connection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUOCGIA_SQL);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int maQG = rs.getInt("maQG");
            String tenQG = rs.getString("tenQG");
            danhSachQuocGia.add(new QuocGia(maQG, tenQG));
        }

        rs.close();
        preparedStatement.close();
        disconnect();

        return danhSachQuocGia;
    }

    @Override
    public boolean save(QuocGia quocGia) throws SQLException {

        System.out.println(INSERT_QUOCGIA_SQL);

        connection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUOCGIA_SQL);

        preparedStatement.setString(1, quocGia.getTenQG());

        System.out.println(preparedStatement);

        boolean rowSaved=preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();

        return rowSaved;
    }

    @Override
    public boolean update(int id, QuocGia quocGia) throws SQLException {
        System.out.println(UPDATE_QUOCGIA_SQL);
        connection();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUOCGIA_SQL);
        preparedStatement.setString(1, quocGia.getTenQG());

        boolean rowUpdated=preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();

        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        System.out.println(DELETE_QUOCGIA_SQL);
        connection();

        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUOCGIA_SQL);
        preparedStatement.setInt(1, id);

        boolean rowDeleted=preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();

        return rowDeleted;
    }

    @Override
    public QuocGia findById(int id) throws SQLException {
        QuocGia quocGia = null;

        connection();

        CallableStatement callableStatement = connection.prepareCall(GET_QUOCGIA_BYID_SQL);

        callableStatement.setInt(1, id);

        ResultSet rs = callableStatement.executeQuery();

        while (rs.next()) {

            String tenQG = rs.getString("tenQG");

            quocGia = new QuocGia(id, tenQG);
        }

        rs.close();
        callableStatement.close();
        disconnect();

        return quocGia;
    }

    @Override
    public List<ThiSinh> danhSachThiSinh() throws SQLException{
        return null;
    }
}
