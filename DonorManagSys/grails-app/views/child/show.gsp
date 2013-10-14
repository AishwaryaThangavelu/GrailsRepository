
<%@ page import="aish.vaishno.dms.Child" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'child.label', default: 'Child')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-child" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="child.childId.label" default="Child Id" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: childInstance, field: "childId")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="child.childName.label" default="Child Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: childInstance, field: "childName")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="child.place.label" default="Place" /></td>
				
				<td valign="top" class="value"><g:link controller="place" action="show" id="${childInstance?.place?.id}">${childInstance?.place?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
