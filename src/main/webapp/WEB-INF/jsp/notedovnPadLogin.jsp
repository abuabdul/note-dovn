<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp"%>
<%@page session="true" %>
    <%-- ScratchPad LogIn Section --%>
    <section id="scratchform" class="scratchform-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
	                    <h1>Log In</h1>
	                    <p><strong>Write down your notes, scratch text, scripts</strong></p>
                </div>
                <div class="col-xs-12 col-md-12 buffer-bottom">
                    <c:url var="userLoginUrl" value="/secure/scratch/login.go"/>
	            	<form:form id="loginForm" class="form-horizontal" role="form" modelAttribute="loginForm" action="${userLoginUrl}" method="post">
	  			         <div class="alert alert-info">
		                   	Looks like abuabdul can only log in. You can request for login account, or feel free to fork the code from github and make your own version.
	                     </div>
 	                     <div class="form-group">
		                       <div class="col-sm-3"></div>
		                       <div class="col-sm-6">
								    <c:if test="${loginDetails}">
										<div class="alert alert-warning">
											<a href="#" class="close" data-dismiss="alert">&times;</a> 
											Username or Password is incorrect!!!
										</div>
							        </c:if>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
			  			    <div class="col-sm-3"></div>
							<div class="input-group input-append col-sm-6">
		                            <div class="input-group-addon add-on">@</div>
							        <form:input type="text" class="form-control" path="username" placeholder="username" 
									               data-toggle="tooltip" data-placement="top" title="User Name"/>
							</div>
							<div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
			  			    <div class="col-sm-3"></div>
							<div class="input-group input-append col-sm-6">
		                            <div class="input-group-addon add-on"><i class="fa fa-key"></i></div>
							        <form:input type="text" class="form-control" path="password" placeholder="password" 
									               data-toggle="tooltip" data-placement="top" title="Password"/>
							</div>
							<div class="col-sm-3"></div>
						 </div>
	                    <div class="form-group">
							   <div class="col-sm-3"></div>
							   <div class="col-sm-6 text-center">
							      <button type="submit" class="btn btn-sm btn-primary" title="Log In">Log In</button>
							   </div>
							   <div class="col-sm-3"></div>
						</div>
	                </form:form>
                </div>
            </div>
        </div>
    </section>