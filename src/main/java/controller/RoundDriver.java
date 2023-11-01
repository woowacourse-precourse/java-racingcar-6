package controller;

import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import data.DTO;

import static data.Constants.SMALLEST_RANGE;
import static data.Constants.GREATEST_RANGE;
import static data.Constants.ADVANCE;
import static data.Constants.STOP;
import static data.Constants.HYPHEN_NOTHING_YET;

public class RoundDriver {

	private Map<String, Integer> records;
	private String [] eachName;
	
	public RoundDriver(DTO dto) {
		this.records=dto.getRecords();
		this.eachName=dto.getEachName();
	}

	private int advance_or_stop() {
		
		int advance_or_stop=STOP;
		int random=Randoms.pickNumberInRange(SMALLEST_RANGE,GREATEST_RANGE);;
		
		if(random>=4)
			advance_or_stop=ADVANCE;
		
		return advance_or_stop;
	}
	
	public Map<String, Integer> per_round() {
		
		for(int i=0;i<records.size();i++) {

			int score=records.get(eachName[i]);
			score+=advance_or_stop();
			
			records.put(eachName[i], score);
		}
		return records;
	}
	
	public void announcement() {
		
		for(String name:eachName) {
			
			int score=records.get(name);
			String hyphens=typeConverter(score);
			
			System.out.println(name+" : "+hyphens);
		}
		System.out.println();
	}
	
	public String typeConverter(int score) {
		
		String hyphens=HYPHEN_NOTHING_YET;
		
		for(int i=0;i<score;i++)
			hyphens+="-";
		
		return hyphens;
	}
}
