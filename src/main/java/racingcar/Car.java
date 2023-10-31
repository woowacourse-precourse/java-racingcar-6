package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Car {
	public List<StringBuilder> moveForward(List<StringBuilder> steps) {
		for (int i = 0; i < steps.size(); i++) {
			int randomNumber = Randoms.pickNumberInRange(0, 9);
			if (randomNumber >= 4) {
				steps.set(i, steps.get(i).append("-"));
			}
		}
		return steps;
	}
}
