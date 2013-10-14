
<%@ page import="aish.vaishno.dms.ChildReport" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'childReport.label', default: 'ChildReport')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-childReport" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.child.label" default="Child" /></td>
				
				<td valign="top" class="value"><g:link controller="child" action="show" id="${childReportInstance?.child?.id}">${childReportInstance?.child?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.childReportId.label" default="Child Report Id" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: childReportInstance, field: "childReportId")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.donor.label" default="Donor" /></td>
				
				<td valign="top" class="value"><g:link controller="donor" action="show" id="${childReportInstance?.donor?.id}">${childReportInstance?.donor?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.educationalReport.label" default="Educational Report" /></td>
				
				<td valign="top" class="value"><g:link controller="educationalReport" action="show" id="${childReportInstance?.educationalReport?.id}">${childReportInstance?.educationalReport?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.sportsReport.label" default="Sports Report" /></td>
				
				<td valign="top" class="value"><g:link controller="sportsReport" action="show" id="${childReportInstance?.sportsReport?.id}">${childReportInstance?.sportsReport?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="childReport.year.label" default="Year" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${childReportInstance?.year}" /></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
