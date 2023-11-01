package racingcar.userinput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    private static final String CAR_NAME_INPUT_DELIMITER = ",";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";

    private final UserInputValidator inputValidator;

    public UserInput() {
        this.inputValidator = new UserInputValidator();
    }

    public List<String> inputCarNames() {
        String userInput = Console.readLine();
        String[] carNames = userInput.split(CAR_NAME_INPUT_DELIMITER);

        List<String> validCarNames = new ArrayList<>();
        for (String carName : carNames) {
            inputValidator.carName(validCarNames, carName);
            validCarNames.add(carName);
        }
        return validCarNames;
    }

    public int inputGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String userInput = Console.readLine();
        inputValidator.gameCount(userInput);
        return Integer.parseInt(userInput);
    }
}
