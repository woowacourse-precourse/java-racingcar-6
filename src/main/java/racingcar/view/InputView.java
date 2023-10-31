package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int TRIALS_LOWER_LIMIT = 1;
    private static final String TRIALS_UNDER_LOWER_LIMIT_ERROR_MESSAGE = "시도 횟수는 양의 정수여야 합니다";
    private static final String TRIALS_CHARACTER_ERROR_MESSAGE = "시도 횟수에 문자가 포함될 수 없습니다";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "자동차 이름은 공백일 수 없습니다";

    public List<String> getCarNames() {
        String userInput = getUserInput();
        List<String> userInputList = Arrays.asList(userInput.split(","));
        validateCarNameIsNotBlank(userInputList);
        return userInputList;
    }

    public int getTrials() {
        String userInput = getUserInput();
        try {
            int parsedUserInput = Integer.parseInt(userInput);
            validateTrialsNumber(parsedUserInput);
            return parsedUserInput;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TRIALS_CHARACTER_ERROR_MESSAGE);
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void validateCarNameIsNotBlank(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
            }
        }
    }

    private void validateTrialsNumber(int userInput) {
        if (userInput < TRIALS_LOWER_LIMIT) {
            throw new IllegalArgumentException(TRIALS_UNDER_LOWER_LIMIT_ERROR_MESSAGE);
        }
    }
}
