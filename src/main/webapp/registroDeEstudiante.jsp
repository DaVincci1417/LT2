<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 25-06-2023
  Time: 12:43
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
            <form class="user">
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
              <div class="form-group">
                <input type="number" class="form-control form-control-user" id="numero_matricula" name="numero_matricula"
                       placeholder="N° Matricula" required>
              </div>
              <div class="form-group row">
                <div class="col-sm-6 mb-3 mb-sm-0">
                  <select class="custom-select animated--grow-in" id="carrera" name="carrera" required>
                    <option value="" disable selected hidden>Carrera</option>
                    <option value="plan_comun_ing_civil">Plan Común de Ingenieria Civil</option>
                    <option value="ing_civil">Ingenieria Civil</option>
                    <option value="ing_civil_ind">Ingenieria Civil Industrial</option>
                    <option value="ing_civil_ind_mec">Ingenieria Civil Industrial mención Mecánica</option>
                    <option value="ing_civil_ind_bio">Ingenieria Civil Industrial mención Bioprocesos</option>
                    <option value="ing_civil_ind_inf">Ingenieria Civil Industrial mención Informática</option>
                    <option value="ing_civil_quimica">Ingenieria Civil Química</option>
                    <option value="ing_civil_fisica">Ingenieria Civil Física</option>
                    <option value="ing_civil_mecanica">Ingenieria Civil Mecánica</option>
                    <option value="ing_civil_amb">Ingenieria Civil Ambiental</option>
                    <option value="ing_civil_electrica">Ingenieria Civil Eléctrica</option>
                    <option value="ing_civil_electronica">Ingenieria Civil Electrónica</option>
                    <option value="ing_civil_informatica">Ingenieria Civil Informática</option>
                    <option value="ing_civil_matematica">Ingenieria Civil Matemática</option>
                    <option value="ing_civil_telematica">Ingenieria Civil Telemática</option>
                    <option value="ing_civil_biotec">Ingenieria Civil Biotecnología</option>
                    <option value="ing_construccion">Ingenieria en Construcción</option>
                    <option value="ing_informatica">Ingenieria Informatica</option>
                    <option value="bioquimica">Bioquímica</option>
                  </select>
                </div>
                <div class="col-sm-6">
                  <select class="custom-select animated--grow-in" id="sexo" name="sexo" required>
                    <option value="" disable selected hidden>Sexo</option>
                    <option value="tarea">Masculino</option>
                    <option value="ayudantia">Femenino</option>
                    <option value="taller">Prefiero no decirlo</option>
                  </select>
                </div>
              </div>

              <!-- Divider -->
              <hr class="sidebar-divider">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4 small">Registro Usuario</h1>
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

              <a href="index.jsp" class="btn btn-primary btn-user btn-block">
                Registrar Cuenta
              </a>
              <hr>
            </form>
            <hr>
            <div class="text-center">
              <a class="small" href="loginEstudiante.jsp">¿Ya tienes una cuenta? ¡Ingresa!</a>
            </div>
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

</body>

</html>
