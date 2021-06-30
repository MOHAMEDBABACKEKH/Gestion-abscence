<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/CadreAdminheader.jsp" />

<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<jsp:include page="../fragments/CadreAdminmenu.jsp" />

		</div>
	</nav>






	<div>
		<h3>List of Filieres</h3>
	</div>

	<div>



		</div>
		<p style="text-align:right"><a href="${pageContext.request.contextPath}/admin/exportPersons"><img
			src="${pageContext.request.contextPath}/resources/img/excel.png" width="30">Export Excel</p></a>
			
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Titre de Filiere</th>
					<th scope="col">Code</th>
					<th scope="col">annee accre</th>
					<th scope="col">Fin annee accre</th>
					<th>Actions</th>
				</tr>
			</thead>

			<c:forEach items="${FiliereList}" var="F">
				<tr>
					<td><c:out value="${F.titreFiliere}" /></td>
					<td><c:out value="${F.codeFiliere}" /></td>
					<td><c:out value="${F.anneeaccreditation}" /></td>
					<td><c:out value="${F.anneeFinaccreditation}" /></td>
					

					<td>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/deleteFiliere/${F.idFiliere}">DELETE</a></li>

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/updateFiliereForm/${F.idFiliere}">UPDATE</a></li>
								
							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/showFilieresNiveau/${F.idFiliere}">+Niveau</a></li>
								
							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/showAllCoordinateur">+Coordonnateur</a></li>
								


						</ul>
					</td>

				</tr>

			</c:forEach>

		</table>
	
	<jsp:include page="../fragments/adminfooter.jsp" />