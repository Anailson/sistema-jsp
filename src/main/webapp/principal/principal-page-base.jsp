<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

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
                    <div class="page-body">
                      <div class="row">
                        <h2>conteudo das paginas do sistema - BASE</h2>
                      </div>
                    </div>
                  </div>
                  <div id="styleSelector"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Warning Section Ends -->

    <jsp:include page="javascriptfile.jsp"></jsp:include>
  </body>
</html>
