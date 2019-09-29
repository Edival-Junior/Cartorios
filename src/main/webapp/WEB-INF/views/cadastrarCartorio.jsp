<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Docket Cartórios</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${cartorio.id != null}">
				<h1>Editar Cartório</h1>
			</c:when>
			<c:otherwise>
				<h1>Criar Cartório</h1>
			</c:otherwise>
		</c:choose>
		
		<form action="${ cartorio.nome != null ? '/editar': '/salvar' }" method="post">
			<div class="form-group">
				<label >Nome</label>
				<input class="form-control" type="text" name="nome" placeholder="Insira o nome do cartório"
				value="${ cartorio.nome != null ? cartorio.nome : '' }" />
			</div>
			<input type="hidden" name="ativo" value="true">
			<input type="hidden" name="id" value="${cartorio.id}">
			<div class="row col-md-12">
				<div class="col col-md-6">
					<a href="./">
						<button class="form-control btn btn-secondary" type="button">Voltar</button>
					</a>
				</div>
				<div class="col col-md-6">
					<button class="form-control btn btn-secondary" type="submit">Salvar!</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>