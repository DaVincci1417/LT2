package Model;

public class Academico extends Persona{
    private String depto;

    public Academico(String rut, String nombre, String apellidoP, String apellidoM, String correoInstitucional, String sexo ,String nombreUsuario, String contraseña, String tipoUsuario, String depto){
        super(rut, nombre, apellidoP, apellidoM, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario);
        setDepto(depto);
    }

    @Override
    public String getTipo() {
        return "Academico";
    }

    //Getters and Setters
    public String getDepto() {
        return depto;
    }
    private void setDepto(String depto) {
        this.depto = depto;
    }

}
