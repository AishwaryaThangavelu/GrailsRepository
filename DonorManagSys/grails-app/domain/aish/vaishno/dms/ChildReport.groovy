package aish.vaishno.dms

class ChildReport {

	Long childReportId
	Date year
	Donor donor
	Child child
	EducationalReport educationalReport
	SportsReport sportsReport
	 
    static constraints = {
    }
}
