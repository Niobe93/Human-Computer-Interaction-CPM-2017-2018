package logica;

public class Corredor {
	private int puntuacion;
	private int posicion;
	private int desplazamiento;
	private String nombre;
	private String foto;
	private Calle calleAsignada;
	private boolean statusPoder;
	public final static int POSICION_SALIDA = 0; 
	
	public Corredor(Calle calleAsignada, String nombre, String foto) {
		this.calleAsignada = calleAsignada;
		this.nombre = nombre;
		this.foto = foto;
		this.statusPoder=false;
		puntuacion = 0;
		posicion = POSICION_SALIDA;
	}
	


	public boolean isStatusPoder() {
		return statusPoder;
	}



	public void setStatusPoder(boolean statusPoder) {
		this.statusPoder = statusPoder;
	}



	public String getNombre() {
		return nombre;
	}
	
	public int getDesplazamiento() {
		return desplazamiento;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion (int posicion) {
		this.posicion = posicion;
	}
	
	public Calle getCalleAsignada() {
		return calleAsignada;
	}

	public String getFoto() {
		return foto;
	}
	
	public void incrementaPuntuacion (int puntos){
		puntuacion += puntos;

	}
}
