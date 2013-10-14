package aish.vaishno.dms

class EducationalReport {

	Long eduId
	Long english
	Long maths
	Long hindi
	Long science
	Long social
    
        String toString() {"${eduId}"}
    
	static constraints = {
    }
}
