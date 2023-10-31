package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputConsoleView {

    public String readCarName() {
        String input = Console.readLine();
        validateCarNameInput(input);
        return input;
    }

    private void validateCarNameInput(String input) {
        if(isInputEmpty(input)) {
            throw new IllegalArgumentException("자동차들의 이름을 입력해주세요.");
        }
        else if(isNotSeparateWithComma(input)) {
            throw new IllegalArgumentException("자동차들의 이름은 ','으로 구분해주세요.");
        }
    }

    private boolean isInputEmpty(String input) {
        return (input == null || input.isBlank());
    }

    private boolean isNotSeparateWithComma(String input) {
        return (input.split(",").length == 1);
    }

}
