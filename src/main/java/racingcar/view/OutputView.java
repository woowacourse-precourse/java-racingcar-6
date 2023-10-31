package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.constant.View;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.domain.Winner;

public class OutputView {
	public static void printResultMessage() {
		System.out.println(View.RESULT_MESSAGE);
	}

	public static void printResult(RacingCar racingCar) {
		racingCar.getRacingCar().forEach(car -> printEach(car));
		System.out.println();
	}

	public static void printWinner(Winner winner) {
		System.out.println(String.format(View.WINNER_MESSAGE,convertToString(winner.getWinner())));
	}

	private static String convertToString(List<Car> winner) {
		return winner.stream()
			.map(Car::getName)
			.collect(Collectors.joining(View.COMBINDER));
	}

	private static void printEach(Car car) {
		System.out.println(String.format(View.EACH_RESULT, car.getName(), convertToBar(car.getPosition())));
	}

	private static String convertToBar(int position) {
		return View.BAR.repeat(position);
	}
}
