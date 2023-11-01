package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import data.DTO;

import static data.Constants.SMALLINT;
import static data.Constants.STUB;

public class Winners {

	private Map<String, Integer> records;
	private String [] eachName;
	
	public Winners(DTO dto) {
		this.records=dto.getRecords();
		this.eachName=dto.getEachName();
	}

	public void getWinners() {

		List<String> winners=whoAreTheWinners();
		
		raise_a_toast(winners);
	}
	
	public int getHighestScore() {
		
		int highest_score=SMALLINT;
		
		for(String name:eachName)
			highest_score=Math.max(records.get(name), highest_score);
		
		return highest_score;
	}
	
	public List<String> whoAreTheWinners() {
		
		List<String> winners=new ArrayList<>();
		int highest_score=getHighestScore();
		
		for(String name:eachName) {
			if(records.get(name)==highest_score)
				winners.add(name);
		}
		return winners;
	}
	
	public void raise_a_toast(List<String> winners) {
		
		String print=typeConverter(winners);
		System.out.println("최종 우승자 : "+print);
	}
	
	public String typeConverter(List<String> winners) {
		
		String toast="";
		
		for(String winner:winners)
			toast+=winner+", ";
		
		toast=toast.substring(0, toast.length()-STUB);
		
		return toast;
	}
}
