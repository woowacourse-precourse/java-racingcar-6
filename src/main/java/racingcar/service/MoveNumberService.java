package racingcar.service;

import racingcar.domain.InputMoveNumber;

public class MoveNumberService {
    private final static String exceptionMessage = "숫자만 입력할 수 있습니다.";
    private int moveNumber;

    public void input() {
        InputMoveNumber inputMoveNumber = new InputMoveNumber();
        String input = inputMoveNumber.getInput();
        if (checkException(input)) {
            this.moveNumber = Integer.valueOf(input);
        }
    }

    private boolean checkException(String input) {
        if (input.matches("^[0-9]*$")) return true;
        throw new IllegalArgumentException(exceptionMessage);
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}
