package pkgTortuga;

import java.util.Scanner;

public class Tortuga {
	static Scanner sc = new Scanner(System.in);
	static boolean pluma = false; //verificación de la pluma
	static char direccion = 'r'; //direccion inicial derecha
	static int fila = 0, col = 0; //invocando fila y columna
	public static void main(String[] args) {
		int[][] piso = new int [20][20];
		inicializador(piso);
		char res;
		
		do {
			dibujar(piso);
			System.out.println("Ingreser otro comando???[s-n]");
			res = sc.next().charAt(0);
		} while (res == 's' || res == 'S');
		
		
	}
	
	private static void dibujar(int[][] piso) {
		int cmd;
		int posiciones;
		cmd = menu();
		switch (cmd) {
		case 1:
			pluma = false;
			break;
		case 2:
			pluma = true;
			break;
		case 3:
			if (direccion == 'r') {//si direccion es derecha
				direccion = 'd'; //voltea hacia abajo
			} else {
				if (direccion == 'd') {//si direccion es abajo
					direccion = 'l'; //voltea hacia izquierda
				}else {
					if (direccion == 'l') {//Si direccion es izquierda
						direccion = 'u';//voltea hacia arriba 
					} else {
						direccion = 'r';//voltea hacia derecha
					}
				}
			}
			break;
		case 4:
			if (direccion == 'r') {//si direccion es derecha
				direccion = 'u'; //voltea hacia arriba
			} else {
				if (direccion == 'u') {//si direccion es arriba
					direccion = 'l'; //voltea hacia izquierda
				}else {
					if (direccion == 'l') {//Si direccion es izquierda
						direccion = 'd';//voltea hacia abajo
					} else {
						direccion = 'r';//voltea hacia derecha
					}
				}
			}
			break;
		case 5:
			System.out.println("Posiciones: ");
			posiciones = sc.nextInt(); //posiciones que avanza la tortuga
			if (pluma == false) {
				if (direccion == 'r') {//si direccion es derecha
					col+=posiciones;
				} else {
					if (direccion == 'd') {//si direccion es abajo
						fila+=posiciones;
					} else {
						if (direccion == 'l') {//si direccion es izquierda
							col-=posiciones;
						} else {
							fila -= posiciones;
						}
					}
				}
			} else { // la pluma está abajo
				if (direccion == 'r') {//si direccion es derecha
					for (int c = col; c < posiciones; c++) {
						piso[fila][c] = 1;
					}
					col+=posiciones;
				} else {
					if (direccion == 'd') {//si direccion es abajo
						for (int f = fila; f < posiciones; f++) {
							piso[f][col] = 1;
						}
						fila+=posiciones;
					} else {
						if (direccion == 'l') {//si direccion es izquierda
							for (int c = col; c > (col - posiciones); c--) {
								piso[fila][c] = 1;
							}
							col-=posiciones;
						} else {
							for (int f = fila; f > (fila - posiciones); f--) {
								piso[f][col] = 1;
							}
							fila -= posiciones;
						}
					}
				}
			}
			break;
		case 6:
			imprimir(piso);
			break;
		default:
			break;
		}
	}
	private static void imprimir(int[][] piso) {
		for (int f = 0; f < piso.length; f++) {
			for (int c = 0; c < piso[0].length; c++) {
				System.out.print(piso[f][c]+ " ");
			}
			System.out.println();
		}
	}
	private static int menu() {
		System.out.println("[1] Pluma Arriba");
		System.out.println("[2] Pluma Abajo");
		System.out.println("[3] Voltear Derecha");
		System.out.println("[4] Voltear Izquierda");
		System.out.println("[5] Avanzar");
		System.out.println("[6] Imprimir");
		System.out.println("[9] Fin");
		System.out.print("Elija un comando: ");
		int c = sc.nextInt();
		return c;
	}
	
	private static void inicializador(int[][] piso) {
		//inicializar la matriz con ceros(0)
		for (int f = 0; f < piso.length; f++) {
			for (int c = 0; c < piso.length; c++) {
				piso[f][c] = 0;
			}
		}
	}

}
