package aish.vaishno.dms

import org.springframework.dao.DataIntegrityViolationException

/**
 * SportsReportController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class SportsReportController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [sportsReportInstanceList: SportsReport.list(params), sportsReportInstanceTotal: SportsReport.count()]
    }

    def create() {
        [sportsReportInstance: new SportsReport(params)]
    }

    def save() {
        def sportsReportInstance = new SportsReport(params)
        if (!sportsReportInstance.save(flush: true)) {
            render(view: "create", model: [sportsReportInstance: sportsReportInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), sportsReportInstance.id])
        redirect(action: "show", id: sportsReportInstance.id)
    }

    def show() {
        def sportsReportInstance = SportsReport.get(params.id)
        if (!sportsReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "list")
            return
        }

        [sportsReportInstance: sportsReportInstance]
    }

    def edit() {
        def sportsReportInstance = SportsReport.get(params.id)
        if (!sportsReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "list")
            return
        }

        [sportsReportInstance: sportsReportInstance]
    }

    def update() {
        def sportsReportInstance = SportsReport.get(params.id)
        if (!sportsReportInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (sportsReportInstance.version > version) {
                sportsReportInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'sportsReport.label', default: 'SportsReport')] as Object[],
                          "Another user has updated this SportsReport while you were editing")
                render(view: "edit", model: [sportsReportInstance: sportsReportInstance])
                return
            }
        }

        sportsReportInstance.properties = params

        if (!sportsReportInstance.save(flush: true)) {
            render(view: "edit", model: [sportsReportInstance: sportsReportInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), sportsReportInstance.id])
        redirect(action: "show", id: sportsReportInstance.id)
    }

    def delete() {
        def sportsReportInstance = SportsReport.get(params.id)
        if (!sportsReportInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "list")
            return
        }

        try {
            sportsReportInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'sportsReport.label', default: 'SportsReport'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
