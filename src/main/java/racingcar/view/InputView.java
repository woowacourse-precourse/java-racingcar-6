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
