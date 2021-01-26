package com.ChanhTin.dao;

import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TrinhDoVanHoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoVanHoaDAO implements BaseDAO<TrinhDoVanHoa> {
    private static final String jdbcURL;
    private static final String jdbcUsername;
    private static final String jdbcPassword;
    private static final String SELECT_ALL_TRINHDOVANHOA_SQL;
    private static final String INSERT_TRINHDOVANHOA_SQL;
    private static final String UPDATE_TRINHDOVANHOA_SQL;
    private static final String DELETE_TRINHDOVANHOA_SQL;
    private static final String GET_TRINHDOVANHOA_BYID_SQL;

    static {
        jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useEncoding=true&characterEncoding=UTF-8";
        jdbcUsername = "root";
        jdbcPassword = "123123";
        SELECT_ALL_TRINHDOVANHOA_SQL = "select * from hoahau.trinhdovanhoa;";
        INSERT_TRINHDOVANHOA_SQL = "insert into hoahau.trinhdovanhoa tenTP VALUES ?;";
        UPDATE_TRINHDOVANHOA_SQL = "update hoahau.trinhdovanhoa set tenTDVH = ? where id = ?;";
        DELETE_TRINHDOVANHOA_SQL = "delete from hoahau.trinhdovanhoa where id = ?;";
        GET_TRINHDOVANHOA_BYID_SQL = "{call get_trinhdovanhoa_by_id(?)}";
    }

    public TrinhDoVanHoaDAO() {
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
    public List<TrinhDoVanHoa> getAll() throws Exception {

        List<TrinhDoVanHoa> trinhDoVanHoa = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRINHDOVANHOA_SQL);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int maTDVH = rs.getInt("maTDVH");
            String tenTDVH = rs.getString("tenTDVH");
            trinhDoVanHoa.add(new TrinhDoVanHoa(maTDVH, tenTDVH));
        }

        return trinhDoVanHoa;
    }

    @Override
    public boolean save(TrinhDoVanHoa trinhDoVanHoa) throws Exception {

        System.out.println(INSERT_TRINHDOVANHOA_SQL);

        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRINHDOVANHOA_SQL);

        preparedStatement.setString(1, trinhDoVanHoa.getTenTrinhDoVanHoa());

        System.out.println(preparedStatement);

        return preparedStatement.executeUpdate() > 0;

    }

    @Override
    public boolean update(int id, TrinhDoVanHoa trinhDoVanHoa) throws Exception {
        System.out.println(UPDATE_TRINHDOVANHOA_SQL);
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(UPDATE_TRINHDOVANHOA_SQL);
        statement.setString(1, trinhDoVanHoa.getTenTrinhDoVanHoa());

        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws Exception {
        System.out.println(DELETE_TRINHDOVANHOA_SQL);
        Connection connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(DELETE_TRINHDOVANHOA_SQL);
        statement.setInt(1, id);

        return statement.executeUpdate() > 0;
    }

    @Override
    public TrinhDoVanHoa findById(int id) throws Exception {
        TrinhDoVanHoa trinhDoVanHoa = null;

        Connection connection = getConnection();

        CallableStatement callableStatement = connection.prepareCall(GET_TRINHDOVANHOA_BYID_SQL);

        callableStatement.setInt(1, id);

        ResultSet rs = callableStatement.executeQuery();

        while (rs.next()) {

            String tenTDVH = rs.getString("tenTDVH");

            trinhDoVanHoa = new TrinhDoVanHoa(id, tenTDVH);
        }

        return trinhDoVanHoa;
    }

    @Override
    public List<ThiSinh> danhSachThiSinh() throws Exception{
        return null;
    }
}
