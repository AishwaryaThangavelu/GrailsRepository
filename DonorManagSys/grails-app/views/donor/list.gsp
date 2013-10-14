
<%@ page import="aish.vaishno.dms.Donor" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'donor.label', default: 'Donor')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-donor" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="donorId" title="${message(code: 'donor.donorId.label', default: 'Donor Id')}" />
			
				<g:sortableColumn property="donorName" title="${message(code: 'donor.donorName.label', default: 'Donor Name')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${donorInstanceList}" status="i" var="donorInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${donorInstance.id}">${fieldValue(bean: donorInstance, field: "donorId")}</g:link></td>
			
				<td>${fieldValue(bean: donorInstance, field: "donorName")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${donorInstanceTotal}" />
	</div>
</section>

</body>

</html>
