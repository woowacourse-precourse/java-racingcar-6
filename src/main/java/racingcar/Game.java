package racingcar;

import java.util.ArrayList;

public class Game {

	public static void playGame() {
		
		Input input = new Input();
		
		input.getUserInput();
		
		int count = input.getCount();
		ArrayList<Car> cars = input.getCars();
		
	    for (int i = 0; i < count; i++) {
	        raceGame(cars);
	        printResult(cars);
	    }
	    printWinners(cars);
	}
}
