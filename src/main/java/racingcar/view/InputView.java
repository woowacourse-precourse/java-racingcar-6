package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.validation.InputValidator.InputValidator;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";
    private final static String REQUEST_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    public void printRequestCarName() {
        System.out.println(REQUEST_CAR_NAME_MESSAGE);
    }

    public void printRequestRound() {
        System.out.println(REQUEST_ROUND_MESSAGE);
    }

    public List<String> getUserInputCarNames() {
        String userInput = Console.readLine();
        InputValidator.validateUserInput(userInput);
        List<String> userInputList = Arrays.asList(userInput.split(SPLIT_DELIMITER));
        InputValidator.validateUserInputList(userInputList);
        return userInputList;
    }

    public int getUserInputRacingRound() {
        String inputRacingRound = Console.readLine();
        return InputValidator.validateRacingRound(inputRacingRound);
    }

}
