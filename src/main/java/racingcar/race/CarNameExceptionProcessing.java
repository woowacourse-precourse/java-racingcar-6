package racingcar.race;

public class CarNameExceptionProcessing {

    private static final String NAME_WARNING = "자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 1자 이상, 5자 이하만 가능합니다.";

    public static void checkName(String[] carNames) {

        checkComma(carNames);
        for (String carName : carNames) {
            checkLength(carName);
            checkEmpty(carName);
            checkEquals(carName);
        }

    }

    public static void checkComma(String[] carName) {

        try {
            if (carName.length == 0) {
                throw new IllegalArgumentException(NAME_WARNING);
            }
        } catch (IllegalStateException ignored) {

        }

    }

    public static void checkLength(String carName) {

        try {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(NAME_WARNING);
            }
        } catch (IllegalStateException ignored) {

        }

    }

    public static void checkEmpty(String carName) {

        try {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(NAME_WARNING);
            }
        } catch (IllegalStateException ignored) {

        }

    }

    public static void checkEquals(String carName) {

        try {
            if (" ".equals(carName)) {
                throw new IllegalArgumentException(NAME_WARNING);
            }
        } catch (IllegalStateException ignored) {

        }
    }

}
