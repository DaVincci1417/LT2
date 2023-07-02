<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 26-06-2023
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="panelPrincipal.jsp">
      <div class="sidebar-brand-icon">
        <i class="fas fa-school"></i>
      </div>
      <div class="sidebar-brand-text mx-3">Learning Tracker</div>
    </a>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Heading -->
    <div class="sidebar-heading">
      Gestión
    </div>
    <!-- Nav Item - Apuntes_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="verApuntes.jsp">
        <i class="fas fa-book-open"></i>
        <span>Apuntes</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Ramos_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a type="submit" class="nav-link" href="verAsignaturas.jsp">
        <i class="fas fa-window-restore"></i>
        <span>Asignaturas</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Tareas_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="verTasks.jsp">
        <i class="fas fa-book-open"></i>
        <span>Tasks</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
  </ul>
  <!-- End of Sidebar -->
