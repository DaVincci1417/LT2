package Model;

public class Asignatura {
    private int codAsignatura;
    private String nombreAsignatura;
    private int modulo;
    private int semestre;
    private String rutAcademico;

    public Asignatura(String nombreAsignatura, int modulo, int semestre, String rutAcademico) {
        setNombreAsignatura(nombreAsignatura);
        setModulo(modulo);
        setSemestre(semestre);
        setRutAcademico(rutAcademico);
    }

    public int getCodAsignatura() {
        return codAsignatura;
    }
    private void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    private void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getModulo() {
        return modulo;
    }
    private void setModulo(int modulo) {
        this.modulo = modulo;
    }
    public int getSemestre() {
        return semestre;
    }
    private void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getRutAcademico() {
        return rutAcademico;
    }
    private void setRutAcademico(String rutAcademico) {
        this.rutAcademico = rutAcademico;
    }
}
