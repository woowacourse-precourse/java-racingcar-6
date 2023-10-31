package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final int MINIMUM_TRIAL = 1;

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
            throw new IllegalArgumentException("시도 횟수에 문자가 포함될 수 없습니다");
        }
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void validateCarNameIsNotBlank(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
            }
        }
    }

    private void validateTrialsNumber(int userInput) {
        if (userInput < MINIMUM_TRIAL) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다");
        }
    }
}
