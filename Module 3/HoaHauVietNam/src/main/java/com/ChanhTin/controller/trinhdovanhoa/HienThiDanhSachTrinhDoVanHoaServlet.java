package com.ChanhTin.controller;

import com.ChanhTin.model.DanToc;
import com.ChanhTin.model.TrinhDoVanHoa;
import com.ChanhTin.service.TrinhDoVanHoaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HienThiDanhSachTrinhDoVanHoaServlet", urlPatterns = "/showTDVH")
public class HienThiDanhSachTrinhDoVanHoaServlet extends HttpServlet {

    TrinhDoVanHoaService trinhDoVanHoaService=new TrinhDoVanHoaService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            danhSachTDVH(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void danhSachTDVH(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<TrinhDoVanHoa> danhSachTDVH;

        danhSachTDVH = trinhDoVanHoaService.danhSach();
        request.setAttribute("danhSachTrinhDoVH", danhSachTDVH);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/trinhdovh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
