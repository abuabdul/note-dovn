<%@ include file="/WEB-INF/jsp/includes/siteTags.jsp"%>
    <%-- ScratchPad Write Section --%>
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
							      <button type="submit" class="btn btn-sm btn-primary">note-dovn</button>
							   </div>
							   <div class="col-sm-3"></div>
						   </div>
					</form:form>
					<h1>}</h1>
                </div>
            </div>
        </div>
    </section>
    <%-- ScratchPad Section --%>
    <section id="scratchpad" class="scratchpad-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <h1>Notes</h1>
			    </div>
			    <c:if test="${not empty notesFolder}">
			      <c:forEach items="${notesFolder}" var="folder">
			        <c:url var="removeScratchPadUrl" value="/secure/scratch"/>
				    <div class="col-xs-12 col-md-12">
					    <div class="col-sm-4">
						     <c:if test="${not empty folder.oneInTrioNote.id}">
						        <div class="note">
							      <a id="${removeScratchPadUrl}/${folder.oneInTrioNote.id}/removeNotes.go" class="close remove" data-dismiss="alert"> &times; </a>
							      <span class="glyphicon glyphicon-pushpin pull-left"></span><br>
							      <a href="#" class="editable" id="category" data-pk="${folder.oneInTrioNote.id}">${folder.oneInTrioNote.category}</a><br>
							      <a href="#" class="editable" id="aboutNote" data-pk="${folder.oneInTrioNote.id}">${folder.oneInTrioNote.aboutNote}</a><br>
							      <a href="#" class="editable" id="reasonNote" data-pk="${folder.oneInTrioNote.id}">${folder.oneInTrioNote.reasonNote}</a><br>
							      <a href="#" class="editable" id="noteMsg" data-pk="${folder.oneInTrioNote.id}">${folder.oneInTrioNote.noteMsg}</a><br>
							      <a href="#" class="editable" id="sideNote" data-pk="${folder.oneInTrioNote.id}">${folder.oneInTrioNote.sideNote}</a>
							     </div>
							 </c:if>    
						</div>
						<div class="col-sm-4">
						     <c:if test="${not empty folder.twoInTrioNote.id}">
						        <div class="note">
							      <a id="${removeScratchPadUrl}/${folder.twoInTrioNote.id}/removeNotes.go" class="close remove" data-dismiss="alert"> &times; </a>
							      <span class="glyphicon glyphicon-pushpin pull-left"></span><br>
							      <a href="#" class="editable" id="category" data-pk="${folder.twoInTrioNote.id}">${folder.twoInTrioNote.category}</a><br>
							      <a href="#" class="editable" id="aboutNote" data-pk="${folder.twoInTrioNote.id}">${folder.twoInTrioNote.aboutNote}</a><br>
							      <a href="#" class="editable" id="reasonNote" data-pk="${folder.twoInTrioNote.id}">${folder.twoInTrioNote.reasonNote}</a><br>
							      <a href="#" class="editable" id="noteMsg" data-pk="${folder.twoInTrioNote.id}">${folder.twoInTrioNote.noteMsg}</a><br>
							      <a href="#" class="editable" id="sideNote" data-pk="${folder.twoInTrioNote.id}">${folder.twoInTrioNote.sideNote}</a>
							     </div> 
						     </c:if> 
						</div>
						<div class="col-sm-4">
						   <c:if test="${not empty folder.threeInTrioNote.id}">
							   <div class="note">
   							      <a id="${removeScratchPadUrl}/${folder.threeInTrioNote.id}/removeNotes.go" class="close remove" data-dismiss="alert"> &times; </a>
							      <span class="glyphicon glyphicon-pushpin pull-left"></span><br>
							      <a href="#" class="editable" id="category" data-pk="${folder.threeInTrioNote.id}">${folder.threeInTrioNote.category}</a><br>
							      <a href="#" class="editable" id="aboutNote" data-pk="${folder.threeInTrioNote.id}">${folder.threeInTrioNote.aboutNote}</a><br>
							      <a href="#" class="editable" id="reasonNote" data-pk="${folder.threeInTrioNote.id}">${folder.threeInTrioNote.reasonNote}</a><br>
							      <a href="#" class="editable" id="noteMsg" data-pk="${folder.threeInTrioNote.id}">${folder.threeInTrioNote.noteMsg}</a><br>
							      <a href="#" class="editable" id="sideNote" data-pk="${folder.threeInTrioNote.id}">${folder.threeInTrioNote.sideNote}</a>
							   </div>
							</c:if>   
						 </div>
				    </div>
				   </c:forEach> 
				</c:if>   
			    <div class="col-xs-12 col-md-12 buffer-bottom">
	                 &nbsp;
                </div>
            </div>
        </div>
    </section>
    
    <%-- About Section --%>
    <section id="about" class="about-section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <h1>About</h1>
                    <%-- write about --%>
                    <p><strong>Simple, handy notepad-like application. Very simple one page interface. 
                    Notes are pinned in the middle of the page where they can be edited and updated seamlessly. 
                    Notes are grouped by category. Otherwise it uses updated date time to group the notes. 
                    Scratchpad is limited to accept only few entries. About the note and key note message are mandatory information to create a new note, and the constraint also applies while updating any note</strong></p>
                    <a class="btn btn-default page-scroll" href="#scratchform"><span class="glyphicon glyphicon-triangle-top scroll-up"></span></a>
                </div>
            </div>
        </div>
    </section>
