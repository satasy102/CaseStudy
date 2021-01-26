<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/09/28
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Thêm hoặc sửa thông tin thí sinh</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<h1>Tạo hoặc chỉnh sửa thông tin khách hàng</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="showthisinh">Trở lại</a>
</p>
<form method="post" action="themthisinh">
  <fieldset>
    <legend>Thông tin thí sinh</legend>
    <table>
      <tr>
        <td>Họ tên:</td>
        <td><input type="text" name="ten" required></td>
      </tr>
      <tr>
        <td>Ngày sinh:</td>
        <td><input type="text" name="ngaySinh" required>
        </td>
      </tr>
      <tr>
        <td>Địa chỉ:</td>
        <td><input type="text" name="diaChiCuTru" required></td>
      </tr>
      <tr>
        <td>Số điện thoại :</td>
        <td><input type="text" name="sdt" required></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><input type="email" name="email" required></td>
      </tr>
      <tr>
        <td>Chứng minh thư:</td>
        <td><input type="text" name="cmt" required></td>
      </tr>
      <tr>
        <td>Nghề nghiệp:</td>
        <td><input type="text" name="ngheNghiep" required></td>
      </tr>
      <tr>
        <td>Trình độ văn hóa:</td>
        <td>
          <select name="trinhDoVH">
            <c:forEach items="${danhSachTDVH}" var="danhSachTDVH">
              <option value="${danhSachTDVH.idTrinhDoVanHoa}">${danhSachTDVH.tenTrinhDoVanHoa}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td>Dân tộc:</td>
        <td>
          <select name="danToc">
            <c:forEach items="${danhSachDanToc}" var="danhSachDanToc">
              <option value="${danhSachDanToc.idDanToc}">${danhSachDanToc.tenDanToc}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td>Đơn vị công tác:</td>
        <td><input type="text" name="donViCongTac" required></td>
      </tr>
      <tr>
        <td>Chiều cao:</td>
        <td>
          <input type="text" name="chieuCao" required>
        </td>
      </tr>
      <tr>
        <td>Cân nặng:</td>
        <td><input type="text" name="canNang" required></td>
      </tr>
      <tr>
        <td>Năng khiếu khác:</td>
        <td><input type="text" name="nangKieuKhac" required></td>
      </tr>
      <tr>
        <td>Ảnh cá nhân:</td>
        <td><input type="text" name="anhCaNhan" required></td>

      </tr>
      <tr>
        <td>Đại diện tỉnh thành:</td>
        <td><select name="daiDienTinhThanh">
          <c:forEach items="${danhSachTinhThanh}" var="tinhThanh">
            <option value="${tinhThanh.idTinh}">${tinhThanh.tenTinh}</option>
          </c:forEach>
        </select>
        </td>
      </tr>
      <tr>
        <td><input type="submit" value="Xong"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
