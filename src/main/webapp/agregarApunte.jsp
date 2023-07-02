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
<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h1 class="h4 text-gray-900 mb-4">Nuevo Apunte</h1>
        </div>
        <div class="card-body">
            <form class="user" action="agregarApunte" method="post" >
                <div class="form-group ">
                    <input type="text" class="form-control form-control-user fa-th-large" id="nombre_apunte" name="nombre_apunte" placeholder="Nombre" required>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" id="cod_asignatura" name="cod_asignatura" placeholder="Codigo Asignatura" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" id="fecha_apunte" name="fecha_apunte" placeholder="Fecha" required>
                    </div>
                </div>
                <div class="form-group ">
                    <textarea class="form-control" id="apunte" name="apunte" placeholder="Apunte..." rows="10" required></textarea>
                </div>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <input type="submit" value="Guardar Apunte" class="btn btn-primary btn-user btn-block">
                <hr>
            </form>
        </div>
    </div>
</div>
<%@ include file="Componentes/footer.jsp"%>
<%@ include file="Componentes/alerta_Logout.jsp"%>
<%@ include file="Componentes/ending.jsp"%>
