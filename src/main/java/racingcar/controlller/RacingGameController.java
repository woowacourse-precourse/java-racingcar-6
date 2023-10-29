package racingcar.controlller;

import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Round;

public class RacingGameController {
    private boolean isRunning;
    private Cars cars;
    private Round round;

    public RacingGameController(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        while (isRunning) {
            startGame();
            endGame();
        }
    }

    public void startGame() {
        cars = InputController.scanCars();
        round = InputController.scanRound();

        playAllRounds();
    }

    private void playAllRounds() {
        OutputController.printResultHeaderMessage();
        while(!round.Over()) {
            playOneRound();
        }
        OutputController.printWinnersMessage(pickWinners());
    }

    private void playOneRound() {
        for (Car car : cars.getCarList()) {
            car.TryToMove();
        }
        OutputController.printForwardStateMessage(cars);
        round.plusOne();
    }

    private Cars pickWinners() {
        List<Car> winnerList = (cars.getCarList()).stream()
                .filter(car -> (car.getPosition() == Collections.max(cars.getPositionList())))
                .toList();
        return new Cars(winnerList);
    }

    private void endGame() {
        isRunning = false;
    }
}
