package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.validation.UserInputValidator;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private RacingCar racingCar;

    public RacingCarController() {
        this.racingCarView = new RacingCarView();
    }

    public void start() {
        racingCarView.printStartRacingCar();
        String userInput = askCarNames();
        UserInputValidator.validateUserInput(userInput);

        racingCar = new RacingCar(userInput);

        racingCarView.printAskingNumberOfRetries();
        Integer numberOfRetries = askingNumberOfRetires();

        racingCarView.printResultPerRacing();
        while (numberOfRetries > 0) {
            this.racingCar.moveRandomAllCar();
            numberOfRetries--;
            racingCarView.printCarListMovement(this.racingCar);
        }

        List<Car> winners = this.racingCar.findWinners();
        racingCarView.printFinalMessage(winners);
    }

    public String askCarNames() {
        return Console.readLine();
    }

    public Integer askingNumberOfRetires() {
        String numberOfRetries = Console.readLine();
        UserInputValidator.validateNumberOfRetriesInput(numberOfRetries);
        return Integer.valueOf(numberOfRetries);
    }

}
