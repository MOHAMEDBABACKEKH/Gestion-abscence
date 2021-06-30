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
		<h3>Formulaire D'Ajout d'une Class
		
		</h3>
	</div>
	<div>


		<f:form action="${pageContext.request.contextPath}/cadreadmin/addNiveau/${idFiliere}" method="POST" modelAttribute="NiveauModel">

          
           <f:hidden path="filiere.idFiliere" />
			<div class="row">
				 <div class="col">
					<label>Titre de Niveau</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="titre de Niveau" />
					<f:errors path="titre" class="text-danger" />
				</div> 

				<div class="col">
					<label>Code De Niveau</label>
					<f:input path="alias" type="text" class="form-control"
						placeholder="...." />
					<f:errors path="alias" class="text-danger" />
				</div>
				
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>
	
	
	
	
	
	<div>
		<h3>List of Classes ${NiveauModel.filiere.titreFiliere}</h3>
	</div>

	<div>



		</div>
		<%-- <p style="text-align:right"><a href="${pageContext.request.contextPath}/admin/exportPersons"><img
			src="${pageContext.request.contextPath}/resources/img/excel.png" width="30">Export Excel</p></a> --%>
			
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Titre</th>
					<th scope="col">Code</th>
					<th>Actions</th>
				</tr>
			</thead>

			<c:forEach items="${NiveauList}" var="N">
				<tr>
					<td><c:out value="${N.titre}" /></td>
					<td><c:out value="${N.alias}" /></td>					

					<td>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/deleteNiveau/${N.idNiveau}">DELETE</a></li>

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/updateNiveauForm/${N.idNiveau}/${N.filiere.idFiliere}">UPDATE</a></li>
								
								<li><a
								href="${pageContext.request.contextPath}/cadreadmin/showNiveauModules/${N.idNiveau}">+Module</a></li>


						</ul>
					</td>

				</tr>

			</c:forEach>

		</table>
	<jsp:include page="../fragments/adminfooter.jsp" />