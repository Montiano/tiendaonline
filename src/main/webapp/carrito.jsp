<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ page import="java.util.ArrayList"%>
<%@ page import="tiendaonline.modelo.Carrito"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"> </a>
    
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
	          <a class="nav-link" href="Controlador?accion=inicio"><i class="bi bi-bag-plus"></i>Seguir comprando</a>
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
		<h3>Carrito:</h3><br>
		<div class="row">
			<div class="col-sm-8">
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th>ITEM</th>
							<th>NOMBRE</th>
							<th>DESCRIPCION</th>
							<th>PRECIO</th>
							<th>CANTIDAD</th>
							<th>SUBTOTAL</th>
							<th>ACCION</th>
						</tr>
					</thead>
					<%				
				ArrayList<Carrito> listaCarrito = (ArrayList<Carrito>) request.getAttribute("listaCarrito");
				if (listaCarrito != null) {
					for (Carrito c : listaCarrito) {
						%>	
					<tbody>
						<tr>
							<td><%=c.getItem()%></td>
							<td><%=c.getNombre()%></td>
							<td><%=c.getDescripcion()%></td>
							<td><%=c.getPrecioCompra()%></td>
							<td><%=c.getCantidad()%>
								<%-- <input type="number" min="1" id="Cantidad" value="<%=c.getCantidad()%>" class="form-control text-center">
								<a href="Controlador?accion=Comprar&id=<%=c.getIdProducto() %>">Actualizar</a> --%>
							</td>
							<td><%=c.getSubTotal()%></td>
							<td>
								<input type=hidden id="idProducto" value="<%=c.getIdProducto()%>">
								<a href="Controlador?accion=Delete&idProducto=<%=c.getIdProducto()%>" id="btnDelete" onclick="Eliminado()">Eliminar</a>
							</td>
						</tr>
					</tbody>
					<%}
					}%>
				</table>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-header">
						<h3>Pedido:</h3>
					</div>
					<div class="card-body">
						<label>Subtotal:</label>
						<input type="text" value="<%=request.getAttribute("totalPago")%>" readonly="readonly" class="form-control">
						<label>Descuento:</label>
						<input type="text" value="0.00€" readonly="readonly" class="form-control">
						<label>Total a pagar:</label>
						<input type="text" value="<%=request.getAttribute("totalPago")%>" readonly="readonly" class="form-control">
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-success w-100 visually-hidden" role="button">Realizar pago</a><hr>
						<a href="Controlador?accion=GenerarPedido" class="btn btn-danger col-12">Generar pedido</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script src="js/funciones.js" type="text/javascript"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>