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
        String userInput = askCarNames();
        racingCar = new RacingCar(userInput);

        Integer numberOfRetries = askNumberOfRetires();
        startRacingCar(numberOfRetries);

        findWinners();
    }

    private String askCarNames() {
        racingCarView.printStartRacingCar();
        String userInput = Console.readLine();
        UserInputValidator.validateUserInput(userInput);
        return userInput;
    }

    private Integer askNumberOfRetires() {
        racingCarView.printAskingNumberOfRetries();
        String numberOfRetries = Console.readLine();
        UserInputValidator.validateNumberOfRetriesInput(numberOfRetries);
        return Integer.valueOf(numberOfRetries);
    }

    private void startRacingCar(Integer numberOfRetries) {
        racingCarView.printResultPerRacing();
        startAllRetries(numberOfRetries);
    }

    private void startAllRetries(Integer numberOfRetries) {
        while (numberOfRetries > 0) {
            racingCar.moveRandomAllCar();
            numberOfRetries--;
            racingCarView.printCarListMovement(racingCar);
        }
    }

    private void findWinners() {
        List<Car> winners = racingCar.findWinners();
        racingCarView.printFinalMessage(winners);
    }
}
