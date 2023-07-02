package Controller;

import Model.Academico;
import Model.Data.DAO.AcademicoDAO;
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

@WebServlet(name = "registrarAcademicoServlet", value = "/registrarAcademico")
public class registrarAcademicoServlet extends HttpServlet {
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
                || req.getParameter("rut").length() != 0 || req.getParameter("correo_institucional").length() != 0 || req.getParameter("depto").length() != 0
                || req.getParameter("sexo").length() != 0 || req.getParameter("nombre_usuario").length() != 0 || req.getParameter("contraseña").length() != 0){
            String nombre = req.getParameter("nombre");
            String apellidoPaterno = req.getParameter("apellido_paterno");
            String apellidoMaterno = req.getParameter("apellido_materno");
            String rut = req.getParameter("rut");
            String correoInstitucional = req.getParameter("correo_institucional");
            String depto = req.getParameter("depto");
            String sexo = req.getParameter("sexo");

            String nombreUsuario = req.getParameter("nombre_usuario");
            String contraseña = req.getParameter("contraseña");
            String tipoUsuario = "Academico";

            Academico academico = new Academico(rut, nombre, apellidoPaterno, apellidoMaterno, correoInstitucional, sexo, nombreUsuario, contraseña, tipoUsuario, depto);


            try {
                if(agregarAcademico(academico)){
                    req.setAttribute("Academico",academico);
                    respuesta = req.getRequestDispatcher("/exitoRegistrarAcademico.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarAcademico(Academico academico) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Academico> academicos = AcademicoDAO.obtenerAcademico(query,"rut", academico.getRut());
        if(academicos.size()!=0){
            return false;
        }
        else{
            AcademicoDAO.agregarAcademico(query,academico);
            return true;
        }
    }
}
