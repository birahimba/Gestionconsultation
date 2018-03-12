<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="Access/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<title>Formulaire des patients</title>
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
			<%
				if(request.getAttribute("ajout") != null)
				{
					if(request.getAttribute("ajout") == "succes" )
						
						out.print("<br><div class='alert alert-warning alert-dismissible' role='alert'><button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>Donnees ajoutees avec succes </div>");
					else
						out.print("Donnees non ajoutees avec succes");
				}
			%>
		
		</br>
			<form method="post" action="PatientServ">
				<table>
					<tr>
						<td>Nom</td>
						<td><input type="text" name="nom" /> </td>
					</tr>
					<tr>
						<td>Prenom</td>
						<td><input type="text" name="prenom" > </td>
					</tr>
					<tr>
						<td><input type="submit" name="env" /></td>
						<td><input type="reset" name="res" /></td>
					</tr>
				</table>
			</form>
		</div>
			<script type="text/javascript" src="Access/bootstrap-3.3.6-dist/js/jquery-3.1.1.min.js"></script>
			<script type="text/javascript" src="Access/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
		</body>
</html>