package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Rule;

public class RandomNumberFactory {
	public static int createRandomNumber() {
		return Randoms.pickNumberInRange(Rule.START_NUMBER, Rule.END_NUMBER);
	}
}
