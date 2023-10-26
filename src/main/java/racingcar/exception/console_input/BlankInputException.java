package racingcar.exception.console_input;

public class BlankInputException extends IllegalArgumentException {

    public BlankInputException() {
        super("입력 값이 비어있습니다. 다시 입력해주세요.");
    }
}
