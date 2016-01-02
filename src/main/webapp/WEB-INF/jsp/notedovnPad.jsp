<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Scrolling Nav - Start Bootstrap Template</title>

	<!-- Bootstrap -->
	<link href="<c:url value='/resources/css/bootstrap.min.css'/>"	rel="stylesheet">
	<link href="<c:url value='/resources/css/scrolling-nav.css'/>" rel="stylesheet">
	<link href="<c:url value='/resources/css/note-dovn.css'/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="<c:url value='/scratch/notedovnPad.go'/>">
                     <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                     <span class="brand-logo">Note-Dovn</span> 
                 </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a class="page-scroll" href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#scratchpad">ScratchPad</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Section -->
    <section id="scratchform" class="scratchform-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Scratch Pad</h1>
                    <p><strong>Write down your notes, scratch text, scripts</strong> </p>
                    <a class="btn btn-default page-scroll" href="#about"><span class="glyphicon glyphicon-triangle-bottom scroll-down"></span></a>
                </div>
            </div>
        </div>
    </section>

    <!-- ScratchPad Section -->
    <section id="scratchpad" class="scratchpad-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1>ScratchPad Section</h1>
                </div>
            </div>
        </div>
    </section>
    
    <!-- About Section -->
    <section id="about" class="about-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1>About Section</h1>
                    <a class="btn btn-default page-scroll" href="#scratchform"><span class="glyphicon glyphicon-triangle-top scroll-up"></span></a>
                </div>
            </div>
        </div>
    </section>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

    <!-- Scrolling Nav JavaScript -->
    <script src="<c:url value='/resources/js/jquery.easing.min.js'/>"></script>
    <script src="<c:url value='/resources/js/scrolling-nav.js'/>"></script>

</body>

</html>
