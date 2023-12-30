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
                                                        <form class="form-material" action="<%= request.getContextPath()%>/ServletUsuarioController" method="post">
                                                            <div class="form-group form-default">
                                                                <input type="text" name="id" id="id" readonly="readonly" class="form-control"  value="${modelLogin.id}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Id:</label>
                                                            </div>
                                                            <div class="form-group form-default">
                                                                <input type="text" name="nome" id="nome" class="form-control" required="required" value="${modelLogin.nome}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Nome:</label>
                                                            </div>

                                                            <div class="form-group form-default">
                                                                <input type="email" name="email" id="email"  class="form-control" required="required"  autocomplete="off" value="${modelLogin.email}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Email:</label>
                                                            </div>
                                                            <div class="form-group form-default">
                                                                <input type="text" name=login id="login"  class="form-control" required="required" autocomplete="off" value="${modelLogin.login}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Login:</label>
                                                            </div>
                                                            <div class="form-group form-default">
                                                                <input type="password" name="senha" id="senha"  class="form-control" required="required" autocomplete="off" value="${modelLogin.senha}">
                                                                <span class="form-bar"></span>
                                                                <label class="float-label">Senha:</label>
                                                            </div>
                                                            <button class="btn btn-primary btn-round waves-effect waves-light">Novo</button>
                                                            <button class="btn btn-success btn-round waves-effect waves-light">Salvar</button>
                                                            <button class="btn btn-info btn-round waves-effect waves-light">Excluir</button>    
                                                        

                                                        </form>

                                                    </div><!--card-block-->


                                                </div><!--card-->
                                            </div><!--col-sm-12-->
                                        </div><!--row-->
                                      
                                    </div><!--page-wrapper-->
										  <span>${msg}</span><!-- Mensagem de controller ao salvar usuário -->
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