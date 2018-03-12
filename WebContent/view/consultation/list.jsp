<%@page import="com.cours.entities.Consultation"%>
<%@page import="java.util.List"%>
<%@page import="com.cours.dao.ConsultationDAO"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Libelle</th>
			<th>Date</th>
			<th>Patient</th>
			<th>Medecin</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<%
			
			List<Consultation> liste = (List<Consultation>)request.getAttribute("liste");
			for(int i = 0; i < liste.size() ; i++)
			{
				out.print("<tr>");
 					out.print("<td>"+liste.get(i).getIdc()+"</td>");
 					out.print("<td>"+liste.get(i).getLibC()+"</td>");
 					out.print("<td>"+liste.get(i).getDateC()+"</td>");
 					out.print("<td>"+liste.get(i).getIdP().getIdp()+"</td>");
 					out.print("<td>"+liste.get(i).getIdM().getIdm()+"</td>");
 					out.print("<td><a href='ConsultationServ?ids="+liste.get(i).getIdc()+"'>Supprimer</a></td>");
 					out.print("<td><a href='ConsultationServ?idm="+liste.get(i).getIdc()+"'>Modifier</a></td>");
 				out.print("</tr>"); 
			}
 			
		%>
	</table>
</body>
</html>