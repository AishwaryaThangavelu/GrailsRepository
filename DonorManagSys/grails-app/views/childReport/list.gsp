
<%@ page import="aish.vaishno.dms.ChildReport" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'childReport.label', default: 'ChildReport')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-childReport" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
                                <g:sortableColumn property="childReportId" title="${message(code: 'childReport.childReportId.label', default: 'Child Report Id')}" />
                          
				<g:sortableColumn property="year" title="${message(code: 'childReport.year.label', default: 'Year')}" />
                                
                                <th><g:message code="childReport.child.label" default="Child" /></th>
			
				<th><g:message code="childReport.donor.label" default="Donor" /></th>
			
				<th><g:message code="childReport.educationalReport.label" default="Educational Report" /></th>
			
				<th><g:message code="childReport.sportsReport.label" default="Sports Report" /></th>
			
							
			</tr>
		</thead>
		<tbody>
		<g:each in="${childReportInstanceList}" status="i" var="childReportInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
                                <td>${fieldValue(bean: childReportInstance, field: "childReportId")}</td>
                          
                                <td><g:formatDate date="${childReportInstance.year}" /></td>
                                
				<td><g:link action="show" id="${childReportInstance.id}">${fieldValue(bean: childReportInstance, field: "child")}</g:link></td>
			
				<td>${fieldValue(bean: childReportInstance, field: "donor")}</td>
			
				<td>${fieldValue(bean: childReportInstance, field: "educationalReport")}</td>
			
				<td>${fieldValue(bean: childReportInstance, field: "sportsReport")}</td>
			
				
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${childReportInstanceTotal}" />
	</div>
</section>

</body>

</html>
