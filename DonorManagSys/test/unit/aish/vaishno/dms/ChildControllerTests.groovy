package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

/**
 * ChildControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(ChildController)
@Mock(Child)
class ChildControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/child/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.childInstanceList.size() == 0
        assert model.childInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.childInstance != null
    }

    void testSave() {
        controller.save()

        assert model.childInstance != null
        assert view == '/child/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/child/show/1'
        assert controller.flash.message != null
        assert Child.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/child/list'


        populateValidParams(params)
        def child = new Child(params)

        assert child.save() != null

        params.id = child.id

        def model = controller.show()

        assert model.childInstance == child
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/child/list'


        populateValidParams(params)
        def child = new Child(params)

        assert child.save() != null

        params.id = child.id

        def model = controller.edit()

        assert model.childInstance == child
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/child/list'

        response.reset()


        populateValidParams(params)
        def child = new Child(params)

        assert child.save() != null

        // test invalid parameters in update
        params.id = child.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/child/edit"
        assert model.childInstance != null

        child.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/child/show/$child.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        child.clearErrors()

        populateValidParams(params)
        params.id = child.id
        params.version = -1
        controller.update()

        assert view == "/child/edit"
        assert model.childInstance != null
        assert model.childInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/child/list'

        response.reset()

        populateValidParams(params)
        def child = new Child(params)

        assert child.save() != null
        assert Child.count() == 1

        params.id = child.id

        controller.delete()

        assert Child.count() == 0
        assert Child.get(child.id) == null
        assert response.redirectedUrl == '/child/list'
    }
}
