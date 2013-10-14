<%@ page import="aish.vaishno.dms.SportsReport" %>


                       <div class="control-group fieldcontain ${hasErrors(bean: sportsReportInstance, field: 'sportsId', 'error')} required">
				<label for="sportsId" class="control-label"><g:message code="sportsReport.sportsId.label" default="Sports Id" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="sportsId" required="" value="${sportsReportInstance.sportsId}"/>
					<span class="help-inline">${hasErrors(bean: sportsReportInstance, field: 'sportsId', 'error')}</span>
				</div>
			</div>   

                        <div class="control-group fieldcontain ${hasErrors(bean: sportsReportInstance, field: 'height', 'error')} required">
				<label for="height" class="control-label"><g:message code="sportsReport.height.label" default="Height" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="height" step="any" required="" value="${sportsReportInstance.height}"/>
					<span class="help-inline">${hasErrors(bean: sportsReportInstance, field: 'height', 'error')}</span>
				</div>
			</div>


                        <div class="control-group fieldcontain ${hasErrors(bean: sportsReportInstance, field: 'weight', 'error')} required">
				<label for="weight" class="control-label"><g:message code="sportsReport.weight.label" default="Weight" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="weight" step="any" required="" value="${sportsReportInstance.weight}"/>
					<span class="help-inline">${hasErrors(bean: sportsReportInstance, field: 'weight', 'error')}</span>
				</div>
			</div>

                        <div class="control-group fieldcontain ${hasErrors(bean: sportsReportInstance, field: 'interestedGames', 'error')} ">
				<label for="interestedGames" class="control-label"><g:message code="sportsReport.interestedGames.label" default="Interested Games" /></label>
				<div class="controls">
					<g:textField name="interestedGames" value="${sportsReportInstance?.interestedGames}"/>
					<span class="help-inline">${hasErrors(bean: sportsReportInstance, field: 'interestedGames', 'error')}</span>
				</div>
			</div>


			<div class="control-group fieldcontain ${hasErrors(bean: sportsReportInstance, field: 'excelledGames', 'error')} ">
				<label for="excelledGames" class="control-label"><g:message code="sportsReport.excelledGames.label" default="Excelled Games" /></label>
				<div class="controls">
					<g:textField name="excelledGames" value="${sportsReportInstance?.excelledGames}"/>
					<span class="help-inline">${hasErrors(bean: sportsReportInstance, field: 'excelledGames', 'error')}</span>
				</div>
			</div>

			

			

			

			

