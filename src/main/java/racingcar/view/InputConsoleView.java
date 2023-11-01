package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputConsoleView {

    public String readCarName() {
        String input = Console.readLine();
        validateCarNameInput(input);
        return input;
    }

    public String readNumberOfTrial() {
        String input = Console.readLine();
        validateNumberOfTrial(input);
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

    private void validateNumberOfTrial(String input) {
        if(isInputEmpty(input)) {
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요.");
        }
        else if(isNotNumber(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        else if (isNotBiggerThanZero(input)) {
            throw new IllegalArgumentException("시도할 횟수는 1보다 커야됩니다.");
        }
    }

    private boolean isInputEmpty(String input) {
        return (input == null || input.isBlank());
    }

    private boolean isNotSeparateWithComma(String input) {
        return (input.split(",").length == 1);
    }

    private boolean isNotNumber(String input) {
        return !Pattern.matches("^[0-9]+$",input);
    }

    private boolean isNotBiggerThanZero(String input) {
        return (Integer.parseInt(input) <= 0);
    }
}
