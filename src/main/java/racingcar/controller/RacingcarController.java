package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.GameCondition;
import racingcar.view.Player;
import racingcar.view.PrintMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {

	public void startGame() {
		PrintMessage.printStartMessage();
	
		Player player = new Player();
		player.promptCarNames();
		List<String> carNames = player.getCarNames();
	
		int numberOfMoves = GameCondition.getInstance().getNumberOfMoves();
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	
		PrintMessage.printGameResult(carNames, numberOfMoves);
	
		for (int i = 0; i < numberOfMoves; i++) {
			moveCarsForward(cars);
			PrintMessage.printGameResult(carNames, numberOfMoves);
		}
	
		List<String> winners = findWinners(cars);
		PrintMessage.printRacingWinner(winners);
	}
	
    private static void moveCarsForward(List<Car> cars) {
        for (Car car : cars) {
            if (GameCondition.getInstance().shouldCarMove()) {
                car.moveForward();
            }
        }
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
