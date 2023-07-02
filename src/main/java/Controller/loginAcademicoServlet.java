package Controller;

import Model.Academico;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginAcademicoServlet", value = "/loginAcademico")
public class loginAcademicoServlet extends HttpServlet{
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
        if(req.getParameter("rutLoginAcademico").length()!=0 && req.getParameter("contraseñaAcademico").length() != 0){
            String rutAcademico = req.getParameter("rutLoginAcademico");
            String contraseñaAcademico = req.getParameter("contraseñaAcademico");
        }
        respuesta.forward(req,resp);
    }
}
