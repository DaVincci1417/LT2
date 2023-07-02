<%@ page import="java.sql.ResultSet" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %><%--
<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 27-06-2023
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
  prepared = con.prepareStatement("select * from apunte");
  resultSet = prepared.executeQuery();
%>

<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Apuntes</h1>
    <a href="agregarApunte.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50"></i>Agregar Apunte</a>
  </div>
  <p class="mb-4">Apuntes actualizados a la fecha 02/07/2023</p>
  <!-- DataTales Apuntes-->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">Apuntes</h6>
    </div>
    <div class="card-header py-3 alert-warning">
      <h2 class="h4 text-gray-900 mb-4">Se ha agregado el APUNTE con exito.</h2>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
          <thead>
          <tr>
            <th>Codigo Apunte</th>
            <th>Nombre Apunte</th>
            <th>Codigo Asignatura</th>
            <th>Fecha Apunte</th>
            <th>Apunte</th>
          </tr>
          </thead>
          <tfoot>
          <tr>
            <th>Codigo Apunte</th>
            <th>Nombre Apunte</th>
            <th>Codigo Asignatura</th>
            <th>Fecha Apunte</th>
            <th>Apunte</th>
          </tr>
          </tfoot>
          <tbody>
          <%
            while(resultSet.next()){
          %>
          <tr>
            <td><%= resultSet.getString("cod_apunte")%></td>
            <td><%= resultSet.getString("nombre_apunte")%></td>
            <td><%= resultSet.getString("cod_asignatura")%></td>
            <td><%= resultSet.getDate("fecha_apunte")%></td>
            <td><%= resultSet.getString("texto_apunte")%></td>
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
