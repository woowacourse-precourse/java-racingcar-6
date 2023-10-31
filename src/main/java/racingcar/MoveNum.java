package racingcar;

public class MoveNum {
    final static int MAX_MOVE_NUM = 10000;
    private final int value;

    MoveNum(String moveNumString) {
        isValidMoveNum(moveNumString);
        value = Integer.parseInt(moveNumString);
    }

    boolean isInRange(int currentNum) {
        return (value > currentNum);
    }

    void isValidMoveNum(String moveNumString) throws IllegalArgumentException {
        if (moveNumString == null || moveNumString.isBlank()) {
            throw new IllegalArgumentException("Error : 시도할 회수에 값이 들어오지 않았습니다");
        }
        if (!Util.isNumeric(moveNumString)) {
            throw new IllegalArgumentException("Error : 시도할 회수에 0 또는 양수가 아닌 값이 포함되었습니다");
        }
        try {
            if (Integer.parseInt(moveNumString) > MAX_MOVE_NUM) {
                throw new IllegalArgumentException("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
        }
    }
}
