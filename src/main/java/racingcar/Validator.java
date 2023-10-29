package racingcar;

public class Validator {

    private static final String INPUT_WRONG_VALUE = "잘못된 입력값입니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNameArray(String[] carNameArray) throws IllegalArgumentException {
        for (String s : carNameArray) {
            if (s.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(INPUT_WRONG_VALUE);
            }
            if (s.isEmpty()) {
                throw new IllegalArgumentException(INPUT_WRONG_VALUE);
            }
            if (s.equals("null")) {
                throw new IllegalArgumentException(INPUT_WRONG_VALUE);
            }
        }
    }

}
