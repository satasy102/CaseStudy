package com.ChanhTin.controller;

import com.ChanhTin.model.DanToc;
import com.ChanhTin.model.TinhThanh;
import com.ChanhTin.service.DanTocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HienThiDanhSachDanTocServlet",urlPatterns = "/showdantoc")
public class HienThiDanhSachDanTocServlet extends HttpServlet {

    DanTocService danTocService=new DanTocService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            danhSachDanToc(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void danhSachDanToc(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<DanToc> danhSachDanToc;

        danhSachDanToc = danTocService.danhSach();
        request.setAttribute("danhSachDanToc", danhSachDanToc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/dantoc.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
