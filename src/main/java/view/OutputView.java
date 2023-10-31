package view;

import domain.Car;

public class OutputView {
	public void printAwardSingleWinner(Car winner) {
		System.out.print(winner.getName());
	}

	public void printAwardTiedWinner(Car winner) {
		System.out.print(", " + winner.getName());
	}
}
