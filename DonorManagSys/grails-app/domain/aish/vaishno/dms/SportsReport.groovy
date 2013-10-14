package aish.vaishno.dms

class SportsReport {

	Long sportsId
	BigDecimal height
	BigDecimal weight
	String interestedGames
	String excelledGames

        String toString() {"${sportsId}"}
    static constraints = {
    }
}
