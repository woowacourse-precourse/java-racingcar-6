package racingcar;

import java.util.List;

public class Application {
	
    public static void main(String[] args) {
    	List<String> carNames = CarName.inputCarName();
    	int tryTimes = TryTimes.askTimes();
		
		System.out.println("실행 결과");
		CarRacing carRacing = new CarRacing();
		List<Integer> racingResult = carRacing.playRace(carNames, tryTimes);
				
		Winner lastResult = new Winner();
		String result = lastResult.compareCount(racingResult);		
		System.out.println("최종 우승자 : " + result);	
    }
}
