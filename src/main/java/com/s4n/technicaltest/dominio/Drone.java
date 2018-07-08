package com.s4n.technicaltest.dominio;

/**
 * Clase que modela los drones del sistema.
 * @author Juan
 */
public class Drone {

	/**Identificador unico por drone.*/
	private int idTransporte;
	
	/**Propiedad que indica si el drone esta activo.*/
	private boolean active;
	
	/**Posicion del dron en el eje X.*/
	private int dronePosX;
	
	/**Posicion del dron en el eje Y.*/
	private int dronePosY;
	
	/**Camino del dron.*/
	private Way way;
	
	/**
	 * Constructor por defecto del dron.
	 */
	public Drone(){
		this.idTransporte = idTransporte++;
		this.active = true;
	}
	
	/**
	 * Obtener el id.
	 * @return identificador.
	 */
	public Integer getIdTransporte() {
		return idTransporte;
	}
	
	/**
	 * Asigna el identificador.
	 * @param idTransporte identificador.
	 */
	public void setIdTransporte(final Integer pIdTransporte) {
		this.idTransporte = pIdTransporte;
	}
	
	/**
	 * Obtiene si el dron el estado.
	 * @return el estado del dron.
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Asigna estado del dron.
	 * @param pActive estado.
	 */
	public void setActive(final boolean pActive) {
		this.active = pActive;
	}

	/**
	 * Posicion del dron en el eje X.
	 * @return valor de la posicion del dron.
	 */
	public int getDronePosX() {
		return dronePosX;
	}

	/**
	 * Asigna la posicion del dron en el eje X.
	 * @param pDronePosX valor.
	 */
	public void setDronePosX(final int pDronePosX) {
		this.dronePosX = pDronePosX;
	}

	/**
	 * Posicion del dron en el eje Y.
	 * @return valor de la posicion del dron.
	 */
	public int getDronePosY() {
		return dronePosY;
	}

	/**
	 * Asigna la posicion del dron en el eje Y.
	 * @param pDronePosY valor.
	 */
	public void setDronePosY(int pDronePosY) {
		this.dronePosY = pDronePosY;
	}

	/**
	 * Camino del Dron.
	 * @return Valor del camino.
	 */
	public Way getWay() {
		return way;
	}

	/**
	 * Asigna la direccion del Dron.
	 * @param way direccion del Dron.
	 */
	public void setWay(final Way pWay) {
		this.way = pWay;
	}
	
	/**
	 * Agrega un paso hacia el Norte.
	 */
	public void addStepNort(){
		setDronePosY(this.dronePosY+1);
	}
	
	/**
	 * Agrega un paso hacia el Sur.
	 */
	public void addStepSur(){
		setDronePosY(this.dronePosY-1);
	}
	
	/**
	 * Agrega un paso hacia el Este.
	 */
	public void addStepEste(){
		setDronePosX(this.dronePosX+1);
	}
	
	/**
	 * Agrega un paso hacia el OEste.
	 */
	public void addStepOEste(){
		setDronePosX(this.dronePosX-1);
	}
}
