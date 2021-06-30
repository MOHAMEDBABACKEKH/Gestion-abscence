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
			<h3>Mise à jour d'une Matiere
		
		
		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/cadreadmin/updateMatiere/${idMatiere}"
			method="POST" modelAttribute="MatiereModel">
			<f:hidden path="module.idModule" />
			<f:hidden path="idMatiere" />
			

               <div class="row">
				<div class="col">
					<label>Titre de Matiere</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="titre de Matiere" value="${MatiereModel.nom}" />
					<f:errors path="nom" class="text-danger" />
				</div>

				<div class="col">
					<label>Code De Matiere</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="Code De Matiere" value="${MatiereModel.code}"/>
					<f:errors path="code" class="text-danger" />
				</div>
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">UPDATE</button>
					<button type="reset" class="btn btn-secondary">CANCEL</button>
				</div>




		</f:form>
	</div>



	<jsp:include page="../fragments/adminfooter.jsp" />