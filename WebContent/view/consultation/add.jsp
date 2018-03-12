<%@page import="com.cours.dao.MedcinDAO"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.cours.entities.Patient"%>
<%@page import="com.cours.dao.PatientDAO"%>
<%@page import="com.cours.entities.Medecin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
<div>
	<%
		if(request.getAttribute("ajout") != null)
			if(request.getAttribute("ajout") == "succes")
				out.print(" <script> alert('Donnees ajoutees avec succes'); </script> ");
			else
				out.print(" <script> alert('Donnees non ajoutees ') </script> ");
	%>
</div>
	<form method="post" action="ConsultationServ">
		<table>
			<tr>
				<td>Libelle</td>
				<td><input name="libelle" type="text" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input name="date" type="date" /></td>
			</tr>
			<tr>
				<td>Patient</td>
				<td>
					<select name="patient" id="">
						<option value="">--Choisir le patient--</option>
						<%
						
						List<Patient> liste =(List<Patient>) request.getAttribute("listeP");
						for(Patient p : liste)
						{
							out.print("<option value="+p.getIdp()+">"+p.getPrenomP()+" "+p.getNomP()+"</option>");	
						}
						
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>Medecin</td>
				<td>
					<select name="medecin" id="">
						<option value="">--Choisir le medecin--</option>
						<%
						
						List<Medecin> listem = (List<Medecin>)request.getAttribute("listeM");
						for(Medecin m : listem)
						{
							out.print("<option value="+m.getIdm()+">"+m.getPrenomM()+" "+m.getNomM()+"</option>");	
						}
						
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td><input name="env" type="submit" /></td>
				<td><input name="res" type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>