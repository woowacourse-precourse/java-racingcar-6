package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputView {

    private final InputValidator carNamesInputValidator;
    private final InputValidator numberOfRoundsInputValidator;

    public InputView(
            InputValidator carNamesInputValidator,
            InputValidator numberOfRoundsInputValidator
    ) {
        this.carNamesInputValidator = carNamesInputValidator;
        this.numberOfRoundsInputValidator = numberOfRoundsInputValidator;
    }

    public List<String> askForCarNames() {
        String userInput = Console.readLine();
        carNamesInputValidator.validate(userInput);
        return List.of(userInput.split(","));
    }

    public int askForNumberOfRounds() {
        String userInput = Console.readLine();
        numberOfRoundsInputValidator.validate(userInput);
        return Integer.parseInt(userInput);
    }
}
