<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
	<%@ page import="java.util.ArrayList"%>
<%@ page import="tiendaonline.modelo.Producto"%>
<html>
<head>
<title></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
      
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Tienda</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="Controlador?accion=inicio">Inicio</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Ofertas del día</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="Controlador?accion=Carrito"><i class="bi bi-cart-plus">(<label style="color: orange"><%=request.getAttribute("contador")%></label>)</i>Carrito</a>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	      <ul class="navbar-nav">
		      <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Iniciar sesión
		          </a>
		          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item" href="#">Action</a></li>
		            <li><a class="dropdown-item" href="#">Another action</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="#">Something else here</a></li>
		          </ul>
		        </li>
	        </ul>
	    </div>
	  </div>
	</nav>
	<div class="container mt-4">
		<div class="row">
			<% ArrayList<Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProductos");
			if (listaProductos != null) {
				for (Producto producto : listaProductos) {
					%>					
			<div class="col-sm-4">
				<div class="card  text-center">
					<div class="card-header">
						<label class="text-center"><%=producto.getNombre().toUpperCase() %></label>
					</div>
					<div class="card-body">
						<i><%=producto.getPrecio()%> €</i>
						<img src="images/producto.png" width="200" height="180">
					</div>
					<div class="card-footer text-center">
						<label class="form-label"><%=producto.getDescripcion()%></label>
						<label class="form-label">ID:<%=producto.getId()%></label>
						<div>
							<a href="Controlador?accion=AgregarCarrito&id=<%=producto.getId() %>" class="btn btn-outline-info">Agregar al carrito<i class="bi bi-cart-plus-fill"></i></a><hr>
							<a href="Controlador?accion=Comprar&id=<%=producto.getId() %>" class="btn btn-danger">Comprar</a>
						</div>
					</div>
				</div>
			</div>
			<br><br>
			<% }
			}%>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<h1>Aquí iría el login modal</h1><br>
			<h2>Pulse inicio en el menú de arriba o en el siguiente botón</h2><hr>
			 <a class="btn btn-primary w-50" href="Controlador?accion=inicio">Continuar al catálogo</a> 
		</div>		
	</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>
