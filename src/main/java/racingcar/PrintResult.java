package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class PrintResult {
	public void viewRaceCar(int totalCar, List<Integer> racingRecord, List<String> carName) {
		int i = 0;
		while(i < totalCar) {
			System.out.print(carName.get(i) + " : ");
			for(int j = 0; j < racingRecord.get(i); j++) {
				System.out.print("-");
			}
			System.out.println();
			i++;
		}
	}
	
	public void racingWinner(List<Integer> carRecord, List<String> carName) {
		
		List<Integer> winnerList = new ArrayList<Integer>();
		int maxScore = maxScore(carRecord);
		List<String> winner = gameList(carRecord, carName, maxScore);
		
		System.out.print("최종 우승자 : "+String.join(", ", winner));
		return ;
	}
	
	public int maxScore(List<Integer> carRecord) {
		int maxScore = Collections.max(carRecord);
		return maxScore;
	}
	
	public List<String> gameList(List<Integer> carRecord, List<String> carName, int maxScore){
		List<String> winner = new ArrayList<String>();
		Map<String, Integer> racingList = new HashMap<String, Integer>();
		
		for(int i = 0; i < carName.size(); i++) {
			racingList.put(carName.get(i), carRecord.get(i));
		}
		
		winner = racingList.entrySet().stream()
				.filter(entry-> Objects.equals(entry.getValue(), maxScore))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		return winner;
	}
} //end of class
