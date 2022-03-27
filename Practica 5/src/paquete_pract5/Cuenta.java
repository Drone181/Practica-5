package paquete_pract5;

 public class Cuenta {
	private String nombre;
	private String pin;
	private float saldo;
	
	public Cuenta() {
		this.nombre = null;
		this.pin = null;
		this.saldo = 0;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getPin() {
		return pin;
	}
	public float getSaldo() {
		return saldo;
	}

}
