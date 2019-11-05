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
		else if(codigo !=null && codigo==-4){	
			out.write("<p>El segundo apellido es un dato obligatorio, debe usted llenarlo</p>");
		}
		misesion.removeAttribute("codigo");
	%>
	<form method="get" action="TutorControl">
	    <p>
			Codigo:<input type="text" id="tutor.codigo" name="tutor.codigo">
		</p>
	    <p>
			Nombre:<input type="text" id="tutor.nombre" name="tutor.nombre">
		</p>
		<p>
			Primer apellido:<input type="text" id="tutor.primerapellido"
				name="tutor.primerapellido">
		</p>
		<p>
			Segundo apellido:<input type="text" id="tutor.segundoapellido"
				name="tutor.segundoapellido">
		</p>
		<input type="submit" value="Registrar Tutor"> 
	</form>
</body>
</html>