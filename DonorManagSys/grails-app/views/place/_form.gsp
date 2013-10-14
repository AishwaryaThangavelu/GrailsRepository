<%@ page import="aish.vaishno.dms.Place" %>



			<div class="control-group fieldcontain ${hasErrors(bean: placeInstance, field: 'placeName', 'error')} ">
				<label for="placeName" class="control-label"><g:message code="place.placeName.label" default="Place Name" /></label>
				<div class="controls">
					<g:textField name="placeName" value="${placeInstance?.placeName}"/>
					<span class="help-inline">${hasErrors(bean: placeInstance, field: 'placeName', 'error')}</span>
				</div>
			</div>

