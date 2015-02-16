package model;

public class Vote {

	String country;
	String vote;

	public Vote(String vote, String country) {
		this.vote = vote;
		
		this.country = country.replace(",", "");
	}

	public String toString() {
		return vote + country;
	}

	public String getCountry() {
		return country;
	}

	public String getVote() {
		return vote;
	}

	public boolean isYes() {
		return this.vote.compareTo("Y ") ==0;
	}
	public boolean isNo() {
		return this.vote.compareTo("N ") ==0;
	}
	public boolean isAbstention() {
		return this.vote.compareTo("A ") ==0;
	}
}
