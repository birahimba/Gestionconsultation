<%@page import="com.cours.dao.PatientDAO"%>
<%@page import="com.cours.entities.Patient"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="Access/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<title>Liste des patients</title>
</head>
<body>

	<div class="container-fluid">
	<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/GestionConsultationTrainingM">Project name</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="RootServ?page=p">Gestion des patients</a></li>
				<li><a href="RootServ?page=m">Gestion des medecins</a></li>
				<li><a href="RootServ?page=c">Gestion des consultations</a></li>
              
            </ul>
            
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
		<h1>Liste des Patients</h1>
		<table class="table table-hover" border=1>
			<tr>
				<th>Numero</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
			<%
				List<Patient> liste = (ArrayList<Patient>) request.getAttribute("liste");
				for(int i = 0; i < liste.size() ; i++)
				{
					out.print("<tr>");
	 					out.print("<td>"+liste.get(i).getIdp()+"</td>");
	 					out.print("<td>"+liste.get(i).getNomP()+"</td>");
	 					out.print("<td>"+liste.get(i).getPrenomP()+"</td>");
	 					out.print("<td><a href='PatientServ?ids="+liste.get(i).getIdp()+"'>Supprimer</a></td>");
	 					out.print("<td><a href='PatientServ?idm="+liste.get(i).getIdp()+"'>Modifier</a></td>");
	 				out.print("</tr>"); 
				}
	 			
			%>
		</table>
		<script src="Access/bootstrap-3.3.6-dist/js/"></script>
				<script type="text/javascript" src="Access/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
	</div>
</body>
</html>