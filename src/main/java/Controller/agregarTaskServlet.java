package Controller;

import Model.Data.DAO.TaskDAO;
import Model.Data.DBGenerator;
import Model.Task;
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

@WebServlet(name = "agregarTaskServlet", value = "/agregarTask")
public class agregarTaskServlet extends HttpServlet {
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
        RequestDispatcher respuesta = request.getRequestDispatcher("/agregarTask.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorAgregarTask.jsp");
        if(req.getParameter("nombre_tarea").length()!=0 || req.getParameter("cod_asignatura").length() != 0 || req.getParameter("tipo_tarea").length() != 0
                || req.getParameter("fecha_tarea").length() != 0){
            Date fechaTask;
            String nombreTask= req.getParameter("nombre_tarea");
            int codAsignatura = Integer.parseInt(req.getParameter("cod_asignatura"));
            String tipoTask = req.getParameter("tipo_tarea");
            try {
                fechaTask = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("fecha_tarea"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Task task = new Task(nombreTask, codAsignatura, tipoTask, fechaTask);

            try {
                if(agregarTask(task)){
                    req.setAttribute("Task",task);
                    respuesta = req.getRequestDispatcher("/exitoAgregarTask.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarTask(Task task) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        TaskDAO.agregarTask(query,task);
        return true;
    }
}
