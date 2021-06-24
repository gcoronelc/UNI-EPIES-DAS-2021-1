<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: lightsteelblue">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav  w-100">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Inicio </a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="#">Ficha de Usuario</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="#">Matricula</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none " class="btn btn-outline-light" href="#">Tramites</a>
                    </li>
                </ul>
                <div class="dropdown ">
                    <button  class=" btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuario ingresado
                    </button>
                    <div class="dropdown-menu text-center" >
                        <a class="dropdown-item" href="#">
                            <img src="img/login2.jpeg" alt="60" width="60"/>
                        </a>
                        <a class="dropdown-item" href="#">${usuario.usuario}</a>
                        <div class="dropdown-divider"></div>
                        <a href="index.jsp" class="dropdown-item" href="#">Salir</a>
                    </div>
                </div>
            </div>
        </nav>
        <script src="js/jquery-3.5.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>