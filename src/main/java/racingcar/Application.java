package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
	
    public static void main(String[] args) {
    	List<String> carNames = CarName.inputCarName();
    	int tryTimes = TryTimes.askTimes();
    	
    	CarRacing[] car = new CarRacing[carNames.size()];
    	
		for (int j = 0; j < carNames.size(); j++) {
        	car[j] = new CarRacing();
		}
		
		
		System.out.println("실행 결과");
		for (int i = 0; i < tryTimes ; i++) {
			for (int j = 0; j < carNames.size(); j++) {
				car[j].carMove(carNames.get(j));
			}
			System.out.println("");
		}
		
		List<Integer> racingResult = new ArrayList<>();
		for (int j = 0; j < carNames.size(); j++) {
			racingResult.add(j, car[j].resultCount);
		}
		System.out.println(racingResult);
		
		
		int winnerPoint = Collections.max(racingResult);
		System.out.println(winnerPoint);
		
		List<Integer> winnerIndexNumber = new ArrayList<>();
		for (int i = 0; i < racingResult.size(); i++) {
			if (racingResult.get(i).equals(winnerPoint)) {
				System.out.println("우승자 인덱스 넘버" + i);
				winnerIndexNumber.add(i);
			}
		}
		System.out.println(winnerIndexNumber);
		
		List<String> winnerList = new ArrayList<>();
		for(int i = 0; i < winnerIndexNumber.size(); i++) {
			winnerList.add(carNames.get(winnerIndexNumber.get(i)));
		}
		
		String result = String.join(",", winnerList);
		System.out.println("최종 우승자 : " + result);
		
		
    }
}
