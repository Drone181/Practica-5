package paquete_pract5;

import javax.swing.JOptionPane;

public class Main {
	public final static int TAM = 10;

	public static void main(String[] args) {
		int e=0;
		Banco b[] = new Banco[TAM];
		for(int i=0;i<TAM;i++) {
			b[i] = new Banco();
		}
		boolean s = false;
		int op1,op2;
		String llave = new String();
		
		do {
			op1 = Integer.parseInt(JOptionPane.showInputDialog("********MENU********\n\n1.Crear una cuenta\n2.Acceder a una cuenta\n3.Salir"));
			
			switch(op1) {
			case 1:
				for(int i=0;i<TAM;i++) {
					if(b[i].s==false) {
						b[i].registrarCuenta();
						b[i].mostrar();
						break;
					}
					
					else{
						System.out.println("*************No");
					}
				}
				
				break;
			case 2:
				llave = JOptionPane.showInputDialog("Ingrese su Pin");
				
				for(int i=0;i<TAM;i++) {
					
					if(llave.equals(b[i].getUsuarioPin())) {
						b[i].mostrar();
						do {
							op2 = Integer.parseInt(JOptionPane.showInputDialog("****Cuenta Encontrada****\n\nBienvenido: "+b[i].getUsuarioNombre()+"\n\n1.Depositar dinero\n2.Retirar dinero\n3.Regresar"));
							
							switch(op2) {
							case 1:
								b[i].depositar();
								break;
							case 2:
								b[i].retirarSaldo();
								break;
							case 3:
								break;
							default:
								JOptionPane.showMessageDialog(null, "***Ingrese una opcion valida***");
								break;
							}
						}while(op2!=3);
						e=1;
					}
					if(i==1&&e==0) {
						JOptionPane.showMessageDialog(null, "****Usuario No Encontrado****");
					}
				}
				e=0;
				break;
				
			case 3:
				s = true;
				JOptionPane.showMessageDialog(null,"Hasta Pronto!!");
				break;
			default:
				JOptionPane.showMessageDialog(null,"++++Opcion no valida++++");
				break;
			}
		}while(s==false);
			

	}
	

}
