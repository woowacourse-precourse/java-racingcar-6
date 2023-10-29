package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 9;
	public int generate() {
		return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
	}
}


