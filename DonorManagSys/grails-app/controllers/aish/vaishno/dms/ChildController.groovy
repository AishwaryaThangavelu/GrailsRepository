package aish.vaishno.dms

import org.springframework.dao.DataIntegrityViolationException

/**
 * ChildController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ChildController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [childInstanceList: Child.list(params), childInstanceTotal: Child.count()]
    }

    def create() {
        [childInstance: new Child(params)]
    }

    def save() {
        def childInstance = new Child(params)
        if (!childInstance.save(flush: true)) {
            render(view: "create", model: [childInstance: childInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'child.label', default: 'Child'), childInstance.id])
        redirect(action: "show", id: childInstance.id)
    }

    def show() {
        def childInstance = Child.get(params.id)
        if (!childInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "list")
            return
        }

        [childInstance: childInstance]
    }

    def edit() {
        def childInstance = Child.get(params.id)
        if (!childInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "list")
            return
        }

        [childInstance: childInstance]
    }

    def update() {
        def childInstance = Child.get(params.id)
        if (!childInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (childInstance.version > version) {
                childInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'child.label', default: 'Child')] as Object[],
                          "Another user has updated this Child while you were editing")
                render(view: "edit", model: [childInstance: childInstance])
                return
            }
        }

        childInstance.properties = params

        if (!childInstance.save(flush: true)) {
            render(view: "edit", model: [childInstance: childInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'child.label', default: 'Child'), childInstance.id])
        redirect(action: "show", id: childInstance.id)
    }

    def delete() {
        def childInstance = Child.get(params.id)
        if (!childInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "list")
            return
        }

        try {
            childInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'child.label', default: 'Child'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
