<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>On the GO</title>

        <!-- CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- font -->
        <link href='http://fonts.googleapis.com/css?family=Nova+Square' rel='stylesheet'>
        <link rel="stylesheet" href="font/font.css">
    </head>
    <body id="p-contact">
        <div id="wrapper">
            <section class="section-1">
                <div class="container">
                    <header class="site-header">
                        <div class="row">
                            <div class="col-sm-4 col-xs-8">
                                <h1 class="logo"><a href="index.html">On the GO</a></h1>
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
                                            <a href="http://localhost:8000/OCRP/logout.jsp">Logout</a>
                                            <%}%></li>
                                        </ul>
                                    </div><!-- /.navbar-collapse -->
                                </nav>
                            </div>
                        </div>  <!-- row -->
                    </header>   <!-- site header -->
                </div>
            </section>

            <section class="contact-block">
            	<div class="container">
            		<div class="row">
            			<div class="col-md-12">
            				<h1 class="main-page-header">Register Cycle</h1>
            				<h3 class="main-sub-header">Contribute to the Community</h3>
            			</div>
            		</div><!-- row -->
            		<div class="row">
            			<div class="col-md-12">
            				<form id="contact-form" method="post" action="RegCyc">
                                <div class="clearfix">
            						<label>Cycle Number(May use mobile number if not Known)<span>*</span></label>
            						<input name="cid" type="text" required>
                                    <label>Cycle Type/Model<span>*</span></label>
                                    <input name="ctype" type="text" required>
                                    <label>Hall/Stand Used<span>*</span></label>
                                    <input name="hall" type="text" required>
            						<input class="btn-submit" type="submit" value="Submit">
            					</div>
            				</form>
            			</div>
            		</div>
            	</div>
            </section>

            <footer class="site-footer">
                <div class="copyright">
                    &copy; Vivek Gupta 16CS30040
                </div>
            </footer>
        </div>  <!-- wrapper -->

        <!-- js -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script>
            $(document).ready(function(){
                $('.owl-carousel').owlCarousel({
                    loop:true,
                    margin:10,
                    autoplay:true,
                    autoplayTimeout:3000,
                    autoplayHoverPause:true,
                    responsiveClass:true,
                    responsive:{
                            0:{
                                items:1,
                            },
                            600:{
                                items:1,
                            },
                            1000:{
                                items:1,
                            }
                    }
                })
            });
        </script>
        <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-55162400-1', 'auto');
      ga('send', 'pageview');
    </script>
    </body>
</html>
