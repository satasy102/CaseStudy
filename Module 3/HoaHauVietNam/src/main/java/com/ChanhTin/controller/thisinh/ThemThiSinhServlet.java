package com.ChanhTin.controller;

import com.ChanhTin.model.DanToc;
import com.ChanhTin.model.ThiSinh;
import com.ChanhTin.model.TinhThanh;
import com.ChanhTin.model.TrinhDoVanHoa;
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
import java.util.List;

@WebServlet(name = "ThemThiSinhServlet", urlPatterns = "/themthisinh")
public class ThemThiSinhServlet extends HttpServlet {
    TinhThanhService tinhThanhService = new TinhThanhService();
    ThiSinhService thiSinhService = new ThiSinhService();
    DanTocService danTocService=new DanTocService();
    TrinhDoVanHoaService trinhDoVanHoaService=new TrinhDoVanHoaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        createThiSinh(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            formthemthisinh(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void formthemthisinh(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<TinhThanh> danhSachTinhThanh = tinhThanhService.danhSach();
        request.setAttribute("danhSachTinhThanh", danhSachTinhThanh);

        List<DanToc> danhSachDanToc = danTocService.danhSach();
        request.setAttribute("danhSachDanToc", danhSachDanToc);

        List<TrinhDoVanHoa> danhSachTDVH = trinhDoVanHoaService.danhSach();
        request.setAttribute("danhSachTDVH", danhSachTDVH);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/themthisinh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createThiSinh(HttpServletRequest request, HttpServletResponse response) {
        try {
            ThiSinh thiSinh = getThiSinh(request);

            request.setAttribute("message", thiSinhService.them(thiSinh));

            List<TinhThanh> danhSachTinhThanh = tinhThanhService.danhSach();
            request.setAttribute("danhSachTinhThanh", danhSachTinhThanh);

            List<DanToc> danhSachDanToc = danTocService.danhSach();
            request.setAttribute("danhSachDanToc", danhSachDanToc);

            List<TrinhDoVanHoa> danhSachTDVH = trinhDoVanHoaService.danhSach();
            request.setAttribute("danhSachTDVH", danhSachTDVH);

            RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/themthisinh.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    private ThiSinh getThiSinh(HttpServletRequest request) {

        String ten = request.getParameter("ten");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChiCuTru = request.getParameter("diaChiCuTru");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String cmt = request.getParameter("cmt");
        String ngheNghiep = request.getParameter("ngheNghiep");
        int maTrinhDoVH = Integer.parseInt(request.getParameter("trinhDoVH"));
        int maDanToc = Integer.parseInt(request.getParameter("danToc"));
        String donViCongTac = request.getParameter("donViCongTac");
        float chieuCao = Float.parseFloat(request.getParameter("chieuCao"));
        float canNang = Float.parseFloat(request.getParameter("canNang"));
        String nangKieuKhac = request.getParameter("nangKieuKhac");
        String anhCaNhan = request.getParameter("anhCaNhan");
        int maTinh = Integer.parseInt(request.getParameter("daiDienTinhThanh"));

        return new ThiSinh(ten, ngaySinh, diaChiCuTru, sdt, email, cmt, ngheNghiep, maTrinhDoVH, maDanToc,
                donViCongTac, chieuCao, canNang, nangKieuKhac, anhCaNhan, maTinh);
    }

}
