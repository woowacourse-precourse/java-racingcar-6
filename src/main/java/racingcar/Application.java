package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
	
    public static void main(String[] args) {
    	List<String> carNames = CarName.inputCarName();
    	int tryTimes = TryTimes.askTimes();
    	
    	CarRacing[] car = new CarRacing[carNames.size()]; //입력된 자동차 갯수 만큼 객체 생성
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
			racingResult.add(j, car[j].moveCount);
		}
				
		String result = FindWinner.lastResult(FindWinner.compareCount(racingResult));
		
		
		System.out.println("최종 우승자 : " + result);
		
		
    }
}
