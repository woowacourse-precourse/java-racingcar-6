package racingcar.view;

import racingcar.constant.View;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class OutputView {
	public static void printResultMessage() {
		System.out.println(View.RESULT_MESSAGE);
	}

	public static void printResult(RacingCar racingCar) {
		racingCar.getRacingCar().forEach(
			car -> {
				printEach(car);
			});
		System.out.println();
	}

	private static void printEach(Car car) {
		System.out.println(String.format(View.EACH_RESULT, car.getName(), convertToBar(car.getCurrentPosition())));
	}

	private static String convertToBar(int position) {
		return View.BAR.repeat(position);
	}
}
