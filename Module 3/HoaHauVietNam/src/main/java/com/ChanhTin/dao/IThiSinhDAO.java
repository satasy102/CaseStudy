package com.ChanhTin.dao;

import com.ChanhTin.model.ThiSinh;

import java.util.List;

public interface InterfaceThiSinhDAO extends BaseDAO<ThiSinh> {

    List<ThiSinh> findByName(String ten) throws Exception;

    List<ThiSinh> findByTinhThanh(int idTinhThanh) throws Exception;

    List<ThiSinh> danhSachDaDuyet() throws Exception;
}
