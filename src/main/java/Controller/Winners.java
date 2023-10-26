package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winners {
	
	private final int smallint=Integer.MIN_VALUE;
	private final int stub=2;

	public void getWinners(Map<String, Integer> records,String [] eachName) {

		List<String> winners=whoAreTheWinners(records, eachName);
		
		raise_a_toast(winners);
	}
	
	public int getHighestScore(Map<String, Integer> records,String [] eachName) {
		
		int highest_score=smallint;
		
		for(String name:eachName)
			highest_score=Math.max(records.get(name), highest_score);
		
		return highest_score;
	}
	
	public List<String> whoAreTheWinners(Map<String, Integer> records,String [] eachName) {
		
		List<String> winners=new ArrayList<>();
		int highest_score=getHighestScore(records, eachName);
		
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
		
		toast=toast.substring(0, toast.length()-stub);
		
		return toast;
	}
}
