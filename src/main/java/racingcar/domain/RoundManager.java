package racingcar.domain;

public class RoundManager {
    private final Cars cars;
    private final RoundCount roundCount;
    private final NumberGenerator numberGenerator;
    private final ForwardChecker forwardChecker;

    public RoundManager(final Cars cars, final RoundCount roundCount, final NumberGenerator numberGenerator, final ForwardChecker forwardChecker) {
        this.cars = cars;
        this.roundCount = roundCount;
        this.numberGenerator = numberGenerator;
        this.forwardChecker = forwardChecker;
    }

    public void runRounds() {
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            cars.runRound(numberGenerator, forwardChecker);
        }
    }
}
