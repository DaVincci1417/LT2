package Model;

import java.util.Date;

public class Task {
    private int codTask;
    private String nombreTask;
    private int codAsignatura;
    private String tipoTask;
    private Date fechaTask;

    public Task(String nombreTask, int codAsignatura, String tipoTask, Date fechaTask) {
        setNombreTask(nombreTask);
        setCodAsignatura(codAsignatura);
        setTipoTask(tipoTask);
        setFechaTask(fechaTask);
    }

    public int getCodTask() {
        return codTask;
    }
    private void setCodTask(int codTask) {
        this.codTask = codTask;
    }
    public String getNombreTask() {
        return nombreTask;
    }
    private void setNombreTask(String nombreTask) {
        this.nombreTask = nombreTask;
    }
    public int getCodAsignatura() {
        return codAsignatura;
    }
    private void setCodAsignatura(int codAsignatura) {
        this.codAsignatura = codAsignatura;
    }
    public String getTipoTask() {
        return tipoTask;
    }
    private void setTipoTask(String tipoTask) {
        this.tipoTask = tipoTask;
    }
    public Date getFechaTask() {
        return fechaTask;
    }
    private void setFechaTask(Date fechaTask) {
        this.fechaTask = fechaTask;
    }
}