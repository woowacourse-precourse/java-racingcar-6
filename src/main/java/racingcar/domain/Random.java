package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
	int randomNumber;
	
	public Random() {
		randomNumber = Randoms.pickNumberInRange(0, 9);
	}
	
	public int getRandomNumber() {
		return randomNumber;
	}
}