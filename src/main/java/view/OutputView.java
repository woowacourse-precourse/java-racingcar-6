package view;

import java.util.List;

import domain.Car;
import domain.Winners;

public class OutputView {
	public void printRacingCarStatus(Car car) {
		System.out.println(car.getName() + " : " + car.createHyphenByLocation());
	}

	public void printAwardWinner(Winners winners) {
		System.out.println(String.join(", ", winners.getCarNames()));
	}
}
