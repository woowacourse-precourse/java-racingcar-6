package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.validation.CarValidator;
import racingcar.validation.UserInputValidator;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController() {
        this.racingCarView = new RacingCarView();
    }

    public void start() {
        racingCarView.printStartRacingCar();
        String userInput = askCarNames();
        UserInputValidator.validateUserInput(userInput);

        List<String> carNames = splitInputByComma(userInput);
        CarValidator.validateCarNameList(carNames);

        List<Car> cars = carNames.stream().map(Car::new).toList();

        racingCarView.printAskingNumberOfRetries();
        Integer numberOfRetries = askingNumberOfRetires();

        RacingCar racingCar = new RacingCar(cars);

        racingCarView.printResultPerRacing();
        while (numberOfRetries > 0) {
            racingCar.moveRandomAllCar();
            numberOfRetries--;
            racingCarView.printCarListMovement(racingCar);
        }

        List<Car> winners = racingCar.findWinners();
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

    private List<String> splitInputByComma(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

}
