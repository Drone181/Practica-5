package paquete_pract5;

import javax.swing.JOptionPane;

public class Banco {
	public String banco;
	private String Sucursal;
	private String tel;
	boolean s;
	private Cuenta c = new Cuenta();
	
	public Banco() {
		this.banco = "Santander";
		this.Sucursal = "Paseo de los Heroes Centro Comercial Plaza Rio Tijuana 108 Loc. 11-A, Centro, 22010 Tijuana, B.C.";
		this.tel = "686 684 0250";
		this.s = false;
	}
	
	public String getUsuarioPin() {
		return c.getPin();
	}
	public String getUsuarioNombre() {
		return c.getNombre();
	}
	
	public void registrarCuenta() {
		float saldo;
		this.s = true;
		c.setNombre(JOptionPane.showInputDialog("Ingrese su nombre"));
		c.setPin(JOptionPane.showInputDialog("Ingrese su Pin"));
		do {
			saldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese saldo inicial"));
			if(saldo>=50&&saldo>0) {
				c.setSaldo(saldo);
			}
			else {
				JOptionPane.showMessageDialog(null,"*****Error, monto de ingreso no valido*****");
			}
		}while(saldo<50||saldo<0);
		JOptionPane.showMessageDialog(null, "*****Usuario Registrado*****");
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, "                                                                               ****"+banco + "****" + "\nSucursal: " + 
				Sucursal + "\nTelefono: " + tel + "\n\nNombre: " + c.getNombre()+"\nPin: "+c.getPin()+"\nSaldo: "+c.getSaldo());
	}
	
	public void retirarSaldo() {
		float d;
		float n1=c.getSaldo();
	
			do {
				d = Float.parseFloat(JOptionPane.showInputDialog("Saldo Actual: "+c.getSaldo()+"\n\nIngrese el monto a retirar\n\n(Digite 0 para regresar)"));
				if(d<=c.getSaldo()&&d>0) {
					c.setSaldo(n1-d);
					JOptionPane.showMessageDialog(null,"****OPERACION EXITOSA****\n\nSaldo anterior: "+n1+"\n\nMonto retirado: "+d
							+"\n\nSaldo actual: "+(double)Math.round(c.getSaldo()*100d)/100);
				}
				else if(d>c.getSaldo()){
					JOptionPane.showMessageDialog(null,"Error, monto de retiro sobrepasa el saldo actual");
				}
				else if(d==0) break;
				else {
					JOptionPane.showMessageDialog(null,"Error, monto de retiro no valido");
				}
			}while(d>n1||d<0);
		
	}
	
	public void depositar() {
		float n;
		float n1 = c.getSaldo();
		
		do {
			n = Float.parseFloat(JOptionPane.showInputDialog("Saldo Actual: "+c.getSaldo()+"\n\nDigite el monto a depositar\n\n(Digite 0 para regresar)"));
			if(n>0) {
				c.setSaldo(n1+n);
				JOptionPane.showMessageDialog(null,"****OPERACION EXITOSA****\n\nSaldo anterior: "+n1+"\n\nMonto depositado: "+n
						+"\n\nSaldo actual: "+(double)Math.round(c.getSaldo()*100d)/100);
			}
			else if(n==0) break;
			else {
				JOptionPane.showMessageDialog(null,"Error, monto de deposito no valido");
			}
		}while(n<0);
	
	}
}
