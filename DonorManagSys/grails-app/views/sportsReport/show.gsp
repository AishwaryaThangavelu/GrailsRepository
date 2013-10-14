
<%@ page import="aish.vaishno.dms.SportsReport" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'sportsReport.label', default: 'SportsReport')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-sportsReport" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sportsReport.excelledGames.label" default="Excelled Games" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sportsReportInstance, field: "excelledGames")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sportsReport.height.label" default="Height" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sportsReportInstance, field: "height")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sportsReport.interestedGames.label" default="Interested Games" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sportsReportInstance, field: "interestedGames")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sportsReport.sportsId.label" default="Sports Id" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sportsReportInstance, field: "sportsId")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sportsReport.weight.label" default="Weight" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sportsReportInstance, field: "weight")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
