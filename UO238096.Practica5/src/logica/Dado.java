package logica;

public class Dado {
	
	private static int valor;
	
	public static void lanzar ()
	{
		valor = ((int) (Math.random() * 3) + 1);
		
	}

	public static int getValor() {
		return valor;
	}

}
