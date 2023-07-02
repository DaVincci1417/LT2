package Model.Data.DAO;

import Model.Estudiante;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class EstudianteDAO {
    public static void agregarEstudiante(DSLContext query, Estudiante estudiante){
        Table tablaEstudiante = table(name("Estudiante"));
        Field[] columnas = tablaEstudiante.fields("numero_matricula","nombre_estudiante","apellido_paterno","apellido_materno","rut","correo_institucional","sexo","carrera", "nombre_usuario","contraseña","tipo_usuario");
        query.insertInto(tablaEstudiante, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5], columnas[6], columnas[7], columnas[8], columnas[9], columnas[10])
                .values(estudiante.getNumeroMatricula(), estudiante.getNombre(), estudiante.getApellidoP(), estudiante.getApellidoM(), estudiante.getRut(),
                        estudiante.getCorreoInstitucional(), estudiante.getSexo(), estudiante.getCarrera(), estudiante.getNombreUsuario(), estudiante.getContraseña(),
                        estudiante.getTipoUsuario()
                )
                .execute();
    }
    public static void modificarLibro(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Estudiante")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("numero_matricula").eq(nombre)).execute();
    }
    public static List<Estudiante> obtenerEstudiante(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Estudiante")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaEstudiantes(resultados);
    }
    public static List<Estudiante> obtenerEstudiantes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Estudiante")).fetch();
        return obtenerListaEstudiantes(resultados);
    }
    public static void eliminarEstudiante(DSLContext query, Object nombre){
        Table tablaEstudiante = table(name("Estudiante"));
        query.delete(DSL.table("Estudiante")).where(DSL.field("numero_matricula").eq(nombre)).execute();
    }
    private static List<Estudiante> obtenerListaEstudiantes(Result resultados){
        List<Estudiante> estudiantes = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            int numeroMatricula = (int) resultados.getValue(fila,"numero_matricula");
            String nombreEstudiante = (String) resultados.getValue(fila,"nombre_estudiante");
            String apellidoPaterno = (String) resultados.getValue(fila,"apellido_paterno");
            String apellidoMaterno = (String) resultados.getValue(fila,"apellido_materno");
            String rut = (String) resultados.getValue(fila,"rut");
            String correoInstitucional = (String) resultados.getValue(fila,"correo_institucional");
            String sexo = (String) resultados.getValue(fila,"sexo");
            String carrera = (String) resultados.getValue(fila,"carrera");
            String nombreUsuario = (String) resultados.getValue(fila,"nombre_usuario");
            String contraseña = (String) resultados.getValue(fila,"contraseña");
            String tipoUsuario = (String) resultados.getValue(fila,"tipo_usuario");

            estudiantes.add(new Estudiante(rut, nombreEstudiante, apellidoPaterno, apellidoMaterno, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario, carrera, numeroMatricula));
        }
        return estudiantes;
    }
}
