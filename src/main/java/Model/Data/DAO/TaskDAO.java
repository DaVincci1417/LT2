package Model.Data.DAO;

import Model.Task;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class TaskDAO {
    public static void agregarTask(DSLContext query, Task task){
        Table tablaTask = table(name("Task"));
        Field[] columnas = tablaTask.fields("cod_task","nombre_task","cod_asignatura","tipo_task","fecha_task");
        query.insertInto(tablaTask, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(task.getCodTask(), task.getNombreTask(), task.getCodAsignatura(), task.getTipoTask(), task.getFechaTask())
                .execute();
    }
    public static void modificarTask(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Task")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("cod_task").eq(nombre)).execute();
    }
    public static List obtenerTask(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Task")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaTasks(resultados);
    }
    public static List obtenerTasks(DSLContext query){
        Result resultados = query.select().from(DSL.table("Task")).fetch();
        return obtenerListaTasks(resultados);
    }
    public static void eliminarTask(DSLContext query, String nombre){
        Table tablaTask = table(name("Task"));
        query.delete(DSL.table("Task")).where(DSL.field("cod_task").eq(nombre)).execute();
    }
    private static List obtenerListaTasks(Result resultados){
        List<Task> tasks = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombreTask = (String) resultados.getValue(fila,"nombre_task");
            int codAsignatura = (int) resultados.getValue(fila,"cod_asignatura");
            String tipoTask = (String) resultados.getValue(fila,"tipo_task");
            Date fechaTask = (Date) resultados.getValue(fila,"fecha_task");

            tasks.add(new Task(nombreTask, codAsignatura, tipoTask, fechaTask));
        }
        return tasks;
    }
}
