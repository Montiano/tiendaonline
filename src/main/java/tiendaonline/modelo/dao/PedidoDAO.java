package tiendaonline.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tiendaonline.configuracion.Conexion;
import tiendaonline.modelo.Carrito;
import tiendaonline.modelo.Pedido;

public class PedidoDAO {

	Connection conn;
	Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	int resultado;
	
	public int GenerarPedido(Pedido pedido) {
		int id;
		String sql = "Insert into pedidos(id_usuario,fecha,metodo_pago,estado,num_factura,total) values (?,?,?,?,?,?)";
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pedido.getCliente().getId());
			ps.setTimestamp(2, pedido.getFecha());
			ps.setString(3, pedido.getMetodoPago());
			ps.setString(4, pedido.getEstado());
			ps.setString(5, pedido.getNumFactura());
			ps.setDouble(6, pedido.getTotal());
			resultado = ps.executeUpdate();
			
			sql = "Select @@IDENTITY AS id";
			rs = ps.executeQuery();
			rs.next();
			id = rs.getInt("id");
			rs.close();
			
			for (Carrito detalle : pedido.getDetallePedido()) {
				sql = "Insert into detalles_pedido(id_pedido,id_producto,precio_unidad,unidades,impuesto,total) values (?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setInt(2, detalle.getIdProducto());
				ps.setDouble(3, detalle.getPrecioCompra());
				ps.setInt(4, detalle.getCantidad());
				ps.setDouble(5, (Double) null);
				ps.setDouble(6, detalle.getSubTotal());
				resultado = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
		
	}
}
