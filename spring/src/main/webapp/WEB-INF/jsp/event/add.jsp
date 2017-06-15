<%@include file="../includes/header.jsp"%>

<div class="panel panel-primary">

	<div class="panel-heading">
		<h3 class="panel-title">Add Event</h3>
	</div>

	<div class="panel-body">
		${error }
		<form:form method="post" commandName="event" 
			action="${pageContext.request.contextPath }/event/add">
			
			<div class="form-group">
				<label for="title">Title(*): </label> 
				<form:input path="title" 
						cssClass="form-control" id="title" />
				<form:errors cssClass="error" path="title" />
			</div>
			
			<div class="form-group">
				<label for="location">Location(*):</label> 
				<form:input path="location" 
						cssClass="form-control" id="location" />	
				<form:errors cssClass="error" path="location" />
			</div>
			
			<div class="form-group">
				<label for="attendeeList">Attendee List(*):</label> 
				<form:textarea path="attendeeList" 
						cssClass="form-control" 
						id="attendeeList" 
						cols="20" 
						rows="5" />	
				<form:errors cssClass="error" path="attendeeList" />
			</div>
			
			<div class="form-group">
			    <label for="date">Date:</label>
			    <input type="text" name="date" class="form-control" id="dateEvent">
			</div>
			
			<div class="form-group">
			    <label for="time">Time:</label>
			    <div class="form-inline">
			    	<div class="form-group">
					    <label for="email">Hour:</label>
					    <select name="hours" class="form-control">
					    	<% for(int i = 1; i <= 24; i++) { %>
					    		<option value="<%= i %>"><%= i %></option>
					    	<% } %>
					    </select>
					 </div>
					 <div class="form-group">
					    <label for="email">Minutes:</label>
					    <select name="minutes" class="form-control">
					    	<% for(int i = 1; i <= 60; i++) { %>
					    		<option value="<%= i %>"><%= i %></option>
					    	<% } %>
					    </select>
					 </div>
			    </div>
			</div>
			
			<div class="form-group">
			    <label for="reminderTime">Reminder Time:</label>
			    <input type="text" name="reminderTime" 
			    	class="form-control" id="reminderTime">
			</div>
			
			<div class="form-group">
				<label for="location">Reminder Sent:</label> 
				<form:input path="reminderSent" 
						cssClass="form-control" id="reminderSent" />
				<form:errors cssClass="error" path="reminderSent" />	
			</div>
			
			<button type="submit" class="btn btn-default">Save</button>
		</form:form>

	</div>

</div>

<%@include file="../includes/footer.jsp"%>