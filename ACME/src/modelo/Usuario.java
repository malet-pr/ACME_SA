package modelo;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */
public class Usuario {
    
    private int id;
    private String nombre;
    private String legajo;
    private String userName;
    private String password;
    private int permisos;
    private String ultimaSesion;    
    private String motivo;
    private String idioma;

    public Usuario() {
    }
    
    public Usuario(int id, String nombre, int permisos, String motivo, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
        this.motivo = motivo;
        this.idioma = idioma;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    public String getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }  
    
}

