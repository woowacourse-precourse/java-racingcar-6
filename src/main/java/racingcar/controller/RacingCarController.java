package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfRoundsInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(
            new CarNamesInputValidator(),
            new NumberOfRoundsInputValidator()
    );

    public void run() {
        outputView.printAskingForCarNames();
        List<String> carNames = inputView.askForCarNames();
        RacingCars racingCars = RacingCars.init(carNames);
        for (int i = 0; i < 5; i++) {
            racingCars = racingCars.move();
            for (RacingCar racingCar : racingCars.getRacingCarList()) {
                System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getLocation()));
            }
        }
        outputView.printAskingForNumberOfRounds();
        inputView.askForNumberOfRounds();
        outputView.printResult();
        outputView.printWinners();
    }
}
