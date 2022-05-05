package tiendaonline.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tiendaonline.modelo.Carrito;

import tiendaonline.modelo.Pedido;
import tiendaonline.modelo.Producto;
import tiendaonline.modelo.Usuario;
import tiendaonline.modelo.dao.PedidoDAO;
import tiendaonline.modelo.dao.ProductoDAO;


/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoDAO productoDAO = new ProductoDAO();
	Producto producto = new Producto();
	List<Producto> listaProductos = new ArrayList<Producto>();
	
	List<Carrito> listaCarrito = new ArrayList<Carrito>();
	int item;
	double totalPago = 0.0;
	int cantidad = 1;
	
	int idProducto;
	Carrito carrito;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//		String accion = request.getParameter("accion");
		//    	listaProductos = productoDAO.listarProductos();
		//    	System.out.println("hola");
		//    	System.out.println(accion);
		//    	for (int i = 0; i < listaProductos.size(); i++) {
		//			System.out.println("-" + listaProductos.get(i).toString());
		//		}
		//    	switch (accion) {
		//			case "ejemplo":
		//				
		//				break;
		//	
		//			default:			
		//				request.setAttribute("listaProductos", listaProductos);
		//				request.getRequestDispatcher("index.jsp").forward(request, response);
		//			}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String accion = request.getParameter("accion");
//		int id = Integer.parseInt(request.getParameter("id"));	
//		System.out.println("El id es:" + id);
		
		System.out.println(accion);
		
		listaProductos = productoDAO.listarProductos();
		
		for (int i = 0; i < listaProductos.size(); i++) {
			System.out.println("-" + listaProductos.get(i).toString());
		}
		
		switch (accion) { 
		
			case "AgregarCarrito":
				int posicion = 0;
				cantidad = 1;
				idProducto = Integer.parseInt(request.getParameter("id"));
				System.out.println("El idp es:" + idProducto);
				producto = productoDAO.listarPorID(idProducto);
				if(listaCarrito.size()>0) {
					for (int i = 0; i < listaCarrito.size(); i++) {
						if (idProducto == listaCarrito.get(i).getIdProducto()) {
							posicion = i;
						}
					}
					if (idProducto == listaCarrito.get(posicion).getIdProducto()) {
						cantidad = listaCarrito.get(posicion).getCantidad() + cantidad;
						double subTotal = listaCarrito.get(posicion).getPrecioCompra() * cantidad;
						listaCarrito.get(posicion).setCantidad(cantidad);
						listaCarrito.get(posicion).setSubTotal(subTotal);
					} else {
						aniadirCarrito();
					}
				} else {
					aniadirCarrito();	
				}				
				request.setAttribute("contador", listaCarrito.size());
				request.getRequestDispatcher("Controlador?accion=inicio").forward(request, response);				
				break;
				
			case "Delete":
				int idProducto = Integer.parseInt(request.getParameter("idProducto"));
				for (int i = 0; i < listaCarrito.size(); i++) {
					if(listaCarrito.get(i).getIdProducto()==idProducto) {
						listaCarrito.remove(i);
						System.out.println("Producto eliminado correctamente");
					}
				}
				request.getRequestDispatcher("Controlador?accion=Carrito").forward(request, response);
				break;
				
			case "ActualizarCantidad":
				int idPro = Integer.parseInt(request.getParameter("idProducto"));
				int cant = Integer.parseInt(request.getParameter("Cantidad"));
				for (int i = 0; i < listaCarrito.size(); i++) {
					if(listaCarrito.get(i).getIdProducto() == idPro) {
						listaCarrito.get(i).setCantidad(cant);
						double st = listaCarrito.get(i).getPrecioCompra()*cant;
						listaCarrito.get(i).setSubTotal(st);
					}
				}
				request.getRequestDispatcher("Controlador?accion=Carrito").forward(request, response);
				break;
				
			case "Carrito":
				totalPago=0.0;
				request.setAttribute("listaCarrito", listaCarrito);
				for (int i = 0; i < listaCarrito.size(); i++) {
					totalPago = totalPago + listaCarrito.get(i).getSubTotal();
				}
				request.setAttribute("totalPago", totalPago);
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
				break;
			
			case "Comprar":
				totalPago = 0.0;
				idProducto = Integer.parseInt(request.getParameter("id"));
				System.out.println("El idp es:" + idProducto);
				producto = productoDAO.listarPorID(idProducto);
				item = item + 1;
				carrito = new Carrito();
				carrito.setItem(item);
				carrito.setIdProducto(producto.getId());
				carrito.setNombre(producto.getNombre());
				carrito.setDescripcion(producto.getDescripcion());
				carrito.setPrecioCompra(producto.getPrecio());
				carrito.setCantidad(cantidad);
				carrito.setSubTotal(cantidad * producto.getPrecio());
				listaCarrito.add(carrito);
				for (int i = 0; i < listaCarrito.size(); i++) {
					totalPago = totalPago + listaCarrito.get(i).getSubTotal();
				}
				request.setAttribute("totalPago", totalPago);
				request.setAttribute("listaCarrito", listaCarrito);
				request.setAttribute("contador", listaCarrito.size());
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
				break;
			
			case "Salir":
				listaCarrito = new ArrayList<Carrito>();
				request.getRequestDispatcher("Controlador?accion=inicio").forward(request, response);
				break;
			
			case "GenerarPedido":	
				Usuario cliente = new Usuario();
				cliente.setId(1);
				PedidoDAO pedidoDAO = new PedidoDAO();
				Pedido pedido = new Pedido(Timestamp.valueOf(LocalDateTime.now()), "Tarjeta", "Realizado", "Fac.2154875", totalPago, cliente, listaCarrito);
				int respuesta = pedidoDAO.GenerarPedido(pedido);
				if(respuesta!=0 && totalPago>0) {
					request.getRequestDispatcher("pedido_realizado.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("error_pedido.jsp").forward(request, response);
				}
				break;
			default: 
				request.setAttribute("contador", listaCarrito.size());
				request.setAttribute("listaProductos", listaProductos);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

	}

	public void aniadirCarrito() {
		item = item + 1;
		Carrito carrito = new Carrito();
		carrito.setItem(item);
		carrito.setIdProducto(producto.getId());
		carrito.setNombre(producto.getNombre());
		carrito.setDescripcion(producto.getDescripcion());
		carrito.setPrecioCompra(producto.getPrecio());
		carrito.setCantidad(cantidad);
		carrito.setSubTotal(cantidad*producto.getPrecio());
		listaCarrito.add(carrito);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
