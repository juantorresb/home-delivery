package com.s4n.technicaltest.util;

import java.util.Properties;
/**
 * Clase encargada de optener la informacion del fichero de configuracion.
 * @author Juan
 *
 */
public class LoadConfig {

	/**Constante de maximo de domicilios.*/
	private final static String MAX_DELIVERY_BY_DRONE ="maxDeliveryByDrone";
	/**Constante de maximo movimientos a la redonda.*/
	private final static String MAX_STEP_BY_DRONE ="maxStepByDrone";
	/**Valor maximo de domicilios por drone.*/
	private Integer maxDeliveryByDrone;
	/**Valor maximo de movimientos a la redonda por drone.*/
	private Integer maxStepByDrone;
	
	/**
	 * Carga la informacion del fichero properties, en el caso que no se obtenga el fichero
	 * se carga valores por defecto.
	 * @param pProperties fichero properties.
	 */
	public LoadConfig(final Properties pProperties) {
		String value = pProperties.getProperty(MAX_DELIVERY_BY_DRONE);
		if (value !=null){
			maxDeliveryByDrone = Integer.valueOf(value);
		} else {
			maxDeliveryByDrone = 3;
		}
		value = pProperties.getProperty(MAX_STEP_BY_DRONE);
		if (value !=null){
			maxStepByDrone= Integer.valueOf(value);
		} else {
			maxStepByDrone = 10;
		}
	}

	/**
	 * @return the maxDeliveryByDrone
	 */
	public Integer getMaxDeliveryByDrone() {
		return maxDeliveryByDrone;
	}

	/**
	 * @param pMaxDeliveryByDrone the maxDeliveryByDrone to set
	 */
	public void setMaxDeliveryByDrone(final Integer pMaxDeliveryByDrone) {
		this.maxDeliveryByDrone = pMaxDeliveryByDrone;
	}

	/**
	 * @return the maxStepByDrone
	 */
	public Integer getMaxStepByDrone() {
		return maxStepByDrone;
	}

	/**
	 * @param pMaxStepByDrone the maxStepByDrone to set
	 */
	public void setMaxStepByDrone(final Integer pMaxStepByDrone) {
		this.maxStepByDrone = pMaxStepByDrone;
	}
}
