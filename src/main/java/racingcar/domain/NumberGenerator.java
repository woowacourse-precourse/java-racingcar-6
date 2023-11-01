package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
	private static final int MAX_RANGE_NUMBER = 9;
	private static final int MIN_RANGE_NUMBER = 0;

	public static void createRandomNumber(GameData data) {
		data.resetNumberList();
		for (int i = 0; i < data.getCarList().size(); i++) {
			int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
			data.getNumberList().add(randomNumber);
		}
	}
}
