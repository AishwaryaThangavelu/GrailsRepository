package aish.vaishno.dms

class Child {

	Long childId
	String childName
	Place place
	
        static hasMany=[place:Place]

	String toString() {"${childName}"}
//	static hasMany=[childReport:ChildReport]
	

    static constraints = {
    }
}
