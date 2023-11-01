package racingcar;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import controller.RoundDriver;
import controller.Winners;
import data.DTO;

import static data.Constants.INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static data.Constants.INIT_SCORE;

public class Game {

	private String [] eachName;
	private int roundCount;
	private Map<String, Integer> records;
	
	private DTO dto;
	private RoundDriver rounding;
	
	public void runGame() {
		
		this.eachName=INPUT.provideNames();
		this.roundCount=INPUT.provideRoundCount();
		this.records=init_records(eachName);
		
		creatConstructors(roundCount,eachName,records);
		gameRepeater(dto);
		//winners.getWinners(records, eachName);
		new Winners(dto).getWinners();;
	}
	
	private void creatConstructors(int roundCount,String [] eachName,Map<String, Integer> records) {
		
		this.dto=new DTO(roundCount, records, eachName);
		this.rounding=new RoundDriver(dto);
		//this.winners=new Winners(dto);
	}
	
	private void gameRepeater(DTO dto) {
		
		for(int i=0;i<roundCount;i++) {
			records=rounding.per_round();
			rounding.announcement();
		}
		dto.setRecords(records);
		//return records;
	}
	
	public Map<String, Integer> init_records(String [] eachName) {
		
		Map<String, Integer> records=new HashMap<>();
		
		for(String name:eachName) {
			records.put(name, INIT_SCORE);
		}
		return records;
	}
}
