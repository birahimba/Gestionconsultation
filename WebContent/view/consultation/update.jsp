<%@page import="com.cours.entities.Consultation"%>
<%@page import="com.cours.entities.Patient"%>
<%@page import="com.cours.entities.Medecin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modification</title>
</head>
<body>
<%
	Consultation cslt = (Consultation)request.getAttribute("consultation");
%>
	<form method="post" action="ConsultationServ">
		<table>
		<input name="idc" value=<% out.print(cslt.getIdc()); %> type="hidden" />
			<tr>
				<td>Libelle</td>
				<td><input value="<% out.print(cslt.getLibC()); %>" name="libelle" type="text" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input value="<% out.print(cslt.getDateC()); %>" name="date" type="date" /></td>
			</tr>
			<tr>
				<td>Patient</td>
				<td>
					<select name="patient" id="">
						
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
				<td><input name="modif" type="submit" /></td>
				<td><input name="res" type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>