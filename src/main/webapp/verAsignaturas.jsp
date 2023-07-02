<%@ page import="java.sql.ResultSet" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %><%--
<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/23/2023
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="Componentes/head.jsp"%>
<%@ include file="Componentes/sidebar.jsp"%>
<%@ include file="Componentes/topbar.jsp"%>

<%
    DBGenerator.iniciarBD("learning_tracker");
    Connection con;
    String Driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String clave = "";
    Class.forName(Driver);
    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/learning_tracker",user,clave);
    PreparedStatement prepared;
    ResultSet resultSet;
    prepared = con.prepareStatement("select * from asignatura");
    resultSet = prepared.executeQuery();
%>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Asignaturas</h1>
        <a href="agregarAsignatura.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50"></i>Agregar Asignatura</a>
    </div>
    <p class="mb-4">Asignaturas cursadas y/o cursando al 1-2023.</p>
    <!-- DataTales Asignatura -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Asignaturas</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Codigo Asignatura</th>
                        <th>Nombre Asignatura</th>
                        <th>Modulo</th>
                        <th>Semestre</th>
                        <th>RUT de Académico</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Codigo Asignatura</th>
                        <th>Nombre Asignatura</th>
                        <th>Modulo</th>
                        <th>Semestre</th>
                        <th>RUT de Académico</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <%
                        while(resultSet.next()){
                    %>
                    <tr>
                        <td><%= resultSet.getString("cod_asignatura")%></td>
                        <td><%= resultSet.getString("nombre_asignatura")%></td>
                        <td><%= resultSet.getInt("modulo")%></td>
                        <td><%= resultSet.getInt("semestre")%></td>
                        <td><%= resultSet.getString("rut_academico")%></td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="Componentes/footer.jsp"%>
<%@ include file="Componentes/alerta_Logout.jsp"%>
<%@ include file="Componentes/ending.jsp"%>

