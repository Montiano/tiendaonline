package tiendaonline.modelo;

public class Pago {

	private int id;
	private Double total;
	
	
	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pago(int id, Double total) {
		super();
		this.id = id;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
