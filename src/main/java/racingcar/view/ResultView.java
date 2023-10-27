package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class ResultView {

	private static final String FINAL_WINNER = "최종 우승자 : ";
	private static final String SCORE = "-";
	private static final String DIVISION = ", ";

	public void getResult(Race race) {
		List<Car> cars = race.getCars();
		StringBuilder result = new StringBuilder();

		for (Car car : cars) {
			result.append(car.getName())
				.append(" : ")
				.append(SCORE.repeat(Math.max(0, car.getPosition())))
				.append("\n");
		}

		System.out.println(result);
	}

	public void getFinalWinner(Race race) {
		StringBuilder result = new StringBuilder();
		result.append(FINAL_WINNER);

		List<String> winner = new ArrayList<>();
		List<Car> cars = race.getCars();
		for (Car car : cars) {
			if (race.getMaxRecord() == car.getPosition()) {
				winner.add(car.getName());
			}
		}

		result.append(String.join(DIVISION, winner));
		System.out.print(result);
	}
}