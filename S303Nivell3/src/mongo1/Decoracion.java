package mongo1;

public class Decoracion {

	private int _id;
	private String tipo;
	private String material;
	private double precio;

	public Decoracion(int _id, String tipo, String material, double precio) {

		this._id = _id;
		this.tipo = tipo;
		this.material = material;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
