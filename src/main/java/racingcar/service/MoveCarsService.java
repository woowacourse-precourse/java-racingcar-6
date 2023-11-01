package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.generator.NumberGenerator;

public class MoveCarsService {
	
	private static final NumberGenerator GENERATOR = new NumberGenerator();
	private static final int MOVE_CONDITION_NUMBER = 4;
	
	public void moveCars(Cars cars) {
		for(Car car : cars.getCars()) {
			int randomNumber = getRandomNumber();
			
			moveCar(car, randomNumber);
		}
	}
	
	public void moveCar(Car car, int number) {
		if(checkMoveCondition(number)) {
			car.move();
		}
	}
	
	private int getRandomNumber() {
		return GENERATOR.generate();
	}
	
	private boolean checkMoveCondition(int number) {
		return number >= MOVE_CONDITION_NUMBER;
	}
}
