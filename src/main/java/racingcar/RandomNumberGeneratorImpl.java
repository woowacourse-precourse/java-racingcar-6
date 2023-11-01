package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
	@Override
	public int generate(int min, int max) {
		return Randoms.pickNumberInRange(min, max);
	}
}
