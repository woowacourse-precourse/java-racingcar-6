package racingcar.service;

import static racingcar.view.input.Input.inputTrialAmount;
import static racingcar.view.output.Output.printMessage;
import static racingcar.view.output.Output.printNewLine;

import racingcar.domain.car.Cars;
import racingcar.view.output.OutputMessage;

public class CarService {

    public static final String MERGING_STANDARD = ", ";

    private final Cars cars;

    public CarService(Cars cars) {
        this.cars = cars;
    }

    public void progressCarGame() {
        printMessage(OutputMessage.HOW_MANY_TIME);
        int trialAmount = inputTrialAmount();
        printNewLine();
        printMessage(OutputMessage.EXECUTION_RESULT);
        for (int trial = 0; trial < trialAmount; trial++) {
            cars.randomCarMove();
            printNewLine();
        }
        announceWinner();
    }

    private void announceWinner() {
        String winners = String.join(MERGING_STANDARD, cars.findWinners());
        printMessage(OutputMessage.FINAL_WINNER, winners);
    }


}
