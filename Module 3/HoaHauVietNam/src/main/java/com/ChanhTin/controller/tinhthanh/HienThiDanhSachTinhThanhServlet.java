package com.ChanhTin.controller;

import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TinhThanh;
import com.ChanhTin.service.TinhThanhService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HienThiDanhSachTinhThanhServlet", urlPatterns = "/showTinhThanh")
public class HienThiDanhSachTinhThanhServlet extends HttpServlet {
    TinhThanhService tinhThanhService=new TinhThanhService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            danhSachTinhThanh(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void danhSachTinhThanh(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<TinhThanh> danhSachTinhThanh;

        danhSachTinhThanh = tinhThanhService.danhSach();
        request.setAttribute("danhSachTinhThanh", danhSachTinhThanh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/tinhthanh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
