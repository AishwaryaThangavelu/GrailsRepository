
<%@ page import="aish.vaishno.dms.Place" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'place.label', default: 'Place')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-place" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="place.placeName.label" default="Place Name" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: placeInstance, field: "placeName")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
