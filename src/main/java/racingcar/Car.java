package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int forwardCount;
	Car(String name){
		this.name = name;
		this.forwardCount = 0;
	}

	public void goForwardOrNot(){
		int randomNumber = Randoms.pickNumberInRange(0,9);
		if(randomNumber >= 4){
			++this.forwardCount;
		}
	}

	public String getName(){
		return this.name;
	}

	public int getForwardCount(){
		return this.forwardCount;
	}
}
