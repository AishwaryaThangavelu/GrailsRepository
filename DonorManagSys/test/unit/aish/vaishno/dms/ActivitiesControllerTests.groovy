package aish.vaishno.dms



import org.junit.*
import grails.test.mixin.*

@TestFor(ActivitiesController)
@Mock(Activities)
class ActivitiesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/activities/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.activitiesInstanceList.size() == 0
        assert model.activitiesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.activitiesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.activitiesInstance != null
        assert view == '/activities/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/activities/show/1'
        assert controller.flash.message != null
        assert Activities.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/activities/list'

        populateValidParams(params)
        def activities = new Activities(params)

        assert activities.save() != null

        params.id = activities.id

        def model = controller.show()

        assert model.activitiesInstance == activities
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/activities/list'

        populateValidParams(params)
        def activities = new Activities(params)

        assert activities.save() != null

        params.id = activities.id

        def model = controller.edit()

        assert model.activitiesInstance == activities
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/activities/list'

        response.reset()

        populateValidParams(params)
        def activities = new Activities(params)

        assert activities.save() != null

        // test invalid parameters in update
        params.id = activities.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/activities/edit"
        assert model.activitiesInstance != null

        activities.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/activities/show/$activities.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        activities.clearErrors()

        populateValidParams(params)
        params.id = activities.id
        params.version = -1
        controller.update()

        assert view == "/activities/edit"
        assert model.activitiesInstance != null
        assert model.activitiesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/activities/list'

        response.reset()

        populateValidParams(params)
        def activities = new Activities(params)

        assert activities.save() != null
        assert Activities.count() == 1

        params.id = activities.id

        controller.delete()

        assert Activities.count() == 0
        assert Activities.get(activities.id) == null
        assert response.redirectedUrl == '/activities/list'
    }
}
