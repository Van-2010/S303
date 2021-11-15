package mongo1;

public class Tickets {

	private int _id;
	private String tipo;
	private int altura;
	private double precio;
	private String material;
	private String color;
	private String creado;

	public Tickets(int _id, String tipo, int altura, double precio, String creado) {
		this._id = _id;
		this.tipo = tipo;
		this.altura = altura;
		this.precio = precio;
		this.creado = creado;

	}

	public Tickets(int _id, String tipo, String color, double precio, String creado) {

		this._id = _id;
		this.tipo = tipo;
		this.precio = precio;
		this.color = color;
		this.creado = creado;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCreado() {

		return creado;
	}

	public void setVendido(String creado) {
		this.creado = creado;
	}

}
