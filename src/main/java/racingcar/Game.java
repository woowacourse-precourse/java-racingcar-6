package racingcar;

import java.util.ArrayList;

public class Game {

	public static void play() {

		Input input = new Input();

		input.user();

		int count = input.getCount();
		ArrayList<Car> cars = input.getCars();

		for (int i = 0; i < count; i++) {
			GameHelper.raceGame(cars);
			GameHelper.printResult(cars);
		}
		GameHelper.printWinners(cars);
	}
}
