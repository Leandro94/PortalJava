<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
	<body>
	<p>${alunos}</p>
		<table>
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Matricula</th>
				<th>Periodo</th>
				<th>Nota</th>
				<th>Falta</th>
			</tr>
			<c:forEach items="${alunos}" var="a">
			    <tr>      
			        <td>${a._id}</td>
			        <td>${a.nome}</td>
			        <td>${a.matricula}</td>
			        <td>${a.periodo}</td>
			        <td>${a.nota}</td>
			        <td>${a.falta}</td>  
			    </tr>
			</c:forEach>
		</table>
	</body>
</html>