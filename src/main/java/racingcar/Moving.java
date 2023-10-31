package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Moving {
    public int inputMovingNumber() {
        String rawMoveNumber = Console.readLine();
        checkMovingNumber(rawMoveNumber);
        return Integer.parseInt(rawMoveNumber);
    }

    private void checkMovingNumber(String rawMoveNumber) {

        try {
            if (Integer.parseInt(rawMoveNumber)<=0) {
                throw new IllegalArgumentException("1이상의 수를 입력해주세요");
                }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }


}
