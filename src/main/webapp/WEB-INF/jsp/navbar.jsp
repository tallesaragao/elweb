<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
	    <!-- Navbar brand -->
	    <a class="navbar-brand" href="#">Projeto Eletiva Web</a>
	
	    <!-- Collapse button -->
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#app-nav" aria-controls="app-nav"
	        aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	
	    <!-- Collapsible content -->
	    <div class="collapse navbar-collapse" id="app-nav">
	
	        <!-- Links -->
	        <ul class="navbar-nav">
	            <li class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" id="dropdownPessoa" data-toggle="dropdown"
	                aria-haspopup="true" aria-expanded="false">
	                	<i class="fas fa-user"></i>
	                	Pessoa
	                </a>
	                <div class="dropdown-menu" aria-labelledby="dropdownPessoa">
	                    <a class="dropdown-item" href="#">
	                    	<i class="fa fa-list"></i>
	                    	Lista de pessoas
	                    </a>
	                    <a class="dropdown-item" href="#">
	                    	<i class="fa fa-plus"></i>
	                    	Nova pessoa
	                    </a>
	                </div>
	            </li>
	        </ul>
	        
	       
	        <!-- Links -->
	    </div>
	    <!-- Collapsible content -->
	</div>

</nav>