package model;

public class VoteFilter {
	String yes = "Y ";
	String no = "N ";
	String abs = "A ";

	
	public Vote filterLine(String linea) {
		Vote vote = null;
		if(linea.substring(0, 2).compareTo(yes)==0){
			vote = new Vote(yes, linea.substring(2, linea.length()));
		}
		if(linea.substring(0, 2).compareTo(no)==0){
			vote = new Vote(no, linea.substring(2, linea.length()));
		}
		if(linea.substring(0, 2).compareTo(abs)==0){
			vote = new Vote(abs, linea.substring(2, linea.length()));
		}
		return vote ;
	}
}
