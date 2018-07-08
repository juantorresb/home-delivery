package com.s4n.technicaltest.route.test;

import java.io.IOException;
import java.net.URL;

import com.s4n.technicaltest.util.FileManager;
import com.s4n.technicaltest.util.RouteData;

import junit.framework.TestCase;

public class FileManagerTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FileManagerTest(String testName ){
        super( testName );
    }
    
    /**
     * Caso de prueba ideal en el que se pasan tres rutas validas para el drone.
     * - Se espera que se retorne un objeto RouteData.
     * @throws IOException
     */
    public void testReadFileOK() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	RouteData rData = FileManager.read(url.getPath());
    	assertNotNull("El fichero no es valido", rData);
    }
    
    /**
     * Caso de prueba en el que no se presentan routas para un drone.
     * - Se espera que no se presente informacion en el RouteData.
     * @throws IOException
     */
    public void testReadFileZeroRoutes() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in02.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	RouteData rData = FileManager.read(url.getPath());
    	assertEquals("El fichero no debe tener informacion", 0, rData.rowCount());
    }

}
