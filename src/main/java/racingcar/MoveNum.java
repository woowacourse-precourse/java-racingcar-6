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

    private void isValidMoveNum(String moveNumString) {
        validateMoveNumBlank(moveNumString);
        validateMoveNumNumeric(moveNumString);
        validateMoveNumRangeOver(moveNumString);
        validateMoveNumRangeUnder(moveNumString);
    }
    private void validateMoveNumBlank(String moveNumString) throws IllegalArgumentException {
        if (moveNumString == null || moveNumString.isBlank()) {
            throw new IllegalArgumentException("Error : 시도할 회수에 값이 들어오지 않았습니다");
        }
    }

    private void validateMoveNumNumeric(String moveNumString) throws IllegalArgumentException {
        if (!Util.isNumeric(moveNumString)) {
            throw new IllegalArgumentException("Error : 시도할 회수에 0 또는 양수가 아닌 값이 포함되었습니다");
        }
    }

    private void validateMoveNumRangeOver(String moveNumString) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(moveNumString) > MAX_MOVE_NUM) {
                throw new IllegalArgumentException("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Error : 시도할 회수가 너무 많습니다 최대회수 " + MAX_MOVE_NUM);
        }
    }

    private void validateMoveNumRangeUnder(String moveNumString) throws IllegalArgumentException {
        if (Integer.parseInt(moveNumString) <= 0) {
            throw new IllegalArgumentException("Error : 최소 1이상의 값을 입력해주세요");
        }
    }
}
