package aish.vaishno.dms

class Donor {

	Long donorId
	String donorName

	String toString() {"${donorName}"}
//	static belongsTo = [childReport : ChildReport]
	//static hasMany = [childReport:ChildReport]
	

    static constraints = {
    }
}
