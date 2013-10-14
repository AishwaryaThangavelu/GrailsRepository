
<%@ page import="aish.vaishno.dms.EducationalReport" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'educationalReport.label', default: 'EducationalReport')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-educationalReport" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.eduId.label" default="Edu Id" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "eduId")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.english.label" default="English" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "english")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.hindi.label" default="Hindi" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "hindi")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.maths.label" default="Maths" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "maths")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.science.label" default="Science" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "science")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="educationalReport.social.label" default="Social" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: educationalReportInstance, field: "social")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
