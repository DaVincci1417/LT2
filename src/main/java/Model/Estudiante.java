package Model;

public class Estudiante extends Persona{
    private int numeroMatricula;
    private String carrera;
    public Estudiante(String rut, String nombre, String apellidoP, String apellidoM, String correoInstitucional, String sexo, String nombreUsuario, String contraseña, String tipoUsuario, String carrera, int numeroMatricula){
        super(rut, nombre, apellidoP, apellidoM, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario);
        setNumeroMatricula(numeroMatricula);
        setCarrera(carrera);
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }

    //Getters and Setters
    public int getNumeroMatricula() {
        return numeroMatricula;
    }
    private void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getCarrera() {
        return carrera;
    }
    private void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
