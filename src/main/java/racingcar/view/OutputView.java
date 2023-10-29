package racingcar.view;

import racingcar.model.RaceStatus;
import racingcar.model.RacingCar;
import racingcar.util.Constant;
import racingcar.util.Message;

import java.util.List;

public class OutputView {
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printInputCarNameMessage() {
		printMessage(Message.INPUT_CAR_NAME_MESSAGE);
	}

	public static void printInputRoundNumberMessage() {
		printMessage(Message.INPUT_ROUND_NUMBER_MESSAGE);
	}

	public static void printGameStartMessage() {
		printMessage(Message.GAME_START_MESSAGE);
	}

	public static void printWinnerMessage(String winner) {
		printMessage(Message.WINNER_MESSAGE + winner);
	}

	private static String printCarPosition(int position) {
		StringBuilder carPosition = new StringBuilder();
		for (int i = 0; i < position; i++) {
			carPosition.append(Constant.CAR_MOVE_SIGN);
		}
		return carPosition.toString();
	}

	public static void printRoundStatus(RaceStatus raceStatus) {
		List<RacingCar> cars = raceStatus.getCars();
		cars.forEach(car -> {
			printMessage(car.getName() + " : " + printCarPosition(car.getPosition()));
		});
	}

	public static void printWinner(RaceStatus raceStatus) {
		List<RacingCar> cars = raceStatus.getCars();
		String winners = cars.stream()
				.map(RacingCar::getName)
				.reduce((a, b) -> a + ", " + b)
				.get();

		printWinnerMessage(Message.WINNER_MESSAGE + winners);
	}
}
