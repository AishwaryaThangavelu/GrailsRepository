<%@ page import="aish.vaishno.dms.Donor" %>



			<div class="control-group fieldcontain ${hasErrors(bean: donorInstance, field: 'donorId', 'error')} required">
				<label for="donorId" class="control-label"><g:message code="donor.donorId.label" default="Donor Id" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="donorId" required="" value="${donorInstance.donorId}"/>
					<span class="help-inline">${hasErrors(bean: donorInstance, field: 'donorId', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: donorInstance, field: 'donorName', 'error')} ">
				<label for="donorName" class="control-label"><g:message code="donor.donorName.label" default="Donor Name" /></label>
				<div class="controls">
					<g:textField name="donorName" value="${donorInstance?.donorName}"/>
					<span class="help-inline">${hasErrors(bean: donorInstance, field: 'donorName', 'error')}</span>
				</div>
			</div>

