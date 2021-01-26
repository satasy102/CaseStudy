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

@WebServlet(name = "HienThiDanhSachServlet", urlPatterns = "/showthisinh")
public class HienThiDanhSachThiSinhServlet extends HttpServlet {
    ThiSinhService thiSinhService = new ThiSinhService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "";
        try {
            switch (action) {
                case "cungtinhthanh":
                    danhSachThiSinhCungTinhThanh(request, response);
                    break;
                case "cungdantoc":
                    danhSachThiSinhCungDanToc(request, response);
                    break;
                case "cungtdvh":
                    danhSachThiSinhCungTrinhDoVanHoa(request, response);
                    break;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) action = "";
        try {
            switch (action) {
                case "daduyet":
                    danhSachThiSinhDaDuyet(request, response);
                break;
                case "chuaduyet":
                    danhSachThiSinhChuaDuyet(request, response);
                    break;
                case "biloai":
                    danhSachThiSinhBiLoai(request, response);
                    break;
                case "cungtinhthanh":
                    formDanhSachThiSinhCungTinhThanh(request,response);
                    break;
                case "cungdantoc":
                    formDanhSachThiSinhCungDanToc(request, response);
                    break;
                case "cungtdvh":
                    formDanhSachThiSinhCungTDVH(request,response);
                    break;
                case "timtheoten":
                    danhSachThiSinhTimTheoTen(request,response);
                default:
                    danhSachThiSinh(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void danhSachThiSinh(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<ThiSinh> danhSachThiSinh;

        danhSachThiSinh = thiSinhService.danhSach();
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/trangchuAdmin.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhDaDuyet(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<ThiSinh> danhSachThiSinh;

        danhSachThiSinh = thiSinhService.danhSachDaDuyet();
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/daduyet.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhChuaDuyet(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<ThiSinh> danhSachThiSinh;

        danhSachThiSinh = thiSinhService.danhSachChuaDuyet();
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/chuaduyet.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhBiLoai(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<ThiSinh> danhSachThiSinh;

        danhSachThiSinh = thiSinhService.danhSachBiLoai();
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/biloai.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formDanhSachThiSinhCungTinhThanh(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        TinhThanhService tinhThanhService=new TinhThanhService();
        List<TinhThanh> danhSachTinhThanh = tinhThanhService.danhSach();

        request.setAttribute("danhSachTinhThanh", danhSachTinhThanh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungtinhthanh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhCungTinhThanh(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        TinhThanhService tinhThanhService=new TinhThanhService();
        List<TinhThanh> danhSachTinhThanh = tinhThanhService.danhSach();

        request.setAttribute("danhSachTinhThanh", danhSachTinhThanh);

        List<ThiSinh> danhSachThiSinh;

        int id=Integer.parseInt(request.getParameter("id"));

        danhSachThiSinh = thiSinhService.timTheoTinhThanh(id);
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungtinhthanh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formDanhSachThiSinhCungDanToc(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        DanTocService danTocService=new DanTocService();
        List<DanToc> danhSachDanToc = danTocService.danhSach();

        request.setAttribute("danhSachDanToc", danhSachDanToc);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungdantoc.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhCungDanToc(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        DanTocService danTocService=new DanTocService();
        List<DanToc> danhSachDanToc = danTocService.danhSach();

        request.setAttribute("danhSachDanToc", danhSachDanToc);

        List<ThiSinh> danhSachThiSinh;

        int id=Integer.parseInt(request.getParameter("id"));
        danhSachThiSinh = thiSinhService.timTheoDanToc(id);
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungdantoc.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formDanhSachThiSinhCungTDVH(HttpServletRequest request, HttpServletResponse response) throws SQLException{
        TrinhDoVanHoaService trinhDoVanHoaService=new TrinhDoVanHoaService();
        List<TrinhDoVanHoa> danhSachTDVH = trinhDoVanHoaService.danhSach();

        request.setAttribute("danhSachTDVH", danhSachTDVH);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungtdvh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhCungTrinhDoVanHoa(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        TrinhDoVanHoaService trinhDoVanHoaService=new TrinhDoVanHoaService();
        List<TrinhDoVanHoa> danhSachTDVH = trinhDoVanHoaService.danhSach();

        request.setAttribute("danhSachTDVH", danhSachTDVH);

        List<ThiSinh> danhSachThiSinh;

        int id=Integer.parseInt(request.getParameter("id"));
        danhSachThiSinh = thiSinhService.timTheoTrinhDoVH(id);
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/cungtdvh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void danhSachThiSinhTimTheoTen(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<ThiSinh> danhSachThiSinh;

        String ten=request.getParameter("ten");
        danhSachThiSinh = thiSinhService.timTheoTen(ten);
        request.setAttribute("danhSachThiSinh", danhSachThiSinh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./admin-assets/timthisinh.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
