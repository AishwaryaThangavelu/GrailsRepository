
<%@ page import="aish.vaishno.dms.Donor" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'donor.label', default: 'Donor')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-donor" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="donor.donorId.label" default="Donor Id" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: donorInstance, field: "donorId")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="donor.donorName.label" default="Donor Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: donorInstance, field: "donorName")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
