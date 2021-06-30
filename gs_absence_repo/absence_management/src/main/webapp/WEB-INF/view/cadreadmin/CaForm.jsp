<%@page import="com.ensah.core.web.models.PersonModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h3>Formulaire D'Ajout d'une Filiere
		
		</h3>
	</div>
	<div>


		<f:form action="addFiliere" method="POST" modelAttribute="FiliereModel">
            
			<div class="row">
				<div class="col">
					<label>Titre de Filiere</label>
					<f:input path="titreFiliere" type="text" class="form-control"
						placeholder="titre de filiere" />
					<f:errors path="titreFiliere" class="text-danger" />
				</div>

				<div class="col">
					<label>Code De Filiere</label>
					<f:input path="codeFiliere" type="text" class="form-control"
						placeholder="Code De Filiere" />
					<f:errors path="codeFiliere" class="text-danger" />
				</div>
				

			<div class="row">
				<div class="col">
					<label>Annee D'accreditation</label>
					<f:input path="anneeaccreditation" type="text" class="form-control"
						placeholder="anneeaccreditation" />
					<f:errors path="anneeaccreditation" class="text-danger" />
				</div>

				<div class="col">
					<label>Annee Fin D'accreditation</label>
					<f:input path="anneeFinaccreditation" type="text" class="form-control"
						placeholder="anneeFinaccreditation" />
					<f:errors path="anneeFinaccreditation" class="text-danger" />
				</div>
			</div>
	
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>
	
	
	
	
	
	<div>
		<h3>List of Filieres</h3>
	</div>

	<div>



		</div>
		<%-- <p style="text-align:right"><a href="${pageContext.request.contextPath}/admin/exportPersons"><img
			src="${pageContext.request.contextPath}/resources/img/excel.png" width="30">Export Excel</p></a> --%>
			
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


						</ul>
					</td>

				</tr>

			</c:forEach>

		</table>
	<jsp:include page="../fragments/adminfooter.jsp" />