package mongo1;

public class Arbol {

	private int _id;
	private String tipo;
	private int altura;
	private double precio;

	public Arbol(int _id, String tipo, int altura, double precio) {
		this._id = _id;
		this.tipo = tipo;
		this.altura = altura;
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

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
