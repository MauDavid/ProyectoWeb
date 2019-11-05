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
			out.write("<p>El Codigo es un dato obligatorio, debe usted llenarlo</p>");
		} 
		else if(codigo !=null && codigo ==-2 ){
			out.write("<p>El nombre es un dato obligatorio, debe usted llenarlo</p>");
		} 
		else if(codigo !=null && codigo==-3){
			out.write("<p>El primer apellido es un dato obligatorio, debe usted llenarlo</p>");
		}
		misesion.removeAttribute("codigo");
	%>
	<form method="get" action="CursoControl">
	    <p>
			Nombre:<input type="text" id="curso.nombre" name="curso.nombre">
		</p>
	    <p>
			Fecha de inicio:<input type="text" id="curso.fechainicio" name="curso.fechainicio">
		</p>
		<p>
			Fecha de fin:<input type="text" id="curso.Fechafin" name="curso.Fechafin">
		</p>
		
		<input type="submit" value="Registrar curso"> 
	</form>
</body>
</html>