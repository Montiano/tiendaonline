package tiendaonline.modelo;

import java.sql.Timestamp;
import java.util.List;

public class Pedido {

	private int id;
	private int idCliente;
	private Timestamp fecha;
	private String metodoPago;
	private String estado;
	private String numFactura;
	private Double total;
	
	private Usuario cliente;
	
	private List<Carrito> detallePedido;

	public Pedido() {
		super();
	}

	public Pedido(Timestamp fecha, String metodoPago, String estado, String numFactura, Double total,
			Usuario cliente, List<Carrito> detallePedido) {
		super();
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.numFactura = numFactura;
		this.total = total;
		this.cliente = cliente;
		this.detallePedido = detallePedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public List<Carrito> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<Carrito> detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", fecha=" + fecha + ", metodoPago=" + metodoPago
				+ ", estado=" + estado + ", numFactura=" + numFactura + ", total=" + total + ", cliente=" + cliente
				+ ", detallePedido=" + detallePedido + "]";
	}
	
	
}
