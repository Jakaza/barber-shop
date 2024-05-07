<%-- 
    Document   : user_profile
    Created on : 21 May 2023, 1:53:11 AM
    Author     : Jakaza G Chauke
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Bookings"%>
<%@page import="za.ac.tut.entities.Person"%>
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
        
           Person person = (Person)session.getAttribute("person");
            List<Bookings> bookings = (List<Bookings>) request.getAttribute("bookings");
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
                                <a class="nav-link click-scroll" href="#section_1">Profile Page</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="col-md-8  ms-sm-auto col-lg-9 p-0">
                    <section class=" d-flex justify-content-center align-items-center" id="section_1">

                        <div class="container ">
                            <a href="bookings_page.jsp" class="btn btn-success mt-3">Home page</a>
                            <p class="pt-5">Profile</p>
                            <table>
                                <tr>
                                    <th>Name : </th>
                                    <th><%= person.getFirstname()%></th>
                                </tr>
                                
                                <tr>
                                    <th>Surname : </th>
                                    <th><%= person.getSurname()%></th>
                                </tr>
                           <tr>
                                    <th>Email : </th>
                                    <th><%= person.getEmail()%></th>
                                </tr>
                                                                                        <tr>
                                    <th>Gender : </th>
                                    <th><%= person.getGender()%></th>
                                </tr>
                                
                                                           <tr>
                                    <th>Age : </th>
                                    <th><%= person.getAge()%></th>
                                </tr>
                            </table>
                                
                               <%if(bookings.size() > 0){%>
                                
                                <p class="pt-5">List Of All Your Bookings</p>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Contact</th>
                                        <th scope="col">Branches</th>
                                        <th scope="col">Style</th>
                                        <th scope="col"># People</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Time</th>
                                        <th scope="col">Status</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                         SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                                        for (int i = 0; i < bookings.size(); i++) {
                                            Bookings booking = bookings.get(i);
                                            String date = dateFormat.format(booking.getDate());
                                            String time = timeFormat.format(booking.getTime());
                                    %>
                                    <tr>
                                        <th scope="row"><%=(i+1)%></th>
                                        <td><%=booking.getName()%></td>
                                        <td><%=booking.getContacts()%></td>
                                        <td><%=booking.getBranch()%></td>
                                        <td><%=booking.getStyle()%></td>
                                        <td><%=booking.getNumPeople()%></td>
                                        <td><%=date%></td>
                                        <td><%=time%></td>
                                        <td><%=booking.getStatus()%></td>
                                       
                                    </tr>
       
                                     <%
                                        }
                                    %>
                                </tbody>
                            </table>
                                
                                <%
                                    }else{
                                %>
                                
                                 <p class="pt-5">There are no bookings for the current profile. click the button below to book.</p>
                                 
                                 <a class="btn btn-primary" href="bookings_page.jsp">Book Now</a>
                                 
                                 <%}%>
                                
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
<a href="entry_page.html"></a>