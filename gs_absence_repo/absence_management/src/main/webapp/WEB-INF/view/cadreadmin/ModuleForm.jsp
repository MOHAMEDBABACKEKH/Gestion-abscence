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
		<h3>Formulaire d'Ajout d'un Module
		
		</h3>
	</div>
	<div>


		<f:form action="${pageContext.request.contextPath}/cadreadmin/addModule/${idNiveau}" method="POST" modelAttribute="ModuleModel">

        	 
           <f:hidden path="niveau.idNiveau" />
			<div class="row">
			
				<div class="col">
					<label>Code De Module</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="module code" />
					<f:errors path="code" class="text-danger" />
				</div>
				 <div class="col">
				 
					<label>Titre de Module</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="titre de module" />
					<f:errors path="titre" class="text-danger" />
				</div> 
	
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	</div>
	
	
	
	
	
	<div>
		<h3>List of Matieres</h3>
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

			<c:forEach items="${ModuleList}" var="N">
				<tr>
					<td><c:out value="${N.titre}" /></td>
					<td><c:out value="${N.code}" /></td>					

					<td>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/deleteModule/${N.idModule}">DELETE</a></li>

							<li><a
								href="${pageContext.request.contextPath}/cadreadmin/updateModuleForm/${N.idModule}/${N.niveau.idNiveau}">UPDATE</a></li>
								
								<li><a
								href="${pageContext.request.contextPath}/cadreadmin/showModuleMatiere/${N.idModule}">+Matiere</a></li>


						</ul>
					</td>

				</tr>

			</c:forEach>

		</table>
	<jsp:include page="../fragments/adminfooter.jsp" />