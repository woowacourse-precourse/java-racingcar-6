package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

final class NumberGenerator {
	static int createRandomNumber(int maxNumber) {
		if (maxNumber < 0) {
			throw new IllegalArgumentException("인수는 0 이상의 값이어야 합니다.");
		}
		return Randoms.pickNumberInRange(0, maxNumber);
	}
}
