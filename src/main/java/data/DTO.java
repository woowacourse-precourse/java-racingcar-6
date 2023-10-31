package data;

import java.util.Map;

public class DTO {

	private int roundCount;
	private Map<String, Integer> records;
	private String [] eachName;
	
	public int getRoundCount() {
		return roundCount;
	}
	public Map<String, Integer> getRecords() {
		return records;
	}
	public String[] getEachName() {
		return eachName;
	}
	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}
	public void setRecords(Map<String, Integer> records) {
		this.records = records;
	}
	public void setEachName(String[] eachName) {
		this.eachName = eachName;
	}
	public DTO(int roundCount,Map<String, Integer> records,String [] eachName) {
		this.roundCount=roundCount;
		this.records=records;
		this.eachName=eachName;
	}
}
