package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
		private final List<String> winners = new ArrayList<>();
		
		public List<String> getWinners(){
			int maxPosition = 0;
			for (Car car : winners) {
				if (car.getPosition() > maxPosition) {
					maxPosition = car.getPosition();
					winners.clear();
				}
				
				if (car.getPosition() == maxPosition) {
					winners.add(car);
				}
			}
			return winners;
			
		}

}
