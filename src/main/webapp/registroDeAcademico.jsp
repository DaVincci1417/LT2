<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 25-06-2023
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title> Learning Tracker - FICA </title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

  <div class="card o-hidden border-0 shadow-lg my-5">
    <div class="card-body p-0">
      <!-- Nested Row within Card Body -->
      <div class="row">
        <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
        <div class="col-lg-7">
          <div class="p-5">
            <div class="text-center">
              <h1 class="h4 text-gray-900 mb-4">Datos Personales</h1>
            </div>
            <form class="user" action="registrarAcademico" method="post">
              <div class="form-group">
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" required>
              </div>
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <input type="text" class="form-control form-control-user" id="apellido_paterno" name="apellido_paterno"
                         placeholder="Apellido Paterno" required>
                </div>
                <div class="col-sm-6">
                  <input type="text" class="form-control form-control-user" id="apellido_materno" name="apellido_materno"
                         placeholder="Apellido Materno" required>
                </div>
              </div>
              <div class="form-group">
                <input type="text" class="form-control form-control-user" id="rut" name="rut"
                       placeholder="RUT" required>
              </div>
              <div class="form-group">
                <input type="email" class="form-control form-control-user" id="correo_institucional" name="correo_institucional"
                       placeholder="Correo Institucional" required>
              </div>
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <select class="custom-select animated--grow-in" id="depto" name="depto" required>
                    <option value="" disable selected hidden>Departamento en cual trabaja</option>
                    <option value="depto_ciencias_fisicas">Departamento de Ciencias Físicas</option>
                    <option value="depto_ciencias_quimicas">Departamento de Ciencias Químicas y Recursos Naturales</option>
                    <option value="depto_ing_indutrial">Departamento de Ingeniería Industrial y de Sistemas</option>
                    <option value="depto_ing_matematica">Departamento de Ingeniería Matemática</option>
                    <option value="depto_ciencias_computacion">Departamento de Ciencias de la Computación e Informática</option>
                    <option value="depto_ing_mecanica">Departamento de Ingeniería Mecánica</option>
                    <option value="depto_ing_quimica">Departamento de Ingeniería Química</option>
                    <option value="depto_ing_obras">Departamento de Ingeniería de Obras Civiles</option>
                    <option value="depto_ing_electrica">Departamento de Ingeniería Eléctrica</option>
                    <option value="depto_matematica">Departamento de Matemática y Estadística</option>
                  </select>
                </div>
                <div class="col-sm-6">
                  <select class="custom-select animated--grow-in" id="sexo" name="sexo" required>
                    <option value="" disable selected hidden>Sexo</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                    <option value="#">Prefiero no decirlo</option>
                  </select>
                </div>
              </div>

              <!-- Divider -->
              <hr class="sidebar-divider">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Registro Usuario</h1>
              </div>

              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <input type="text" class="form-control form-control-user"
                         id="nombre_usuario" name="nombre_usuario" placeholder="Nombre Usuario" required>
                </div>
                <div class="col-sm-6">
                  <input type="password" class="form-control form-control-user"
                         id="contraseña" name="contraseña" placeholder="Contraseña" required>
                </div>
              </div>
              <input type="submit" value="Registrar Cuenta" class="btn btn-primary btn-user btn-block">
              <hr>
            </form>
            <hr>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>
<script src="js/sb-admin-2.js"></script>

</body>

</html>
