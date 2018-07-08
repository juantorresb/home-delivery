package com.s4n.technicaltest.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import com.s4n.technicaltest.util.DroneRoute;
import com.s4n.technicaltest.util.FileManager;
import com.s4n.technicaltest.util.LoadConfig;
import com.s4n.technicaltest.util.RouteData;

/**
 * 
 * @author Juan
 */
public class SuCorrientazoDomicilio {

	
	/**
	 * Metodo principal que se encarga de leer el fichero de configuracion
	 * con las rutas por drone y realizar los recorridos respectivos por Dron.
	 * @param pFileName nombre del fichero que contiene las rutas.
	 * @return lista de los puntos cardinales resultantes.
	 */
	public List<String> realizarDomicilio(final String pFileName){
		DroneRoute drone = new DroneRoute();
		List<String> result = null;
		try {
			RouteData rData = FileManager.read(pFileName);
			LoadConfig config = loadProperties();
			result =  drone.initRoute(rData, config);
			
			FileManager.write(pFileName, result);
			
		} catch (IOException e) {
			//TODO agregar logger.
		}
		return result;
	}
	
	/**
	 * Metodo encargado de cargar el fichero de configuracion Properties.
	 * @return objeto con la informacion.
	 * @throws IOException
	 */
	public LoadConfig loadProperties() throws IOException{
		Properties properties= new Properties();
		InputStream is = LoadConfig.class.getClassLoader().getResourceAsStream("config.properties");
		if (is != null){
			properties.load(is);
		}
		return new LoadConfig(properties);
	}
}
