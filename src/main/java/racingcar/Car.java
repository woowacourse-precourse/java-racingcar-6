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
		int randomNumber = makeRandomNumber();
		if(randomNumber >= 4){
			++this.moveCount;
		}
	}

	public boolean checkIsFaster(Car otherCar){
		return this.moveCount > otherCar.getMoveCount();
	}

	public boolean checkIsSame(Car otherCar){
		return this.moveCount == otherCar.getMoveCount();
	}

	protected int makeRandomNumber(){
		return Randoms.pickNumberInRange(0,9);
	}

	public String getName(){
		return this.name;
	}

	public int getMoveCount(){
		return this.moveCount;
	}

}
