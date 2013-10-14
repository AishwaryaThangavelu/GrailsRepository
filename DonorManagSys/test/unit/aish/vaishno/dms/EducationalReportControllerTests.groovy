package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

/**
 * EducationalReportControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(EducationalReportController)
@Mock(EducationalReport)
class EducationalReportControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/educationalReport/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.educationalReportInstanceList.size() == 0
        assert model.educationalReportInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.educationalReportInstance != null
    }

    void testSave() {
        controller.save()

        assert model.educationalReportInstance != null
        assert view == '/educationalReport/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/educationalReport/show/1'
        assert controller.flash.message != null
        assert EducationalReport.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/educationalReport/list'


        populateValidParams(params)
        def educationalReport = new EducationalReport(params)

        assert educationalReport.save() != null

        params.id = educationalReport.id

        def model = controller.show()

        assert model.educationalReportInstance == educationalReport
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/educationalReport/list'


        populateValidParams(params)
        def educationalReport = new EducationalReport(params)

        assert educationalReport.save() != null

        params.id = educationalReport.id

        def model = controller.edit()

        assert model.educationalReportInstance == educationalReport
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/educationalReport/list'

        response.reset()


        populateValidParams(params)
        def educationalReport = new EducationalReport(params)

        assert educationalReport.save() != null

        // test invalid parameters in update
        params.id = educationalReport.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/educationalReport/edit"
        assert model.educationalReportInstance != null

        educationalReport.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/educationalReport/show/$educationalReport.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        educationalReport.clearErrors()

        populateValidParams(params)
        params.id = educationalReport.id
        params.version = -1
        controller.update()

        assert view == "/educationalReport/edit"
        assert model.educationalReportInstance != null
        assert model.educationalReportInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/educationalReport/list'

        response.reset()

        populateValidParams(params)
        def educationalReport = new EducationalReport(params)

        assert educationalReport.save() != null
        assert EducationalReport.count() == 1

        params.id = educationalReport.id

        controller.delete()

        assert EducationalReport.count() == 0
        assert EducationalReport.get(educationalReport.id) == null
        assert response.redirectedUrl == '/educationalReport/list'
    }
}
