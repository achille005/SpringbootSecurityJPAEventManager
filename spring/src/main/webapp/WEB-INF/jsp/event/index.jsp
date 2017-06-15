<%@include file="../includes/header.jsp"%>

<div class="panel panel-primary">

	<div class="panel-heading">
		<h3 class="panel-title">Event List</h3>
		<a href="${pageContext.request.contextPath }/event/today" class="panel-title">Today</a> / 
		<a href="${pageContext.request.contextPath }/event/week" class="panel-title">Week</a> / 
		<a href="${pageContext.request.contextPath }/event/month" class="panel-title">Month</a>
	</div>

	<div class="panel-body">
		
		<a href="${pageContext.request.contextPath }/event/add">Add New Event</a>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Time</th>
					<th>Option</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="event" items="${events }">
					<tr>
						<td>${event.title }</td>
						<td>${event.date }</td>
						<td>${event.time }</td>
						<td>
							<a href="${pageContext.request.contextPath }/event/edit/${event.id }">Edit</a> 
							| 
							<a href="${pageContext.request.contextPath }/event/delete/${event.id }" 
								onclick="return confirm('Are you sure?')">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>

<%@include file="../includes/footer.jsp"%>