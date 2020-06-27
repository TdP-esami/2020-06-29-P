package it.polito.tdp.PremierLeague.model;

public class Action {
	Integer playerID;
	Integer matchID;
	Integer teamID;
	Integer starts;
	Integer goals;
	Integer timePlayed;
	Integer redCards;
	Integer yellowCards;
	Integer totalSuccessfulPassesAll;
	Integer totalUnsuccessfulPassesAll;
	Integer assists;
	Integer totalFoulsConceded;
	Integer offsides;
	
	public Action(Integer playerID, Integer matchID, Integer teamID, Integer starts, Integer goals, Integer timePlayed,
			Integer redCards, Integer yellowCards, Integer totalSuccessfulPassesAll, Integer totalUnsuccessfulPassesAll,
			Integer assists, Integer totalFoulsConceded, Integer offsides) {
		super();
		this.playerID = playerID;
		this.matchID = matchID;
		this.teamID = teamID;
		this.starts = starts;
		this.goals = goals;
		this.timePlayed = timePlayed;
		this.redCards = redCards;
		this.yellowCards = yellowCards;
		this.totalSuccessfulPassesAll = totalSuccessfulPassesAll;
		this.totalUnsuccessfulPassesAll = totalUnsuccessfulPassesAll;
		this.assists = assists;
		this.totalFoulsConceded = totalFoulsConceded;
		this.offsides = offsides;
	}
	
	
	public Integer getPlayerID() {
		return playerID;
	}
	public void setPlayerID(Integer playerID) {
		this.playerID = playerID;
	}
	public Integer getMatchID() {
		return matchID;
	}
	public void setMatchID(Integer matchID) {
		this.matchID = matchID;
	}
	public Integer getTeamID() {
		return teamID;
	}
	public void setTeamID(Integer teamID) {
		this.teamID = teamID;
	}
	public Integer getStarts() {
		return starts;
	}
	public void setStarts(Integer starts) {
		this.starts = starts;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	public Integer getTimePlayed() {
		return timePlayed;
	}
	public void setTimePlayed(Integer timePlayed) {
		this.timePlayed = timePlayed;
	}
	public Integer getRedCards() {
		return redCards;
	}
	public void setRedCards(Integer redCards) {
		this.redCards = redCards;
	}
	public Integer getYellowCards() {
		return yellowCards;
	}
	public void setYellowCards(Integer yellowCards) {
		this.yellowCards = yellowCards;
	}
	public Integer getTotalSuccessfulPassesAll() {
		return totalSuccessfulPassesAll;
	}
	public void setTotalSuccessfulPassesAll(Integer totalSuccessfulPassesAll) {
		this.totalSuccessfulPassesAll = totalSuccessfulPassesAll;
	}
	public Integer getTotalUnsuccessfulPassesAll() {
		return totalUnsuccessfulPassesAll;
	}
	public void setTotalUnsuccessfulPassesAll(Integer totalUnsuccessfulPassesAll) {
		this.totalUnsuccessfulPassesAll = totalUnsuccessfulPassesAll;
	}
	public Integer getAssists() {
		return assists;
	}
	public void setAssists(Integer assists) {
		this.assists = assists;
	}
	public Integer getTotalFoulsConceded() {
		return totalFoulsConceded;
	}
	public void setTotalFoulsConceded(Integer totalFoulsConceded) {
		this.totalFoulsConceded = totalFoulsConceded;
	}
	public Integer getOffsides() {
		return offsides;
	}
	public void setOffsides(Integer offsides) {
		this.offsides = offsides;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matchID == null) ? 0 : matchID.hashCode());
		result = prime * result + ((playerID == null) ? 0 : playerID.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (matchID == null) {
			if (other.matchID != null)
				return false;
		} else if (!matchID.equals(other.matchID))
			return false;
		if (playerID == null) {
			if (other.playerID != null)
				return false;
		} else if (!playerID.equals(other.playerID))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Action [playerID=" + playerID + ", matchID=" + matchID + ", starts=" + starts + ", goals=" + goals
				+ ", timePlayed=" + timePlayed + "]";
	}
	
	
}
