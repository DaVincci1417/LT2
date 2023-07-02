package Model.Data.DAO;

import Model.Apunte;
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

public class ApunteDAO {
    public static void agregarApunte(DSLContext query, Apunte apunte){
        Table tablaApunte = table(name("Apunte"));
        Field[] columnas = tablaApunte.fields("cod_apunte","nombre_apunte","cod_asignatura","fecha_apunte","texto_apunte");
        query.insertInto(tablaApunte, columnas[0], columnas[1], columnas[2], columnas[3], columnas[4])
                .values(apunte.getCodApunte(), apunte.getNombreApunte(), apunte.getCodAsignatura(), apunte.getFechaApunte(), apunte.getTextoApunte())
                .execute();
    }
    public static void modificarApunte(DSLContext query, String nombre, String columnaTabla, Object dato){
        query.update(DSL.table("Apunte")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("cod_apunte").eq(nombre)).execute();
    }
    public static List<Apunte> obtenerApunte(DSLContext query, String columnaTabla, String dato){
        Result resultados = query.select().from(DSL.table("Apunte")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaApuntes(resultados);
    }
    public static List<Apunte> obtenerApuntes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Apunte")).fetch();
        return obtenerListaApuntes(resultados);
    }
    public static void eliminarApunte(DSLContext query, String nombre){
        Table tablaApunte = table(name("Apunte"));
        query.delete(DSL.table("Apunte")).where(DSL.field("cod_apunte").eq(nombre)).execute();
    }
    private static List<Apunte> obtenerListaApuntes(Result resultados){
        List<Apunte> apuntes = new ArrayList<>();
        for(int fila=0; fila < resultados.size() ; fila++){
            String nombreApunte = (String) resultados.getValue(fila,"nombre_apunte");
            int codAsignatura = (int) resultados.getValue(fila,"cod_asignatura");
            Date fechaApunte = (Date) resultados.getValue(fila,"fecha_apunte");
            String textoApunte = (String) resultados.getValue(fila,"texto_apunte");

            apuntes.add(new Apunte(nombreApunte, codAsignatura, fechaApunte, textoApunte));
        }
        return apuntes;
    }
}
