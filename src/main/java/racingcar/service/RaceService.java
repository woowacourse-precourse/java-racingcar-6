package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarManager;
import racingcar.utils.Util;
import racingcar.view.Output;

public class RaceService {
    private final CarManager carManager;
    private final Output output;

    public RaceService(final CarManager carManager, final Output output) {
        this.carManager = carManager;
        this.output = output;
    }

    public void runRace(final int attemptNumber) {
        for (int nTimes = 0; nTimes < attemptNumber; nTimes++) {
            nthAttemptRace();
            printAttemptResult();
        }
    }

    public void nthAttemptRace() {
        for (final Car car : carManager.readCarList()) {
            int movingNumber = Util.generateRandomNumber();
            if (Util.isMove(movingNumber)) {
                car.moveForward();
            }
        }
    }

    public void printAttemptResult() {
        for (final Car car : carManager.readCarList()) {
            output.printMessage(car.status());
        }
    }

    public List<String> getWinners() {
        int maxMovingCount = 0;
        final List<String> winners = new ArrayList<>();

        for (final Car car : carManager.readCarList()) {
            int movingCount = car.getMovingCount();
            if (movingCount > maxMovingCount) {
                maxMovingCount = movingCount;
                winners.clear();
            }

            if (movingCount == maxMovingCount) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }
}