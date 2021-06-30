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
			<h3>Mise à jour d'un Niveau
		
		
		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/cadreadmin/updateNiveau/${idNiveau}"
			method="POST" modelAttribute="NiveauModel">
			<f:hidden path="idNiveau" />
            <f:hidden path="filiere.idFiliere" />

               <div class="row">
				 <div class="col">
					<label>Titre de Niveau</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="titre de Niveau" value="${NiveauModel.titre}" />
					<f:errors path="titre" class="text-danger" />
				</div> 

				<div class="col">
					<label>Code De Niveau</label>
					<f:input path="alias" type="text" class="form-control"
						placeholder="...." value="${NiveauModel.alias}"/>
					<f:errors path="alias" class="text-danger" />
				</div>
				
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Update</button>
					<button type="reset" class="btn btn-secondary">CANCEl</button>
				</div>



		</f:form>
	</div>



	<jsp:include page="../fragments/adminfooter.jsp" />