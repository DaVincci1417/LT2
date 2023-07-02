package Controller;

import Model.Academico;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.EstudianteDAO;
import Model.Data.DBGenerator;
import Model.Estudiante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "loginEstudianteServlet", value = "/loginEstudiante")
public class loginEstudianteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorRegistrarAcademico.jsp");
        if(req.getParameter("matriculaLogin").length()!=0 && req.getParameter("contraseñaEstudiante").length() != 0){
            try {
                if(obtenerEstudiante(req) == null){
                    respuesta = req.getRequestDispatcher("/estudianteNoTieneCuenta.jsp");
                }else{
                    Estudiante estudiante;
                    estudiante = obtenerEstudiante(req);
                    HttpSession session;

                    session = req.getSession();
                    session.setAttribute("estudiante", estudiante);
                    this.getServletContext().getRequestDispatcher("/vistaEstudiante.jsp").forward(req, resp);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        respuesta.forward(req,resp);
    }

    private Estudiante obtenerEstudiante(HttpServletRequest req) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Estudiante> estudiante = EstudianteDAO.obtenerEstudiante(query,"numero_matricula", req.getParameter("matriculaLogin"));
        if(estudiante.size() == 1){
            return estudiante.get(0);
        }
        else{
            return null;
        }
    }
}
