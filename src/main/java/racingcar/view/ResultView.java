package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class ResultView {

	private static final String FINAL_WINNER = "최종 우승자 : ";

	public void getResult(Race race) {
		List<Car> cars = race.getCars();
		StringBuilder result = new StringBuilder();

		for (Car car : cars) {
			result.append(car.getName())
				.append(" : ")
				.append("-".repeat(Math.max(0, car.getPosition())))
				.append("\n");
		}

		System.out.println(result);
	}
}