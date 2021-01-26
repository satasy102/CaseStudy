package com.ChanhTin.controller;

import com.ChanhTin.service.DanTocService;
import com.ChanhTin.service.ThiSinhService;
import com.ChanhTin.service.TinhThanhService;
import com.ChanhTin.service.TrinhDoVanHoaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "XoaThiSinhServlet", urlPatterns = "/xoathisinh")
public class XoaThiSinhServlet extends HttpServlet {
    TinhThanhService tinhThanhService = new TinhThanhService();
    ThiSinhService thiSinhService = new ThiSinhService();
    DanTocService danTocService=new DanTocService();
    TrinhDoVanHoaService trinhDoVanHoaService=new TrinhDoVanHoaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            xoaThiSinh(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void xoaThiSinh(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("message", thiSinhService.xoa(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("showthisinh");
        try {
            dispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
