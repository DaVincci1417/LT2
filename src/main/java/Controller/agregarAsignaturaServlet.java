package Controller;

import Model.Asignatura;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "agregarAsignaturaServlet", value = "/agregarAsignatura")
public class agregarAsignaturaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarAsignatura.jsp");
        respuesta.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorAgregarAsignatura.jsp");
        if(req.getParameter("nombre_asignatura").length() != 0 || req.getParameter("modulo").length() != 0
                || req.getParameter("semestre").length() != 0 || req.getParameter("tipoLibro").length() != 0){
            String nombreAsignatura = req.getParameter("nombre_asignatura");
            int modulo = Integer.parseInt(req.getParameter("modulo"));
            int semestre = Integer.parseInt(req.getParameter("semestre"));
            String rutAcademico = req.getParameter("rut_academico");


            Asignatura asignatura = new Asignatura(nombreAsignatura, modulo, semestre, rutAcademico);

            try {
                if(agregarAsignatura(asignatura)){
                    req.setAttribute("Asignatura",asignatura);
                    respuesta = req.getRequestDispatcher("/exitoAgregarAsignatura.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarAsignatura(Asignatura asignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Asignatura> asignaturas = AsignaturaDAO.obtenerAsignatura(query,"cod_asignatura", Integer.toString(asignatura.getCodAsignatura()));
        if(asignaturas.size()!=0){
            return false;
        }
        else{
            AsignaturaDAO.agregarAsignatura(query,asignatura);
            return true;
        }
    }

}
