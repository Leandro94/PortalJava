<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<html>
	<head><h1>Cadastro de Alunos:</h1> </head><br><br>
	<body>
		<input type="hidden" name="mensagem" id="mensagem">${mensagem }</input>
		<div id="formulario">
			<form action="AlunoServlet" method="post">
				<input type="hidden" name="_id" id="_id" value="${_id}"/>
				<label>Nome</label><br>
				<input type="text" name="nome" id="nome" value="${nome}"/><br>
				<label>Matricula</label><br>
				<input type="text" name="matricula" id="matricula" value="${matricula}" /><br>
				<label>Periodo</label><br>
				<input type="text" name="periodo" id="periodo" value="${periodo}" /><br>
				<label>Nota</label><br>
				<input type="text" name="nota" id="nota" value="${nota}" /><br>
				<label>Falta</label><br>
				<input type="text" name="falta" id="falta" value="${falta}" /><br><br>
				<input type="submit" id="buscar" value="Salvar" />
			</form>
		</div>
		
		<div id="lista">
			<table>
				<tr>
		
					<th>Nome</th>
				</tr>
				<c:forEach items="${alunos}" var="a">
				    <tr>      
	
				        <td>${a.nome}</td>
				   
				    </tr>
				</c:forEach>
			</table>
		</div>

	</body>
</html>