package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;

public class InputView {

    private final CarNamesInputValidator carNamesInputValidator;
    private final NumberOfGamesInputValidator numberOfGamesInputValidator;

    public InputView(CarNamesInputValidator carNamesInputValidator,
                     NumberOfGamesInputValidator numberOfGamesInputValidator) {
        this.carNamesInputValidator = carNamesInputValidator;
        this.numberOfGamesInputValidator = numberOfGamesInputValidator;
    }

    public List<String> getCarNamesFromUser() {
        String userInput = Console.readLine();
        carNamesInputValidator.validate(userInput);
        String[] carNames = userInput.split(Constant.INPUT_CAR_NAMES_DELIMITER);
        return Arrays.asList(carNames);
    }

    public Long getNumberOfGamesFromUser() {
        String userInput = Console.readLine();
        numberOfGamesInputValidator.validate(userInput);
        return Long.parseLong(userInput);
    }
}
