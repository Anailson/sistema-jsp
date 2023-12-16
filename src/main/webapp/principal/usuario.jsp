<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <!DOCTYPE html>
    <html lang="en">
    <jsp:include page="head.jsp"></jsp:include>

    <body>
        <jsp:include page="theme-loader.jsp"></jsp:include>
        <div id="pcoded" class="pcoded">
            <div class="pcoded-overlay-box"></div>
            <div class="pcoded-container navbar-wrapper">
                <jsp:include page="navbar.jsp"></jsp:include>

                <div class="pcoded-main-container">
                    <div class="pcoded-wrapper">
                        <jsp:include page="navbarmainmenu.jsp"></jsp:include>
                        <div class="pcoded-content">
                            <jsp:include page="page-header.jsp"></jsp:include>

                            <div class="pcoded-inner-content">
                                <div class="main-body">
                                    <div class="page-wrapper">


                                        <div class="row">
                                            <div class="col-sm-12">
                                                <!-- Basic Form Inputs card start -->
                                                <div class="card">

                                                    <div class="card-block">
                                                        <h4 class="sub-title">Cad. Usuário</h4>
                                                        <form class="form-material">
                                                            <div class="form-group form-default">
                                                                <input type="text" name="footer-email"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Id:</label>
                                                            </div>
                                                            <div class="form-group form-default">
                                                                <input type="text" name="footer-email"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Nome:</label>
                                                            </div>

                                                            <div class="form-group form-default">
                                                                <input type="text" name="footer-email"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Email:</label>
                                                            </div>
                                                            <div class="form-group form-default">
                                                                <input type="password" name="footer-email"
                                                                    class="form-control" required="">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Password</label>
                                                            </div>
                                                            <button
                                                                class="btn btn-primary btn-round waves-effect waves-light">Primary
                                                                Button</button>
                                                            <button
                                                                class="btn btn-success btn-round waves-effect waves-light">Success
                                                                Button</button>
                                                            <button
                                                                class="btn btn-info btn-round waves-effect waves-light">Info
                                                                Button</button>
                                                            <button
                                                                class="btn btn-warning btn-round waves-effect waves-light">Warning
                                                                Button</button>
                                                            <button
                                                                class="btn btn-danger btn-round waves-effect waves-light">Danger
                                                                Button</button>
                                                            <button
                                                                class="btn btn-inverse btn-round waves-effect waves-light">Inverse
                                                                Button</button>
                                                            <button
                                                                class="btn btn-disabled btn-round disabled waves-effect waves-light">Disabled
                                                                Button</button>

                                                        </form>

                                                    </div><!--card-block-->


                                                </div><!--card-->
                                            </div><!--col-sm-12-->
                                        </div><!--row-->
                                    </div><!--page-wrapper-->

                                </div><!-- main-body -->
                            </div><!-- pcoded-inner-contentr -->
                            <div id="styleSelector"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div><!-- pcoded -->


        <jsp:include page="javascriptfile.jsp"></jsp:include>
    </body>

    </html>