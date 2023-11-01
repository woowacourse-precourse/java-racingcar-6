package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Result {
		private final List<Car> winners = new ArrayList<>();
		
		public List<Car> getWinner(){
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
