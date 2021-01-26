package com.ChanhTin.controller;

import com.ChanhTin.model.DanToc;
import com.ChanhTin.model.TinhThanh;
import com.ChanhTin.model.TrinhDoVanHoa;
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

@WebServlet(name = "ThemTinhThanhServlet",urlPatterns = "/themtinhthanh")
public class ThemTinhThanhServlet extends HttpServlet {
    TinhThanhService tinhThanhService=new TinhThanhService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenTinh=request.getParameter("tenTinh");
        try {
            tinhThanhService.them(new TinhThanh(tenTinh));
            response.sendRedirect("showTinhThanh");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        RequestDispatcher dispatcher= request.getRequestDispatcher("./admin-assets/themtinhthanh.jsp");
        dispatcher.forward(request,response);
    }




}
