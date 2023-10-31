//Car.java
package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int moveCount;
	Car(String name){
		this.name = name;
		this.moveCount = 0;
	}

	public void move(){
		int randomNumber = Randoms.pickNumberInRange(0,9);
		if(randomNumber >= 4){
			++this.moveCount;
		}
	}

	public String getName(){
		return this.name;
	}

	public int getMoveCount(){
		return this.moveCount;
	}

	public boolean checkIsFaster(Car otherCar){
		int otherCarMoveCount = otherCar.getMoveCount();

		if(this.moveCount > otherCarMoveCount){
			return true;
		}else{
			return false;
		}
	}

	public boolean checkIsSame(Car otherCar){
		int otherCarMoveCount = otherCar.getMoveCount();

		if(this.moveCount == otherCarMoveCount){
			return true;
		}else{
			return false;
		}
	}


	public List<String> getCarNames(List<Car> cars){
		List<String> carNames = new ArrayList<>();
		for(Car car : cars){
			carNames.add(car.getName());
		}
		return carNames;
	}
}
