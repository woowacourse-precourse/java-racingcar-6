package racingcar.controlller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingGameController {
    private boolean isRunning;

    public RacingGameController(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        while (isRunning) {
            startGame();
        }
    }

    public void startGame() {
        Cars cars = IOController.scanCarList();
        int numberOfRounds = IOController.scanNumberOfRounds();

        IOController.printResultHeaderMessage();

        for (int i = 0; i < numberOfRounds; i++) {
            doOneRound(cars);
            IOController.printlnCurrentForwardStateMessage(cars);
        }
        IOController.printWinnersMessage(pickWinners(cars));

        endGame();
    }

    private void doOneRound(Cars cars) {
        for (Car car : cars.getCarList()) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
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
