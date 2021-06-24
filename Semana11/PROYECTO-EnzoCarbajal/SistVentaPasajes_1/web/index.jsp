

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>SISTEMA DE VENTA DE PASAJES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/index.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body class="img js-fullheight" style="background-image: url(img/fondo.jpg);">
        <section class="ftco-section">
            <div class="container">

                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap py-5">
                            <div class="img d-flex align-items-center justify-content-center" style="background-image: url(img/icono.jpg);"></div>
                            <h3 class="text-center mb-0">BIENVENIDO</h3>
                            <p class="text-center">Ingrese su usuario y clave</p>
                            <C:if test="${not empty mensaje}">
                                <div class="alert alert-danger alert-dismissible fade show">  
                                    <button type="button" class="close" data-dismiss="alert">×</button>  
                                    <h4 class="alert-heading">Error!</h4> ${mensaje} 
                                </div>
                            </C:if>
                            <form class="form-signin" method="post" action="LogonControllerIngresar" >                              
                                <div class="form-group">
                                    <div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-user"></span></div>
                                    <input type="text" id="usuario" name="usuario" class="form-control" placeholder="Usuario" required>                              
                                </div>
                                <div class="form-group">
                                    <div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-lock"></span></div>
                                    <input id="clave" name="clave" type="password" class="form-control" placeholder="Clave" required>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn form-control btn-primary rounded submit px-3">Ingresar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Option 2: Separate Popper and Bootstrap JS -->

        <script src="js/jquery-3.5.1.min.js" ></script>
        <script src="js/popper.min.js" ></script>
        <script src="js/bootstrap.min.js" ></script>

    </body>
</html>
