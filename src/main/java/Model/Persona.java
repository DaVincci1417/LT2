package Model;

public abstract class Persona {
    protected String rut;
    protected String nombre;
    protected String apellidoP;
    protected String apellidoM;
    protected String correoInstitucional;
    protected String sexo;
    protected String nombreUsuario;
    protected String contraseña;
    protected String tipoUsuario;

    public Persona(String rut, String nombre, String apellidoP, String apellidoM, String correoInstitucional, String sexo,
                   String nombreUsuario, String contraseña, String tipoUsuario) {
        setRut(rut);
        setNombre(nombre);
        setApellidoP(apellidoP);
        setApellidoM(apellidoM);
        setCorreoInstitucional(correoInstitucional);
        setSexo(sexo);
        setNombreUsuario(nombreUsuario);
        setContraseña(contraseña);
        setTipoUsuario(tipoUsuario);
    }
    public Persona(){}

    public abstract String getTipo();

    //Getters and Setters
    public String getRut() {
        return rut;
    }
    private void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoP() {
        return apellidoP;
    }
    protected void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return apellidoM;
    }
    protected void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }
    protected void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }
    public String getSexo() {
        return sexo;
    }
    protected void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    private void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    private void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    private void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
