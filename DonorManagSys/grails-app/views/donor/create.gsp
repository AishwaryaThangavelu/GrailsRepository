<%@ page import="aish.vaishno.dms.Donor" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'donor.label', default: 'Donor')}" />
	<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>

<body>

<section id="create-donor" class="first">

	<g:hasErrors bean="${donorInstance}">
	<div class="alert alert-error">
		<g:renderErrors bean="${donorInstance}" as="list" />
	</div>
	</g:hasErrors>
	
	<g:form action="save" class="form-horizontal" >
		<fieldset class="form">
			<g:render template="form"/>
		</fieldset>
		<div class="form-actions">
			<g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
            <button class="btn" type="reset"><g:message code="default.button.reset.label" default="Reset" /></button>
		</div>
	</g:form>
	
</section>
		
</body>

</html>
