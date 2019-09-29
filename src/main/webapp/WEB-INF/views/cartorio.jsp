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
		<h1>Listar Cartórios</h1>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Cartório ID</th>
					<th scope="col">Nome</th>
					<th scope="col" colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartorios}"  var="cartorio" >
					<c:if test="${cartorio.ativo}">
						<tr id="cartorio-${cartorio.id}" >
							<th scope="row">${cartorio.id}</th>
							<td>${cartorio.nome}</td>
							<td colspan="2">
								<div class="row col-md-12">
									<div class="col col-md-6">
										<a href="./editarCartorio?id=${cartorio.id}">
											<button class="btn btn-success" type="button">Editar</button>
										</a>
									</div>
									<div class="col col-md-6">
										<a href="./inativar?id=${cartorio.id}">
											<button class="btn btn-danger" type="button">Inativar</button>
										</a>
									</div>
								</div>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<div class="row col-md-12">
			<a href="./" class="col col-xl-12" style="padding: 0px;">
				<button class="form-control btn btn-secondary btn-lg btn-block" type="button">Voltar para página inicial</button>
			</a>
		</div>
	</div>
</body>
</html>