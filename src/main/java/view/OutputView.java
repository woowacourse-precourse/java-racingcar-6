package view;

import domain.Car;
import domain.Winners;

public class OutputView {
	private static final String COLON = " : ";
	private static final String COMMA = ", ";

	public void printRacingCarStatus(Car car) {
		System.out.println(car.getName() + COLON + car.createHyphenByLocation());
	}

	public void printAwardWinner(Winners winners) {
		System.out.println(String.join(COMMA, winners.getCarNames()));
	}
}
