package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.generator.NumberGenerator;

public class MoveCarsService {
	
	private static final NumberGenerator GENERATOR = new NumberGenerator();
	private static final int MOVE_CONDITION_NUMBER = 4;
	
	public void moveCars(Cars cars) {
		for(Car car : cars.getCars()) {
			int randomNumber = GENERATOR.generate();
			
			moveCar(car, randomNumber);
		}
	}
	
	private void moveCar(Car car, int number) {
		if(checkMoveCondition(number)) {
			car.move();
		}
	}
	
	private boolean checkMoveCondition(int number) {
		return number >= MOVE_CONDITION_NUMBER;
	}
}
