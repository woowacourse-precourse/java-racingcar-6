package racingcar.utility;

import static racingcar.utility.constant.NumberConstant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
	public static int getRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
	}
}
