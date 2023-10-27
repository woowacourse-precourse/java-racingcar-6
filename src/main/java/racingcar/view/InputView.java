package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validator.BasicValidator;

public class InputView {

    private final BasicValidator carNamesInputValidator;
    private final BasicValidator numberOfRoundsInputValidator;

    public InputView(
            BasicValidator carNamesInputValidator,
            BasicValidator numberOfRoundsInputValidator
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
