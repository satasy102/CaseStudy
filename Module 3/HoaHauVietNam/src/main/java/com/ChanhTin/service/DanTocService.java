package com.ChanhTin.service;

import com.ChanhTin.dao.QuocGiaDAO;
import com.ChanhTin.model.QuocGia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuocGiaService extends ValidateHelper implements BaseService<QuocGia> {
    private final QuocGiaDAO quocGiaDAO=new QuocGiaDAO();

    public QuocGiaService() {
    }

    @Override
    public String result(QuocGia quocGia) throws SQLException {
        if(!regexName(quocGia.getTenQG(),80,1))
        return "481";
        return "200";
    }

    @Override
    public List<QuocGia> danhSach() throws SQLException {
        return new ArrayList<>(quocGiaDAO.getAll());
    }

    @Override
    public String them(QuocGia quocGia) throws SQLException {
        String result=result(quocGia);
        if(result.equals("200")&&quocGiaDAO.save(quocGia))
            return "Thêm thành công";
        return result;
    }

    @Override
    public String sua(int id, QuocGia quocGia) throws SQLException {
        String result=result(quocGia);

        if (result.equals("200")&& quocGiaDAO.update(id,quocGia))
            return "Sửa thành công";
        return result;
    }

    @Override
    public String xoa(int id) throws SQLException {
        if (quocGiaDAO.delete(id))
            return "Xóa thành công";
        return "Xóa không thành công";
    }

    @Override
    public QuocGia timTheoID(int id) throws SQLException {
        return quocGiaDAO.findById(id);
    }
}
