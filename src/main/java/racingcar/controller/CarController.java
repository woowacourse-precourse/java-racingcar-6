package racingcar.controller;

import static racingcar.view.input.Input.inputTrialAmount;
import static racingcar.view.output.Output.printMessage;
import static racingcar.view.output.Output.printNewLine;
import static racingcar.view.output.Output.printStatusMessage;

import java.util.Map;
import racingcar.domain.car.Cars;
import racingcar.util.RandomGenerator;
import racingcar.view.output.OutputMessage;

public class CarController {
    public static final String MERGING_STANDARD = ", ";
    private int trialAmount;
    private final Cars cars;
    private final RandomGenerator randomGenerator;

    public CarController(Cars cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public void run() {
        startCarGame();
        progressCarGame();
        announceWinner();
    }

    public void startCarGame() {
        printMessage(OutputMessage.HOW_MANY_TIME);
        trialAmount = inputTrialAmount();
        printNewLine();
    }

    public void progressCarGame() {
        printMessage(OutputMessage.EXECUTION_RESULT);

        for (int trial = 0; trial < trialAmount; trial++) {
            cars.randomMove(randomGenerator);
            Map<String, String> carStatus = cars.generateStatus();

            printStatusMessage(OutputMessage.PROGRESS_RESULT, carStatus);
            printNewLine();
        }
    }

    private void announceWinner() {
        String winners = String.join(MERGING_STANDARD, cars.findWinners());
        printMessage(OutputMessage.FINAL_WINNER, winners);
    }


}
