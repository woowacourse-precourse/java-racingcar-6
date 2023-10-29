package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        String userInput = getUserInput();
        List<String> userInputList = Arrays.asList(userInput.split(","));
        validateCarNameIsNotBlank(userInputList);
        return userInputList;
    }

    public int getTrials() {
        String userInput = getUserInput();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다");
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
}
