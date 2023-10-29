package racingcar.controlller;

import java.util.Collections;
import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.utils.RandomGenerator;

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
        cars = InputController.scanCarList();
        round = InputController.scanRound();

        playAllRounds();
        OutputController.printWinnersMessage(pickWinners());
    }

    private void playAllRounds() {
        OutputController.printResultHeaderMessage();
        while(!round.Over()) {
            playOneRound();
        }
    }

    private void playOneRound() {
        for (Car car : cars.getCarList()) {
            moveOrNot(car);
        }
        OutputController.printForwardStateMessage(cars);
        round.plusOne();
    }

    private void moveOrNot(Car car) {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);
        if (randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            car.moveOneStep();
        }
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
