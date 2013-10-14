<%@ page import="aish.vaishno.dms.Child" %>



			<div class="control-group fieldcontain ${hasErrors(bean: childInstance, field: 'childId', 'error')} required">
				<label for="childId" class="control-label"><g:message code="child.childId.label" default="Child Id" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="childId" required="" value="${childInstance.childId}"/>
					<span class="help-inline">${hasErrors(bean: childInstance, field: 'childId', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: childInstance, field: 'childName', 'error')} ">
				<label for="childName" class="control-label"><g:message code="child.childName.label" default="Child Name" /></label>
				<div class="controls">
					<g:textField name="childName" value="${childInstance?.childName}"/>
					<span class="help-inline">${hasErrors(bean: childInstance, field: 'childName', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: childInstance, field: 'place', 'error')} required">
				<label for="place" class="control-label"><g:message code="child.place.label" default="Place" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="place" name="place.id" from="${aish.vaishno.dms.Place.list()}" optionKey="id" required="" value="${childInstance?.place?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: childInstance, field: 'place', 'error')}</span>
				  
                                        <g:autoCompletePrimary id="primarySearch1" 	
                                                               name="id"
                                                              domain='aish.vaishno.dms.Place'
                                                              searchField='placeName'
                                                              collectField='id'
                                                              setId="secondarySearch2"
                                                              hidden='hidden3'
                                                              value=''/>  
                                
                                
                                </div>
			</div>

