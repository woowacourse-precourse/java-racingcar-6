package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	private static final int MAX_RANGE_NUMBER = 9;
	private static final int MIN_RANGE_NUMBER = 0;
	
	public int createRandomNumber() {
		int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
		return randomNumber;
	}
}
