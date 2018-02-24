package player;


import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	private BasicPlayer basicPlayer = null;
	private MyFile cancionSonando;
	private double volumen=50;
	private double volumenMax=100;
	
	
	public double getVolumen() {
		return volumen;
	}

	

	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	public void play (MyFile file){
		try {
			basicPlayer.open(file.getF());
			setCancionSonando(file);
			basicPlayer.play();
			
			
		}
		catch (Exception e){}
	}
	
	public MyFile getCancionSonando() {
		return cancionSonando;
	}

	public void setCancionSonando(MyFile file) {
		this.cancionSonando = file;
	}

	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
			volumen = vol;
			volumenMax = volMax;
		}
		catch (BasicPlayerException e){
		}
	}

	public double getVolMax() {
		return volumenMax;
	}

	
}
