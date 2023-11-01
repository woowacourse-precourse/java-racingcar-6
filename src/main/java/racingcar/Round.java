package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Round {

	public void result(final List<Car> carList) {
		final var sb = new StringBuilder();
		for (var car : carList) {
			final var number = Randoms.pickNumberInRange(0, 9);
			car.advance(number);
			sb.append(car).append("\n");
		}
		System.out.println(sb);
	}
}
