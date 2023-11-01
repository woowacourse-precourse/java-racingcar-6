package racingcar.util;

public class Validator {
    static final String CAR_NAME_REGEX = "[a-zA-Z]{1,5}";
    static final String MOVE_CNT_REGEX = "[0-9]+";

    public static boolean validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!carName.matches(CAR_NAME_REGEX)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateMoveCnt(String inputMoveCnt) {
        if (!inputMoveCnt.matches(MOVE_CNT_REGEX)) {
            return false;
        }
        return true;
    }
}
