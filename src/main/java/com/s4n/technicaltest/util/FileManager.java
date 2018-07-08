package com.s4n.technicaltest.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO documentar.
 * @author Juan
 */
public final class FileManager {

	/** Constructor privado para las clases utilitarias. */
    private FileManager () {
    }
    
    /**
     * Se encarga de leer el fichero y construir la ruta para el Dron.
     * @param pFileName nombre del fichero que contiene las rutas.
     * @return un objeto RouteData con las rutas.
     * @throws IOException si hay algun inconveniente con la lectura del fichero.
     */
    public static RouteData read(final String pFileName) throws IOException{
    	 String line;
    	 BufferedReader in = null;
    	 RouteData rData;
    	 try {
    		 in = new BufferedReader(new FileReader(pFileName));
    		 rData = new RouteData(); 
    		 while ((line = in.readLine()) != null) {
    			 rData.add(line);
    		 }
    	 } finally {
    		 if (in != null) {
    			 in.close();
    		 }
    	 }
    	 
    	 //Si la ruta es valida para el dron se retorna.
    	 return rData;
    }
    
    
    /**
     * Metodo encargado de crear el fichero de salida con la respuesta.
     * @param pFileName nombre del fichero
     * @param pRouteData informacion de las rutas.
     * @throws IOException
     */
    public static void write(final String pMessage) throws IOException{
    	List<String> data = new ArrayList<String>();
    	data.add(pMessage);
    	write(null, data);
    }
    public static void write(final String pFileName, final List<String> pRouteData) throws IOException{
    	File cursorsFile;
    	Writer cursorsOutput;
    	
    	if (pRouteData != null){
	    	cursorsFile = new File("out.txt");
	        if (cursorsFile.exists()) {
	            cursorsFile.delete();
	        }
	        cursorsOutput = new BufferedWriter(new FileWriter(cursorsFile));
	        
	        for (String data : pRouteData) {
	        	cursorsOutput.write(data+"\n");
			}
	        cursorsOutput.close();
    	}
    }
    
    //<>
    /* *
     * Se encarga de validar la cantidad de rutas que puede hacer el dron.
     * @param pRData routa definida para el dron.
     * @return true si la cantidad de rutas es menor o igual a 3.
     * /
    private static boolean validateRouteSize(final RouteData pRData){
    	return pRData.rowCount() >0 && pRData.rowCount() <= 3;
    }*/
}
