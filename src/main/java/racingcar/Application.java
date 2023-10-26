package racingcar;


import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String cars = Console.readLine();
		List<String> carsList = splitComma(cars);
		checkLength(carsList);
		System.out.println(carsList);
	}

	private static List<String> splitComma(String cars) {

		String[] carsArr = cars.split(",");
		List<String> carsList = Arrays.asList(carsArr);

		return carsList;
	}

	private static void checkLength(List<String> carsList) {

		for (String cars : carsList) {
			if (cars.length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}

	}
}
