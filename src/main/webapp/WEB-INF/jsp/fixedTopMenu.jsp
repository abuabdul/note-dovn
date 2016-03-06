<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp"%>
<script type="text/javascript">
	baseURL = '<spring:eval expression="@propertyConfigurer.getProperty(\'notedovn.app.base.url\')" />';
</script>
    <%-- Navigation --%>
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
                     <span class="brand-logo">note-dovn</span> 
                 </a>
            </div>

            <%-- Collect the nav links, forms, and other content for toggling --%>
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
                <ul class="nav navbar-nav pull-right">
                   <c:if test="${pageContext.request.userPrincipal.name != null}">
                     <li><a href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-out"></span></a></li>
				   </c:if>
                   <li><a href="http://abuabdul.com">&copy; abuabdul.com 2013-2016</a></li>
                </ul>
            </div>
        </div>
    </nav>