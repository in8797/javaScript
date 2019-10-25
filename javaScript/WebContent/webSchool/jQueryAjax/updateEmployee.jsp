
<%@page import="emp.Employee"%>
<%@page import="emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../jquery/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#change").on("click", function() {
			var empId = $("input[name='empId']").val();
			var salary = $("input[name='salary']").val();
			var email = $("input[name='email']").val();

			$.ajax({
				url : "../../UpdateEmpServ",
				data : "empId=" + empId + "&salary=" + salary + "&email="+ email,
				success: function () {
					console.log("completed.");
					location.href = "listEmployee.html";
					
					
					

				}
			})
		})
	});
</script>
</head>
<body>
	<%
		String empId = request.getParameter("empId");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmployee(Integer.parseInt(empId));
	%>
	<table border="1">
		<tr>
			<td>FistName</td>
			<td><input type="text" readonly name="firstName"
				value="<%=emp.getFirstName()%>"></td>
		</tr>
		<tr>
			<td>lastName</td>
			<td><input type="text" readonly name="lastName"
				value="<%=emp.getLastName()%>"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%=emp.getEmail()%>"></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary"
				value="<%=emp.getSalary()%>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" id="change" value="변경"></td>
		</tr>
		<input type="hidden" name="empId" value="<%=emp.getEmployeeId()%>">
	</table>
</body>
</html>