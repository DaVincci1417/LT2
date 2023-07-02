package Controller;

import Model.Apunte;
import Model.Data.DAO.ApunteDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "agregarApunteServlet", value = "/agregarApunte")
public class agregarApunteServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarApunte.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorAgregarApunte.jsp");
        if(req.getParameter("nombre_apunte").length() != 0 || req.getParameter("cod_asignatura").length() != 0
                || req.getParameter("fecha_apunte").length() != 0 || req.getParameter("apunte").length() != 0){

            Date fechaApunte;
            String nombreApunte = req.getParameter("nombre_apunte");
            int codAsignatura = Integer.parseInt(req.getParameter("cod_asignatura"));
            try {
                fechaApunte = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("fecha_apunte"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String textoApunte = req.getParameter("apunte");

            Apunte apunte = new Apunte(nombreApunte, codAsignatura, fechaApunte, textoApunte);

            try {
                if(agregarApunte(apunte)){
                    req.setAttribute("Apunte",apunte);
                    respuesta = req.getRequestDispatcher("/exitoAgregarApunte.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarApunte(Apunte apunte) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Apunte> apuntes = ApunteDAO.obtenerApunte(query,"cod_apunte", Integer.toString(apunte.getCodApunte()));
        if(apuntes.size()!=0){
            return false;
        }
        else{
            ApunteDAO.agregarApunte(query,apunte);
            return true;
        }
    }
}