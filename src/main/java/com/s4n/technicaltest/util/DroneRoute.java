package com.s4n.technicaltest.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.s4n.technicaltest.dominio.Drone;
import com.s4n.technicaltest.dominio.Way;

/**
 * Clase que se encarga de transformar las indicaciones (rutas) establecidas en el fichero 
 * in.txt en las posiciones del drone en el plano cartesiano, de acuerdo a las siguientes 
 * indicaciones: 
 * 
 * 	- La letra A corresponde a un movimiento hacia adelante.
 *  - La letra I corresponde a un giro de 90 grados del dron a la izquierda.
 *  - La letra D corresponde a un giro de 90 grados del dron a la derecha.
 * 
 * El dron siempre inicia en la posición (0, 0) orientación Norte (para cada fichero)
 * 
 * @author Juan
 */
public class DroneRoute {
	
	/**
	 * Metodo encargado de realizar el recorrido del dron de acuerdo a los
	 * movimientos definidos por el usuario para el respectivo dron.
	 * @param pRouteData ruta del drone.
	 * @param pConfig Variables de configuracion.
	 * @return lista de coordenadas del dron.
	 */
	public List<String> initRoute(final RouteData pRouteData, final LoadConfig pConfig){
		List<String> resultRoute = new ArrayList<String>();
		StringBuilder sb;
		
		//Inicializa el drone con direccion al norte.
		Drone drone = new Drone();
		drone.setWay(Way.NORT);
		
		try {
			//Valida que no se puedan enviar mas de tres almuerzos por dron.
			validateNumberOfOrders(pRouteData, pConfig.getMaxDeliveryByDrone());
		
			for (String route : pRouteData.getAll()) {
				sb = new StringBuilder("(");
				
				//Realizar movimientos al dron.
				moveDrone(route, drone);
				
				//Valida el maximo de cuadras permitido.
				validateRoute(drone, pConfig.getMaxStepByDrone());
				
				sb.append(drone.getDronePosX());
				sb.append(", ");
				sb.append(drone.getDronePosY());
				sb.append(", ");
				sb.append(drone.getWay().toString());
				sb.append(")");
				resultRoute.add(sb.toString());
			}

		} catch (Exception e) {
			resultRoute = null;
			try {
				FileManager.write(e.getMessage());
			} catch (IOException e1) {
			}
		}
		return resultRoute;
	}

	/**
	 * Metodo que se encarga de realizar las validaciones y respectivos 
	 * movimientos del dron.
	 * @param pRoute especificacion de los movimientos del dron 
	 * @param pDrone informacion del dron.
	 * @throws Exception En el caso que alguna de las letras no sea valida.
	 */
	private void moveDrone(final String pRoute, final Drone pDrone) throws Exception{		
		//Se convierte un domicilio en un arreglo de caracteres.
		String route = pRoute.toUpperCase();
		char[] routeArray = route.toCharArray();
		
		//Se recorren las indicaciones del domicilio
		for (char stape : routeArray) {
			switch (stape) {
			case 'A'://Dar un paso hacia adelante.
				takeStape(pDrone);
				break;
			case 'D'://Giro del dron a la derecha.
				changeRight(pDrone);
				break;
			case 'I'://Giro del dron a la izquierda.
				changeLeft(pDrone);
				break;
			default:
				throw new Exception("Letra no valida en la ruta: "+ stape);
			}		
		}
	}
	
	/**
	 * Metodo que se encarga de validar que no se puedan enviar 
	 * mas de tres almuerzos por dron.
	 * @param pRouteData informacion de las rutas del dron.
	 * @param pMaxDelivery Maximo de almuerzos que puede enviar. 
	 * @throws Exception en caso que no cumpla con la validacion.
	 */
	private void validateNumberOfOrders(final RouteData pRouteData, final Integer pMaxDelivery) throws Exception {
		//TODO leer de fichero properties.
		if (pRouteData.rowCount() == 0){
			throw new Exception("Se debe definir al menos una ruta.");
		}
		if (pRouteData.rowCount() > pMaxDelivery){
			throw new Exception("La cantidad de almuerzos excede la capacidad del dron.");
		}
	}
	
	/**
	 * Metodo que se encarga de validar el maximo de cuadras a la redonda
	 * que puede realizar un Dron.
	 * @param pDrone movimientos que tendria que hacer el dron.
	 * @throws Exception en caso que no cumpla con la validacion.
	 */
	private void validateRoute(final Drone pDrone, final Integer pMaxStep) throws Exception {
		//TODO leer de fichero properties.
		boolean isValidX = pDrone.getDronePosX()>=-pMaxStep && pDrone.getDronePosX()<=pMaxStep;
		boolean isValidY = pDrone.getDronePosY()>=-pMaxStep && pDrone.getDronePosY()<=pMaxStep;
		
		if (!isValidY || !isValidX){
			throw new Exception("La ruta excede las "+pMaxStep+" cuadras a la redonda");
		}
	}
	
	/**
	 * Metodo que se encarga de modificar el camino del dron a la Izquierda,
	 * segun su posicion actual.
	 * 
	 * El movimiento de direccion esta con la perspectiva del dron de acuerdo
	 * al requerimiento:
	 * - La letra I corresponde a un giro de 90 grados del dron a la izquierda.
	 * @param pDrone informacion de la posicion actual del dron.
	 */
	private void changeLeft(final Drone pDrone) {
		if (Way.NORT.equals(pDrone.getWay())){
			pDrone.setWay(Way.WEST);
		} else if (Way.SOUTH.equals(pDrone.getWay())){
			pDrone.setWay(Way.EAST);
		}else if (Way.EAST.equals(pDrone.getWay())){
			pDrone.setWay(Way.NORT);
		}else if (Way.WEST.equals(pDrone.getWay())){
			pDrone.setWay(Way.SOUTH);
		}
	}

	/**
	 * Metodo que se encarga de modificar el camino del dron a la derecha,
	 * segun su posicion actual.
	 * 
	 * El movimiento de direccion esta con la perspectiva del dron de acuerdo
	 * al requerimiento:
	 * - La letra D corresponde a un giro de 90 grados del dron a la derecha.
	 * @param pDrone informacion de la posicion actual del dron.
	 */
	private void changeRight(final Drone pDrone) {
		if (Way.NORT.equals(pDrone.getWay())){
			pDrone.setWay(Way.EAST);
		} else if (Way.SOUTH.equals(pDrone.getWay())){
			pDrone.setWay(Way.WEST);
		}else if (Way.EAST.equals(pDrone.getWay())){
			pDrone.setWay(Way.SOUTH);
		}else if (Way.WEST.equals(pDrone.getWay())){
			pDrone.setWay(Way.NORT);
		}
	}


	/**
	 * Metodo encargado de agregar paso segun el camino que tenga asignado
	 * el dron.
	 * @param pDrone informacion del dron.
	 */
	private void takeStape(final Drone pDrone) {
		if (Way.NORT.equals(pDrone.getWay())){
			pDrone.addStepNort();
		}
		if (Way.SOUTH.equals(pDrone.getWay())){
			pDrone.addStepSur();
		}
		if (Way.EAST.equals(pDrone.getWay())){
			pDrone.addStepEste();
		}
		if (Way.WEST.equals(pDrone.getWay())){
			pDrone.addStepOEste();
		}
	}
}
