<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession misesion = request.getSession();
		Integer codigo = 0;
		codigo = (Integer) misesion.getAttribute("codigo");
		if (codigo != null && codigo == -1) {
			out.write("<p>El nombre es un dato obligatorio, debe usted llenarlo</p>");
		}
		misesion.removeAttribute("codigo");
	%>
	<form method="get" action="EliminarControl">
		<p>
			Codigo:<input type="text" id="tutor.codigo" name="tutor.codigo">
		</p>
		<input type="submit" value="Eliminar Tutor"> 
	</form>
</body>
</html>