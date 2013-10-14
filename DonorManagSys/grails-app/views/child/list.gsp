
<%@ page import="aish.vaishno.dms.Child" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'child.label', default: 'Child')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-child" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="childId" title="${message(code: 'child.childId.label', default: 'Child Id')}" />
			
				<g:sortableColumn property="childName" title="${message(code: 'child.childName.label', default: 'Child Name')}" />
			
				<th><g:message code="child.place.label" default="Place" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${childInstanceList}" status="i" var="childInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${childInstance.id}">${fieldValue(bean: childInstance, field: "childId")}</g:link></td>
			
				<td>${fieldValue(bean: childInstance, field: "childName")}</td>
			
				<td>${fieldValue(bean: childInstance, field: "place")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${childInstanceTotal}" />
	</div>
</section>

</body>

</html>
