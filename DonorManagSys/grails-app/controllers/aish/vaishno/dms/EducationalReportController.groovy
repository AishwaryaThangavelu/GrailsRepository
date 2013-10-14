package aish.vaishno.dms

import org.springframework.dao.DataIntegrityViolationException

/**
 * EducationalReportController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class EducationalReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [educationalReportInstanceList: EducationalReport.list(params), educationalReportInstanceTotal: EducationalReport.count()]
    }

    def create() {
        [educationalReportInstance: new EducationalReport(params)]
    }

    def save() {
        def educationalReportInstance = new EducationalReport(params)
        if (!educationalReportInstance.save(flush: true)) {
            render(view: "create", model: [educationalReportInstance: educationalReportInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), educationalReportInstance.id])
        redirect(action: "show", id: educationalReportInstance.id)
    }

    def show() {
        def educationalReportInstance = EducationalReport.get(params.id)
        if (!educationalReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "list")
            return
        }

        [educationalReportInstance: educationalReportInstance]
    }

    def edit() {
        def educationalReportInstance = EducationalReport.get(params.id)
        if (!educationalReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "list")
            return
        }

        [educationalReportInstance: educationalReportInstance]
    }

    def update() {
        def educationalReportInstance = EducationalReport.get(params.id)
        if (!educationalReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (educationalReportInstance.version > version) {
                educationalReportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'educationalReport.label', default: 'EducationalReport')] as Object[],
                          "Another user has updated this EducationalReport while you were editing")
                render(view: "edit", model: [educationalReportInstance: educationalReportInstance])
                return
            }
        }

        educationalReportInstance.properties = params

        if (!educationalReportInstance.save(flush: true)) {
            render(view: "edit", model: [educationalReportInstance: educationalReportInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), educationalReportInstance.id])
        redirect(action: "show", id: educationalReportInstance.id)
    }

    def delete() {
        def educationalReportInstance = EducationalReport.get(params.id)
        if (!educationalReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "list")
            return
        }

        try {
            educationalReportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'educationalReport.label', default: 'EducationalReport'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
