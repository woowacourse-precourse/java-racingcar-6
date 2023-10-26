package racingcar;

import java.util.HashMap;
import java.util.Map;

import Controller.InputValues;
import Controller.RoundDriver;
import Controller.Winners;

public class Game {
	
	private final Controller.InputValues input=new InputValues();
	private final Controller.RoundDriver rounding=new RoundDriver();
	private final Controller.Winners winners=new Winners();
	
	private final int init_score=0;
	
	public void runGame() {
		
		String [] eachName=input.provideNames();
		int roundCount=input.provideRoundCount();
		
		Map<String, Integer> records=init_records(eachName);
		records=gameRepeater(roundCount, records, eachName);
		
		winners.getWinners(records, eachName);
	}
	
	public Map<String, Integer> gameRepeater(int roundCount,Map<String, Integer> records,String [] eachName) {
		
		for(int i=0;i<roundCount;i++) {
			records=rounding.per_round(records, eachName);
			rounding.announcement(records, eachName);
		}
		return records;
	}
	
	public Map<String, Integer> init_records(String [] eachName) {
		
		Map<String, Integer> records=new HashMap<>();
		
		for(String name:eachName) {
			records.put(name, init_score);
		}
		return records;
	}
}
