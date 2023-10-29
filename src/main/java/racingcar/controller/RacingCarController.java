package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
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
    }

    public String askCarNames() {
        return Console.readLine();
    }

    public List<String> splitInputByComma(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

}
