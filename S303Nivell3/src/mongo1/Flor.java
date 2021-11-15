package mongo1;

public class Flor {

	private int _id;
	private String tipo;
	private String color;
	private double precio;

	public Flor(int _id, String tipo, String color, double precio) {

		this._id = _id;
		this.tipo = tipo;
		this.color = color;
		this.precio = precio;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
