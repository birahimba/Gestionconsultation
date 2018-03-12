<%@page import="java.util.ArrayList"%>
<%@page import="com.cours.entities.Medecin"%>
<%@page import="java.util.List"%>
<%@page import="com.cours.dao.MedcinDAO"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>

<body>
	<h1>Liste des medecins</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Action</th>
		</tr>
		<%
			ArrayList<Medecin> liste = (ArrayList<Medecin>)request.getAttribute("liste");
			for(int i = 0; i < liste.size() ; i++)
			{
				out.print("<tr>");
 					out.print("<td>"+liste.get(i).getIdm()+"</td>");
 					out.print("<td>"+liste.get(i).getNomM()+"</td>");
 					out.print("<td>"+liste.get(i).getPrenomM()+"</td>");
 					out.print("<td>"+liste.get(i).getTelM()+"</td>");
 					out.print("<td><a href=''>Supprimer</a></td>");
 					out.print("<td><a href=''>Modifier</a></td>");
 				out.print("</tr>"); 
			}
 			
		%>
	</table>
</body>
</html>