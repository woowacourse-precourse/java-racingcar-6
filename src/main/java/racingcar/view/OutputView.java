package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	private static final String RESULT_MESSAGE = "실행 결과";
	private static final String BAR = "-";
	private static final String EACH_RESULT = "%s : %s";

	public static void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printTryResult(List<Car> carList) {
		carList.forEach(
			car -> {
				printTryEachResult(car);
			});
		System.out.println();
	}

	private static void printTryEachResult(Car car) {
		System.out.println(String.format(EACH_RESULT, car.getName(), converToBar(car.getCurrentPosition())));
	}

	private static String converToBar(int position) {
		return BAR.repeat(position);
	}
}
