<%@ page import="aish.vaishno.dms.ChildReport" %>


                        <div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'childReportId', 'error')} required">
				<label for="childReportId" class="control-label"><g:message code="childReport.childReportId.label" default="Child Report Id" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="childReportId" required="" value="${childReportInstance.childReportId}"/>
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'childReportId', 'error')}</span>
				</div>
			</div>

                        <div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'year', 'error')} required">
				<label for="year" class="control-label"><g:message code="childReport.year.label" default="Year" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="year" precision="day"  value="${childReportInstance?.year}"  />
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'year', 'error')}</span>
				</div>
			</div>


			<div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'child', 'error')} required">
				<label for="child" class="control-label"><g:message code="childReport.child.label" default="Child" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="child" name="child.id" from="${aish.vaishno.dms.Child.list()}" optionKey="id" required="" value="${childReportInstance?.child?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'child', 'error')}</span>
				</div>
			</div>
          
                        <div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'donor', 'error')} required">
				<label for="donor" class="control-label"><g:message code="childReport.donor.label" default="Donor" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="donor" name="donor.id" from="${aish.vaishno.dms.Donor.list()}" optionKey="id" required="" value="${childReportInstance?.donor?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'donor', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'educationalReport', 'error')} required">
				<label for="educationalReport" class="control-label"><g:message code="childReport.educationalReport.label" default="Educational Report" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="educationalReport" name="educationalReport.id" from="${aish.vaishno.dms.EducationalReport.list()}" optionKey="id" required="" value="${childReportInstance?.educationalReport?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'educationalReport', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: childReportInstance, field: 'sportsReport', 'error')} required">
				<label for="sportsReport" class="control-label"><g:message code="childReport.sportsReport.label" default="Sports Report" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="sportsReport" name="sportsReport.id" from="${aish.vaishno.dms.SportsReport.list()}" optionKey="id" required="" value="${childReportInstance?.sportsReport?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: childReportInstance, field: 'sportsReport', 'error')}</span>
				</div>
			</div>

			
