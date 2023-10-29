package racingcar.controlller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import racingcar.constant.RacingGameConstants;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.RandomGenerator;

public class RacingGameController {
    private boolean isRunning;

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
        Cars cars = InputController.scanCarList();
        int numberOfRounds = InputController.scanNumberOfRounds();

        playAllRounds(numberOfRounds, cars);
        OutputController.printWinnersMessage(pickWinners(cars));
    }

    private void playAllRounds(int numberOfRounds, Cars cars) {
        OutputController.printResultHeaderMessage();
        for (int i = 0; i < numberOfRounds; i++) {
            playOneRound(cars);
            OutputController.printForwardStateMessage(cars);
        }
    }

    private void playOneRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        int randomNumber = RandomGenerator
                .generateRandomIntInRange(RacingGameConstants.MOVE_ENERGY_MIN, RacingGameConstants.MOVE_ENERGY_MAX);
        if (randomNumber >= RacingGameConstants.ENERGY_THRESHOLD_TO_MOVE) {
            car.moveOneStep();
        }
    }

    private Cars pickWinners(Cars cars) {
        List<Car> winnerList = (cars.getCarList()).stream()
                .filter(car -> (car.getPosition() == Collections.max(cars.getPositionList())))
                .toList();
        return new Cars(winnerList);
    }

    private void endGame() {
        isRunning = false;
    }
}
