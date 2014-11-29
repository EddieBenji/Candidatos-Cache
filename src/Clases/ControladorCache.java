package Clases;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author Lalo
 */
public class ControladorCache {

    private JCS jcsCache;
    private static ControladorCache instanciaCache = new ControladorCache();

    private ControladorCache() {}

    /**
     * Implementa el patrón de diseño singleton, devuelve una instancia única
     * del controlador de la caché.
     *
     * @return instancia de la caché.
     */
    public static ControladorCache getInstanciaCache() {
        return instanciaCache;
    }

    /**
     * Este método es el encargado de cargar el archivo de configuración de la
     * caché. Si se desea manipular la caché, será este método que se deba
     * llamar en primer lugar.
     *
     * @throws Clases.ExcepcionArchivoConfiguracion
     */
    public void configLoad() throws ExcepcionArchivoConfiguracion {

        try {
            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("mvcDetailsCache");
        } catch (CacheException ex) {
            throw new ExcepcionArchivoConfiguracion();
        }
    }

    /**
     * Método encargado de agregar la información del candidato a la caché.
     *
     * @param objeto es el objeto que se introducirá a la caché. Deberá ser
     * específicamente de tipo cacheable.
     * @throws Clases.ExcepcionObjetoDuplicado
     */
    public void put(Cacheable objeto) throws ExcepcionObjetoDuplicado {
        try {
            jcsCache.put(objeto.getID(), objeto);
        } catch (CacheException ex) {
            throw new ExcepcionObjetoDuplicado();
        }
    }

    /**
     * Método encargado de devolver de la caché, el candidato que se desea, a
     * partir de la clave que se le pase.
     *
     * @param claveObjeto, que es el identificador del candidato que se desea
     * obtener de la caché.
     * @return el objeto del candidato.
     * @throws Clases.ExcepcionObjetoDesconocido
     */
    public Object get(int claveObjeto) throws ExcepcionObjetoDesconocido {
        return (Cacheable) jcsCache.get(claveObjeto);
    }

    /**
     * Método encargado de limpiar la caché. (la deja sin datos completamente)
     *
     * @throws org.apache.jcs.access.exception.CacheException
     */
    public void limpiarCache() throws CacheException {
        jcsCache.clear();
    }

     /**
     * Método que elimina el objeto que se desea de la cache, a partir del id
     * que se le pase como parámetro.
     * @param id, identificador del objeto a eliminar.
     * @throws Clases.ExcepcionObjetoDesconocido 
     */
    public void delete(int id)throws ExcepcionObjetoDesconocido{
        try {
            jcsCache.remove(id);
        } catch (CacheException ex) {
            throw new ExcepcionObjetoDesconocido();
        }
    }
}
