<%-- 
    Document   : admin_page
    Created on : 21 May 2023, 1:13:18 AM
    Author     : Jakaza G Chauke
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
                                <a class="nav-link click-scroll" href="#section_1">Admin Page</a>
                            </li>

                        </ul>
                    </div>
                </nav>
                <div class="col-md-8  ms-sm-auto col-lg-9 p-0">
                    <section class=" d-flex justify-content-center align-items-center" id="section_1">

                        <div class="container ">
                            
                            <p class="pt-5">Admin Menu</p>
                            
                            <a href="ViewBookingsServlet.do" class="btn btn-primary mb-4">View All Bookings</a>  <br>
                            
                            <a href="ViewTodaysBookingServlet.do" class="btn btn-primary mb-4">View All Today's Bookings</a>  <br>
                            
                            <a href="ViewAllCustomersServlet.do" class="btn btn-secondary mb-4">View All Customers</a>  <br>
                         
                            <a href="age_range.jsp" class="btn btn-secondary mb-4">View Customers of specific age</a>  <br>
                            
                            <a href="gender_selection.jsp" class="btn btn-secondary mb-4">View Customers By Gender</a>  <br>
                            
                        </div>


                        <!-- Modal -->
                        <div class="modal fade " id="updateDetails" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                <h1 class="modal-title fs-5" id="updateDetails">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">


                                    <form>
                                        <p>Record ID : </p>


                                      <div class="mb-1">
                                        <label for="age" class="form-label">Status : </label>
                                        <select class="form-select" aria-label="" >
                                            <option selected>Select Status</option>
                                            <option value="male">Pending</option>
                                            <option value="female">Done</option>
                                          </select>
                                      </div>
                                      <div class="mb-1">
                                        <input type="submit" class="btn  btn-sm  btn-primary" value="update status">
                                      </div>
                                    </form>

                                    <br>

                                    <form>
                                        <div class="mb-1">
                                            <input type="submit" class="btn btn-sm btn-danger" value="Delete">
                                          </div>
                                    </form>


                                </div>
                                <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                            </div>
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