package tiendaonline.modelo;

import java.io.InputStream;
import java.sql.Timestamp;

public class Producto {

	private int id;
	private int idCategoria;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Timestamp fechaAlta;
	private Timestamp fechaBaja;
	private float impuesto;

	private String imagen;
	
	public Producto() {
		super();
	}
	public Producto(Producto producto) {
		super();
	}
	
	public Producto(int id, int idCategoria, String nombre, String descripcion, double precio, int stock,
			Timestamp fechaAlta, Timestamp fechaBaja, float impuesto, String imagen) {
		super();
		this.id = id;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.impuesto = impuesto;
		this.imagen = imagen;
	}
	
	public Producto(int id, String nombre, String descripcion, double precio, int stock, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
	}
	
	
	public Producto(int idCategoria, String nombre, String descripcion, double precio, int stock, Timestamp fechaAlta,
			Timestamp fechaBaja, float impuesto, String imagen) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.impuesto = impuesto;
		this.imagen = imagen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Timestamp getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public float getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", fechaAlta=" + fechaAlta + ", fechaBaja="
				+ fechaBaja + ", impuesto=" + impuesto + ", imagen=" + imagen + "]";
	}
	
	
	
}
