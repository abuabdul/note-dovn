<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp"%>
    <!-- ScratchPad Write Section -->
    <section id="scratchform" class="scratchform-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
	                    <h1>Scratch Pad</h1>
	                    <p><strong>Write down your notes, scratch text, scripts</strong></p>
	                    <a class="btn btn-default page-scroll" href="#about"><span class="glyphicon glyphicon-triangle-bottom scroll-down"></span></a>
                </div>
                <div class="col-xs-12 col-md-12 buffer-bottom">
                    <h1>{</h1>
					<c:url var="scratchPadUrl" value="/secure/scratch/makeNotes.go"/>
                    <form:form id="scratchPadForm" class="form-horizontal" role="form" modelAttribute="scratchPadForm" action="${scratchPadUrl}" method="post">
		                   <div class="form-group">
		                       <div class="col-sm-3"></div>
		                       <div class="col-sm-6">
								    <c:if test="${saveNoteDetails}">
										<div class="alert alert-success">
											<a href="#" class="close" data-dismiss="alert">&times;</a> 
											Noted!!!
										</div>
							        </c:if>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
	  					   <div class="form-group">
		  					   <div class="col-sm-3"></div>
							   <div class="col-sm-6">
								   <form:input type="text" class="form-control no-border" path="category" placeholder="Category" 
								               data-toggle="tooltip" data-placement="top"
								               title="Category just helps to classify notes"/>
							    </div>
								<div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
							  <div class="col-sm-3"></div>
							  <div class="col-sm-6">
							      <form:input type="text" class="form-control no-border" path="aboutNote" placeholder="What is it about?"
							      			  data-toggle="tooltip" data-placement="top"
								              title="Tell us about note, what is it all about?"/>
							  </div>
							  <div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
							   <div class="col-sm-3"></div>
							   <div class="col-sm-6">
							      <form:input type="text" class="form-control no-border" path="reasonNote" placeholder="Why is it?"
							      			  data-toggle="tooltip" data-placement="top"
								              title="You could have done something, why is it you want a note?"/>							      
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
							   <div class="col-sm-3"></div>
							   <div class="col-sm-6">
							      <form:input type="text" class="form-control no-border" path="noteMsg" placeholder="A keynote"
   							      			  data-toggle="tooltip" data-placement="top"
								              title="Place your key note text here"/>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
							   <div class="col-sm-3"></div>
							   <div class="col-sm-6">
							      <form:input type="text" class="form-control no-border" path="sideNote" placeholder="An expressive side note"
							      			  data-toggle="tooltip" data-placement="top"
								              title="You can also tell us elaborately anything with this keynote message?"/>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
						   <div class="form-group">
							   <div class="col-sm-3"></div>
							   <div class="col-sm-6">
							       <button type="button" id="resetButton" class="btn btn-sm btn-default">Clear</button>
							       &nbsp;
							      <button type="submit" class="btn btn-sm btn-primary">Note-Dovn</button>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
					</form:form>
					<h1>}</h1>
                </div>
            </div>
        </div>
    </section>
    <!-- ScratchPad Section -->
    <section id="scratchpad" class="scratchpad-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <h1>Notes</h1>
			    </div>
			    <div class="col-xs-12 col-md-12">
				    <div class="col-sm-4">
					   <div class="note">
					     <a href="#" class="close" data-dismiss="alert">&times;</a>
					     Pinned text that can span upto col-sm-3 and for medium and large desktops
					   </div>
					</div>
					<div class="col-sm-4">
					   <div class="note">
					     <a href="#" class="close">&times;</a>
					     Pinned text that can span upto col-sm-3 and for medium and large desktops
					   </div>
					</div>
					<div class="col-sm-4">
					   <div class="note">
					     <a href="#" class="close" data-dismiss="alert">&times;</a>
					     Pinned text that can span upto col-sm-3 and for medium and large desktops
					   </div>
					 </div>
			    </div>
			    <div class="col-xs-12 col-md-12 buffer-bottom">
	                 &nbsp;
                </div>
            </div>
        </div>
    </section>
    
    <!-- About Section -->
    <section id="about" class="about-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <h1>About Section</h1>
                    <a class="btn btn-default page-scroll" href="#scratchform"><span class="glyphicon glyphicon-triangle-top scroll-up"></span></a>
                </div>
            </div>
        </div>
    </section>
