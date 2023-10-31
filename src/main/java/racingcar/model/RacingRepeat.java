package racingcar.model;

public class RacingRepeat {
    private int repeat;

    private final String ERROR_MESSAGE = "[Error]: 잘못된 시도횟수 입력";
    private final int MINIMUM_REPEAT_RANGE = 1;

    public RacingRepeat(String repeatString) {
        int repeat = parseInt(repeatString);
        validateIntRange(repeat);
        this.repeat = repeat;
    }

    private int parseInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validateIntRange(int repeat) {
        if (repeat < MINIMUM_REPEAT_RANGE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public boolean decrease() {
        if (repeat >= MINIMUM_REPEAT_RANGE) {
            repeat--;
            return true;
        }
        return false;
    }
}
