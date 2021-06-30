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
		<h3>List of Coordinateur</h3>
	</div>
	<div>
		<f:form action="${pageContext.request.contextPath}/cadreadmin/addCoordonateur/${idFiliere}/${idUtilisateur}"
			method="POST" modelAttribute="CoordinationModel">

         <f:hidden path="coordonateur.idUtilisateur" /> 
	     <f:hidden path="filiere.idFiliere" />
		

			<div class="row">

				<div class="col">
					<label>Please select the Enseignant</label>

					<f:select path="coordonateur" multiple="false" size="1"
						class="form-control">
						<f:options items="${EnseignantList}" itemValue="idUtilisateur"  itemLabel="nom" />
					</f:select>
				</div>
			</div>
			
			
			<div></div>
			<div class="row">

				<div class="col">
					<label>Please select the Filiere</label>

					<f:select path="filiere" multiple="false" size="1"
						class="form-control">
						<f:options items="${FiliereList}" itemValue="idFiliere" itemLabel="titreFiliere" />
					</f:select>


				</div>
			</div>

	

			<div style="text-align: right">
				<button type="submit" class="btn btn-primary">Create</button>
				<button type="reset" class="btn btn-secondary">Rest</button>
			</div>

		</f:form>
	</div>
	
	<jsp:include page="../fragments/adminfooter.jsp" />