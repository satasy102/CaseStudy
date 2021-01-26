package com.ChanhTin.dao;

import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TrinhDoVanHoa;

import java.util.List;

public interface BaseDAO<G> {

    List<G> getAll()  throws Exception;

    boolean save(G object) throws Exception;

    boolean update(int id, G object) throws Exception;

    boolean delete(int id) throws Exception;

    G findById(int id) throws Exception;

    List<ThiSinh> danhSachThiSinh() throws Exception;
}
