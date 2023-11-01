//Car.java
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int moveCount;
	Car(String name){
		this.name = name;
		this.moveCount = 0;
	}

	//랜덤한 숫자가 4 이상이면 moveCount를 1 증가시킨다
	public void move(){
		int randomNumber = makeRandomNumber();
		if(randomNumber >= Constants.MOVE_STANDARD){
			++this.moveCount;
		}
	}

	public boolean checkIsFaster(Car otherCar){
		return this.moveCount > otherCar.getMoveCount();
	}

	public boolean checkIsEqualSpeed(Car otherCar){
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
