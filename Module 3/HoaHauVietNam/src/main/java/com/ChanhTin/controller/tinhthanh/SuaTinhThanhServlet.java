package com.ChanhTin.controller;

import com.ChanhTin.model.DanToc;
import com.ChanhTin.model.ThiSinh;
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

@WebServlet(name = "SuaTinhThanhServlet", urlPatterns = "/suatinhthanh")
public class SuaTinhThanhServlet extends HttpServlet {
    TinhThanhService tinhThanhService=new TinhThanhService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            suaTinhThanh(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            formSuaTinhThanh(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void formSuaTinhThanh(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        TinhThanh tinhThanh = tinhThanhService.timTheoID(id);
        request.setAttribute("tinhThanh", tinhThanh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/suatinhthanh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void suaTinhThanh(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        int id=Integer.parseInt(request.getParameter("id"));
        String tenTinh=request.getParameter("tenTinh");

        TinhThanh tinhThanh=new TinhThanh(id,tenTinh);

        request.setAttribute("message", tinhThanhService.sua(tinhThanh.getIdTinh(), tinhThanh));

        request.setAttribute("tinhThanh", tinhThanh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/suatinhthanh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
