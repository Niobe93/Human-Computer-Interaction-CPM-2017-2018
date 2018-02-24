package logica;


public class Carrera {

	private Corredor liebre;
	private int trampa = generateAleatorio();
	private int superPoder = generateAleatorio();

	public Carrera() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		liebre = new Corredor(new Calle(),"liebre","liebre.jpg");
		while(trampa==superPoder)
			superPoder=generateAleatorio();
		}
	

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar();
		if (liebre.getPosicion() + Dado.getValor() < Calle.DIM)
			isPosible = true;
		return isPosible;	
	}

	
	private boolean isJugadaCorrecta(int i) {
		return (liebre.getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;

		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta(i) && (!isCasillaSuperPoder()) && (!isTrampa())) {
			liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
			liebre.incrementaPuntuacion(liebre.getCalleAsignada().puntosCasilla(liebre.getPosicion()));
			resuelta = true;
		}
		
		if (isJugadaCorrecta(i) && (liebre.isStatusPoder()) && (isTrampa())) {
			liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
			liebre.incrementaPuntuacion(1000);
			resuelta = true;
		}
		
		if(isPartidaFinalizada()){
			liebre.incrementaPuntuacion(200);
			return true;
		}
			

		else {
			if (isCasillaSuperPoder() && isJugadaCorrecta(i)) 
			{
				liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
				liebre.setStatusPoder(true);
				liebre.incrementaPuntuacion(550);
				resuelta = true;
			}

			if (isTrampa() && isJugadaCorrecta(i)) 
			{
				liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
				liebre.incrementaPuntuacion(liebre.getPuntuacion() * 0);
				resuelta = true;
			}

		}
		return resuelta;
	}
	
	public boolean isTrampa( ) {
		return (liebre.getPosicion()==trampa) ;			
	}
	
	public boolean isCasillaSuperPoder( ) {
		return (liebre.getPosicion()==superPoder) ;			
	}
	
	public int getCasillaSuperPoder() {
		return superPoder;
	}
		

	public int getTrampa() {
		return trampa;
	}
	
	private int generateAleatorio() {
		return  (int)((Math.random()* 9) + 1);
		
	}

	public boolean isPartidaFinalizada() {
		return (liebre.getPosicion() == Calle.POSICION_META);
			
		
	}

	public Corredor getLiebre() {
		return liebre;
	}
}