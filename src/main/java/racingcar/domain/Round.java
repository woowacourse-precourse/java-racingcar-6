package racingcar.domain;

public class Round {
    private final Cars cars;
    private final NumberGenerator numberGenerator;
    private final ForwardChecker forwardChecker;

    public Round(final Cars cars, final NumberGenerator numberGenerator, final ForwardChecker forwardChecker) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
        this.forwardChecker = forwardChecker;
    }

    public void run() {
        for (Car car : cars.getCars()) {
            int number = numberGenerator.createRandomNumber();
            if (forwardChecker.checkIfForward(number)) {
                car.forward();
            }
        }
    }
}
