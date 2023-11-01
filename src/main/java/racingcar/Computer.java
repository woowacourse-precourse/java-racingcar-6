package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

	public int RandomComputerNum() {
		return Randoms.pickNumberInRange(0, 9);
	}

}
