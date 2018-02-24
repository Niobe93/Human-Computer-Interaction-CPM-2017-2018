package logica;

import java.util.Random;

public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	

	public Carrera() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		boolean trampa= activarTrampa();
		liebre = new Corredor(new Calle(trampa,true),"liebre","liebre.jpg", 4, false);
		tortuga = new Corredor(new Calle(!trampa,false),"tortuga","tortuga.jpg", 2, true);
		setCorredorActivo();		
		}
	
	
		private void setCorredorActivo() {
		if(liebre.isTurno())
			corredorActivo = liebre;
		else corredorActivo = tortuga;
	}
		
	private boolean activarTrampa() {		
		    Random random = new Random();
		    return random.nextBoolean();
		}	

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar(getCorredorActivo().getDesplazamiento());
		if (getCorredorActivo().getPosicion() + Dado.getValor() < Calle.DIM)
			isPosible = true;
		else{
			cambiarTurnos();
		}
		return isPosible;	
	}

	
	public void cambiarTurnos() {
		liebre.cambiaTurno();
		tortuga.cambiaTurno();
		setCorredorActivo();
		
	}

	private boolean isJugadaCorrecta(int i) {		
		return (getCorredorActivo().getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta=false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta(i)) {
			// Comprobamos que se trata de ir a la casilla correcta
			if (isJugadaCorrecta (i)){
				corredorActivo.setPosicion(corredorActivo.getPosicion() + Dado.getValor());
				// Incrementamos la puntuacion del corredor
				corredorActivo.incrementaPuntuacion(corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
				//si es superpoder incrementamos los puntos
				if(corredorActivo.getPosicion()==corredorActivo.getCalleAsignada().getSuperPoder()) {
					corredorActivo.incrementaPuntuacion(500);
					corredorActivo.setStatusPoder(true);}
				if(isPartidaFinalizada())
					corredorActivo.incrementaPuntuacion(200);
				//si es trampa anulamos los puntos
				if(corredorActivo.getPosicion()==corredorActivo.getCalleAsignada().getTrampa()) {
					if(corredorActivo.isStatusPoder()==false) {
					corredorActivo.setPuntuacion(0);	}	
				else
					corredorActivo.incrementaPuntuacion(1000);}
					
				// Intercambiamos los turnos
				cambiarTurnos();
				resuelta = true;
			}
			return resuelta;
		}
			

		return false;
	}
	
	
	public Corredor getTortuga() {
		return tortuga;
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}
	
	public boolean isArbol() {
		return(getCorredorActivo().getPosicion()==getLiebre().getCalleAsignada().getArbol());
	}

	public boolean isTrampa( ) {
		return (getCorredorActivo().getPosicion()==this.getTrampa() && getCorredorActivo().getCalleAsignada().isTrampaActiva()) ;			
	}
	
	public boolean isTrampaSuperPoder() {
		
		return(isTrampa() && getCorredorActivo().isStatusPoder() );
	}
	
	public boolean isCasillaSuperPoder( ) {
		return (getCorredorActivo().getPosicion() == this.getCasillaSuperPoder()) ;			
	}
	
	public int getCasillaSuperPoder() {
		return getCorredorActivo().getCalleAsignada().getSuperPoder();}
		

	public int getTrampa() {
		return getCorredorActivo().getCalleAsignada().getTrampa();
	}

	public boolean isPartidaFinalizada() {
		return ((liebre.getPosicion() == Calle.POSICION_META)||(tortuga.getPosicion() == Calle.POSICION_META));
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getCorredorNOActivo() {
		if(corredorActivo.equals(getLiebre()))
		return getTortuga();
		else
			return getLiebre();
	}
	
	
}