package Clases;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author Lalo
 */
public class ControladorCache {

    private JCS jcsCache;

    public ControladorCache() {
    }

    /**
     * Este método es el encargado de cargar el archivo de configuración de la
     * caché. Si se desea manipular la caché, será este método que se deba
     * llamar en primer lugar.
     * @throws org.apache.jcs.access.exception.CacheException
     */
    public void configLoad() throws CacheException {

            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("mvcDetailsCache");
    }


    /**
     *Método encargado de agregar la información del candidato a la caché.
     * @param id es el identificador del objeto que se introducirá a la caché.
     * @param objeto es el objeto que se introducirá a la caché.
     * @throws org.apache.jcs.access.exception.CacheException
     */
    public void put(int id, Cacheable objeto) throws CacheException {
        String ID = String.valueOf(id);
            jcsCache.put(ID, objeto);
    }

    /**
     * Método encargado de devolver de la caché, el candidato que se desea, a
     * partir de la clave que se le pase.
     *
     * @param claveObjeto, que es el identificador del candidato que se desea
     * obtener de la caché.
     * @return el objeto del candidato.
     */
    public Object get(int claveObjeto) throws CacheException {
        String id = String.valueOf(claveObjeto);
        return  (Cacheable) jcsCache.get(id);
    }
    
    /**
     * Método encargado de limpiar la caché. (la deja sin datos completamente)
     * @throws org.apache.jcs.access.exception.CacheException
     */
    public void limpiarCache() throws CacheException {
            jcsCache.clear();        
    }
    
    
    
}
