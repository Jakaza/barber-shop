<%-- 
    Document   : view_deleted_bookings
    Created on : 22 May 2023, 9:38:52 AM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="">
        <meta name="author" content="">

        <title>Gentlemen's Barber Shop - HTML CSS Template</title>

        <!-- CSS FILES -->        
        <link rel="preconnect" href="https://fonts.googleapis.com">

        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Unbounded:wght@300;500&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/templatemo-barber-shop.css" rel="stylesheet">

        <link rel="stylesheet" href="/css/index.css">
        <!--
        
        TemplateMo 585 Barber Shop
        
        https://templatemo.com/tm-585-barber-shop
        
        -->
    </head>

    <body>
        
        <%
            Long booking_id = (Long) request.getAttribute("booking_id");
        %>
        
        <div class="container-fluid">
            <div class="row">

                <button class="navbar-toggler d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <nav id="sidebarMenu" class="col-md-4 col-lg-3 d-md-block sidebar collapse p-0">

                    <div class="position-sticky sidebar-sticky d-flex flex-column justify-content-center align-items-center">
                        <a class="navbar-brand" href="index.html">
                            <img src="images/templatemo-barber-logo.png" class="logo-image img-fluid" align="">
                        </a>

                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link click-scroll" href="#section_1">Deleted Bookings Page</a>
                            </li>

                        </ul>
                    </div>
                </nav>
                <div class="col-md-8  ms-sm-auto col-lg-9 p-0">
                    <section class=" d-flex justify-content-center align-items-center" id="section_1">

                        <div class="container ">
                            
                            <p class="pt-5">The booking with the following id <%=booking_id%>  has been successfully deleted.</p>
                             
                            <a href="ViewBookingsServlet.do" class="btn btn-success mt-3">Admin's page</a>
                        </div>

                    </section>
                </div>
                <!-- JAVASCRIPT FILES -->
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/click-scroll.js"></script>
                <script src="js/custom.js"></script>

                </body>
               </html>