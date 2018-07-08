package com.s4n.technicaltest.dominio;

/**
 * Enum que contiene las direcciones que puede tomar
 * un dron.
 * @author Juan
 */
public enum Way {
	NORT("NORTE"),
	SOUTH("SUR"),
	EAST("ESTE"),
	WEST("OESTE")
	;
	
	/**Valor del texto.*/
	private final String value;
	
	/**
     * @param pValue Valor de la direccion.
     */
    private Way(final String pValue) {
        this.value = pValue;
    }

    /**
     * Retorna el valor de la direccion.
     */
    public String toString() {
        return value;
    }
}
