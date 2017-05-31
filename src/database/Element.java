
package database;

/**
 *
 * @author jquesadaabeijon
 */
public class Element {

    String id, nombre, apellido, edad;
    
    /**
    * Constructor por defecto.
    */
    public Element() {
    }

    /**
     * Constructor con variables.
     * @param id
     * @param nombre
     * @param apellido
     * @param edad 
     */
    public Element(String id, String nombre, String apellido, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    /**
     * Getter id.
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * Getter nombre.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter apellido.
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Getter edad.
     * @return 
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Setter id.
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter nombre.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter apellido.
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Setter edad.
     * @param edad 
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    

}
