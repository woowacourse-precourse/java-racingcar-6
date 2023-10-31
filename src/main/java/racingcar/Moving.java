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
                throw new IllegalArgumentException();
                }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


}
