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

        Integer repeatCount = askRepeatCount();
        startRacing(repeatCount);

        findWinners();
    }

    String askCarNames() {
        racingCarView.printStartMessage();
        String userInput = Console.readLine();
        UserInputValidator.validateUserInput(userInput);
        return userInput;
    }

    Integer askRepeatCount() {
        racingCarView.printAskingRepeatCountMessage();
        String repeatCount = Console.readLine();
        UserInputValidator.validateNumberOfRetriesInput(repeatCount);
        return Integer.valueOf(repeatCount);
    }

    private void startRacing(Integer repeatCount) {
        racingCarView.printResultMessage();
        raceAll(repeatCount);
    }

    private void raceAll(Integer repeatCount) {
        while (repeatCount > 0) {
            racingCar.moveRandomAllCar();
            repeatCount--;
            racingCarView.printAllTravelDistance(racingCar);
        }
    }

    private void findWinners() {
        List<Car> winners = racingCar.findWinners();
        racingCarView.printWinners(winners);
    }
}
