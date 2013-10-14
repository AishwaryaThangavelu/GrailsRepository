package aish.vaishno.dms

import org.springframework.dao.DataIntegrityViolationException

/**
 * ChildReportController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ChildReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [childReportInstanceList: ChildReport.list(params), childReportInstanceTotal: ChildReport.count()]
    }

    def create() {
        [childReportInstance: new ChildReport(params)]
    }

    def save() {
        def childReportInstance = new ChildReport(params)
        if (!childReportInstance.save(flush: true)) {
            render(view: "create", model: [childReportInstance: childReportInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'childReport.label', default: 'ChildReport'), childReportInstance.id])
        redirect(action: "show", id: childReportInstance.id)
    }

    def show() {
        def childReportInstance = ChildReport.get(params.id)
        if (!childReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "list")
            return
        }

        [childReportInstance: childReportInstance]
    }

    def edit() {
        def childReportInstance = ChildReport.get(params.id)
        if (!childReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "list")
            return
        }

        [childReportInstance: childReportInstance]
    }

    def update() {
        def childReportInstance = ChildReport.get(params.id)
        if (!childReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (childReportInstance.version > version) {
                childReportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'childReport.label', default: 'ChildReport')] as Object[],
                          "Another user has updated this ChildReport while you were editing")
                render(view: "edit", model: [childReportInstance: childReportInstance])
                return
            }
        }

        childReportInstance.properties = params

        if (!childReportInstance.save(flush: true)) {
            render(view: "edit", model: [childReportInstance: childReportInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'childReport.label', default: 'ChildReport'), childReportInstance.id])
        redirect(action: "show", id: childReportInstance.id)
    }

    def delete() {
        def childReportInstance = ChildReport.get(params.id)
        if (!childReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "list")
            return
        }

        try {
            childReportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'childReport.label', default: 'ChildReport'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
