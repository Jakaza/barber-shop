<%-- 
    Document   : view_all_customers_by_age
    Created on : 21 May 2023, 4:23:05 PM
    Author     : Student
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Person"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            List<Person> customers = (List<Person>) request.getAttribute("customers");
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
                                <a class="nav-link click-scroll" href="#section_1">Admin Page</a>
                            </li>

                        </ul>
                    </div>
                </nav>
                <div class="col-md-8  ms-sm-auto col-lg-9 p-0">
                    <section class=" d-flex justify-content-center align-items-center" id="section_1">

                        <div class="container ">
                            <a href="admin_page.jsp" class="btn btn-success mt-3">Back </a>
                            <p class="pt-5">List Of People Who Book Seats by age range</p>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">First Name</th>
                                        <th scope="col">Surname</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Age</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Registered Date</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                        for (int i = 0; i < customers.size(); i++) {
                                            Person person = customers.get(i);
                                            String date = dateFormat.format(person.getCreationDate());
                                            
                                    %>
                                    <tr>
                                        <th scope="row"><%=(i+1)%></th>
                                        <td><%=person.getFirstname()%></td>
                                        <td><%=person.getSurname()%></td>
                                        <td><%=person.getGender()%></td>
                                        <td><%=person.getAge()%></td>
                                        <td><%=person.getEmail()%></td>
                                        <td><%=date%></td>
                              
                          
                                    </tr>
                                     <%
                                        }
                                    %>
                                </tbody>
                            </table>
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
