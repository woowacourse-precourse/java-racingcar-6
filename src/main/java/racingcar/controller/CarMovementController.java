package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class CarMovementController {
	
	private final int STANDARD_FORWARD_NUMBER = 4;
	
	public Car[] forward(Car[] cars) {
		for(int i = 0;i<cars.length;i++) {
			int randNumber = generatedRandomNumberZerotoNine();
			if(checkPossibleMoveForward(randNumber))
				cars[i].forward();
		}
		return cars;
	}
	
	private boolean checkPossibleMoveForward(int number) {
		if(number>=STANDARD_FORWARD_NUMBER) {
			return true;
		}
		return false;
	}
	
	protected int generatedRandomNumberZerotoNine(){
		return Randoms.pickNumberInRange(0,9);
	}
	
}
