package view;

import domain.Car;

public class OutputView {
	public void printRacingCarStatus(Car car) {
		System.out.println(car.getName() + " : " + car.createHyphenByLocation());
	}

	public void printAwardWinner(String awardWinnerMessage) {
		System.out.println(awardWinnerMessage);
	}
}
