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
			<h3>Mise à jour d'une Filiere
		
		
		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/cadreadmin/updateFiliere"
			method="POST" modelAttribute="FiliereModel">
			<f:hidden path="idFiliere" />

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
					<label>Anne D'accreditation</label>
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
					<button type="submit" class="btn btn-primary">UPDATE</button>
					<button type="reset" class="btn btn-secondary">CANCEL</button>
				</div>




		</f:form>
	</div>



	<jsp:include page="../fragments/adminfooter.jsp" />