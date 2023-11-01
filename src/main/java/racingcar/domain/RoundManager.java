package racingcar.domain;

import racingcar.domain.data.Cars;
import racingcar.domain.data.RoundCount;
import racingcar.output.Output;

public class RoundManager {

    private final Cars cars;
    private final RoundCount roundCount;
    private final NumberGenerator numberGenerator;
    private final ForwardChecker forwardChecker;
    private final Output output;

    public RoundManager(final Cars cars, final RoundCount roundCount, final NumberGenerator numberGenerator, final Output output) {
        this.cars = cars;
        this.roundCount = roundCount;
        this.numberGenerator = numberGenerator;
        this.forwardChecker = new ForwardChecker();
        this.output = output;
    }

    public void runRounds() {
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            cars.runRound(numberGenerator, forwardChecker);
            output.print(cars);
            output.printEnter();
        }
    }
}
