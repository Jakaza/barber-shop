<%-- 
    Document   : gender_selection
    Created on : 22 May 2023, 10:14:44 AM
    Author     : Student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Gentlemen's Barber Shop - HTML CSS Template</title>

        <!-- CSS FILES -->        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Unbounded:wght@300;500&display=swap" rel="stylesheet">

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <link href="css/bootstrap-icons.css" rel="stylesheet">

        <link href="css/templatemo-barber-shop.css" rel="stylesheet">

        <link rel="stylesheet" href="/css/index.css">
        
        <script src="path/to/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!--

TemplateMo 585 Barber Shop

https://templatemo.com/tm-585-barber-shop

-->
    </head>
    
    <body>
        
        <% String error = request.getParameter("error"); %>

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
                                <a class="nav-link click-scroll" href="#section_1"></a>
                            </li>


                            <li class="nav-item">
                                <p>Customer Selected by gender</p>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="col-md-8  margin-top-login ms-sm-auto col-lg-9 p-0">
                    <section class=" d-flex justify-content-center align-items-center" id="section_1">
                            
                            <div class="container mt-5">
                                <h3 class="pb-5">Find customer by Gender.</h3>
                                
                                
                                
                                <form class="row g-3 col-md-6"   action="ViewCustomerByGender.do" method="POST">

                                      <div class="mb-3">
                                        <label for="gender" class="form-label">Select Gender</label>
                                        <select name="gender" class="form-select" aria-label="">
                                            <option selected>Select Gender</option>
                                            <option value="male">Male</option>
                                            <option value="female">Female</option>
                                          </select>
                                        
                                      </div>


                                      <div class="mb-1">
                                        <input type="submit" class="btn btn-primary" value="Find Customer">
                                      </div>
                                </form>
                                
                            </div>





                            <div class="custom-block d-lg-flex flex-column justify-content-center align-items-center">
                                <img src="images/vintage-chair-barbershop.jpg" class="custom-block-image img-fluid" alt="">
                                <h4 ><strong class="text-white">Hurry Up! Get good haircut.</strong></h4>
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
