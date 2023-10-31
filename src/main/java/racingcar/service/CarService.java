package racingcar.service;

import static racingcar.view.input.Input.bringTrialAmount;

import racingcar.domain.car.Cars;
import racingcar.view.output.Output;
import racingcar.view.output.OutputMessage;

public class CarService {

    public static final String MERGING_STANDARD = ", ";

    private final Cars cars;

    public CarService(Cars cars) {
        this.cars = cars;
    }

    public void progressCarGame() {
        Output.printMessage(OutputMessage.HOW_MANY_TIME);
        int trialAmount = bringTrialAmount();
        Output.printNewLine();
        Output.printMessage(OutputMessage.EXECUTION_RESULT);
        for (int trial = 0; trial < trialAmount; trial++) {
            cars.randomCarMove();
        }
        announceWinner();
    }

    public void announceWinner() {
        String winners = String.join(MERGING_STANDARD, cars.findWinners());
        Output.printMessage(OutputMessage.FINAL_WINNER, winners);
    }


}
