<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela que mostra os Erros</title>
</head>
<body>
   <h1>Mensagem de erro, entre em contato com a equipe de suporte do sistema</h1>
   <textarea rows="50" cols="50">${msg}</textarea>
   
   <%
   	 out.print(request.getAttribute("msg"));
   %>

</body>
</html>