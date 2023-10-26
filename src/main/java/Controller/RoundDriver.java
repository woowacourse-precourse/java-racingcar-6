package Controller;

import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class RoundDriver {
	
	private final int smallest_range=0;
	private final int greatest_range=9;
	
	private final String nothing_yet="";
	
	private final int advance=1;
	private final int stop=0;

	public int advance_or_stop() {
		
		int advance_or_stop=stop;
		int random=Randoms.pickNumberInRange(smallest_range,greatest_range);;
		
		if(random>=4)
			advance_or_stop=advance;
		
		return advance_or_stop;
	}
	
	public Map<String, Integer> per_round(Map<String, Integer> records,String [] eachName) {
		
		for(int i=0;i<records.size();i++) {

			int score=records.get(eachName[i]);
			score+=advance_or_stop();
			
			records.put(eachName[i], score);
		}
		return records;
	}
	
	public void announcement(Map<String, Integer> records,String [] eachName) {
		
		for(String name:eachName) {
			
			int score=records.get(name);
			String hyphens=typeConverter(score);
			
			System.out.println(name+" : "+hyphens);
		}
		System.out.println();
	}
	
	public String typeConverter(int score) {
		
		String hyphens=nothing_yet;
		
		for(int i=0;i<score;i++)
			hyphens+="-";
		
		return hyphens;
	}
}
