<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 25-06-2023
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="Componentes/head.jsp"%>
<%@ include file="Componentes/sidebar.jsp"%>
<%@ include file="Componentes/topbar.jsp"%>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Learning Tracker - FICA</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="h4 text-gray-900 mb-4">Nueva Asignatura</h1>
        </div>
        <div class="card-body">
            <form class="user" action="agregarAsignatura" method="post">
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" id="nombre_asignatura" name="nombre_asignatura" placeholder="Nombre" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" id="modulo" name="modulo" placeholder="Modulo" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="number" class="form-control form-control-user" id="semestre" name="semestre" placeholder="Semestre" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="semestre" class="form-control form-control-user" id="rut_academico" name="rut_academico" placeholder="RUT de Académico" required>
                    </div>
                </div>
                <!-- Divider -->
                <hr class="sidebar-divider">

                <input type="submit" value="Guardar Asignatura" class="btn btn-primary btn-user btn-block">
                <hr>
            </form>
        </div>
    </div>
</div>

<%@ include file="Componentes/footer.jsp"%>
<%@ include file="Componentes/alerta_Logout.jsp"%>
<%@ include file="Componentes/ending.jsp"%>