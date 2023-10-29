package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;
import racingcar.validator.CarNamesInputValidator;

public class InputView {

    private final CarNamesInputValidator carNamesInputValidator;

    public InputView(CarNamesInputValidator carNamesInputValidator) {
        this.carNamesInputValidator = carNamesInputValidator;
    }

    public List<String> getCarNamesFromUser() {
        String userInput = Console.readLine();
        carNamesInputValidator.validate(userInput);
        String[] carNames = userInput.split(Constant.INPUT_CAR_NAMES_DELIMITER);
        return Arrays.asList(carNames);
    }

    public Integer getNumberOfGamesFromUser() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
