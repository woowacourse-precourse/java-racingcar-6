package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class OutputView {
	public static void printResultHeader() {
		System.out.println("실행 결과");
	}

	public static void printTurnUserResult(List<Car> cars) {
		for (Car user : cars) {
			System.out.println(user.getName() + " : " + ("-").repeat(user.getDistance()));
		}
		System.out.println();
	}

	public static void printWinners(List<Car> winners) {
		String result = winners.stream().
			map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.println("최종 우승자 : " + result);
	}
}
