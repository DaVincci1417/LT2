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
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registrarEstudianteServlet", value = "/registrarEstudiante")
public class registrarEstudianteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/registroDeAcademico.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorRegistrarAcademico.jsp");
        if(req.getParameter("nombre").length()!=0 || req.getParameter("apellido_paterno").length() != 0 || req.getParameter("apellido_materno").length() != 0
                || req.getParameter("rut").length() != 0 || req.getParameter("correo_institucional").length() != 0 || req.getParameter("numero_matricula").length() != 0
                || req.getParameter("carrera").length() != 0|| req.getParameter("sexo").length() != 0 || req.getParameter("nombre_usuario").length() != 0 || req.getParameter("contraseña").length() != 0){
            String nombre = req.getParameter("nombre");
            String apellidoPaterno = req.getParameter("apellido_paterno");
            String apellidoMaterno = req.getParameter("apellido_materno");
            String rut = req.getParameter("rut");
            String correoInstitucional = req.getParameter("correo_institucional");
            int numeroMatricula = Integer.parseInt(req.getParameter("numero_matricula"));
            String carrera = req.getParameter("carrera");
            String sexo = req.getParameter("sexo");

            String nombreUsuario = req.getParameter("nombre_usuario");
            String contraseña = req.getParameter("contraseña");
            String tipoUsuario = "Estudiante";

            Estudiante estudiante = new Estudiante(rut, nombre, apellidoPaterno, apellidoMaterno, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario, carrera, numeroMatricula);


            try {
                if(agregarEstudiante(estudiante)){
                    req.setAttribute("Estudiante",estudiante);
                    respuesta = req.getRequestDispatcher("/exitoRegistrarEstudiante.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarEstudiante(Estudiante estudiante) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Estudiante> estudiantes = EstudianteDAO.obtenerEstudiante(query,"numero_matricula", estudiante.getNumeroMatricula());
        if(estudiantes.size()!=0){
            return false;
        }
        else{
            EstudianteDAO.agregarEstudiante(query,estudiante);
            return true;
        }
    }
}
