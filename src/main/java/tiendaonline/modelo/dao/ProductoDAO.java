package tiendaonline.modelo.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import tiendaonline.configuracion.Conexion;
import tiendaonline.modelo.Producto;



public class ProductoDAO {

	Connection conn;
	Conexion conexion = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public Producto listarPorID(int id) {
		String sql = "Select * From productos Where id="+id;
		Producto p = new Producto();
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setIdCategoria(rs.getInt("id_categoria"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				p.setFechaAlta(rs.getTimestamp("fecha_alta"));
				p.setFechaBaja(rs.getTimestamp("fecha_baja"));
				p.setImpuesto(rs.getFloat("impuesto"));
				p.setImagen(rs.getString("imagen"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Producto> listarProductos() {
		List<Producto> listaProductos = new ArrayList<Producto>();
		String sql = "Select * From productos";
		try {
			conn=conexion.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setIdCategoria(rs.getInt("id_categoria"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setPrecio(rs.getDouble("precio"));
				p.setStock(rs.getInt("stock"));
				p.setFechaAlta(rs.getTimestamp("fecha_alta"));
				p.setFechaBaja(rs.getTimestamp("fecha_baja"));
				p.setImpuesto(rs.getFloat("impuesto"));
				p.setImagen(rs.getString("imagen"));
				listaProductos.add(p);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProductos;
	}
	
	public void listarImagen(int id, HttpServletResponse response) {
		String sql="Select * From productos Where id="+id;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			outputStream = response.getOutputStream();
			conn=conexion.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				inputStream = rs.getBinaryStream("Imagen");
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i = 0;
			while ((i=bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
