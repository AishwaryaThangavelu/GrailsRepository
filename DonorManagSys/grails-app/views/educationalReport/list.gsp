
<%@ page import="aish.vaishno.dms.EducationalReport" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'educationalReport.label', default: 'EducationalReport')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-educationalReport" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="eduId" title="${message(code: 'educationalReport.eduId.label', default: 'Edu Id')}" />
			
				<g:sortableColumn property="english" title="${message(code: 'educationalReport.english.label', default: 'English')}" />
			
				<g:sortableColumn property="hindi" title="${message(code: 'educationalReport.hindi.label', default: 'Hindi')}" />
			
				<g:sortableColumn property="maths" title="${message(code: 'educationalReport.maths.label', default: 'Maths')}" />
			
				<g:sortableColumn property="science" title="${message(code: 'educationalReport.science.label', default: 'Science')}" />
			
				<g:sortableColumn property="social" title="${message(code: 'educationalReport.social.label', default: 'Social')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${educationalReportInstanceList}" status="i" var="educationalReportInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${educationalReportInstance.id}">${fieldValue(bean: educationalReportInstance, field: "eduId")}</g:link></td>
			
				<td>${fieldValue(bean: educationalReportInstance, field: "english")}</td>
			
				<td>${fieldValue(bean: educationalReportInstance, field: "hindi")}</td>
			
				<td>${fieldValue(bean: educationalReportInstance, field: "maths")}</td>
			
				<td>${fieldValue(bean: educationalReportInstance, field: "science")}</td>
			
				<td>${fieldValue(bean: educationalReportInstance, field: "social")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${educationalReportInstanceTotal}" />
	</div>
</section>

</body>

</html>
