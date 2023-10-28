package racingcar.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator implements Generator<Integer> {

	@Override
	public Integer generate() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
