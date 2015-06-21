<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<html>
	<body>
		${mensagem }
		<div id="formulario">
			<form action="AlunoServlet" method="post">
				<input type="hidden" name="_id" id="_id" value="${_id}"/>
				<label>Nome</label>
				<input type="text" name="nome" id="nome" value="${nome}"/>
				<label>Matricula</label>
				<input type="text" name="matricula" id="matricula" value="${matricula}" />
				<label>Periodo</label>
				<input type="text" name="periodo" id="periodo" value="${periodo}" />
				<label>Nota</label>
				<input type="text" name="nota" id="nota" value="${nota}" />
				<label>Falta</label>
				<input type="text" name="falta" id="falta" value="${falta}" />
				<input type="submit" id="buscar" value="Salvar" />
			</form>
		</div>
		
		<div id="lista">
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
		</div>

	</body>
</html>