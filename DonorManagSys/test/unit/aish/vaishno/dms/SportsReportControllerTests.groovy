package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

/**
 * SportsReportControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(SportsReportController)
@Mock(SportsReport)
class SportsReportControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sportsReport/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sportsReportInstanceList.size() == 0
        assert model.sportsReportInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.sportsReportInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sportsReportInstance != null
        assert view == '/sportsReport/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sportsReport/show/1'
        assert controller.flash.message != null
        assert SportsReport.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sportsReport/list'


        populateValidParams(params)
        def sportsReport = new SportsReport(params)

        assert sportsReport.save() != null

        params.id = sportsReport.id

        def model = controller.show()

        assert model.sportsReportInstance == sportsReport
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sportsReport/list'


        populateValidParams(params)
        def sportsReport = new SportsReport(params)

        assert sportsReport.save() != null

        params.id = sportsReport.id

        def model = controller.edit()

        assert model.sportsReportInstance == sportsReport
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sportsReport/list'

        response.reset()


        populateValidParams(params)
        def sportsReport = new SportsReport(params)

        assert sportsReport.save() != null

        // test invalid parameters in update
        params.id = sportsReport.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sportsReport/edit"
        assert model.sportsReportInstance != null

        sportsReport.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sportsReport/show/$sportsReport.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sportsReport.clearErrors()

        populateValidParams(params)
        params.id = sportsReport.id
        params.version = -1
        controller.update()

        assert view == "/sportsReport/edit"
        assert model.sportsReportInstance != null
        assert model.sportsReportInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sportsReport/list'

        response.reset()

        populateValidParams(params)
        def sportsReport = new SportsReport(params)

        assert sportsReport.save() != null
        assert SportsReport.count() == 1

        params.id = sportsReport.id

        controller.delete()

        assert SportsReport.count() == 0
        assert SportsReport.get(sportsReport.id) == null
        assert response.redirectedUrl == '/sportsReport/list'
    }
}
