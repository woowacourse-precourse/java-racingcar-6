package racingcar.global.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

	private static final int MIN_NUMBER_OF_RANGE = 0;
	private static final int MAX_NUMBER_OF_RANGE = 9;

	@Override
	public int generate() {
		return Randoms.pickNumberInRange(MIN_NUMBER_OF_RANGE, MAX_NUMBER_OF_RANGE);
	}
}
