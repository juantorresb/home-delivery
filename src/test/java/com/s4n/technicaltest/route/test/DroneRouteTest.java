package com.s4n.technicaltest.route.test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.s4n.technicaltest.core.SuCorrientazoDomicilio;

import junit.framework.TestCase;

public class DroneRouteTest extends TestCase {
	
	/**
     * Create the test case
     * @param testName name of the test case
     */
    public DroneRouteTest(String testName ){
        super( testName );
    }
    
    /**
     * Caso de prueba ideal en el que se pasan tres rutas validas para el drone.
     * - Se espera que se retorne un objeto RouteData.
     * @throws IOException
     */
    public void testRealizarDomicilioPrincipal() throws IOException {
    	URL url = FileManagerTest.class.getResource("/in.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertEquals("(-2, 4, NORTE)", result.get(0));
    	
    	assertEquals("(-1, 3, SUR)", result.get(1));
    	
    	assertEquals("(0, 0, OESTE)", result.get(2));
    	
    }

    /**
     * Caso de prueba en el que se encarga de verifica que al menos se 
     * defina una ruta en el fichero.
     * @throws IOException
     */
    public void testRealizarDomicilioRuta02() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in02.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertNull(result);
    }
    
    /**
     * Caso de prueba que se encarga de verificar la ruta para
     * un movimiento del dron:
     * DDAIAAD
     * @throws IOException
     */
    public void testRealizarDomicilioRuta03() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in03.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertEquals("(2, -1, SUR)", result.get(0));
    }
    
    /**
     * Caso de prueba que se encarga de verificar la ruta para
     * los movimientos del dron:
     * IAAAIAD
     * AAAAAIAA
     * DAAIAA
     * @throws IOException
     */
    public void testRealizarDomicilioRuta04() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in04.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertEquals("(-3, -1, OESTE)", result.get(0));
    	assertEquals("(-8, -3, SUR)", result.get(1));	
    	assertEquals("(-10, -5, SUR)", result.get(2));
    }
    
    /**
     * Caso de prueba que se encarga de verificar la ruta para
     * los movimientos del dron:
     * AAIADAD
     * DDAAIAAAAA
     * @throws IOException
     */
    public void testRealizarDomicilioRuta05() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in05.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertEquals("(-1, 3, ESTE)", result.get(0));
    	assertEquals("(-3, -2, SUR)", result.get(1));	
    }
    
    /**
     * Caso de prueba que se encarga de verificar si se puede enviar
     * varios ficheros al tiempo.
     * 
     * @throws IOException
     */
    public void testRealizarDomicilioRutaTodosLosFicheros() throws IOException{
    	URL url = FileManagerTest.class.getResource("/");
    	assertNotNull("No se obtiene el fichero indicado",url);
    	
    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertNull(result);
    }
    
    /**
     * Caso de prueba se encarga de verificar el requerimiento:
     * - Para la primera entrega del proyecto, “Su corrientazo domicilio”, ha decidido que
     * solo entregara domicilios a 10 cuadras a la redonda de su barrio.
     * 
     * ruta del dron:
     * IAAAIAD
     * AAAAAIAA
     * DAAAAIAA
     * @throws IOException
     */
    public void testRealizarDomicilioRuta06MasDeDiezCuadras() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in06.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);

    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertNull(result);
    }
    
    /**
     * Caso de prueba se encarga de verificar el requerimiento:
     *  - El dron es sólo capaz de cargar hasta tres almuerzos por
     *  vez.
     * @throws IOException
     */
    public void testRealizarDomicilioRuta07MasDeTresAlmuerzos() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in07.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);

    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertNull(result);
    }
    
    /**
     * Caso de prueba se encarga de verificar el requerimiento:
     *  - El dron es sólo capaz de cargar hasta tres almuerzos por
     *  vez.
     * @throws IOException
     */
    public void testRealizarDomicilioRuta08LetraNoValida() throws IOException{
    	URL url = FileManagerTest.class.getResource("/in08.txt");
    	assertNotNull("No se obtiene el fichero indicado",url);

    	SuCorrientazoDomicilio app = new SuCorrientazoDomicilio();
    	List<String> result = app.realizarDomicilio(url.getPath());
    	assertNull(result);
    }
}
