<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page"
			href="${pageContext.request.contextPath}/cadreadmin/showHome">Home</a></li>

<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false">Filieres
				Management</a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/showAllFilieres">Add
						Filiere</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/ManageFilieres">Manage
						Filiere</a></li>
						
						<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/cadreadmin/showAll">Show
						All</a></li>
		
			</ul></li>


<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Niveau
				Management </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=2">Add
						Niveau</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=1">Manage
						Niveaux</a></li>
		
			</ul></li>


<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Matiere
				Management </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=2">Add
						Matiere</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=1">Manage
						Matieres</a></li>
		
			</ul></li>

<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Module
				Management </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=2">Add
						Module</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=1">Manage
						Modules</a></li>
		
			</ul></li>



		<li class="nav-item">

		<f:form action="${pageContext.request.contextPath}/logout" method="POST">
			
			<button type="submit" class="btn btn-link">logout</button>
			
			</f:form></li>
	</ul>
</div>