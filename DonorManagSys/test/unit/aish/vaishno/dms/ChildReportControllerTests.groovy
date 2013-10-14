package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

/**
 * ChildReportControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(ChildReportController)
@Mock(ChildReport)
class ChildReportControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/childReport/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.childReportInstanceList.size() == 0
        assert model.childReportInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.childReportInstance != null
    }

    void testSave() {
        controller.save()

        assert model.childReportInstance != null
        assert view == '/childReport/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/childReport/show/1'
        assert controller.flash.message != null
        assert ChildReport.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/childReport/list'


        populateValidParams(params)
        def childReport = new ChildReport(params)

        assert childReport.save() != null

        params.id = childReport.id

        def model = controller.show()

        assert model.childReportInstance == childReport
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/childReport/list'


        populateValidParams(params)
        def childReport = new ChildReport(params)

        assert childReport.save() != null

        params.id = childReport.id

        def model = controller.edit()

        assert model.childReportInstance == childReport
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/childReport/list'

        response.reset()


        populateValidParams(params)
        def childReport = new ChildReport(params)

        assert childReport.save() != null

        // test invalid parameters in update
        params.id = childReport.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/childReport/edit"
        assert model.childReportInstance != null

        childReport.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/childReport/show/$childReport.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        childReport.clearErrors()

        populateValidParams(params)
        params.id = childReport.id
        params.version = -1
        controller.update()

        assert view == "/childReport/edit"
        assert model.childReportInstance != null
        assert model.childReportInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/childReport/list'

        response.reset()

        populateValidParams(params)
        def childReport = new ChildReport(params)

        assert childReport.save() != null
        assert ChildReport.count() == 1

        params.id = childReport.id

        controller.delete()

        assert ChildReport.count() == 0
        assert ChildReport.get(childReport.id) == null
        assert response.redirectedUrl == '/childReport/list'
    }
}
