package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public int generateNumber() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
