
package Clases;

import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author Lalo
 */
public class ExcepcionArchivoConfiguracion extends CacheException {

    /**
     * En caso de haya error con el archivo de configuración,
     * se lanzará esta excepción. 
     */
    public ExcepcionArchivoConfiguracion() {
        super("Error en el archivo de configuración");
    }
}
