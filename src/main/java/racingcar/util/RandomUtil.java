package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
public class RandomUtil {

	public static int getRandomNumber() {
		return Randoms.pickNumberInRange(0,9);
	}
}