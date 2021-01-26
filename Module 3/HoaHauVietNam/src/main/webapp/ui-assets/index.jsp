<%--
  Created by IntelliJ IDEA.
  User: docha
  Date: 20/10/02
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Hoa hậu Việt Nam</title>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css"/>
    <!-- CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet"/>
</head>

<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#home" onclick="animateScroll(this)">
            <img src="assets/img/logos/logo.png" alt="logo"/></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ml-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ml-auto">
                <li class="nav-item"><a class="nav-link js-scroll-trigger" onclick="animateScroll(this)"
                                        href="#home">Trang Chủ</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" onclick="animateScroll(this)"
                                        href="#regista">Đăng ký Online</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" onclick="animateScroll(this)"
                                        href="#male">Danh sách đăng ký</a>
                </li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" onclick="animateScroll(this)"
                                        href="#female">Danh sách trúng tuyển</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="masthead" id="home">

</header>

<section class="page-section bg-light" id="regista">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Đăng ký dự thi</h2>
            <h3 class="section-subheading text-muted">Các mục đánh dấu * là thông tin bắt buộc
            </h3>
        </div>
        <div class="d-flex justify-content-center h-100">
            <div class="card bg-light">
                <article class="card-body mx-auto" style="max-width: 400px;">
                    <form>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                            </div>
                            <input name="" class="form-control" placeholder="Họ và tên" type="text">
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                            </div>
                            <input name="" class="form-control" placeholder="Email" type="email">
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
                            </div>
                            <input name="" class="form-control" placeholder="Số điện thoại" type="text">
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                            </div>
                            <input class="form-control" placeholder="Tạo mật khẩu" type="password">
                        </div>
                        <div class="form-group input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                            </div>
                            <input class="form-control" placeholder="Lặp lại mật khẩu" type="password">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Tạo tài khoản
                            </button>
                        </div>
                        <p class="text-center">Bạn đã có tài khoản? <a href="#ĐăngNhập">Đăng nhập</a>
                        </p>
                    </form>
                </article>
            </div>
        </div>
    </div>
</section>

<section class=" page-section bg-light" id="male">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Danh Sách Đăng Ký</h2>
            <h3 class="section-subheading text-muted">Thí sinh đã đăng ký</h3>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam1.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C01 OFFW/RED</div>
                        <div class="portfolio-caption-subheading text-muted">375,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam2.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C01 OFFW/YELLOW</div>
                        <div class="portfolio-caption-subheading text-muted">375,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam3.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C03 BLACK</div>
                        <div class="portfolio-caption-subheading text-muted">430,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam4.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C03 DR.BROWN</div>
                        <div class="portfolio-caption-subheading text-muted">430,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam5.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C03 L.GREY</div>
                        <div class="portfolio-caption-subheading text-muted">430,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nam6.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C03 TAN</div>
                        <div class="portfolio-caption-subheading text-muted">430,000₫</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="page-section bg-light" id="female">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Danh Sách Đã Duyệt</h2>
            <h3 class="section-subheading text-muted">Danh sách hồ sơ đã được duyệt qua vòng loại</h3>
        </div>
        <div class="row">
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu1.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C12 WHITE</div>
                        <div class="portfolio-caption-subheading text-muted">375,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu2.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C20 PINK</div>
                        <div class="portfolio-caption-subheading text-muted">420,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu3.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C20 RED</div>
                        <div class="portfolio-caption-subheading text-muted">420,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu4.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C20 CHOCOLATE</div>
                        <div class="portfolio-caption-subheading text-muted">420,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu5.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C20 GREY</div>
                        <div class="portfolio-caption-subheading text-muted">420,000₫</div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-sm-6 mb-4">
                <div class="portfolio-item">
                    <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content"></div>
                        </div>
                        <img class="img-fluid" src="assets/img/portfolio/nu6.webp" alt=""/>
                    </a>
                    <div class="portfolio-caption">
                        <div class="portfolio-caption-heading">C20 NAVY</div>
                        <div class="portfolio-caption-subheading text-muted">420,000₫</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6 my-3 text-align-center">
                <a href="#">
                    <div class="btn btn-primary btn-xl text-uppercase">TIN TỨC</div>
                </a>
            </div>
            <div class="col-md-3 col-sm-6 my-3 text-align-center">
                <a href="#">
                    <div class="btn btn-primary btn-xl text-uppercase">VIDEO</div>
                </a>
            </div>
            <div class="col-md-3 col-sm-6 my-3 text-align-center">
                <a href="#">
                    <div class="btn btn-primary btn-xl text-uppercase">HÌNH ẢNH</div>
                </a>
            </div>
            <div class="col-md-3 col-sm-6 my-3 text-align-center">
                <a href="#">
                    <div class="btn btn-primary btn-xl text-uppercase">BẢO HÀNH </br>1 NĂM</div>
                </a>
            </div>
        </div>
    </div>
</div>

<footer class="footer py-4">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-left">Đỗ Chánh Tín C620I1 CodeGym Huế</div>
            <div class="col-lg-4 my-3 my-lg-0">
                <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
            </div>
            <div class="col-lg-4 text-lg-right">
                <a class="mr-3" href="#!">Privacy Policy</a>
                <a href="#!">Terms of Use</a>
            </div>
        </div>
    </div>
</footer>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>

<script src="js/scripts.js"></script>


</body>

</html>
