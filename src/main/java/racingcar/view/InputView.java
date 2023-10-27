package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.CarNamesInputValidator;

public class InputView {

    private final CarNamesInputValidator carNamesInputValidator;

    public InputView(CarNamesInputValidator carNamesInputValidator) {
        this.carNamesInputValidator = carNamesInputValidator;
    }

    public List<String> askForCarNames() {
        String userInput = Console.readLine();
        carNamesInputValidator.validate(userInput);
        return List.of(userInput.split(","));
    }

    public int askForNumberOfRounds() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
