package com.s4n.technicaltest.util;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO documentar.
 * @author Juan
 */
public class RouteData {

	private List<String> data;
	
	/**
	 * Crea la estructura de datos para almacenar los recorridos.
	 */
	public RouteData(){
		data = new ArrayList<String>();
	}
	
	/**
	 * Metodo encargado los recorridos.
	 * @param pValue valor de la fila
	 */
	public void add(final String pValue){
		data.add(pValue);
	}
	
	/**
	 * Metodo encargado de devolver el recorrido segun el identificador.
	 * @param pIndex identificador del recorrido.
	 * @return devuelve las indicaciones del recorrido.
	 */
	public String get(final int pIndex){
		return data.get(pIndex);
	}
	
	/**
	 * Metodo encargado de devolver los recorridos.
	 * @return devuelve los recorridos.
	 */
	public List<String> getAll(){
		return data;
	}
	
	/**
	 * 
	 * @return numero de recorridos (almuerzos).
	 */
	public int rowCount(){
		return data.size();
	}
	
}
