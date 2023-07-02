package Model.Data.DAO;

import Model.Academico;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class AcademicoDAO {
    public static void agregarAcademico(DSLContext query, Academico academico){
        Table tablaAcademico = table(name("Academico"));
        Field[] columnas = tablaAcademico.fields("rut","nombre_academico","apellido_paterno","apellido_materno","correo_institucional","sexo","depto", "nombre_usuario","contraseña","tipo_usuario");
        query.insertInto(tablaAcademico, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4], columnas[5], columnas[6], columnas[7], columnas[8], columnas[9])
                .values(academico.getRut(), academico.getNombre(), academico.getApellidoP(), academico.getApellidoM(), academico.getCorreoInstitucional(),
                        academico.getSexo(), academico.getDepto(), academico.getNombreUsuario(), academico.getContraseña(), academico.getTipoUsuario())
                .execute();
    }
    public static void modificarAcademico(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(table("Academico")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("rut").eq(nombre)).execute();
    }
    public static List<Academico> obtenerAcademico(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(table("Academico")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaAcademicos(resultados);
    }
    public static List<Academico> obtenerAcademicos(DSLContext query){
        Result resultados = query.select().from(table("Academico")).fetch();
        return obtenerListaAcademicos(resultados);
    }
    public static void eliminarAcademico(DSLContext query, String nombre){
        Table tablaAcademico= table(name("Academico"));
        query.delete(table("Academico")).where(DSL.field("rut").eq(nombre)).execute();
    }
    private static List<Academico> obtenerListaAcademicos(Result resultados){
        List<Academico> academicos = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String rut = (String) resultados.getValue(fila,"rut");
            String nombreAcademico = (String) resultados.getValue(fila,"nombre_academico");
            String apellidoPaterno = (String) resultados.getValue(fila,"apellido_paterno");
            String apellidoMaterno = (String) resultados.getValue(fila,"apellido_materno");
            String correoInstitucional = (String) resultados.getValue(fila,"correo_institucional");
            String sexo = (String) resultados.getValue(fila,"sexo");
            String depto = (String) resultados.getValue(fila,"depto");
            String nombreUsuario = (String) resultados.getValue(fila,"nombre_usuario");
            String contraseña = (String) resultados.getValue(fila,"contraseña");
            String tipoUsuario = (String) resultados.getValue(fila,"tipo_usuario");

            academicos.add(new Academico(rut, nombreAcademico, apellidoPaterno, apellidoMaterno, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario, depto));
        }
        return academicos;
    }
}
