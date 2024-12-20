<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" 
	 integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	
	<title>Curso JSP</title>
	
	<style type="text/css">
	
	form {
	 position: absolute;
	 top: 40%;
	 left: 33%;
	 right: 33%;
	}
	h5 {
	 position: absolute;
	 top: 30%;
	 left: 33%;	
	}
	.msg{
	 position: absolute;
	 top: 80%;
	 left: 33%;	
	 color: red;
	 font: 12px;
	}	
	
	</style>
</head>
<body>
		
		<h5>Treinamento de JSP - JDV Treinamento</h5>
				
	<form action="<%=request.getContextPath()%>/ServletLogin" method="post" class="row g-3 needs-validation" novalidate>
	
	<input type="hidden" value="<%= request.getParameter("url")%>" name="url">
	
	<div class="mb-3">
	    <label class="form-label">Login:</label>
	    <input type="text" class="form-control" name="login" required="required">
		    <div class="invalid-feedback"> 
	     		Por favor, informar login. 
	    	</div>
	    	<div class="valid-feedback"> 
	     		Usu�rio informado. 
	    	</div>
  	</div>
  	
  	<div class="mb-3">
	    <label class="form-label">Senha:</label>
	    <input type="password" class="form-control" name="senha" required="required">
	    <div class="invalid-feedback">
	     	   Por favor, informar senha.
	    </div>
	    <div class="valid-feedback"> 
	     		Senha informada. 
	    	</div>
  	</div>
 	 		
	 <input  class="btn btn-primary" type="submit" value="Acessar">
	
	</form>
	
	<!-- Ler a msg que vem da ServletLogin -->
	<h3 class="msg" >${msg}</h3>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<!-- VALIDANDO DO BOOTSTRAP SITE https://getbootstrap.com/docs/5.3/forms/validation/ -->
<script type="text/javascript">
//Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()

</script>
</body>
</html>