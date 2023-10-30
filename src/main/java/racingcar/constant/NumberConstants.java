package racingcar.constant;

import static racingcar.constant.MessageConstants.NONE_INSTANTIABLE_CLASS;

public final class NumberConstants {

    private NumberConstants() {
        throw new AssertionError(NONE_INSTANTIABLE_CLASS);
    }

    public static final int ZERO = 0;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    public static final int MIN_MOVE_CONDITION = 0;
    public static final int MAX_MOVE_CONDITION = 9;
    public static final int MOVE_CONDITION = 4;

}
