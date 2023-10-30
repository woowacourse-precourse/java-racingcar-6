package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
    	List<String> carNames = CarName.inputCarName();
    	int tryTimes = TryTimes.askTimes();
    	
    	CarRacing[] car = new CarRacing[carNames.size()];
    	
		for (int j = 0; j < carNames.size(); j++) {
        	car[j] = new CarRacing();
		} 	
		
		for (int i = 0; i < tryTimes ; i++) {
			for (int j = 0; j < carNames.size(); j++) {
				car[j].carMove(carNames.get(j));
			}
		}
    }
}
