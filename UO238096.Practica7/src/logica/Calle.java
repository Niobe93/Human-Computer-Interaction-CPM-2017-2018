package logica;

public class Calle {
	
	public static final int DIM = 11;
	public static final int POSICION_META = DIM -1;
	private Casilla[] casillas = new Casilla[DIM];
	private int trampa;
	private int superPoder;
	private int arbol;

	public Calle(boolean casillaTrampa, boolean casillaArbol) {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
		}
		setSuperPoder(generateAleatorio());

		if (casillaArbol == true) {
			setArbol(generateAleatorio());
		}

		if (casillaTrampa == true) {
			setTrampa(generateAleatorio());
		}

		while (trampa == arbol)

			setTrampa(generateAleatorio());

	}
	
	public void setNumeroCasillas(int casillas){
		
		
		
	}

	public int getArbol() {
		return arbol;
	}
	public boolean isTrampaActiva() {
		if(trampa!=0)			
			return true;
		return false;
	}	

	private void setArbol(int arbol) {
		this.arbol=arbol;
		
	}
	private void setTrampa(int trampa) {
		this.trampa=trampa;		
	}	
	private void setSuperPoder(int superPoder) {
		this.superPoder=superPoder;		
	}

	public int puntosCasilla(int posicion) {		
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
	
	private int generateAleatorio() {
		return  (int)((Math.random()* 9) + 1);
		
	}
	
	public int getTrampa() {
		return trampa;
	}

	public int getSuperPoder() {
		return superPoder;
	}
	
}
