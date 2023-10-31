package view;

import java.util.List;

import domain.Car;

public class OutputView {
	public void printRacingCarStatus(Car car) {
		System.out.println(car.getName() + " : " + car.createHyphenByLocation());
	}

	public void printAwardWinner(List<String> winnersName) {
		System.out.println(String.join(", ", winnersName));
	}
}
