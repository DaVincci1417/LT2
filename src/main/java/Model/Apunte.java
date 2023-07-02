package Model;

import java.util.Date;

public class Apunte {
    private int codApunte;
    private String nombreApunte;
    private int codAsignatura;
    private Date fechaApunte;
    private String textoApunte;

    public Apunte(String nombreApunte, int codAsignatura, Date fechaApunte, String textoApunte) {
        setNombreApunte(nombreApunte);
        setCodAsignatura(codAsignatura);
        setFechaApunte(fechaApunte);
        setTextoApunte(textoApunte);
    }

    public int getCodApunte() {
        return codApunte;
    }
    private void setCodApunte(int codApunte) {
        this.codApunte = codApunte;
    }
    public String getNombreApunte() {
        return nombreApunte;
    }
    private void setNombreApunte(String nombreApunte) {
        this.nombreApunte = nombreApunte;
    }
    public int getCodAsignatura() {
        return codAsignatura;
    }
    private void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }
    public Date getFechaApunte() {
        return fechaApunte;
    }
    private void setFechaApunte(Date fechaApunte) {
        this.fechaApunte = fechaApunte;
    }
    public String getTextoApunte() {
        return textoApunte;
    }
    private void setTextoApunte(String textoApunte) {
        this.textoApunte = textoApunte;
    }
}