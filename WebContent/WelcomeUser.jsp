<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>On the GO</title>

        <!-- CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/ionicons.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- font -->
        <link href='http://fonts.googleapis.com/css?family=Nova+Square' rel='stylesheet'>
        <link rel="stylesheet" href="font/font.css">
    </head>
    <body>
        <div id="wrapper">
            <section class="section-1">
                <div class="container">
                    <header class="site-header">
                        <div class="row">
                            <div class="col-sm-4 col-xs-8">
                                <h1 class="logo"><a href="http://localhost:8000/OCRP/WelcomeUser.jsp">On the GO</a></h1>
                            </div>
                            <div class="col-sm-8 col-xs-4">
                                <nav class="navbar pull-right" role="navigation">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                        <span class="ion-navicon"></span>
                                    </button>

                                    <!-- Collect the nav links, forms, and other content for toggling -->
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <ul class="nav navbar-nav">
                                            <li><a href="http://localhost:8000/OCRP/WelcomeUser.jsp">Home</a></li>
                                            <li><%if(session.getAttribute("islogin").toString()=="0"){%>
                                            <a href="http://localhost:8000/OCRP/login.jsp">Login</a>
                                            <%}else{%>
                                            <a href="http://localhost:8000/OCRP/home.jsp">Logout</a>
                                            <%}%></li>
                                        </ul>
                                    </div><!-- /.navbar-collapse -->
                                </nav>
                            </div>
                        </div>  <!-- row -->
                    </header>   <!-- site header -->

                    <h1 class="promo-text">Online Cycle Rental Portal</h1>
                    <div class="CTA text-center">
                        <a class="btn-CTA">IIT Kharagpur</a></button>
                    </div>
                </div>
            </section>
            
            <section class="section-2">
                <div class="container">
                    <div class="row">
                        <div class="col-md-1">
                            <div class="icon-holder icon-holder-1">
                                <span class="ion-ios7-people-outline"></span>
                            </div>
                        </div>
                        <div class="col-md-11">
                            <%
                            if(session.getAttribute("inRide").equals("Yes")){  %>
                            	<a href="http://localhost:8000/OCRP/RentFinish.jsp"><h2>Current Ride</h2></a>
                        	   <%
                            }
                            else{%>
                            	 <a href="http://localhost:8000/OCRP/GetRide.jsp"><h2>Get Ride</h2></a>
                            <%} %>
                        </div>
                    </div>  <!-- row -->

                    <div class="row">
                        <div class="col-md-1">
                            <div class="icon-holder icon-holder-2">
                                <span class="ion-ios7-search"></span>
                            </div>
                        </div>
                        <div class="col-md-11">
                            <a href="http://localhost:8000/OCRP/RegisterCycle.jsp"><h2>Register Cycle</h2></a>
                        </div>
                    </div>  <!-- row -->

                    <div class="row">
                        <div class="col-md-1">
                            <div class="icon-holder icon-holder-3">
                                <span class="ion-ios7-cloudy-night-outline"></span>
                            </div>
                        </div>
                        <div class="col-md-11">
                            <a href="http://localhost:8000/OCRP/ManageCycle.jsp"><h2>Manage Cycle</h2></a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-1">
                            <div class="icon-holder icon-holder-1">
                                <span class="ion-ios7-people-outline"></span>
                            </div>
                        </div>
                        <div class="col-md-11"> 
                            <a href="http://localhost:8000/OCRP/FileReport.jsp"><h2>File Report</h2></a>
                        </div>
                    </div>  
                </div>
            </section> 
    </body>
    <footer class="site-footer">
                <div class="copyright">
                    © Vivek Gupta 16CS30040
                </div>
            </footer>
</html>
