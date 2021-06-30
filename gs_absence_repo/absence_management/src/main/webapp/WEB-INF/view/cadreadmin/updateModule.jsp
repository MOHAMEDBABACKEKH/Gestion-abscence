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
			<h3>Mise à jour d'un Module
		
		
		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/cadreadmin/updateModule/${idModule}"
			method="POST" modelAttribute="ModuleModel">
			<f:hidden path="niveau.idNiveau" />
			<f:hidden path="idModule" />
			

               <div class="row">
				<div class="col">
					<label>Titre de Module</label>
					<f:input path="titre" type="text" class="form-control"
						placeholder="titre de Module" value="${ModuleModel.titre}" />
					<f:errors path="titre" class="text-danger" />
				</div>

				<div class="col">
					<label>Code De Module</label>
					<f:input path="code" type="text" class="form-control"
						placeholder="Code De Module" value="${ModuleModel.code}" />
					<f:errors path="code" class="text-danger" />
				</div>
         			<div style="text-align: right">
					<button type="submit" class="btn btn-primary">UPDATE</button>
					<button type="reset" class="btn btn-secondary">CANCEL</button>
				</div>
				</div>




		</f:form>
	</div>



	<jsp:include page="../fragments/adminfooter.jsp" />