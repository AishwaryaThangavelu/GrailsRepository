<%@ page import="aish.vaishno.dms.EducationalReport" %>



			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'eduId', 'error')} required">
				<label for="eduId" class="control-label"><g:message code="educationalReport.eduId.label" default="Edu Id" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="eduId" required="" value="${educationalReportInstance.eduId}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'eduId', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'english', 'error')} required">
				<label for="english" class="control-label"><g:message code="educationalReport.english.label" default="English" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="english" required="" value="${educationalReportInstance.english}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'english', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'hindi', 'error')} required">
				<label for="hindi" class="control-label"><g:message code="educationalReport.hindi.label" default="Hindi" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="hindi" required="" value="${educationalReportInstance.hindi}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'hindi', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'maths', 'error')} required">
				<label for="maths" class="control-label"><g:message code="educationalReport.maths.label" default="Maths" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="maths" required="" value="${educationalReportInstance.maths}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'maths', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'science', 'error')} required">
				<label for="science" class="control-label"><g:message code="educationalReport.science.label" default="Science" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="science" required="" value="${educationalReportInstance.science}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'science', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: educationalReportInstance, field: 'social', 'error')} required">
				<label for="social" class="control-label"><g:message code="educationalReport.social.label" default="Social" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="social" required="" value="${educationalReportInstance.social}"/>
					<span class="help-inline">${hasErrors(bean: educationalReportInstance, field: 'social', 'error')}</span>
				</div>
			</div>

