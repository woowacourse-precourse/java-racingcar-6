package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public Integer RandomComputerNum() {
		int RandomNumber = Randoms.pickNumberInRange(0, 9);

		return RandomNumber;
	}

}
