package Model;

public class Ayudante extends Persona{
    private String numeroMatricula;
    private Asignatura asignatura;
    public Ayudante(String rut, String nombre, String apellidoP, String apellidoM, String correoInstitucional, String sexo, String nombreUsuario, String contraseña, String tipoUsuario, Asignatura asignatura, String numeroMatricula){
        super(rut, nombre, apellidoP, apellidoM, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario);
        setAsignatura(asignatura);
        setNumeroMatricula(numeroMatricula);
    }

    @Override
    public String getTipo() {
        return "Ayudante";
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    private void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public Asignatura getAsignatura() {
        return asignatura;
    }
    private void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
