package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Group {

	String name;
	ArrayList<String> members;
	ArrayList<Vote> votes;
	private int yes;
	private int no;
	private int abstention;
	private int total;

	public Group(String name) {
		this.name = name;
		this.members = new ArrayList<String>();
		this.votes = new ArrayList<Vote>();
	}

	public void addMember(String country) {
		this.members.add(country);
	}

	public boolean isGroup(String string) {
		return this.name.compareTo(string) == 0;
	}

	public String toString() {
		String string = name + "\n Members: ";
		for (String country : members) {
			string += country + " ";
		}
		return string;
	}

	public boolean addVote(Vote vote) {
		boolean found = false;
		for (String member : members) {
			if (equalsIgnoreCaseAndSpaces(member, vote.country)){ //member.compareToIgnoreCase(vote.country) == 0) {
				this.votes.add(vote);
				found = true;
			}
		}
		return found;
	}

	public ArrayList<Vote> getVotes() {
		return votes;
	}

	public String getStats() {

		countVotes();
		double porcentageYes = (double) yes / (double) total;
		porcentageYes = porcentageYes * 100;
		DecimalFormat df = new DecimalFormat("#.00");
		return "%Yes: " + df.format(porcentageYes) + " Yes: " + yes + " No: "
				+ no + " Abs: " + abstention + " Total: " + total;
	}

	public String getCsv(){
		countVotes();
		//double porcentageYes = getPorcentage(yes);
		//DecimalFormat df = new DecimalFormat("#.00");
		String output = name +" ," + yes +"," + no + ","+ abstention+ " \n";
		return output;
	}

	public boolean equalsIgnoreCaseAndSpaces(String member, String country){
		String countryNoSpaces = country.replace(" ", "");
		String memberNoSpaces = member.replace(" ", "");
		return memberNoSpaces.equalsIgnoreCase(countryNoSpaces);
	}
	
	private double getPorcentage(int thing) {
		double porcentageThing = (double) thing / (double) total;
		porcentageThing = porcentageThing * 100;		
		return porcentageThing;
	}

	private void countVotes() {
		yes = 0;
		no = 0;
		abstention = 0;
		total = this.votes.size();
		for (Vote vote : this.votes) {
			if (vote.isYes()) {
				yes++;
			}
			if (vote.isNo()) {
				no++;
			}
			if (vote.isAbstention()) {
				abstention++;
			}
		}

	}
}
