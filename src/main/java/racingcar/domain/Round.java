package racingcar.domain;

import java.util.List;

public class Round {
    private final RacingCars racingCars;
    private final NumberGenerator numberGenerator;
    private final ForwardChecker forwardChecker;

    public Round(final RacingCars racingCars, final NumberGenerator numberGenerator, final ForwardChecker forwardChecker) {
        this.racingCars = racingCars;
        this.numberGenerator = numberGenerator;
        this.forwardChecker = forwardChecker;
    }

    public void run() {
        for (RacingCar racingCar: racingCars.getRacingCars()) {
            int number = numberGenerator.createRandomNumber();
            if (forwardChecker.checkIfForward(number)) {
                racingCar.forward();
            }
        }
    }
}
