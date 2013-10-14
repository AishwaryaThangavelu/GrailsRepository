package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

/**
 * DonorControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(DonorController)
@Mock(Donor)
class DonorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/donor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.donorInstanceList.size() == 0
        assert model.donorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.donorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.donorInstance != null
        assert view == '/donor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/donor/show/1'
        assert controller.flash.message != null
        assert Donor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/donor/list'


        populateValidParams(params)
        def donor = new Donor(params)

        assert donor.save() != null

        params.id = donor.id

        def model = controller.show()

        assert model.donorInstance == donor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/donor/list'


        populateValidParams(params)
        def donor = new Donor(params)

        assert donor.save() != null

        params.id = donor.id

        def model = controller.edit()

        assert model.donorInstance == donor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/donor/list'

        response.reset()


        populateValidParams(params)
        def donor = new Donor(params)

        assert donor.save() != null

        // test invalid parameters in update
        params.id = donor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/donor/edit"
        assert model.donorInstance != null

        donor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/donor/show/$donor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        donor.clearErrors()

        populateValidParams(params)
        params.id = donor.id
        params.version = -1
        controller.update()

        assert view == "/donor/edit"
        assert model.donorInstance != null
        assert model.donorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/donor/list'

        response.reset()

        populateValidParams(params)
        def donor = new Donor(params)

        assert donor.save() != null
        assert Donor.count() == 1

        params.id = donor.id

        controller.delete()

        assert Donor.count() == 0
        assert Donor.get(donor.id) == null
        assert response.redirectedUrl == '/donor/list'
    }
}
