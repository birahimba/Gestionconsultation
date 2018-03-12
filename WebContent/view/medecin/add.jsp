<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Medecin</title>
</head>
<body>
	<h1>Formulaire medecin</h1>
<div>
	<%
		if(request.getAttribute("ajout") != null)
			if(request.getAttribute("ajout") == "succes")
				out.print(" <script> alert('Donnees ajoutees avec succes'); </script> ");
			else
				out.print(" <script> alert('Donnees non ajoutees ') </script> ");
	%>
</div>
	<form action="MedecinServ" method="post">
		<table>
			<tr>
				<td>Nom</td>
				<td><input name="nom" type="text"></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input name="prenom" type="text"></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><input name="telephone" type="text"></td>
			</tr>
			<tr>
				<td><input name="env" type="submit"></td>
				<td><input name="res" type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>