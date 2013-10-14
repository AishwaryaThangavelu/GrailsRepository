
<%@ page import="aish.vaishno.dms.SportsReport" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'sportsReport.label', default: 'SportsReport')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-sportsReport" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
                                <g:sortableColumn property="sportsId" title="${message(code: 'sportsReport.sportsId.label', default: 'Sports Id')}" />
                          
                                <g:sortableColumn property="height" title="${message(code: 'sportsReport.height.label', default: 'Height')}" />
				
                                <g:sortableColumn property="weight" title="${message(code: 'sportsReport.weight.label', default: 'Weight')}" />
                                
                                <g:sortableColumn property="interestedGames" title="${message(code: 'sportsReport.interestedGames.label', default: 'Interested Games')}" />
                                
                                <g:sortableColumn property="excelledGames" title="${message(code: 'sportsReport.excelledGames.label', default: 'Excelled Games')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${sportsReportInstanceList}" status="i" var="sportsReportInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
                          
                                <td>${fieldValue(bean: sportsReportInstance, field: "sportsId")}</td>
                          
                                <td>${fieldValue(bean: sportsReportInstance, field: "height")}</td>
                                
                                <td>${fieldValue(bean: sportsReportInstance, field: "weight")}</td>
                                
      				<td>${fieldValue(bean: sportsReportInstance, field: "interestedGames")}</td>
                                
                                <td><g:link action="show" id="${sportsReportInstance.id}">${fieldValue(bean: sportsReportInstance, field: "excelledGames")}</g:link></td>
			
                	</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${sportsReportInstanceTotal}" />
	</div>
</section>

</body>

</html>
