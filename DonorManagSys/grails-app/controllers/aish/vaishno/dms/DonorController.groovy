package aish.vaishno.dms

import org.springframework.dao.DataIntegrityViolationException

/**
 * DonorController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class DonorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [donorInstanceList: Donor.list(params), donorInstanceTotal: Donor.count()]
    }

    def create() {
        [donorInstance: new Donor(params)]
    }

    def save() {
        def donorInstance = new Donor(params)
        if (!donorInstance.save(flush: true)) {
            render(view: "create", model: [donorInstance: donorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'donor.label', default: 'Donor'), donorInstance.id])
        redirect(action: "show", id: donorInstance.id)
    }

    def show() {
        def donorInstance = Donor.get(params.id)
        if (!donorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "list")
            return
        }

        [donorInstance: donorInstance]
    }

    def edit() {
        def donorInstance = Donor.get(params.id)
        if (!donorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "list")
            return
        }

        [donorInstance: donorInstance]
    }

    def update() {
        def donorInstance = Donor.get(params.id)
        if (!donorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (donorInstance.version > version) {
                donorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'donor.label', default: 'Donor')] as Object[],
                          "Another user has updated this Donor while you were editing")
                render(view: "edit", model: [donorInstance: donorInstance])
                return
            }
        }

        donorInstance.properties = params

        if (!donorInstance.save(flush: true)) {
            render(view: "edit", model: [donorInstance: donorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'donor.label', default: 'Donor'), donorInstance.id])
        redirect(action: "show", id: donorInstance.id)
    }

    def delete() {
        def donorInstance = Donor.get(params.id)
        if (!donorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            donorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'donor.label', default: 'Donor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
