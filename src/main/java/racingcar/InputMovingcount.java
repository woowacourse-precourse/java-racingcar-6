package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputMovingcount {
    public int inputMovingCount() {
        String rawMoveNumber = Console.readLine();

        return convertNumber(rawMoveNumber);
    }

    private int convertNumber(String rawMoveNumber) {
        try {
            if (Integer.parseInt(rawMoveNumber)<=0) {
                throw new IllegalArgumentException();
                }
            return Integer.parseInt(rawMoveNumber);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
