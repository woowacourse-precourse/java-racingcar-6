package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InputConstant;
import racingcar.domain.CarNameList;
import racingcar.domain.NumberOfGames;
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

    public CarNameList getCarNameListFromUser() {
        String userInput = readUserInput();
        carNamesInputValidator.validate(userInput);
        String[] carNames = userInput.split(InputConstant.INPUT_CAR_NAMES_DELIMITER);
        return new CarNameList(carNames);
    }

    public NumberOfGames getNumberOfGamesFromUser() {
        String userInput = readUserInput();
        numberOfGamesInputValidator.validate(userInput);
        return new NumberOfGames(Long.parseLong(userInput));
    }

    private String readUserInput() {
        return Console.readLine();
    }
}