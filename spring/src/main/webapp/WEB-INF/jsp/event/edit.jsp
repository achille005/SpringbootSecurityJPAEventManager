<%@include file="../includes/header.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>

<div class="panel panel-primary">

	<div class="panel-heading">
		<h3 class="panel-title">Edit Event</h3>
	</div>

	<div class="panel-body">
		${error }
		<form:form method="post" commandName="event" 
			action="${pageContext.request.contextPath }/event/edit">
			
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
			    <fmt:formatDate var="dateEvent" 
			    	value="${event.date }" 
			    	pattern="MM/dd/yyyy"/>
			    <input type="text" name="date" 
			    	class="form-control" 
			    	id="dateEvent" 
			    	value="${dateEvent }">
			</div>
			
			<div class="form-group">
			    <label for="time">Time:</label>
			    <div class="form-inline">
			    	<div class="form-group">
					    <label for="email">Hour:</label>
					    <c:set var="timeEvent" value="${event.time }"></c:set>
					    <%  
					    	Date date = (Date)pageContext.getAttribute("timeEvent");
					    	Calendar calendar = Calendar.getInstance();
					    	calendar.setTime(date);
					    	int hour = calendar.get(Calendar.HOUR);
					    	int minute = calendar.get(Calendar.MINUTE);
					    %>
					    
					    <select name="hours" class="form-control">
					    	<% for(int i = 1; i <= 24; i++) { %>
					    		<option value="<%= i %>" 
					    			<%= hour == i ? "selected='selected'" : "" %>><%= i %></option>
					    	<% } %>
					    </select>
					 </div>
					 <div class="form-group">
					    <label for="email">Minutes:</label>
					    <select name="minutes" class="form-control">
					    	<% for(int i = 1; i <= 60; i++) { %>
					    		<option value="<%= i %>" 
					    			<%= minute == i ? "selected='selected'" : "" %>><%= i %></option>
					    	<% } %>
					    </select>
					 </div>
			    </div>
			</div>
			
			<div class="form-group">
			    <label for="reminderTime">Reminder Time:</label>
			    <fmt:formatDate var="reminderTime" 
			    	value="${event.reminderTime }" 
			    	pattern="MM/dd/yyyy"/>
			    <input type="text" name="reminderTime" 
			    	class="form-control" 
			    	id="reminderTime" 
			    	value="${reminderTime }">
			</div>
			
			<div class="form-group">
				<label for="location">Reminder Sent:</label> 
				<form:input path="reminderSent" 
						cssClass="form-control" id="reminderSent" />
				<form:errors cssClass="error" path="reminderSent" />	
			</div>
			<form:hidden path="id"/>
			<button type="submit" class="btn btn-default">Save</button>
		</form:form>

	</div>

</div>

<%@include file="../includes/footer.jsp"%>