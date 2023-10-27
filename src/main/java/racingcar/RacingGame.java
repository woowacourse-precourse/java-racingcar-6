package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	private final CarManger carManger = new CarManger();

	public void run() {
		String[] carNames = Console.readLine().split(",");
		carManger.managedCar(carNames);

		int repeat = Integer.parseInt(Console.readLine());
		racing(repeat);
		List<String> winners = carManger.findWinner();
		result(winners);
	}

	public void racing(int repeat) {
		for (int i = 0; i < repeat; i++) {
			carManger.moveCar();
			System.out.println();
		}
	}

	public void result(List<String> winnerName) {
		System.out.print("최종 우승자 : ");
		for (String s : winnerName) {
			System.out.print(s);
		}
	}
}
